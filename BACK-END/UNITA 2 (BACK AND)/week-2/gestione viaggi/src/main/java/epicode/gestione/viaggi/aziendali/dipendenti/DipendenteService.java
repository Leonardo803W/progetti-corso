package epicode.gestione.viaggi.aziendali.dipendenti;

import epicode.gestione.viaggi.aziendali.general_responses.CreateResponse;
import epicode.gestione.viaggi.aziendali.mail.EmailService;
import jakarta.mail.MessagingException;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;

//Service identifica una classe come un componente di servizio. I servizi sono responsabili dell'esecuzione di operazioni specifiche all'interno di un'applicazione, Spring la riconosce come un bean e la gestisce per l'iniezione di dipendenze
//indica che una classe o un metodo deve essere validato prima dell'esecuzione. La validazione si basa sulle annotazioni di validazione come @NotBlank utilizzata nella classe DipendenteRequest....
//....fondamentale per garantire la correttezza dei dati in ingresso. Se una classe o un metodo è annotato con @Validated, Spring controllerà automaticamente se i dati soddisfano i vincoli di validazione. Se i dati non sono validi, verrà sollevata un'eccezione.
//RequiredArgsConstructor genera automaticamente un costruttore che inizializza i campi finali della classe. In questo caso, inizializza aziendaRepository e faker

@Service
@RequiredArgsConstructor
@Validated
public class DipendenteService {

    //final poiche le classi non devono essere cambiate in questa classe, inoltre la classe repository serve per avere i campi della classe Dipendente mentre faker per avere dati fitizzi riguardanti l'area geografica specificata nella classe

    private final DipendenteRepository dipendenteRepository;
    private final EmailService emailService;

    //Value tramite questa annotazione prendo i valori che stanno nelle properties

    @Value("${messages.new.dipendente.subject}")
    private String newDipendenteSubject;

    @Value("${messages.new.dipendente.body}")
    private String newDipendenteBody;

    public List<DipendenteResponse> findAll() {

        List<DipendenteResponse> response =  dipendenteResponseListFromEntityList(dipendenteRepository.findAll());
        return response;
    }

    public Dipendente modify(Long id, DipendenteRequest request) {

        Dipendente dipendente = findById(id);
        BeanUtils.copyProperties(request, dipendente);
        dipendenteRepository.save(dipendente);
        return dipendente;
    }

    //metodo per inserire un dipendente
    //invio una email di notifica per inserimento dipendente
    public CreateResponse save(@Valid DipendenteRequest request)   {

        if(dipendenteRepository.existsByUsername(request.getUsername())){
            throw new EntityExistsException("Dipendente già esistente");
        }

        if(dipendenteRepository.existsByEmail(request.getEmail())){
            throw new EntityExistsException("Dipendente già esistente");
        }

        Dipendente dipendente = dipendenteFromRequest(request);

        dipendenteRepository.save(dipendente);
        CreateResponse response = new CreateResponse();
        BeanUtils.copyProperties(dipendente, response);

        try {
            emailService.sendEmail(
                    dipendente.getEmail(),newDipendenteSubject, "<h1>"+newDipendenteBody+"</h1><img src='https://res.cloudinary.com/dmc1dmdyo/image/upload/v1739439825/FS0824/paris.jpg.jpg'>"
                            +dipendente.getEmail()) ;
        } catch (Exception e) {

            System.out.println("Errore invio email");
        }

        return response;

    }

    public Dipendente findById(Long id) {

        if(!dipendenteRepository.existsById(id))
        {
            throw new EntityNotFoundException("Dipendente non trovato");
        }
        return dipendenteRepository.findById(id).get();
    }

    //@Transactional viene utilizzata per indicare che un metodo o una classe deve essere eseguito all'interno di una transazione.
    //Questo significa che tutte le operazioni di database eseguite all'interno di quel contesto saranno trattate come un'unica unità di lavoro. Se una di queste operazioni fallisce, tutte le altre verranno annullate, garantendo così l'integrità dei dati.

    @Transactional
    public DipendenteDettaglioResponse findDipendenteResponseById(Long id){

        if(!dipendenteRepository.existsById(id)){
            throw new EntityNotFoundException("Dipendente non trovato");
        }

        Dipendente dipendente = dipendenteRepository.findById(id).get();

        DipendenteDettaglioResponse response = new DipendenteDettaglioResponse();
        BeanUtils.copyProperties(dipendente, response);

        return response;

    }

    public void delete(Long id) {

        Dipendente dipendente = findById(id);
        dipendenteRepository.deleteById(id);
    }


    public DipendenteResponse dipendenteResponseFromEntity(Dipendente dipendente){

        DipendenteResponse response = new DipendenteResponse();
        BeanUtils.copyProperties(dipendente, response);
        return response;
    }

    public List<DipendenteResponse> dipendenteResponseListFromEntityList(List<Dipendente> dipendenti){

        return dipendenti.stream().map(this::dipendenteResponseFromEntity).toList();
    }

    public Dipendente dipendenteFromRequest(DipendenteRequest request){

        Dipendente dipendente = new Dipendente();
        BeanUtils.copyProperties(request, dipendente);
        return dipendente;
    }
}

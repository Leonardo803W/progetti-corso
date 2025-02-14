package epicode.gestione.viaggi.aziendali.dipendenti;

import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//component specifica che tale classe la gestira automaticamente e soltanto il fremwork, ovvero spring
//RequiredArgsConstructor genera automaticamente un costruttore che inizializza i campi finali della classe. In questo caso, inizializza aziendaRepository e faker
//Questa interfaccia indica che la classe verrà eseguita quando l'applicazione Spring viene avviata. Il metodo run() verrà chiamato automaticamente

@Component
@RequiredArgsConstructor
public class DipendenteRunner implements CommandLineRunner {

    //final poiche le classi non devono essere cambiate in questa classe, inoltre la classe repository serve per avere i campi della classe Dipendente mentre faker per avere dati fitizzi riguardanti l'area geografica specificata nella classe

    private final DipendenteRepository dipendenteRepository;
    private final Faker faker;

    //in questo modo non solo gestisco eventuiali errori ma genero in automatico tuti i dipendenti che voglio

    @Override
    public void run(String... args) throws Exception {


        for(int i = 0; i < 15; i++){
            Dipendente dipendente = new Dipendente();
            dipendente.setUsername(faker.name().username());
            dipendente.setCognome(faker.name().lastName());
            dipendente.setNome(faker.name().firstName());
            dipendente.setEmail(faker.address().fullAddress());
            dipendenteRepository.save(dipendente);

        }

    }
}

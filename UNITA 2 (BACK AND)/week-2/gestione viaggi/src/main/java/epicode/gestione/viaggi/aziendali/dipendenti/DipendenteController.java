package epicode.gestione.viaggi.aziendali.dipendenti;

import epicode.gestione.viaggi.aziendali.general_responses.CreateResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//RestController specifico che questa classe sia un rest ovvero responsabile della gestione delle richieste HTTP e della restituzione di risposte in formato JSON.
//RequestMapping specifico il percorso base per le richieste HTTP che saranno gestite da questa classe
//RequiredArgsConstructor genera automaticamente un costruttore che inizializza i campi finali della classe. In questo caso, inizializza aziendaRepository e faker

@RestController
@RequestMapping("/api/dipendenti")
@RequiredArgsConstructor
public class DipendenteController {

    //final poiche le classi non devono essere cambiate in questa classe, inoltre la classe repository serve per avere i campi della classe Dipendente mentre faker per avere dati fitizzi riguardanti l'area geografica specificata nella classe

    private final DipendenteService dipendenteService;

    //tutti i metodi avranno alla base dell'url questo: http://localhost:8080/api/dipendenti
    //tutte le annotazione di questa classe prima di Mapping specificano il metodo che verra utilizzato
    //ResponseStatus con questa annotazione posso personalizzare i messaggi di risposta delle api, anziche avere i numeri standard


    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public List<DipendenteResponse> findAll() {

        return dipendenteService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public DipendenteDettaglioResponse findById(@PathVariable Long id) {

        return dipendenteService.findDipendenteResponseById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateResponse save(@RequestBody DipendenteRequest request) {

        return dipendenteService.save(request);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Dipendente modify(@PathVariable Long id, @RequestBody DipendenteRequest request) {

        return dipendenteService.modify(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {

        dipendenteService.delete(id);
    }
}
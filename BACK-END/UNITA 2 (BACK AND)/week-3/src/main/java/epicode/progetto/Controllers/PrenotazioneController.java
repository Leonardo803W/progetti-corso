package epicode.progetto.Controllers;

import epicode.progetto.prenotazioni.Prenotazione;
import epicode.progetto.services.PrenotazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//RestController specifico che questa classe sia un rest ovvero responsabile della gestione delle richieste HTTP e della restituzione di risposte in formato JSON.
//RequestMapping specifico il percorso base per le richieste HTTP che saranno gestite da questa classe

@RestController
@RequestMapping("/prenotazioni")
public class PrenotazioneController {

    @Autowired
    private PrenotazioneService prenotazioneService;

    //tutti i metodi avranno alla base dell'url questo: http://localhost:8080/api/prenotazioni
    //tutte le annotazione di questa classe prima di Mapping specificano il metodo che verra utilizzato
    //ResponseStatus con questa annotazione posso personalizzare i messaggi di risposta delle api, anziche avere i numeri standard

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Prenotazione> prenotaEvento(@RequestBody Prenotazione prenotazione) {

        Prenotazione createdPrenotazione = prenotazioneService.prenotaEvento(prenotazione);
        return ResponseEntity.ok(createdPrenotazione);
    }
}
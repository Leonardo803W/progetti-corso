package epicode.progetto.Controllers;

import epicode.progetto.eventi.Evento;
import epicode.progetto.services.EventoService;
import epicode.progetto.utenti.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

// RestController specifico che questa classe sia un rest ovvero responsabile della gestione delle richieste HTTP e della restituzione di risposte in formato JSON.
// RequestMapping specifico il percorso base per le richieste HTTP che saranno gestite da questa classe
@RestController
@RequestMapping("/eventi")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    // tutti i metodi avranno alla base dell'url questo: http://localhost:8080/api/eventi
    // tutte le annotazione di questa classe prima di Mapping specificano il metodo che verrà utilizzato
    // ResponseStatus con questa annotazione posso personalizzare i messaggi di risposta delle api, anziché avere i numeri standard

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Evento> creaEvento(@RequestBody Evento evento, @RequestParam Long organizzatoreId) {

        // Recupero l'utente dal database usando l'ID (assicurati di implementare il recupero corretto)
        Utente organizzatore = new Utente(); // Questo dovrebbe essere recuperato dal servizio Utente

        // Associo l'organizzatore all'evento
        evento.setOrganizzatore(organizzatore);
        Evento createdEvento = eventoService.creaEvento(evento, organizzatore);

        return ResponseEntity.ok(createdEvento);
    }

    @PutMapping("/{eventoId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Evento> modificaEvento(@PathVariable Long eventoId, @RequestBody Evento evento) {

        evento.setId(eventoId);
        eventoService.modificaEvento(evento);
        return ResponseEntity.ok(evento);
    }

    @DeleteMapping("/{eventoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> eliminaEvento(@PathVariable Long eventoId) {

        eventoService.eliminaEvento(eventoId);
        return ResponseEntity.noContent().build();
    }
}
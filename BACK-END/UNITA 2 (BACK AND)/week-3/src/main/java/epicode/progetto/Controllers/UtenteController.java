package epicode.progetto.Controllers;

import epicode.progetto.utenti.Utente;
import epicode.progetto.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//RestController specifico che questa classe sia un rest ovvero responsabile della gestione delle richieste HTTP e della restituzione di risposte in formato JSON.
//RequestMapping specifico il percorso base per le richieste HTTP che saranno gestite da questa classe

@RestController
@RequestMapping("/utenti")
public class UtenteController {

    @Autowired
    private UtenteService utenteService;

    //tutti i metodi avranno alla base dell'url questo: http://localhost:8080/api/utenti
    //tutte le annotazione di questa classe prima di Mapping specificano il metodo che verra utilizzato
    //ResponseStatus con questa annotazione posso personalizzare i messaggi di risposta delle api, anziche avere i numeri standard

    @PostMapping("/registrati")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Utente> registrati(@RequestBody Utente utente) {

        Utente createdUtente = utenteService.registrati(utente);
        return ResponseEntity.ok(createdUtente);
    }
}
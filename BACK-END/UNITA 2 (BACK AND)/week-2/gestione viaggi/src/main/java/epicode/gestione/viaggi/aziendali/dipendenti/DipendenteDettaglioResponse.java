package epicode.gestione.viaggi.aziendali.dipendenti;

//tale classe posso utilizzarla per personarizzare la risposta che ricevera il client in formato json

import epicode.gestione.viaggi.aziendali.viaggi.Viaggio;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//utilizzo le annotqazione table per la tabella e NoArgsConstructor poiche il databese richiede un costruttore senza parametri
//data e AllArgsConstructor per avere tutti i metodi e un costruttore con parametri senza scriverli

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DipendenteDettaglioResponse {

    private Long id;
    private String username;
    private String email;
    private Viaggio viaggio;
}

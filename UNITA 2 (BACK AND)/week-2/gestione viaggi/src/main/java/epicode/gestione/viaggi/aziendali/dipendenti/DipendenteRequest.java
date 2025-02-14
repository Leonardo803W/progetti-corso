package epicode.gestione.viaggi.aziendali.dipendenti;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

//utilizzo le annotqazione table per la tabella e NoArgsConstructor poiche il databese richiede un costruttore senza parametri
//data e AllArgsConstructor per avere tutti i metodi e un costruttore con parametri senza scriverli

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DipendenteRequest {

    //le annotqazioni NotBlank Indicano che il valore di un campo non può essere null e deve contenere almeno un carattere significativo
    //mentre l'annotazione email verifica se la variabile inserita, ovvero l'email sia valida

    @NotBlank(message = "Il campo username non puo essere vuoto")
    private String username;

    @NotBlank(message = "Il campo username non puo essere vuoto")
    private String nome;

    @NotBlank(message = "Il campo username non puo essere vuoto")
    private String cognome;

    @NotBlank(message = "Il campo username non puo essere vuoto")
    @Email(message = "Email non valida")
    private String email;
}

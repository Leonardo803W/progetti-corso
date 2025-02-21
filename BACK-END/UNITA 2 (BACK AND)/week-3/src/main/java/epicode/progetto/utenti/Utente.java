package epicode.progetto.utenti;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

//utilizzo le annotqazione table per la tabella e NoArgsConstructor poiche il databese richiede un costruttore senza parametri
//data e AllArgsConstructor per avere tutti i metodi e un costruttore con parametri senza scriverli
//entity per far gestire al framwork la classe, in oltre se non specifico il nome facendo: (name = "dipendenti"), il databese non avra problemi a riconoscere quale tabella fa parte l'entita

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Utente {

    //l'id serve per la tabella sul db (databese) avendole creata una primary key
    //invece GenerationType.SEQUENCE serve per non avere problemi in termini di id per eventuali copie identiche

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private StatoRuolo ruolo;

}
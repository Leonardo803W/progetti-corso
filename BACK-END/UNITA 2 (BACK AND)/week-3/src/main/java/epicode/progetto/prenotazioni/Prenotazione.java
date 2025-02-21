package epicode.progetto.prenotazioni;

import epicode.progetto.eventi.Evento;
import epicode.progetto.utenti.Utente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//utilizzo le annotqazione table per la tabella e NoArgsConstructor poiche il databese richiede un costruttore senza parametri
//data e AllArgsConstructor per avere tutti i metodi e un costruttore con parametri senza scriverli
//entity per far gestire al framwork la classe, in oltre se non specifico il nome facendo: (name = "dipendenti"), il databese non avra problemi a riconoscere quale tabella fa parte l'entita

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Prenotazione {

    //l'id serve per la tabella sul db (databese) avendole creata una primary key
    //invece GenerationType.SEQUENCE serve per non avere problemi in termini di id per eventuali copie identiche

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@ManyToOne: Questa annotazione indica che un'istanza di Partecipazione può essere associata a una sola istanza di Evento.
    //In altre parole, molti partecipanti possono essere associati allo stesso evento, ma ogni partecipante è associato a un solo evento.
    //@JoinColumn(name = "evento_id") Questa annotazione specifica come la relazione è implementata nel database

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;
}
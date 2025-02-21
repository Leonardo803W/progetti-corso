package epicode.progetto.repository;

import epicode.progetto.prenotazioni.Prenotazione;
import epicode.progetto.utenti.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

//utilizzo extends anziche implements poiche la seconda mi obbligerebbe di portare tutti i metodi di JpaRepository dentro alla classe,
//invece extends mi permette tramite questa classe di utilizzare tutti i metodi che voglio di JpaRepository e aggiungere metodi personali piu personalizzati
//invece <Tipo, Long> specifico con che tipo di entita dovranno essere legati i metodi e anche con che chiave primaria

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {

    List<Prenotazione> findByUtente(Utente utente);
}
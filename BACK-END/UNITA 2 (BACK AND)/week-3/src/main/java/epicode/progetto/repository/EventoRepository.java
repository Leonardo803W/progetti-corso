package epicode.progetto.repository;

import epicode.progetto.eventi.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

//utilizzo extends anziche implements poiche la seconda mi obbligherebbe di portare tutti i metodi di JpaRepository dentro alla classe,
//invece extends mi permette tramite questa classe di utilizzare tutti i metodi che voglio di JpaRepository e aggiungere metodi personali piu personalizzati
//invece <Tipo, Long> specifico con che tipo di entita dovranno essere legati i metodi e anche con che chiave primaria

public interface EventoRepository extends JpaRepository<Evento, Long> {

    List<Evento> findAllByOrdineByDataAsc();

    // Aggiunta di un metodo per trovare un evento per ID
    Optional<Evento> findById(Long id);

    // Aggiunta di un metodo per eliminare un evento per ID
    void deleteById(Long id);
}
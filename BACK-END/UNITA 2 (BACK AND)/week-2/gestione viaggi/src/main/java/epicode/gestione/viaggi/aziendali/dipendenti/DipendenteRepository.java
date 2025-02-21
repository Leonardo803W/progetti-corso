package epicode.gestione.viaggi.aziendali.dipendenti;

import org.springframework.data.jpa.repository.JpaRepository;

//utilizzo extends anziche implements poiche la seconda mi obbligerebbe di portare tutti i metodi di JpaRepository dentro alla classe,
//invece extends mi permette tramite questa classe di utilizzare tutti i metodi che voglio di JpaRepository e aggiungere metodi personali piu personalizzati
//invece <Dipendente, Long> specifico con che tipo di entita dovranno essere legati i metodi e anche con che chiave primaria

public interface DipendenteRepository extends JpaRepository <Dipendente, Long> {

    //con questi metodi aggiuntivi posso verificare o cercare un singolo dipendente

    public boolean existsByUsername(String username);
    public boolean existsByEmail(String email);
}

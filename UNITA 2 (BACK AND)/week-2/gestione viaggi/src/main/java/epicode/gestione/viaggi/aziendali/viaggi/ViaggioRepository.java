package epicode.gestione.viaggi.aziendali.viaggi;

import epicode.gestione.viaggi.aziendali.dipendenti.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViaggioRepository extends JpaRepository<Viaggio, Long> {

    Viaggio findByDestinazione(String destinazione);
    boolean existsByDestinazione(String destinazione);
}
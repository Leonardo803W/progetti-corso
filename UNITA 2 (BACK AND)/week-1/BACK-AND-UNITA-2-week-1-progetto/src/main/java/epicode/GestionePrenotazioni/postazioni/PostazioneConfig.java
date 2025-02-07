package epicode.GestionePrenotazioni.postazioni;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PostazioneConfig {

    @Bean
    public Postazione postazione() {

        Postazione p = new Postazione();
        p.setCodice("001");
        p.setDescrizione("Edificio immerso nel verde");
        p.setStatoposizione(StatoPosizione.OPENSPACE);
        p.setNumeroMassimoOccupanti(20);
        return p;
    }
}

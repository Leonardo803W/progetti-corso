package epicode.GestionePrenotazioni.prenotazioni;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class PrenotazioneConfig {

    @Bean
    public Prenotazione prenotazione() {

        Prenotazione p = new Prenotazione();
        LocalDateTime data = java.time.LocalDateTime.now();
        p.setData(data);
        return p;
    }
}

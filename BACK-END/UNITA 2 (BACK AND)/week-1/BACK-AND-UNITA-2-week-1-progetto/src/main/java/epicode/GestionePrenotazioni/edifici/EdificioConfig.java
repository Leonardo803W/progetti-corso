package epicode.GestionePrenotazioni.edifici;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EdificioConfig {

    @Bean
    public Edificio edificio() {

        Edificio e = new Edificio();
        e.setCitta("Livorno");
        e.setNome("Assicurazioni Macchine");
        e.setIndirizzo("Via cesano 1");
        return e;
    }
}

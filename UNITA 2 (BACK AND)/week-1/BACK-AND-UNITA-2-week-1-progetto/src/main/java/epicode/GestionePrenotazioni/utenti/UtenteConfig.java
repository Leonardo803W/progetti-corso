package epicode.GestionePrenotazioni.utenti;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UtenteConfig {

    @Bean
    public Utente utente() {

        Utente u = new Utente();
        u.setEmail("mario.rossi@gmail.com");
        u.setUsername("Mario");
        u.setNomeCompleto("Mario Rossi");
        return u;
    }
}

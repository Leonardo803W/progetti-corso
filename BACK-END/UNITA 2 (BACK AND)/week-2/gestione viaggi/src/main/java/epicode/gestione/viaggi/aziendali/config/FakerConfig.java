package epicode.gestione.viaggi.aziendali.config;

import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;

//creo il faker per popolarmi il databese
//configuration contiene informazioni per configurare un ogetto
//bean crea direttamente le istanze per poter ritornare un nuovo ogetto

@Configuration
public class FakerConfig {

    @Bean
    public Faker faker() {

        //tutti i dati fitizzi saranno dati italiani
        return new Faker(Locale.ITALIAN);
    }
}

package epicode.gestione.viaggi.aziendali.config;

import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

//configuration contiene informazioni per configurare un ogetto
//bean crea direttamente le istanze per poter ritornare un nuovo ogetto
//Value tramite questa annotazione prendo i valori che stanno nelle properties

@Configuration
public class CloudinaryConfig {

    @Value("${cloudinary.cloud_name}")
    private String cloudName;
    @Value("${cloudinary.api_key}")
    private String apiKey;
    @Value("${cloudinary.api_secret}")
    private String apiSecret;

    @Bean
    public Cloudinary cloudinary() {

        Map<String, String> config = new HashMap<>();
        config.put("dz4gkzrpj", cloudName);
        config.put("672724298338689", apiKey);
        config.put("3VZLsZ3eygTNEP0VOl-aPTEvDEs",apiSecret);
        return new Cloudinary(config);
    }
}

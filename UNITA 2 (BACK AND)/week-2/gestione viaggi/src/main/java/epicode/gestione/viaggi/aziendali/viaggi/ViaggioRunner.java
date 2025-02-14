package epicode.gestione.viaggi.aziendali.viaggi;

import com.github.javafaker.Faker;
import epicode.gestione.viaggi.aziendali.dipendenti.Dipendente;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.time.ZoneId;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
public class ViaggioRunner implements CommandLineRunner {

    private final ViaggioRepository viaggioRepository;
    private final Faker faker;

    @Override
    public void run(String... args) throws Exception {

        /*
        List<Dipendente> dipendenti = dipendenteRepository.findAll();

        //Verifica se ci sono dipendenti
         if (dipendenti.isEmpty())
         {
             System.out.println("Nessun dipendente trovato nel database.");
             return;
         }
        */

        for (int i = 0; i < 15; i++) {
            Viaggio viaggio = new Viaggio();
            viaggio.setDestinazione(faker.address().city());
            viaggio.setDataViaggio(faker.date().future(10, TimeUnit.DAYS).toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            viaggio.setStatoViaggio(StatoViaggio.COMPLETATO);
            //Dipendente dipendente = dipendenti.get(new Random().nextInt(dipendenti.size()));
            //viaggio.setDipendenteId(dipendente.getId());
            viaggioRepository.save(viaggio);
        }
    }
}
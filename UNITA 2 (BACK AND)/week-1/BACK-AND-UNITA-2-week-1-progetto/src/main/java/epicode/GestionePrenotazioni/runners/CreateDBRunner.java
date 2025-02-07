package epicode.GestionePrenotazioni.runners;

import com.github.javafaker.Faker;
import epicode.GestionePrenotazioni.edifici.Edificio;
import epicode.GestionePrenotazioni.edifici.EdificioRepository;
import epicode.GestionePrenotazioni.postazioni.Postazione;
import epicode.GestionePrenotazioni.prenotazioni.Prenotazione;
import epicode.GestionePrenotazioni.utenti.Utente;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateDBRunner implements CommandLineRunner {

    private final Faker faker;
    private final Edificio edificio;
    private final Postazione postazione;
    private final Prenotazione prenotazione;
    private final Utente utente;

    @Override
    public void run(String... args) throws Exception {

        for (int i = 0; i < 20; i++) {

            Edificio edificio = new Edificio();
            edificio.setNome(faker.name().firstName());
            edificio.setCitta(faker.address().cityName());
            edificio.setIndirizzo(faker.address().city());
        }

        System.out.println(edificio);
    }
}

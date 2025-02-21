package epicode.progetto.services;

import epicode.progetto.prenotazioni.Prenotazione;
import epicode.progetto.repository.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Service identifica una classe come un componente di servizio. I servizi sono responsabili dell'esecuzione di operazioni specifiche all'interno di un'applicazione, Spring la riconosce come un bean e la gestisce per l'iniezione di dipendenze

@Service
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    public Prenotazione prenotaEvento(Prenotazione prenotazione) {

        return prenotazioneRepository.save(prenotazione);
    }
}
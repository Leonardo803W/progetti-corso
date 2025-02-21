package epicode.progetto.services;

import epicode.progetto.repository.UtenteRepository;
import epicode.progetto.utenti.Utente;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Service identifica una classe come un componente di servizio. I servizi sono responsabili dell'esecuzione di operazioni specifiche all'interno di un'applicazione, Spring la riconosce come un bean e la gestisce per l'iniezione di dipendenze

@Service
public class UtenteService {

    @Autowired
    private UtenteRepository utenteRepository;

    public Utente registrati(Utente utente) {

        return utenteRepository.save(utente);
    }
}
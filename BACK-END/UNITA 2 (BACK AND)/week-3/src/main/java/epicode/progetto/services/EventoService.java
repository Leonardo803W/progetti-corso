package epicode.progetto.services;

import epicode.progetto.eventi.Evento;
import epicode.progetto.repository.EventoRepository;
import epicode.progetto.utenti.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

//Service identifica una classe come un componente di servizio. I servizi sono responsabili dell'esecuzione di operazioni specifiche all'interno di un'applicazione, Spring la riconosce come un bean e la gestisce per l'iniezione di dipendenze

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    public Evento creaEvento(Evento evento, Utente organizzatore) {

        evento.setOrganizzatore(organizzatore);
        return eventoRepository.save(evento);
    }

    public Evento modificaEvento(Evento evento) {

        Optional<Evento> existingEvento = eventoRepository.findById(evento.getId());

        return eventoRepository.save(evento);
    }

    public void eliminaEvento(Long eventoId) {

        if (eventoRepository.existsById(eventoId))
        {
            eventoRepository.deleteById(eventoId);
        }
        else
        {
            throw new RuntimeException("Evento non trovato");
        }
    }
}
package epicode.DAO;

import epicode.entities.Utente;

public interface UtenteDAO {

    void save(Utente utente);
    void removeByCode(int code);
}

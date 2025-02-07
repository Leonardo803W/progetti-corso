package epicode.DAO;

import epicode.entities.Catalogo;

import java.time.LocalDate;
import java.util.List;

public interface CatalogoDAO {

    void save(Catalogo catalogo);
    void removeByCode(int code);
    Catalogo findByCode(int code);
    Catalogo findByYear(LocalDate date);
    Catalogo findByAutore(String autore);
    Catalogo findByTitle(String titolo);
}

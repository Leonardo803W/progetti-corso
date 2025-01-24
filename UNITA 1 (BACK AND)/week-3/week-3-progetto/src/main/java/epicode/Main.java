package epicode;

import epicode.DAO.CatalogoDAO;
import epicode.DAO.CtalogoDAOImpl;
import epicode.entities.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        LocalDate today = LocalDate.now();
        LocalDate data1 = LocalDate.of(1212,06,5);

        Catalogo libro1 = new Libri("Lande oscure", LocalDate.of(1982,10,04), 500, "Arzulla", "Fantasy");
        Catalogo libro2 = new Riviste("Meloni al governo", today, 12, Periodicita.MENSILE);
        Catalogo libro3 = new Libri("LOL", data1, 150, "Sigma", "Avventura");
        Utente utente1 = new Utente("Leo", "Riganelli", data1);
        Prestito prestito1 = new Prestito(utente1, libro2, LocalDate.now(), LocalDate.of(2025,02,25), LocalDate.of(2025,03,20));

        CatalogoDAO dao = new CtalogoDAOImpl();

        dao.save(libro1);
        dao.save(libro2);
        dao.save(libro3);

        System.out.println(libro1.getTitolo());
        libro1.setTitolo("bob e l'oscuro");
        System.out.println(libro1.getTitolo());
        System.out.println(utente1.getCognome());
        System.out.println(prestito1.getDataRestituzionePrevista());
    }
}
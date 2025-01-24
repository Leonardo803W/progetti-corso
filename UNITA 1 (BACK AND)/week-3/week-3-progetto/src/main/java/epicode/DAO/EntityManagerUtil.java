package epicode.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerUtil {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneFormazionePU");

    public static EntityManager getEntityManager() {

        return emf.createEntityManager();
    }

    public static void close(){

        emf.close();
    }
}

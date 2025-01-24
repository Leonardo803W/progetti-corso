package epicode.DAO;

import epicode.entities.Utente;
import jakarta.persistence.EntityManager;

public class UtenteDAOImpl implements UtenteDAO{

    @Override
    public void save(Utente utente) {

        EntityManager em = EntityManagerUtil.getEntityManager();

        try {

            em.getTransaction().begin();

            if (utente != null) {
                em.persist(utente);
                System.out.println("Salvataccio effettuato con sucesso");
            } else {
                em.merge(utente);
                System.out.println("Aggiornamento effettuato con sucesso");
            }

            em.getTransaction().commit();

        } catch (Exception e) {

            if(em.getTransaction().isActive())
            {
                em.getTransaction().rollback();
            }

            System.out.println("Attenzione!!!" + e.getMessage());
        }
        finally {
            em.close();
        }
    }

    @Override
    public void removeByCode(int code) {

        EntityManager em = EntityManagerUtil.getEntityManager();

        try {

            em.getTransaction().begin();
            Utente elementoDaRimuovere = em.find(Utente.class, code);

            if (elementoDaRimuovere != null)
            {
                em.remove(elementoDaRimuovere);
                System.out.println("Rimozione effettuato con sucesso");
            }

            em.getTransaction().commit();

        } catch (Exception e) {

            if(em.getTransaction().isActive())
            {
                em.getTransaction().rollback();
            }

            System.out.println("Attenzione!!!" + e.getMessage());
        }
        finally {
            em.close();
        }
    }
}

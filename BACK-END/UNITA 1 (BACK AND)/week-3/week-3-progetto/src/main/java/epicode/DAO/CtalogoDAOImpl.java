package epicode.DAO;

import epicode.entities.Catalogo;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;
import java.util.List;

public class CtalogoDAOImpl implements CatalogoDAO {

    @Override
    public void save(Catalogo catalogo) {

        EntityManager em = EntityManagerUtil.getEntityManager();

        try {

            em.getTransaction().begin();

            if (catalogo != null) {
                em.persist(catalogo);
                System.out.println("Salvataccio effettuato con sucesso");
            } else {
                em.merge(catalogo);
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
            Catalogo elementoDaRimuovere = em.find(Catalogo.class, code);

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

    @Override
    public Catalogo findByCode(int code) {

        EntityManager em = EntityManagerUtil.getEntityManager();

        try {

            em.getTransaction().begin();
            Catalogo elementoDaCercare = em.find(Catalogo.class, code);
            System.out.println("Elemento trovato con sucesso");
            em.getTransaction().commit();
            return elementoDaCercare;

        } catch (Exception e) {

            if(em.getTransaction().isActive())
            {
                em.getTransaction().rollback();
            }

            System.out.println("Attenzione!!!" + e.getMessage());
            return null;
        }
        finally {
            em.close();
        }
    }

    @Override
    public Catalogo findByYear(LocalDate date) {

        EntityManager em = EntityManagerUtil.getEntityManager();

        try {

            em.getTransaction().begin();
            Catalogo elementoDaCercare = em.find(Catalogo.class, date);
            System.out.println("Elemento trovato con sucesso");
            em.getTransaction().commit();
            return elementoDaCercare;

        } catch (Exception e) {

            if(em.getTransaction().isActive())
            {
                em.getTransaction().rollback();
            }

            System.out.println("Attenzione!!!" + e.getMessage());
            return null;
        }
        finally {
            em.close();
        }
    }

    @Override
    public Catalogo findByAutore(String autore) {

        EntityManager em = EntityManagerUtil.getEntityManager();

        try {

            em.getTransaction().begin();
            Catalogo elementoDaCercare = em.find(Catalogo.class, autore);
            System.out.println("Elemento trovato con sucesso");
            em.getTransaction().commit();
            return elementoDaCercare;

        } catch (Exception e) {

            if(em.getTransaction().isActive())
            {
                em.getTransaction().rollback();
            }

            System.out.println("Attenzione!!!" + e.getMessage());
            return null;
        }
        finally {
            em.close();
        }
    }

    @Override
    public Catalogo findByTitle(String titolo) {

        EntityManager em = EntityManagerUtil.getEntityManager();

        try {

            em.getTransaction().begin();
            Catalogo elementoDaCercare = em.find(Catalogo.class, titolo);
            System.out.println("Elemento trovato con sucesso");
            em.getTransaction().commit();
            return elementoDaCercare;

        } catch (Exception e) {

            if(em.getTransaction().isActive())
            {
                em.getTransaction().rollback();
            }

            System.out.println("Attenzione!!!" + e.getMessage());
            return null;
        }
        finally {
            em.close();
        }
    }
}

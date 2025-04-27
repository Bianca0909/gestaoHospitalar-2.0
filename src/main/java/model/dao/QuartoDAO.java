package model.dao;

import java.util.List;
import model.bo.Quarto;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class QuartoDAO implements InterfaceDAO<Quarto> {

    private static QuartoDAO instance;
    protected EntityManager entityManager;

    private QuartoDAO() {
        entityManager = getEntityManager();
    }

    public static QuartoDAO getInstance() {
        if (instance == null) {
            instance = new QuartoDAO();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }

    @Override
    public void create(Quarto objeto) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(objeto);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public List<Quarto> retrieve() {
        List<Quarto> quartos = new ArrayList<>();
        quartos = entityManager.createQuery("Select q From quarto q", Quarto.class).getResultList();
        return quartos;
    }

    @Override
    public Quarto retrieve(int pk) {
        Quarto quarto = entityManager.find(Quarto.class, pk);
        return quarto;
    }

    @Override
    public List<Quarto> retrieve(String parametro, String atributo) {
        List<Quarto> quartos = new ArrayList<>();
        quartos = entityManager.createQuery("Select q From quarto q "
                + " Where " + atributo + " like ( % " + parametro + " % )", Quarto.class).getResultList();
        return quartos;
    }

    @Override
    public void update(Quarto objeto) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(objeto);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Quarto objeto) {
        try {
            Quarto quarto = entityManager.find(Quarto.class, objeto.getId());
            entityManager.getTransaction().begin();
            entityManager.remove(quarto);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
}

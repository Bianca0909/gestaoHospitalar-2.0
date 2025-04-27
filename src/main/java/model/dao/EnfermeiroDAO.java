package model.dao;

import java.util.List;
import model.bo.Enfermeiro;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EnfermeiroDAO implements InterfaceDAO<Enfermeiro> {

    private static EnfermeiroDAO instance;
    protected EntityManager entityManager;

    private EnfermeiroDAO() {
        entityManager = getEntityManager();
    }

    public static EnfermeiroDAO getInstance() {
        if (instance == null) {
            instance = new EnfermeiroDAO();
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
    public void create(Enfermeiro objeto) {
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
    public List<Enfermeiro> retrieve() {
        List<Enfermeiro> enfermeiros = new ArrayList<>();
        enfermeiros = entityManager.createQuery("Select e From enfermeiro e", Enfermeiro.class).getResultList();
        return enfermeiros;
    }

    @Override
    public Enfermeiro retrieve(int pk) {
        Enfermeiro enfermeiro = entityManager.find(Enfermeiro.class, pk);
        return enfermeiro;
    }

    @Override
    public List<Enfermeiro> retrieve(String parametro, String atributo) {
        List<Enfermeiro> enfermeiros = new ArrayList<>();
        enfermeiros = entityManager.createQuery("Select e From enfermeiro e "
                + " Where " + atributo + " like ( % " + parametro + " % )", Enfermeiro.class).getResultList();
        return enfermeiros;
    }

    @Override
    public void update(Enfermeiro objeto) {
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
    public void delete(Enfermeiro objeto) {
        try {
            Enfermeiro enfermeiro = entityManager.find(Enfermeiro.class, objeto.getId());
            entityManager.getTransaction().begin();
            entityManager.remove(enfermeiro);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
}

package model.dao;

import java.util.List;
import model.bo.ConsultaExame;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConsultaExameDAO implements InterfaceDAO<ConsultaExame> {

    private static ConsultaExameDAO instance;
    protected EntityManager entityManager;

    private ConsultaExameDAO() {
        entityManager = getEntityManager();
    }

    public static ConsultaExameDAO getInstance() {
        if (instance == null) {
            instance = new ConsultaExameDAO();
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
    public void create(ConsultaExame objeto) {
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
    public List<ConsultaExame> retrieve() {
        List<ConsultaExame> consultaExames = new ArrayList<>();
        consultaExames = entityManager.createQuery("Select ce From consultaexame ce", ConsultaExame.class).getResultList();
        return consultaExames;
    }

    @Override
    public ConsultaExame retrieve(int pk) {
        ConsultaExame consultaExame = entityManager.find(ConsultaExame.class, pk);
        return consultaExame;
    }

    @Override
    public List<ConsultaExame> retrieve(String parametro, String atributo) {
        List<ConsultaExame> consultaExames = new ArrayList<>();
        consultaExames = entityManager.createQuery("Select ce From consultaexame ce "
                + " Where " + atributo + " like ( % " + parametro + " %  )", ConsultaExame.class).getResultList();
        return consultaExames;
    }

    @Override
    public void update(ConsultaExame objeto) {
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
    public void delete(ConsultaExame objeto) {
        try {
            ConsultaExame consultaExame = entityManager.find(ConsultaExame.class, objeto.getId());
            entityManager.getTransaction().begin();
            entityManager.remove(consultaExame);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
}

package model.dao;

import java.util.List;
import model.bo.Consulta;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConsultaDAO implements InterfaceDAO<Consulta> {

    private static ConsultaDAO instance;
    protected EntityManager entityManager;

    private ConsultaDAO() {
        entityManager = getEntityManager();
    }

    public static ConsultaDAO getInstance() {
        if (instance == null) {
            instance = new ConsultaDAO();
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
    public void create(Consulta objeto) {
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
    public List<Consulta> retrieve() {
        List<Consulta> consultas = new ArrayList<>();
        consultas = entityManager.createQuery("Select c From consulta c", Consulta.class).getResultList();
        return consultas;
    }

    @Override
    public Consulta retrieve(int pk) {
        Consulta consulta = entityManager.find(Consulta.class, pk);
        return consulta;
    }

    @Override
    public List<Consulta> retrieve(String parametro, String atributo) {
        List<Consulta> consultas = new ArrayList<>();
        consultas = entityManager.createQuery("Select c From consulta c "
                + " Where " + atributo + " like ( % " + parametro + " %  )", Consulta.class).getResultList();
        return consultas;
    }

    @Override
    public void update(Consulta objeto) {
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
    public void delete(Consulta objeto) {
        try {
            Consulta consulta = entityManager.find(Consulta.class, objeto.getId());
            entityManager.getTransaction().begin();
            entityManager.remove(consulta);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
}

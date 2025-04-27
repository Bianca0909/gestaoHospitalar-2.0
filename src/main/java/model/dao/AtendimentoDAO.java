package model.dao;

import java.util.List;
import model.bo.Atendimento;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class AtendimentoDAO implements InterfaceDAO<Atendimento> {

    private static AtendimentoDAO instance;
    protected EntityManager entityManager;

    private AtendimentoDAO() {
        entityManager = getEntityManager();
    }

    public static AtendimentoDAO getInstance() {
        if (instance == null) {
            instance = new AtendimentoDAO();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        if (entityManager == null || !entityManager.isOpen()) {
            entityManager = ConnectionFactory.getEntityManager();
        }
        return entityManager;
    }

    @Override
    public void create(Atendimento objeto) {
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
    public List<Atendimento> retrieve() {
        TypedQuery<Atendimento> query = entityManager.createQuery("SELECT a FROM atendimento a", Atendimento.class);
        return query.getResultList();
    }

    @Override
    public Atendimento retrieve(int pk) {
        return entityManager.find(Atendimento.class, pk);
    }

    @Override
    public List<Atendimento> retrieve(String parametro, String atributo) {
        TypedQuery<Atendimento> query = entityManager.createQuery("SELECT a FROM atendimento a WHERE " + atributo + " LIKE :parametro", Atendimento.class)
                .setParameter("parametro", "%" + parametro + "%");
        return query.getResultList();
    }

    @Override
    public void update(Atendimento objeto) {
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
    public void delete(Atendimento objeto) {
        try {
            entityManager.getTransaction().begin();
            objeto = entityManager.find(Atendimento.class, objeto.getId());
            entityManager.remove(objeto);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
}

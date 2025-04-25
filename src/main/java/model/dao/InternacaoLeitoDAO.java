package model.dao;

import java.util.List;
import model.bo.InternacaoLeito;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class InternacaoLeitoDAO implements InterfaceDAO<InternacaoLeito> {

    protected EntityManager entityManager;

    public InternacaoLeitoDAO() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }

    @Override
    public void create(InternacaoLeito objeto) {
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
    public List<InternacaoLeito> retrieve() {
        return entityManager.createQuery("FROM " + InternacaoLeito.class.getName(), InternacaoLeito.class).getResultList();
    }

    @Override
    public InternacaoLeito retrieve(int pk) {
        return entityManager.find(InternacaoLeito.class, pk);
    }

    @Override
    public List<InternacaoLeito> retrieve(String parametro, String atributo) {
        return entityManager.createQuery("FROM " + InternacaoLeito.class.getName() + " WHERE " + atributo + " LIKE :parametro", InternacaoLeito.class)
                .setParameter("parametro", "%" + parametro + "%")
                .getResultList();
    }

    @Override
    public void update(InternacaoLeito objeto) {
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
    public void delete(InternacaoLeito objeto) {
        try {
            entityManager.getTransaction().begin();
            objeto = entityManager.find(InternacaoLeito.class, objeto.getId());
            entityManager.remove(objeto);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
}

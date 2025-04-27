package model.dao;

import java.util.List;
import model.bo.Receita;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ReceitaDAO implements InterfaceDAO<Receita> {

    private static ReceitaDAO instance;
    protected EntityManager entityManager;

    private ReceitaDAO() {
        entityManager = getEntityManager();
    }

    public static ReceitaDAO getInstance() {
        if (instance == null) {
            instance = new ReceitaDAO();
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
    public void create(Receita objeto) {
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
    public List<Receita> retrieve() {
        List<Receita> receitas = new ArrayList<>();
        receitas = entityManager.createQuery("Select r From receita r", Receita.class).getResultList();
        return receitas;
    }

    @Override
    public Receita retrieve(int pk) {
        Receita receita = entityManager.find(Receita.class, pk);
        return receita;
    }

    @Override
    public List<Receita> retrieve(String parametro, String atributo) {
        List<Receita> receitas = new ArrayList<>();
        receitas = entityManager.createQuery("Select r From receita r "
                + " Where " + atributo + " like ( % " + parametro + " % )", Receita.class).getResultList();
        return receitas;
    }

    @Override
    public void update(Receita objeto) {
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
    public void delete(Receita objeto) {
        try {
            Receita receita = entityManager.find(Receita.class, objeto.getId());
            entityManager.getTransaction().begin();
            entityManager.remove(receita);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
}

package model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import model.bo.Atendimento;

public class AtendimentoDAO implements InterfaceDAO<Atendimento>{

    private EntityManager entityManager;

    public AtendimentoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void create(Atendimento objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Atendimento> retrieve() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Atendimento retrieve(int pk) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Atendimento> retrieve(String parametro, String atributo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Atendimento objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Atendimento objeto) {
        try {
            Atendimento atendimento = entityManager.find(Atendimento.class, objeto.getId());
            entityManager.getTransaction().begin();
            entityManager.remove(atendimento);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
}

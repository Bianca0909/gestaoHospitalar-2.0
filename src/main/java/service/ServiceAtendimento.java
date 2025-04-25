package service;

import java.util.List;
import model.bo.Atendimento;
import model.dao.AtendimentoDAO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ServiceAtendimento {

    private static EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU");
        return factory.createEntityManager();
    }

    public static void adicionar(Atendimento objeto) {
        AtendimentoDAO atendimentoDAO = new AtendimentoDAO(getEntityManager());
        atendimentoDAO.create(objeto);
    }

    public static List<Atendimento> ler() {
        AtendimentoDAO atendimentoDAO = new AtendimentoDAO(getEntityManager());
        return atendimentoDAO.retrieve();
    }

    public static Atendimento ler(int PK) {
        AtendimentoDAO atendimentoDAO = new AtendimentoDAO(getEntityManager());
        return atendimentoDAO.retrieve(PK);
    }

    public static List<Atendimento> ler(String parametro, String atributo) {
        AtendimentoDAO atendimentoDAO = new AtendimentoDAO(getEntityManager());
        return atendimentoDAO.retrieve(parametro, atributo);
    }

    public static void atualizar(Atendimento objeto) {
        AtendimentoDAO atendimentoDAO = new AtendimentoDAO(getEntityManager());
        atendimentoDAO.update(objeto);
    }
}

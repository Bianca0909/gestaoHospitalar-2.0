package service;

import java.util.List;
import model.bo.Atendimento;
import model.dao.AtendimentoDAO;

public class ServiceAtendimento {

    public static void adicionar(Atendimento objeto) {
        AtendimentoDAO atendimentoDAO = AtendimentoDAO.getInstance();
        atendimentoDAO.create(objeto);
    }

    public static List<Atendimento> ler() {
        AtendimentoDAO atendimentoDAO = AtendimentoDAO.getInstance();
        return atendimentoDAO.retrieve();
    }

    public static Atendimento ler(int pk) {
        AtendimentoDAO atendimentoDAO = AtendimentoDAO.getInstance();
        return atendimentoDAO.retrieve(pk);
    }

    public static List<Atendimento> ler(String parametro, String atributo) {
        AtendimentoDAO atendimentoDAO = AtendimentoDAO.getInstance();
        return atendimentoDAO.retrieve(parametro, atributo);
    }

    public static void atualizar(Atendimento objeto) {
        AtendimentoDAO atendimentoDAO = AtendimentoDAO.getInstance();
        atendimentoDAO.update(objeto);
    }
}

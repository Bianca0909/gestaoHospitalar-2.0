package service;

import java.util.List;
import model.bo.ReceitaMedicamento;
import model.dao.ReceitaMedicamentoDAO;

public class ServiceReceitaMedicamento {

    public static void adicionar(ReceitaMedicamento objeto) {
        ReceitaMedicamentoDAO receitaDAO = ReceitaMedicamentoDAO.getInstance();
        receitaDAO.create(objeto);
    }

    public static List<ReceitaMedicamento> ler() {
        ReceitaMedicamentoDAO receitaDAO = ReceitaMedicamentoDAO.getInstance();
        return receitaDAO.retrieve();
    }

    public static ReceitaMedicamento ler(int pk) {
        ReceitaMedicamentoDAO receitaDAO = ReceitaMedicamentoDAO.getInstance();
        return receitaDAO.retrieve(pk);
    }

    public static List<ReceitaMedicamento> ler(String parametro, String atributo) {
        ReceitaMedicamentoDAO receitaDAO = ReceitaMedicamentoDAO.getInstance();
        return receitaDAO.retrieve(parametro, atributo);
    }

    public static void atualizar(ReceitaMedicamento objeto) {
        ReceitaMedicamentoDAO receitaDAO = ReceitaMedicamentoDAO.getInstance();
        receitaDAO.update(objeto);
    }
}

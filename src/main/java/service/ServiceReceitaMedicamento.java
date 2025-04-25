package service;

import java.util.List;
import model.bo.ReceitaMedicamento;
import model.dao.ReceitaMedicamentoDAO;

public class ServiceReceitaMedicamento {

    public static void adicionar(ReceitaMedicamento objeto) {
        ReceitaMedicamentoDAO.getInstance().create(objeto);
    }

    public static List<ReceitaMedicamento> ler() {
        return ReceitaMedicamentoDAO.getInstance().retrieve();
    }

    public static ReceitaMedicamento ler(int PK) {
        return ReceitaMedicamentoDAO.getInstance().retrieve(PK);
    }

    public static List<ReceitaMedicamento> ler(String parametro, String atributo) {
        return ReceitaMedicamentoDAO.getInstance().retrieve(parametro, atributo);
    }

    public static void atualizar(ReceitaMedicamento objeto) {
        ReceitaMedicamentoDAO.getInstance().update(objeto);
    }
}

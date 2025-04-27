package service;

import java.util.List;
import model.bo.MovimentoMedicamento;
import model.dao.MovimentoMedicamentoDAO;

public class ServiceMovimentoMedicamento {

    public static void adicionar(MovimentoMedicamento objeto) {
        MovimentoMedicamentoDAO movimentoDAO = MovimentoMedicamentoDAO.getInstance();
        movimentoDAO.create(objeto);
    }

    public static List<MovimentoMedicamento> ler() {
        MovimentoMedicamentoDAO movimentoDAO = MovimentoMedicamentoDAO.getInstance();
        return movimentoDAO.retrieve();
    }

    public static MovimentoMedicamento ler(int pk) {
        MovimentoMedicamentoDAO movimentoDAO = MovimentoMedicamentoDAO.getInstance();
        return movimentoDAO.retrieve(pk);
    }

    public static List<MovimentoMedicamento> ler(String parametro, String atributo) {
        MovimentoMedicamentoDAO movimentoDAO = MovimentoMedicamentoDAO.getInstance();
        return movimentoDAO.retrieve(parametro, atributo);
    }

    public static void atualizar(MovimentoMedicamento objeto) {
        MovimentoMedicamentoDAO movimentoDAO = MovimentoMedicamentoDAO.getInstance();
        movimentoDAO.update(objeto);
    }
}

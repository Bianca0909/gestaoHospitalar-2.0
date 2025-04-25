package service;

import java.util.List;
import model.bo.MovimentoMedicamento;
import model.dao.MovimentoMedicamentoDAO;

public class ServiceMovimentoMedicamento {

    public static void adicionar(MovimentoMedicamento objeto) {
        MovimentoMedicamentoDAO.getInstance().create(objeto);
    }

    public static List<MovimentoMedicamento> ler() {
        return MovimentoMedicamentoDAO.getInstance().retrieve();
    }

    public static MovimentoMedicamento ler(int PK) {
        return MovimentoMedicamentoDAO.getInstance().retrieve(PK);
    }

    public static List<MovimentoMedicamento> ler(String parametro, String atributo) {
        return MovimentoMedicamentoDAO.getInstance().retrieve(parametro, atributo);
    }

    public static void atualizar(MovimentoMedicamento objeto) {
        MovimentoMedicamentoDAO.getInstance().update(objeto);
    }
}

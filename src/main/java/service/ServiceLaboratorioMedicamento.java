package service;

import java.util.List;
import model.bo.LaboratorioMedicamento;
import model.dao.LaboratorioMedicamentoDAO;

public class ServiceLaboratorioMedicamento {

    public static void adicionar(LaboratorioMedicamento objeto) {
        LaboratorioMedicamentoDAO.getInstance().create(objeto);
    }

    public static List<LaboratorioMedicamento> ler() {
        return LaboratorioMedicamentoDAO.getInstance().retrieve();
    }

    public static LaboratorioMedicamento ler(int PK) {
        return LaboratorioMedicamentoDAO.getInstance().retrieve(PK);
    }

    public static List<LaboratorioMedicamento> ler(String parametro, String atributo) {
        return LaboratorioMedicamentoDAO.getInstance().retrieve(parametro, atributo);
    }

    public static void atualizar(LaboratorioMedicamento objeto) {
        LaboratorioMedicamentoDAO.getInstance().update(objeto);
    }
}

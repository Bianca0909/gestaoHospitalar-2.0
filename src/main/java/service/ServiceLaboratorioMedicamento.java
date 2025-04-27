package service;

import java.util.List;
import model.bo.LaboratorioMedicamento;
import model.dao.LaboratorioMedicamentoDAO;

public class ServiceLaboratorioMedicamento {

    public static void adicionar(LaboratorioMedicamento objeto) {
        LaboratorioMedicamentoDAO laboratorioDAO = LaboratorioMedicamentoDAO.getInstance();
        laboratorioDAO.create(objeto);
    }

    public static List<LaboratorioMedicamento> ler() {
        LaboratorioMedicamentoDAO laboratorioDAO = LaboratorioMedicamentoDAO.getInstance();
        return laboratorioDAO.retrieve();
    }

    public static LaboratorioMedicamento ler(int pk) {
        LaboratorioMedicamentoDAO laboratorioDAO = LaboratorioMedicamentoDAO.getInstance();
        return laboratorioDAO.retrieve(pk);
    }

    public static List<LaboratorioMedicamento> ler(String parametro, String atributo) {
        LaboratorioMedicamentoDAO laboratorioDAO = LaboratorioMedicamentoDAO.getInstance();
        return laboratorioDAO.retrieve(parametro, atributo);
    }

    public static void atualizar(LaboratorioMedicamento objeto) {
        LaboratorioMedicamentoDAO laboratorioDAO = LaboratorioMedicamentoDAO.getInstance();
        laboratorioDAO.update(objeto);
    }
}

package service;

import java.util.List;
import model.bo.Medicamento;
import model.dao.MedicamentoDAO;

public class ServiceMedicamento {

    public static void adicionar(Medicamento objeto) {
        MedicamentoDAO medicamentoDAO = MedicamentoDAO.getInstance();
        medicamentoDAO.create(objeto);
    }

    public static List<Medicamento> ler() {
        MedicamentoDAO medicamentoDAO = MedicamentoDAO.getInstance();
        return medicamentoDAO.retrieve();
    }

    public static Medicamento ler(int pk) {
        MedicamentoDAO medicamentoDAO = MedicamentoDAO.getInstance();
        return medicamentoDAO.retrieve(pk);
    }

    public static List<Medicamento> ler(String parametro, String atributo) {
        MedicamentoDAO medicamentoDAO = MedicamentoDAO.getInstance();
        return medicamentoDAO.retrieve(parametro, atributo);
    }

    public static void atualizar(Medicamento objeto) {
        MedicamentoDAO medicamentoDAO = MedicamentoDAO.getInstance();
        medicamentoDAO.update(objeto);
    }
}

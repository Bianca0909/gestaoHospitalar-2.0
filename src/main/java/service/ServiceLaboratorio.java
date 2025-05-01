package service;

import java.util.List;
import model.bo.Laboratorio;
import model.dao.LaboratorioDAO;

public class ServiceLaboratorio {

    public static void adicionar(Laboratorio objeto) {
        LaboratorioDAO.getInstance().create(objeto);
    }

    public static List<Laboratorio> ler() {
        return LaboratorioDAO.getInstance().retrieve();
    }

    public static Laboratorio ler(int PK) {
        return LaboratorioDAO.getInstance().retrieve(PK);
    }

    public static List<Laboratorio> ler(String parametro, String atributo) {
        return LaboratorioDAO.getInstance().retrieve(parametro, atributo);
    }

    public static void atualizar(Laboratorio objeto) {
        LaboratorioDAO.getInstance().update(objeto);

    }

    public static boolean excluir(int id) {
        try {
            LaboratorioDAO laboratorioDAO = LaboratorioDAO.getInstance();
            Laboratorio laboratorio = laboratorioDAO.retrieve(id);
            if (laboratorio != null) {
                laboratorioDAO.delete(laboratorio);
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}

package service;

import java.util.List;
import model.bo.Medico;
import model.dao.MedicoDAO;

public class ServiceMedico {

    public static void adicionar(Medico objeto) {
        MedicoDAO medicoDAO = MedicoDAO.getInstance();
        medicoDAO.create(objeto);
    }

    public static List<Medico> ler() {
        MedicoDAO medicoDAO = MedicoDAO.getInstance();
        return medicoDAO.retrieve();
    }

    public static Medico ler(int pk) {
        MedicoDAO medicoDAO = MedicoDAO.getInstance();
        return medicoDAO.retrieve(pk);
    }

    public static List<Medico> ler(String parametro, String atributo) {
        MedicoDAO medicoDAO = MedicoDAO.getInstance();
        return medicoDAO.retrieve(parametro, atributo);
    }

    public static void atualizar(Medico objeto) {
        MedicoDAO medicoDAO = MedicoDAO.getInstance();
        medicoDAO.update(objeto);
    }

    public static boolean excluir(int id) {
        try {
            MedicoDAO.getInstance().delete(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

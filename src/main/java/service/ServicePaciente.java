package service;

import java.util.List;
import model.bo.Paciente;
import model.dao.PacienteDAO;

public class ServicePaciente {

    public static void adicionar(Paciente objeto) {
        PacienteDAO pacienteDAO = PacienteDAO.getInstance();
        pacienteDAO.create(objeto);
    }

    public static List<Paciente> ler() {
        PacienteDAO pacienteDAO = PacienteDAO.getInstance();
        return pacienteDAO.retrieve();
    }

    public static Paciente ler(int pk) {
        PacienteDAO pacienteDAO = PacienteDAO.getInstance();
        return pacienteDAO.retrieve(pk);
    }

    public static List<Paciente> ler(String parametro, String atributo) {
        PacienteDAO pacienteDAO = PacienteDAO.getInstance();
        return pacienteDAO.retrieve(parametro, atributo);
    }

    public static void atualizar(Paciente objeto) {
        PacienteDAO pacienteDAO = PacienteDAO.getInstance();
        pacienteDAO.update(objeto);
    }
}

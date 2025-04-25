package service;

import java.util.List;
import model.bo.Paciente;
import model.dao.PacienteDAO;


public class ServicePaciente {
    
     public static void adicionar(Paciente objeto) {
        PacienteDAO.getInstance().create(objeto);
    }
     public static List<Paciente> ler() {
        return PacienteDAO.getInstance().retrieve();
    }

    public static Paciente ler(int PK) {
        return PacienteDAO.getInstance().retrieve(PK);
    }

    public static List<Paciente> ler(String parametro, String atributo) {
        return PacienteDAO.getInstance().retrieve(parametro, atributo);
    }
    
    public static void atualizar(Paciente objeto){
        PacienteDAO.getInstance().update(objeto);
    }
}

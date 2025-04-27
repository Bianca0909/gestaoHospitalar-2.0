package service;

import java.util.List;
import model.bo.Prontuario;
import model.dao.ProntuarioDAO;

public class ServiceProntuario {

    public static void adicionar(Prontuario objeto) {
        ProntuarioDAO prontuarioDAO = ProntuarioDAO.getInstance();
        prontuarioDAO.create(objeto);
    }

    public static List<Prontuario> ler() {
        ProntuarioDAO prontuarioDAO = ProntuarioDAO.getInstance();
        return prontuarioDAO.retrieve();
    }

    public static Prontuario ler(int pk) {
        ProntuarioDAO prontuarioDAO = ProntuarioDAO.getInstance();
        return prontuarioDAO.retrieve(pk);
    }

    public static List<Prontuario> ler(String parametro, String atributo) {
        ProntuarioDAO prontuarioDAO = ProntuarioDAO.getInstance();
        return prontuarioDAO.retrieve(parametro, atributo);
    }

    public static void atualizar(Prontuario objeto) {
        ProntuarioDAO prontuarioDAO = ProntuarioDAO.getInstance();
        prontuarioDAO.update(objeto);
    }
}

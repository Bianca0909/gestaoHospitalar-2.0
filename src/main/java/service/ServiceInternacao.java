package service;

import java.util.List;
import model.bo.Internacao;
import model.dao.InternacaoDAO;

public class ServiceInternacao {

    public static void adicionar(Internacao objeto) {
        InternacaoDAO internacaoDAO = InternacaoDAO.getInstance();
        internacaoDAO.create(objeto);
    }

    public static List<Internacao> ler() {
        InternacaoDAO internacaoDAO = InternacaoDAO.getInstance();
        return internacaoDAO.retrieve();
    }

    public static Internacao ler(int pk) {
        InternacaoDAO internacaoDAO = InternacaoDAO.getInstance();
        return internacaoDAO.retrieve(pk);
    }

    public static List<Internacao> ler(String parametro, String atributo) {
        InternacaoDAO internacaoDAO = InternacaoDAO.getInstance();
        return internacaoDAO.retrieve(parametro, atributo);
    }

    public static void atualizar(Internacao objeto) {
        InternacaoDAO internacaoDAO = InternacaoDAO.getInstance();
        internacaoDAO.update(objeto);
    }
}

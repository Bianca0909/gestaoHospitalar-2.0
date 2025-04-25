package service;

import java.util.List;
import model.bo.InternacaoLeito;
import model.dao.InternacaoLeitoDAO;

public class ServiceInternacaoLeito {

    public static void adicionar(InternacaoLeito objeto) {
        InternacaoLeitoDAO internacaoLeitoDAO = new InternacaoLeitoDAO();
        internacaoLeitoDAO.create(objeto);
    }

    public static List<InternacaoLeito> ler() {
        InternacaoLeitoDAO internacaoLeitoDAO = new InternacaoLeitoDAO();
        return internacaoLeitoDAO.retrieve();
    }

    public static InternacaoLeito ler(int PK) {
        InternacaoLeitoDAO internacaoLeitoDAO = new InternacaoLeitoDAO();
        return internacaoLeitoDAO.retrieve(PK);
    }

    public static List<InternacaoLeito> ler(String parametro, String atributo) {
        InternacaoLeitoDAO internacaoLeitoDAO = new InternacaoLeitoDAO();
        return internacaoLeitoDAO.retrieve(parametro, atributo);
    }

    public static void atualizar(InternacaoLeito objeto) {
        InternacaoLeitoDAO internacaoLeitoDAO = new InternacaoLeitoDAO();
        internacaoLeitoDAO.update(objeto);
    }
}

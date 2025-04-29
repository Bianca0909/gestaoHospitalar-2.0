package service;

import java.util.List;
import model.bo.AcompanhanteInternacao;
import model.dao.AcompanhanteInternacaoDAO;

public class ServiceAcompanhanteInternacao {

    public static void adicionar(AcompanhanteInternacao objeto) {
        AcompanhanteInternacaoDAO.getInstance().create(objeto);
    }

    public static List<AcompanhanteInternacao> ler() {
        return AcompanhanteInternacaoDAO.getInstance().retrieve();
    }

    public static AcompanhanteInternacao ler(int PK) {
        return AcompanhanteInternacaoDAO.getInstance().retrieve(PK);
    }

    public static List<AcompanhanteInternacao> ler(String parametro, String atributo) {
        return AcompanhanteInternacaoDAO.getInstance().retrieve(parametro, atributo);
    }

    public static void atualizar(AcompanhanteInternacao objeto) {
        AcompanhanteInternacaoDAO.getInstance().update(objeto);
    }
    
    public static void excluir(AcompanhanteInternacao objeto) {
        AcompanhanteInternacaoDAO.getInstance().delete(objeto);
    }
}

package service;

import java.util.List;
import model.bo.Lote;
import model.dao.LoteDAO;

public class ServiceLote {

    public static void adicionar(Lote objeto) {
        LoteDAO loteDAO = LoteDAO.getInstance();
        loteDAO.create(objeto);
    }

    public static List<Lote> ler() {
        LoteDAO loteDAO = LoteDAO.getInstance();
        return loteDAO.retrieve();
    }

    public static Lote ler(int pk) {
        LoteDAO loteDAO = LoteDAO.getInstance();
        return loteDAO.retrieve(pk);
    }

    public static List<Lote> ler(String parametro, String atributo) {
        LoteDAO loteDAO = LoteDAO.getInstance();
        return loteDAO.retrieve(parametro, atributo);
    }

    public static void atualizar(Lote objeto) {
        LoteDAO loteDAO = LoteDAO.getInstance();
        loteDAO.update(objeto);
    }
}

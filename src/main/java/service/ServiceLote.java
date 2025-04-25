package service;

import java.util.List;
import model.bo.Lote;
import model.dao.LoteDAO;

public class ServiceLote {

    public static void adicionar(Lote objeto) {
        LoteDAO loteDAO = new LoteDAO();
        loteDAO.create(objeto);
    }

    public static List<Lote> ler() {
        LoteDAO loteDAO = new LoteDAO();
        return loteDAO.retrieve();
    }

    public static Lote ler(int PK) {
        LoteDAO loteDAO = new LoteDAO();
        return loteDAO.retrieve(PK);
    }

    public static List<Lote> ler(String parametro, String atributo) {
        LoteDAO loteDAO = new LoteDAO();
        return loteDAO.retrieve(parametro, atributo);
    }

    public static void atualizar(Lote objeto) {
        LoteDAO loteDAO = new LoteDAO();
        loteDAO.update(objeto);
    }
}

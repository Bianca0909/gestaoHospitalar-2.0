package service;

import java.util.List;
import model.bo.Fornecedor;
import model.dao.FornecedorDAO;

public class ServiceFornecedor {

    public static void adicionar(Fornecedor objeto) {
        FornecedorDAO fornecedorDAO = FornecedorDAO.getInstance();
        fornecedorDAO.create(objeto);
    }

    public static List<Fornecedor> ler() {
        FornecedorDAO fornecedorDAO = FornecedorDAO.getInstance();
        return fornecedorDAO.retrieve();
    }

    public static Fornecedor ler(int pk) {
        FornecedorDAO fornecedorDAO = FornecedorDAO.getInstance();
        return fornecedorDAO.retrieve(pk);
    }

    public static List<Fornecedor> ler(String parametro, String atributo) {
        FornecedorDAO fornecedorDAO = FornecedorDAO.getInstance();
        return fornecedorDAO.retrieve(parametro, atributo);
    }

    public static void atualizar(Fornecedor objeto) {
        FornecedorDAO fornecedorDAO = FornecedorDAO.getInstance();
        fornecedorDAO.update(objeto);
    }

    public static boolean excluir(int id) {
        try {
            FornecedorDAO fornecedorDAO = FornecedorDAO.getInstance();
            Fornecedor fornecedor = fornecedorDAO.retrieve(id);
            if (fornecedor != null) {
                fornecedorDAO.delete(fornecedor);
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}

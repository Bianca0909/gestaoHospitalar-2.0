package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bo.Fornecedor;
import service.ServiceFornecedor;
import view.TelaBuscaFornecedor;
import view.TelaCadastroFornecedor;
import enums.StatusCadastroEnum;

public class ControllerBuscaFornecedor implements ActionListener {

    TelaBuscaFornecedor telaBuscaFornecedor;
    private int codigoRetorno = 0;

    public int getCodigoRetorno() {
        return codigoRetorno;
    }

    public void setCodigoRetorno(int codigoRetorno) {
        this.codigoRetorno = codigoRetorno;
    }

    public ControllerBuscaFornecedor(TelaBuscaFornecedor telaBuscaFornecedor) {
        this.telaBuscaFornecedor = telaBuscaFornecedor;
        this.telaBuscaFornecedor.getjButtonCarregar().addActionListener(this);
        this.telaBuscaFornecedor.getjButtonSair().addActionListener(this);
        this.telaBuscaFornecedor.getjButtonFiltar().addActionListener(this);
        this.telaBuscaFornecedor.getEditarButton().addActionListener(this);
        this.telaBuscaFornecedor.getExcluirButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == this.telaBuscaFornecedor.getjButtonCarregar()) {
            loadTableData();
        } else if (evento.getSource() == this.telaBuscaFornecedor.getjButtonSair()) {
            this.telaBuscaFornecedor.dispose();
        } else if (evento.getSource() == this.telaBuscaFornecedor.getjButtonFiltar()) {
            filterTableData();
        } else if (evento.getSource() == this.telaBuscaFornecedor.getEditarButton()) {
            editSelectedRecord();
        } else if (evento.getSource() == this.telaBuscaFornecedor.getExcluirButton()) {
            deleteSelectedRecord();
        }
    }

    private void loadTableData() {
        DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaFornecedor.getjTableDados().getModel();
        tabela.setRowCount(0);
        for (Fornecedor fornecedor : ServiceFornecedor.ler()) {
            addRowToTable(tabela, fornecedor);
        }
    }

    private void filterTableData() {
        String filtro = this.telaBuscaFornecedor.getjTFFiltro().getText().trim();
        if (filtro.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha o campo de busca");
            this.telaBuscaFornecedor.getjTFFiltro().requestFocus();
            return;
        }

        DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaFornecedor.getjTableDados().getModel();
        tabela.setRowCount(0);

        String tipoFiltro = this.telaBuscaFornecedor.getjCBFiltro().getSelectedItem().toString();
        if (tipoFiltro.equals("ID")) {
            try {
                Fornecedor fornecedor = ServiceFornecedor.ler(Integer.parseInt(filtro));
                if (fornecedor != null) {
                    addRowToTable(tabela, fornecedor);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "ID deve ser um número");
            }
        } else {
            String campo = getCampoFiltro(tipoFiltro);
            for (Fornecedor fornecedor : ServiceFornecedor.ler(filtro, campo)) {
                addRowToTable(tabela, fornecedor);
            }
        }
    }

    private void editSelectedRecord() {
        int linhaSelecionada = this.telaBuscaFornecedor.getjTableDados().getSelectedRow();
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(null, "Selecione um registro para editar");
            return;
        }

        int id = (int) this.telaBuscaFornecedor.getjTableDados().getValueAt(linhaSelecionada, 0);
        Fornecedor fornecedor = ServiceFornecedor.ler(id);
        if (fornecedor == null) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar o fornecedor");
            return;
        }

        TelaCadastroFornecedor telaCadastro = new TelaCadastroFornecedor(null, true);

        // Preenche os campos
        telaCadastro.getIdField().setText(String.valueOf(fornecedor.getId()));
        telaCadastro.getNomeField().setText(fornecedor.getNome());
        telaCadastro.getNomeFantasiaField().setText(fornecedor.getNomeFantasia());
        telaCadastro.getCpfCnpjField().setText(fornecedor.getCpfCnpj());
        telaCadastro.getRgInscricaoEstadualField().setText(fornecedor.getRgInscricaoEstadual());
        telaCadastro.getFone1Field().setText(fornecedor.getFone1());
        telaCadastro.getFone2Field().setText(fornecedor.getFone2());
        telaCadastro.getEmailField().setText(fornecedor.getEmail());
        telaCadastro.getDataCadastroField().setText(fornecedor.getDataCadastro());
        telaCadastro.getContatoField().setText(fornecedor.getContato());
        telaCadastro.getCepField().setText(fornecedor.getCep());
        telaCadastro.getCidadeField().setText(fornecedor.getCidade());
        telaCadastro.getBairroField().setText(fornecedor.getBairro());
        telaCadastro.getLogradouroField().setText(fornecedor.getLogradouro());
        telaCadastro.getComplementoField().setText(fornecedor.getComplemento());
        
        // Converte o status
        StatusCadastroEnum statusEnum = fornecedor.getStatus().equals("A") ? 
            StatusCadastroEnum.ATIVO : StatusCadastroEnum.INATIVO;
        telaCadastro.getStatusComboBox().setSelectedItem(statusEnum);

        // Configura os campos - todos habilitados exceto ID
        telaCadastro.getIdField().setEnabled(false);
        telaCadastro.getNomeField().setEnabled(true);
        telaCadastro.getNomeFantasiaField().setEnabled(true);
        telaCadastro.getCpfCnpjField().setEnabled(true);
        telaCadastro.getRgInscricaoEstadualField().setEnabled(true);
        telaCadastro.getFone1Field().setEnabled(true);
        telaCadastro.getFone2Field().setEnabled(true);
        telaCadastro.getEmailField().setEnabled(true);
        telaCadastro.getDataCadastroField().setEnabled(true);
        telaCadastro.getContatoField().setEnabled(true);
        telaCadastro.getCepField().setEnabled(true);
        telaCadastro.getCidadeField().setEnabled(true);
        telaCadastro.getBairroField().setEnabled(true);
        telaCadastro.getLogradouroField().setEnabled(true);
        telaCadastro.getComplementoField().setEnabled(true);
        telaCadastro.getStatusComboBox().setEnabled(true);

        // Configura os botões
        telaCadastro.getjButtonNovo().setEnabled(false);
        telaCadastro.getjButtonCancelar().setEnabled(true);
        telaCadastro.getjButtonGravar().setEnabled(true);
        telaCadastro.getjButtonBuscar().setEnabled(false);
        telaCadastro.getjButtonSair().setEnabled(true);

        telaCadastro.setVisible(true);
        loadTableData(); // Recarrega a tabela após a edição
    }

    private void deleteSelectedRecord() {
        int linhaSelecionada = this.telaBuscaFornecedor.getjTableDados().getSelectedRow();
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(null, "Selecione um registro para excluir");
            return;
        }

        int id = (int) this.telaBuscaFornecedor.getjTableDados().getValueAt(linhaSelecionada, 0);
        int confirmacao = JOptionPane.showConfirmDialog(null, "Confirma a exclusão do fornecedor?");
        if (confirmacao == JOptionPane.YES_OPTION) {
            if (ServiceFornecedor.excluir(id)) {
                JOptionPane.showMessageDialog(null, "Fornecedor excluído com sucesso!");
                loadTableData();
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao excluir o fornecedor");
            }
        }
    }

    private void addRowToTable(DefaultTableModel tabela, Fornecedor fornecedor) {
        tabela.addRow(new Object[]{
            fornecedor.getId(),
            fornecedor.getNome(),
            fornecedor.getNomeFantasia(),
            fornecedor.getCpfCnpj(),
            fornecedor.getRgInscricaoEstadual(),
            fornecedor.getFone1(),
            fornecedor.getFone2(),
            fornecedor.getEmail(),
            fornecedor.getDataCadastro(),
            fornecedor.getContato(),
            fornecedor.getCep(),
            fornecedor.getCidade(),
            fornecedor.getBairro(),
            fornecedor.getLogradouro(),
            fornecedor.getComplemento(),
            fornecedor.getStatus()
        });
    }

    private String getCampoFiltro(String tipoFiltro) {
        switch (tipoFiltro) {
            case "NOME": return "nome";
            case "NOME FANTASIA": return "nomeFantasia";
            case "CPF/CNPJ": return "cpfCnpj";
            case "TELEFONE": return "fone1";
            case "EMAIL": return "email";
            case "CIDADE": return "cidade";
            case "STATUS": return "status";
            default: return "";
        }
    }
}

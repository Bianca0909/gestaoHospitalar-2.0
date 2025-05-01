package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bo.Enfermeiro;
import service.ServiceEnfermeiro;
import view.TelaBuscaEnfermeiro;
import view.TelaCadastroEnfermeiro;
import enums.StatusCadastroEnum;

public class ControllerBuscaEnfermeiro implements ActionListener {

    TelaBuscaEnfermeiro telaBuscaEnfermeiro;
    private int codigoRetorno = 0;

    public int getCodigoRetorno() {
        return codigoRetorno;
    }

    public void setCodigoRetorno(int codigoRetorno) {
        this.codigoRetorno = codigoRetorno;
    }

    public ControllerBuscaEnfermeiro(TelaBuscaEnfermeiro telaBuscaEnfermeiro) {
        this.telaBuscaEnfermeiro = telaBuscaEnfermeiro;

        this.telaBuscaEnfermeiro.getjButtonCarregar().addActionListener(this);
        this.telaBuscaEnfermeiro.getjButtonSair().addActionListener(this);
        this.telaBuscaEnfermeiro.getjCBFiltro().addActionListener(this);
        this.telaBuscaEnfermeiro.getjButtonFiltar().addActionListener(this);
        this.telaBuscaEnfermeiro.getjButtonEditar().addActionListener(this);
        this.telaBuscaEnfermeiro.getjButtonExcluir().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == this.telaBuscaEnfermeiro.getjButtonCarregar()) {
            loadTable();
        } else if (evento.getSource() == this.telaBuscaEnfermeiro.getjButtonSair()) {
            this.telaBuscaEnfermeiro.dispose();
        } else if (evento.getSource() == this.telaBuscaEnfermeiro.getjButtonFiltar()) {
            filterTableData();
        } else if (evento.getSource() == this.telaBuscaEnfermeiro.getjButtonEditar()) {
            editSelectedRecord();
        } else if (evento.getSource() == this.telaBuscaEnfermeiro.getjButtonExcluir()) {
            deleteSelectedRecord();
        }
    }

    private void loadTable() {
        DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaEnfermeiro.getjTableDados().getModel();
        tabela.setRowCount(0);
        for (Enfermeiro enfermeiro : ServiceEnfermeiro.ler()) {
            addRowToTable(tabela, enfermeiro);
        }
    }

    private void filterTableData() {
        if (this.telaBuscaEnfermeiro.getjTFFiltro().getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "É obrigatório o preenchimento de algum caracter...");
            this.telaBuscaEnfermeiro.getjTFFiltro().requestFocus();
            return;
        }

        DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaEnfermeiro.getjTableDados().getModel();
        tabela.setRowCount(0);

        String filtroSelecionado = this.telaBuscaEnfermeiro.getjCBFiltro().getSelectedItem().toString();
        String valorFiltro = this.telaBuscaEnfermeiro.getjTFFiltro().getText();

        if (filtroSelecionado.equals("ID")) {
            try {
                Enfermeiro enfermeiro = ServiceEnfermeiro.ler(Integer.parseInt(valorFiltro));
                if (enfermeiro != null) {
                    addRowToTable(tabela, enfermeiro);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "ID deve ser um número válido");
            }
        } else {
            String campoFiltro = getCampoFiltro(filtroSelecionado);
            for (Enfermeiro enfermeiro : ServiceEnfermeiro.ler(valorFiltro, campoFiltro)) {
                addRowToTable(tabela, enfermeiro);
            }
        }
    }

    private void editSelectedRecord() {
        int linhaSelecionada = this.telaBuscaEnfermeiro.getjTableDados().getSelectedRow();
        
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(null, "Selecione um registro para editar.");
            return;
        }

        int id = (int) this.telaBuscaEnfermeiro.getjTableDados().getValueAt(linhaSelecionada, 0);
        Enfermeiro enfermeiro = ServiceEnfermeiro.ler(id);
        
        if (enfermeiro == null) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar o enfermeiro.");
            return;
        }

        TelaCadastroEnfermeiro telaCadastro = new TelaCadastroEnfermeiro(null, true);
        new ControllerCadastroEnfermeiro(telaCadastro);
        
        // Preenche os campos
        telaCadastro.getIdField().setText(String.valueOf(enfermeiro.getId()));
        telaCadastro.getNomeField().setText(enfermeiro.getNome());
        telaCadastro.getCreField().setText(enfermeiro.getCre());
        telaCadastro.getCpfCnpjField().setText(enfermeiro.getCpfCnpj());
        telaCadastro.getFone1Field().setText(enfermeiro.getFone1());
        telaCadastro.getFone2Field().setText(enfermeiro.getFone2());
        telaCadastro.getEmailField().setText(enfermeiro.getEmail());
        telaCadastro.getNomeSocialField().setText(enfermeiro.getNomeSocial());
        telaCadastro.getRgInscricaoEstadualField().setText(enfermeiro.getRgInscricaoEstadual());
        telaCadastro.getDataCadastroField().setText(enfermeiro.getDataCadastro());
        telaCadastro.getCepField().setText(enfermeiro.getCep());
        telaCadastro.getCidadeField().setText(enfermeiro.getCidade());
        telaCadastro.getBairroField().setText(enfermeiro.getBairro());
        telaCadastro.getLogradouroField().setText(enfermeiro.getLogradouro());
        telaCadastro.getComplementoField().setText(enfermeiro.getComplemento());
        telaCadastro.getLoginField().setText(enfermeiro.getLogin());
        telaCadastro.getSenhaField().setText(enfermeiro.getSenha());
        
        // Converte o status String para StatusCadastroEnum
        StatusCadastroEnum statusEnum = enfermeiro.getStatus().equals("A") ? 
            StatusCadastroEnum.ATIVO : StatusCadastroEnum.INATIVO;
        telaCadastro.getStatusComboBox().setSelectedItem(statusEnum);
        
        // Configura os campos - todos habilitados exceto ID
        telaCadastro.getIdField().setEnabled(false);
        telaCadastro.getNomeField().setEnabled(true);
        telaCadastro.getCreField().setEnabled(true);
        telaCadastro.getCpfCnpjField().setEnabled(true);
        telaCadastro.getFone1Field().setEnabled(true);
        telaCadastro.getFone2Field().setEnabled(true);
        telaCadastro.getEmailField().setEnabled(true);
        telaCadastro.getNomeSocialField().setEnabled(true);
        telaCadastro.getRgInscricaoEstadualField().setEnabled(true);
        telaCadastro.getDataCadastroField().setEnabled(true);
        telaCadastro.getCepField().setEnabled(true);
        telaCadastro.getCidadeField().setEnabled(true);
        telaCadastro.getBairroField().setEnabled(true);
        telaCadastro.getLogradouroField().setEnabled(true);
        telaCadastro.getComplementoField().setEnabled(true);
        telaCadastro.getLoginField().setEnabled(true);
        telaCadastro.getSenhaField().setEnabled(true);
        telaCadastro.getStatusComboBox().setEnabled(true);
        
        // Configura os botões
        telaCadastro.getjButtonNovo().setEnabled(false);
        telaCadastro.getjButtonCancelar().setEnabled(true);
        telaCadastro.getjButtonGravar().setEnabled(true);
        telaCadastro.getjButtonBuscar().setEnabled(false);
        telaCadastro.getjButtonSair().setEnabled(true);
        
        telaCadastro.setVisible(true);
        
        // Atualiza a tabela
        loadTable();
    }

    private void deleteSelectedRecord() {
        int linhaSelecionada = this.telaBuscaEnfermeiro.getjTableDados().getSelectedRow();
        
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(null, "Selecione um registro para excluir.");
            return;
        }

        int id = (int) this.telaBuscaEnfermeiro.getjTableDados().getValueAt(linhaSelecionada, 0);
        
        int opcao = JOptionPane.showConfirmDialog(null, "Confirma a exclusão do enfermeiro selecionado?");
        if (opcao == JOptionPane.YES_OPTION) {
            if (ServiceEnfermeiro.excluir(id)) {
                JOptionPane.showMessageDialog(null, "Enfermeiro excluído com sucesso!");
                loadTable();
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao excluir o enfermeiro.");
            }
        }
    }

    private void addRowToTable(DefaultTableModel tabela, Enfermeiro enfermeiro) {
        tabela.addRow(new Object[]{
            enfermeiro.getId(),
            enfermeiro.getNome(),
            enfermeiro.getCre(),
            enfermeiro.getCpfCnpj(),
            enfermeiro.getFone1(),
            enfermeiro.getFone2(),
            enfermeiro.getEmail(),
            enfermeiro.getNomeSocial(),
            enfermeiro.getRgInscricaoEstadual(),
            enfermeiro.getDataCadastro(),
            enfermeiro.getCep(),
            enfermeiro.getCidade(),
            enfermeiro.getBairro(),
            enfermeiro.getLogradouro(),
            enfermeiro.getComplemento(),
            enfermeiro.getLogin(),
            enfermeiro.getSenha(),
            enfermeiro.getStatus()
        });
    }

    private String getCampoFiltro(String filtroSelecionado) {
        switch (filtroSelecionado) {
            case "NOME": return "nome";
            case "CRE": return "cre";
            case "LOGIN": return "login";
            case "STATUS": return "status";
            default: return "";
        }
    }
}

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bo.Acompanhante;
import service.ServiceAcompanhante;
import view.TelaBuscaAcompanhante;
import view.TelaCadastroAcompanhante;
import enums.StatusCadastroEnum;

public class ControllerBuscaAcompanhante implements ActionListener {

    TelaBuscaAcompanhante telaBuscaAcompanhante;
    private int codigoRetorno = 0;

    public int getCodigoRetorno() {
        return codigoRetorno;
    }

    public void setCodigoRetorno(int codigoRetorno) {
        this.codigoRetorno = codigoRetorno;
    }

    public ControllerBuscaAcompanhante(TelaBuscaAcompanhante telaBuscaAcompanhante) {
        this.telaBuscaAcompanhante = telaBuscaAcompanhante;
        this.telaBuscaAcompanhante.getCarregarButton().addActionListener(this);
        this.telaBuscaAcompanhante.getButtonFechar().addActionListener(this);
        this.telaBuscaAcompanhante.getButtonFiltrar().addActionListener(this);
        this.telaBuscaAcompanhante.getEditarButton().addActionListener(this);
        this.telaBuscaAcompanhante.getExcluirButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.telaBuscaAcompanhante.getCarregarButton()) {
            loadTableData();
        } else if (e.getSource() == this.telaBuscaAcompanhante.getButtonFechar()) {
            this.telaBuscaAcompanhante.dispose();
        } else if (e.getSource() == this.telaBuscaAcompanhante.getButtonFiltrar()) {
            filterTableData();
        } else if (e.getSource() == this.telaBuscaAcompanhante.getEditarButton()) {
            editSelectedRecord();
        } else if (e.getSource() == this.telaBuscaAcompanhante.getExcluirButton()) {
            deleteSelectedRecord();
        }
    }

    private void loadTableData() {
        DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaAcompanhante.getJTableDados().getModel();
        tabela.setRowCount(0);
        for (Acompanhante acompanhante : ServiceAcompanhante.ler()) {
            addRowToTable(tabela, acompanhante);
        }
    }

    private void filterTableData() {
        String filtro = this.telaBuscaAcompanhante.getValorField().getText().trim();
        if (filtro.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha o campo de busca");
            this.telaBuscaAcompanhante.getValorField().requestFocus();
            return;
        }

        DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaAcompanhante.getJTableDados().getModel();
        tabela.setRowCount(0);

        String tipoFiltro = this.telaBuscaAcompanhante.getFiltroComboBox().getSelectedItem().toString();
        if (tipoFiltro.equals("ID")) {
            try {
                Acompanhante acompanhante = ServiceAcompanhante.ler(Integer.parseInt(filtro));
                if (acompanhante != null) {
                    addRowToTable(tabela, acompanhante);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "ID deve ser um número");
            }
        } else {
            String campo = getCampoFiltro(tipoFiltro);
            for (Acompanhante acompanhante : ServiceAcompanhante.ler(filtro, campo)) {
                addRowToTable(tabela, acompanhante);
            }
        }
    }

    private void editSelectedRecord() {
        int linhaSelecionada = this.telaBuscaAcompanhante.getJTableDados().getSelectedRow();
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(null, "Selecione um registro para editar");
            return;
        }

        int id = (int) this.telaBuscaAcompanhante.getJTableDados().getValueAt(linhaSelecionada, 0);
        Acompanhante acompanhante = ServiceAcompanhante.ler(id);
        if (acompanhante == null) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar o acompanhante");
            return;
        }

        TelaCadastroAcompanhante telaCadastro = new TelaCadastroAcompanhante(null, true);

        // Preenche os campos
        telaCadastro.getIdField().setText(String.valueOf(acompanhante.getId()));
        telaCadastro.getNomeField().setText(acompanhante.getNome());
        telaCadastro.getGrauParentescoField().setText(acompanhante.getGrauParentesco());
        telaCadastro.getCpfCnpjField().setText(acompanhante.getCpf());
        telaCadastro.getFone1Field().setText(acompanhante.getFone());
        telaCadastro.getEmailField().setText(acompanhante.getEmail());
        
        // Converte o status
        StatusCadastroEnum statusEnum = acompanhante.getStatus().equals("A") ? 
            StatusCadastroEnum.ATIVO : StatusCadastroEnum.INATIVO;
        telaCadastro.getStatusComboBox().setSelectedItem(statusEnum);

        // Configura os campos
        telaCadastro.getIdField().setEnabled(false);
        telaCadastro.getNomeField().setEnabled(true);
        telaCadastro.getGrauParentescoField().setEnabled(true);
        telaCadastro.getCpfCnpjField().setEnabled(true);
        telaCadastro.getFone1Field().setEnabled(true);
        telaCadastro.getEmailField().setEnabled(true);
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
        int linhaSelecionada = this.telaBuscaAcompanhante.getJTableDados().getSelectedRow();
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(null, "Selecione um registro para excluir");
            return;
        }

        int id = (int) this.telaBuscaAcompanhante.getJTableDados().getValueAt(linhaSelecionada, 0);
        int confirmacao = JOptionPane.showConfirmDialog(null, "Confirma a exclusão do acompanhante?");
        if (confirmacao == JOptionPane.YES_OPTION) {
            if (ServiceAcompanhante.excluir(id)) {
                JOptionPane.showMessageDialog(null, "Acompanhante excluído com sucesso!");
                loadTableData();
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao excluir o acompanhante");
            }
        }
    }

    private void addRowToTable(DefaultTableModel tabela, Acompanhante acompanhante) {
        tabela.addRow(new Object[]{
            acompanhante.getId(),
            acompanhante.getNome(),
            acompanhante.getGrauParentesco(),
            acompanhante.getCpf(),
            acompanhante.getFone(),
            acompanhante.getEmail(),
            acompanhante.getStatus()
        });
    }

    private String getCampoFiltro(String tipoFiltro) {
        switch (tipoFiltro) {
            case "NOME": return "nome";
            case "GRAU PARENTESCO": return "grauParentesco";
            case "CPF": return "cpf";
            case "TELEFONE": return "fone";
            case "EMAIL": return "email";
            case "STATUS": return "status";
            default: return "";
        }
    }
}

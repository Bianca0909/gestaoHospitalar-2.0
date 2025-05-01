package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bo.Laboratorio;
import service.ServiceLaboratorio;
import view.TelaBuscaLaboratorio;
import view.TelaCadastroLaboratorio;
import enums.StatusCadastroEnum;

public class ControllerBuscaLaboratorio implements ActionListener {

    TelaBuscaLaboratorio telaBuscaLaboratorio;
    private int codigoRetorno = 0;

    public int getCodigoRetorno() {
        return codigoRetorno;
    }

    public void setCodigoRetorno(int codigoRetorno) {
        this.codigoRetorno = codigoRetorno;
    }

    public ControllerBuscaLaboratorio(TelaBuscaLaboratorio telaBuscaLaboratorio) {
        this.telaBuscaLaboratorio = telaBuscaLaboratorio;
        this.telaBuscaLaboratorio.getCarregarButton().addActionListener(this);
        this.telaBuscaLaboratorio.getFecharButton().addActionListener(this);
        this.telaBuscaLaboratorio.getButtonFiltrar().addActionListener(this);
        this.telaBuscaLaboratorio.getEditarButton().addActionListener(this);
        this.telaBuscaLaboratorio.getExcluirButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == this.telaBuscaLaboratorio.getCarregarButton()) {
            loadTableData();
        } else if (evento.getSource() == this.telaBuscaLaboratorio.getFecharButton()) {
            this.telaBuscaLaboratorio.dispose();
        } else if (evento.getSource() == this.telaBuscaLaboratorio.getButtonFiltrar()) {
            filterTableData();
        } else if (evento.getSource() == this.telaBuscaLaboratorio.getEditarButton()) {
            editSelectedRecord();
        } else if (evento.getSource() == this.telaBuscaLaboratorio.getExcluirButton()) {
            deleteSelectedRecord();
        }
    }

    private void loadTableData() {
        DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaLaboratorio.getJTableDados().getModel();
        tabela.setRowCount(0);
        for (Laboratorio laboratorio : ServiceLaboratorio.ler()) {
            addRowToTable(tabela, laboratorio);
        }
    }

    private void filterTableData() {
        if (this.telaBuscaLaboratorio.getValorField().getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha o campo de busca");
            this.telaBuscaLaboratorio.getValorField().requestFocus();
            return;
        }

        DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaLaboratorio.getJTableDados().getModel();
        tabela.setRowCount(0);
        String filtro = this.telaBuscaLaboratorio.getValorField().getText();

        if (this.telaBuscaLaboratorio.getFiltroComboBox().getSelectedItem().equals("ID")) {
            try {
                Laboratorio laboratorio = ServiceLaboratorio.ler(Integer.parseInt(filtro));
                if (laboratorio != null) {
                    addRowToTable(tabela, laboratorio);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "ID deve ser um número");
            }
        } else {
            String campo = getCampoFiltro(this.telaBuscaLaboratorio.getFiltroComboBox().getSelectedItem().toString());
            for (Laboratorio laboratorio : ServiceLaboratorio.ler(filtro, campo)) {
                addRowToTable(tabela, laboratorio);
            }
        }
    }

    private void editSelectedRecord() {
        int linhaSelecionada = this.telaBuscaLaboratorio.getJTableDados().getSelectedRow();
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(null, "Selecione um registro para editar");
            return;
        }

        int id = (int) this.telaBuscaLaboratorio.getJTableDados().getValueAt(linhaSelecionada, 0);
        Laboratorio laboratorio = ServiceLaboratorio.ler(id);
        if (laboratorio == null) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar o laboratório");
            return;
        }

        TelaCadastroLaboratorio telaCadastro = new TelaCadastroLaboratorio(null, true);

        // Preenche os campos
        telaCadastro.getIdField().setText(String.valueOf(laboratorio.getId()));
        telaCadastro.getNomeField().setText(laboratorio.getNomeFantasia());
        telaCadastro.getContatoField().setText(laboratorio.getContato());
        
        // Converte o status
        StatusCadastroEnum statusEnum = laboratorio.getStatus().equals("A") ? 
            StatusCadastroEnum.ATIVO : StatusCadastroEnum.INATIVO;
        telaCadastro.getjComboStatus().setSelectedItem(statusEnum);

        // Configura os campos - todos habilitados exceto ID
        telaCadastro.getIdField().setEnabled(false);
        telaCadastro.getNomeField().setEnabled(true);
        telaCadastro.getContatoField().setEnabled(true);
        telaCadastro.getjComboStatus().setEnabled(true);

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
        int linhaSelecionada = this.telaBuscaLaboratorio.getJTableDados().getSelectedRow();
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(null, "Selecione um registro para excluir");
            return;
        }

        int id = (int) this.telaBuscaLaboratorio.getJTableDados().getValueAt(linhaSelecionada, 0);
        int confirmacao = JOptionPane.showConfirmDialog(null, "Confirma a exclusão do laboratório?");
        if (confirmacao == JOptionPane.YES_OPTION) {
            if (ServiceLaboratorio.excluir(id)) {
                JOptionPane.showMessageDialog(null, "Laboratório excluído com sucesso!");
                loadTableData();
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao excluir o laboratório");
            }
        }
    }

    private void addRowToTable(DefaultTableModel tabela, Laboratorio laboratorio) {
        tabela.addRow(new Object[]{
            laboratorio.getId(),
            laboratorio.getNomeFantasia(),
            laboratorio.getContato(),
            laboratorio.getStatus()
        });
    }

    private String getCampoFiltro(String tipoFiltro) {
        switch (tipoFiltro) {
            case "DESCRIÇÃO": return "nomeFantasia";
            case "CONTATO": return "contato";
            case "STATUS": return "status";
            default: return "";
        }
    }
}

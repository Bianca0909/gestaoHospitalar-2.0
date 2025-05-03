package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bo.Paciente;
import service.ServicePaciente;
import view.TelaBuscaPaciente;
import view.TelaCadastroPaciente;
import enums.StatusCadastroEnum;
import enums.SexoEnum;
import enums.TipoSanguineoEnum;

public class ControllerBuscaPaciente implements ActionListener {
    
    TelaBuscaPaciente telaBuscaPaciente;

    public ControllerBuscaPaciente(TelaBuscaPaciente telaBuscaPaciente) {
        this.telaBuscaPaciente = telaBuscaPaciente;
        
        this.telaBuscaPaciente.getCarregarButton().addActionListener(this);
        this.telaBuscaPaciente.getFecharButton().addActionListener(this);
        this.telaBuscaPaciente.getButtonFiltrar().addActionListener(this);
        this.telaBuscaPaciente.getEditarButton().addActionListener(this);
        this.telaBuscaPaciente.getExcluirButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == this.telaBuscaPaciente.getCarregarButton()) {
            loadTableData();
        } else if (evento.getSource() == this.telaBuscaPaciente.getFecharButton()) {
            this.telaBuscaPaciente.dispose();
        } else if (evento.getSource() == this.telaBuscaPaciente.getButtonFiltrar()) {
            filterTableData();
        } else if (evento.getSource() == this.telaBuscaPaciente.getEditarButton()) {
            editSelectedRecord();
        } else if (evento.getSource() == this.telaBuscaPaciente.getExcluirButton()) {
            deleteSelectedRecord();
        }
    }

    private void loadTableData() {
        DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaPaciente.getJTableDados().getModel();
        tabela.setRowCount(0);
        for (Paciente paciente : ServicePaciente.ler()) {
            addRowToTable(tabela, paciente);
        }
    }

    private void filterTableData() {
        String filtro = this.telaBuscaPaciente.getValorField().getText().trim();
        if (filtro.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha o campo de busca");
            this.telaBuscaPaciente.getValorField().requestFocus();
            return;
        }

        DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaPaciente.getJTableDados().getModel();
        tabela.setRowCount(0);

        String tipoFiltro = this.telaBuscaPaciente.getFiltroComboBox().getSelectedItem().toString();
        if (tipoFiltro.equals("ID")) {
            try {
                Paciente paciente = ServicePaciente.ler(Integer.parseInt(filtro));
                if (paciente != null) {
                    addRowToTable(tabela, paciente);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "ID deve ser um número");
            }
        } else {
            String campo = getCampoFiltro(tipoFiltro);
            for (Paciente paciente : ServicePaciente.ler(filtro, campo)) {
                addRowToTable(tabela, paciente);
            }
        }
    }

    private void editSelectedRecord() {
        int linhaSelecionada = this.telaBuscaPaciente.getJTableDados().getSelectedRow();
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(null, "Selecione um registro para editar");
            return;
        }

        int id = (int) this.telaBuscaPaciente.getJTableDados().getValueAt(linhaSelecionada, 0);
        Paciente paciente = ServicePaciente.ler(id);
        if (paciente == null) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar o paciente");
            return;
        }

        TelaCadastroPaciente telaCadastro = new TelaCadastroPaciente(null, true);
        new ControllerCadastroPaciente(telaCadastro);
        
        // Preenche os campos com os dados do paciente
        telaCadastro.getIdField().setText(String.valueOf(paciente.getId()));
        telaCadastro.getNomeField().setText(paciente.getNome());
        telaCadastro.getNomeSocialField().setText(paciente.getNomeSocial());
        telaCadastro.getCpfField().setText(paciente.getCpfCnpj());
        telaCadastro.getRgField().setText(paciente.getRgInscricaoEstadual());
        telaCadastro.getFone1Field().setText(paciente.getFone1());
        telaCadastro.getFone2Field().setText(paciente.getFone2());
        telaCadastro.getDataCadastroField().setText(paciente.getDataCadastro());
        telaCadastro.getEmailField().setText(paciente.getEmail());
        telaCadastro.getCepField().setText(paciente.getCep());
        telaCadastro.getCidadeField().setText(paciente.getCidade());
        telaCadastro.getBairroField().setText(paciente.getBairro());
        telaCadastro.getLogradouroField().setText(paciente.getLogradouro());
        telaCadastro.getComplementoField().setText(paciente.getComplemento());
        
        // Configura os ComboBox
        telaCadastro.getSexoComboBox().setSelectedItem(SexoEnum.valueOf(paciente.getSexo()));
        telaCadastro.getTipoSanguineoComboBox().setSelectedItem(TipoSanguineoEnum.valueOf(paciente.getTipoSanguineo()));
        
        // Converte o status String para StatusCadastroEnum
        StatusCadastroEnum statusEnum = paciente.getStatus().equals("A") ? 
            StatusCadastroEnum.ATIVO : StatusCadastroEnum.INATIVO;
        telaCadastro.getStatusComboBox().setSelectedItem(statusEnum);
        
        // Configura os campos editáveis
        telaCadastro.getIdField().setEnabled(false); // ID não pode ser editado
        telaCadastro.getNomeField().setEnabled(true);
        telaCadastro.getNomeSocialField().setEnabled(true);
        telaCadastro.getCpfField().setEnabled(true);
        telaCadastro.getRgField().setEnabled(true);
        telaCadastro.getFone1Field().setEnabled(true);
        telaCadastro.getFone2Field().setEnabled(true);
        telaCadastro.getDataCadastroField().setEnabled(true);
        telaCadastro.getEmailField().setEnabled(true);
        telaCadastro.getCepField().setEnabled(true);
        telaCadastro.getCidadeField().setEnabled(true);
        telaCadastro.getBairroField().setEnabled(true);
        telaCadastro.getLogradouroField().setEnabled(true);
        telaCadastro.getComplementoField().setEnabled(true);
        telaCadastro.getSexoComboBox().setEnabled(true);
        telaCadastro.getTipoSanguineoComboBox().setEnabled(true);
        telaCadastro.getStatusComboBox().setEnabled(true);
        
        // Configura os botões
        telaCadastro.getjButtonNovo().setEnabled(false);
        telaCadastro.getjButtonCancelar().setEnabled(true);
        telaCadastro.getjButtonGravar().setEnabled(true);
        telaCadastro.getjButtonBuscar().setEnabled(false);
        telaCadastro.getjButtonSair().setEnabled(true);
        
        // Foca no campo de nome para facilitar a edição
        telaCadastro.getNomeField().requestFocus();
        
        telaCadastro.setVisible(true);
        loadTableData(); // Recarrega a tabela após a edição
    }

    private void deleteSelectedRecord() {
        int linhaSelecionada = this.telaBuscaPaciente.getJTableDados().getSelectedRow();
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(null, "Selecione um registro para excluir");
            return;
        }

        int id = (int) this.telaBuscaPaciente.getJTableDados().getValueAt(linhaSelecionada, 0);
        int confirmacao = JOptionPane.showConfirmDialog(null, "Confirma a exclusão do paciente?");
        if (confirmacao == JOptionPane.YES_OPTION) {
            if (ServicePaciente.excluir(id)) {
                JOptionPane.showMessageDialog(null, "Paciente excluído com sucesso!");
                loadTableData();
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao excluir o paciente");
            }
        }
    }

    private void addRowToTable(DefaultTableModel tabela, Paciente paciente) {
        tabela.addRow(new Object[]{
            paciente.getId(), 
            paciente.getNome(),
            paciente.getCpfCnpj(), 
            paciente.getFone1(), 
            paciente.getDataCadastro(), 
            paciente.getEmail(),
            paciente.getStatus()
        });
    }

    private String getCampoFiltro(String tipoFiltro) {
        switch (tipoFiltro) {
            case "NOME": return "nome";
            case "CPF": return "cpfCnpj";
            case "DATA NASCIMENTO": return "dataCadastro";
            case "TELEFONE": return "fone1";
            case "EMAIL": return "email";
            case "STATUS": return "status";
            default: return "";
        }
    }
}
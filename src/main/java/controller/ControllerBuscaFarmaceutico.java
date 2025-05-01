package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bo.Farmaceutico;
import service.ServiceFarmaceutico;
import view.TelaBuscaFarmaceutico;
import view.TelaCadastroFarmaceutico;
import enums.StatusCadastroEnum;

public class ControllerBuscaFarmaceutico implements ActionListener {

    TelaBuscaFarmaceutico telaBuscaFarmaceutico;
    private int codigoRetorno = 0;

    public int getCodigoRetorno() {
        return codigoRetorno;
    }

    public void setCodigoRetorno(int codigoRetorno) {
        this.codigoRetorno = codigoRetorno;
    }

    public ControllerBuscaFarmaceutico(TelaBuscaFarmaceutico telaBuscaFarmaceutico) {
        this.telaBuscaFarmaceutico = telaBuscaFarmaceutico;
        this.telaBuscaFarmaceutico.getCarregarButton().addActionListener(this);
        this.telaBuscaFarmaceutico.getButtonFechar().addActionListener(this);
        this.telaBuscaFarmaceutico.getButtonFiltrar().addActionListener(this);
        this.telaBuscaFarmaceutico.getEditarButton().addActionListener(this);
        this.telaBuscaFarmaceutico.getExcluirButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == this.telaBuscaFarmaceutico.getCarregarButton()) {
            loadTableData();
        } else if (evento.getSource() == this.telaBuscaFarmaceutico.getButtonFechar()) {
            this.telaBuscaFarmaceutico.dispose();
        } else if (evento.getSource() == this.telaBuscaFarmaceutico.getButtonFiltrar()) {
            filterTableData();
        } else if (evento.getSource() == this.telaBuscaFarmaceutico.getEditarButton()) {
            editSelectedRecord();
        } else if (evento.getSource() == this.telaBuscaFarmaceutico.getExcluirButton()) {
            deleteSelectedRecord();
        }
    }

    private void loadTableData() {
        DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaFarmaceutico.getJTableDados().getModel();
        tabela.setRowCount(0);
        for (Farmaceutico farmaceutico : ServiceFarmaceutico.ler()) {
            addRowToTable(tabela, farmaceutico);
        }
    }

    private void filterTableData() {
        String filtro = this.telaBuscaFarmaceutico.getValorField().getText().trim();
        if (filtro.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha o campo de busca");
            this.telaBuscaFarmaceutico.getValorField().requestFocus();
            return;
        }

        DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaFarmaceutico.getJTableDados().getModel();
        tabela.setRowCount(0);

        String tipoFiltro = this.telaBuscaFarmaceutico.getFiltroComboBox().getSelectedItem().toString();
        if (tipoFiltro.equals("ID")) {
            try {
                Farmaceutico farmaceutico = ServiceFarmaceutico.ler(Integer.parseInt(filtro));
                if (farmaceutico != null) {
                    addRowToTable(tabela, farmaceutico);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "ID deve ser um número");
            }
        } else {
            String campo = getCampoFiltro(tipoFiltro);
            for (Farmaceutico farmaceutico : ServiceFarmaceutico.ler(filtro, campo)) {
                addRowToTable(tabela, farmaceutico);
            }
        }
    }

    private void editSelectedRecord() {
        int linhaSelecionada = this.telaBuscaFarmaceutico.getJTableDados().getSelectedRow();
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(null, "Selecione um registro para editar");
            return;
        }

        int id = (int) this.telaBuscaFarmaceutico.getJTableDados().getValueAt(linhaSelecionada, 0);
        Farmaceutico farmaceutico = ServiceFarmaceutico.ler(id);
        if (farmaceutico == null) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar o farmacêutico");
            return;
        }

        TelaCadastroFarmaceutico telaCadastro = new TelaCadastroFarmaceutico(null, true);

        // Preenche os campos
        telaCadastro.getIdField().setText(String.valueOf(farmaceutico.getId()));
        telaCadastro.getNomeField().setText(farmaceutico.getNome());
        telaCadastro.getCrfField().setText(farmaceutico.getCrf());
        telaCadastro.getCpfField().setText(farmaceutico.getCpfCnpj());
        telaCadastro.getFone1Field().setText(farmaceutico.getFone1());
        telaCadastro.getFone2Field().setText(farmaceutico.getFone2());
        telaCadastro.getEmailField().setText(farmaceutico.getEmail());
        telaCadastro.getNomeSocialField().setText(farmaceutico.getNomeSocial());
        telaCadastro.getRgField().setText(farmaceutico.getRgInscricaoEstadual());
        telaCadastro.getDataCadastroField().setText(farmaceutico.getDataCadastro());
        telaCadastro.getCepField().setText(farmaceutico.getCep());
        telaCadastro.getCidadeField().setText(farmaceutico.getCidade());
        telaCadastro.getBairroField().setText(farmaceutico.getBairro());
        telaCadastro.getLogradouroField().setText(farmaceutico.getLogradouro());
        telaCadastro.getComplementoField().setText(farmaceutico.getComplemento());
        telaCadastro.getLoginField().setText(farmaceutico.getLogin());
        telaCadastro.getSenhaField().setText(farmaceutico.getSenha());
        
        // Converte o status
        StatusCadastroEnum statusEnum = farmaceutico.getStatus().equals("A") ? 
            StatusCadastroEnum.ATIVO : StatusCadastroEnum.INATIVO;
        telaCadastro.getStatusComboBox().setSelectedItem(statusEnum);

        // Configura os campos - todos habilitados exceto ID
        telaCadastro.getIdField().setEnabled(false);
        telaCadastro.getNomeField().setEnabled(true);
        telaCadastro.getCrfField().setEnabled(true);
        telaCadastro.getCpfField().setEnabled(true);
        telaCadastro.getFone1Field().setEnabled(true);
        telaCadastro.getFone2Field().setEnabled(true);
        telaCadastro.getEmailField().setEnabled(true);
        telaCadastro.getNomeSocialField().setEnabled(true);
        telaCadastro.getRgField().setEnabled(true);
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
        loadTableData(); // Recarrega a tabela após a edição
    }

    private void deleteSelectedRecord() {
        int linhaSelecionada = this.telaBuscaFarmaceutico.getJTableDados().getSelectedRow();
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(null, "Selecione um registro para excluir");
            return;
        }

        int id = (int) this.telaBuscaFarmaceutico.getJTableDados().getValueAt(linhaSelecionada, 0);
        int confirmacao = JOptionPane.showConfirmDialog(null, "Confirma a exclusão do farmacêutico?");
        if (confirmacao == JOptionPane.YES_OPTION) {
            if (ServiceFarmaceutico.excluir(id)) {
                JOptionPane.showMessageDialog(null, "Farmacêutico excluído com sucesso!");
                loadTableData();
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao excluir o farmacêutico");
            }
        }
    }

    private void addRowToTable(DefaultTableModel tabela, Farmaceutico farmaceutico) {
        tabela.addRow(new Object[]{
            farmaceutico.getId(),
            farmaceutico.getNome(),
            farmaceutico.getCrf(),
            farmaceutico.getCpfCnpj(),
            farmaceutico.getFone1(),
            farmaceutico.getFone2(),
            farmaceutico.getEmail(),
            farmaceutico.getNomeSocial(),
            farmaceutico.getRgInscricaoEstadual(),
            farmaceutico.getDataCadastro(),
            farmaceutico.getCep(),
            farmaceutico.getCidade(),
            farmaceutico.getBairro(),
            farmaceutico.getLogradouro(),
            farmaceutico.getComplemento(),
            farmaceutico.getLogin(),
            farmaceutico.getSenha(),
            farmaceutico.getStatus()
        });
    }

    private String getCampoFiltro(String tipoFiltro) {
        switch (tipoFiltro) {
            case "NOME": return "nome";
            case "CRF": return "crf";
            case "CPF/CNPJ": return "cpfCnpj";
            case "TELEFONE": return "fone1";
            case "EMAIL": return "email";
            case "LOGIN": return "login";
            case "STATUS": return "status";
            default: return "";
        }
    }
}

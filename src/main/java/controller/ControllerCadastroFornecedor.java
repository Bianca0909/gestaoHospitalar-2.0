package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import model.bo.Fornecedor;
import service.ServiceFornecedor;
import utilities.Utilities;
import view.TelaBuscaFornecedor;
import view.TelaCadastroFornecedor;

public class ControllerCadastroFornecedor implements ActionListener {

    TelaCadastroFornecedor telaCadastroFornecedor;

    public ControllerCadastroFornecedor(TelaCadastroFornecedor telaCadastroFornecedor) {
        this.telaCadastroFornecedor = telaCadastroFornecedor;

        this.telaCadastroFornecedor.getjButtonNovo().addActionListener(this);
        this.telaCadastroFornecedor.getjButtonBuscar().addActionListener(this);
        this.telaCadastroFornecedor.getjButtonGravar().addActionListener(this);
        this.telaCadastroFornecedor.getjButtonCancelar().addActionListener(this);
        this.telaCadastroFornecedor.getjButtonSair().addActionListener(this);

        Utilities.ativaDesativa(false, this.telaCadastroFornecedor.getjPanelBotoes());
        Utilities.limpaComponentes(false, this.telaCadastroFornecedor.getjPanelDados());
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == this.telaCadastroFornecedor.getjButtonNovo()) {
            Utilities.ativaDesativa(true, this.telaCadastroFornecedor.getjPanelBotoes());
            Utilities.limpaComponentes(true, this.telaCadastroFornecedor.getjPanelDados());
            this.telaCadastroFornecedor.getIdField().setEnabled(false);

        } else if (evento.getSource() == this.telaCadastroFornecedor.getjButtonCancelar()) {
            Utilities.ativaDesativa(false, this.telaCadastroFornecedor.getjPanelBotoes());
            Utilities.limpaComponentes(false, this.telaCadastroFornecedor.getjPanelDados());

        } else if (evento.getSource() == this.telaCadastroFornecedor.getjButtonGravar()) {
            Fornecedor fornecedor = new Fornecedor();
            fornecedor.setNome(this.telaCadastroFornecedor.getNomeField().getText());
            fornecedor.setFone1(this.telaCadastroFornecedor.getFone1Field().getText());
            fornecedor.setFone2(this.telaCadastroFornecedor.getFone2Field().getText());
            fornecedor.setEmail(this.telaCadastroFornecedor.getEmailField().getText());
            fornecedor.setCpfCnpj(this.telaCadastroFornecedor.getCpfCnpjField().getText());
            fornecedor.setRgInscricaoEstadual(this.telaCadastroFornecedor.getRgInscricaoEstadualField().getText());
            fornecedor.setDataCadastro(this.telaCadastroFornecedor.getDataCadastroField().getText());
            fornecedor.setCep(this.telaCadastroFornecedor.getCepField().getText());
            fornecedor.setCidade(this.telaCadastroFornecedor.getCidadeField().getText());
            fornecedor.setBairro(this.telaCadastroFornecedor.getBairroField().getText());
            fornecedor.setLogradouro(this.telaCadastroFornecedor.getLogradouroField().getText());
            fornecedor.setComplemento(this.telaCadastroFornecedor.getComplementoField().getText());
            fornecedor.setNomeFantasia(this.telaCadastroFornecedor.getNomeFantasiaField().getText());
            fornecedor.setContato(this.telaCadastroFornecedor.getContatoField().getText());
            fornecedor.setStatus(this.telaCadastroFornecedor.getStatusComboBox().getSelectedItem().toString().equals("ATIVO") ? "A" : "I");

            if (this.telaCadastroFornecedor.getIdField().getText().trim().equalsIgnoreCase("")) {
                ServiceFornecedor.adicionar(fornecedor);
            } else {
                fornecedor.setId(Integer.parseInt(this.telaCadastroFornecedor.getIdField().getText()));
                ServiceFornecedor.atualizar(fornecedor);
            }

            Utilities.ativaDesativa(false, this.telaCadastroFornecedor.getjPanelBotoes());
            Utilities.limpaComponentes(false, this.telaCadastroFornecedor.getjPanelDados());

        } else if (evento.getSource() == this.telaCadastroFornecedor.getjButtonBuscar()) {
            abrirBusca();
        } else if (evento.getSource() == this.telaCadastroFornecedor.getjButtonSair()) {
            this.telaCadastroFornecedor.dispose();
        }
    }

    private void abrirBusca() {
        TelaBuscaFornecedor telaBuscaFornecedor = new TelaBuscaFornecedor(new JFrame(), true);
        ControllerBuscaFornecedor controllerBuscaFornecedor = new ControllerBuscaFornecedor(telaBuscaFornecedor);
        telaBuscaFornecedor.setVisible(true);

        int codigoRetorno = controllerBuscaFornecedor.getCodigoRetorno();
        if (codigoRetorno != 0) {
            Fornecedor fornecedor = ServiceFornecedor.ler(codigoRetorno);
            if (fornecedor != null) {
                Utilities.ativaDesativa(true, this.telaCadastroFornecedor.getjPanelBotoes());
                Utilities.limpaComponentes(true, this.telaCadastroFornecedor.getjPanelDados());

                this.telaCadastroFornecedor.getIdField().setText(String.valueOf(fornecedor.getId()));
                this.telaCadastroFornecedor.getNomeField().setText(fornecedor.getNome());
                this.telaCadastroFornecedor.getFone1Field().setText(fornecedor.getFone1());
                this.telaCadastroFornecedor.getFone2Field().setText(fornecedor.getFone2());
                this.telaCadastroFornecedor.getEmailField().setText(fornecedor.getEmail());
                this.telaCadastroFornecedor.getCpfCnpjField().setText(fornecedor.getCpfCnpj());
                this.telaCadastroFornecedor.getRgInscricaoEstadualField().setText(fornecedor.getRgInscricaoEstadual());
                this.telaCadastroFornecedor.getDataCadastroField().setText(fornecedor.getDataCadastro());
                this.telaCadastroFornecedor.getCepField().setText(fornecedor.getCep());
                this.telaCadastroFornecedor.getCidadeField().setText(fornecedor.getCidade());
                this.telaCadastroFornecedor.getBairroField().setText(fornecedor.getBairro());
                this.telaCadastroFornecedor.getLogradouroField().setText(fornecedor.getLogradouro());
                this.telaCadastroFornecedor.getComplementoField().setText(fornecedor.getComplemento());
                this.telaCadastroFornecedor.getNomeFantasiaField().setText(fornecedor.getNomeFantasia());
                this.telaCadastroFornecedor.getContatoField().setText(fornecedor.getContato());

                this.telaCadastroFornecedor.getIdField().setEnabled(false);
                this.telaCadastroFornecedor.getjButtonNovo().setEnabled(false);
                this.telaCadastroFornecedor.getjButtonCancelar().setEnabled(true);
                this.telaCadastroFornecedor.getjButtonGravar().setEnabled(true);
                this.telaCadastroFornecedor.getjButtonBuscar().setEnabled(false);
                this.telaCadastroFornecedor.getjButtonSair().setEnabled(false);
                this.telaCadastroFornecedor.getNomeField().requestFocus();
            }
        }
    }
}

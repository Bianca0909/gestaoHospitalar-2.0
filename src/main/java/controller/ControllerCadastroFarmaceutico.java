package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import model.bo.Farmaceutico;
import service.ServiceFarmaceutico;
import utilities.Utilities;
import view.TelaBuscaFarmaceutico;
import view.TelaCadastroFarmaceutico;

public class ControllerCadastroFarmaceutico implements ActionListener {

    TelaCadastroFarmaceutico telaCadastroFarmaceutico;
    
    public ControllerCadastroFarmaceutico(TelaCadastroFarmaceutico telaCadastroFarmaceutico) {
        this.telaCadastroFarmaceutico = telaCadastroFarmaceutico;

        this.telaCadastroFarmaceutico.getjButtonNovo().addActionListener(this);
        this.telaCadastroFarmaceutico.getjButtonBuscar().addActionListener(this);
        this.telaCadastroFarmaceutico.getjButtonGravar().addActionListener(this);
        this.telaCadastroFarmaceutico.getjButtonCancelar().addActionListener(this);
        this.telaCadastroFarmaceutico.getjButtonSair().addActionListener(this);

        Utilities.ativaDesativa(false, this.telaCadastroFarmaceutico.getjPanelBotoes());
        Utilities.limpaComponentes(false, this.telaCadastroFarmaceutico.getjPanelDados());
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        
         if (evento.getSource() == this.telaCadastroFarmaceutico.getjButtonNovo()) {
            Utilities.ativaDesativa(true, this.telaCadastroFarmaceutico.getjPanelBotoes());
            Utilities.limpaComponentes(true, this.telaCadastroFarmaceutico.getjPanelDados());
            this.telaCadastroFarmaceutico.getIdField().setEnabled(false);

        } else if (evento.getSource() == this.telaCadastroFarmaceutico.getjButtonCancelar()) {
            Utilities.ativaDesativa(false, this.telaCadastroFarmaceutico.getjPanelBotoes());
            Utilities.limpaComponentes(false, this.telaCadastroFarmaceutico.getjPanelDados());

        } else if (evento.getSource() == this.telaCadastroFarmaceutico.getjButtonGravar()) {

            Farmaceutico farmaceutico = new Farmaceutico();
            farmaceutico.setNome(this.telaCadastroFarmaceutico.getNomeField().getText());
            farmaceutico.setDataCadastro(this.telaCadastroFarmaceutico.getDataCadastroField().getText());
            farmaceutico.setNomeSocial(this.telaCadastroFarmaceutico.getNomeSocialField().getText());
            farmaceutico.setCpfCnpj(this.telaCadastroFarmaceutico.getCpfField().getText());
            farmaceutico.setRgInscricaoEstadual(this.telaCadastroFarmaceutico.getRgField().getText());
            farmaceutico.setFone1(this.telaCadastroFarmaceutico.getFone1Field().getText());
            farmaceutico.setFone2(this.telaCadastroFarmaceutico.getFone2Field().getText());
            farmaceutico.setEmail(this.telaCadastroFarmaceutico.getEmailField().getText());
            farmaceutico.setCep(this.telaCadastroFarmaceutico.getCepField().getText());
            farmaceutico.setCidade(this.telaCadastroFarmaceutico.getCidadeField().getText());
            farmaceutico.setBairro(this.telaCadastroFarmaceutico.getBairroField().getText());
            farmaceutico.setLogradouro(this.telaCadastroFarmaceutico.getLogradouroField().getText());
            farmaceutico.setComplemento(this.telaCadastroFarmaceutico.getComplementoField().getText());
            farmaceutico.setCrf(this.telaCadastroFarmaceutico.getCrfField().getText());
            farmaceutico.setSenha(this.telaCadastroFarmaceutico.getSenhaField().getText());
            farmaceutico.setLogin(this.telaCadastroFarmaceutico.getLoginField().getText());
            farmaceutico.setNomeSocial(this.telaCadastroFarmaceutico.getNomeSocialField().getText());
            farmaceutico.setStatus(this.telaCadastroFarmaceutico.getStatusComboBox().getSelectedItem().toString());
            
            if (this.telaCadastroFarmaceutico.getIdField().getText().equals("")) {
                ServiceFarmaceutico.adicionar(farmaceutico);
            } else {
                farmaceutico.setId(Integer.parseInt(this.telaCadastroFarmaceutico.getIdField().getText()));
                ServiceFarmaceutico.atualizar(farmaceutico);
            }
            
            Utilities.ativaDesativa(false, this.telaCadastroFarmaceutico.getjPanelBotoes());
            Utilities.limpaComponentes(false, this.telaCadastroFarmaceutico.getjPanelDados());

        } else if (evento.getSource() == this.telaCadastroFarmaceutico.getjButtonBuscar()) {

            TelaBuscaFarmaceutico telaBuscaFarmaceutico = new TelaBuscaFarmaceutico(new JFrame(), true);
            ControllerBuscaFarmaceutico controllerBuscaFarmaceutico = new ControllerBuscaFarmaceutico(telaBuscaFarmaceutico);
            telaBuscaFarmaceutico.setVisible(true);

            int codigo = controllerBuscaFarmaceutico.getCodigoRetorno();
            if (codigo != 0) {
                Farmaceutico farmaceutico = ServiceFarmaceutico.ler(codigo);

                if (farmaceutico != null) {
                    Utilities.ativaDesativa(true, this.telaCadastroFarmaceutico.getjPanelBotoes());
                    Utilities.limpaComponentes(true, this.telaCadastroFarmaceutico.getjPanelDados());

                    this.telaCadastroFarmaceutico.getIdField().setText(farmaceutico.getId() + "");
                    this.telaCadastroFarmaceutico.getNomeField().setText(farmaceutico.getNome());
                    this.telaCadastroFarmaceutico.getNomeSocialField().setText(farmaceutico.getNomeSocial());
                    this.telaCadastroFarmaceutico.getFone1Field().setText(farmaceutico.getFone1());
                    this.telaCadastroFarmaceutico.getFone2Field().setText(farmaceutico.getFone2());
                    this.telaCadastroFarmaceutico.getEmailField().setText(farmaceutico.getEmail());
                    this.telaCadastroFarmaceutico.getCpfField().setText(farmaceutico.getCpfCnpj());
                    this.telaCadastroFarmaceutico.getRgField().setText(farmaceutico.getRgInscricaoEstadual());
                    this.telaCadastroFarmaceutico.getDataCadastroField().setText(farmaceutico.getDataCadastro());
                    this.telaCadastroFarmaceutico.getCepField().setText(farmaceutico.getCep());
                    this.telaCadastroFarmaceutico.getCidadeField().setText(farmaceutico.getCidade());
                    this.telaCadastroFarmaceutico.getBairroField().setText(farmaceutico.getBairro());
                    this.telaCadastroFarmaceutico.getLogradouroField().setText(farmaceutico.getLogradouro());
                    this.telaCadastroFarmaceutico.getComplementoField().setText(farmaceutico.getComplemento());
                    this.telaCadastroFarmaceutico.getCrfField().setText(farmaceutico.getCrf());
                    this.telaCadastroFarmaceutico.getLoginField().setText(farmaceutico.getLogin());
                    this.telaCadastroFarmaceutico.getSenhaField().setText(farmaceutico.getSenha());

                    this.telaCadastroFarmaceutico.getIdField().setEnabled(false);
                    this.telaCadastroFarmaceutico.getNomeField().requestFocus();
                }
            }
        } else if (evento.getSource() == this.telaCadastroFarmaceutico.getjButtonSair()) {
            this.telaCadastroFarmaceutico.dispose();
        }
    }

}

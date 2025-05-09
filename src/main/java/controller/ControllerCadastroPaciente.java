package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.bo.Paciente;
import utilities.Utilities;
import view.TelaBuscaPaciente;
import view.TelaCadastroPaciente;
import enums.SexoEnum;
import enums.TipoSanguineoEnum;

public class ControllerCadastroPaciente implements ActionListener {
    
    public static int codigo;
    
    TelaCadastroPaciente telaCadastroPaciente;
    
    public ControllerCadastroPaciente(TelaCadastroPaciente telaCadastroPaciente) {
        this.telaCadastroPaciente = telaCadastroPaciente;

        this.telaCadastroPaciente.getjButtonNovo().addActionListener(this);
        this.telaCadastroPaciente.getjButtonBuscar().addActionListener(this);
        this.telaCadastroPaciente.getjButtonGravar().addActionListener(this);
        this.telaCadastroPaciente.getjButtonCancelar().addActionListener(this);
        this.telaCadastroPaciente.getjButtonSair().addActionListener(this);

        Utilities.ativaDesativa(false, this.telaCadastroPaciente.getjPanelBotoes());
        Utilities.limpaComponentes(false, this.telaCadastroPaciente.getjPanelDados());
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {

        if (evento.getSource() == this.telaCadastroPaciente.getjButtonNovo()) {
            Utilities.ativaDesativa(true, this.telaCadastroPaciente.getjPanelBotoes());
            Utilities.limpaComponentes(true, this.telaCadastroPaciente.getjPanelDados());
            this.telaCadastroPaciente.getIdField().setEnabled(false);

        } else if (evento.getSource() == this.telaCadastroPaciente.getjButtonCancelar()) {
            Utilities.ativaDesativa(false, this.telaCadastroPaciente.getjPanelBotoes());
            Utilities.limpaComponentes(false, this.telaCadastroPaciente.getjPanelDados());

        } else if (evento.getSource() == this.telaCadastroPaciente.getjButtonGravar()) {

            Paciente paciente = new Paciente();
            paciente.setNome(this.telaCadastroPaciente.getNomeField().getText());
            paciente.setDataCadastro(this.telaCadastroPaciente.getDataCadastroField().getText());
            paciente.setNomeSocial(this.telaCadastroPaciente.getNomeSocialField().getText());
            paciente.setCpfCnpj(this.telaCadastroPaciente.getCpfField().getText());
            paciente.setRgInscricaoEstadual(this.telaCadastroPaciente.getRgField().getText());
            paciente.setSexo(((SexoEnum)this.telaCadastroPaciente.getSexoComboBox().getSelectedItem()).name());
            paciente.setTipoSanguineo(((TipoSanguineoEnum)this.telaCadastroPaciente.getTipoSanguineoComboBox().getSelectedItem()).name());
            paciente.setFone1(this.telaCadastroPaciente.getFone1Field().getText());
            paciente.setFone2(this.telaCadastroPaciente.getFone2Field().getText());
            paciente.setEmail(this.telaCadastroPaciente.getEmailField().getText());
            paciente.setCep(this.telaCadastroPaciente.getCepField().getText());
            paciente.setCidade(this.telaCadastroPaciente.getCidadeField().getText());
            paciente.setBairro(this.telaCadastroPaciente.getBairroField().getText());
            paciente.setLogradouro(this.telaCadastroPaciente.getLogradouroField().getText());
            paciente.setComplemento(this.telaCadastroPaciente.getComplementoField().getText());
            paciente.setStatus(this.telaCadastroPaciente.getStatusComboBox().getSelectedItem().toString());
            
            if (this.telaCadastroPaciente.getIdField().getText().equals("")) {
                service.ServicePaciente.adicionar(paciente);
            } else {
                paciente.setId(Integer.parseInt(this.telaCadastroPaciente.getIdField().getText()));
                service.ServicePaciente.atualizar(paciente);
            }

            Utilities.ativaDesativa(false, this.telaCadastroPaciente.getjPanelBotoes());
            Utilities.limpaComponentes(false, this.telaCadastroPaciente.getjPanelDados());

        } else if (evento.getSource() == this.telaCadastroPaciente.getjButtonBuscar()) {
            codigo = 0;
            TelaBuscaPaciente telaBuscaPaciente = new TelaBuscaPaciente(null, true);
            new ControllerBuscaPaciente(telaBuscaPaciente); 
            telaBuscaPaciente.setVisible(true);
            
            if (codigo != 0) {
                Paciente paciente = service.ServicePaciente.ler(codigo);
                
                Utilities.ativaDesativa(true, this.telaCadastroPaciente.getjPanelBotoes());
                Utilities.limpaComponentes(true, this.telaCadastroPaciente.getjPanelDados());
                
                this.telaCadastroPaciente.getIdField().setText(paciente.getId() + "");
                this.telaCadastroPaciente.getNomeField().setText(paciente.getNome());
                this.telaCadastroPaciente.getNomeSocialField().setText(paciente.getNomeSocial());
                this.telaCadastroPaciente.getFone1Field().setText(paciente.getFone1());
                this.telaCadastroPaciente.getFone2Field().setText(paciente.getFone2());
                this.telaCadastroPaciente.getEmailField().setText(paciente.getEmail());
                this.telaCadastroPaciente.getCpfField().setText(paciente.getCpfCnpj());
                this.telaCadastroPaciente.getDataCadastroField().setText(paciente.getDataCadastro());
                this.telaCadastroPaciente.getCepField().setText(paciente.getCep());
                this.telaCadastroPaciente.getCidadeField().setText(paciente.getCidade());
                this.telaCadastroPaciente.getBairroField().setText(paciente.getBairro());
                this.telaCadastroPaciente.getLogradouroField().setText(paciente.getLogradouro());
                this.telaCadastroPaciente.getComplementoField().setText(paciente.getComplemento());
                this.telaCadastroPaciente.getSexoComboBox().setSelectedItem(SexoEnum.valueOf(paciente.getSexo()));
                this.telaCadastroPaciente.getTipoSanguineoComboBox().setSelectedItem(TipoSanguineoEnum.valueOf(paciente.getTipoSanguineo()));
                
                this.telaCadastroPaciente.getIdField().setEnabled(false);
                this.telaCadastroPaciente.getNomeField().requestFocus();
            }

        } else if (evento.getSource() == this.telaCadastroPaciente.getjButtonSair()) {
            this.telaCadastroPaciente.dispose();
        }
    }
}

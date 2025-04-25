package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.bo.Acompanhante;
import utilities.Utilities;
import view.TelaBuscaAcompanhante;
import view.TelaCadastroAcompanhante;

public class ControllerCadastroAcompanhante implements ActionListener {
    
    public static int codigo;
    
    TelaCadastroAcompanhante telaCadastroAcompanhante;
    
    public ControllerCadastroAcompanhante(TelaCadastroAcompanhante telaCadastroAcompanhante) {
        this.telaCadastroAcompanhante = telaCadastroAcompanhante;
        
        this.telaCadastroAcompanhante.getjButtonNovo().addActionListener(this);
        this.telaCadastroAcompanhante.getjButtonBuscar().addActionListener(this);
        this.telaCadastroAcompanhante.getjButtonGravar().addActionListener(this);
        this.telaCadastroAcompanhante.getjButtonCancelar().addActionListener(this);
        this.telaCadastroAcompanhante.getjButtonSair().addActionListener(this);
        
        Utilities.ativaDesativa(false, this.telaCadastroAcompanhante.getjPanelBotoes());
        Utilities.limpaComponentes(false, this.telaCadastroAcompanhante.getjPanelDados());
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == this.telaCadastroAcompanhante.getjButtonNovo()) {
            Utilities.ativaDesativa(true, this.telaCadastroAcompanhante.getjPanelBotoes());
            Utilities.limpaComponentes(true, this.telaCadastroAcompanhante.getjPanelDados());
            this.telaCadastroAcompanhante.getIdField().setEnabled(false);
            
        } else if (evento.getSource() == this.telaCadastroAcompanhante.getjButtonCancelar()) {
            Utilities.ativaDesativa(false, this.telaCadastroAcompanhante.getjPanelBotoes());
            Utilities.limpaComponentes(false, this.telaCadastroAcompanhante.getjPanelDados());
            
        } else if (evento.getSource() == this.telaCadastroAcompanhante.getjButtonGravar()) {
            Acompanhante acompanhante = new Acompanhante();
            
            acompanhante.setNome(this.telaCadastroAcompanhante.getNomeField().getText());
            acompanhante.setEmail(this.telaCadastroAcompanhante.getEmailField().getText());
            acompanhante.setCpfCnpj(this.telaCadastroAcompanhante.getCpfCnpjField().getText());
            acompanhante.setFone1(this.telaCadastroAcompanhante.getFone1Field().getText());
            acompanhante.setGrauParentesco(this.telaCadastroAcompanhante.getGrauParentescoField().getText());
            acompanhante.setStatus(this.telaCadastroAcompanhante.getStatusComboBox().getSelectedItem() + "");
            
            if (this.telaCadastroAcompanhante.getIdField().getText().equals("")) {
                service.ServiceAcompanhante.adicionar(acompanhante);
            } else {
                acompanhante.setId(Integer.parseInt(this.telaCadastroAcompanhante.getIdField().getText()));
                service.ServiceAcompanhante.atualizar(acompanhante);
            }
            
            Utilities.ativaDesativa(false, this.telaCadastroAcompanhante.getjPanelBotoes());
            Utilities.limpaComponentes(false, this.telaCadastroAcompanhante.getjPanelDados());
            
        } else if (evento.getSource() == this.telaCadastroAcompanhante.getjButtonBuscar()) {
            codigo = 0;
            TelaBuscaAcompanhante telaBuscaAcompanhante = new TelaBuscaAcompanhante(null, true);
            new ControllerBuscaAcompanhante(telaBuscaAcompanhante);
            telaBuscaAcompanhante.setVisible(true);
            
            if (codigo != 0) {
                Acompanhante acompanhante = service.ServiceAcompanhante.ler(codigo);
                
                Utilities.ativaDesativa(true, this.telaCadastroAcompanhante.getjPanelBotoes());
                Utilities.limpaComponentes(true, this.telaCadastroAcompanhante.getjPanelDados());
                
                this.telaCadastroAcompanhante.getIdField().setText(acompanhante.getId() + "");
                this.telaCadastroAcompanhante.getNomeField().setText(acompanhante.getNome());
                this.telaCadastroAcompanhante.getEmailField().setText(acompanhante.getEmail());
                this.telaCadastroAcompanhante.getCpfCnpjField().setText(acompanhante.getCpfCnpj());
                this.telaCadastroAcompanhante.getFone1Field().setText(acompanhante.getFone1());
                this.telaCadastroAcompanhante.getGrauParentescoField().setText(acompanhante.getGrauParentesco());
                this.telaCadastroAcompanhante.getStatusComboBox().setSelectedItem(acompanhante.getStatus());
                
                this.telaCadastroAcompanhante.getIdField().setEnabled(false);
                this.telaCadastroAcompanhante.getNomeField().requestFocus();
            }
            
        } else if (evento.getSource() == this.telaCadastroAcompanhante.getjButtonSair()) {
            this.telaCadastroAcompanhante.dispose();
        }
    }
}

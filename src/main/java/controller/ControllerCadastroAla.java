package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.bo.Ala;
import utilities.Utilities;
import view.TelaBuscaAla;
import view.TelaCadastroAla;

public class ControllerCadastroAla implements ActionListener {
    
    public static int codigo;
    
    TelaCadastroAla telaCadastroAla;
    
    public ControllerCadastroAla(TelaCadastroAla telaCadastroAla) {
        this.telaCadastroAla = telaCadastroAla;
        
        this.telaCadastroAla.getjButtonNovo().addActionListener(this);
        this.telaCadastroAla.getjButtonBuscar().addActionListener(this);
        this.telaCadastroAla.getjButtonGravar().addActionListener(this);
        this.telaCadastroAla.getjButtonCancelar().addActionListener(this);
        this.telaCadastroAla.getjButtonSair().addActionListener(this);
        
        Utilities.ativaDesativa(false, this.telaCadastroAla.getjPanelBotoes());
        Utilities.limpaComponentes(false, this.telaCadastroAla.getjPanelDados());
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == this.telaCadastroAla.getjButtonNovo()) {
            Utilities.ativaDesativa(true, this.telaCadastroAla.getjPanelBotoes());
            Utilities.limpaComponentes(true, this.telaCadastroAla.getjPanelDados());
            this.telaCadastroAla.getIdField().setEnabled(false);
            
        } else if (evento.getSource() == this.telaCadastroAla.getjButtonCancelar()) {
            Utilities.ativaDesativa(false, this.telaCadastroAla.getjPanelBotoes());
            Utilities.limpaComponentes(false, this.telaCadastroAla.getjPanelDados());
            
        } else if (evento.getSource() == this.telaCadastroAla.getjButtonGravar()) {
            Ala ala = new Ala();
            
            ala.setDescricao(this.telaCadastroAla.getDescricaoField().getText());
            
            if (this.telaCadastroAla.getIdField().getText().equals("")) {
                service.ServiceAla.adicionar(ala);
            } else {
                ala.setId(Integer.parseInt(this.telaCadastroAla.getIdField().getText()));
                service.ServiceAla.atualizar(ala);
            }
            
            Utilities.ativaDesativa(false, this.telaCadastroAla.getjPanelBotoes());
            Utilities.limpaComponentes(false, this.telaCadastroAla.getjPanelDados());
            
        } else if (evento.getSource() == this.telaCadastroAla.getjButtonBuscar()) {
            codigo = 0;
            TelaBuscaAla telaBuscaAla = new TelaBuscaAla(null, true);
            new ControllerBuscaAla(telaBuscaAla);
            telaBuscaAla.setVisible(true);
            
            if (codigo != 0) {
                Ala ala = service.ServiceAla.ler(codigo);
                
                Utilities.ativaDesativa(true, this.telaCadastroAla.getjPanelBotoes());
                Utilities.limpaComponentes(true, this.telaCadastroAla.getjPanelDados());
                
                this.telaCadastroAla.getIdField().setText(ala.getId() + "");
                this.telaCadastroAla.getDescricaoField().setText(ala.getDescricao());
                
                this.telaCadastroAla.getIdField().setEnabled(false);
                this.telaCadastroAla.getNomeField().requestFocus();
            }
            
        } else if (evento.getSource() == this.telaCadastroAla.getjButtonSair()) {
            this.telaCadastroAla.dispose();
        }
    }
}

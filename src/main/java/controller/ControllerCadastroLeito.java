package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.bo.Leito;
import model.bo.Quarto;
import service.ServiceLeito;
import view.TelaCadastroLeito;
import enums.StatusCadastroEnum;

public class ControllerCadastroLeito implements ActionListener {
    
    private TelaCadastroLeito telaCadastroLeito;
    
    public ControllerCadastroLeito(TelaCadastroLeito telaCadastroLeito) {
        this.telaCadastroLeito = telaCadastroLeito;
        
        this.telaCadastroLeito.getjButtonNovo().addActionListener(this);
        this.telaCadastroLeito.getjButtonCancelar().addActionListener(this);
        this.telaCadastroLeito.getjButtonGravar().addActionListener(this);
        this.telaCadastroLeito.getjButtonBuscar().addActionListener(this);
        this.telaCadastroLeito.getjButtonSair().addActionListener(this);
        
        // Inicia com os campos desabilitados
        this.telaCadastroLeito.getIdField().setEnabled(false);
        this.telaCadastroLeito.getDescricaoField().setEnabled(false);
        this.telaCadastroLeito.getStatusComboBox().setEnabled(false);
        this.telaCadastroLeito.getQuartoComboBox().setEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == this.telaCadastroLeito.getjButtonNovo()) {
            this.telaCadastroLeito.getIdField().setEnabled(false);
            this.telaCadastroLeito.getDescricaoField().setEnabled(true);
            this.telaCadastroLeito.getStatusComboBox().setEnabled(true);
            this.telaCadastroLeito.getQuartoComboBox().setEnabled(true);
            
            this.telaCadastroLeito.getjButtonNovo().setEnabled(false);
            this.telaCadastroLeito.getjButtonCancelar().setEnabled(true);
            this.telaCadastroLeito.getjButtonGravar().setEnabled(true);
            this.telaCadastroLeito.getjButtonBuscar().setEnabled(false);
            this.telaCadastroLeito.getjButtonSair().setEnabled(false);
            
            this.telaCadastroLeito.getDescricaoField().requestFocus();
            
            // Limpa os campos ao clicar em novo
            this.telaCadastroLeito.getIdField().setText("");
            this.telaCadastroLeito.getDescricaoField().setText("");
            this.telaCadastroLeito.getStatusComboBox().setSelectedItem(StatusCadastroEnum.ATIVO);
            this.telaCadastroLeito.getQuartoComboBox().setSelectedIndex(-1);
            
        } else if (evento.getSource() == this.telaCadastroLeito.getjButtonCancelar()) {
            this.telaCadastroLeito.getIdField().setEnabled(false);
            this.telaCadastroLeito.getDescricaoField().setEnabled(false);
            this.telaCadastroLeito.getStatusComboBox().setEnabled(false);
            this.telaCadastroLeito.getQuartoComboBox().setEnabled(false);
            
            this.telaCadastroLeito.getjButtonNovo().setEnabled(true);
            this.telaCadastroLeito.getjButtonCancelar().setEnabled(false);
            this.telaCadastroLeito.getjButtonGravar().setEnabled(false);
            this.telaCadastroLeito.getjButtonBuscar().setEnabled(true);
            this.telaCadastroLeito.getjButtonSair().setEnabled(true);
            
            this.telaCadastroLeito.getIdField().requestFocus();
            
            this.telaCadastroLeito.getIdField().setText("");
            this.telaCadastroLeito.getDescricaoField().setText("");
            this.telaCadastroLeito.getStatusComboBox().setSelectedItem(StatusCadastroEnum.ATIVO);
            this.telaCadastroLeito.getQuartoComboBox().setSelectedIndex(-1);
            
        } else if (evento.getSource() == this.telaCadastroLeito.getjButtonGravar()) {
            if (this.telaCadastroLeito.getDescricaoField().getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "Descrição é obrigatória!");
                this.telaCadastroLeito.getDescricaoField().requestFocus();
                
            } else if (this.telaCadastroLeito.getQuartoComboBox().getSelectedItem() == null) {
                JOptionPane.showMessageDialog(null, "Quarto é obrigatório!");
                this.telaCadastroLeito.getQuartoComboBox().requestFocus();
                
            } else {
                Leito leito = new Leito();
                leito.setDescricao(this.telaCadastroLeito.getDescricaoField().getText());
                
                StatusCadastroEnum statusEnum = (StatusCadastroEnum) this.telaCadastroLeito.getStatusComboBox().getSelectedItem();
                leito.setStatus(statusEnum == StatusCadastroEnum.ATIVO ? "A" : "I");
                
                // Associa o quarto selecionado ao leito
                Quarto quartoSelecionado = (Quarto) this.telaCadastroLeito.getQuartoComboBox().getSelectedItem();
                leito.setQuarto(quartoSelecionado);
                
                // Se tem ID é atualização
                if (!this.telaCadastroLeito.getIdField().getText().equals("")) {
                    leito.setId(Integer.parseInt(this.telaCadastroLeito.getIdField().getText()));
                    ServiceLeito.atualizar(leito);
                } else {
                    ServiceLeito.adicionar(leito);
                }
                
                // Após gravar, mantém o ID desabilitado
                this.telaCadastroLeito.getIdField().setEnabled(false);
                this.telaCadastroLeito.getDescricaoField().setEnabled(false);
                this.telaCadastroLeito.getStatusComboBox().setEnabled(false);
                this.telaCadastroLeito.getQuartoComboBox().setEnabled(false);
                
                this.telaCadastroLeito.getjButtonNovo().setEnabled(true);
                this.telaCadastroLeito.getjButtonCancelar().setEnabled(false);
                this.telaCadastroLeito.getjButtonGravar().setEnabled(false);
                this.telaCadastroLeito.getjButtonBuscar().setEnabled(true);
                this.telaCadastroLeito.getjButtonSair().setEnabled(true);
                
                this.telaCadastroLeito.getIdField().requestFocus();
                
                this.telaCadastroLeito.getIdField().setText("");
                this.telaCadastroLeito.getDescricaoField().setText("");
                this.telaCadastroLeito.getStatusComboBox().setSelectedItem(StatusCadastroEnum.ATIVO);
                this.telaCadastroLeito.getQuartoComboBox().setSelectedIndex(-1);
            }
            
        } else if (evento.getSource() == this.telaCadastroLeito.getjButtonBuscar()) {
            this.telaCadastroLeito.dispose();
            
        } else if (evento.getSource() == this.telaCadastroLeito.getjButtonSair()) {
            this.telaCadastroLeito.dispose();
        }
    }
}

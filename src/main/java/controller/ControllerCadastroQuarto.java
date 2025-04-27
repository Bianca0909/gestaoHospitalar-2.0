package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.bo.Ala;
import model.bo.Quarto;
import utilities.Utilities;
import view.TelaBuscaQuarto;
import view.TelaCadastroQuarto;
import enums.StatusCadastroEnum;
import service.ServiceQuarto;
import javax.persistence.PersistenceException;
import javax.swing.JOptionPane;

public class ControllerCadastroQuarto implements ActionListener {

    private TelaCadastroQuarto telaCadastroQuarto;
    public static int codigo;
    
    public ControllerCadastroQuarto(TelaCadastroQuarto telaCadastroQuarto) {
        this.telaCadastroQuarto = telaCadastroQuarto;
        
        this.telaCadastroQuarto.getjButtonNovo().addActionListener(this);
        this.telaCadastroQuarto.getjButtonBuscar().addActionListener(this);
        this.telaCadastroQuarto.getjButtonGravar().addActionListener(this);
        this.telaCadastroQuarto.getjButtonCancelar().addActionListener(this);
        this.telaCadastroQuarto.getjButtonSair().addActionListener(this);

        Utilities.ativaDesativa(false, this.telaCadastroQuarto.getjPanelBotoes());
        Utilities.limpaComponentes(false, this.telaCadastroQuarto.getjPanelDados());
    }
      
    @Override
    public void actionPerformed(ActionEvent evento) {
         if (evento.getSource() == this.telaCadastroQuarto.getjButtonNovo()) {
            Utilities.ativaDesativa(true, this.telaCadastroQuarto.getjPanelBotoes());
            Utilities.limpaComponentes(true, this.telaCadastroQuarto.getjPanelDados());
            this.telaCadastroQuarto.getIdField().setEnabled(false);

        } else if (evento.getSource() == this.telaCadastroQuarto.getjButtonCancelar()) {
            Utilities.ativaDesativa(false, this.telaCadastroQuarto.getjPanelBotoes());
            Utilities.limpaComponentes(false, this.telaCadastroQuarto.getjPanelDados());

        } else if (evento.getSource() == this.telaCadastroQuarto.getjButtonGravar()) {
            try {
                Quarto quarto = new Quarto();

                quarto.setNumero(this.telaCadastroQuarto.getNumeroField().getText());
                quarto.setDescricao(this.telaCadastroQuarto.getDescricaoField().getText());
                quarto.setStatus(this.telaCadastroQuarto.getStatusComboBox().getSelectedItem().toString());
                
                Ala alaSelecionada = (Ala) this.telaCadastroQuarto.getAlaComboBox().getSelectedItem();
                quarto.setAla(alaSelecionada);
                
                if (this.telaCadastroQuarto.getIdField().getText().equals("")) {
                    ServiceQuarto.adicionar(quarto);
                    JOptionPane.showMessageDialog(null, "Quarto adicionado com sucesso!");
                } else {
                    quarto.setId(Integer.parseInt(this.telaCadastroQuarto.getIdField().getText()));
                    ServiceQuarto.atualizar(quarto);
                    JOptionPane.showMessageDialog(null, "Quarto atualizado com sucesso!");
                }

                Utilities.ativaDesativa(false, this.telaCadastroQuarto.getjPanelBotoes());
                Utilities.limpaComponentes(false, this.telaCadastroQuarto.getjPanelDados());
            } catch (PersistenceException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao salvar o quarto: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro inesperado: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }

        } else if (evento.getSource() == this.telaCadastroQuarto.getjButtonBuscar()) {
            codigo = 0;
            TelaBuscaQuarto telaBuscaQuarto = new TelaBuscaQuarto(null, true);
            new ControllerBuscaQuarto(telaBuscaQuarto);
            telaBuscaQuarto.setVisible(true);

            if (codigo != 0) {
                try {
                    Quarto quarto = ServiceQuarto.ler(codigo);

                    Utilities.ativaDesativa(true, this.telaCadastroQuarto.getjPanelBotoes());
                    Utilities.limpaComponentes(true, this.telaCadastroQuarto.getjPanelDados());

                    this.telaCadastroQuarto.getIdField().setText(quarto.getId() + "");
                    this.telaCadastroQuarto.getNumeroField().setText(quarto.getNumero());
                    this.telaCadastroQuarto.getDescricaoField().setText(quarto.getDescricao());
                    this.telaCadastroQuarto.getStatusComboBox().setSelectedItem(StatusCadastroEnum.valueOf(quarto.getStatus()));
                    this.telaCadastroQuarto.getAlaComboBox().setSelectedItem(quarto.getAla());
                    
                    this.telaCadastroQuarto.getIdField().setEnabled(false);
                    this.telaCadastroQuarto.getDescricaoField().requestFocus();
                } catch (PersistenceException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao carregar o quarto: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro inesperado: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }

        } else if (evento.getSource() == this.telaCadastroQuarto.getjButtonSair()) {
            this.telaCadastroQuarto.dispose();
        }
    }
}

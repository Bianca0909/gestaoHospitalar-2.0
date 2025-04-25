package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.bo.Ala;
import model.bo.Quarto;
import utilities.Utilities;
import view.TelaBuscaQuarto;
import view.TelaCadastroQuarto;
import enums.StatusCadastroEnum;

public class ControllerCadastroQuarto implements ActionListener {

    TelaCadastroQuarto telaCadastroQuarto;
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

            Quarto quarto = new Quarto();

            quarto.setDescricao(this.telaCadastroQuarto.getDescricaoField().getText());
            quarto.setStatus(this.telaCadastroQuarto.getStatusComboBox().getSelectedItem().toString());
            
            Ala alaSelecionada = (Ala) this.telaCadastroQuarto.getAlaComboBox().getSelectedItem();
            quarto.setAlaId(alaSelecionada.getId());
            
            if (this.telaCadastroQuarto.getIdField().getText().equals("")) {
                service.ServiceQuarto.adicionar(quarto);
            } else {
                quarto.setId(Integer.parseInt(this.telaCadastroQuarto.getIdField().getText()));
                service.ServiceQuarto.atualizar(quarto);
            }

            Utilities.ativaDesativa(false, this.telaCadastroQuarto.getjPanelBotoes());
            Utilities.limpaComponentes(false, this.telaCadastroQuarto.getjPanelDados());

        } else if (evento.getSource() == this.telaCadastroQuarto.getjButtonBuscar()) {
            codigo = 0;
            TelaBuscaQuarto telaBuscaQuarto = new TelaBuscaQuarto(null, true);
            new ControllerBuscaQuarto(telaBuscaQuarto);
            telaBuscaQuarto.setVisible(true);

            if (codigo != 0) {
                Quarto quarto = service.ServiceQuarto.ler(codigo);

                Utilities.ativaDesativa(true, this.telaCadastroQuarto.getjPanelBotoes());
                Utilities.limpaComponentes(true, this.telaCadastroQuarto.getjPanelDados());

                this.telaCadastroQuarto.getIdField().setText(quarto.getId() + "");
                this.telaCadastroQuarto.getDescricaoField().setText(quarto.getDescricao());
                this.telaCadastroQuarto.getStatusComboBox().setSelectedItem(StatusCadastroEnum.valueOf(quarto.getStatus()));
                
                this.telaCadastroQuarto.getIdField().setEnabled(false);
                this.telaCadastroQuarto.getDescricaoField().requestFocus();
            }

        } else if (evento.getSource() == this.telaCadastroQuarto.getjButtonSair()) {
            this.telaCadastroQuarto.dispose();
        }
    }
}

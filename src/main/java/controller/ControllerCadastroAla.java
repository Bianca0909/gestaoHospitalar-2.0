package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.bo.Ala;
import service.ServiceAla;
import utilities.Utilities;
import view.TelaBuscaAla;
import view.TelaCadastroAla;
import enums.StatusCadastroEnum;

public class ControllerCadastroAla implements ActionListener {

    TelaCadastroAla telaCadastroAla;
    public static int codigo;

    public ControllerCadastroAla(TelaCadastroAla telaCadastroAla) {
        this.telaCadastroAla = telaCadastroAla;

        this.telaCadastroAla.getjButtonNovo().addActionListener(this);
        this.telaCadastroAla.getjButtonCancelar().addActionListener(this);
        this.telaCadastroAla.getjButtonGravar().addActionListener(this);
        this.telaCadastroAla.getjButtonBuscar().addActionListener(this);
        this.telaCadastroAla.getjButtonSair().addActionListener(this);

        Utilities.ativaDesativa(false, this.telaCadastroAla.getjPanelBotoes());
        Utilities.limpaComponentes(false, this.telaCadastroAla.getjPanelDados());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.telaCadastroAla.getjButtonNovo()) {
            Utilities.ativaDesativa(true, this.telaCadastroAla.getjPanelBotoes());
            Utilities.limpaComponentes(true, this.telaCadastroAla.getjPanelDados());
            this.telaCadastroAla.getIdField().setEnabled(false);

        } else if (e.getSource() == this.telaCadastroAla.getjButtonCancelar()) {
            Utilities.ativaDesativa(false, this.telaCadastroAla.getjPanelBotoes());
            Utilities.limpaComponentes(false, this.telaCadastroAla.getjPanelDados());

        } else if (e.getSource() == this.telaCadastroAla.getjButtonGravar()) {
            Ala ala = new Ala();
            ala.setDescricao(this.telaCadastroAla.getDescricaoField().getText());
            
            // Converte StatusCadastroEnum para String ao salvar
            Object selectedItem = this.telaCadastroAla.getStatusComboBox().getSelectedItem();
            if (selectedItem != null && selectedItem instanceof StatusCadastroEnum) {
                StatusCadastroEnum statusEnum = (StatusCadastroEnum) selectedItem;
                ala.setStatus(statusEnum.getStatus());
            }

            if (this.telaCadastroAla.getIdField().getText().equals("")) {
                ServiceAla.inserir(ala);
            } else {
                ala.setId(Integer.parseInt(this.telaCadastroAla.getIdField().getText()));
                ServiceAla.atualizar(ala);
            }

            Utilities.ativaDesativa(false, this.telaCadastroAla.getjPanelBotoes());
            Utilities.limpaComponentes(false, this.telaCadastroAla.getjPanelDados());

        } else if (e.getSource() == this.telaCadastroAla.getjButtonBuscar()) {
            codigo = 0;
            TelaBuscaAla telaBuscaAla = new TelaBuscaAla(null, true);
            new ControllerBuscaAla(telaBuscaAla);
            telaBuscaAla.setVisible(true);

            if (codigo != 0) {
                Ala ala = ServiceAla.ler(codigo);
                if (ala != null) {
                    Utilities.ativaDesativa(true, this.telaCadastroAla.getjPanelBotoes());
                    Utilities.limpaComponentes(true, this.telaCadastroAla.getjPanelDados());

                    this.telaCadastroAla.getIdField().setText(ala.getId() + "");
                    this.telaCadastroAla.getDescricaoField().setText(ala.getDescricao());
                    
                    // Converte o status String para StatusCadastroEnum
                    StatusCadastroEnum statusEnum = ala.getStatus().equals("A") ? 
                        StatusCadastroEnum.ATIVO : StatusCadastroEnum.INATIVO;
                    this.telaCadastroAla.getStatusComboBox().setSelectedItem(statusEnum);
                    
                    this.telaCadastroAla.getIdField().setEnabled(false);
                    this.telaCadastroAla.getDescricaoField().requestFocus();
                }
            }

        } else if (e.getSource() == this.telaCadastroAla.getjButtonSair()) {
            this.telaCadastroAla.dispose();
        }
    }
}

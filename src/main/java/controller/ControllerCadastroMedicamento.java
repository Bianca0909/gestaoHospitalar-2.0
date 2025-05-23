package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.bo.Laboratorio;
import model.bo.Medicamento;
import utilities.Utilities;
import view.TelaBuscaMedicamento;
import view.TelaCadastroMedicamento;

public class ControllerCadastroMedicamento implements ActionListener {
    
    public static int codigo;
    
    TelaCadastroMedicamento telaCadastroMedicamento;
    
    public ControllerCadastroMedicamento(TelaCadastroMedicamento telaCadastroMedicamento) {
        this.telaCadastroMedicamento = telaCadastroMedicamento;
        
        this.telaCadastroMedicamento.getjButtonNovo().addActionListener(this);
        this.telaCadastroMedicamento.getjButtonBuscar().addActionListener(this);
        this.telaCadastroMedicamento.getjButtonGravar().addActionListener(this);
        this.telaCadastroMedicamento.getjButtonCancelar().addActionListener(this);
        this.telaCadastroMedicamento.getjButtonSair().addActionListener(this);
        
        Utilities.ativaDesativa(false, this.telaCadastroMedicamento.getjPanelBotoes());
        Utilities.limpaComponentes(false, this.telaCadastroMedicamento.getjPanelDados());
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == this.telaCadastroMedicamento.getjButtonNovo()) {
            Utilities.ativaDesativa(true, this.telaCadastroMedicamento.getjPanelBotoes());
            Utilities.limpaComponentes(true, this.telaCadastroMedicamento.getjPanelDados());
            this.telaCadastroMedicamento.getIdField().setEnabled(false);
            
        } else if (evento.getSource() == this.telaCadastroMedicamento.getjButtonCancelar()) {
            Utilities.ativaDesativa(false, this.telaCadastroMedicamento.getjPanelBotoes());
            Utilities.limpaComponentes(false, this.telaCadastroMedicamento.getjPanelDados());
            
        } else if (evento.getSource() == this.telaCadastroMedicamento.getjButtonGravar()) {
            Medicamento medicamento = new Medicamento();
            
            medicamento.setDescricaoMedicamento(this.telaCadastroMedicamento.getDescricaoField().getText());
            medicamento.setCodigoBarras(this.telaCadastroMedicamento.getCodigoBarrasField().getText());
            medicamento.setPrincipioAtivo(this.telaCadastroMedicamento.getPrincipioAtivoField().getText());
            medicamento.setQtdMinima(Integer.parseInt(this.telaCadastroMedicamento.getQuantidadeMinimaField().getText()));
            medicamento.setStatus(this.telaCadastroMedicamento.getStatusComboBox().getSelectedItem().toString());
            
            Laboratorio laboratorioSelecionado = (Laboratorio) this.telaCadastroMedicamento.getLaboratorioComboBox().getSelectedItem();
            medicamento.setLaboratorioId(laboratorioSelecionado);
            
            if (this.telaCadastroMedicamento.getIdField().getText().equals("")) {
                service.ServiceMedicamento.adicionar(medicamento);
            } else {
                medicamento.setId(Integer.parseInt(this.telaCadastroMedicamento.getIdField().getText()));
                service.ServiceMedicamento.atualizar(medicamento);
            }
            
            Utilities.ativaDesativa(false, this.telaCadastroMedicamento.getjPanelBotoes());
            Utilities.limpaComponentes(false, this.telaCadastroMedicamento.getjPanelDados());
            
        } else if (evento.getSource() == this.telaCadastroMedicamento.getjButtonBuscar()) {
            codigo = 0;
            TelaBuscaMedicamento telaBuscaMedicamento = new TelaBuscaMedicamento(null, true);
            new ControllerBuscaMedicamento(telaBuscaMedicamento);
            telaBuscaMedicamento.setVisible(true);
            
            if (codigo != 0) {
                Medicamento medicamento = service.ServiceMedicamento.ler(codigo);
                
                Utilities.ativaDesativa(true, this.telaCadastroMedicamento.getjPanelBotoes());
                Utilities.limpaComponentes(true, this.telaCadastroMedicamento.getjPanelDados());
                
                this.telaCadastroMedicamento.getIdField().setText(medicamento.getId() + "");
                this.telaCadastroMedicamento.getDescricaoField().setText(medicamento.getDescricaoMedicamento());
                this.telaCadastroMedicamento.getCodigoBarrasField().setText(medicamento.getCodigoBarras());
                this.telaCadastroMedicamento.getPrincipioAtivoField().setText(medicamento.getPrincipioAtivo());
                this.telaCadastroMedicamento.getQuantidadeMinimaField().setText(medicamento.getQtdMinima()+ "");
                this.telaCadastroMedicamento.getStatusComboBox().setSelectedItem(medicamento.getStatus());
                
                this.telaCadastroMedicamento.getIdField().setEnabled(false);
                this.telaCadastroMedicamento.getDescricaoField().requestFocus();
            }
            
        } else if (evento.getSource() == this.telaCadastroMedicamento.getjButtonSair()) {
            this.telaCadastroMedicamento.dispose();
        }
    }
}

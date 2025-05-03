package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bo.Quarto;
import service.ServiceQuarto;
import view.TelaBuscaQuarto;
import view.TelaCadastroQuarto;
import enums.StatusCadastroEnum;

public class ControllerBuscaQuarto implements ActionListener {

    TelaBuscaQuarto telaBuscaQuarto;

    public ControllerBuscaQuarto(TelaBuscaQuarto telaBuscaQuarto) {
        this.telaBuscaQuarto = telaBuscaQuarto;

        this.telaBuscaQuarto.getCarregarButton().addActionListener(this);
        this.telaBuscaQuarto.getFecharButton().addActionListener(this);
        this.telaBuscaQuarto.getButtonFiltrar().addActionListener(this);
        this.telaBuscaQuarto.getEditarButton().addActionListener(this);
        this.telaBuscaQuarto.getExcluirButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == this.telaBuscaQuarto.getCarregarButton()) {
            DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaQuarto.getJTableDados().getModel();
            tabela.setRowCount(0);

            for (Quarto objetoAtualDaLista : ServiceQuarto.ler()) {
                tabela.addRow(new Object[]{
                    objetoAtualDaLista.getId(),
                    objetoAtualDaLista.getDescricao(),
                    objetoAtualDaLista.getStatus(),
                    objetoAtualDaLista.getAla() != null ? objetoAtualDaLista.getAla().getDescricao() : ""
                });
            }
        } else if (evento.getSource() == this.telaBuscaQuarto.getFecharButton()) {
            this.telaBuscaQuarto.dispose();

        } else if (evento.getSource() == this.telaBuscaQuarto.getButtonFiltrar()) {
            if (this.telaBuscaQuarto.getValorField().getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "É obrigatório o preenchimento de algum caracter....");
                this.telaBuscaQuarto.getValorField().requestFocus();

            } else {
                DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaQuarto.getJTableDados().getModel();
                tabela.setRowCount(0);
                
                if (this.telaBuscaQuarto.getFiltroComboBox().getSelectedItem().equals("ID")) {
                    Quarto quarto = ServiceQuarto.ler(Integer.parseInt(this.telaBuscaQuarto.getValorField().getText()));
                    if (quarto != null) {
                        tabela.addRow(new Object[]{
                            quarto.getId(), 
                            quarto.getDescricao(), 
                            quarto.getStatus(),
                            quarto.getAla() != null ? quarto.getAla().getDescricao() : ""
                        });
                    }
                } else {
                    String campoFiltro = "";
                    if (this.telaBuscaQuarto.getFiltroComboBox().getSelectedItem().equals("DESCRIÇÃO")) {
                        campoFiltro = "descricao";
                    } else if (this.telaBuscaQuarto.getFiltroComboBox().getSelectedItem().equals("STATUS")) {
                        campoFiltro = "status";
                    } else if (this.telaBuscaQuarto.getFiltroComboBox().getSelectedItem().equals("ALA")) {
                        campoFiltro = "ala";
                    }

                    for (Quarto objetoAtualDaLista : ServiceQuarto.ler(this.telaBuscaQuarto.getValorField().getText(), campoFiltro)) {
                        tabela.addRow(new Object[]{
                            objetoAtualDaLista.getId(),
                            objetoAtualDaLista.getDescricao(),
                            objetoAtualDaLista.getStatus(),
                            objetoAtualDaLista.getAla() != null ? objetoAtualDaLista.getAla().getDescricao() : ""
                        });
                    }
                }
            }
        } else if (evento.getSource() == this.telaBuscaQuarto.getEditarButton()) {
            int linhaSelecionada = this.telaBuscaQuarto.getJTableDados().getSelectedRow();
            
            if (linhaSelecionada != -1) {
                int id = (int) this.telaBuscaQuarto.getJTableDados().getValueAt(linhaSelecionada, 0);
                
                Quarto quarto = ServiceQuarto.ler(id);
                if (quarto != null) {
                    TelaCadastroQuarto telaCadastro = new TelaCadastroQuarto(null, true);
                    new ControllerCadastroQuarto(telaCadastro);
                    
                    telaCadastro.getIdField().setText(String.valueOf(quarto.getId()));
                    telaCadastro.getDescricaoField().setText(quarto.getDescricao());
                    telaCadastro.getNumeroField().setText(quarto.getNumero());
                    
                    StatusCadastroEnum statusEnum = quarto.getStatus().equals("A") ? 
                        StatusCadastroEnum.ATIVO : StatusCadastroEnum.INATIVO;
                    telaCadastro.getStatusComboBox().setSelectedItem(statusEnum);
                    
                    // Seleciona a ala do quarto no combo
                    if (quarto.getAla() != null) {
                        telaCadastro.getAlaComboBox().setSelectedItem(quarto.getAla());
                    }
                    
                    telaCadastro.getIdField().setEnabled(false);
                    telaCadastro.getDescricaoField().setEnabled(true);
                    telaCadastro.getNumeroField().setEnabled(true);
                    telaCadastro.getStatusComboBox().setEnabled(true);
                    telaCadastro.getAlaComboBox().setEnabled(true);
                    
                    telaCadastro.getjButtonNovo().setEnabled(false);
                    telaCadastro.getjButtonCancelar().setEnabled(true);
                    telaCadastro.getjButtonGravar().setEnabled(true);
                    telaCadastro.getjButtonBuscar().setEnabled(false);
                    telaCadastro.getjButtonSair().setEnabled(true);
                    
                    telaCadastro.getDescricaoField().requestFocus();
                    
                    telaCadastro.setVisible(true);
                    
                    // Atualiza a tabela após a edição
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaQuarto.getJTableDados().getModel();
                    tabela.setRowCount(0);
                    for (Quarto obj : ServiceQuarto.ler()) {
                        tabela.addRow(new Object[]{
                            obj.getId(), 
                            obj.getDescricao(),
                            obj.getStatus(),
                            obj.getAla() != null ? obj.getAla().getDescricao() : ""
                        });
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "É necessário selecionar uma linha para editar.");
            }
        } else if (evento.getSource() == this.telaBuscaQuarto.getExcluirButton()) {
            int linhaSelecionada = this.telaBuscaQuarto.getJTableDados().getSelectedRow();
            
            if (linhaSelecionada != -1) {
                int id = (int) this.telaBuscaQuarto.getJTableDados().getValueAt(linhaSelecionada, 0);
                
                int opcao = JOptionPane.showConfirmDialog(null, "Confirma a exclusão do quarto selecionado?");
                if (opcao == JOptionPane.YES_OPTION) {
                    if (ServiceQuarto.excluir(id)) {
                        JOptionPane.showMessageDialog(null, "Quarto excluído com sucesso!");
                        
                        // Atualiza a tabela após a exclusão
                        DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaQuarto.getJTableDados().getModel();
                        tabela.setRowCount(0);
                        for (Quarto obj : ServiceQuarto.ler()) {
                            tabela.addRow(new Object[]{
                                obj.getId(), 
                                obj.getDescricao(),
                                obj.getStatus(),
                                obj.getAla() != null ? obj.getAla().getDescricao() : ""
                            });
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Erro ao excluir o quarto.");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "É necessário selecionar uma linha para excluir.");
            }
        }
    }
}

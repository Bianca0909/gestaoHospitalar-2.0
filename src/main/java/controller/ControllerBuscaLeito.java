package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bo.Leito;
import service.ServiceLeito;
import view.TelaBuscaLeito;
import view.TelaCadastroLeito;
import enums.StatusCadastroEnum;

public class ControllerBuscaLeito implements ActionListener {
    
    TelaBuscaLeito telaBuscaLeito;

    public ControllerBuscaLeito(TelaBuscaLeito telaBuscaLeito) {
        this.telaBuscaLeito = telaBuscaLeito;
        
        this.telaBuscaLeito.getCarregarButton().addActionListener(this);
        this.telaBuscaLeito.getFecharButton().addActionListener(this);
        this.telaBuscaLeito.getButtonFiltrar().addActionListener(this);
        this.telaBuscaLeito.getEditarButton().addActionListener(this);
        this.telaBuscaLeito.getExcluirButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == this.telaBuscaLeito.getCarregarButton()) {
            DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaLeito.getJTableDados().getModel();
            tabela.setRowCount(0);

            for (Leito objetoAtualDaLista : ServiceLeito.ler()) {
                tabela.addRow(new Object[]{
                    objetoAtualDaLista.getId(), 
                    objetoAtualDaLista.getDescricao(),
                    objetoAtualDaLista.getStatus(),
                    objetoAtualDaLista.getQuarto() != null ? objetoAtualDaLista.getQuarto().getNumero() : ""
                });
            }
        } else if (evento.getSource() == this.telaBuscaLeito.getFecharButton()) {
            this.telaBuscaLeito.dispose();
            
        } else if (evento.getSource() == this.telaBuscaLeito.getButtonFiltrar()) {
            if (this.telaBuscaLeito.getValorField().getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "É obrigatório o preenchimento de algum caracter...");
                this.telaBuscaLeito.getValorField().requestFocus();
            } else {
                DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaLeito.getJTableDados().getModel();
                tabela.setRowCount(0);
                
                String filtroSelecionado = this.telaBuscaLeito.getFiltroComboBox().getSelectedItem().toString();
                String valorFiltro = this.telaBuscaLeito.getValorField().getText();

                if (filtroSelecionado.equals("ID")) {
                    Leito leito = ServiceLeito.ler(Integer.parseInt(valorFiltro));
                    if (leito != null) {
                        tabela.addRow(new Object[]{
                            leito.getId(), 
                            leito.getDescricao(),
                            leito.getStatus(),
                            leito.getQuarto() != null ? leito.getQuarto().getNumero() : ""
                        });
                    }
                } else {
                    String campoFiltro = "";
                    if (filtroSelecionado.equals("DESCRIÇÃO")) {
                        campoFiltro = "descricao";
                    } else if (filtroSelecionado.equals("STATUS")) {
                        campoFiltro = "status";
                    }

                    for (Leito leito : ServiceLeito.ler(valorFiltro, campoFiltro)) {
                        tabela.addRow(new Object[]{
                            leito.getId(), 
                            leito.getDescricao(),
                            leito.getStatus(),
                            leito.getQuarto() != null ? leito.getQuarto().getNumero() : ""
                        });
                    }
                }
            }
        } else if (evento.getSource() == this.telaBuscaLeito.getEditarButton()) {
            int linhaSelecionada = this.telaBuscaLeito.getJTableDados().getSelectedRow();
            
            if (linhaSelecionada != -1) {
                int id = (int) this.telaBuscaLeito.getJTableDados().getValueAt(linhaSelecionada, 0);
                
                Leito leito = ServiceLeito.ler(id);
                if (leito != null) {
                    TelaCadastroLeito telaCadastro = new TelaCadastroLeito(null, true);
                    new ControllerCadastroLeito(telaCadastro);
                    
                    telaCadastro.getIdField().setText(String.valueOf(leito.getId()));
                    telaCadastro.getDescricaoField().setText(leito.getDescricao());
                    
                    StatusCadastroEnum statusEnum = leito.getStatus().equals("A") ? 
                        StatusCadastroEnum.ATIVO : StatusCadastroEnum.INATIVO;
                    telaCadastro.getStatusComboBox().setSelectedItem(statusEnum);
                    
                    // Seleciona o quarto do leito no combo
                    if (leito.getQuarto() != null) {
                        telaCadastro.getQuartoComboBox().setSelectedItem(leito.getQuarto());
                    }
                    
                    telaCadastro.getIdField().setEnabled(false);
                    telaCadastro.getDescricaoField().setEnabled(true);
                    telaCadastro.getStatusComboBox().setEnabled(true);
                    telaCadastro.getQuartoComboBox().setEnabled(true);
                    
                    telaCadastro.getjButtonNovo().setEnabled(false);
                    telaCadastro.getjButtonCancelar().setEnabled(true);
                    telaCadastro.getjButtonGravar().setEnabled(true);
                    telaCadastro.getjButtonBuscar().setEnabled(false);
                    telaCadastro.getjButtonSair().setEnabled(true);
                    
                    telaCadastro.getDescricaoField().requestFocus();
                    
                    telaCadastro.setVisible(true);
                    
                    // Atualiza a tabela após a edição
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaLeito.getJTableDados().getModel();
                    tabela.setRowCount(0);
                    for (Leito obj : ServiceLeito.ler()) {
                        tabela.addRow(new Object[]{
                            obj.getId(), 
                            obj.getDescricao(),
                            obj.getStatus(),
                            obj.getQuarto() != null ? obj.getQuarto().getNumero() : ""
                        });
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "É necessário selecionar uma linha para editar.");
            }
        } else if (evento.getSource() == this.telaBuscaLeito.getExcluirButton()) {
            int linhaSelecionada = this.telaBuscaLeito.getJTableDados().getSelectedRow();
            
            if (linhaSelecionada != -1) {
                int id = (int) this.telaBuscaLeito.getJTableDados().getValueAt(linhaSelecionada, 0);
                
                int opcao = JOptionPane.showConfirmDialog(null, "Confirma a exclusão do leito selecionado?");
                if (opcao == JOptionPane.YES_OPTION) {
                    if (ServiceLeito.excluir(id)) {
                        JOptionPane.showMessageDialog(null, "Leito excluído com sucesso!");
                        
                        // Atualiza a tabela após a exclusão
                        DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaLeito.getJTableDados().getModel();
                        tabela.setRowCount(0);
                        for (Leito obj : ServiceLeito.ler()) {
                            tabela.addRow(new Object[]{
                                obj.getId(), 
                                obj.getDescricao(),
                                obj.getStatus(),
                                obj.getQuarto() != null ? obj.getQuarto().getNumero() : ""
                            });
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Erro ao excluir o leito.");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "É necessário selecionar uma linha para excluir.");
            }
        }
    }
}

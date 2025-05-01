package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bo.Ala;
import service.ServiceAla;
import view.TelaBuscaAla;
import view.TelaCadastroAla;
import enums.StatusCadastroEnum;

public class ControllerBuscaAla implements ActionListener {

    TelaBuscaAla telaBuscaAla;

    public ControllerBuscaAla(TelaBuscaAla telaBuscaAla) {
        this.telaBuscaAla = telaBuscaAla;

        this.telaBuscaAla.getjButtonCarregar().addActionListener(this);
        this.telaBuscaAla.getjButtonSair().addActionListener(this);
        this.telaBuscaAla.getjCBFiltro().addActionListener(this);
        this.telaBuscaAla.getjButtonFiltar().addActionListener(this);
        this.telaBuscaAla.getEditarButton().addActionListener(this);
        this.telaBuscaAla.getExcluirButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == this.telaBuscaAla.getjButtonCarregar()) {
            DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaAla.getjTableDados().getModel();
            tabela.setRowCount(0);

            for (Ala objetoAtualDaLista : ServiceAla.ler()) {
                tabela.addRow(new Object[]{
                    objetoAtualDaLista.getId(),
                    objetoAtualDaLista.getDescricao(),
                    objetoAtualDaLista.getStatus()
                });
            }

        } else if (evento.getSource() == this.telaBuscaAla.getjButtonSair()) {
            this.telaBuscaAla.dispose();

        } else if (evento.getSource() == this.telaBuscaAla.getjButtonFiltar()) {
            if (this.telaBuscaAla.getjTFFiltro().getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "É obrigatório o preenchimento de algum caracter...");
                this.telaBuscaAla.getjTFFiltro().requestFocus();
            } else {
                DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaAla.getjTableDados().getModel();
                tabela.setRowCount(0);

                String filtroSelecionado = this.telaBuscaAla.getjCBFiltro().getSelectedItem().toString();
                String valorFiltro = this.telaBuscaAla.getjTFFiltro().getText();

                if (filtroSelecionado.equals("ID")) {
                    Ala ala = ServiceAla.ler(Integer.parseInt(valorFiltro));
                    if (ala != null) {
                        tabela.addRow(new Object[]{
                            ala.getId(),
                            ala.getDescricao(),
                            ala.getStatus()
                        });
                    }
                } else {
                    String campoFiltro = "";
                    if (filtroSelecionado.equals("DESCRIÇÃO")) {
                        campoFiltro = "descricao";
                    } else if (filtroSelecionado.equals("STATUS")) {
                        campoFiltro = "status";
                    }

                    for (Ala ala : ServiceAla.ler(valorFiltro, campoFiltro)) {
                        tabela.addRow(new Object[]{
                            ala.getId(),
                            ala.getDescricao(),
                            ala.getStatus()
                        });
                    }
                }
            }
        } else if (evento.getSource() == this.telaBuscaAla.getEditarButton()) {
            int linhaSelecionada = this.telaBuscaAla.getjTableDados().getSelectedRow();
            
            if (linhaSelecionada != -1) {
                // Obtém o ID diretamente da tabela
                int id = (int) this.telaBuscaAla.getjTableDados().getValueAt(linhaSelecionada, 0);
                
                // Busca a ala completa do banco
                Ala ala = ServiceAla.ler(id);
                if (ala != null) {
                    TelaCadastroAla telaCadastro = new TelaCadastroAla(null, true);
                    new ControllerCadastroAla(telaCadastro);
                    
                    // Preenche os campos com os dados da ala
                    telaCadastro.getIdField().setText(String.valueOf(ala.getId()));
                    telaCadastro.getDescricaoField().setText(ala.getDescricao());
                    
                    // Converte o status String para StatusCadastroEnum
                    StatusCadastroEnum statusEnum = ala.getStatus().equals("A") ? 
                        StatusCadastroEnum.ATIVO : StatusCadastroEnum.INATIVO;
                    telaCadastro.getStatusComboBox().setSelectedItem(statusEnum);
                    
                    // Configura os campos editáveis
                    telaCadastro.getIdField().setEnabled(false); // ID não pode ser editado
                    telaCadastro.getDescricaoField().setEnabled(true); // Descrição pode ser editada
                    telaCadastro.getStatusComboBox().setEnabled(true); // Status pode ser editado
                    
                    // Configura os botões
                    telaCadastro.getjButtonNovo().setEnabled(false);
                    telaCadastro.getjButtonCancelar().setEnabled(true);
                    telaCadastro.getjButtonGravar().setEnabled(true);
                    telaCadastro.getjButtonBuscar().setEnabled(false);
                    telaCadastro.getjButtonSair().setEnabled(false);
                    
                    // Foca no campo de descrição para facilitar a edição
                    telaCadastro.getDescricaoField().requestFocus();
                    
                    telaCadastro.setVisible(true);
                    
                    // Atualiza a tabela após a edição
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaAla.getjTableDados().getModel();
                    tabela.setRowCount(0);
                    for (Ala obj : ServiceAla.ler()) {
                        tabela.addRow(new Object[]{obj.getId(), obj.getDescricao(), obj.getStatus()});
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "É necessário selecionar uma linha para editar.");
            }
        } else if (evento.getSource() == this.telaBuscaAla.getExcluirButton()) {
            int linhaSelecionada = this.telaBuscaAla.getjTableDados().getSelectedRow();
            
            if (linhaSelecionada != -1) {
                // Obtém o ID diretamente da tabela
                int id = (int) this.telaBuscaAla.getjTableDados().getValueAt(linhaSelecionada, 0);
                
                int opcao = JOptionPane.showConfirmDialog(null, "Confirma a exclusão da ala selecionada?");
                if (opcao == JOptionPane.YES_OPTION) {
                    if (ServiceAla.excluir(id)) {
                        JOptionPane.showMessageDialog(null, "Ala excluída com sucesso!");
                        
                        // Atualiza a tabela após a exclusão
                        DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaAla.getjTableDados().getModel();
                        tabela.setRowCount(0);
                        for (Ala obj : ServiceAla.ler()) {
                            tabela.addRow(new Object[]{obj.getId(), obj.getDescricao(), obj.getStatus()});
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Erro ao excluir a ala.");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "É necessário selecionar uma linha para excluir.");
            }
        }
    }
}

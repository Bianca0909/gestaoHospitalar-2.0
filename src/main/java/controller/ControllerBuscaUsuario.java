package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bo.Usuario;
import service.ServiceUsuario;
import view.TelaBuscaUsuario;
import view.TelaCadastroUsuario;
import enums.StatusCadastroEnum;

public class ControllerBuscaUsuario implements ActionListener {

    TelaBuscaUsuario telaBuscaUsuario;

    public ControllerBuscaUsuario(TelaBuscaUsuario telaBuscaUsuario) {
        this.telaBuscaUsuario = telaBuscaUsuario;
        this.telaBuscaUsuario.getCarregarButton().addActionListener(this);
        this.telaBuscaUsuario.getFecharButton().addActionListener(this);
        this.telaBuscaUsuario.getButtonFiltrar().addActionListener(this);
        this.telaBuscaUsuario.getEditarButton().addActionListener(this);
        this.telaBuscaUsuario.getExcluirButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == this.telaBuscaUsuario.getCarregarButton()) {
            DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaUsuario.getJTableDados().getModel();
            tabela.setRowCount(0);

            for (Usuario objetoAtualDaLista : service.ServiceUsuario.ler()) {
                tabela.addRow(new Object[]{
                    objetoAtualDaLista.getId(),
                    objetoAtualDaLista.getLogin()
                });
            }

        } else if (evento.getSource() == this.telaBuscaUsuario.getFecharButton()) {
            this.telaBuscaUsuario.dispose();

        } else if (evento.getSource() == this.telaBuscaUsuario.getButtonFiltrar()) {
            if (this.telaBuscaUsuario.getValorField().getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "É obrigatório o preenchimento de algum caracter...");
                this.telaBuscaUsuario.getValorField().requestFocus();
            } else {
                DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaUsuario.getJTableDados().getModel();
                tabela.setRowCount(0);

                if (this.telaBuscaUsuario.getFiltroComboBox().getSelectedItem().equals("ID")) {
                    Usuario usuario = service.ServiceUsuario.ler(Integer.parseInt(this.telaBuscaUsuario.getValorField().getText()));
                    tabela.addRow(new Object[]{
                        usuario.getId(),
                        usuario.getLogin()
                    });

                } else if (this.telaBuscaUsuario.getFiltroComboBox().getSelectedItem().equals("LOGIN")) {
                    for (Usuario objetoAtualDaLista : service.ServiceUsuario.ler(this.telaBuscaUsuario.getValorField().getText(), "login")) {
                        tabela.addRow(new Object[]{
                            objetoAtualDaLista.getId(),
                            objetoAtualDaLista.getLogin()
                        });
                    }
                }
            }
        } else if (evento.getSource() == this.telaBuscaUsuario.getEditarButton()) {
            int linhaSelecionada = this.telaBuscaUsuario.getJTableDados().getSelectedRow();
            
            if (linhaSelecionada != -1) {
                // Primeiro, obtemos o ID diretamente da tabela
                int id = (int) this.telaBuscaUsuario.getJTableDados().getValueAt(linhaSelecionada, 0);
                
                // Em seguida, usamos esse ID para buscar o usuário completo no banco de dados
                // Isso garante que tenhamos todos os dados do usuário, e não apenas o que está visível na tabela
                Usuario usuario = ServiceUsuario.ler(id);
                if (usuario != null) {
                    TelaCadastroUsuario telaCadastro = new TelaCadastroUsuario(null, true);
                    new ControllerCadastroUsuario(telaCadastro);
                    
                    // Preenche os campos com os dados do usuário
                    telaCadastro.getIdField().setText(String.valueOf(usuario.getId()));
                    telaCadastro.getLoginField().setText(usuario.getLogin());
                    telaCadastro.getSenhaField().setText(usuario.getSenha());
                    
                    // Converte o status String para StatusCadastroEnum
                    StatusCadastroEnum statusEnum = usuario.getStatus().equals("A") ? 
                        StatusCadastroEnum.ATIVO : StatusCadastroEnum.INATIVO;
                    telaCadastro.getStatusComboBox().setSelectedItem(statusEnum);
                    
                    // Configura os campos editáveis
                    telaCadastro.getIdField().setEnabled(false); // ID não pode ser editado
                    telaCadastro.getLoginField().setEnabled(true); // Login pode ser editado
                    telaCadastro.getSenhaField().setEnabled(true); // Senha pode ser editada
                    telaCadastro.getStatusComboBox().setEnabled(true); // Status pode ser editado
                    
                    // Configura os botões
                    telaCadastro.getjButtonNovo().setEnabled(false);
                    telaCadastro.getjButtonCancelar().setEnabled(true);
                    telaCadastro.getjButtonGravar().setEnabled(true);
                    telaCadastro.getjButtonBuscar().setEnabled(false);
                    telaCadastro.getjButtonSair().setEnabled(false);
                    
                    // Foca no campo de login para facilitar a edição
                    telaCadastro.getLoginField().requestFocus();
                    
                    telaCadastro.setVisible(true);
                    
                    // Atualiza a tabela após a edição
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaUsuario.getJTableDados().getModel();
                    tabela.setRowCount(0);
                    for (Usuario obj : ServiceUsuario.ler()) {
                        tabela.addRow(new Object[]{obj.getId(), obj.getLogin()});
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "É necessário selecionar uma linha para editar.");
            }
        } else if (evento.getSource() == this.telaBuscaUsuario.getExcluirButton()) {
            int linhaSelecionada = this.telaBuscaUsuario.getJTableDados().getSelectedRow();
            
            if (linhaSelecionada != -1) {
                // Obtém o ID diretamente da tabela
                int id = (int) this.telaBuscaUsuario.getJTableDados().getValueAt(linhaSelecionada, 0);
                
                int opcao = JOptionPane.showConfirmDialog(null, "Confirma a exclusão do usuário selecionado?");
                if (opcao == JOptionPane.YES_OPTION) {
                    if (ServiceUsuario.excluir(id)) {
                        JOptionPane.showMessageDialog(null, "Usuário excluído com sucesso!");
                        
                        // Atualiza a tabela após a exclusão
                        DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaUsuario.getJTableDados().getModel();
                        tabela.setRowCount(0);
                        for (Usuario obj : ServiceUsuario.ler()) {
                            tabela.addRow(new Object[]{obj.getId(), obj.getLogin()});
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Erro ao excluir o usuário.");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "É necessário selecionar uma linha para excluir.");
            }
        }
    }
}

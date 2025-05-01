package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bo.Medico;
import service.ServiceMedico;
import view.TelaBuscaMedico;
import view.TelaCadastroMedico;

public class ControllerBuscaMedico implements ActionListener {

    TelaBuscaMedico telaBuscaMedico;
    private int codigoRetorno = 0;

    public int getCodigoRetorno() {
        return codigoRetorno;
    }

    public void setCodigoRetorno(int codigoRetorno) {
        this.codigoRetorno = codigoRetorno;
    }

    public ControllerBuscaMedico(TelaBuscaMedico telaBuscaMedico) {
        this.telaBuscaMedico = telaBuscaMedico;
        this.telaBuscaMedico.getCarregarButton().addActionListener(this);
        this.telaBuscaMedico.getButtonFechar().addActionListener(this);
        this.telaBuscaMedico.getButtonFiltrar().addActionListener(this);
        this.telaBuscaMedico.getjButtonEditar().addActionListener(this);
        this.telaBuscaMedico.getjButtonExcluir().addActionListener(this);

        // Load initial data
        carregarDados();
    }

    private void carregarDados() {
        DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaMedico.getJTableDados().getModel();
        tabela.setRowCount(0);

        for (Medico objetoAtualDaLista : ServiceMedico.ler()) {
            tabela.addRow(new Object[]{objetoAtualDaLista.getId(), objetoAtualDaLista.getNome(),
                objetoAtualDaLista.getCrm(), objetoAtualDaLista.getDataCadastro(),
                objetoAtualDaLista.getEmail(), objetoAtualDaLista.getFone1()});
        }
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == this.telaBuscaMedico.getCarregarButton()) {
            int linhaSelecionada = this.telaBuscaMedico.getJTableDados().getSelectedRow();
            
            if (linhaSelecionada != -1) {
                this.codigoRetorno = (int) this.telaBuscaMedico.getJTableDados().getValueAt(linhaSelecionada, 0);
                this.telaBuscaMedico.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "É necessário selecionar uma linha.");
            }
        } else if (evento.getSource() == this.telaBuscaMedico.getButtonFechar()) {
            this.telaBuscaMedico.dispose();
        } else if (evento.getSource() == this.telaBuscaMedico.getButtonFiltrar()) {
            if (this.telaBuscaMedico.getValorField().getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "É obrigatório o preenchimento de algum caracter....");
                this.telaBuscaMedico.getValorField().requestFocus();
            } else {
                DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaMedico.getJTableDados().getModel();
                tabela.setRowCount(0);

                if (this.telaBuscaMedico.getFiltroComboBox().getSelectedItem().equals("ID")) {
                    Medico medico = ServiceMedico.ler(Integer.parseInt(this.telaBuscaMedico.getValorField().getText()));
                    if (medico != null) {
                        tabela.addRow(new Object[]{medico.getId(), medico.getNome(),
                            medico.getCrm(), medico.getDataCadastro(),
                            medico.getEmail(), medico.getFone1()});
                    }
                } else if (this.telaBuscaMedico.getFiltroComboBox().getSelectedItem().equals("NOME")) {
                    for (Medico objetoAtualDaLista : ServiceMedico.ler(this.telaBuscaMedico.getValorField().getText(), "nome")) {
                        tabela.addRow(new Object[]{objetoAtualDaLista.getId(), objetoAtualDaLista.getNome(),
                            objetoAtualDaLista.getCrm(), objetoAtualDaLista.getDataCadastro(),
                            objetoAtualDaLista.getEmail(), objetoAtualDaLista.getFone1()});
                    }
                } else if (this.telaBuscaMedico.getFiltroComboBox().getSelectedItem().equals("CRM")) {
                    for (Medico objetoAtualDaLista : ServiceMedico.ler(this.telaBuscaMedico.getValorField().getText(), "crm")) {
                        tabela.addRow(new Object[]{objetoAtualDaLista.getId(), objetoAtualDaLista.getNome(),
                            objetoAtualDaLista.getCrm(), objetoAtualDaLista.getDataCadastro(),
                            objetoAtualDaLista.getEmail(), objetoAtualDaLista.getFone1()});
                    }
                } else if (this.telaBuscaMedico.getFiltroComboBox().getSelectedItem().equals("DATA CADASTRO")) {
                    for (Medico objetoAtualDaLista : ServiceMedico.ler(this.telaBuscaMedico.getValorField().getText(), "dataCadastro")) {
                        tabela.addRow(new Object[]{objetoAtualDaLista.getId(), objetoAtualDaLista.getNome(),
                            objetoAtualDaLista.getCrm(), objetoAtualDaLista.getDataCadastro(),
                            objetoAtualDaLista.getEmail(), objetoAtualDaLista.getFone1()});
                    }
                } else if (this.telaBuscaMedico.getFiltroComboBox().getSelectedItem().equals("EMAIL")) {
                    for (Medico objetoAtualDaLista : ServiceMedico.ler(this.telaBuscaMedico.getValorField().getText(), "email")) {
                        tabela.addRow(new Object[]{objetoAtualDaLista.getId(), objetoAtualDaLista.getNome(),
                            objetoAtualDaLista.getCrm(), objetoAtualDaLista.getDataCadastro(),
                            objetoAtualDaLista.getEmail(), objetoAtualDaLista.getFone1()});
                    }
                } else if (this.telaBuscaMedico.getFiltroComboBox().getSelectedItem().equals("TELEFONE")) {
                    for (Medico objetoAtualDaLista : ServiceMedico.ler(this.telaBuscaMedico.getValorField().getText(), "fone1")) {
                        tabela.addRow(new Object[]{objetoAtualDaLista.getId(), objetoAtualDaLista.getNome(),
                            objetoAtualDaLista.getCrm(), objetoAtualDaLista.getDataCadastro(),
                            objetoAtualDaLista.getEmail(), objetoAtualDaLista.getFone1()});
                    }
                }
            }
        } else if (evento.getSource() == this.telaBuscaMedico.getjButtonEditar()) {
            int linhaSelecionada = this.telaBuscaMedico.getJTableDados().getSelectedRow();
            
            if (linhaSelecionada != -1) {
                int id = (int) this.telaBuscaMedico.getJTableDados().getValueAt(linhaSelecionada, 0);
                
                TelaCadastroMedico telaCadastro = new TelaCadastroMedico(null, true);
                new ControllerCadastroMedico(telaCadastro);
                
                Medico medico = ServiceMedico.ler(id);
                if (medico != null) {
                    telaCadastro.getIdField().setText(String.valueOf(medico.getId()));
                    telaCadastro.getNomeField().setText(medico.getNome());
                    telaCadastro.getFone1Field().setText(medico.getFone1());
                    telaCadastro.getFone2Field().setText(medico.getFone2());
                    telaCadastro.getDataCadastroField().setText(medico.getDataCadastro());
                    telaCadastro.getNomeSocialField().setText(medico.getNomeSocial());
                    telaCadastro.getCpfCnpjField().setText(medico.getCpfCnpj());
                    telaCadastro.getRgField().setText(medico.getRgInscricaoEstadual());
                    telaCadastro.getEmailField().setText(medico.getEmail());
                    telaCadastro.getCepField().setText(medico.getCep());
                    telaCadastro.getCidadeField().setText(medico.getCidade());
                    telaCadastro.getBairroField().setText(medico.getBairro());
                    telaCadastro.getLogradouroField().setText(medico.getLogradouro());
                    telaCadastro.getComplementoField().setText(medico.getComplemento());
                    telaCadastro.getCrmField().setText(medico.getCrm());
                    telaCadastro.getSenhaField().setText(medico.getSenha());
                    telaCadastro.getLoginField().setText(medico.getLogin());
                    telaCadastro.getNomeSocialField().setText(medico.getNomeSocial());
                    telaCadastro.getStatusComboBox().setSelectedItem(medico.getStatus());

                    telaCadastro.getIdField().setEnabled(false);
                    telaCadastro.getjButtonNovo().setEnabled(false);
                    telaCadastro.getjButtonCancelar().setEnabled(true);
                    telaCadastro.getjButtonGravar().setEnabled(true);
                    telaCadastro.getjButtonBuscar().setEnabled(false);
                    telaCadastro.getjButtonSair().setEnabled(false);
                    telaCadastro.getNomeField().requestFocus();
                    
                    telaCadastro.setVisible(true);
                    
                    // Atualiza a tabela após a edição
                    carregarDados();
                }
            } else {
                JOptionPane.showMessageDialog(null, "É necessário selecionar uma linha para editar.");
            }

        } else if (evento.getSource() == this.telaBuscaMedico.getjButtonExcluir()) {
            int linhaSelecionada = this.telaBuscaMedico.getJTableDados().getSelectedRow();
            
            if (linhaSelecionada != -1) {
                int id = (int) this.telaBuscaMedico.getJTableDados().getValueAt(linhaSelecionada, 0);
                
                int opcao = JOptionPane.showConfirmDialog(null, "Confirma a exclusão do médico selecionado?");
                if (opcao == JOptionPane.YES_OPTION) {
                    if (ServiceMedico.excluir(id)) {
                        JOptionPane.showMessageDialog(null, "Médico excluído com sucesso!");
                        carregarDados();
                    } else {
                        JOptionPane.showMessageDialog(null, "Erro ao excluir o médico.");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "É necessário selecionar uma linha para excluir.");
            }
        }
    }
}

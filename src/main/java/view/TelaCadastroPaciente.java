/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import enums.SexoEnum;
import enums.StatusCadastroEnum;
import enums.TipoSanguineoEnum;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import utilities.MaskFormatters;
import utilities.Utilities;

/**
 *
 * @author professor
 */
public class TelaCadastroPaciente extends javax.swing.JDialog {

    /**
     * Creates new form ModeloCadastral_2024
     */
    public TelaCadastroPaciente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        loadComboBox();
        setupMasks();
    }

    public JComboBox<StatusCadastroEnum> getStatusComboBox() {
        return statusComboBox;
    }

    public void setStatusComboBox(JComboBox<StatusCadastroEnum> statusComboBox) {
        this.statusComboBox = statusComboBox;
    }

    public JLabel getBairroLabel() {
        return BairroLabel;
    }

    public void setBairroLabel(JLabel BairroLabel) {
        this.BairroLabel = BairroLabel;
    }

    public JLabel getCidadeLabel() {
        return CidadeLabel;
    }

    public void setCidadeLabel(JLabel CidadeLabel) {
        this.CidadeLabel = CidadeLabel;
    }

    public JTextField getBairroField() {
        return bairroField;
    }

    public void setBairroField(JTextField bairroField) {
        this.bairroField = bairroField;
    }

    public JFormattedTextField getCepField() {
        return cepField;
    }

    public void setCepField(JFormattedTextField cepField) {
        this.cepField = cepField;
    }

    public JLabel getCepLabel() {
        return cepLabel;
    }

    public void setCepLabel(JLabel cepLabel) {
        this.cepLabel = cepLabel;
    }

    public JTextField getCidadeField() {
        return cidadeField;
    }

    public void setCidadeField(JTextField cidadeField) {
        this.cidadeField = cidadeField;
    }

    public JTextField getComplementoField() {
        return complementoField;
    }

    public void setComplementoField(JTextField complementoField) {
        this.complementoField = complementoField;
    }

    public JLabel getComplementoLabel() {
        return complementoLabel;
    }

    public void setComplementoLabel(JLabel complementoLabel) {
        this.complementoLabel = complementoLabel;
    }

    public JFormattedTextField getCpfField() {
        return cpfField;
    }

    public void setCpfField(JFormattedTextField cpfField) {
        this.cpfField = cpfField;
    }

    public JLabel getCpfCnpjLabel() {
        return cpfCnpjLabel;
    }

    public void setCpfCnpjLabel(JLabel cpfCnpjLabel) {
        this.cpfCnpjLabel = cpfCnpjLabel;
    }


    public JFormattedTextField getDataCadastroField() {
        return dataCadastroField;
    }

    public void setDataCadastroField(JFormattedTextField dataCadastroField) {
        this.dataCadastroField = dataCadastroField;
    }

    public JLabel getDataCadastroLabel() {
        return dataCadastroLabel;
    }

    public void setDataCadastroLabel(JLabel dataCadastroLabel) {
        this.dataCadastroLabel = dataCadastroLabel;
    }

    public JTextField getEmailField() {
        return emailField;
    }

    public void setEmailField(JTextField emailField) {
        this.emailField = emailField;
    }

    public JLabel getEmailLabel() {
        return emailLabel;
    }

    public void setEmailLabel(JLabel emailLabel) {
        this.emailLabel = emailLabel;
    }

    public JFormattedTextField getFone1Field() {
        return fone1Field;
    }

    public void setFone1Field(JFormattedTextField fone1Field) {
        this.fone1Field = fone1Field;
    }

    public JLabel getFone1Label() {
        return fone1Label;
    }

    public void setFone1Label(JLabel fone1Label) {
        this.fone1Label = fone1Label;
    }

    public JFormattedTextField getFone2Field() {
        return fone2Field;
    }

    public void setFone2Field(JFormattedTextField fone2Field) {
        this.fone2Field = fone2Field;
    }

    public JLabel getFone2Label() {
        return fone2Label;
    }

    public void setFone2Label(JLabel fone2Label) {
        this.fone2Label = fone2Label;
    }

    public JTextField getIdField() {
        return idField;
    }

    public void setIdField(JTextField idField) {
        this.idField = idField;
    }

    public JLabel getIdLabel() {
        return idLabel;
    }

    public void setIdLabel(JLabel idLabel) {
        this.idLabel = idLabel;
    }

    public JButton getjButtonBuscar() {
        return jButtonBuscar;
    }

    public void setjButtonBuscar(JButton jButtonBuscar) {
        this.jButtonBuscar = jButtonBuscar;
    }

    public JButton getjButtonCancelar() {
        return jButtonCancelar;
    }

    public void setjButtonCancelar(JButton jButtonCancelar) {
        this.jButtonCancelar = jButtonCancelar;
    }

    public JButton getjButtonGravar() {
        return jButtonGravar;
    }

    public void setjButtonGravar(JButton jButtonGravar) {
        this.jButtonGravar = jButtonGravar;
    }

    public JButton getjButtonNovo() {
        return jButtonNovo;
    }

    public void setjButtonNovo(JButton jButtonNovo) {
        this.jButtonNovo = jButtonNovo;
    }

    public JButton getjButtonSair() {
        return jButtonSair;
    }

    public void setjButtonSair(JButton jButtonSair) {
        this.jButtonSair = jButtonSair;
    }

    public JLabel getjLabelTitulo() {
        return jLabelTitulo;
    }

    public void setjLabelTitulo(JLabel jLabelTitulo) {
        this.jLabelTitulo = jLabelTitulo;
    }

    public JPanel getjPanelBotoes() {
        return jPanelBotoes;
    }

    public void setjPanelBotoes(JPanel jPanelBotoes) {
        this.jPanelBotoes = jPanelBotoes;
    }

    public JPanel getjPanelDados() {
        return jPanelDados;
    }

    public void setjPanelDados(JPanel jPanelDados) {
        this.jPanelDados = jPanelDados;
    }

    public JPanel getjPaneltitulo() {
        return jPaneltitulo;
    }

    public void setjPaneltitulo(JPanel jPaneltitulo) {
        this.jPaneltitulo = jPaneltitulo;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JTextArea getjTextArea1() {
        return jTextArea1;
    }

    public void setjTextArea1(JTextArea jTextArea1) {
        this.jTextArea1 = jTextArea1;
    }

    public JTextField getLogradouroField() {
        return logradouroField;
    }

    public void setLogradouroField(JTextField logradouroField) {
        this.logradouroField = logradouroField;
    }

    public JLabel getLogradouroLabel() {
        return logradouroLabel;
    }

    public void setLogradouroLabel(JLabel logradouroLabel) {
        this.logradouroLabel = logradouroLabel;
    }

    public JTextField getNomeField() {
        return nomeField;
    }

    public void setNomeField(JTextField nomeField) {
        this.nomeField = nomeField;
    }

    public JLabel getNomeLabel() {
        return nomeLabel;
    }

    public void setNomeLabel(JLabel nomeLabel) {
        this.nomeLabel = nomeLabel;
    }

    public JTextField getNomeSocialField() {
        return nomeSocialField;
    }

    public void setNomeSocialField(JTextField nomeSocialField) {
        this.nomeSocialField = nomeSocialField;
    }

    public JLabel getNomeSocialLabel() {
        return nomeSocialLabel;
    }

    public void setNomeSocialLabel(JLabel nomeSocialLabel) {
        this.nomeSocialLabel = nomeSocialLabel;
    }

    public JTextField getRgField() {
        return rgField;
    }

    public void setRgField(JTextField rgField) {
        this.rgField = rgField;
    }

    public JLabel getRgInscricaoEstadualLabel() {
        return rgInscricaoEstadualLabel;
    }

    public void setRgInscricaoEstadualLabel(JLabel rgInscricaoEstadualLabel) {
        this.rgInscricaoEstadualLabel = rgInscricaoEstadualLabel;
    }

    public JComboBox<SexoEnum> getSexoComboBox() {
        return sexoComboBox;
    }

    public void setSexoComboBox(JComboBox<SexoEnum> sexoComboBox) {
        this.sexoComboBox = sexoComboBox;
    }

    public JLabel getSexoLabel() {
        return sexoLabel;
    }

    public void setSexoLabel(JLabel sexoLabel) {
        this.sexoLabel = sexoLabel;
    }

    public JComboBox<TipoSanguineoEnum> getTipoSanguineoComboBox() {
        return tipoSanguineoComboBox;
    }

    public void setTipoSanguineoComboBox(JComboBox<TipoSanguineoEnum> tipoSanguineoComboBox) {
        this.tipoSanguineoComboBox = tipoSanguineoComboBox;
    }

    public JLabel getTipoSanguineoLabel() {
        return tipoSanguineoLabel;
    }

    public void setTipoSanguineoLabel(JLabel tipoSanguineoLabel) {
        this.tipoSanguineoLabel = tipoSanguineoLabel;
    }

    private void setupMasks() {
        MaskFormatters.cpfMask(cpfField);
        MaskFormatters.dateMask(dataCadastroField);
        MaskFormatters.phoneMask(fone1Field);
        MaskFormatters.phoneMask(fone2Field);
        MaskFormatters.cepMask(cepField);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPaneltitulo = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jPanelDados = new javax.swing.JPanel();
        nomeLabel = new javax.swing.JLabel();
        idLabel = new javax.swing.JLabel();
        dataCadastroLabel = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
        nomeField = new javax.swing.JTextField();
        dataCadastroField = new javax.swing.JFormattedTextField();
        cpfCnpjLabel = new javax.swing.JLabel();
        rgField = new javax.swing.JTextField();
        rgInscricaoEstadualLabel = new javax.swing.JLabel();
        nomeSocialLabel = new javax.swing.JLabel();
        nomeSocialField = new javax.swing.JTextField();
        sexoLabel = new javax.swing.JLabel();
        tipoSanguineoLabel = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        emailLabel = new javax.swing.JLabel();
        fone1Label = new javax.swing.JLabel();
        fone2Label = new javax.swing.JLabel();
        cepLabel = new javax.swing.JLabel();
        CidadeLabel = new javax.swing.JLabel();
        cidadeField = new javax.swing.JTextField();
        BairroLabel = new javax.swing.JLabel();
        bairroField = new javax.swing.JTextField();
        logradouroLabel = new javax.swing.JLabel();
        logradouroField = new javax.swing.JTextField();
        complementoLabel = new javax.swing.JLabel();
        complementoField = new javax.swing.JTextField();
        tipoSanguineoComboBox = new javax.swing.JComboBox<>();
        sexoComboBox = new javax.swing.JComboBox<>();
        statusComboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jPanelBotoes = new javax.swing.JPanel();
        jButtonNovo = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonGravar = new javax.swing.JButton();
        jButtonBuscar = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        cpfField = new javax.swing.JFormattedTextField();
        fone1Field = new javax.swing.JFormattedTextField();
        fone2Field = new javax.swing.JFormattedTextField();
        cepField = new javax.swing.JFormattedTextField();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Título do Form");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPaneltitulo.setBackground(new java.awt.Color(51, 153, 255));
        jPaneltitulo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelTitulo.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("Cadastro de Paciente");
        jLabelTitulo.setToolTipText("");

        javax.swing.GroupLayout jPaneltituloLayout = new javax.swing.GroupLayout(jPaneltitulo);
        jPaneltitulo.setLayout(jPaneltituloLayout);
        jPaneltituloLayout.setHorizontalGroup(
            jPaneltituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 756, Short.MAX_VALUE)
        );
        jPaneltituloLayout.setVerticalGroup(
            jPaneltituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );

        getContentPane().add(jPaneltitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, -1));

        jPanelDados.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanelDados.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nomeLabel.setText("Nome");
        jPanelDados.add(nomeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 62, 37, -1));

        idLabel.setText("Id");
        jPanelDados.add(idLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 8, 37, -1));

        dataCadastroLabel.setText("Data de nascimento");
        jPanelDados.add(dataCadastroLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(608, 62, -1, -1));

        idField.setEditable(false);
        idField.setEnabled(false);
        idField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idFieldActionPerformed(evt);
            }
        });
        jPanelDados.add(idField, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 28, 49, 28));

        nomeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeFieldActionPerformed(evt);
            }
        });
        jPanelDados.add(nomeField, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 84, 594, 32));

        dataCadastroField.setText("  /  /    ");
        jPanelDados.add(dataCadastroField, new org.netbeans.lib.awtextra.AbsoluteConstraints(608, 84, 139, 32));

        cpfCnpjLabel.setText("CPF");
        jPanelDados.add(cpfCnpjLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(608, 122, 65, -1));

        rgField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpfCnpjFieldActionPerformed(evt);
            }
        });
        jPanelDados.add(rgField, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 209, 161, 32));

        rgInscricaoEstadualLabel.setText("RG");
        jPanelDados.add(rgInscricaoEstadualLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 187, -1, -1));

        nomeSocialLabel.setText("Nome social");
        jPanelDados.add(nomeSocialLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 122, 75, -1));
        jPanelDados.add(nomeSocialField, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 144, 594, 31));

        sexoLabel.setText("Sexo");
        jPanelDados.add(sexoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 187, 37, -1));

        tipoSanguineoLabel.setText("Tipo sanguíneo");
        jPanelDados.add(tipoSanguineoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(306, 187, 92, -1));
        jPanelDados.add(emailField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 286, 30));

        emailLabel.setText("E-mail");
        jPanelDados.add(emailLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 247, 37, -1));

        fone1Label.setText("Fone 1");
        jPanelDados.add(fone1Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 190, 43, -1));

        fone2Label.setText("Fone 2");
        jPanelDados.add(fone2Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 190, 43, -1));

        cepLabel.setText("CEP");
        jPanelDados.add(cepLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(306, 247, 43, -1));

        CidadeLabel.setText("Cidade");
        jPanelDados.add(CidadeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(433, 247, 43, -1));

        cidadeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cidadeFieldActionPerformed(evt);
            }
        });
        jPanelDados.add(cidadeField, new org.netbeans.lib.awtextra.AbsoluteConstraints(433, 269, 314, 30));

        BairroLabel.setText("Bairro");
        jPanelDados.add(BairroLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 303, 43, -1));
        jPanelDados.add(bairroField, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 325, 161, 30));

        logradouroLabel.setText("Logradouro");
        jPanelDados.add(logradouroLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(179, 303, 72, -1));
        jPanelDados.add(logradouroField, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 325, 252, 30));

        complementoLabel.setText("Complemento");
        jPanelDados.add(complementoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(433, 303, 88, -1));
        jPanelDados.add(complementoField, new org.netbeans.lib.awtextra.AbsoluteConstraints(433, 325, 314, 30));

        tipoSanguineoComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(TipoSanguineoEnum.values()));
        jPanelDados.add(tipoSanguineoComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 104, 30));

        sexoComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(SexoEnum.values()));
        sexoComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sexoComboBoxActionPerformed(evt);
            }
        });
        jPanelDados.add(sexoComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, 113, 30));

        jPanelDados.add(statusComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 160, 30));

        jLabel1.setText("Status");
        jPanelDados.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, -1, -1));

        jPanelDados.add(cpfField, new org.netbeans.lib.awtextra.AbsoluteConstraints(608, 144, 139, 32));
        jPanelDados.add(fone1Field, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 210, 139, 32));
        jPanelDados.add(fone2Field, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 210, 139, 32));
        jPanelDados.add(cepField, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, 113, 30));

        getContentPane().add(jPanelDados, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 49, 760, 420));

        jPanelBotoes.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButtonNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Create.png"))); // NOI18N
        jButtonNovo.setText("Novo");
        jButtonNovo.setActionCommand("1");
        jButtonNovo.setEnabled(false);
        jButtonNovo.setMinimumSize(new java.awt.Dimension(67, 25));
        jButtonNovo.setPreferredSize(new java.awt.Dimension(100, 30));
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });
        jPanelBotoes.add(jButtonNovo);

        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cancel.png"))); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.setActionCommand("0");
        jButtonCancelar.setPreferredSize(new java.awt.Dimension(100, 30));
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        jPanelBotoes.add(jButtonCancelar);

        jButtonGravar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Download.png"))); // NOI18N
        jButtonGravar.setText("Gravar");
        jButtonGravar.setActionCommand("0");
        jButtonGravar.setPreferredSize(new java.awt.Dimension(100, 30));
        jButtonGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGravarActionPerformed(evt);
            }
        });
        jPanelBotoes.add(jButtonGravar);

        jButtonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Find.png"))); // NOI18N
        jButtonBuscar.setText("Buscar");
        jButtonBuscar.setActionCommand("1");
        jButtonBuscar.setEnabled(false);
        jButtonBuscar.setPreferredSize(new java.awt.Dimension(100, 30));
        jPanelBotoes.add(jButtonBuscar);

        jButtonSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Exit.png"))); // NOI18N
        jButtonSair.setText("Sair");
        jButtonSair.setActionCommand("1");
        jButtonSair.setPreferredSize(new java.awt.Dimension(100, 30));
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });
        jPanelBotoes.add(jButtonSair);

        getContentPane().add(jPanelBotoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 470, 760, 50));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
        Utilities.ativaDesativa(true, jPanelBotoes);
    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        Utilities.ativaDesativa(false, jPanelBotoes);
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGravarActionPerformed
        Utilities.ativaDesativa(false, jPanelBotoes);
    }//GEN-LAST:event_jButtonGravarActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void idFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idFieldActionPerformed

    private void nomeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeFieldActionPerformed

    private void cidadeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cidadeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cidadeFieldActionPerformed

    private void cpfCnpjFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpfCnpjFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cpfCnpjFieldActionPerformed

    private void sexoComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sexoComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sexoComboBoxActionPerformed

      private void loadComboBox() {
        sexoComboBox.setModel(new DefaultComboBoxModel<>(SexoEnum.values()));
        tipoSanguineoComboBox.setModel(new DefaultComboBoxModel<>(TipoSanguineoEnum.values()));
        statusComboBox.setModel(new DefaultComboBoxModel<>(StatusCadastroEnum.values()));
    }
  
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaCadastroPaciente dialog = new TelaCadastroPaciente(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BairroLabel;
    private javax.swing.JLabel CidadeLabel;
    private javax.swing.JTextField bairroField;
    private javax.swing.JFormattedTextField cepField;
    private javax.swing.JLabel cepLabel;
    private javax.swing.JTextField cidadeField;
    private javax.swing.JTextField complementoField;
    private javax.swing.JLabel complementoLabel;
    private javax.swing.JFormattedTextField cpfField;
    private javax.swing.JLabel cpfCnpjLabel;
    private javax.swing.JFormattedTextField dataCadastroField;
    private javax.swing.JLabel dataCadastroLabel;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JFormattedTextField fone1Field;
    private javax.swing.JLabel fone1Label;
    private javax.swing.JFormattedTextField fone2Field;
    private javax.swing.JLabel fone2Label;
    private javax.swing.JTextField idField;
    private javax.swing.JLabel idLabel;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonGravar;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanelBotoes;
    private javax.swing.JPanel jPanelDados;
    private javax.swing.JPanel jPaneltitulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField logradouroField;
    private javax.swing.JLabel logradouroLabel;
    private javax.swing.JTextField nomeField;
    private javax.swing.JLabel nomeLabel;
    private javax.swing.JTextField nomeSocialField;
    private javax.swing.JLabel nomeSocialLabel;
    private javax.swing.JTextField rgField;
    private javax.swing.JLabel rgInscricaoEstadualLabel;
    private javax.swing.JComboBox<SexoEnum> sexoComboBox;
    private javax.swing.JLabel sexoLabel;
    private javax.swing.JComboBox<StatusCadastroEnum> statusComboBox;
    private javax.swing.JComboBox<TipoSanguineoEnum> tipoSanguineoComboBox;
    private javax.swing.JLabel tipoSanguineoLabel;
    // End of variables declaration//GEN-END:variables
}

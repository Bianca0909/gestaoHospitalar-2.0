package view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class TelaBuscaQuarto extends JDialog {
    
    private JPanel painel;
    private JButton carregarButton;
    private JButton fecharButton;
    private JButton buttonFiltrar;
    private JButton editarButton;
    private JButton excluirButton;
    private JComboBox<String> filtroComboBox;
    private JTextField valorField;
    private JTable jTableDados;
    private JScrollPane jScrollPane1;
    private JLabel filtroLabel;
    private JLabel valorLabel;

    public TelaBuscaQuarto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        
        painel = new JPanel();
        carregarButton = new JButton("Carregar");
        fecharButton = new JButton("Fechar");
        buttonFiltrar = new JButton("Filtrar");
        editarButton = new JButton("Editar");
        excluirButton = new JButton("Excluir");
        filtroComboBox = new JComboBox<>();
        valorField = new JTextField();
        jTableDados = new JTable();
        jScrollPane1 = new JScrollPane();
        filtroLabel = new JLabel("Filtro:");
        valorLabel = new JLabel("Valor:");
        
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Busca de Quartos");
        
        jTableDados.setModel(new DefaultTableModel(
            new Object [][] {},
            new String [] {
                "ID", "Descrição", "Status", "Ala"
            }
        ));
        jScrollPane1.setViewportView(jTableDados);
        
        filtroComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(
            new String[] { "ID", "DESCRIÇÃO", "STATUS", "ALA" }
        ));
        
        // Layout do painel
        javax.swing.GroupLayout painelLayout = new javax.swing.GroupLayout(painel);
        painel.setLayout(painelLayout);
        painelLayout.setHorizontalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
                    .addGroup(painelLayout.createSequentialGroup()
                        .addComponent(carregarButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editarButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(excluirButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(fecharButton))
                    .addGroup(painelLayout.createSequentialGroup()
                        .addComponent(filtroLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filtroComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(valorLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(valorField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonFiltrar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painelLayout.setVerticalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filtroLabel)
                    .addComponent(filtroComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valorLabel)
                    .addComponent(valorField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonFiltrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(carregarButton)
                    .addComponent(editarButton)
                    .addComponent(excluirButton)
                    .addComponent(fecharButton))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }
    
    public JButton getCarregarButton() {
        return carregarButton;
    }

    public JButton getFecharButton() {
        return fecharButton;
    }

    public JButton getButtonFiltrar() {
        return buttonFiltrar;
    }
    
    public JButton getEditarButton() {
        return editarButton;
    }
    
    public JButton getExcluirButton() {
        return excluirButton;
    }

    public JComboBox<String> getFiltroComboBox() {
        return filtroComboBox;
    }

    public JTextField getValorField() {
        return valorField;
    }

    public JTable getJTableDados() {
        return jTableDados;
    }
}

package telas.membro;

import dao.MembroDAO;
import entidades.Membro;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.table.DefaultTableModel;
import telas.Principal;
import util.Mensagens;
import util.TamanhoFixo;

public class ManterMembro extends javax.swing.JInternalFrame {

    private List<Membro> listaMem;
    private final MembroDAO memDao;
    private final Principal telaPrincipal;

    /**
     * Creates new form Zona
     *
     * @param telaPrincipal
     */
    public ManterMembro(Principal telaPrincipal) {
        initComponents();
        this.memDao = new MembroDAO();
        this.telaPrincipal = telaPrincipal;
        preencherTabela();
    }

    private void preencherTabela() {

        String nome = txtNome.getText();
        String fone = txtFone.getText();

        try {
            this.listaMem = memDao.listarTodosNomesFone(nome, fone);

            DefaultTableModel modelo = (DefaultTableModel) tabUsuario.getModel();

            for (int linha = modelo.getRowCount() - 1; linha >= 0; linha--) {
                modelo.removeRow(linha);
            }

            for (Membro mb : listaMem) {
                modelo.addRow(new String[]{mb.getNome(), mb.getFone()});

            }
        } catch (SQLException ex) {
            Mensagens.erro("Problema ao listar os Membros: " + ex.getMessage());
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelFuncionalidade = new javax.swing.JPanel();
        btAdicionar = new javax.swing.JButton();
        btRemover = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btSair = new javax.swing.JButton();
        painelLista = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabUsuario = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtFone = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Gerenciar Usuario");
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setPreferredSize(new java.awt.Dimension(600, 400));

        painelFuncionalidade.setBorder(javax.swing.BorderFactory.createTitledBorder("Funcionalidade"));

        btAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add.png"))); // NOI18N
        btAdicionar.setText("Adicionar");
        btAdicionar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btAdicionar.setFocusable(false);
        btAdicionar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btAdicionar.setPreferredSize(new java.awt.Dimension(100, 50));
        btAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdicionarActionPerformed(evt);
            }
        });
        painelFuncionalidade.add(btAdicionar);
        btAdicionar.getAccessibleContext().setAccessibleDescription("");

        btRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excluir2.png"))); // NOI18N
        btRemover.setText("Remover");
        btRemover.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btRemover.setEnabled(false);
        btRemover.setFocusable(false);
        btRemover.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btRemover.setPreferredSize(new java.awt.Dimension(100, 50));
        painelFuncionalidade.add(btRemover);

        btAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/alterar.png"))); // NOI18N
        btAlterar.setText("Alterar");
        btAlterar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btAlterar.setFocusable(false);
        btAlterar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btAlterar.setPreferredSize(new java.awt.Dimension(100, 50));
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });
        painelFuncionalidade.add(btAlterar);

        btSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Exit.png"))); // NOI18N
        btSair.setText("Sair");
        btSair.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btSair.setFocusable(false);
        btSair.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btSair.setPreferredSize(new java.awt.Dimension(100, 50));
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });
        painelFuncionalidade.add(btSair);

        getContentPane().add(painelFuncionalidade, java.awt.BorderLayout.PAGE_START);

        painelLista.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista"));
        painelLista.setPreferredSize(new java.awt.Dimension(480, 250));
        painelLista.setLayout(new java.awt.BorderLayout());

        tabUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Fone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tabUsuario);
        if (tabUsuario.getColumnModel().getColumnCount() > 0) {
            tabUsuario.getColumnModel().getColumn(0).setResizable(false);
            tabUsuario.getColumnModel().getColumn(0).setPreferredWidth(200);
            tabUsuario.getColumnModel().getColumn(1).setResizable(false);
            tabUsuario.getColumnModel().getColumn(1).setPreferredWidth(20);
        }

        painelLista.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel1.setText("Filtro: ");

        txtNome.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomeKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel3.setText("Fone:");

        txtFone.setDocument(new TamanhoFixo(10));
        txtFone.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtFone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFoneKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtFone, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtFone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        painelLista.add(jPanel2, java.awt.BorderLayout.NORTH);

        getContentPane().add(painelLista, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btSairActionPerformed

    private void btAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionarActionPerformed

        JDialog dialogo = new CadastroMembro(telaPrincipal, true, memDao);
        dialogo.setVisible(true);

        preencherTabela();
    }//GEN-LAST:event_btAdicionarActionPerformed

    private void txtNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyReleased
        // TODO add your handling code here:
        preencherTabela();
    }//GEN-LAST:event_txtNomeKeyReleased

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        // TODO add your handling code here:
        int linha = tabUsuario.getSelectedRow();

        if (linha < 0) {
            Mensagens.atenção("Por favor, selecione uma linha para alterar");
        } else {
            JDialog dialogo = new CadastroMembro(telaPrincipal, true, memDao, listaMem.get(linha));
            dialogo.setVisible(true);
        }

        preencherTabela();

    }//GEN-LAST:event_btAlterarActionPerformed

    private void txtFoneKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFoneKeyReleased
        preencherTabela();
    }//GEN-LAST:event_txtFoneKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdicionar;
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btRemover;
    private javax.swing.JButton btSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel painelFuncionalidade;
    private javax.swing.JPanel painelLista;
    private javax.swing.JTable tabUsuario;
    private javax.swing.JTextField txtFone;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}

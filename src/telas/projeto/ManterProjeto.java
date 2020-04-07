package telas.projeto;

import dao.ProjetoDAO;
import entidades.Projeto;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import telas.Principal;
import util.Mensagens;

public class ManterProjeto extends javax.swing.JInternalFrame {

    private List<Projeto> listaProj;
    private final ProjetoDAO projDao;
    private final Principal telaPrincipal;

    public ManterProjeto(Principal telaPrincipal) {
        initComponents();
        this.projDao = new ProjetoDAO();
        this.telaPrincipal = telaPrincipal;
        preencherTabela();
    }

    private void preencherTabela() {

        String nome = txtNome.getText();

        try {
            this.listaProj = projDao.listarTodosNomes(nome);

            DefaultTableModel modelo = (DefaultTableModel) tabUsuario.getModel();

            for (int linha = modelo.getRowCount() - 1; linha >= 0; linha--) {
                modelo.removeRow(linha);
            }

            for (Projeto pj : listaProj) {
                modelo.addRow(new String[]{pj.getNome(), (pj.isAtivo()) ? "Sim" : "Não"});

            }
        } catch (SQLException ex) {
            Mensagens.erro("Problema ao listar os Projetos" + ex.getMessage());
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
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabUsuario = new javax.swing.JTable();

        setClosable(true);
        setTitle("Gerenciar Projetos");
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
        btRemover.setFocusable(false);
        btRemover.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btRemover.setPreferredSize(new java.awt.Dimension(100, 50));
        btRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoverActionPerformed(evt);
            }
        });
        painelFuncionalidade.add(btRemover);

        btAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/alterar.png"))); // NOI18N
        btAlterar.setText("Alterar");
        btAlterar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btAlterar.setFocusable(false);
        btAlterar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btAlterar.setPreferredSize(new java.awt.Dimension(100, 50));
        btAlterar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
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
        btSair.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
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

        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel1.setText("Filtro: ");
        jPanel1.add(jLabel1, java.awt.BorderLayout.WEST);

        txtNome.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomeKeyReleased(evt);
            }
        });
        jPanel1.add(txtNome, java.awt.BorderLayout.CENTER);

        painelLista.add(jPanel1, java.awt.BorderLayout.NORTH);

        tabUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Ativo"
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
            tabUsuario.getColumnModel().getColumn(1).setPreferredWidth(10);
        }

        painelLista.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        getContentPane().add(painelLista, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btSairActionPerformed

    private void btAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionarActionPerformed

        JDialog dialogo = new CadastroProjeto(telaPrincipal, true, projDao);
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
            JDialog dialogo = new CadastroProjeto(telaPrincipal, true, projDao, listaProj.get(linha));
            dialogo.setVisible(true);
        }

        preencherTabela();

    }//GEN-LAST:event_btAlterarActionPerformed

    private void btRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoverActionPerformed
        // TODO add your handling code here:

        int linha = tabUsuario.getSelectedRow();

        if (linha < 0) {
            Mensagens.atenção("Por favor, selecione Projeto para remoção.");
        } else {

            Projeto pj = listaProj.get(linha);

            if (JOptionPane.showConfirmDialog(this, "Tem certeza que deseja remover o Projeto " + pj.getNome(), "Atenção", JOptionPane.YES_NO_OPTION) == 0) {
                try {

                    pj.setAtivo(false);

                    this.projDao.remover(pj);

                } catch (SQLException ex) {
                    Mensagens.erro("Erro ao tentar remover o Projeto: " + ex.getMessage());
                }
            }

        }

        preencherTabela();
    }//GEN-LAST:event_btRemoverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdicionar;
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btRemover;
    private javax.swing.JButton btSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel painelFuncionalidade;
    private javax.swing.JPanel painelLista;
    private javax.swing.JTable tabUsuario;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}

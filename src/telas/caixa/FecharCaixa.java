package telas.caixa;

import dao.CaixaDAO;
import dao.FormaPagamentoDAO;
import dao.PagamentoDAO;
import entidades.FormaPagamento;
import entidades.Usuario;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import relatorios.ImprimirRelatorio;
import util.Mensagens;

public class FecharCaixa extends javax.swing.JInternalFrame {

    private final Usuario usu;
    private final CaixaDAO caiDao;
    private List<FormaPagamento> listaForPag;
    private final FormaPagamentoDAO fpagDao;
    private final PagamentoDAO pagDao;
    private double valorTotal = 0;

    public FecharCaixa(CaixaDAO caiDao, Usuario usu) {
        initComponents();
        this.usu = usu;
        this.caiDao = caiDao;
        this.pagDao = new PagamentoDAO();
        this.fpagDao = new FormaPagamentoDAO();
        preencherTabela();
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
        tabelaPagamento = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setClosable(true);

        tabelaPagamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Forma de Pagamento", "SubTotal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaPagamento);
        if (tabelaPagamento.getColumnModel().getColumnCount() > 0) {
            tabelaPagamento.getColumnModel().getColumn(0).setResizable(false);
            tabelaPagamento.getColumnModel().getColumn(0).setPreferredWidth(150);
            tabelaPagamento.getColumnModel().getColumn(1).setResizable(false);
            tabelaPagamento.getColumnModel().getColumn(1).setPreferredWidth(50);
        }

        jLabel1.setText("Valores recebidos.");

        jButton2.setBackground(new java.awt.Color(0, 153, 0));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/salvar.png"))); // NOI18N
        jButton2.setText("Confirmar Fechamento CAIXA");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 0, 0));
        jButton3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excluir2.png"))); // NOI18N
        jButton3.setText("Cancelar Fechamento CAIXA");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        dispose();

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        try {

            caiDao.fechar(usu.getCaixa());

            Mensagens.sucesso();

            ImprimirRelatorio.fechamentoCaixa(this.usu.getCaixa().getCodigo());

            this.usu.setCaixa(null);

            dispose();

        } catch (SQLException ex) {
            Mensagens.erro("Erro ao fechar o caixa: " + ex.getMessage());
        } catch (JRException ex) {
            Mensagens.erro("Erro ao tentar imprimir o relatorio de\n"
                    + " fechamento de caixa: " + ex.getMessage());
        }


    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaPagamento;
    // End of variables declaration//GEN-END:variables

    private void preencherTabela() {

        try {

            listaForPag = fpagDao.listarTodos();

            DefaultTableModel modelo = (DefaultTableModel) tabelaPagamento.getModel();

            for (int linha = modelo.getRowCount() - 1; linha >= 0; linha--) {
                modelo.removeRow(linha);
            }

            double valor = 0;

            for (FormaPagamento fp : listaForPag) {
                valor = pagDao.somarValores(fp.getCodigo(), usu.getCaixa().getCodigo());
                valorTotal += valor;
                modelo.addRow(new String[]{fp.getNome(), "R$ " + valor});
            }

            modelo.addRow(new String[]{"Valor TOTAL em Caixa", "R$ " + valorTotal});

        } catch (SQLException ex) {
            Mensagens.erro("Problema ao listar os Valores de Fechamento de Caixa: " + ex.getMessage());
        }

    }

}
package telas.compromisso;

import dao.BoletoDAO;
import dao.FormaPagamentoDAO;
import dao.PagamentoDAO;
import entidades.Boleto;
import entidades.Caixa;
import entidades.FormaPagamento;
import entidades.Pagamento;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import relatorios.ImprimirRelatorio;
import util.Mensagens;

public class ReceberCompromisso extends javax.swing.JDialog {

    private final Boleto boleto;
    private final BoletoDAO boletoDao;
    private final PagamentoDAO pagDao;
    private final FormaPagamentoDAO formPagDao;

    private final Caixa cai;
    private double valorPago = 0;

    public ReceberCompromisso(java.awt.Frame parent, boolean modal, Boleto boleto, Caixa cai, BoletoDAO boletoDao) {
        super(parent, modal);

        this.cai = cai;
        this.boleto = boleto;
        this.boletoDao = boletoDao;
        this.boleto.setListaPagamento(new ArrayList<>());

        this.pagDao = new PagamentoDAO();
        this.formPagDao = new FormaPagamentoDAO();
        initComponents();
        preencherFormBoleto();
        preecherjComboFormaPagamento();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNumParcela = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        txtDataVencimento = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jcFormaPagamento = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        txtValorP = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaPagamento = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtValorPago = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Receber Compromisso");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Boleto"));

        jLabel1.setText("Data de Vencimento:");

        jLabel2.setText("Numero da Parcela:");

        txtNumParcela.setEditable(false);
        txtNumParcela.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel4.setText("Valor do compromisso:");

        txtValor.setEditable(false);
        txtValor.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        txtDataVencimento.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDataVencimento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txtNumParcela, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(txtNumParcela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtDataVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Dado de Pagamento"));

        jcFormaPagamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Valor:");

        txtValorP.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtValorP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtValorPKeyTyped(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add.png"))); // NOI18N
        jButton1.setText("Adicionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcFormaPagamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtValorP, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jcFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtValorP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabelaPagamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Forma de Pagamento", "Valor"
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
            tabelaPagamento.getColumnModel().getColumn(0).setPreferredWidth(200);
            tabelaPagamento.getColumnModel().getColumn(1).setResizable(false);
            tabelaPagamento.getColumnModel().getColumn(1).setPreferredWidth(20);
        }

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/salvar.png"))); // NOI18N
        jButton2.setText("Confirmar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excluir.png"))); // NOI18N
        jButton3.setText("Cancelar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel5.setText("Valor Pago:");

        txtValorPago.setEditable(false);
        txtValorPago.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excluir.png"))); // NOI18N
        jButton4.setText("Remover");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(txtValorPago, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtValorPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (jcFormaPagamento.getSelectedIndex() <= 0) {
            Mensagens.atenção("Por favor, selecione uma forma de pagamento.");
        } else if (txtValorP.getText().trim().length() == 0) {
            Mensagens.atenção("Informe o valor que esta sendo pago.");
        } else {
            Pagamento pag = new Pagamento();

            pag.setBoleto(boleto);
            pag.setCaixa(cai);
            pag.setFormaPagamento((FormaPagamento) jcFormaPagamento.getSelectedItem());
            pag.setValor(Double.parseDouble(txtValorP.getText().trim().replace(",", ".")));

            boleto.getListaPagamento().add(pag);

            valorPago += pag.getValor();

            limparFormPagamento();

            preencherTabelaPagamento();

        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        try {
            for (Pagamento pg : boleto.getListaPagamento()) {
                pagDao.salvar(pg);
            }

            boleto.setQuitado(true);
            boleto.setValor(valorPago);

            boletoDao.confirmarPagamento(boleto);

            Mensagens.sucesso();

            ImprimirRelatorio.gerarReciboPagamento(boleto.getCodigo());

            dispose();

        } catch (SQLException ex) {
            Mensagens.erro("Erro ao Tentar Salvar os Pagamentos: " + ex.getMessage());

        } catch (JRException ex) {
            Mensagens.erro("Erro ao Tentar Imprimir o recibo de Pagamento: " + ex.getMessage());
        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        int linha = tabelaPagamento.getSelectedRow();

        if (linha < 0) {
            Mensagens.atenção("Selecione uma forma de pagamento.");
        } else {
            if (Mensagens.perguntar("Tem certeza que deseja excluir a forma de pagamento em "
                    + boleto.getListaPagamento().get(linha).getFormaPagamento().getNome() + "?") == 0) {

                valorPago -= boleto.getListaPagamento().get(linha).getValor();

                boleto.getListaPagamento().remove(linha);

                preencherTabelaPagamento();

            }
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtValorPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorPKeyTyped
        String caracteres = "0987654321,";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtValorPKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox jcFormaPagamento;
    private javax.swing.JTable tabelaPagamento;
    private com.toedter.calendar.JDateChooser txtDataVencimento;
    private javax.swing.JTextField txtNumParcela;
    private javax.swing.JTextField txtValor;
    private javax.swing.JTextField txtValorP;
    private javax.swing.JTextField txtValorPago;
    // End of variables declaration//GEN-END:variables

    private void preecherjComboFormaPagamento() {

        DefaultComboBoxModel modelCidade = (DefaultComboBoxModel) jcFormaPagamento.getModel();

        modelCidade.removeAllElements();

        modelCidade.addElement("Selecione um projeto");

        try {
            for (FormaPagamento fp : formPagDao.listarTodos()) {
                modelCidade.addElement(fp);
            }
        } catch (SQLException ex) {
            Mensagens.erro("Problema ao preencher o Lista de Forma de Pagamento: " + ex.getMessage());
        }
    }

    private void preencherFormBoleto() {
        txtNumParcela.setText(String.valueOf(boleto.getNumeroParcela()));
        txtDataVencimento.setDate(boleto.getDataVencimento());
        txtValor.setText(String.valueOf(boleto.getValor()).replace(".", ","));
    }

    private void preencherTabelaPagamento() {

        DefaultTableModel modelo = (DefaultTableModel) tabelaPagamento.getModel();

        for (int linha = modelo.getRowCount() - 1; linha >= 0; linha--) {
            modelo.removeRow(linha);
        }

        for (Pagamento pg : boleto.getListaPagamento()) {
            modelo.addRow(new String[]{pg.getFormaPagamento().getNome(), String.valueOf(pg.getValor()).replace(".", ",")});
        }

        txtValorPago.setText(String.valueOf(valorPago).replace(".", ","));

    }

    private void limparFormPagamento() {

        jcFormaPagamento.setSelectedIndex(0);

        txtValorP.setText("");

    }

}
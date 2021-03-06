package telas.compromisso;

import dao.BoletoDAO;
import dao.CompromissoDAO;
import dao.PagamentoDAO;
import entidades.Boleto;
import entidades.Compromisso;
import entidades.Membro;
import entidades.Pagamento;
import entidades.Usuario;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JDialog;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import relatorios.ImprimirRelatorio;
import telas.Principal;
import util.Mensagens;
import telas.telaUtil.SelecaoMembro;

public class ConsultarCompromisso extends javax.swing.JInternalFrame {

    private final Principal tela;
    private Membro membro;
    private final CompromissoDAO compDao;
    private final PagamentoDAO pagDao;
    private final BoletoDAO boDao;
    private final Usuario usu;
    private int linhaCompromisso;
    private final SimpleDateFormat formatar;

    public ConsultarCompromisso(Principal tela, Usuario usu) {
        initComponents();
        this.compDao = new CompromissoDAO();
        this.pagDao = new PagamentoDAO();
        this.boDao = new BoletoDAO();
        this.tela = tela;
        this.usu = usu;
        formatar = new SimpleDateFormat("dd/MM/yyyy");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtFone = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaCompromisso = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaBoleto = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        setClosable(true);
        setTitle("Consulta de Compromisso");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Membro"));

        jLabel1.setText("Nome:");

        txtNome.setEditable(false);

        jLabel2.setText("Fone:");

        txtFone.setEditable(false);
        try {
            txtFone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/procurar.png"))); // NOI18N
        jButton1.setText("Buscar Membro");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtFone)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtNome))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtFone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Compromissos"));

        tabelaCompromisso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Projeto", "Valor  por Parcela", "T. Parcela", "Quitado?"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaCompromisso);
        if (tabelaCompromisso.getColumnModel().getColumnCount() > 0) {
            tabelaCompromisso.getColumnModel().getColumn(0).setResizable(false);
            tabelaCompromisso.getColumnModel().getColumn(0).setPreferredWidth(200);
            tabelaCompromisso.getColumnModel().getColumn(1).setResizable(false);
            tabelaCompromisso.getColumnModel().getColumn(1).setPreferredWidth(80);
            tabelaCompromisso.getColumnModel().getColumn(2).setPreferredWidth(20);
            tabelaCompromisso.getColumnModel().getColumn(3).setResizable(false);
            tabelaCompromisso.getColumnModel().getColumn(3).setPreferredWidth(20);
        }

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/dizimoEditar.png"))); // NOI18N
        jButton2.setText("Visualizar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add.png"))); // NOI18N
        jButton5.setText("Adicionar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excluir.png"))); // NOI18N
        jButton7.setText("Excluir");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addGap(18, 18, 18)
                        .addComponent(jButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton5)
                    .addComponent(jButton7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Parcelas"));

        tabelaBoleto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Parcela", "Vencimento", "Valor", "Quitado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tabelaBoleto);
        if (tabelaBoleto.getColumnModel().getColumnCount() > 0) {
            tabelaBoleto.getColumnModel().getColumn(0).setResizable(false);
            tabelaBoleto.getColumnModel().getColumn(1).setResizable(false);
            tabelaBoleto.getColumnModel().getColumn(2).setResizable(false);
            tabelaBoleto.getColumnModel().getColumn(3).setResizable(false);
        }

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/registrar2.png"))); // NOI18N
        jButton3.setText("Receber Compromisso");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/sair.png"))); // NOI18N
        jButton4.setText("Cancelar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excluir2.png"))); // NOI18N
        jButton8.setText("Cancelar Recibo");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        SelecaoMembro dialogo = new SelecaoMembro(this.tela, true);

        dialogo.setVisible(true);

        if (dialogo.getMembro() == null) {

            limparFormularioMembro();

        } else {
            this.membro = dialogo.getMembro();

            preencherFormularioMembro();
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        if (tabelaCompromisso.getSelectedRow() < 0) {
            Mensagens.atenção("Selecione um Compromisso");
        } else {

            linhaCompromisso = tabelaCompromisso.getSelectedRow();

            preencherTabelaBoleto();

        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        if (tabelaBoleto.getSelectedRow() < 0) {
            Mensagens.atenção("Selecione um boleto para pagamento.");
        } else {

            Compromisso comp = membro.getListaCompromisso().get(linhaCompromisso);

            Boleto bl = comp.getListaBoletos().get(tabelaBoleto.getSelectedRow());

            if (bl.isQuitado()) {

                if (Mensagens.perguntar("O Boleto selecionado já esta pago.\n Deseja reemprimir o recibo?") == 0) {
                    try {
                        ImprimirRelatorio.gerarReciboPagamento(bl.getCodigo());
                    } catch (JRException ex) {
                        Mensagens.erro("Não foi possivel reemprimir o recibo: " + ex.getMessage());
                    }
                }

            } else if (usu.getCaixa() == null) {
                Mensagens.atenção("Usuário " + usu.getNome() + " não possui um CAIXA aberto.");
            } else {
                JDialog receberCompromisso = new ReceberCompromisso(tela, true,
                        bl, usu.getCaixa(), boDao);

                receberCompromisso.setVisible(true);

                boolean quitado = true;

                for (Boleto bo : comp.getListaBoletos()) {
                    if (!bo.isQuitado()) {
                        quitado = false;
                    }
                }

                if (quitado) {
                    try {
                        compDao.comfirmarPagamento(comp);
                    } catch (SQLException ex) {
                        Mensagens.erro("Erro ao tentar comfirmar Pagamento Compromisso: " + ex.getMessage());
                    }
                }

                preencherTabelaCompromisso();

                tabelaCompromisso.setRowSelectionInterval(linhaCompromisso, linhaCompromisso);

                preencherTabelaBoleto();
            }
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        dispose();

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        if (membro == null) {
            Mensagens.atenção("Selecione um membro antes de cadastrar um compromisso.");
        } else {
            JDialog dialogo = new CadastroCompromisso(tela, true, membro, usu);
            dialogo.setVisible(true);
        }

        preencherTabelaCompromisso();

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        if (usu.isAdm()) {

            int linha = tabelaCompromisso.getSelectedRow();

            if (linha < 0) {
                Mensagens.atenção("Selecione um compromisso para excluir.");
            } else {

                Compromisso comp = membro.getListaCompromisso().get(linha);

                if (comp.isQuitado()) {
                    Mensagens.atenção("Compromisso já esta quitado, não será possível excluir.");
                } else {

                    try {

                        boolean pode = true;

                        comp.setListaBoletos(boDao.listarTodosCompromisso(comp.getCodigo()));

                        for (Boleto bo : comp.getListaBoletos()) {
                            if (bo.isQuitado()) {
                                pode = false;
                            }
                        }

                        if (pode) {

                            if (Mensagens.perguntar("Tem certeza que deseja excluir o compromisso " + comp.getProjeto().getNome() + "?") == 0) {
                                for (Boleto bo : comp.getListaBoletos()) {
                                    boDao.delete(bo);
                                }

                                compDao.delete(comp);

                                Mensagens.sucesso();

                                preencherTabelaCompromisso();
                            }

                        } else {
                            Mensagens.atenção("O compromisso possui parcelas pagas, não será possível excluir.");
                        }

                    } catch (SQLException ex) {
                        Mensagens.erro("Erro ao tentar excluir Compromisso: " + ex.getMessage());
                    }

                }
            }

        } else {
            Mensagens.atenção("Você não tem permissão para alterar um compromisso.");
        }


    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed

        if (!usu.isAdm()) {
            Mensagens.atenção("Você não permissão para Cancelar um Recibo.");
        } else if (tabelaBoleto.getSelectedRow() < 0) {
            Mensagens.atenção("Selecione um Boleto para Cancelar o Recibo.");
        } else {
            Compromisso comp = membro.getListaCompromisso().get(linhaCompromisso);

            Boleto bo = comp.getListaBoletos().get(tabelaBoleto.getSelectedRow());

            if (!bo.isQuitado()) {
                Mensagens.atenção("Boleto selecionado não possui Recibo.");
            } else {

                if (Mensagens.perguntar("Tem certeza que deseja excluir O Recibo deste Boleto?") == 0) {

                    try {
                        bo.setListaPagamento(pagDao.listarTodosBoleto(bo.getCodigo()));

                        for (Pagamento pg : bo.getListaPagamento()) {
                            pagDao.delete(pg.getCodigo());
                        }

                        bo.setQuitado(false);
                        bo.setValor(comp.getValor_parcela());

                        boDao.cancelarPagamento(bo);

                        Mensagens.sucesso();

                        preencherTabelaCompromisso();

                        tabelaCompromisso.setRowSelectionInterval(linhaCompromisso, linhaCompromisso);

                        preencherTabelaBoleto();

                    } catch (SQLException ex) {
                        Mensagens.erro("Erro ao tentar Listar ou excluir o recibo: " + ex.getMessage());
                    }

                }

            }
        }


    }//GEN-LAST:event_jButton8ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabelaBoleto;
    private javax.swing.JTable tabelaCompromisso;
    private javax.swing.JFormattedTextField txtFone;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables

    private void acaoBotaoAlterar() {
        if (usu.isAdm()) {

            int linha = tabelaCompromisso.getSelectedRow();

            if (linha < 0) {
                Mensagens.atenção("Selecione um compromisso para alteração.");
            } else {

                Compromisso comp = membro.getListaCompromisso().get(linha);

                if (comp.isQuitado()) {
                    Mensagens.atenção("Compromisso já esta quitado, não será possível alterar.");
                } else {
                    comp.setMembro(membro);

                    JDialog dialogo = new AlterarCompromisso(tela, true, comp, usu);
                    dialogo.setVisible(true);

                    preencherTabelaCompromisso();

                }
            }

        } else {
            Mensagens.atenção("Você não tem permissão para alterar um compromisso.");
        }
    }

    private void limparFormularioMembro() {
        txtNome.setText("");
        txtFone.setText("");

        limparTabela((DefaultTableModel) tabelaCompromisso.getModel());
        limparTabela((DefaultTableModel) tabelaBoleto.getModel());

    }

    private void preencherFormularioMembro() {
        txtNome.setText(this.membro.getNome());
        txtFone.setText(this.membro.getFone());

        preencherTabelaCompromisso();

    }

    private void limparTabela(DefaultTableModel modelo) {
        for (int linha = modelo.getRowCount() - 1; linha >= 0; linha--) {
            modelo.removeRow(linha);
        }
    }

    private void preencherTabelaCompromisso() {

        limparTabela((DefaultTableModel) tabelaBoleto.getModel());

        try {
            membro.setListaCompromisso(compDao.listarTodosMembro(membro.getCodigo()));

            DefaultTableModel modelo = (DefaultTableModel) tabelaCompromisso.getModel();

            limparTabela(modelo);

            for (Compromisso comp : membro.getListaCompromisso()) {
                modelo.addRow(new String[]{comp.getProjeto().getNome(), String.valueOf(comp.getValor_parcela()), String.valueOf(comp.getTotalNumParcela()), ((comp.isQuitado()) ? "Sim" : "Não")});

            }

        } catch (SQLException ex) {
            Mensagens.erro("Erro ao tentar lista os Compromisso: " + ex.getMessage());
        }

    }

    private void preencherTabelaBoleto() {

        try {

            Compromisso comp = membro.getListaCompromisso().get(linhaCompromisso);

            comp.setListaBoletos(boDao.listarTodosCompromisso(comp.getCodigo()));

            DefaultTableModel modelo = (DefaultTableModel) tabelaBoleto.getModel();

            limparTabela(modelo);

            for (Boleto bo : comp.getListaBoletos()) {
                modelo.addRow(new String[]{String.valueOf(bo.getNumeroParcela()), formatar.format(bo.getDataVencimento()), String.valueOf(bo.getValor()), ((bo.isQuitado()) ? "Sim" : "Não")});

            }
        } catch (SQLException ex) {
            Mensagens.erro("Erro ao tentar lista os Compromisso: " + ex.getMessage());
        }

    }

}

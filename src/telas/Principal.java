package telas;

import dao.CaixaDAO;
import entidades.Usuario;
import java.awt.Dimension;
import java.sql.SQLException;
import javax.swing.JInternalFrame;
import telas.caixa.FecharCaixa;
import telas.compromisso.CompromissoDeus;
import telas.membro.ManterMembro;
import telas.projeto.ManterProjeto;
import telas.receber.ConsultarCompromisso;
import telas.usuario.ManterUsuario;
import util.Mensagens;

public class Principal extends javax.swing.JFrame {

    private final Usuario usu;
    private final CaixaDAO caiDao;

    public Principal(Usuario usu) {

        this.caiDao = new CaixaDAO();
        this.usu = usu;
        initComponents();
        buscarCaixaAberto();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem6 = new javax.swing.JMenuItem();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        desktop = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();

        jMenuItem6.setText("jMenuItem6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Controle de Matenedores");
        setExtendedState(MAXIMIZED_BOTH);
        setIconImage(util.IconeTela.buscarIcone(this));

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.setPreferredSize(new java.awt.Dimension(100, 30));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/nova.png"))); // NOI18N
        jButton1.setText("Cadastro Compromisso");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/procurar.png"))); // NOI18N
        jButton2.setText("Consultar Compromisso");
        jButton2.setFocusable(false);
        jButton2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 458, Short.MAX_VALUE)
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 209, Short.MAX_VALUE)
        );

        getContentPane().add(desktop, java.awt.BorderLayout.CENTER);

        jMenu1.setText("Cadastro");

        jMenuItem1.setText("Cadastro Usuario");
        jMenuItem1.setEnabled(usu.isAdm());
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Cadastro Projeto");
        jMenuItem2.setEnabled(usu.isAdm());
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Cadastro Membros");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Caixa");

        jMenuItem4.setText("Abrir Caixa");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem5.setText("Fechar Caixa");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

        iniciarVinculo(new ManterUsuario(this));

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        iniciarVinculo(new ManterProjeto(this));
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        iniciarVinculo(new ManterMembro(this));
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed

        if (this.usu.getCaixa() != null) {
            Mensagens.atenção("Você já possui um Caixa aberto.");
        } else if (Mensagens.perguntar("Tem certeza que deseja abrir o CAIXA?") == 0) {

            try {
                this.caiDao.abrir(this.usu.getCpf());

                buscarCaixaAberto();

                Mensagens.sucesso();

            } catch (SQLException ex) {
                Mensagens.erro("Houve um erro ao abrir o Caixa: " + ex.getMessage());
            }

        }

    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed

        if (this.usu.getCaixa() == null) {
            Mensagens.atenção("Usuario " + usu.getNome() + " não possui um caixa aberto.");
        } else {
            iniciarVinculo(new FecharCaixa(this.caiDao, this.usu));

        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        iniciarVinculo(new CompromissoDeus(this, this.usu));

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        iniciarVinculo(new ConsultarCompromisso(this, this.usu));

    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables

    private void setPosicao(JInternalFrame interno) {
        Dimension d = this.desktop.getSize();
        interno.setLocation((d.width - interno.getSize().width) / 2, (d.height - interno.getSize().height) / 2);
    }

    private void iniciarVinculo(JInternalFrame frame) {
        desktop.add(frame);
        setPosicao(frame);
        frame.show();
    }

    private void buscarCaixaAberto() {
        try {
            this.usu.setCaixa(this.caiDao.buscarCaixaAberto(this.usu.getCpf()));
        } catch (SQLException ex) {
            Mensagens.erro("Houve um erro ao buscar o Caixa: " + ex.getMessage());
        }
    }

}

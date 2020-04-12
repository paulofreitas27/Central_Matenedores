package telas.usuario;

import dao.UsuarioDAO;
import entidades.Usuario;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import util.Mensagens;
import util.TamanhoFixo;

public class CadastroUsuario extends javax.swing.JDialog {

    private Usuario usu;
    private final UsuarioDAO usuDao;

    public CadastroUsuario(java.awt.Frame parent, boolean modal, UsuarioDAO usuDao) {
        super(parent, modal);

        this.usuDao = usuDao;

        initComponents();

        btSalvar.addActionListener(this::Salvar);

    }

    /**
     * Criando formulario para alterar o Usuario
     *
     * @param parent
     * @param modal
     * @param usuDao
     * @param usu
     */
    public CadastroUsuario(java.awt.Frame parent, boolean modal, UsuarioDAO usuDao, Usuario usu) {
        super(parent, modal);

        this.usu = usu;
        this.usuDao = usuDao;

        initComponents();

        txtCPF.setEnabled(false);

        jcAtivo.setEnabled(true);

        btSalvar.addActionListener(this::alterar);

        btSalvar.setText("Alterar");

        preencherCampos();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jcAtivo = new javax.swing.JCheckBox();
        jcADM = new javax.swing.JCheckBox();
        txtCPF = new javax.swing.JFormattedTextField();
        txtNome = new javax.swing.JTextField();
        txtSenha = new javax.swing.JPasswordField();
        btSalvar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("C.P.F:");

        jLabel2.setText("Nome:");

        jLabel3.setText("Senha:");

        jcAtivo.setSelected(true);
        jcAtivo.setText("Ativo");
        jcAtivo.setEnabled(false);

        jcADM.setText("Administrador");

        try {
            txtCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        txtNome.setDocument(new TamanhoFixo(60));
        txtNome.setDocument(new TamanhoFixo(60));
        txtNome.setToolTipText("No maxímo 60 caractere.");

        txtSenha.setDocument(new TamanhoFixo(10));
        txtSenha.setToolTipText("No maxímo 60 caractere");

        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/novo.png"))); // NOI18N
        btSalvar.setText("Salvar");

        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excluir.png"))); // NOI18N
        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(jcADM)
                        .addGap(40, 40, 40)
                        .addComponent(jcAtivo, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtNome)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btSalvar)
                        .addGap(18, 18, 18)
                        .addComponent(btCancelar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jcADM)
                    .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcAtivo))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSalvar)
                    .addComponent(btCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JCheckBox jcADM;
    private javax.swing.JCheckBox jcAtivo;
    private javax.swing.JFormattedTextField txtCPF;
    private javax.swing.JTextField txtNome;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables

    private void alterar(ActionEvent evt) {

        if (verificarCampos()) {

            popular();

            try {
                this.usuDao.alterar(usu);

                Mensagens.sucesso();

                this.dispose();

            } catch (SQLException ex) {
                Mensagens.erro("Erro ao tentar Alterar: " + ex.getMessage()
                );
            }

        }

    }

    private void Salvar(ActionEvent evt) {

        if (verificarCampos()) {

            this.usu = new Usuario();

            this.usu.setCpf(txtCPF.getText());

            popular();

            try {
                this.usuDao.salvar(usu);

                Mensagens.sucesso();

                this.dispose();

            } catch (SQLException ex) {
                Mensagens.erro("Erro ao tentar Salvar: " + ex.getMessage());
            }

        }

    }

    private boolean verificarCampos() {

        boolean conf = false;

        if (txtCPF.getText().trim().length() < 14) {
            Mensagens.atenção("O campo CPF é obrigatório.");
            txtCPF.requestFocus();
        } else if (txtNome.getText().trim().isEmpty()) {
            Mensagens.atenção("O campo Nome é obrigatório.");
            txtNome.requestFocus();
        } else if (getSenha().trim().isEmpty()) {
            Mensagens.atenção("O campo Senha é obrigatório.");
            txtCPF.requestFocus();
        } else {
            conf = true;
        }

        return conf;

    }

    private String getSenha() {
        char[] s = txtSenha.getPassword();
        String senha = "";
        for (char c : s) {
            senha += c;
        }
        return senha;
    }

    private void popular() {

        this.usu.setNome(txtNome.getText().trim());
        this.usu.setSenha(getSenha());
        this.usu.setAdm(jcADM.isSelected());
        this.usu.setAtivo(jcAtivo.isSelected());

    }

    private void preencherCampos() {

        txtCPF.setText(this.usu.getCpf());
        txtNome.setText(this.usu.getNome());
        txtSenha.setText(this.usu.getSenha());

        jcADM.setSelected(this.usu.isAdm());
        jcAtivo.setSelected(this.usu.isAtivo());

    }

}

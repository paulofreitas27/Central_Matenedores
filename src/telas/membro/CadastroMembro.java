package telas.membro;

import dao.MembroDAO;
import entidades.Membro;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import util.Mensagens;
import util.TamanhoFixo;

public class CadastroMembro extends javax.swing.JDialog {

    private Membro mem;
    private final MembroDAO memDao;

    public CadastroMembro(java.awt.Frame parent, boolean modal, MembroDAO memDao) {
        super(parent, modal);

        this.memDao = memDao;

        initComponents();

        btSalvar.addActionListener(this::Salvar);

    }

    /**
     * Criando formulario para alterar
     *
     * @param parent
     * @param modal
     * @param memDao
     * @param mem
     */
    public CadastroMembro(java.awt.Frame parent, boolean modal, MembroDAO memDao, Membro mem) {
        super(parent, modal);

        this.mem = mem;
        this.memDao = memDao;

        initComponents();

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

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        btSalvar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        txtFone = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setText("Nome:");

        jLabel3.setText("Celular:");

        txtNome.setDocument(new TamanhoFixo(60));
        txtNome.setToolTipText("No maxímo 60 caractere.");

        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/salvar.png"))); // NOI18N
        btSalvar.setText("Salvar");

        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excluir.png"))); // NOI18N
        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        try {
            txtFone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtFone, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(jLabel2)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(btSalvar)
                    .addComponent(btCancelar)
                    .addComponent(txtFone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JFormattedTextField txtFone;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables

    private void alterar(ActionEvent evt) {

        if (verificarCampos()) {

            popular();

            try {
                this.memDao.alterar(mem);

                Mensagens.sucesso();

                this.dispose();

            } catch (SQLException ex) {
                Mensagens.erro("Erro ao tentar Alterar: " + ex.getMessage());
            }

        }

    }

    private void Salvar(ActionEvent evt) {

        if (verificarCampos()) {

            this.mem = new Membro();

            popular();

            try {
                this.memDao.salvar(mem);

                Mensagens.sucesso();

                this.dispose();

            } catch (SQLException ex) {
                if (ex.getMessage().contains("Duplicate")) {
                    Mensagens.erro("O Numero telefone já existe no cadastro!");
                } else {
                    Mensagens.erro("Erro ao tentar Salvar: " + ex.getMessage());
                }
            }

        }

    }

    private boolean verificarCampos() {

        boolean conf = false;

        if (txtNome.getText().trim().isEmpty()) {
            Mensagens.atenção("O campo Nome é obrigatório.");
            txtNome.requestFocus();
        } else if (txtFone.getText().trim().length() < 10) {
            Mensagens.atenção("O campo Fone é obrigatório.");
            txtFone.requestFocus();
        } else {
            conf = true;
        }

        return conf;

    }

    private void popular() {

        this.mem.setNome(txtNome.getText().trim());
        this.mem.setFone(txtFone.getText());

    }

    private void preencherCampos() {

        txtNome.setText(this.mem.getNome());
        txtFone.setText(this.mem.getFone());

    }

}

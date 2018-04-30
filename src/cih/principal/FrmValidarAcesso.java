package cih.principal;

import cci.CtrlPrincipal;
import java.awt.event.KeyEvent;

public class FrmValidarAcesso extends javax.swing.JFrame {

    private CtrlPrincipal ctrlPrincipal;

    public FrmValidarAcesso(CtrlPrincipal ctrlPrincipal) {
        this.ctrlPrincipal = ctrlPrincipal;
        initComponents();
        setarBackground();
    }

    private void setarBackground(){
        pnlExterior.setBackground(ctrlPrincipal.setarCorPanelExterior());
        pnlInterior.setBackground(ctrlPrincipal.setarCorPanelInterior());
    }
    
    public void limparCampos(){
        jTextFieldLogin.setText("");
        jPasswordFieldSenha.setText("");
    }
    
    private void validarAcesso(){
        String login = jTextFieldLogin.getText();
        String senha = jPasswordFieldSenha.getText();
        
        ctrlPrincipal.validarAcesso(login, senha);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlExterior = new javax.swing.JPanel();
        pnlInterior = new javax.swing.JPanel();
        jPasswordFieldSenha = new javax.swing.JPasswordField();
        jLabelSenha = new javax.swing.JLabel();
        btnEntrar = new javax.swing.JButton();
        jTextFieldLogin = new javax.swing.JTextField();
        jLabelUsuario = new javax.swing.JLabel();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Validar Acesso");
        setResizable(false);

        pnlExterior.setBackground(new java.awt.Color(53, 151, 48));
        pnlExterior.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        pnlInterior.setBackground(new java.awt.Color(0, 204, 102));

        jPasswordFieldSenha.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jPasswordFieldSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordFieldSenhaKeyPressed(evt);
            }
        });

        jLabelSenha.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabelSenha.setText("Senha:");

        btnEntrar.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        btnEntrar.setText("Entrar");
        btnEntrar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });
        btnEntrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnEntrarKeyPressed(evt);
            }
        });

        jTextFieldLogin.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N

        jLabelUsuario.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabelUsuario.setText("Usuário:");

        btnSair.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        btnSair.setText("Sair");
        btnSair.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        btnSair.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnSairKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout pnlInteriorLayout = new javax.swing.GroupLayout(pnlInterior);
        pnlInterior.setLayout(pnlInteriorLayout);
        pnlInteriorLayout.setHorizontalGroup(
            pnlInteriorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInteriorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlInteriorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPasswordFieldSenha)
                    .addComponent(jTextFieldLogin)
                    .addGroup(pnlInteriorLayout.createSequentialGroup()
                        .addGroup(pnlInteriorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelSenha)
                            .addComponent(jLabelUsuario))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlInteriorLayout.createSequentialGroup()
                        .addComponent(btnEntrar, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlInteriorLayout.setVerticalGroup(
            pnlInteriorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInteriorLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabelUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordFieldSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addGroup(pnlInteriorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlExteriorLayout = new javax.swing.GroupLayout(pnlExterior);
        pnlExterior.setLayout(pnlExteriorLayout);
        pnlExteriorLayout.setHorizontalGroup(
            pnlExteriorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlExteriorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlInterior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlExteriorLayout.setVerticalGroup(
            pnlExteriorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlExteriorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlInterior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlExterior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlExterior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        validarAcesso(); 
    }//GEN-LAST:event_btnEntrarActionPerformed

    private void jPasswordFieldSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldSenhaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            validarAcesso();
        }
    }//GEN-LAST:event_jPasswordFieldSenhaKeyPressed

    private void btnEntrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnEntrarKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            validarAcesso();
        }
    }//GEN-LAST:event_btnEntrarKeyPressed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnSairKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSairKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            this.dispose();
        }
    }//GEN-LAST:event_btnSairKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntrar;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabelSenha;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JPasswordField jPasswordFieldSenha;
    private javax.swing.JTextField jTextFieldLogin;
    private javax.swing.JPanel pnlExterior;
    private javax.swing.JPanel pnlInterior;
    // End of variables declaration//GEN-END:variables
}

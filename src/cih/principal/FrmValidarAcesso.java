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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlExterior = new javax.swing.JPanel();
        pnlInterior = new javax.swing.JPanel();
        jPasswordFieldSenha = new javax.swing.JPasswordField();
        jLabelSenha = new javax.swing.JLabel();
        jButtonEntrar = new javax.swing.JButton();
        jTextFieldLogin = new javax.swing.JTextField();
        jLabelUsuario = new javax.swing.JLabel();

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

        jButtonEntrar.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        jButtonEntrar.setText("Entrar");
        jButtonEntrar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButtonEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEntrarActionPerformed(evt);
            }
        });
        jButtonEntrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButtonEntrarKeyPressed(evt);
            }
        });

        jTextFieldLogin.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N

        jLabelUsuario.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabelUsuario.setText("Usuário:");

        javax.swing.GroupLayout pnlInteriorLayout = new javax.swing.GroupLayout(pnlInterior);
        pnlInterior.setLayout(pnlInteriorLayout);
        pnlInteriorLayout.setHorizontalGroup(
            pnlInteriorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInteriorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlInteriorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPasswordFieldSenha)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInteriorLayout.createSequentialGroup()
                        .addGap(0, 217, Short.MAX_VALUE)
                        .addComponent(jButtonEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextFieldLogin)
                    .addGroup(pnlInteriorLayout.createSequentialGroup()
                        .addGroup(pnlInteriorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelSenha)
                            .addComponent(jLabelUsuario))
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void jButtonEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEntrarActionPerformed
        
        String login = jTextFieldLogin.getText();
        String senha = jPasswordFieldSenha.getText();
        
        ctrlPrincipal.validarAcesso(login, senha);
    }//GEN-LAST:event_jButtonEntrarActionPerformed

    private void jPasswordFieldSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldSenhaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            jButtonEntrarActionPerformed(null);
        }
    }//GEN-LAST:event_jPasswordFieldSenhaKeyPressed

    private void jButtonEntrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonEntrarKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            jButtonEntrarActionPerformed(null);
        }
    }//GEN-LAST:event_jButtonEntrarKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEntrar;
    private javax.swing.JLabel jLabelSenha;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JPasswordField jPasswordFieldSenha;
    private javax.swing.JTextField jTextFieldLogin;
    private javax.swing.JPanel pnlExterior;
    private javax.swing.JPanel pnlInterior;
    // End of variables declaration//GEN-END:variables
}

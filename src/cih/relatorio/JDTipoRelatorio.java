package cih.relatorio;

import cci.CtrlPrincipal;
import java.awt.Frame;

public class JDTipoRelatorio extends javax.swing.JDialog {
    
    private CtrlPrincipal ctrlPrincipal;
    private Frame pai;

    public JDTipoRelatorio(java.awt.Frame parent, boolean modal, CtrlPrincipal ctrl) {
        super(parent, modal);
        this.ctrlPrincipal = ctrl;
        this.pai = parent;
        initComponents();
        setarBackground();
    }
    
    private void setarBackground(){
        pnlPrincipal.setBackground(ctrlPrincipal.setarCorPanelExterior());
        pnlConfiguracoes.setBackground(ctrlPrincipal.setarCorPanelExterior());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grpFiltros = new javax.swing.ButtonGroup();
        pnlPrincipal = new javax.swing.JPanel();
        pnlConfiguracoes = new javax.swing.JPanel();
        btnProfessores = new javax.swing.JButton();
        btnTurmas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tipos de Relatórios");
        setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        setMinimumSize(new java.awt.Dimension(100, 80));
        setResizable(false);
        setSize(new java.awt.Dimension(1366, 788));

        pnlPrincipal.setBackground(new java.awt.Color(0, 153, 102));
        pnlPrincipal.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        pnlPrincipal.setMaximumSize(new java.awt.Dimension(1920, 790));

        pnlConfiguracoes.setBackground(new java.awt.Color(0, 153, 102));
        pnlConfiguracoes.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        btnProfessores.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        btnProfessores.setForeground(new java.awt.Color(255, 255, 255));
        btnProfessores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/prof_reduzido.png"))); // NOI18N
        btnProfessores.setText("Professores");
        btnProfessores.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnProfessores.setContentAreaFilled(false);
        btnProfessores.setFocusable(false);
        btnProfessores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfessoresActionPerformed(evt);
            }
        });

        btnTurmas.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        btnTurmas.setForeground(new java.awt.Color(255, 255, 255));
        btnTurmas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/turma_reduzida.png"))); // NOI18N
        btnTurmas.setText("Turmas");
        btnTurmas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnTurmas.setContentAreaFilled(false);
        btnTurmas.setFocusable(false);
        btnTurmas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTurmasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlConfiguracoesLayout = new javax.swing.GroupLayout(pnlConfiguracoes);
        pnlConfiguracoes.setLayout(pnlConfiguracoesLayout);
        pnlConfiguracoesLayout.setHorizontalGroup(
            pnlConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlConfiguracoesLayout.createSequentialGroup()
                .addContainerGap(94, Short.MAX_VALUE)
                .addGroup(pnlConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnProfessores, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(btnTurmas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(92, 92, 92))
        );
        pnlConfiguracoesLayout.setVerticalGroup(
            pnlConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlConfiguracoesLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(btnProfessores, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnTurmas, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlConfiguracoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlConfiguracoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(pnlPrincipal, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnProfessoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfessoresActionPerformed
        ctrlPrincipal.getCtrlRelatorio().instanciarTelaRelatorioProfessor(pai);
    }//GEN-LAST:event_btnProfessoresActionPerformed

    private void btnTurmasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTurmasActionPerformed
        ctrlPrincipal.getCtrlRelatorio().instanciarTelaRelatorioTurma(pai);
    }//GEN-LAST:event_btnTurmasActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProfessores;
    private javax.swing.JButton btnTurmas;
    private javax.swing.ButtonGroup grpFiltros;
    private javax.swing.JPanel pnlConfiguracoes;
    private javax.swing.JPanel pnlPrincipal;
    // End of variables declaration//GEN-END:variables
}

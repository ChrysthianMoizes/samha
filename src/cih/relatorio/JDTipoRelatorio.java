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
        pnlConfiguracoes.setBackground(ctrlPrincipal.setarCorPanelInterior());
    }
    
    private void identificarTipoRelatorio(){
        char tipo = (char) grpFiltros.getSelection().getMnemonic();
        ctrlPrincipal.getCtrlRelatorio().identificarTipoRelatorio(pai, tipo);      
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grpFiltros = new javax.swing.ButtonGroup();
        pnlPrincipal = new javax.swing.JPanel();
        pnlConfiguracoes = new javax.swing.JPanel();
        btnGerar = new javax.swing.JButton();
        lblEixo = new javax.swing.JLabel();
        rbtnTurma = new javax.swing.JRadioButton();
        rbtnCurso = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tipos de Relatórios");
        setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        setMinimumSize(new java.awt.Dimension(100, 80));
        setResizable(false);
        setSize(new java.awt.Dimension(1366, 788));

        pnlPrincipal.setBackground(new java.awt.Color(53, 151, 48));
        pnlPrincipal.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        pnlPrincipal.setMaximumSize(new java.awt.Dimension(1920, 790));

        pnlConfiguracoes.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Relatórios", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 1, 14))); // NOI18N

        btnGerar.setBackground(new java.awt.Color(255, 255, 255));
        btnGerar.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        btnGerar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/relatorio-botao.png"))); // NOI18N
        btnGerar.setText("OK");
        btnGerar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnGerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerarActionPerformed(evt);
            }
        });

        lblEixo.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblEixo.setText("Selecione o tipo do relatório:");
        lblEixo.setToolTipText("");

        grpFiltros.add(rbtnTurma);
        rbtnTurma.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        rbtnTurma.setMnemonic('p');
        rbtnTurma.setSelected(true);
        rbtnTurma.setText("Professor");

        grpFiltros.add(rbtnCurso);
        rbtnCurso.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        rbtnCurso.setMnemonic('t');
        rbtnCurso.setText("Turma");

        javax.swing.GroupLayout pnlConfiguracoesLayout = new javax.swing.GroupLayout(pnlConfiguracoes);
        pnlConfiguracoes.setLayout(pnlConfiguracoesLayout);
        pnlConfiguracoesLayout.setHorizontalGroup(
            pnlConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlConfiguracoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblEixo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlConfiguracoesLayout.createSequentialGroup()
                        .addGroup(pnlConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbtnCurso)
                            .addComponent(rbtnTurma))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlConfiguracoesLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnGerar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlConfiguracoesLayout.setVerticalGroup(
            pnlConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlConfiguracoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblEixo, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rbtnTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rbtnCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGerar)
                .addContainerGap())
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

    private void btnGerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarActionPerformed
        identificarTipoRelatorio();
    }//GEN-LAST:event_btnGerarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGerar;
    private javax.swing.ButtonGroup grpFiltros;
    private javax.swing.JLabel lblEixo;
    private javax.swing.JPanel pnlConfiguracoes;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JRadioButton rbtnCurso;
    private javax.swing.JRadioButton rbtnTurma;
    // End of variables declaration//GEN-END:variables
}

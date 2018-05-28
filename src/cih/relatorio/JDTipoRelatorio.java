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
        lblEixo = new javax.swing.JLabel();
        rbtnTurma = new javax.swing.JRadioButton();
        rbtnCurso = new javax.swing.JRadioButton();
        btnEntrar = new javax.swing.JButton();

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
        pnlConfiguracoes.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        lblEixo.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        lblEixo.setForeground(new java.awt.Color(255, 255, 255));
        lblEixo.setText("Selecione o tipo do relatório:");
        lblEixo.setToolTipText("");

        rbtnTurma.setBackground(new java.awt.Color(0, 153, 102));
        grpFiltros.add(rbtnTurma);
        rbtnTurma.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        rbtnTurma.setForeground(new java.awt.Color(255, 255, 255));
        rbtnTurma.setMnemonic('p');
        rbtnTurma.setSelected(true);
        rbtnTurma.setText("Professor");

        rbtnCurso.setBackground(new java.awt.Color(0, 153, 102));
        grpFiltros.add(rbtnCurso);
        rbtnCurso.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        rbtnCurso.setForeground(new java.awt.Color(255, 255, 255));
        rbtnCurso.setMnemonic('t');
        rbtnCurso.setText("Turma");

        btnEntrar.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        btnEntrar.setForeground(new java.awt.Color(255, 255, 255));
        btnEntrar.setText("Visualizar");
        btnEntrar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEntrar.setContentAreaFilled(false);
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlConfiguracoesLayout = new javax.swing.GroupLayout(pnlConfiguracoes);
        pnlConfiguracoes.setLayout(pnlConfiguracoesLayout);
        pnlConfiguracoesLayout.setHorizontalGroup(
            pnlConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlConfiguracoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEixo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlConfiguracoesLayout.createSequentialGroup()
                        .addGroup(pnlConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbtnCurso)
                            .addComponent(rbtnTurma))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlConfiguracoesLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlConfiguracoesLayout.setVerticalGroup(
            pnlConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlConfiguracoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblEixo, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rbtnTurma)
                .addGap(10, 10, 10)
                .addComponent(rbtnCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(pnlConfiguracoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(pnlPrincipal, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        identificarTipoRelatorio();
    }//GEN-LAST:event_btnEntrarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntrar;
    private javax.swing.ButtonGroup grpFiltros;
    private javax.swing.JLabel lblEixo;
    private javax.swing.JPanel pnlConfiguracoes;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JRadioButton rbtnCurso;
    private javax.swing.JRadioButton rbtnTurma;
    // End of variables declaration//GEN-END:variables
}

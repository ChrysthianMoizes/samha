package cih.oferta;

import cci.CtrlPrincipal;
import cdp.Curso;
import javax.swing.JPanel;

public class JDOferta extends javax.swing.JDialog {
    
    private CtrlPrincipal ctrlPrincipal;

    public JDOferta(java.awt.Frame parent, boolean modal, CtrlPrincipal ctrl) {
        super(parent, modal);
        initComponents();
        this.ctrlPrincipal = ctrl;
        setarBackground();
    }
    
    private void setarBackground(){
        pnlPrincipal.setBackground(ctrlPrincipal.setarCorPanelExterior());
        pnlAlocacoes.setBackground(ctrlPrincipal.setarCorPanelInterior());
        pnlNotificacoes.setBackground(ctrlPrincipal.setarCorPanelInterior());
        pnlCentral.setBackground(ctrlPrincipal.setarCorPanelInterior());
        pnlValidacao.setBackground(ctrlPrincipal.setarCorPanelInterior());
        pnlConfiguracao.setBackground(ctrlPrincipal.setarCorPanelInterior());
    }
    
    public void atualizarLista(){
        
        lblMensagem.setText("");
        
        int ano = (int) spnAno.getValue();
        int semestre = (int) spnSemestre.getValue();
        
        ctrlPrincipal.getCtrlOferta().preencherListaAlocacoes(ano, semestre, cbxTurma, lstAlocacoes);
    }
    
    public void preencherComboCurso(){ 
        ctrlPrincipal.getCtrlOferta().preencherComboCurso(cbxCurso, cbxTurma);
    }
    
    public void trocarPanel(JPanel jPanel) {
        pnlCentral.removeAll();
        pnlCentral.add(jPanel);
        pnlCentral.validate();
        pnlCentral.repaint();
    }
    
    public void setarMensagem(String mensagem){
        lblMensagem.setText(mensagem);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPrincipal = new javax.swing.JPanel();
        pnlAlocacoes = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstAlocacoes = new javax.swing.JList<>();
        pnlNotificacoes = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaNotificacoes = new javax.swing.JTextArea();
        pnlCentral = new javax.swing.JPanel();
        pnlValidacao = new javax.swing.JPanel();
        btnValidar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        lblTempoMaximo = new javax.swing.JLabel();
        txtTempoMaximo = new javax.swing.JTextField();
        lblIntervaloMinimo = new javax.swing.JLabel();
        txtIntervaloMinimo = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        pnlConfiguracao = new javax.swing.JPanel();
        cbxCurso = new javax.swing.JComboBox<>();
        cbxTurma = new javax.swing.JComboBox<>();
        lblAno = new javax.swing.JLabel();
        spnAno = new javax.swing.JSpinner();
        lblSemestre = new javax.swing.JLabel();
        spnSemestre = new javax.swing.JSpinner();
        jSeparator2 = new javax.swing.JSeparator();
        lblMensagem = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Montar Oferta");

        pnlPrincipal.setBackground(new java.awt.Color(53, 151, 48));

        pnlAlocacoes.setBackground(new java.awt.Color(0, 204, 102));
        pnlAlocacoes.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Alocações", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 1, 14))); // NOI18N

        lstAlocacoes.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jScrollPane3.setViewportView(lstAlocacoes);

        javax.swing.GroupLayout pnlAlocacoesLayout = new javax.swing.GroupLayout(pnlAlocacoes);
        pnlAlocacoes.setLayout(pnlAlocacoesLayout);
        pnlAlocacoesLayout.setHorizontalGroup(
            pnlAlocacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAlocacoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        pnlAlocacoesLayout.setVerticalGroup(
            pnlAlocacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAlocacoesLayout.createSequentialGroup()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );

        pnlNotificacoes.setBackground(new java.awt.Color(0, 204, 102));
        pnlNotificacoes.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Notificações", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 1, 14))); // NOI18N

        txtAreaNotificacoes.setEditable(false);
        txtAreaNotificacoes.setColumns(20);
        txtAreaNotificacoes.setLineWrap(true);
        txtAreaNotificacoes.setRows(5);
        txtAreaNotificacoes.setBorder(null);
        jScrollPane1.setViewportView(txtAreaNotificacoes);

        javax.swing.GroupLayout pnlNotificacoesLayout = new javax.swing.GroupLayout(pnlNotificacoes);
        pnlNotificacoes.setLayout(pnlNotificacoesLayout);
        pnlNotificacoesLayout.setHorizontalGroup(
            pnlNotificacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNotificacoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlNotificacoesLayout.setVerticalGroup(
            pnlNotificacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNotificacoesLayout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlCentralLayout = new javax.swing.GroupLayout(pnlCentral);
        pnlCentral.setLayout(pnlCentralLayout);
        pnlCentralLayout.setHorizontalGroup(
            pnlCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 595, Short.MAX_VALUE)
        );
        pnlCentralLayout.setVerticalGroup(
            pnlCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 767, Short.MAX_VALUE)
        );

        btnValidar.setBackground(new java.awt.Color(255, 255, 255));
        btnValidar.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        btnValidar.setText("Validar Ofertas");
        btnValidar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnValidar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValidarActionPerformed(evt);
            }
        });

        btnSalvar.setBackground(new java.awt.Color(255, 255, 255));
        btnSalvar.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        lblTempoMaximo.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblTempoMaximo.setText("Tempo Máximo:");
        lblTempoMaximo.setToolTipText("");

        txtTempoMaximo.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        txtTempoMaximo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTempoMaximo.setText("11");

        lblIntervaloMinimo.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblIntervaloMinimo.setText("Intervalo Mínimo:");

        txtIntervaloMinimo.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        txtIntervaloMinimo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIntervaloMinimo.setText("11");

        javax.swing.GroupLayout pnlValidacaoLayout = new javax.swing.GroupLayout(pnlValidacao);
        pnlValidacao.setLayout(pnlValidacaoLayout);
        pnlValidacaoLayout.setHorizontalGroup(
            pnlValidacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlValidacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlValidacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnValidar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlValidacaoLayout.createSequentialGroup()
                        .addGroup(pnlValidacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlValidacaoLayout.createSequentialGroup()
                                .addComponent(lblIntervaloMinimo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(pnlValidacaoLayout.createSequentialGroup()
                                .addComponent(lblTempoMaximo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(35, 35, 35)))
                        .addGroup(pnlValidacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTempoMaximo, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                            .addComponent(txtIntervaloMinimo))))
                .addContainerGap())
        );
        pnlValidacaoLayout.setVerticalGroup(
            pnlValidacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlValidacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlValidacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTempoMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTempoMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlValidacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIntervaloMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIntervaloMinimo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnValidar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        cbxCurso.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        cbxCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCursoActionPerformed(evt);
            }
        });

        cbxTurma.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        cbxTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTurmaActionPerformed(evt);
            }
        });

        lblAno.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblAno.setText("Ano:");

        spnAno.setFont(new java.awt.Font("DialogInput", 0, 16)); // NOI18N
        spnAno.setModel(new javax.swing.SpinnerNumberModel(2015, 2000, null, 1));
        spnAno.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnAnoStateChanged(evt);
            }
        });

        lblSemestre.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblSemestre.setText("Semestre:");

        spnSemestre.setFont(new java.awt.Font("DialogInput", 0, 16)); // NOI18N
        spnSemestre.setModel(new javax.swing.SpinnerNumberModel(1, 1, 2, 1));
        spnSemestre.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnSemestreStateChanged(evt);
            }
        });

        lblMensagem.setFont(new java.awt.Font("DialogInput", 1, 16)); // NOI18N
        lblMensagem.setForeground(new java.awt.Color(229, 0, 0));

        javax.swing.GroupLayout pnlConfiguracaoLayout = new javax.swing.GroupLayout(pnlConfiguracao);
        pnlConfiguracao.setLayout(pnlConfiguracaoLayout);
        pnlConfiguracaoLayout.setHorizontalGroup(
            pnlConfiguracaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlConfiguracaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlConfiguracaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlConfiguracaoLayout.createSequentialGroup()
                        .addComponent(cbxCurso, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(9, 9, 9))
                    .addGroup(pnlConfiguracaoLayout.createSequentialGroup()
                        .addComponent(cbxTurma, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(pnlConfiguracaoLayout.createSequentialGroup()
                        .addComponent(lblAno, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(spnAno, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addComponent(lblSemestre)
                        .addGap(18, 18, 18)
                        .addComponent(spnSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlConfiguracaoLayout.createSequentialGroup()
                        .addComponent(jSeparator2)
                        .addContainerGap())
                    .addComponent(lblMensagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        pnlConfiguracaoLayout.setVerticalGroup(
            pnlConfiguracaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlConfiguracaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbxCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbxTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlConfiguracaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spnSemestre, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(lblAno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSemestre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(spnAno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlConfiguracao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlAlocacoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlCentral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlNotificacoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlValidacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlCentral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addComponent(pnlValidacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlNotificacoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addComponent(pnlConfiguracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlAlocacoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        getContentPane().add(pnlPrincipal, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnValidarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnValidarActionPerformed

    }//GEN-LAST:event_btnValidarActionPerformed

    private void cbxTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTurmaActionPerformed
        atualizarLista();
    }//GEN-LAST:event_cbxTurmaActionPerformed

    private void cbxCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCursoActionPerformed
        Curso curso = (Curso) cbxCurso.getSelectedItem();
        if(curso != null){
           ctrlPrincipal.getCtrlOferta().preencherComboTurma(curso.getId(), cbxTurma);
        }
    }//GEN-LAST:event_cbxCursoActionPerformed

    private void spnAnoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnAnoStateChanged
        atualizarLista();
    }//GEN-LAST:event_spnAnoStateChanged

    private void spnSemestreStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnSemestreStateChanged
        atualizarLista();
    }//GEN-LAST:event_spnSemestreStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnValidar;
    private javax.swing.JComboBox<String> cbxCurso;
    private javax.swing.JComboBox<String> cbxTurma;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblAno;
    private javax.swing.JLabel lblIntervaloMinimo;
    private javax.swing.JLabel lblMensagem;
    private javax.swing.JLabel lblSemestre;
    private javax.swing.JLabel lblTempoMaximo;
    private javax.swing.JList<String> lstAlocacoes;
    private javax.swing.JPanel pnlAlocacoes;
    private javax.swing.JPanel pnlCentral;
    private javax.swing.JPanel pnlConfiguracao;
    private javax.swing.JPanel pnlNotificacoes;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JPanel pnlValidacao;
    private javax.swing.JSpinner spnAno;
    private javax.swing.JSpinner spnSemestre;
    private javax.swing.JTextArea txtAreaNotificacoes;
    private javax.swing.JTextField txtIntervaloMinimo;
    private javax.swing.JTextField txtTempoMaximo;
    // End of variables declaration//GEN-END:variables
}

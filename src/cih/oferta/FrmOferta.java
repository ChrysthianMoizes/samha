package cih.oferta;

import cci.CtrlPrincipal;
import cdp.Curso;
import cdp.Turma;
import java.awt.Frame;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class FrmOferta extends javax.swing.JFrame {
    
    private CtrlPrincipal ctrlPrincipal;
    private List<Curso> listaCursos;
    private List<Turma> listaTurma;

    public FrmOferta(CtrlPrincipal ctrlPrincipal) {
        this.ctrlPrincipal = ctrlPrincipal;
        initComponents();
        ImageIcon icone = ctrlPrincipal.setarIconeJanela();
        setIconImage(icone.getImage());
        this.setExtendedState(Frame.MAXIMIZED_BOTH);
        preencherComboCurso();
    }
    
    public void preencherComboCurso(){ 
        listaCursos = ctrlPrincipal.getCtrlCurso().listar();
        cbxCurso.removeAllItems();
        cbxCurso.setModel(new DefaultComboBoxModel(listaCursos.toArray()));
        
        if(listaCursos.size() > 0){
            Curso curso = (Curso) cbxCurso.getSelectedItem();
            preencherComboTurma(curso.getId());
        }  
    }
    
    public void preencherComboTurma(int id) {
        listaTurma = ctrlPrincipal.getCtrlTurma().buscar("curso", String.valueOf(id));
        cbxTurma.removeAllItems();
        cbxTurma.setModel(new DefaultComboBoxModel(listaTurma.toArray())); 
    }
    
    public void trocarPanel(JPanel jPanel) {
        pnlTurma.removeAll();
        pnlTurma.add(jPanel);
        pnlTurma.validate();
        pnlTurma.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator14 = new javax.swing.JSeparator();
        pnlPrincipal = new javax.swing.JPanel();
        pnlAlocacoes = new javax.swing.JPanel();
        cbxCurso = new javax.swing.JComboBox<>();
        cbxTurma = new javax.swing.JComboBox<>();
        lblTempoMaximo = new javax.swing.JLabel();
        lblIntervaloMinimo = new javax.swing.JLabel();
        txtTempoMaximo = new javax.swing.JTextField();
        txtIntervaloMinimo = new javax.swing.JTextField();
        separadorLateral = new javax.swing.JSeparator();
        lblAlocacoes = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        lblCurso = new javax.swing.JLabel();
        lblTurma = new javax.swing.JLabel();
        btnValidar = new javax.swing.JButton();
        lblAno = new javax.swing.JLabel();
        spnAno = new javax.swing.JSpinner();
        lblSemestre = new javax.swing.JLabel();
        spnSemestre = new javax.swing.JSpinner();
        pnlTurma = new javax.swing.JPanel();
        pnlNotificacoes = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaNotificacoes = new javax.swing.JTextArea();
        lblNotificacoes = new javax.swing.JLabel();
        pnlProfessor = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerar Oferta");

        pnlPrincipal.setBackground(new java.awt.Color(53, 151, 48));

        pnlAlocacoes.setBackground(new java.awt.Color(0, 204, 102));

        cbxCurso.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N

        cbxTurma.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N

        lblTempoMaximo.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblTempoMaximo.setText("Tempo Máximo de Trabalho:");
        lblTempoMaximo.setToolTipText("");

        lblIntervaloMinimo.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblIntervaloMinimo.setText("Intervalo Mínimo:");

        txtTempoMaximo.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        txtTempoMaximo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTempoMaximo.setText("11");

        txtIntervaloMinimo.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        txtIntervaloMinimo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIntervaloMinimo.setText("11");

        lblAlocacoes.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblAlocacoes.setText("Alocações:");

        btnSalvar.setBackground(new java.awt.Color(255, 255, 255));
        btnSalvar.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        jList1.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jScrollPane3.setViewportView(jList1);

        lblCurso.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblCurso.setText("Curso:");

        lblTurma.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblTurma.setText("Turma:");

        btnValidar.setBackground(new java.awt.Color(255, 255, 255));
        btnValidar.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        btnValidar.setText("Validar Ofertas");
        btnValidar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnValidar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValidarActionPerformed(evt);
            }
        });

        lblAno.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblAno.setText("Ano:");

        spnAno.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N

        lblSemestre.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblSemestre.setText("Semestre:");

        spnSemestre.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N

        javax.swing.GroupLayout pnlAlocacoesLayout = new javax.swing.GroupLayout(pnlAlocacoes);
        pnlAlocacoes.setLayout(pnlAlocacoesLayout);
        pnlAlocacoesLayout.setHorizontalGroup(
            pnlAlocacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAlocacoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAlocacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxCurso, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(separadorLateral, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3)
                    .addComponent(cbxTurma, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlAlocacoesLayout.createSequentialGroup()
                        .addComponent(lblIntervaloMinimo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIntervaloMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnValidar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlAlocacoesLayout.createSequentialGroup()
                        .addGroup(pnlAlocacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAlocacoes)
                            .addComponent(lblCurso)
                            .addComponent(lblTurma))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAlocacoesLayout.createSequentialGroup()
                        .addGroup(pnlAlocacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlAlocacoesLayout.createSequentialGroup()
                                .addComponent(lblTempoMaximo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(pnlAlocacoesLayout.createSequentialGroup()
                                .addComponent(lblAno)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(spnAno)
                                .addGap(18, 18, 18)
                                .addComponent(lblSemestre)
                                .addGap(18, 18, 18)))
                        .addGroup(pnlAlocacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(spnSemestre)
                            .addComponent(txtTempoMaximo, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))))
                .addContainerGap())
        );
        pnlAlocacoesLayout.setVerticalGroup(
            pnlAlocacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAlocacoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCurso)
                .addGap(3, 3, 3)
                .addComponent(cbxCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTurma)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(pnlAlocacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnAno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlAlocacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTempoMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTempoMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlAlocacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIntervaloMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIntervaloMinimo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnValidar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(separadorLateral, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAlocacoes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3)
                .addContainerGap())
        );

        pnlTurma.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout pnlTurmaLayout = new javax.swing.GroupLayout(pnlTurma);
        pnlTurma.setLayout(pnlTurmaLayout);
        pnlTurmaLayout.setHorizontalGroup(
            pnlTurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 614, Short.MAX_VALUE)
        );
        pnlTurmaLayout.setVerticalGroup(
            pnlTurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 395, Short.MAX_VALUE)
        );

        pnlNotificacoes.setBackground(new java.awt.Color(0, 204, 102));

        txtAreaNotificacoes.setEditable(false);
        txtAreaNotificacoes.setColumns(20);
        txtAreaNotificacoes.setLineWrap(true);
        txtAreaNotificacoes.setRows(5);
        txtAreaNotificacoes.setBorder(null);
        jScrollPane1.setViewportView(txtAreaNotificacoes);

        lblNotificacoes.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        lblNotificacoes.setText("Notificações:");

        javax.swing.GroupLayout pnlNotificacoesLayout = new javax.swing.GroupLayout(pnlNotificacoes);
        pnlNotificacoes.setLayout(pnlNotificacoesLayout);
        pnlNotificacoesLayout.setHorizontalGroup(
            pnlNotificacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNotificacoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlNotificacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(pnlNotificacoesLayout.createSequentialGroup()
                        .addComponent(lblNotificacoes)
                        .addGap(0, 143, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlNotificacoesLayout.setVerticalGroup(
            pnlNotificacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNotificacoesLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblNotificacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        pnlProfessor.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout pnlProfessorLayout = new javax.swing.GroupLayout(pnlProfessor);
        pnlProfessor.setLayout(pnlProfessorLayout);
        pnlProfessorLayout.setHorizontalGroup(
            pnlProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlProfessorLayout.setVerticalGroup(
            pnlProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 395, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addComponent(pnlAlocacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlTurma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(pnlProfessor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlNotificacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPrincipalLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlNotificacoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addComponent(pnlTurma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlProfessor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(pnlAlocacoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5))
        );

        getContentPane().add(pnlPrincipal, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnValidarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnValidarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnValidarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnValidar;
    private javax.swing.JComboBox<String> cbxCurso;
    private javax.swing.JComboBox<String> cbxTurma;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JLabel lblAlocacoes;
    private javax.swing.JLabel lblAno;
    private javax.swing.JLabel lblCurso;
    private javax.swing.JLabel lblIntervaloMinimo;
    private javax.swing.JLabel lblNotificacoes;
    private javax.swing.JLabel lblSemestre;
    private javax.swing.JLabel lblTempoMaximo;
    private javax.swing.JLabel lblTurma;
    private javax.swing.JPanel pnlAlocacoes;
    private javax.swing.JPanel pnlNotificacoes;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JPanel pnlProfessor;
    private javax.swing.JPanel pnlTurma;
    private javax.swing.JSeparator separadorLateral;
    private javax.swing.JSpinner spnAno;
    private javax.swing.JSpinner spnSemestre;
    private javax.swing.JTextArea txtAreaNotificacoes;
    private javax.swing.JTextField txtIntervaloMinimo;
    private javax.swing.JTextField txtTempoMaximo;
    // End of variables declaration//GEN-END:variables
}

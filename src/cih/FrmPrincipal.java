package cih;

public class FrmPrincipal extends javax.swing.JFrame {
    
    private JPGrade jpGrade;

    public FrmPrincipal() {
        jpGrade = new JPGrade();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        toolBar = new javax.swing.JToolBar();
        btnProfessor = new javax.swing.JButton();
        btnCoordenador = new javax.swing.JButton();
        btnCoordenadoria = new javax.swing.JButton();
        btnCurso = new javax.swing.JButton();
        btnEixo = new javax.swing.JButton();
        btnDisciplina = new javax.swing.JButton();
        btnTurma = new javax.swing.JButton();
        btnMatriz = new javax.swing.JButton();
        btnAlocacao = new javax.swing.JButton();
        btnOferta = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        pnlPrincipal = new javax.swing.JPanel();
        pnlLateral = new javax.swing.JPanel();
        cbxCurso = new javax.swing.JComboBox<>();
        cbxTurma = new javax.swing.JComboBox<>();
        cbxSemestre = new javax.swing.JComboBox<>();
        lblTempoMaximo = new javax.swing.JLabel();
        lblIntervaloMinimo = new javax.swing.JLabel();
        txtTempoMaximo = new javax.swing.JTextField();
        txtIntervaloMinimo = new javax.swing.JTextField();
        separadorLateral = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAreaAlocacoes = new javax.swing.JTextArea();
        lblAlocacoes = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        lblCoordenador = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        lblNomeCoordenador = new javax.swing.JLabel();
        lblDataAtual = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        pnlCentral = new javax.swing.JPanel();
        pnlNotificacoes = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaNotificacoes = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Apoio e Montagem de Horários Acadêmicos");

        toolBar.setBackground(new java.awt.Color(0, 255, 51));
        toolBar.setFloatable(false);
        toolBar.setRollover(true);

        btnProfessor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/professor.png"))); // NOI18N
        btnProfessor.setToolTipText("Professores");
        btnProfessor.setFocusable(false);
        btnProfessor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProfessor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfessorActionPerformed(evt);
            }
        });
        toolBar.add(btnProfessor);

        btnCoordenador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/coordenador.png"))); // NOI18N
        btnCoordenador.setToolTipText("Coordenadores");
        btnCoordenador.setFocusable(false);
        btnCoordenador.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCoordenador.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(btnCoordenador);

        btnCoordenadoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/corrdenadoria.png"))); // NOI18N
        btnCoordenadoria.setToolTipText("Coordenadoria");
        btnCoordenadoria.setFocusable(false);
        btnCoordenadoria.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCoordenadoria.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(btnCoordenadoria);

        btnCurso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/curso.png"))); // NOI18N
        btnCurso.setToolTipText("Curso");
        btnCurso.setFocusable(false);
        btnCurso.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCurso.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(btnCurso);

        btnEixo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/eixo.png"))); // NOI18N
        btnEixo.setToolTipText("Eixo");
        btnEixo.setFocusable(false);
        btnEixo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEixo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(btnEixo);

        btnDisciplina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/disciplina.png"))); // NOI18N
        btnDisciplina.setToolTipText("Disciplina");
        btnDisciplina.setFocusable(false);
        btnDisciplina.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDisciplina.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(btnDisciplina);

        btnTurma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/turma.png"))); // NOI18N
        btnTurma.setToolTipText("Turma");
        btnTurma.setFocusable(false);
        btnTurma.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTurma.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(btnTurma);

        btnMatriz.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/matriz_curricular.png"))); // NOI18N
        btnMatriz.setToolTipText("Matriz Curricular");
        btnMatriz.setFocusable(false);
        btnMatriz.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMatriz.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(btnMatriz);

        btnAlocacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/alocacao.png"))); // NOI18N
        btnAlocacao.setFocusable(false);
        btnAlocacao.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAlocacao.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(btnAlocacao);

        btnOferta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/oferta.png"))); // NOI18N
        btnOferta.setToolTipText("Oferta");
        btnOferta.setFocusable(false);
        btnOferta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOferta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(btnOferta);

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/sair.png"))); // NOI18N
        btnSair.setToolTipText("Sair");
        btnSair.setFocusable(false);
        btnSair.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSair.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(btnSair);

        getContentPane().add(toolBar, java.awt.BorderLayout.PAGE_START);

        pnlLateral.setBackground(new java.awt.Color(153, 204, 255));

        cbxCurso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxTurma.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxSemestre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblTempoMaximo.setText("Tempo Máximo de Trabalho:");
        lblTempoMaximo.setToolTipText("");

        lblIntervaloMinimo.setText("Intervalo Mínimo de Descanso:");

        txtAreaAlocacoes.setColumns(20);
        txtAreaAlocacoes.setRows(5);
        jScrollPane2.setViewportView(txtAreaAlocacoes);

        lblAlocacoes.setText("Alocações");

        btnSalvar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        lblCoordenador.setText("Coordenador:");

        lblData.setText("Data:");

        lblNomeCoordenador.setText("User");

        lblDataAtual.setText("21/06/2018");

        javax.swing.GroupLayout pnlLateralLayout = new javax.swing.GroupLayout(pnlLateral);
        pnlLateral.setLayout(pnlLateralLayout);
        pnlLateralLayout.setHorizontalGroup(
            pnlLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLateralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(separadorLateral, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbxCurso, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlLateralLayout.createSequentialGroup()
                        .addComponent(cbxTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxSemestre, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlLateralLayout.createSequentialGroup()
                        .addComponent(lblData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblDataAtual))
                    .addGroup(pnlLateralLayout.createSequentialGroup()
                        .addGroup(pnlLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlLateralLayout.createSequentialGroup()
                                .addGroup(pnlLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblTempoMaximo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblIntervaloMinimo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTempoMaximo, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                                    .addComponent(txtIntervaloMinimo)))
                            .addComponent(lblAlocacoes))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlLateralLayout.createSequentialGroup()
                        .addComponent(lblCoordenador)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblNomeCoordenador))
                    .addComponent(jSeparator1))
                .addContainerGap())
        );
        pnlLateralLayout.setVerticalGroup(
            pnlLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLateralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbxCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbxTurma, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(cbxSemestre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTempoMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTempoMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIntervaloMinimo)
                    .addComponent(txtIntervaloMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separadorLateral, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblAlocacoes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(pnlLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNomeCoordenador)
                    .addComponent(lblCoordenador, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDataAtual)
                    .addComponent(lblData))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlCentral.setBackground(new java.awt.Color(204, 102, 255));

        javax.swing.GroupLayout pnlCentralLayout = new javax.swing.GroupLayout(pnlCentral);
        pnlCentral.setLayout(pnlCentralLayout);
        pnlCentralLayout.setHorizontalGroup(
            pnlCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 561, Short.MAX_VALUE)
        );
        pnlCentralLayout.setVerticalGroup(
            pnlCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 629, Short.MAX_VALUE)
        );

        pnlNotificacoes.setBackground(new java.awt.Color(255, 255, 153));

        txtAreaNotificacoes.setColumns(20);
        txtAreaNotificacoes.setLineWrap(true);
        txtAreaNotificacoes.setRows(5);
        txtAreaNotificacoes.setEnabled(false);
        jScrollPane1.setViewportView(txtAreaNotificacoes);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Notificações:");

        javax.swing.GroupLayout pnlNotificacoesLayout = new javax.swing.GroupLayout(pnlNotificacoes);
        pnlNotificacoes.setLayout(pnlNotificacoesLayout);
        pnlNotificacoesLayout.setHorizontalGroup(
            pnlNotificacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
        );
        pnlNotificacoesLayout.setVerticalGroup(
            pnlNotificacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNotificacoesLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addComponent(pnlLateral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlCentral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlNotificacoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlCentral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlNotificacoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlLateral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(pnlPrincipal, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfessorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnProfessorActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalvarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlocacao;
    private javax.swing.JButton btnCoordenador;
    private javax.swing.JButton btnCoordenadoria;
    private javax.swing.JButton btnCurso;
    private javax.swing.JButton btnDisciplina;
    private javax.swing.JButton btnEixo;
    private javax.swing.JButton btnMatriz;
    private javax.swing.JButton btnOferta;
    private javax.swing.JButton btnProfessor;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnTurma;
    private javax.swing.JComboBox<String> cbxCurso;
    private javax.swing.JComboBox<String> cbxSemestre;
    private javax.swing.JComboBox<String> cbxTurma;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblAlocacoes;
    private javax.swing.JLabel lblCoordenador;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblDataAtual;
    private javax.swing.JLabel lblIntervaloMinimo;
    private javax.swing.JLabel lblNomeCoordenador;
    private javax.swing.JLabel lblTempoMaximo;
    private javax.swing.JPanel pnlCentral;
    private javax.swing.JPanel pnlLateral;
    private javax.swing.JPanel pnlNotificacoes;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JSeparator separadorLateral;
    private javax.swing.JToolBar toolBar;
    private javax.swing.JTextArea txtAreaAlocacoes;
    private javax.swing.JTextArea txtAreaNotificacoes;
    private javax.swing.JTextField txtIntervaloMinimo;
    private javax.swing.JTextField txtTempoMaximo;
    // End of variables declaration//GEN-END:variables
}

package cih;

import cci.CtrlPrincipal;
import cdp.Coordenador;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JPanel;

public class FrmPrincipal extends javax.swing.JFrame {
    
    private JPGrade gradeTurma;
    private JPGrade gradeProfessor;
    private JPInicio inicio;
    private CtrlPrincipal ctrlPrincipal;

    public FrmPrincipal(CtrlPrincipal ctrlPrincipal) {
        this.ctrlPrincipal = ctrlPrincipal;
        initComponents();
        btnInicioActionPerformed(null);
        atualizarInfoSistema();
    }
    
    public void trocarPanel(JPanel jPanel) {
        pnlCentral.removeAll();
        pnlCentral.add(jPanel);
        pnlCentral.validate();
        pnlCentral.repaint();
    }
    
    private void atualizarInfoSistema(){
        Coordenador coord = ctrlPrincipal.getGtPrincipal().getCoordAtual();
        Date dataAtual = Calendar.getInstance().getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String data = formatter.format(dataAtual);
        if(coord != null){
            lblNomeCoordenador.setText(coord.getNome());
            lblDataAtual.setText(data);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator14 = new javax.swing.JSeparator();
        toolBar = new javax.swing.JToolBar();
        jSeparator12 = new javax.swing.JSeparator();
        btnInicio = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        btnProfessor = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnCoordenador = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        btnCoordenadoria = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        btnCurso = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        btnEixo = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        btnDisciplina = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JToolBar.Separator();
        btnTurma = new javax.swing.JButton();
        jSeparator9 = new javax.swing.JToolBar.Separator();
        btnMatriz = new javax.swing.JButton();
        jSeparator10 = new javax.swing.JToolBar.Separator();
        btnAlocacao = new javax.swing.JButton();
        jSeparator11 = new javax.swing.JToolBar.Separator();
        btnOferta = new javax.swing.JButton();
        jSeparator15 = new javax.swing.JToolBar.Separator();
        btnSair = new javax.swing.JButton();
        jSeparator13 = new javax.swing.JSeparator();
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
        lblNotificacoes = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Apoio e Montagem de Horários Acadêmicos");

        toolBar.setBackground(new java.awt.Color(0, 204, 0));
        toolBar.setBorder(null);
        toolBar.setFloatable(false);
        toolBar.setRollover(true);
        toolBar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        toolBar.add(jSeparator12);

        btnInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/inicio.png"))); // NOI18N
        btnInicio.setToolTipText("Início");
        btnInicio.setFocusable(false);
        btnInicio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnInicio.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });
        toolBar.add(btnInicio);
        toolBar.add(jSeparator3);

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
        toolBar.add(jSeparator2);

        btnCoordenador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/coordenador.png"))); // NOI18N
        btnCoordenador.setToolTipText("Coordenadores");
        btnCoordenador.setFocusable(false);
        btnCoordenador.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCoordenador.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCoordenador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCoordenadorActionPerformed(evt);
            }
        });
        toolBar.add(btnCoordenador);
        toolBar.add(jSeparator4);

        btnCoordenadoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/corrdenadoria.png"))); // NOI18N
        btnCoordenadoria.setToolTipText("Coordenadoria");
        btnCoordenadoria.setFocusable(false);
        btnCoordenadoria.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCoordenadoria.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(btnCoordenadoria);
        toolBar.add(jSeparator5);

        btnCurso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/curso.png"))); // NOI18N
        btnCurso.setToolTipText("Curso");
        btnCurso.setFocusable(false);
        btnCurso.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCurso.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(btnCurso);
        toolBar.add(jSeparator6);

        btnEixo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/eixo.png"))); // NOI18N
        btnEixo.setToolTipText("Eixo");
        btnEixo.setFocusable(false);
        btnEixo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEixo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(btnEixo);
        toolBar.add(jSeparator7);

        btnDisciplina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/disciplina.png"))); // NOI18N
        btnDisciplina.setToolTipText("Disciplina");
        btnDisciplina.setFocusable(false);
        btnDisciplina.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDisciplina.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(btnDisciplina);
        toolBar.add(jSeparator8);

        btnTurma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/turma.png"))); // NOI18N
        btnTurma.setToolTipText("Turma");
        btnTurma.setFocusable(false);
        btnTurma.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTurma.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(btnTurma);
        toolBar.add(jSeparator9);

        btnMatriz.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/matriz_curricular.png"))); // NOI18N
        btnMatriz.setToolTipText("Matriz Curricular");
        btnMatriz.setFocusable(false);
        btnMatriz.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMatriz.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(btnMatriz);
        toolBar.add(jSeparator10);

        btnAlocacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/alocacao.png"))); // NOI18N
        btnAlocacao.setFocusable(false);
        btnAlocacao.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAlocacao.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(btnAlocacao);
        toolBar.add(jSeparator11);

        btnOferta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/oferta.png"))); // NOI18N
        btnOferta.setToolTipText("Oferta");
        btnOferta.setFocusable(false);
        btnOferta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOferta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(btnOferta);
        toolBar.add(jSeparator15);

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/sair.png"))); // NOI18N
        btnSair.setToolTipText("Sair");
        btnSair.setFocusable(false);
        btnSair.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSair.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(btnSair);
        toolBar.add(jSeparator13);

        getContentPane().add(toolBar, java.awt.BorderLayout.PAGE_START);

        pnlPrincipal.setBackground(new java.awt.Color(255, 255, 255));

        pnlLateral.setBackground(new java.awt.Color(0, 204, 0));

        cbxCurso.setFont(new java.awt.Font("MV Boli", 0, 14)); // NOI18N
        cbxCurso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um curso...", "ARQUITETURA E URBANISMO", "SANEAMENTO AMBIENTAL", "SISTEMAS DE INFORMAÇÃO" }));

        cbxTurma.setFont(new java.awt.Font("MV Boli", 0, 14)); // NOI18N
        cbxTurma.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione uma turma...", "M20", "M15", "V05", "V07", "N09", "N10" }));

        cbxSemestre.setFont(new java.awt.Font("MV Boli", 0, 14)); // NOI18N
        cbxSemestre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um semestre...", "2015/1", "2015/2", "2016/1", "2016/2", "2017/1", "2017/2", "2018/1", "2018/2" }));

        lblTempoMaximo.setFont(new java.awt.Font("MV Boli", 0, 14)); // NOI18N
        lblTempoMaximo.setText("Tempo Máximo de Trabalho:");
        lblTempoMaximo.setToolTipText("");

        lblIntervaloMinimo.setFont(new java.awt.Font("MV Boli", 0, 14)); // NOI18N
        lblIntervaloMinimo.setText("Intervalo Mínimo de Descanso:");

        txtTempoMaximo.setFont(new java.awt.Font("MV Boli", 0, 14)); // NOI18N
        txtTempoMaximo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTempoMaximo.setText("11");

        txtIntervaloMinimo.setFont(new java.awt.Font("MV Boli", 0, 14)); // NOI18N
        txtIntervaloMinimo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIntervaloMinimo.setText("11");

        txtAreaAlocacoes.setColumns(20);
        txtAreaAlocacoes.setFont(new java.awt.Font("MV Boli", 0, 14)); // NOI18N
        txtAreaAlocacoes.setRows(5);
        jScrollPane2.setViewportView(txtAreaAlocacoes);

        lblAlocacoes.setFont(new java.awt.Font("MV Boli", 0, 14)); // NOI18N
        lblAlocacoes.setText("Alocações");

        btnSalvar.setBackground(new java.awt.Color(255, 255, 255));
        btnSalvar.setFont(new java.awt.Font("MV Boli", 0, 14)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        lblCoordenador.setFont(new java.awt.Font("MV Boli", 0, 12)); // NOI18N
        lblCoordenador.setText("Coordenador:");

        lblData.setFont(new java.awt.Font("MV Boli", 0, 12)); // NOI18N
        lblData.setText("Data:");

        lblNomeCoordenador.setFont(new java.awt.Font("MV Boli", 0, 12)); // NOI18N
        lblNomeCoordenador.setText("User");

        lblDataAtual.setFont(new java.awt.Font("MV Boli", 0, 12)); // NOI18N
        lblDataAtual.setText("00/00/0000");

        javax.swing.GroupLayout pnlLateralLayout = new javax.swing.GroupLayout(pnlLateral);
        pnlLateral.setLayout(pnlLateralLayout);
        pnlLateralLayout.setHorizontalGroup(
            pnlLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLateralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxSemestre, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(separadorLateral, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbxCurso, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addComponent(cbxTurma, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLateralLayout.createSequentialGroup()
                        .addGroup(pnlLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblIntervaloMinimo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTempoMaximo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTempoMaximo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIntervaloMinimo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlLateralLayout.createSequentialGroup()
                        .addComponent(lblCoordenador)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblNomeCoordenador))
                    .addGroup(pnlLateralLayout.createSequentialGroup()
                        .addComponent(lblAlocacoes)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlLateralLayout.createSequentialGroup()
                        .addComponent(lblData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblDataAtual)))
                .addContainerGap())
        );
        pnlLateralLayout.setVerticalGroup(
            pnlLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLateralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbxCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbxTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbxSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTempoMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTempoMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIntervaloMinimo)
                    .addComponent(txtIntervaloMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separadorLateral, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAlocacoes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCoordenador)
                    .addComponent(lblNomeCoordenador))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblData)
                    .addComponent(lblDataAtual))
                .addContainerGap())
        );

        pnlCentral.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout pnlCentralLayout = new javax.swing.GroupLayout(pnlCentral);
        pnlCentral.setLayout(pnlCentralLayout);
        pnlCentralLayout.setHorizontalGroup(
            pnlCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 727, Short.MAX_VALUE)
        );
        pnlCentralLayout.setVerticalGroup(
            pnlCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 723, Short.MAX_VALUE)
        );

        pnlNotificacoes.setBackground(new java.awt.Color(0, 204, 0));

        txtAreaNotificacoes.setEditable(false);
        txtAreaNotificacoes.setColumns(20);
        txtAreaNotificacoes.setLineWrap(true);
        txtAreaNotificacoes.setRows(5);
        txtAreaNotificacoes.setBorder(null);
        jScrollPane1.setViewportView(txtAreaNotificacoes);

        lblNotificacoes.setFont(new java.awt.Font("MV Boli", 0, 14)); // NOI18N
        lblNotificacoes.setText("Notificações:");

        javax.swing.GroupLayout pnlNotificacoesLayout = new javax.swing.GroupLayout(pnlNotificacoes);
        pnlNotificacoes.setLayout(pnlNotificacoesLayout);
        pnlNotificacoesLayout.setHorizontalGroup(
            pnlNotificacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNotificacoesLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addGap(5, 5, 5))
            .addGroup(pnlNotificacoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNotificacoes)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlNotificacoesLayout.setVerticalGroup(
            pnlNotificacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNotificacoesLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblNotificacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addComponent(pnlLateral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlCentral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlNotificacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPrincipalLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlNotificacoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlLateral, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlCentral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5))
        );

        getContentPane().add(pnlPrincipal, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfessorActionPerformed
        
    }//GEN-LAST:event_btnProfessorActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        if(inicio == null)
            inicio = ctrlPrincipal.instanciarPainelInicio(this);         
        trocarPanel(inicio);
    }//GEN-LAST:event_btnInicioActionPerformed

    private void btnCoordenadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCoordenadorActionPerformed
        ctrlPrincipal.getCtrlCoordenador().instanciarTelaBuscaCoordenador(this);
    }//GEN-LAST:event_btnCoordenadorActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlocacao;
    private javax.swing.JButton btnCoordenador;
    private javax.swing.JButton btnCoordenadoria;
    private javax.swing.JButton btnCurso;
    private javax.swing.JButton btnDisciplina;
    private javax.swing.JButton btnEixo;
    private javax.swing.JButton btnInicio;
    private javax.swing.JButton btnMatriz;
    private javax.swing.JButton btnOferta;
    private javax.swing.JButton btnProfessor;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnTurma;
    private javax.swing.JComboBox<String> cbxCurso;
    private javax.swing.JComboBox<String> cbxSemestre;
    private javax.swing.JComboBox<String> cbxTurma;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator10;
    private javax.swing.JToolBar.Separator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JToolBar.Separator jSeparator15;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JToolBar.Separator jSeparator8;
    private javax.swing.JToolBar.Separator jSeparator9;
    private javax.swing.JLabel lblAlocacoes;
    private javax.swing.JLabel lblCoordenador;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblDataAtual;
    private javax.swing.JLabel lblIntervaloMinimo;
    private javax.swing.JLabel lblNomeCoordenador;
    private javax.swing.JLabel lblNotificacoes;
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

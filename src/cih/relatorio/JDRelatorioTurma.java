package cih.relatorio;

import cci.CtrlPrincipal;
import cci.RenderizadorCelulas;
import cdp.Oferta;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class JDRelatorioTurma extends javax.swing.JDialog {
    
    private CtrlPrincipal ctrlPrincipal;

    public JDRelatorioTurma(java.awt.Frame parent, boolean modal, CtrlPrincipal ctrl) {
        super(parent, modal);
        this.ctrlPrincipal = ctrl;
        initComponents();
        setarBackground();
    }
    
    public void preencherTabelaTurma(Oferta oferta){
        ctrlPrincipal.getCtrlRelatorio().preencherTabelaTurma(tblTurma, cbxTurno, oferta);
    }
    
    public void identificarOferta(){
        
        int ano = (int) spnAno.getValue();
        int semestre = (int) spnSemestre.getValue();
        
        ctrlPrincipal.getCtrlRelatorio().identificarOferta(ano, semestre, cbxTurma);
    }
    
    private void setarBackground(){
        pnlPrincipal.setBackground(ctrlPrincipal.setarCorPanelExterior());
        pnlConfiguracoes.setBackground(ctrlPrincipal.setarCorPanelInterior());
    }
    
    public void preencherComboEixo(){
        ctrlPrincipal.getCtrlRelatorio().preencherComboEixos(cbxEixo);
    }
       
    public void salvarAulas(){
        ctrlPrincipal.getCtrlAula().salvarAulas(cbxTurma);
    }
    
    public void preencherComboCurso(){ 
        ctrlPrincipal.getCtrlRelatorio().preencherComboCurso(cbxEixo, cbxCurso, cbxTurma);
    }
    
    public void preencherComboTurma(){
        ctrlPrincipal.getCtrlRelatorio().preencherComboTurma(cbxCurso, cbxTurma);    
    }
    
    public void setarTurma(String nome){
        lblNomeTurma.setText(nome);
    }

    public JTable getTblTurma() {
        return tblTurma;
    }

    public JComboBox<String> getCbxTurno() {
        return cbxTurno;
    }
    
    public void setarTurno(){
        ctrlPrincipal.getCtrlRelatorio().setarTurno(cbxTurma, cbxTurno);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grpFiltros = new javax.swing.ButtonGroup();
        pnlPrincipal = new javax.swing.JPanel();
        pnlTurma = new javax.swing.JPanel();
        pnlDiasTurma = new javax.swing.JPanel();
        lblSexta = new javax.swing.JLabel();
        lblQuinta = new javax.swing.JLabel();
        lblTerca = new javax.swing.JLabel();
        lblQuarta = new javax.swing.JLabel();
        lblSegunda = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        pnlTurno = new javax.swing.JPanel();
        lblNomeTurma = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTurma = new javax.swing.JTable();
        pnlConfiguracoes = new javax.swing.JPanel();
        cbxCurso = new javax.swing.JComboBox<>();
        cbxTurma = new javax.swing.JComboBox<>();
        cbxTurno = new javax.swing.JComboBox<>();
        spnAno = new javax.swing.JSpinner();
        spnSemestre = new javax.swing.JSpinner();
        lblAno = new javax.swing.JLabel();
        btnGerar = new javax.swing.JButton();
        cbxEixo = new javax.swing.JComboBox<>();
        lblTurma = new javax.swing.JLabel();
        lblEixo = new javax.swing.JLabel();
        lblCurso1 = new javax.swing.JLabel();
        lblTurma2 = new javax.swing.JLabel();
        rbtnTurma = new javax.swing.JRadioButton();
        rbtnCurso = new javax.swing.JRadioButton();
        rbtnEixo = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatório de Turmas");
        setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        setMaximumSize(new java.awt.Dimension(2147483647, 605));
        setMinimumSize(new java.awt.Dimension(1100, 595));
        setPreferredSize(new java.awt.Dimension(1079, 325));
        setResizable(false);
        setSize(new java.awt.Dimension(1366, 788));

        pnlPrincipal.setBackground(new java.awt.Color(53, 151, 48));
        pnlPrincipal.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        pnlPrincipal.setMaximumSize(new java.awt.Dimension(1920, 790));

        pnlTurma.setBackground(new java.awt.Color(255, 255, 255));
        pnlTurma.setMinimumSize(new java.awt.Dimension(700, 400));

        lblSexta.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        lblSexta.setText("Sexta");

        lblQuinta.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        lblQuinta.setText("Quinta");

        lblTerca.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        lblTerca.setText("Terça");

        lblQuarta.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        lblQuarta.setText("Quarta");

        lblSegunda.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        lblSegunda.setText("Segunda");

        javax.swing.GroupLayout pnlDiasTurmaLayout = new javax.swing.GroupLayout(pnlDiasTurma);
        pnlDiasTurma.setLayout(pnlDiasTurmaLayout);
        pnlDiasTurmaLayout.setHorizontalGroup(
            pnlDiasTurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDiasTurmaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDiasTurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTerca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlDiasTurmaLayout.createSequentialGroup()
                        .addComponent(lblSegunda)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lblQuarta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSexta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblQuinta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlDiasTurmaLayout.setVerticalGroup(
            pnlDiasTurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDiasTurmaLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblSegunda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(lblTerca)
                .addGap(43, 43, 43)
                .addComponent(lblQuarta)
                .addGap(43, 43, 43)
                .addComponent(lblQuinta)
                .addGap(46, 46, 46)
                .addComponent(lblSexta)
                .addGap(27, 27, 27))
        );

        pnlTurno.setLayout(new java.awt.BorderLayout());

        lblNomeTurma.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        lblNomeTurma.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNomeTurma.setText("Turma");
        pnlTurno.add(lblNomeTurma, java.awt.BorderLayout.CENTER);

        tblTurma.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        tblTurma.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "07:00 - 07:50", "07:55 - 08:45", "08:50 - 09:40", "10:00 - 10:50", "10:55 - 11:45", "11:50 - 12:40"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTurma.setCellSelectionEnabled(true);
        tblTurma.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblTurma.setEnabled(false);
        tblTurma.setRowHeight(65);
        tblTurma.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblTurma.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblTurma);
        tblTurma.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tblTurma.setTransferHandler(new cci.DnDTabela(ctrlPrincipal));
        ((DefaultTableCellRenderer)tblTurma.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        tblTurma.setDefaultRenderer(Object.class, new RenderizadorCelulas(ctrlPrincipal, 2));

        javax.swing.GroupLayout pnlTurmaLayout = new javax.swing.GroupLayout(pnlTurma);
        pnlTurma.setLayout(pnlTurmaLayout);
        pnlTurmaLayout.setHorizontalGroup(
            pnlTurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTurmaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlDiasTurma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlTurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(pnlTurno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlTurmaLayout.setVerticalGroup(
            pnlTurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTurmaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlTurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlTurmaLayout.createSequentialGroup()
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlDiasTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnlConfiguracoes.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Configurações", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 1, 14))); // NOI18N

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

        cbxTurno.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        cbxTurno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MATUTINO", "VESPERTINO", "NOTURNO" }));
        cbxTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTurnoActionPerformed(evt);
            }
        });

        spnAno.setFont(new java.awt.Font("DialogInput", 0, 16)); // NOI18N
        spnAno.setModel(new javax.swing.SpinnerNumberModel(2018, 2000, null, 1));
        spnAno.setEditor(new JSpinner.NumberEditor(spnAno, "####"));
        spnAno.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnAnoStateChanged(evt);
            }
        });

        spnSemestre.setFont(new java.awt.Font("DialogInput", 0, 16)); // NOI18N
        spnSemestre.setModel(new javax.swing.SpinnerNumberModel(1, 1, 2, 1));
        spnSemestre.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnSemestreStateChanged(evt);
            }
        });

        lblAno.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblAno.setText("Ano/Semestre:");
        lblAno.setToolTipText("");

        btnGerar.setBackground(new java.awt.Color(255, 255, 255));
        btnGerar.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        btnGerar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/relatorio-botao.png"))); // NOI18N
        btnGerar.setText("Gerar Relatório");
        btnGerar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnGerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerarActionPerformed(evt);
            }
        });

        cbxEixo.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        cbxEixo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEixoActionPerformed(evt);
            }
        });

        lblTurma.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblTurma.setText("Turma:");
        lblTurma.setToolTipText("");

        lblEixo.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblEixo.setText("Eixo:");
        lblEixo.setToolTipText("");

        lblCurso1.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblCurso1.setText("Curso:");
        lblCurso1.setToolTipText("");

        lblTurma2.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblTurma2.setText("Turno:");
        lblTurma2.setToolTipText("");

        grpFiltros.add(rbtnTurma);
        rbtnTurma.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        rbtnTurma.setMnemonic('t');
        rbtnTurma.setSelected(true);
        rbtnTurma.setText("Turma");

        grpFiltros.add(rbtnCurso);
        rbtnCurso.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        rbtnCurso.setMnemonic('c');
        rbtnCurso.setText("Curso");

        grpFiltros.add(rbtnEixo);
        rbtnEixo.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        rbtnEixo.setMnemonic('e');
        rbtnEixo.setText("Eixo");

        javax.swing.GroupLayout pnlConfiguracoesLayout = new javax.swing.GroupLayout(pnlConfiguracoes);
        pnlConfiguracoes.setLayout(pnlConfiguracoesLayout);
        pnlConfiguracoesLayout.setHorizontalGroup(
            pnlConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlConfiguracoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEixo)
                    .addComponent(cbxEixo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCurso1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTurma)
                    .addComponent(cbxTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTurma2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAno, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlConfiguracoesLayout.createSequentialGroup()
                        .addComponent(spnAno, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(spnSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39)
                .addGroup(pnlConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlConfiguracoesLayout.createSequentialGroup()
                        .addComponent(rbtnTurma, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                        .addGap(10, 10, 10)
                        .addComponent(rbtnCurso)
                        .addGap(10, 10, 10)
                        .addComponent(rbtnEixo))
                    .addComponent(btnGerar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlConfiguracoesLayout.setVerticalGroup(
            pnlConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlConfiguracoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCurso1)
                        .addComponent(lblEixo))
                    .addComponent(lblTurma)
                    .addGroup(pnlConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTurma2)
                        .addComponent(lblAno)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxEixo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnAno, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlConfiguracoesLayout.createSequentialGroup()
                .addGroup(pnlConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlConfiguracoesLayout.createSequentialGroup()
                        .addGroup(pnlConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbtnTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rbtnCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rbtnEixo, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlConfiguracoesLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(btnGerar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTurma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlConfiguracoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlConfiguracoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(pnlPrincipal, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarActionPerformed

    }//GEN-LAST:event_btnGerarActionPerformed

    private void cbxTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTurmaActionPerformed
        setarTurno();
        identificarOferta();
    }//GEN-LAST:event_cbxTurmaActionPerformed

    private void cbxCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCursoActionPerformed
        preencherComboTurma();
        setarTurno();
        identificarOferta();
    }//GEN-LAST:event_cbxCursoActionPerformed

    private void spnAnoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnAnoStateChanged
        
    }//GEN-LAST:event_spnAnoStateChanged

    private void spnSemestreStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnSemestreStateChanged
        
    }//GEN-LAST:event_spnSemestreStateChanged

    private void cbxTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTurnoActionPerformed
        ctrlPrincipal.getCtrlOferta().alterarTurno((String) cbxTurno.getSelectedItem(), tblTurma);
        this.repaint();
        identificarOferta();
    }//GEN-LAST:event_cbxTurnoActionPerformed

    private void cbxEixoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEixoActionPerformed
        preencherComboCurso();
        preencherComboTurma();
        setarTurno();
        identificarOferta();
    }//GEN-LAST:event_cbxEixoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGerar;
    private javax.swing.JComboBox<String> cbxCurso;
    private javax.swing.JComboBox<String> cbxEixo;
    private javax.swing.JComboBox<String> cbxTurma;
    private javax.swing.JComboBox<String> cbxTurno;
    private javax.swing.ButtonGroup grpFiltros;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblAno;
    private javax.swing.JLabel lblCurso1;
    private javax.swing.JLabel lblEixo;
    private javax.swing.JLabel lblNomeTurma;
    private javax.swing.JLabel lblQuarta;
    private javax.swing.JLabel lblQuinta;
    private javax.swing.JLabel lblSegunda;
    private javax.swing.JLabel lblSexta;
    private javax.swing.JLabel lblTerca;
    private javax.swing.JLabel lblTurma;
    private javax.swing.JLabel lblTurma2;
    private javax.swing.JPanel pnlConfiguracoes;
    private javax.swing.JPanel pnlDiasTurma;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JPanel pnlTurma;
    private javax.swing.JPanel pnlTurno;
    private javax.swing.JRadioButton rbtnCurso;
    private javax.swing.JRadioButton rbtnEixo;
    private javax.swing.JRadioButton rbtnTurma;
    private javax.swing.JSpinner spnAno;
    private javax.swing.JSpinner spnSemestre;
    private javax.swing.JTable tblTurma;
    // End of variables declaration//GEN-END:variables
}

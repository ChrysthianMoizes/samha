package cih.relatorio;

import cci.CtrlPrincipal;
import cci.RenderizadorCelulas;
import cdp.Oferta;
import javax.swing.JSpinner;
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
    
    public void setarTurno(){
        ctrlPrincipal.getCtrlRelatorio().setarTurno(cbxTurma, cbxTurno);
    }
    
    public void gerarRelatorioTurma(){
        char tipo = (char) grpFiltros.getSelection().getMnemonic();
        int ano = (int) spnAno.getValue();
        int semestre = (int) spnSemestre.getValue();
        ctrlPrincipal.getCtrlRelatorio().gerarRelatorioTurma(cbxEixo, cbxCurso, cbxTurma, ano, semestre, tipo);
    }
    
    public void ativarFiltroNenhum(){
        ativarFiltroEixo(false);
        ativarFiltroCurso(false);
        ativarFiltroTurma(false);
    }
    
    public void ativarFiltroEixo(boolean opcao){
        cbxEixo.setEnabled(opcao);
        if(opcao)
            preencherComboEixo();
        else
            cbxEixo.removeAllItems();
    }
    
    public void ativarFiltroCurso(boolean opcao){
        cbxCurso.setEnabled(opcao);
        if(opcao)
            preencherComboCurso();
        else
            cbxCurso.removeAllItems();
    }
    
    public void ativarFiltroTurma(boolean opcao){
        cbxTurma.setEnabled(opcao);
        if(opcao){
            cbxTurno.setEnabled(opcao);
            preencherComboTurma();
            setarTurno();
            identificarOferta();
        }else{
            cbxTurma.removeAllItems();
            cbxTurno.setEnabled(opcao);
        }    
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
        btnGerar = new javax.swing.JButton();
        cbxEixo = new javax.swing.JComboBox<>();
        lblTurma = new javax.swing.JLabel();
        lblEixo = new javax.swing.JLabel();
        lblCurso1 = new javax.swing.JLabel();
        lblTurno = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblAno = new javax.swing.JLabel();
        spnAno = new javax.swing.JSpinner();
        spnSemestre = new javax.swing.JSpinner();
        rbtnTodas = new javax.swing.JRadioButton();
        rbtnTurma = new javax.swing.JRadioButton();
        rbtnCurso = new javax.swing.JRadioButton();
        rbtnEixo = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatório de Turmas");
        setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        setMinimumSize(new java.awt.Dimension(1100, 595));
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

        lblTurno.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblTurno.setText("Turno:");
        lblTurno.setToolTipText("");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filtro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 1, 14))); // NOI18N

        lblAno.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblAno.setText("Ano/Semestre:");
        lblAno.setToolTipText("");

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

        grpFiltros.add(rbtnTodas);
        rbtnTodas.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        rbtnTodas.setMnemonic('a');
        rbtnTodas.setSelected(true);
        rbtnTodas.setText("Nenhum");
        rbtnTodas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnTodasActionPerformed(evt);
            }
        });

        grpFiltros.add(rbtnTurma);
        rbtnTurma.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        rbtnTurma.setMnemonic('t');
        rbtnTurma.setText("Turma");
        rbtnTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnTurmaActionPerformed(evt);
            }
        });

        grpFiltros.add(rbtnCurso);
        rbtnCurso.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        rbtnCurso.setMnemonic('c');
        rbtnCurso.setText("Curso");
        rbtnCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnCursoActionPerformed(evt);
            }
        });

        grpFiltros.add(rbtnEixo);
        rbtnEixo.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        rbtnEixo.setMnemonic('e');
        rbtnEixo.setText("Eixo");
        rbtnEixo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnEixoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblAno, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(spnAno, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(spnSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rbtnTodas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbtnEixo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbtnCurso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbtnTurma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbtnCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbtnEixo, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbtnTodas, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spnAno, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAno, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlConfiguracoesLayout = new javax.swing.GroupLayout(pnlConfiguracoes);
        pnlConfiguracoes.setLayout(pnlConfiguracoesLayout);
        pnlConfiguracoesLayout.setHorizontalGroup(
            pnlConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlConfiguracoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxEixo, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEixo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCurso1)
                    .addComponent(cbxCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlConfiguracoesLayout.createSequentialGroup()
                        .addGroup(pnlConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTurma)
                            .addComponent(cbxTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxTurno, 0, 163, Short.MAX_VALUE)
                            .addGroup(pnlConfiguracoesLayout.createSequentialGroup()
                                .addComponent(lblTurno)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(btnGerar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlConfiguracoesLayout.setVerticalGroup(
            pnlConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlConfiguracoesLayout.createSequentialGroup()
                .addGroup(pnlConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlConfiguracoesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlConfiguracoesLayout.createSequentialGroup()
                        .addComponent(btnGerar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addGroup(pnlConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEixo)
                            .addComponent(lblCurso1)
                            .addComponent(lblTurma)
                            .addComponent(lblTurno))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxEixo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
        gerarRelatorioTurma();
    }//GEN-LAST:event_btnGerarActionPerformed

    private void cbxTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTurmaActionPerformed
        setarTurno();
        identificarOferta();
    }//GEN-LAST:event_cbxTurmaActionPerformed

    private void cbxCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCursoActionPerformed
        if(cbxTurma.isEnabled()){
            preencherComboTurma();
            setarTurno();
            identificarOferta();
        }
    }//GEN-LAST:event_cbxCursoActionPerformed

    private void spnAnoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnAnoStateChanged
        identificarOferta();
    }//GEN-LAST:event_spnAnoStateChanged

    private void spnSemestreStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnSemestreStateChanged
        identificarOferta();
    }//GEN-LAST:event_spnSemestreStateChanged

    private void cbxTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTurnoActionPerformed
        ctrlPrincipal.getCtrlOferta().alterarTurno((String) cbxTurno.getSelectedItem(), tblTurma);
        this.repaint();
        identificarOferta();
    }//GEN-LAST:event_cbxTurnoActionPerformed

    private void cbxEixoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEixoActionPerformed
        if(cbxCurso.isEnabled())
            preencherComboCurso();
        if(cbxTurma.isEnabled()){
            preencherComboTurma();
            setarTurno();
            identificarOferta();
        }
    }//GEN-LAST:event_cbxEixoActionPerformed

    private void rbtnTodasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnTodasActionPerformed
        ativarFiltroNenhum();
    }//GEN-LAST:event_rbtnTodasActionPerformed

    private void rbtnEixoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnEixoActionPerformed
        ativarFiltroEixo(true);
        ativarFiltroCurso(false);
        ativarFiltroTurma(false);
    }//GEN-LAST:event_rbtnEixoActionPerformed

    private void rbtnCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnCursoActionPerformed
        ativarFiltroEixo(true);
        ativarFiltroCurso(true);
        ativarFiltroTurma(false);
    }//GEN-LAST:event_rbtnCursoActionPerformed

    private void rbtnTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnTurmaActionPerformed
        ativarFiltroEixo(true);
        ativarFiltroCurso(true);
        ativarFiltroTurma(true);
    }//GEN-LAST:event_rbtnTurmaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGerar;
    private javax.swing.JComboBox<String> cbxCurso;
    private javax.swing.JComboBox<String> cbxEixo;
    private javax.swing.JComboBox<String> cbxTurma;
    private javax.swing.JComboBox<String> cbxTurno;
    private javax.swing.ButtonGroup grpFiltros;
    private javax.swing.JPanel jPanel1;
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
    private javax.swing.JLabel lblTurno;
    private javax.swing.JPanel pnlConfiguracoes;
    private javax.swing.JPanel pnlDiasTurma;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JPanel pnlTurma;
    private javax.swing.JPanel pnlTurno;
    private javax.swing.JRadioButton rbtnCurso;
    private javax.swing.JRadioButton rbtnEixo;
    private javax.swing.JRadioButton rbtnTodas;
    private javax.swing.JRadioButton rbtnTurma;
    private javax.swing.JSpinner spnAno;
    private javax.swing.JSpinner spnSemestre;
    private javax.swing.JTable tblTurma;
    // End of variables declaration//GEN-END:variables
}

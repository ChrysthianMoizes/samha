package cih.oferta;

import cci.CtrlPrincipal;
import cci.RenderizadorCelulas;
import cdp.Aula;
import cdp.Curso;
import java.awt.event.MouseEvent;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class JDOferta extends javax.swing.JDialog {
    
    private CtrlPrincipal ctrlPrincipal;

    public JDOferta(java.awt.Frame parent, boolean modal, CtrlPrincipal ctrl) {
        super(parent, modal);
        this.ctrlPrincipal = ctrl;
        initComponents();
        setarBackground();
    }
    
    private void setarBackground(){
        pnlPrincipal.setBackground(ctrlPrincipal.setarCorPanelExterior());
        pnlAlocacoes.setBackground(ctrlPrincipal.setarCorPanelInterior());
        pnlNotificacoes.setBackground(ctrlPrincipal.setarCorPanelInterior());
        pnlValidacao.setBackground(ctrlPrincipal.setarCorPanelInterior());
    }
    
    public void gerarAula(){
        ctrlPrincipal.getCtrlOferta().gerarAula(lstAlocacoes, tblTurma, cbxTurno);
    }
    
    public void salvarOferta(){
        
        int ano = (int) spnAno.getValue();
        int semestre = (int) spnSemestre.getValue();
        int tempo = (int) spnTempoMaximo.getValue();
        int intervalo = (int) spnIntervalo.getValue();
        ctrlPrincipal.getCtrlOferta().salvarOferta(ano, semestre, tempo, intervalo, cbxTurma);
    }
    
    public void atualizarTela(){
        
        int ano = (int) spnAno.getValue();
        int semestre = (int) spnSemestre.getValue();
        
        ctrlPrincipal.getCtrlOferta().atualizarTela(ano, semestre, cbxTurma, cbxTurno, lstAlocacoes, tblTurma);
    }
    
    public void preencherComboCurso(){ 
        ctrlPrincipal.getCtrlOferta().preencherComboCurso(cbxCurso, cbxTurma);
    }
    
    public void preencherComboTurma(){
        Curso curso = (Curso) cbxCurso.getSelectedItem();
        if(curso != null){
           ctrlPrincipal.getCtrlOferta().preencherComboTurma(curso.getId(), cbxTurma);
        }
    }
    
    public void setarMensagem(String mensagem){
        lblMensagem.setText(mensagem);
    }
    
    public void setarTurma(String mensagem){
        lblNomeTurma.setText(mensagem);
    }
    
    public void exibirNotificacao(String mensagem){
        txtAreaNotificacoes.append(mensagem);
    }
    
    public void limparNotificacoes(){
        txtAreaNotificacoes.setText("");
    }

    public JList<String> getLstAlocacoes() {
        return lstAlocacoes;
    }

    public JTable getTblTurma() {
        return tblTurma;
    }
    
    public void setarTurno(int indice){
        cbxTurno.setSelectedIndex(indice);
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popUpRemover = new javax.swing.JPopupMenu();
        itemRemover = new javax.swing.JMenuItem();
        pnlPrincipal = new javax.swing.JPanel();
        pnlNotificacoes = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaNotificacoes = new javax.swing.JTextArea();
        pnlValidacao = new javax.swing.JPanel();
        btnValidar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        lblTempoMaximo = new javax.swing.JLabel();
        lblIntervaloMinimo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        spnIntervalo = new javax.swing.JSpinner();
        spnTempoMaximo = new javax.swing.JSpinner();
        pnlTurma = new javax.swing.JPanel();
        pnlDiasTurma = new javax.swing.JPanel();
        lblSexta = new javax.swing.JLabel();
        lblQuinta = new javax.swing.JLabel();
        lblTerca = new javax.swing.JLabel();
        lblQuarta = new javax.swing.JLabel();
        lblSegunda = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        lblTurma = new javax.swing.JLabel();
        pnlTurno = new javax.swing.JPanel();
        lblNomeTurma = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTurma = new javax.swing.JTable();
        pnlProfessor = new javax.swing.JPanel();
        pnlDiasProfessor = new javax.swing.JPanel();
        lblSexta1 = new javax.swing.JLabel();
        lblQuinta1 = new javax.swing.JLabel();
        lblTerca1 = new javax.swing.JLabel();
        lblQuarta1 = new javax.swing.JLabel();
        lblSegunda1 = new javax.swing.JLabel();
        cbxQuantidadeProfessor = new javax.swing.JComboBox<>();
        pnlNomeProfessor = new javax.swing.JPanel();
        lblNomeProfessor = new javax.swing.JLabel();
        pnlTabelaProfessor = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblProfessor = new javax.swing.JTable();
        pnlAlocacoes = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstAlocacoes = new javax.swing.JList<>();
        cbxCurso = new javax.swing.JComboBox<>();
        cbxTurma = new javax.swing.JComboBox<>();
        cbxTurno = new javax.swing.JComboBox<>();
        lblAno = new javax.swing.JLabel();
        spnAno = new javax.swing.JSpinner();
        lblSemestre = new javax.swing.JLabel();
        spnSemestre = new javax.swing.JSpinner();
        jSeparator2 = new javax.swing.JSeparator();
        lblMensagem = new javax.swing.JLabel();

        itemRemover.setText("jMenuItem1");
        itemRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRemoverActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Montar Oferta");
        setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        setMaximumSize(new java.awt.Dimension(1850, 788));
        setMinimumSize(new java.awt.Dimension(1400, 788));
        setPreferredSize(new java.awt.Dimension(1600, 800));
        setSize(new java.awt.Dimension(1366, 788));

        pnlPrincipal.setBackground(new java.awt.Color(53, 151, 48));
        pnlPrincipal.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        pnlPrincipal.setMaximumSize(new java.awt.Dimension(1920, 790));

        pnlNotificacoes.setBackground(new java.awt.Color(255, 255, 255));
        pnlNotificacoes.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Notificações", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 1, 14))); // NOI18N

        txtAreaNotificacoes.setEditable(false);
        txtAreaNotificacoes.setColumns(20);
        txtAreaNotificacoes.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        txtAreaNotificacoes.setForeground(new java.awt.Color(252, 2, 2));
        txtAreaNotificacoes.setLineWrap(true);
        txtAreaNotificacoes.setRows(5);
        txtAreaNotificacoes.setWrapStyleWord(true);
        txtAreaNotificacoes.setBorder(null);
        jScrollPane1.setViewportView(txtAreaNotificacoes);

        javax.swing.GroupLayout pnlNotificacoesLayout = new javax.swing.GroupLayout(pnlNotificacoes);
        pnlNotificacoes.setLayout(pnlNotificacoesLayout);
        pnlNotificacoesLayout.setHorizontalGroup(
            pnlNotificacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNotificacoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        pnlNotificacoesLayout.setVerticalGroup(
            pnlNotificacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNotificacoesLayout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        pnlValidacao.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnValidar.setBackground(new java.awt.Color(255, 255, 255));
        btnValidar.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        btnValidar.setText("Validar Aulas");
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

        lblIntervaloMinimo.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblIntervaloMinimo.setText("Intervalo Mínimo:");

        spnIntervalo.setFont(new java.awt.Font("DialogInput", 0, 16)); // NOI18N
        spnIntervalo.setModel(new javax.swing.SpinnerNumberModel(11, 0, null, 1));

        spnTempoMaximo.setFont(new java.awt.Font("DialogInput", 0, 16)); // NOI18N
        spnTempoMaximo.setModel(new javax.swing.SpinnerNumberModel(11, 0, null, 1));

        javax.swing.GroupLayout pnlValidacaoLayout = new javax.swing.GroupLayout(pnlValidacao);
        pnlValidacao.setLayout(pnlValidacaoLayout);
        pnlValidacaoLayout.setHorizontalGroup(
            pnlValidacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlValidacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlValidacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(pnlValidacaoLayout.createSequentialGroup()
                        .addGroup(pnlValidacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlValidacaoLayout.createSequentialGroup()
                                .addComponent(lblIntervaloMinimo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spnIntervalo, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlValidacaoLayout.createSequentialGroup()
                                .addComponent(lblTempoMaximo, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                                .addGap(59, 59, 59)
                                .addComponent(spnTempoMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnValidar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        pnlValidacaoLayout.setVerticalGroup(
            pnlValidacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlValidacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlValidacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTempoMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnTempoMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlValidacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIntervaloMinimo)
                    .addComponent(spnIntervalo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnValidar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

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

        lblTurma.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        lblTurma.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTurma.setText("Turma");

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
        tblTurma.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblTurma.setDragEnabled(true);
        tblTurma.setRowHeight(65);
        tblTurma.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblTurma.getTableHeader().setReorderingAllowed(false);
        tblTurma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTurmaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblTurma);
        tblTurma.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tblTurma.setDefaultRenderer(Object.class, new RenderizadorCelulas());
        tblTurma.setTransferHandler(new cci.DnDTabela(ctrlPrincipal));
        ((DefaultTableCellRenderer)tblTurma.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);

        javax.swing.GroupLayout pnlTurmaLayout = new javax.swing.GroupLayout(pnlTurma);
        pnlTurma.setLayout(pnlTurmaLayout);
        pnlTurmaLayout.setHorizontalGroup(
            pnlTurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTurmaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlDiasTurma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator3)
                    .addComponent(lblTurma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlTurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTurno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        pnlTurmaLayout.setVerticalGroup(
            pnlTurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTurmaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTurma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlTurmaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(pnlTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlTurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTurmaLayout.createSequentialGroup()
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlDiasTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pnlProfessor.setBackground(new java.awt.Color(255, 255, 255));
        pnlProfessor.setMaximumSize(new java.awt.Dimension(32767, 800));
        pnlProfessor.setPreferredSize(new java.awt.Dimension(700, 400));

        lblSexta1.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        lblSexta1.setText("Sexta");

        lblQuinta1.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        lblQuinta1.setText("Quinta");

        lblTerca1.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        lblTerca1.setText("Terça");

        lblQuarta1.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        lblQuarta1.setText("Quarta");

        lblSegunda1.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        lblSegunda1.setText("Segunda");

        cbxQuantidadeProfessor.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        cbxQuantidadeProfessor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2" }));
        cbxQuantidadeProfessor.setEnabled(false);
        cbxQuantidadeProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxQuantidadeProfessorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDiasProfessorLayout = new javax.swing.GroupLayout(pnlDiasProfessor);
        pnlDiasProfessor.setLayout(pnlDiasProfessorLayout);
        pnlDiasProfessorLayout.setHorizontalGroup(
            pnlDiasProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDiasProfessorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDiasProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTerca1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblQuarta1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSexta1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblQuinta1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlDiasProfessorLayout.createSequentialGroup()
                        .addGroup(pnlDiasProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxQuantidadeProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSegunda1))
                        .addGap(0, 2, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlDiasProfessorLayout.setVerticalGroup(
            pnlDiasProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDiasProfessorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbxQuantidadeProfessor)
                .addGap(11, 11, 11)
                .addComponent(lblSegunda1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTerca1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblQuarta1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblQuinta1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSexta1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        pnlNomeProfessor.setLayout(new java.awt.BorderLayout());

        lblNomeProfessor.setBackground(new java.awt.Color(204, 204, 204));
        lblNomeProfessor.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        lblNomeProfessor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNomeProfessor.setText("Professor");
        pnlNomeProfessor.add(lblNomeProfessor, java.awt.BorderLayout.CENTER);

        pnlTabelaProfessor.setLayout(new java.awt.BorderLayout());

        tblProfessor.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        tblProfessor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "07:00", "07:55", "08:50", "10:00", "10:55", "11:50", "13:00", "13:55", "14:50", "16:00", "16:55", "17:50", "18:50", "19:40", "20:50", "21:40"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProfessor.setCellSelectionEnabled(true);
        tblProfessor.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        tblProfessor.setDragEnabled(true);
        tblProfessor.setDropMode(javax.swing.DropMode.INSERT);
        tblProfessor.setEnabled(false);
        tblProfessor.setMaximumSize(new java.awt.Dimension(2147483647, 400));
        tblProfessor.setRowHeight(45);
        tblProfessor.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblProfessor.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(tblProfessor);
        tblProfessor.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tblProfessor.setDefaultRenderer(Object.class, new RenderizadorCelulas());
        ((DefaultTableCellRenderer)tblProfessor.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);

        pnlTabelaProfessor.add(jScrollPane4, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout pnlProfessorLayout = new javax.swing.GroupLayout(pnlProfessor);
        pnlProfessor.setLayout(pnlProfessorLayout);
        pnlProfessorLayout.setHorizontalGroup(
            pnlProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlProfessorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlDiasProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTabelaProfessor, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
                    .addComponent(pnlNomeProfessor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlProfessorLayout.setVerticalGroup(
            pnlProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProfessorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlDiasProfessor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlProfessorLayout.createSequentialGroup()
                        .addComponent(pnlNomeProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlTabelaProfessor, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pnlAlocacoes.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Alocações", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 1, 14))); // NOI18N

        lstAlocacoes.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lstAlocacoes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstAlocacoes.setDragEnabled(true);
        lstAlocacoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstAlocacoesMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(lstAlocacoes);

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

        lblAno.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblAno.setText("Ano:");

        spnAno.setFont(new java.awt.Font("DialogInput", 0, 16)); // NOI18N
        spnAno.setModel(new javax.swing.SpinnerNumberModel(2018, 2000, null, 1));
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

        javax.swing.GroupLayout pnlAlocacoesLayout = new javax.swing.GroupLayout(pnlAlocacoes);
        pnlAlocacoes.setLayout(pnlAlocacoesLayout);
        pnlAlocacoesLayout.setHorizontalGroup(
            pnlAlocacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAlocacoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAlocacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAlocacoesLayout.createSequentialGroup()
                        .addComponent(lblAno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spnAno, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(lblSemestre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(spnSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbxCurso, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlAlocacoesLayout.createSequentialGroup()
                        .addComponent(cbxTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxTurno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblMensagem, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlAlocacoesLayout.setVerticalGroup(
            pnlAlocacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAlocacoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbxCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlAlocacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlAlocacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSemestre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 13, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlAlocacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTurma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlProfessor, javax.swing.GroupLayout.DEFAULT_SIZE, 747, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlValidacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlNotificacoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlAlocacoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addComponent(pnlValidacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlNotificacoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlPrincipalLayout.createSequentialGroup()
                        .addComponent(pnlTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlProfessor, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)))
                .addContainerGap())
        );

        getContentPane().add(pnlPrincipal, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        salvarOferta();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnValidarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnValidarActionPerformed
        ctrlPrincipal.getCtrlOferta().validarOfertas(tblTurma);
    }//GEN-LAST:event_btnValidarActionPerformed

    private void cbxTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTurmaActionPerformed
        atualizarTela();
    }//GEN-LAST:event_cbxTurmaActionPerformed

    private void cbxCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCursoActionPerformed
        preencherComboTurma();
    }//GEN-LAST:event_cbxCursoActionPerformed

    private void spnAnoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnAnoStateChanged
        atualizarTela();
    }//GEN-LAST:event_spnAnoStateChanged

    private void spnSemestreStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnSemestreStateChanged
        atualizarTela();
    }//GEN-LAST:event_spnSemestreStateChanged

    private void cbxTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTurnoActionPerformed
        atualizarTela();
    }//GEN-LAST:event_cbxTurnoActionPerformed

    private void tblTurmaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTurmaMouseClicked

        if(evt.getButton() == MouseEvent.BUTTON3){
            
            int coluna = tblTurma.getSelectedColumn();
            int linha = tblTurma.getSelectedRow();
            
            if((linha >= 0) && (coluna >= 0)){
                
                Aula aula = (Aula) tblTurma.getValueAt(linha, coluna);
                
                if(aula != null){
                    itemRemover.setText("Remover");
                    popUpRemover.add(itemRemover);
                    popUpRemover.show(tblTurma, evt.getX(), evt.getY());
                }
            } 
        }
    }//GEN-LAST:event_tblTurmaMouseClicked

    private void itemRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRemoverActionPerformed
        ctrlPrincipal.getCtrlOferta().removerAula(tblTurma);
    }//GEN-LAST:event_itemRemoverActionPerformed

    private void lstAlocacoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstAlocacoesMouseClicked
        ctrlPrincipal.getCtrlOferta().preencherHorarioProfessor(lstAlocacoes, tblProfessor, cbxQuantidadeProfessor);
    }//GEN-LAST:event_lstAlocacoesMouseClicked

    private void cbxQuantidadeProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxQuantidadeProfessorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxQuantidadeProfessorActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnValidar;
    private javax.swing.JComboBox<String> cbxCurso;
    private javax.swing.JComboBox<String> cbxQuantidadeProfessor;
    private javax.swing.JComboBox<String> cbxTurma;
    private javax.swing.JComboBox<String> cbxTurno;
    private javax.swing.JMenuItem itemRemover;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblAno;
    private javax.swing.JLabel lblIntervaloMinimo;
    private javax.swing.JLabel lblMensagem;
    private javax.swing.JLabel lblNomeProfessor;
    private javax.swing.JLabel lblNomeTurma;
    private javax.swing.JLabel lblQuarta;
    private javax.swing.JLabel lblQuarta1;
    private javax.swing.JLabel lblQuinta;
    private javax.swing.JLabel lblQuinta1;
    private javax.swing.JLabel lblSegunda;
    private javax.swing.JLabel lblSegunda1;
    private javax.swing.JLabel lblSemestre;
    private javax.swing.JLabel lblSexta;
    private javax.swing.JLabel lblSexta1;
    private javax.swing.JLabel lblTempoMaximo;
    private javax.swing.JLabel lblTerca;
    private javax.swing.JLabel lblTerca1;
    private javax.swing.JLabel lblTurma;
    private javax.swing.JList<String> lstAlocacoes;
    private javax.swing.JPanel pnlAlocacoes;
    private javax.swing.JPanel pnlDiasProfessor;
    private javax.swing.JPanel pnlDiasTurma;
    private javax.swing.JPanel pnlNomeProfessor;
    private javax.swing.JPanel pnlNotificacoes;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JPanel pnlProfessor;
    private javax.swing.JPanel pnlTabelaProfessor;
    private javax.swing.JPanel pnlTurma;
    private javax.swing.JPanel pnlTurno;
    private javax.swing.JPanel pnlValidacao;
    private javax.swing.JPopupMenu popUpRemover;
    private javax.swing.JSpinner spnAno;
    private javax.swing.JSpinner spnIntervalo;
    private javax.swing.JSpinner spnSemestre;
    private javax.swing.JSpinner spnTempoMaximo;
    private javax.swing.JTable tblProfessor;
    private javax.swing.JTable tblTurma;
    private javax.swing.JTextArea txtAreaNotificacoes;
    // End of variables declaration//GEN-END:variables
}

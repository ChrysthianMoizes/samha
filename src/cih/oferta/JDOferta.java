package cih.oferta;

import cci.CtrlPrincipal;
import cdp.Aula;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JSpinner;
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
        
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt){
                sair();
            }
        });
    }
    
    private void setarBackground(){
        pnlPrincipal.setBackground(ctrlPrincipal.setarCorPanelExterior());
        pnlAlocacoes.setBackground(ctrlPrincipal.setarCorPanelInterior());
        pnlNotificacoes.setBackground(ctrlPrincipal.setarCorPanelInterior());
    }
    
    public void gerarAula(){
        ctrlPrincipal.getCtrlAula().gerarAula(lstAlocacoes, tblTurma, cbxTurno);
    }
    
    public void salvarAulas(){
        ctrlPrincipal.getCtrlAula().salvarAulas(cbxTurma);
    }
    
    public void atualizarTela(){

        int ano = (int) spnAno.getValue();
        int semestre = (int) spnSemestre.getValue();
        int tempo = (int) spnTempoMaximo.getValue();
        int intervalo = (int) spnIntervalo.getValue();
        int periodo = (int) spnPeriodo.getValue();
        
        ctrlPrincipal.getCtrlOferta().atualizarTela(ano, semestre, tempo, intervalo, periodo, cbxTurma, cbxTurno, lstAlocacoes, tblTurma, btnCQD);
    }
    
    public void validarAulas(){
        ctrlPrincipal.getCtrlOferta().validarOferta(tblTurma, btnCQD);
    }
    
    public void validarTurmas(){
        
        int ano = (int) spnAno.getValue();
        int semestre = (int) spnSemestre.getValue();
        
        ctrlPrincipal.getCtrlValidacao().confirmarValidacaoTurmas(ano, semestre);
    }
    
    public void validandoOferta(){
        btnValidarOferta.setText("Validando...");
        btnValidarOferta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/aguarde.png")));
    }
    
    public void ofertaValidada(){
        btnValidarOferta.setText("Validar");
        btnValidarOferta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/validar.png")));
    }
    
    public void validandoTurmas(){
        btnValidarTurmas.setText("Validando Turmas ...");
        btnValidarTurmas.setEnabled(false);
        btnValidarTurmas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/aguarde.png")));
    }
    
    public void turmasValidadas(){
        btnValidarTurmas.setText("Validar Turmas");
        btnValidarTurmas.setEnabled(true);
        btnValidarTurmas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/validar.png")));
    }
    
    public void atualizarOferta(){
        
        int tempo = (int) spnTempoMaximo.getValue();
        int intervalo = (int) spnIntervalo.getValue();
        ctrlPrincipal.getCtrlOferta().atualizarOferta(tempo, intervalo);   
    }
    
    public void removerAula(int x, int y){
        
        int coluna = tblTurma.getSelectedColumn();
        int linha = tblTurma.getSelectedRow();

        if((linha >= 0) && (coluna >= 0)){

            Aula aula = (Aula) tblTurma.getValueAt(linha, coluna);

            if(aula != null){
                itemRemover.setText("Remover");
                popUpRemover.add(itemRemover);
                popUpRemover.show(tblTurma, x, y);
            }
        }
    }
    
    public void preencherComboCurso(){ 
        ctrlPrincipal.getCtrlOferta().preencherComboCurso(cbxCurso, cbxTurma);
    }
    
    public void preencherComboTurma(){
        ctrlPrincipal.getCtrlOferta().preencherComboTurma(cbxCurso, cbxTurma, false);    
    }
    
    public void setarPeriodoMaximo(int maximo){
        spnPeriodo.setModel(new javax.swing.SpinnerNumberModel(1, 1, maximo, 1));
    }
    
    public void setarMensagem(String mensagem){
        lblMensagem.setText(mensagem);
    }
    
    public void setarTurma(String nome){
        lblNomeTurma.setText(nome);
    }
    
    public void setarProfessor(String nome){
        lblNomeProfessor.setForeground(Color.BLACK);
        lblNomeProfessor.setText(nome);
    }
    
    public void setarProfessor(String nome, Color cor){
        lblNomeProfessor.setForeground(cor);
        lblNomeProfessor.setText(nome);
    }
    
    public void setarTempoMaximo(int tempo){
        spnTempoMaximo.setValue(tempo);
    }
    
    public void setarIntervaloMinimo(int intervalo){
        spnIntervalo.setValue(intervalo);
    }    
    
    public void exibirNotificacao(String mensagem, Color cor){
        txtAreaNotificacoes.setForeground(cor);
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
    
    public JTable getTblProfessor() {
        return tblProfessor;
    }

    public JComboBox<String> getCbxQuantidadeProfessor() {
        return cbxQuantidadeProfessor;
    }

    public JComboBox<String> getCbxTurno() {
        return cbxTurno;
    }
    
    public void validarOferta(boolean opcao){
        btnValidarOferta.setEnabled(opcao);   
        btnSalvar.setEnabled(!opcao);   
    }

    public JSpinner getSpnIntervalo() {
        return spnIntervalo;
    }

    public JSpinner getSpnTempoMaximo() {
        return spnTempoMaximo;
    }

    public JSpinner getSpnAno() {
        return spnAno;
    }

    public JSpinner getSpnSemestre() {
        return spnSemestre;
    }
    
    public void sair(){
        ctrlPrincipal.getCtrlAula().sair(lblNomeTurma.getText());
    }
    
    public void desfazer(){
        ctrlPrincipal.getCtrlAula().desfazer(lblNomeTurma.getText());
    }
    
    public void preencherHorarioProfessor(){
        ctrlPrincipal.getCtrlOferta().preencherHorarioProfessor(lstAlocacoes, tblProfessor, cbxQuantidadeProfessor);
    }

    public JLabel getLblNomeProfessor() {
        return lblNomeProfessor;
    }
    
    public int getAno(){
        return (int) spnAno.getValue();
    }
    
    public int getSemestre(){
        return (int) spnSemestre.getValue();
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
        spnAno = new javax.swing.JSpinner();
        spnSemestre = new javax.swing.JSpinner();
        jSeparator2 = new javax.swing.JSeparator();
        lblMensagem = new javax.swing.JLabel();
        lblAno = new javax.swing.JLabel();
        btnValidarTurmas = new javax.swing.JButton();
        lblTempoMaximo = new javax.swing.JLabel();
        spnTempoMaximo = new javax.swing.JSpinner();
        lblIntervaloMinimo = new javax.swing.JLabel();
        spnIntervalo = new javax.swing.JSpinner();
        jSeparator1 = new javax.swing.JSeparator();
        btnValidarOferta = new javax.swing.JButton();
        btnCQD = new javax.swing.JToggleButton();
        btnSalvar = new javax.swing.JButton();
        btnDesfazer = new javax.swing.JButton();
        lblPeriodo = new javax.swing.JLabel();
        spnPeriodo = new javax.swing.JSpinner();
        btnRevalidarTurmas = new javax.swing.JButton();

        itemRemover.setText("jMenuItem1");
        itemRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRemoverActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Montar Oferta");
        setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        setMinimumSize(new java.awt.Dimension(1400, 825));
        setPreferredSize(new java.awt.Dimension(1600, 810));
        setSize(new java.awt.Dimension(1366, 800));

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlNotificacoesLayout.setVerticalGroup(
            pnlNotificacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNotificacoesLayout.createSequentialGroup()
                .addComponent(jScrollPane1)
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
        tblTurma.setTransferHandler(new cci.DnDTabela(ctrlPrincipal));
        ((DefaultTableCellRenderer)tblTurma.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        tblTurma.setDefaultRenderer(Object.class, ctrlPrincipal.getCtrlConflito().getRender());

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
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 728, Short.MAX_VALUE)
                    .addComponent(pnlTurno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGroup(pnlTurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlTurmaLayout.createSequentialGroup()
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlDiasTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
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
        pnlNomeProfessor.add(lblNomeProfessor, java.awt.BorderLayout.CENTER);

        pnlTabelaProfessor.setLayout(new java.awt.BorderLayout());

        tblProfessor.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        tblProfessor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "07:00", "07:55", "08:50", "10:00", "10:55", "11:50", "12:50", "13:45", "14:40", "15:50", "16:45", "17:40", "18:50", "19:35", "20:30", "21:15", "--", "--"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true
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
        ((DefaultTableCellRenderer)tblProfessor.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        tblProfessor.setDefaultRenderer(Object.class, ctrlPrincipal.getCtrlOferta().getRenderTabelaProfessor());

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
                    .addComponent(pnlTabelaProfessor, javax.swing.GroupLayout.DEFAULT_SIZE, 726, Short.MAX_VALUE)
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
                        .addComponent(pnlTabelaProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
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

        lblMensagem.setFont(new java.awt.Font("DialogInput", 1, 16)); // NOI18N
        lblMensagem.setForeground(new java.awt.Color(229, 0, 0));

        lblAno.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblAno.setText("Ano/Semestre:");
        lblAno.setToolTipText("");

        btnValidarTurmas.setBackground(new java.awt.Color(255, 255, 255));
        btnValidarTurmas.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        btnValidarTurmas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/validar.png"))); // NOI18N
        btnValidarTurmas.setText("Validar Turmas");
        btnValidarTurmas.setToolTipText("Validar Aulas");
        btnValidarTurmas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnValidarTurmas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValidarTurmasActionPerformed(evt);
            }
        });

        lblTempoMaximo.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblTempoMaximo.setText("Tempo Máximo:");
        lblTempoMaximo.setToolTipText("");

        spnTempoMaximo.setFont(new java.awt.Font("DialogInput", 0, 16)); // NOI18N
        spnTempoMaximo.setModel(new javax.swing.SpinnerNumberModel(11, 0, 24, 1));
        spnTempoMaximo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnTempoMaximoStateChanged(evt);
            }
        });

        lblIntervaloMinimo.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblIntervaloMinimo.setText("Intervalo Mínimo:");

        spnIntervalo.setFont(new java.awt.Font("DialogInput", 0, 16)); // NOI18N
        spnIntervalo.setModel(new javax.swing.SpinnerNumberModel(11, 0, 24, 1));
        spnIntervalo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnIntervaloStateChanged(evt);
            }
        });

        btnValidarOferta.setBackground(new java.awt.Color(255, 255, 255));
        btnValidarOferta.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        btnValidarOferta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/validar.png"))); // NOI18N
        btnValidarOferta.setText("Validar");
        btnValidarOferta.setToolTipText("Validar Aulas");
        btnValidarOferta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnValidarOferta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValidarOfertaActionPerformed(evt);
            }
        });

        btnCQD.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        btnCQD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/cqd.png"))); // NOI18N
        btnCQD.setToolTipText("Controle de Quantidade de Disciplinas");
        btnCQD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnCQD.setOpaque(true);
        btnCQD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCQDActionPerformed(evt);
            }
        });

        btnSalvar.setBackground(new java.awt.Color(255, 255, 255));
        btnSalvar.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/save-aulas.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnDesfazer.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        btnDesfazer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/desfazer.png"))); // NOI18N
        btnDesfazer.setToolTipText("Desfazer Alterações");
        btnDesfazer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnDesfazer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesfazerActionPerformed(evt);
            }
        });

        lblPeriodo.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblPeriodo.setText("Período:");
        lblPeriodo.setToolTipText("");

        spnPeriodo.setFont(new java.awt.Font("DialogInput", 0, 18)); // NOI18N
        spnPeriodo.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        spnPeriodo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnPeriodoStateChanged(evt);
            }
        });

        btnRevalidarTurmas.setFont(new java.awt.Font("DialogInput", 0, 12)); // NOI18N
        btnRevalidarTurmas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/recarregar.png"))); // NOI18N
        btnRevalidarTurmas.setToolTipText("Revalidar Turmas Ativas");
        btnRevalidarTurmas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRevalidarTurmasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlAlocacoesLayout = new javax.swing.GroupLayout(pnlAlocacoes);
        pnlAlocacoes.setLayout(pnlAlocacoesLayout);
        pnlAlocacoesLayout.setHorizontalGroup(
            pnlAlocacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAlocacoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAlocacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnValidarTurmas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(cbxCurso, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlAlocacoesLayout.createSequentialGroup()
                        .addGroup(pnlAlocacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbxTurma, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblAno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlAlocacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxTurno, 0, 1, Short.MAX_VALUE)
                            .addGroup(pnlAlocacoesLayout.createSequentialGroup()
                                .addComponent(spnAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spnSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRevalidarTurmas, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                    .addGroup(pnlAlocacoesLayout.createSequentialGroup()
                        .addGroup(pnlAlocacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblIntervaloMinimo, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                            .addComponent(lblTempoMaximo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlAlocacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(spnTempoMaximo, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                            .addComponent(spnIntervalo)))
                    .addGroup(pnlAlocacoesLayout.createSequentialGroup()
                        .addGroup(pnlAlocacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnValidarOferta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlAlocacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCQD, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                            .addComponent(btnDesfazer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlAlocacoesLayout.createSequentialGroup()
                        .addComponent(lblPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(spnPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblMensagem, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
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
                .addGroup(pnlAlocacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlAlocacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(spnAno, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(spnSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnRevalidarTurmas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlAlocacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(spnPeriodo)
                    .addComponent(lblPeriodo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlAlocacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnValidarOferta, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCQD, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlAlocacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDesfazer, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlAlocacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTempoMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnTempoMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlAlocacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(spnIntervalo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlAlocacoesLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(lblIntervaloMinimo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnValidarTurmas, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(pnlProfessor, javax.swing.GroupLayout.DEFAULT_SIZE, 844, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlNotificacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlNotificacoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlAlocacoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlPrincipalLayout.createSequentialGroup()
                        .addComponent(pnlTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlProfessor, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)))
                .addContainerGap())
        );

        getContentPane().add(pnlPrincipal, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        salvarAulas();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnValidarOfertaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnValidarOfertaActionPerformed
        validarAulas();
    }//GEN-LAST:event_btnValidarOfertaActionPerformed

    private void cbxTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTurmaActionPerformed
        ctrlPrincipal.getCtrlOferta().setAbrindoTela(true);
        ctrlPrincipal.getCtrlOferta().identificarUltimaOfertaTurma(cbxTurma);
        atualizarTela();
    }//GEN-LAST:event_cbxTurmaActionPerformed

    private void cbxCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCursoActionPerformed
        ctrlPrincipal.getCtrlOferta().setAbrindoTela(true);
        preencherComboTurma();
    }//GEN-LAST:event_cbxCursoActionPerformed

    private void spnAnoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnAnoStateChanged
        atualizarTela();
    }//GEN-LAST:event_spnAnoStateChanged

    private void spnSemestreStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnSemestreStateChanged
        atualizarTela();
    }//GEN-LAST:event_spnSemestreStateChanged

    private void cbxTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTurnoActionPerformed
        ctrlPrincipal.getCtrlOferta().alterarTurno((String) cbxTurno.getSelectedItem(), tblTurma);
        this.repaint();
        ctrlPrincipal.getCtrlAula().preencherTabelaAulas(tblTurma, (String) cbxTurno.getSelectedItem());
    }//GEN-LAST:event_cbxTurnoActionPerformed

    private void tblTurmaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTurmaMouseClicked
        if(evt.getButton() == MouseEvent.BUTTON3)
            removerAula(evt.getX(), evt.getY());   
    }//GEN-LAST:event_tblTurmaMouseClicked

    private void itemRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRemoverActionPerformed
        ctrlPrincipal.getCtrlAula().removerAula(tblTurma);
    }//GEN-LAST:event_itemRemoverActionPerformed

    private void lstAlocacoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstAlocacoesMouseClicked
        preencherHorarioProfessor();
    }//GEN-LAST:event_lstAlocacoesMouseClicked

    private void cbxQuantidadeProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxQuantidadeProfessorActionPerformed
        ctrlPrincipal.getCtrlOferta().alterarProfessorCombo(lstAlocacoes, tblProfessor, cbxQuantidadeProfessor);
    }//GEN-LAST:event_cbxQuantidadeProfessorActionPerformed

    private void spnTempoMaximoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnTempoMaximoStateChanged
        if(spnTempoMaximo.isEnabled())
            atualizarOferta();
    }//GEN-LAST:event_spnTempoMaximoStateChanged

    private void spnIntervaloStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnIntervaloStateChanged
        if(spnIntervalo.isEnabled())
            atualizarOferta();
    }//GEN-LAST:event_spnIntervaloStateChanged

    private void btnCQDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCQDActionPerformed
        ctrlPrincipal.getCtrlOferta().validarOferta(tblTurma, btnCQD);
    }//GEN-LAST:event_btnCQDActionPerformed

    private void btnDesfazerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesfazerActionPerformed
        desfazer();
    }//GEN-LAST:event_btnDesfazerActionPerformed

    private void spnPeriodoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnPeriodoStateChanged
        atualizarTela();
    }//GEN-LAST:event_spnPeriodoStateChanged

    private void btnValidarTurmasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnValidarTurmasActionPerformed
        validarTurmas();
    }//GEN-LAST:event_btnValidarTurmasActionPerformed

    private void btnRevalidarTurmasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRevalidarTurmasActionPerformed
        preencherComboTurma();
    }//GEN-LAST:event_btnRevalidarTurmasActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnCQD;
    private javax.swing.JButton btnDesfazer;
    private javax.swing.JButton btnRevalidarTurmas;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnValidarOferta;
    private javax.swing.JButton btnValidarTurmas;
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
    private javax.swing.JLabel lblPeriodo;
    private javax.swing.JLabel lblQuarta;
    private javax.swing.JLabel lblQuarta1;
    private javax.swing.JLabel lblQuinta;
    private javax.swing.JLabel lblQuinta1;
    private javax.swing.JLabel lblSegunda;
    private javax.swing.JLabel lblSegunda1;
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
    private javax.swing.JPopupMenu popUpRemover;
    private javax.swing.JSpinner spnAno;
    private javax.swing.JSpinner spnIntervalo;
    private javax.swing.JSpinner spnPeriodo;
    private javax.swing.JSpinner spnSemestre;
    private javax.swing.JSpinner spnTempoMaximo;
    private javax.swing.JTable tblProfessor;
    private javax.swing.JTable tblTurma;
    private javax.swing.JTextArea txtAreaNotificacoes;
    // End of variables declaration//GEN-END:variables
}

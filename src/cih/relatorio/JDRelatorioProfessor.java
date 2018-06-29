package cih.relatorio;

import cci.CtrlPrincipal;
import cci.RenderizadorCelulas;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class JDRelatorioProfessor extends javax.swing.JDialog {
    
    private CtrlPrincipal ctrlPrincipal;

    public JDRelatorioProfessor(java.awt.Frame parent, boolean modal, CtrlPrincipal ctrl) {
        super(parent, modal);
        this.ctrlPrincipal = ctrl;
        initComponents();
        setarBackground();
    }
    
    public void preencherTabelaProfessor(){
        
        int ano = (int) spnAno.getValue();
        int semestre = (int) spnSemestre.getValue();
        ctrlPrincipal.getCtrlRelatorio().identificarProfessor(ano, semestre, cbxProfessor, tblProfessor);
    }
    
    public void atualizarAulasProfessor(){
        int ano = (int) spnAno.getValue();
        int semestre = (int) spnSemestre.getValue();
        ctrlPrincipal.getCtrlRelatorio().atualizarListaAulasAnoSemestre(ano, semestre);
        ctrlPrincipal.getCtrlRelatorio().identificarProfessor(ano, semestre, cbxProfessor, tblProfessor);
    }
    
    public void identificarUltimaAlocacao(){
        ctrlPrincipal.getCtrlRelatorio().identificarUltimaAlocacaoProfessor(cbxProfessor);
    }
    
    private void setarBackground(){
        pnlPrincipal.setBackground(ctrlPrincipal.setarCorPanelExterior());
        pnlConfiguracoes.setBackground(ctrlPrincipal.setarCorPanelInterior());
    }
    
    public void preencherComboEixo(){
        ctrlPrincipal.getCtrlRelatorio().preencherComboEixos(cbxEixo);
    }
    
    public void preencherComboCoordenadoria(){
        ctrlPrincipal.getCtrlRelatorio().preencherComboCoordenadoria(cbxEixo, cbxCoordenadoria);
    }
    
    public void preencherComboProfessor(){
        ctrlPrincipal.getCtrlRelatorio().preencherComboProfessor(cbxCoordenadoria, cbxProfessor);
    }
    
    public void setarProfessor(String nome){
        lblNomeProfessor.setText(nome);
    }
    
    public void gerarRelatorioProfessor(){
        
        char tipo = (char) grpFiltros.getSelection().getMnemonic();
        int ano = (int) spnAno.getValue();
        int semestre = (int) spnSemestre.getValue();
        
        ctrlPrincipal.getCtrlRelatorioProfessor().identificarFiltroRelatorioProfessor(cbxEixo, cbxCoordenadoria, cbxProfessor, ano, semestre, tipo, this);
    }
    
    public void enviarEmails(){
        
        char tipo = (char) grpFiltros.getSelection().getMnemonic();
        int ano = (int) spnAno.getValue();
        int semestre = (int) spnSemestre.getValue();
        
        ctrlPrincipal.getCtrlEmail().identificarProfessoresEnvioEmail(cbxEixo, cbxCoordenadoria, cbxProfessor, ano, semestre, tipo, this);
    }
    
    public void ativarFiltroNenhum(){
        ativarFiltroEixo(false);
        ativarFiltroCoordenadoria(false);
        ativarFiltroProfessor(false);
    }
    
    public void ativarFiltroEixo(boolean opcao){
        cbxEixo.setEnabled(opcao);
        if(opcao)
            preencherComboEixo();
        else
            cbxEixo.removeAllItems();
    }
    
    public void ativarFiltroCoordenadoria(boolean opcao){
        cbxCoordenadoria.setEnabled(opcao);
        if(opcao)
            preencherComboCoordenadoria();
        else
            cbxCoordenadoria.removeAllItems();
    }
    
    public void ativarFiltroProfessor(boolean opcao){
        cbxProfessor.setEnabled(opcao);
        if(opcao){
            preencherComboProfessor();
        }else
            cbxProfessor.removeAllItems();
        
        preencherTabelaProfessor();
    }
    
    public void gerandoRelatorio(){
        btnGerar.setEnabled(false);
        btnGerar.setText("Gerando Relatório...");
        btnGerar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/aguarde.png")));
    }
    
    public void relatorioGerado(){
        btnGerar.setEnabled(true);
        btnGerar.setText("Gerar Relatório");
        btnGerar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/relatorio-botao.png")));
    }
    
    public void enviandoEmails(){
        btnEnviarEmail.setEnabled(false);
        btnEnviarEmail.setText("Enviando Emails...");
        btnEnviarEmail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/aguarde.png")));
    }
    
    public void emailEnviado(){
        btnEnviarEmail.setEnabled(true);
        btnEnviarEmail.setText("Enviar por e-mail");
        btnEnviarEmail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/email.png")));
    }
    
    public JSpinner getSpnAno() {
        return spnAno;
    }

    public JSpinner getSpnSemestre() {
        return spnSemestre;
    }
       
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grpFiltros = new javax.swing.ButtonGroup();
        pnlPrincipal = new javax.swing.JPanel();
        pnlConfiguracoes = new javax.swing.JPanel();
        cbxCoordenadoria = new javax.swing.JComboBox<>();
        cbxProfessor = new javax.swing.JComboBox<>();
        cbxEixo = new javax.swing.JComboBox<>();
        lblProfessor = new javax.swing.JLabel();
        lblEixo = new javax.swing.JLabel();
        lblCoordenadoria = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        rbtnTodos = new javax.swing.JRadioButton();
        rbtnCoordenadoria = new javax.swing.JRadioButton();
        rbtnEixo = new javax.swing.JRadioButton();
        spnAno = new javax.swing.JSpinner();
        spnSemestre = new javax.swing.JSpinner();
        lblAno = new javax.swing.JLabel();
        rbtnProfessor = new javax.swing.JRadioButton();
        btnGerar = new javax.swing.JButton();
        btnAbrirPasta = new javax.swing.JButton();
        btnEnviarEmail = new javax.swing.JButton();
        pnlProfessor = new javax.swing.JPanel();
        pnlDiasProfessor = new javax.swing.JPanel();
        lblSexta1 = new javax.swing.JLabel();
        lblQuinta1 = new javax.swing.JLabel();
        lblTerca1 = new javax.swing.JLabel();
        lblQuarta1 = new javax.swing.JLabel();
        lblSegunda1 = new javax.swing.JLabel();
        pnlNomeProfessor = new javax.swing.JPanel();
        lblNomeProfessor = new javax.swing.JLabel();
        pnlTabelaProfessor = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblProfessor = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatório de Professores");
        setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        setMinimumSize(new java.awt.Dimension(1100, 300));
        setResizable(false);
        setSize(new java.awt.Dimension(1366, 788));

        pnlPrincipal.setBackground(new java.awt.Color(53, 151, 48));
        pnlPrincipal.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        pnlPrincipal.setMaximumSize(new java.awt.Dimension(1920, 790));

        pnlConfiguracoes.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Configurações", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 1, 14))); // NOI18N

        cbxCoordenadoria.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        cbxCoordenadoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCoordenadoriaActionPerformed(evt);
            }
        });

        cbxProfessor.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        cbxProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxProfessorActionPerformed(evt);
            }
        });

        cbxEixo.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        cbxEixo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEixoActionPerformed(evt);
            }
        });

        lblProfessor.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblProfessor.setText("Professor:");
        lblProfessor.setToolTipText("");

        lblEixo.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblEixo.setText("Eixo:");
        lblEixo.setToolTipText("");

        lblCoordenadoria.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblCoordenadoria.setText("Coordenadoria:");
        lblCoordenadoria.setToolTipText("");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filtro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 1, 14))); // NOI18N

        grpFiltros.add(rbtnTodos);
        rbtnTodos.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        rbtnTodos.setMnemonic('a');
        rbtnTodos.setSelected(true);
        rbtnTodos.setText("Nenhum");
        rbtnTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnTodosActionPerformed(evt);
            }
        });

        grpFiltros.add(rbtnCoordenadoria);
        rbtnCoordenadoria.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        rbtnCoordenadoria.setMnemonic('c');
        rbtnCoordenadoria.setText("Coord.");
        rbtnCoordenadoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnCoordenadoriaActionPerformed(evt);
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

        grpFiltros.add(rbtnProfessor);
        rbtnProfessor.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        rbtnProfessor.setMnemonic('p');
        rbtnProfessor.setText("Professor");
        rbtnProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnProfessorActionPerformed(evt);
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
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblAno, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(spnAno, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spnSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(rbtnTodos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbtnEixo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbtnCoordenadoria)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbtnProfessor)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbtnCoordenadoria, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbtnEixo, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbtnProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAno, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnAno, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

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

        btnAbrirPasta.setBackground(new java.awt.Color(255, 255, 255));
        btnAbrirPasta.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        btnAbrirPasta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/pasta.png"))); // NOI18N
        btnAbrirPasta.setText("Mostrar Na Pasta");
        btnAbrirPasta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnAbrirPasta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirPastaActionPerformed(evt);
            }
        });

        btnEnviarEmail.setBackground(new java.awt.Color(255, 255, 255));
        btnEnviarEmail.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        btnEnviarEmail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/email.png"))); // NOI18N
        btnEnviarEmail.setText("Enviar por e-mail");
        btnEnviarEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnEnviarEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarEmailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlConfiguracoesLayout = new javax.swing.GroupLayout(pnlConfiguracoes);
        pnlConfiguracoes.setLayout(pnlConfiguracoesLayout);
        pnlConfiguracoesLayout.setHorizontalGroup(
            pnlConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlConfiguracoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlConfiguracoesLayout.createSequentialGroup()
                        .addGroup(pnlConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEixo)
                            .addComponent(cbxEixo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxCoordenadoria, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCoordenadoria))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlConfiguracoesLayout.createSequentialGroup()
                                .addComponent(lblProfessor)
                                .addGap(0, 264, Short.MAX_VALUE))
                            .addComponent(cbxProfessor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(pnlConfiguracoesLayout.createSequentialGroup()
                        .addGap(0, 228, Short.MAX_VALUE)
                        .addComponent(btnEnviarEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAbrirPasta, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnGerar, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlConfiguracoesLayout.setVerticalGroup(
            pnlConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlConfiguracoesLayout.createSequentialGroup()
                .addGroup(pnlConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlConfiguracoesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlConfiguracoesLayout.createSequentialGroup()
                        .addGroup(pnlConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnGerar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                            .addComponent(btnAbrirPasta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEnviarEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlConfiguracoesLayout.createSequentialGroup()
                                .addComponent(lblProfessor)
                                .addGap(53, 53, 53))
                            .addGroup(pnlConfiguracoesLayout.createSequentialGroup()
                                .addGroup(pnlConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblEixo)
                                    .addComponent(lblCoordenadoria))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbxEixo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxCoordenadoria, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addComponent(lblSegunda1)
                        .addGap(0, 2, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlDiasProfessorLayout.setVerticalGroup(
            pnlDiasProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDiasProfessorLayout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
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
        tblProfessor.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        tblProfessor.setDragEnabled(true);
        tblProfessor.setDropMode(javax.swing.DropMode.INSERT);
        tblProfessor.setEnabled(false);
        tblProfessor.setMaximumSize(new java.awt.Dimension(2147483647, 400));
        tblProfessor.setRowHeight(45);
        tblProfessor.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblProfessor.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(tblProfessor);
        ((DefaultTableCellRenderer)tblProfessor.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        tblProfessor.setDefaultRenderer(Object.class, new RenderizadorCelulas(ctrlPrincipal, 3));

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
                    .addComponent(pnlTabelaProfessor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlConfiguracoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlProfessor, javax.swing.GroupLayout.DEFAULT_SIZE, 1222, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlConfiguracoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(pnlPrincipal, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarActionPerformed
        gerarRelatorioProfessor();
    }//GEN-LAST:event_btnGerarActionPerformed

    private void cbxProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxProfessorActionPerformed
        preencherTabelaProfessor();
    }//GEN-LAST:event_cbxProfessorActionPerformed

    private void cbxCoordenadoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCoordenadoriaActionPerformed
        if(cbxProfessor.isEnabled()){
            preencherComboProfessor();
            preencherTabelaProfessor();
        }
    }//GEN-LAST:event_cbxCoordenadoriaActionPerformed

    private void spnAnoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnAnoStateChanged
        atualizarAulasProfessor();
    }//GEN-LAST:event_spnAnoStateChanged

    private void spnSemestreStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnSemestreStateChanged
        atualizarAulasProfessor();
    }//GEN-LAST:event_spnSemestreStateChanged

    private void cbxEixoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEixoActionPerformed
        if(cbxCoordenadoria.isEnabled())
            preencherComboCoordenadoria();
        if(cbxProfessor.isEnabled()){
            preencherComboProfessor();
            preencherTabelaProfessor();
        }
    }//GEN-LAST:event_cbxEixoActionPerformed

    private void rbtnTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnTodosActionPerformed
        ativarFiltroNenhum();
    }//GEN-LAST:event_rbtnTodosActionPerformed

    private void rbtnEixoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnEixoActionPerformed
        ativarFiltroEixo(true);
        ativarFiltroCoordenadoria(false);
        ativarFiltroProfessor(false);
    }//GEN-LAST:event_rbtnEixoActionPerformed

    private void rbtnCoordenadoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnCoordenadoriaActionPerformed
        ativarFiltroEixo(true);
        ativarFiltroCoordenadoria(true);
        ativarFiltroProfessor(false);
    }//GEN-LAST:event_rbtnCoordenadoriaActionPerformed

    private void rbtnProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnProfessorActionPerformed
        ativarFiltroEixo(true);
        ativarFiltroCoordenadoria(true);
        ativarFiltroProfessor(true);
    }//GEN-LAST:event_rbtnProfessorActionPerformed

    private void btnAbrirPastaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirPastaActionPerformed
        
        int ano = (int) spnAno.getValue();
        int semestre = (int) spnSemestre.getValue();
        
        ctrlPrincipal.getCtrlRelatorioProfessor().abrirPastaProfessor(ano, semestre, this);
    }//GEN-LAST:event_btnAbrirPastaActionPerformed

    private void btnEnviarEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarEmailActionPerformed
        enviarEmails();
    }//GEN-LAST:event_btnEnviarEmailActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrirPasta;
    private javax.swing.JButton btnEnviarEmail;
    private javax.swing.JButton btnGerar;
    private javax.swing.JComboBox<String> cbxCoordenadoria;
    private javax.swing.JComboBox<String> cbxEixo;
    private javax.swing.JComboBox<String> cbxProfessor;
    private javax.swing.ButtonGroup grpFiltros;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblAno;
    private javax.swing.JLabel lblCoordenadoria;
    private javax.swing.JLabel lblEixo;
    private javax.swing.JLabel lblNomeProfessor;
    private javax.swing.JLabel lblProfessor;
    private javax.swing.JLabel lblQuarta1;
    private javax.swing.JLabel lblQuinta1;
    private javax.swing.JLabel lblSegunda1;
    private javax.swing.JLabel lblSexta1;
    private javax.swing.JLabel lblTerca1;
    private javax.swing.JPanel pnlConfiguracoes;
    private javax.swing.JPanel pnlDiasProfessor;
    private javax.swing.JPanel pnlNomeProfessor;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JPanel pnlProfessor;
    private javax.swing.JPanel pnlTabelaProfessor;
    private javax.swing.JRadioButton rbtnCoordenadoria;
    private javax.swing.JRadioButton rbtnEixo;
    private javax.swing.JRadioButton rbtnProfessor;
    private javax.swing.JRadioButton rbtnTodos;
    private javax.swing.JSpinner spnAno;
    private javax.swing.JSpinner spnSemestre;
    private javax.swing.JTable tblProfessor;
    // End of variables declaration//GEN-END:variables
}

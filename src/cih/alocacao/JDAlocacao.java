package cih.alocacao;

import cci.CtrlPrincipal;
import java.awt.Frame;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class JDAlocacao extends javax.swing.JDialog {

    private CtrlPrincipal ctrlPrincipal;
    private Frame pai;
    
    public JDAlocacao(java.awt.Frame parent, boolean modal, CtrlPrincipal ctrl) {
        super(parent, modal);
        initComponents();
        ctrlPrincipal = ctrl;
        this.pai = parent;
        setarBackground();
        alterarLarguraTabela();
    }
    
    public void alterarLarguraTabela(){
        tblAlocacao.getColumnModel().getColumn(0).setPreferredWidth(280);
        tblAlocacao.getColumnModel().getColumn(1).setPreferredWidth(5);
    }

    private void setarBackground(){
        pnlPrincipal.setBackground(ctrlPrincipal.setarCorPanelExterior());
        pnlAlocacao.setBackground(ctrlPrincipal.setarCorPanelInterior());
        pnlAnoSemestre.setBackground(ctrlPrincipal.setarCorPanelInterior());
        pnlDisciplina.setBackground(ctrlPrincipal.setarCorPanelInterior());
        pnlProfessor.setBackground(ctrlPrincipal.setarCorPanelInterior());
    }
    
    public void atualizarTabela(){
        
        lblMensagem.setText("");
        
        int ano = (int) spnAno.getValue();
        int semestre = (int) spnSemestre.getValue();
        int periodo = (int) spnPeriodo.getValue();
        ctrlPrincipal.getCtrlAlocacao().listarAlocacoes(ano, semestre, periodo, tblAlocacao, cbxMatriz);   
    }
    
    public void preencherComboCurso(){
        ctrlPrincipal.getCtrlAlocacao().preencherComboCurso(cbxCurso, cbxMatriz);    
    }
    
    public void preencherComboEixo(){
        ctrlPrincipal.getCtrlAlocacao().preencherComboEixos(cbxEixo);
    }
    
    public void preencherListaDisciplinas(){
        ctrlPrincipal.getCtrlAlocacao().preencherListaDisciplinas(cbxMatriz, lstDisciplinas, spnPeriodo);
        spnPeriodo.setValue(1);
    }
    
    public void preencherListaProfessores(){
        
        char filtro = (char) btnGroupProfessor.getSelection().getMnemonic();
        
        ctrlPrincipal.getCtrlAlocacao().preencherListaProfessores(cbxEixo, lstProfessores, filtro);
    }
    
    public void setarPeriodoMaximo(int maximo){
        spnPeriodo.setModel(new javax.swing.SpinnerNumberModel(1, 1, maximo, 1));
    }
    
    public int getAno(){
        return (int) spnAno.getValue();
    }
    
    public int getSemestre(){
        return (int) spnSemestre.getValue();
    }
    
    public void setAno(int ano){
        spnAno.setValue(ano);
    }
    
    public void setSemestre(int semestre){
        spnSemestre.setValue(semestre);
    }
    
    public void setarMensagem(String mensagem){
        lblMensagem.setText(mensagem);
    }
    
    public void setarAtalho(String mensagem){
        lblAtalho.setText(mensagem);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupProfessor = new javax.swing.ButtonGroup();
        pnlPrincipal = new javax.swing.JPanel();
        pnlDisciplina = new javax.swing.JPanel();
        cbxCurso = new javax.swing.JComboBox<>();
        cbxMatriz = new javax.swing.JComboBox<>();
        spnPeriodo = new javax.swing.JSpinner();
        lblPeriodo = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstDisciplinas = new javax.swing.JList<>();
        pnlProfessor = new javax.swing.JPanel();
        cbxEixo = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstProfessores = new javax.swing.JList<>();
        jSeparator2 = new javax.swing.JSeparator();
        lblAtalho = new javax.swing.JLabel();
        rbtnTodos = new javax.swing.JRadioButton();
        rbtnEixo = new javax.swing.JRadioButton();
        pnlAlocacao = new javax.swing.JPanel();
        pnlAnoSemestre = new javax.swing.JPanel();
        spnSemestre = new javax.swing.JSpinner();
        spnAno = new javax.swing.JSpinner();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAlocacao = new javax.swing.JTable();
        btnAdicionar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        btnCargaHoraria = new javax.swing.JButton();
        lblMensagem = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciar Alocações");
        setResizable(false);

        pnlDisciplina.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Disciplina", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 0, 14))); // NOI18N

        cbxCurso.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        cbxCurso.setPreferredSize(new java.awt.Dimension(39, 30));
        cbxCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCursoActionPerformed(evt);
            }
        });

        cbxMatriz.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        cbxMatriz.setPreferredSize(new java.awt.Dimension(39, 30));
        cbxMatriz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMatrizActionPerformed(evt);
            }
        });

        spnPeriodo.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        spnPeriodo.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        spnPeriodo.setPreferredSize(new java.awt.Dimension(31, 30));
        spnPeriodo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnPeriodoStateChanged(evt);
            }
        });

        lblPeriodo.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblPeriodo.setText("Período:");
        lblPeriodo.setPreferredSize(new java.awt.Dimension(64, 30));

        lstDisciplinas.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lstDisciplinas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstDisciplinas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstDisciplinasMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(lstDisciplinas);

        javax.swing.GroupLayout pnlDisciplinaLayout = new javax.swing.GroupLayout(pnlDisciplina);
        pnlDisciplina.setLayout(pnlDisciplinaLayout);
        pnlDisciplinaLayout.setHorizontalGroup(
            pnlDisciplinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDisciplinaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlDisciplinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbxCurso, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDisciplinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pnlDisciplinaLayout.createSequentialGroup()
                            .addComponent(cbxMatriz, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(lblPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(spnPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        pnlDisciplinaLayout.setVerticalGroup(
            pnlDisciplinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDisciplinaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbxCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDisciplinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxMatriz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPeriodo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pnlProfessor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Professor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 0, 14))); // NOI18N

        cbxEixo.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        cbxEixo.setPreferredSize(new java.awt.Dimension(39, 30));
        cbxEixo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEixoActionPerformed(evt);
            }
        });

        lstProfessores.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lstProfessores.setToolTipText("");
        jScrollPane2.setViewportView(lstProfessores);

        lblAtalho.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N

        btnGroupProfessor.add(rbtnTodos);
        rbtnTodos.setFont(new java.awt.Font("DialogInput", 0, 13)); // NOI18N
        rbtnTodos.setMnemonic('t');
        rbtnTodos.setText("Todos");
        rbtnTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnTodosActionPerformed(evt);
            }
        });

        btnGroupProfessor.add(rbtnEixo);
        rbtnEixo.setFont(new java.awt.Font("DialogInput", 0, 13)); // NOI18N
        rbtnEixo.setMnemonic('e');
        rbtnEixo.setSelected(true);
        rbtnEixo.setText("Eixo");
        rbtnEixo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnEixoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlProfessorLayout = new javax.swing.GroupLayout(pnlProfessor);
        pnlProfessor.setLayout(pnlProfessorLayout);
        pnlProfessorLayout.setHorizontalGroup(
            pnlProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(pnlProfessorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlProfessorLayout.createSequentialGroup()
                        .addComponent(rbtnEixo)
                        .addGap(18, 18, 18)
                        .addComponent(rbtnTodos)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                    .addComponent(cbxEixo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblAtalho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlProfessorLayout.setVerticalGroup(
            pnlProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProfessorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnTodos)
                    .addComponent(rbtnEixo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxEixo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAtalho, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        pnlAlocacao.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Alocações", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 0, 14))); // NOI18N

        pnlAnoSemestre.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ano/Semestre", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 0, 14))); // NOI18N

        spnSemestre.setFont(new java.awt.Font("DialogInput", 0, 18)); // NOI18N
        spnSemestre.setModel(new javax.swing.SpinnerNumberModel(1, 1, 2, 1));
        spnSemestre.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnSemestreStateChanged(evt);
            }
        });

        spnAno.setFont(new java.awt.Font("DialogInput", 0, 18)); // NOI18N
        spnAno.setModel(new javax.swing.SpinnerNumberModel(2018, 2000, null, 1));
        spnAno.setEditor(new JSpinner.NumberEditor(spnAno, "####"));
        spnAno.setPreferredSize(new java.awt.Dimension(31, 35));
        spnAno.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnAnoStateChanged(evt);
            }
        });

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/icone-pesquisar-reduzido.png"))); // NOI18N
        btnBuscar.setToolTipText("Buscar alocações");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlAnoSemestreLayout = new javax.swing.GroupLayout(pnlAnoSemestre);
        pnlAnoSemestre.setLayout(pnlAnoSemestreLayout);
        pnlAnoSemestreLayout.setHorizontalGroup(
            pnlAnoSemestreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAnoSemestreLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spnAno, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(spnSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlAnoSemestreLayout.setVerticalGroup(
            pnlAnoSemestreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAnoSemestreLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(pnlAnoSemestreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlAnoSemestreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(spnAno, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(spnSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblAlocacao.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        tblAlocacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Disciplina / Professor", "Período", "Completa"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ((DefaultTableCellRenderer)tblAlocacao.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        jScrollPane1.setViewportView(tblAlocacao);

        btnAdicionar.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        btnAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/plus.png"))); // NOI18N
        btnAdicionar.setToolTipText("Adicionar Alocação");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnRemover.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        btnRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/trash.png"))); // NOI18N
        btnRemover.setToolTipText("Remover Alocação");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        btnCargaHoraria.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        btnCargaHoraria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/tempo.png"))); // NOI18N
        btnCargaHoraria.setText("Carga Horária");
        btnCargaHoraria.setToolTipText("Exibir carga horária dos professores");
        btnCargaHoraria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargaHorariaActionPerformed(evt);
            }
        });

        lblMensagem.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        lblMensagem.setForeground(new java.awt.Color(229, 0, 0));

        javax.swing.GroupLayout pnlAlocacaoLayout = new javax.swing.GroupLayout(pnlAlocacao);
        pnlAlocacao.setLayout(pnlAlocacaoLayout);
        pnlAlocacaoLayout.setHorizontalGroup(
            pnlAlocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAlocacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAlocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAlocacaoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pnlAlocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAlocacaoLayout.createSequentialGroup()
                                .addGroup(pnlAlocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(pnlAlocacaoLayout.createSequentialGroup()
                                        .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnRemover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(btnCargaHoraria, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(pnlAnoSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(lblMensagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlAlocacaoLayout.setVerticalGroup(
            pnlAlocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAlocacaoLayout.createSequentialGroup()
                .addGroup(pnlAlocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAlocacaoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlAlocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(btnCargaHoraria, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(pnlAnoSemestre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlAlocacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlAlocacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlProfessor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlDisciplina, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );

        getContentPane().add(pnlPrincipal, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        ctrlPrincipal.getCtrlAlocacao().cadastrar(lstProfessores, lstDisciplinas, spnAno, spnSemestre);
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        ctrlPrincipal.getCtrlAlocacao().excluir(tblAlocacao);
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void cbxMatrizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMatrizActionPerformed
        preencherListaDisciplinas();
    }//GEN-LAST:event_cbxMatrizActionPerformed

    private void spnPeriodoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnPeriodoStateChanged
        ctrlPrincipal.getCtrlAlocacao().preencherListaDisciplinas(cbxMatriz, lstDisciplinas, spnPeriodo);
        atualizarTabela();
    }//GEN-LAST:event_spnPeriodoStateChanged

    private void btnCargaHorariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargaHorariaActionPerformed
        ctrlPrincipal.getCtrlAlocacao().instanciarTelaCargaHoraria(pai);
    }//GEN-LAST:event_btnCargaHorariaActionPerformed

    private void spnAnoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnAnoStateChanged
        atualizarTabela();
    }//GEN-LAST:event_spnAnoStateChanged

    private void spnSemestreStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnSemestreStateChanged
        atualizarTabela();
    }//GEN-LAST:event_spnSemestreStateChanged

    private void cbxEixoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEixoActionPerformed
        preencherListaProfessores();
    }//GEN-LAST:event_cbxEixoActionPerformed

    private void cbxCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCursoActionPerformed
        setarMensagem("");
        ctrlPrincipal.getCtrlAlocacao().preencherComboMatriz(cbxCurso, cbxMatriz);
    }//GEN-LAST:event_cbxCursoActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        atualizarTabela();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void lstDisciplinasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstDisciplinasMouseClicked
        ctrlPrincipal.getCtrlAlocacao().identificarDisciplinaEspecial(lstDisciplinas);
    }//GEN-LAST:event_lstDisciplinasMouseClicked

    private void rbtnEixoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnEixoActionPerformed
        preencherComboEixo();
    }//GEN-LAST:event_rbtnEixoActionPerformed

    private void rbtnTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnTodosActionPerformed
        preencherListaProfessores();
    }//GEN-LAST:event_rbtnTodosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCargaHoraria;
    private javax.swing.ButtonGroup btnGroupProfessor;
    private javax.swing.JButton btnRemover;
    private javax.swing.JComboBox<String> cbxCurso;
    private javax.swing.JComboBox<String> cbxEixo;
    private javax.swing.JComboBox<String> cbxMatriz;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblAtalho;
    private javax.swing.JLabel lblMensagem;
    private javax.swing.JLabel lblPeriodo;
    private javax.swing.JList<String> lstDisciplinas;
    private javax.swing.JList<String> lstProfessores;
    private javax.swing.JPanel pnlAlocacao;
    private javax.swing.JPanel pnlAnoSemestre;
    private javax.swing.JPanel pnlDisciplina;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JPanel pnlProfessor;
    private javax.swing.JRadioButton rbtnEixo;
    private javax.swing.JRadioButton rbtnTodos;
    private javax.swing.JSpinner spnAno;
    private javax.swing.JSpinner spnPeriodo;
    private javax.swing.JSpinner spnSemestre;
    private javax.swing.JTable tblAlocacao;
    // End of variables declaration//GEN-END:variables
}

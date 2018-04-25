package cih.alocacao;

import cci.CtrlPrincipal;
import cdp.Curso;
import cdp.Eixo;
import java.awt.Frame;

public class JDAlocacao extends javax.swing.JDialog {

    private CtrlPrincipal ctrlPrincipal;
    private Frame pai;
    
    public JDAlocacao(java.awt.Frame parent, boolean modal, CtrlPrincipal ctrl) {
        super(parent, modal);
        initComponents();
        ctrlPrincipal = ctrl;
        this.pai = parent;
        setarBackground();
    }

    private void setarBackground(){
        pnlPrincipal.setBackground(ctrlPrincipal.setarCorPanelExterior());
        pnlAlocacao.setBackground(ctrlPrincipal.setarCorPanelInterior());
        pnlAnoSemestre.setBackground(ctrlPrincipal.setarCorPanelInterior());
        pnlDisciplina.setBackground(ctrlPrincipal.setarCorPanelInterior());
        pnlProfessor.setBackground(ctrlPrincipal.setarCorPanelInterior());
    }
    
    public void atualizarTabela(){
        
        int ano = (int) spnAno.getValue();
        int semestre = (int) spnSemestre.getValue();
        ctrlPrincipal.getCtrlAlocacao().listarAlocacoes(ano, semestre, tblAlocacao);   
    }
    
    public void preencherComboCurso(){
        ctrlPrincipal.getCtrlAlocacao().preencherComboCurso(cbxCurso, cbxMatriz);    
    }
    
    public void preencherComboEixo(){
        ctrlPrincipal.getCtrlAlocacao().preencherComboEixos(cbxEixo, cbxCoordenadoria);
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        cbxCoordenadoria = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstProfessores = new javax.swing.JList<>();
        jSeparator2 = new javax.swing.JSeparator();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciar Alocações");
        setResizable(false);

        pnlDisciplina.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Disciplina", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 0, 14))); // NOI18N

        cbxCurso.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        cbxCurso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um curso.." }));
        cbxCurso.setPreferredSize(new java.awt.Dimension(39, 30));
        cbxCurso.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxCursoItemStateChanged(evt);
            }
        });

        cbxMatriz.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        cbxMatriz.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Matriz Curricular..." }));
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
        jScrollPane3.setViewportView(lstDisciplinas);

        javax.swing.GroupLayout pnlDisciplinaLayout = new javax.swing.GroupLayout(pnlDisciplina);
        pnlDisciplina.setLayout(pnlDisciplinaLayout);
        pnlDisciplinaLayout.setHorizontalGroup(
            pnlDisciplinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(pnlDisciplinaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDisciplinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                    .addComponent(cbxCurso, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlDisciplinaLayout.createSequentialGroup()
                        .addComponent(cbxMatriz, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(lblPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(spnPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlDisciplinaLayout.setVerticalGroup(
            pnlDisciplinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDisciplinaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbxCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDisciplinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxMatriz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPeriodo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlProfessor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Professor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 0, 14))); // NOI18N

        cbxEixo.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        cbxEixo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um eixo..." }));
        cbxEixo.setPreferredSize(new java.awt.Dimension(39, 30));
        cbxEixo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxEixoItemStateChanged(evt);
            }
        });

        cbxCoordenadoria.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        cbxCoordenadoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione uma coordenadoria..." }));
        cbxCoordenadoria.setPreferredSize(new java.awt.Dimension(39, 30));
        cbxCoordenadoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCoordenadoriaActionPerformed(evt);
            }
        });

        lstProfessores.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lstProfessores.setToolTipText("");
        jScrollPane2.setViewportView(lstProfessores);

        javax.swing.GroupLayout pnlProfessorLayout = new javax.swing.GroupLayout(pnlProfessor);
        pnlProfessor.setLayout(pnlProfessorLayout);
        pnlProfessorLayout.setHorizontalGroup(
            pnlProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProfessorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxEixo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbxCoordenadoria, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        pnlProfessorLayout.setVerticalGroup(
            pnlProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProfessorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbxEixo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbxCoordenadoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        pnlAlocacao.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Alocações", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 0, 14))); // NOI18N

        pnlAnoSemestre.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ano/Semestre", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 0, 14))); // NOI18N

        spnSemestre.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        spnSemestre.setModel(new javax.swing.SpinnerNumberModel(1, 1, 2, 1));

        spnAno.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        spnAno.setModel(new javax.swing.SpinnerNumberModel(2018, 2000, null, 1));
        spnAno.setPreferredSize(new java.awt.Dimension(31, 35));

        btnBuscar.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        btnBuscar.setText("OK");
        btnBuscar.setPreferredSize(new java.awt.Dimension(47, 35));
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(spnAno, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(spnSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlAnoSemestreLayout.setVerticalGroup(
            pnlAnoSemestreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAnoSemestreLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAnoSemestreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAnoSemestreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(spnSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(spnAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblAlocacao.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        tblAlocacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Período", "Disciplina", "Matriz", "Professor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblAlocacao);

        btnAdicionar.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnRemover.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        btnCargaHoraria.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        btnCargaHoraria.setText("Carga Horária");
        btnCargaHoraria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargaHorariaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlAlocacaoLayout = new javax.swing.GroupLayout(pnlAlocacao);
        pnlAlocacao.setLayout(pnlAlocacaoLayout);
        pnlAlocacaoLayout.setHorizontalGroup(
            pnlAlocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAlocacaoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlAlocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlAlocacaoLayout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAlocacaoLayout.createSequentialGroup()
                        .addGroup(pnlAlocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlAlocacaoLayout.createSequentialGroup()
                                .addComponent(btnAdicionar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnCargaHoraria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlAnoSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        pnlAlocacaoLayout.setVerticalGroup(
            pnlAlocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAlocacaoLayout.createSequentialGroup()
                .addGroup(pnlAlocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlAlocacaoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlAlocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                            .addComponent(btnRemover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCargaHoraria, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlAnoSemestre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                .addContainerGap())
        );

        getContentPane().add(pnlPrincipal, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        atualizarTabela();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void cbxCursoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxCursoItemStateChanged
        Curso curso = (Curso) cbxCurso.getSelectedItem();
        if(curso != null){
           ctrlPrincipal.getCtrlAlocacao().preencherComboMatriz(curso.getId(), cbxMatriz);
        }
    }//GEN-LAST:event_cbxCursoItemStateChanged

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        ctrlPrincipal.getCtrlAlocacao().cadastrar(lstProfessores, lstDisciplinas, spnAno, spnSemestre);
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        ctrlPrincipal.getCtrlAlocacao().excluir(tblAlocacao);
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void cbxEixoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxEixoItemStateChanged
        Eixo eixo = (Eixo) cbxEixo.getSelectedItem();
        if(eixo != null){
           ctrlPrincipal.getCtrlAlocacao().preencherComboCoordenadorias(eixo.getId(), cbxCoordenadoria);
        }
    }//GEN-LAST:event_cbxEixoItemStateChanged

    private void cbxMatrizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMatrizActionPerformed
        ctrlPrincipal.getCtrlAlocacao().preencherListaDisciplinas(cbxMatriz, lstDisciplinas, spnPeriodo);
    }//GEN-LAST:event_cbxMatrizActionPerformed

    private void cbxCoordenadoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCoordenadoriaActionPerformed
        ctrlPrincipal.getCtrlAlocacao().preencherListaProfessores(cbxCoordenadoria, lstProfessores);
    }//GEN-LAST:event_cbxCoordenadoriaActionPerformed

    private void spnPeriodoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnPeriodoStateChanged
        ctrlPrincipal.getCtrlAlocacao().preencherListaDisciplinas(cbxMatriz, lstDisciplinas, spnPeriodo);
    }//GEN-LAST:event_spnPeriodoStateChanged

    private void btnCargaHorariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargaHorariaActionPerformed
        ctrlPrincipal.getCtrlAlocacao().instanciarTelaCargaHoraria(pai);
    }//GEN-LAST:event_btnCargaHorariaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCargaHoraria;
    private javax.swing.JButton btnRemover;
    private javax.swing.JComboBox<String> cbxCoordenadoria;
    private javax.swing.JComboBox<String> cbxCurso;
    private javax.swing.JComboBox<String> cbxEixo;
    private javax.swing.JComboBox<String> cbxMatriz;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblPeriodo;
    private javax.swing.JList<String> lstDisciplinas;
    private javax.swing.JList<String> lstProfessores;
    private javax.swing.JPanel pnlAlocacao;
    private javax.swing.JPanel pnlAnoSemestre;
    private javax.swing.JPanel pnlDisciplina;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JPanel pnlProfessor;
    private javax.swing.JSpinner spnAno;
    private javax.swing.JSpinner spnPeriodo;
    private javax.swing.JSpinner spnSemestre;
    private javax.swing.JTable tblAlocacao;
    // End of variables declaration//GEN-END:variables
}

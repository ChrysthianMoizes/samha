package cih.turma;

import cci.CtrlMensagem;
import cci.CtrlPrincipal;
import cci.JTableUtil;
import cdp.Curso;
import cdp.Turma;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JSpinner;

public class JDBuscarTurma extends javax.swing.JDialog {

    private CtrlPrincipal ctrlPrincipal;
    private List<Turma> listaTurmas;
    private List<Curso> listaCursos;
    private Frame pai;
    
    public JDBuscarTurma(java.awt.Frame parent, boolean modal, CtrlPrincipal ctrl) {
        super(parent, modal);
        initComponents();
        this.pai = parent;
        this.ctrlPrincipal = ctrl;
        setarBackground();
        alterarLarguraTabela();
    }
    
    public void alterarLarguraTabela(){
        tblTurma.getColumnModel().getColumn(0).setPreferredWidth(10);
        tblTurma.getColumnModel().getColumn(1).setPreferredWidth(10);
        tblTurma.getColumnModel().getColumn(2).setPreferredWidth(10);
        tblTurma.getColumnModel().getColumn(3).setPreferredWidth(170);
        tblTurma.getColumnModel().getColumn(4).setPreferredWidth(20);
    }
    
    private void setarBackground(){
        pnlGeral.setBackground(ctrlPrincipal.setarCorPanelExterior());
        pnlBuscarTurma.setBackground(ctrlPrincipal.setarCorPanelInterior());
        pnlRodape.setBackground(ctrlPrincipal.setarCorPanelInterior());
    }
    
    public void atualizarTabela(){
        
        lblMensagem.setText("");
        
        String colunaFiltro = cbxFiltro.getSelectedItem().toString().toLowerCase();
        String filtro = txtFiltro.getText();
        
        if(colunaFiltro.toLowerCase().equals("curso")){
            Curso curso = (Curso) cbxCurso.getSelectedItem();
            if(curso != null)
                filtro = String.valueOf(curso.getId());
            else
                CtrlMensagem.exibirMensagemAviso(pai, "Curso não selecionado");       
        }
        ctrlPrincipal.getCtrlTurma().listarTurmas(colunaFiltro, filtro, tblTurma, chxAtiva);
    }
    
    public void listarTurmasAtivas(){
        
        if(chxAtiva.isSelected()){
            spnAno.setEnabled(true);
            spnSemestre.setEnabled(true);
        }else{
            spnAno.setEnabled(false);
            spnSemestre.setEnabled(false);
        }
        atualizarTabela();
    }
    
    public void preencherComboCurso(){
        ctrlPrincipal.getCtrlTurma().preencherComboCurso(cbxCurso, null);
    }
    
    public void alterarComboFiltro(){
        
        JTableUtil.removerLinhas(tblTurma);
        lblMensagem.setText("");
        txtFiltro.setText("");
        
        if(cbxFiltro.getSelectedIndex() == 0){
            cbxCurso.removeAllItems();
            cbxCurso.setEnabled(false);
            txtFiltro.setEnabled(true);
            btnBuscar.setEnabled(true);
            
        }else{
            btnBuscar.setEnabled(false);
            cbxCurso.setEnabled(true);
            txtFiltro.setEnabled(false);
            preencherComboCurso();
            atualizarTabela();
        }
    }

    public List<Turma> getListaTurmas() {
        return listaTurmas;
    }

    public void setListaTurmas(List<Turma> listaTurmas) {
        this.listaTurmas = listaTurmas;
    }

    public List<Curso> getListaCursos() {
        return listaCursos;
    }

    public void setListaCursos(List<Curso> listaCursos) {
        this.listaCursos = listaCursos;
    }
    
    public void setarMensagem(String mensagem){
        lblMensagem.setText(mensagem);
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

        btnGroup = new javax.swing.ButtonGroup();
        pnlGeral = new javax.swing.JPanel();
        pnlRodape = new javax.swing.JPanel();
        btnAlterar = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        pnlBuscarTurma = new javax.swing.JPanel();
        jLabelFiltrar = new javax.swing.JLabel();
        cbxFiltro = new javax.swing.JComboBox<>();
        txtFiltro = new javax.swing.JTextField();
        jScrollPaneTurmas = new javax.swing.JScrollPane();
        tblTurma = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        cbxCurso = new javax.swing.JComboBox<>();
        lblMensagem = new javax.swing.JLabel();
        spnAno = new javax.swing.JSpinner();
        spnSemestre = new javax.swing.JSpinner();
        chxAtiva = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar Turma");
        setIconImage(null);
        setResizable(false);

        pnlGeral.setBackground(new java.awt.Color(0, 153, 102));

        pnlRodape.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnAlterar.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/edit.png"))); // NOI18N
        btnAlterar.setToolTipText("Alterar");
        btnAlterar.setBorder(null);
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });
        btnAlterar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnAlterarKeyPressed(evt);
            }
        });

        btnCadastrar.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        btnCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/plus.png"))); // NOI18N
        btnCadastrar.setToolTipText("Adicionar");
        btnCadastrar.setBorder(null);
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });
        btnCadastrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnCadastrarKeyPressed(evt);
            }
        });

        btnExcluir.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/trash.png"))); // NOI18N
        btnExcluir.setToolTipText("Excluir");
        btnExcluir.setBorder(null);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        btnExcluir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnExcluirKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout pnlRodapeLayout = new javax.swing.GroupLayout(pnlRodape);
        pnlRodape.setLayout(pnlRodapeLayout);
        pnlRodapeLayout.setHorizontalGroup(
            pnlRodapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRodapeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 421, Short.MAX_VALUE)
                .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlRodapeLayout.setVerticalGroup(
            pnlRodapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRodapeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRodapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRodapeLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnlBuscarTurma.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 1, 14))); // NOI18N

        jLabelFiltrar.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabelFiltrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/filter.png"))); // NOI18N
        jLabelFiltrar.setToolTipText("Filtrar");

        cbxFiltro.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        cbxFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nome", "Curso" }));
        cbxFiltro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxFiltroItemStateChanged(evt);
            }
        });

        txtFiltro.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        txtFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFiltroKeyPressed(evt);
            }
        });

        jScrollPaneTurmas.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N

        tblTurma.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        tblTurma.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Ano de Criação", "Matriz Curricular", "Curso", "Turno"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTurma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTurmaMouseClicked(evt);
            }
        });
        jScrollPaneTurmas.setViewportView(tblTurma);

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/icone-pesquisar-reduzido.png"))); // NOI18N
        btnBuscar.setToolTipText("Filtrar");
        btnBuscar.setBorder(null);
        btnBuscar.setPreferredSize(new java.awt.Dimension(49, 25));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        btnBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnBuscarKeyPressed(evt);
            }
        });

        cbxCurso.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        cbxCurso.setEnabled(false);
        cbxCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCursoActionPerformed(evt);
            }
        });

        lblMensagem.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        lblMensagem.setForeground(new java.awt.Color(229, 0, 0));

        spnAno.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        spnAno.setModel(new javax.swing.SpinnerNumberModel(2018, 2000, null, 1));
        spnAno.setEnabled(false);
        spnAno.setEditor(new JSpinner.NumberEditor(spnAno, "####"));
        spnAno.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnAnoStateChanged(evt);
            }
        });

        spnSemestre.setFont(new java.awt.Font("DialogInput", 0, 16)); // NOI18N
        spnSemestre.setModel(new javax.swing.SpinnerNumberModel(1, 1, 2, 1));
        spnSemestre.setEnabled(false);
        spnSemestre.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnSemestreStateChanged(evt);
            }
        });

        chxAtiva.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        chxAtiva.setText("Ativas");
        chxAtiva.setToolTipText("Exibir somente turmas ativas");
        chxAtiva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chxAtivaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBuscarTurmaLayout = new javax.swing.GroupLayout(pnlBuscarTurma);
        pnlBuscarTurma.setLayout(pnlBuscarTurmaLayout);
        pnlBuscarTurmaLayout.setHorizontalGroup(
            pnlBuscarTurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBuscarTurmaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBuscarTurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBuscarTurmaLayout.createSequentialGroup()
                        .addComponent(jLabelFiltrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlBuscarTurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlBuscarTurmaLayout.createSequentialGroup()
                                .addComponent(cbxCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(chxAtiva)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(spnAno, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtFiltro))
                        .addGap(21, 21, 21)
                        .addGroup(pnlBuscarTurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(spnSemestre)))
                    .addGroup(pnlBuscarTurmaLayout.createSequentialGroup()
                        .addGroup(pnlBuscarTurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPaneTurmas, javax.swing.GroupLayout.PREFERRED_SIZE, 723, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlBuscarTurmaLayout.setVerticalGroup(
            pnlBuscarTurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBuscarTurmaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlBuscarTurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFiltro)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlBuscarTurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(spnAno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlBuscarTurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbxCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(chxAtiva, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPaneTurmas, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout pnlGeralLayout = new javax.swing.GroupLayout(pnlGeral);
        pnlGeral.setLayout(pnlGeralLayout);
        pnlGeralLayout.setHorizontalGroup(
            pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGeralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlBuscarTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlRodape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlGeralLayout.setVerticalGroup(
            pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGeralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlBuscarTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlRodape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlGeral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlGeral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtFiltroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            atualizarTabela();
        }
    }//GEN-LAST:event_txtFiltroKeyPressed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        atualizarTabela(); 
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnBuscarKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            atualizarTabela();
        }
    }//GEN-LAST:event_btnBuscarKeyPressed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        ctrlPrincipal.getCtrlTurma().transitarTelas(tblTurma, pai);
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnAlterarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAlterarKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            btnAlterarActionPerformed(null);
        }
    }//GEN-LAST:event_btnAlterarKeyPressed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        ctrlPrincipal.getCtrlTurma().instanciarTelaCadastroTurma(null, pai);       
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnCadastrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCadastrarKeyPressed
        btnCadastrarActionPerformed(null);
    }//GEN-LAST:event_btnCadastrarKeyPressed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        ctrlPrincipal.getCtrlTurma().excluir(tblTurma);
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnExcluirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnExcluirKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            btnExcluirActionPerformed(null);
        }
    }//GEN-LAST:event_btnExcluirKeyPressed

    private void cbxCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCursoActionPerformed
        atualizarTabela();
    }//GEN-LAST:event_cbxCursoActionPerformed

    private void cbxFiltroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxFiltroItemStateChanged
        alterarComboFiltro();
    }//GEN-LAST:event_cbxFiltroItemStateChanged

    private void spnSemestreStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnSemestreStateChanged
        atualizarTabela();
    }//GEN-LAST:event_spnSemestreStateChanged

    private void chxAtivaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chxAtivaActionPerformed
        listarTurmasAtivas();
    }//GEN-LAST:event_chxAtivaActionPerformed

    private void spnAnoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnAnoStateChanged
        atualizarTabela();
    }//GEN-LAST:event_spnAnoStateChanged

    private void tblTurmaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTurmaMouseClicked
        if(evt.getClickCount() == 2){
            ctrlPrincipal.getCtrlTurma().transitarTelas(tblTurma, pai);
        }
    }//GEN-LAST:event_tblTurmaMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.ButtonGroup btnGroup;
    private javax.swing.JComboBox<String> cbxCurso;
    private javax.swing.JComboBox<String> cbxFiltro;
    private javax.swing.JCheckBox chxAtiva;
    private javax.swing.JLabel jLabelFiltrar;
    private javax.swing.JScrollPane jScrollPaneTurmas;
    private javax.swing.JLabel lblMensagem;
    private javax.swing.JPanel pnlBuscarTurma;
    private javax.swing.JPanel pnlGeral;
    private javax.swing.JPanel pnlRodape;
    private javax.swing.JSpinner spnAno;
    private javax.swing.JSpinner spnSemestre;
    private javax.swing.JTable tblTurma;
    private javax.swing.JTextField txtFiltro;
    // End of variables declaration//GEN-END:variables
}

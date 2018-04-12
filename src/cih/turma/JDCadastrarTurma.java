package cih.turma;

import cci.CtrlPrincipal;
import cdp.Curso;
import cdp.Eixo;
import cdp.MatrizCurricular;
import cdp.Turma;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class JDCadastrarTurma extends javax.swing.JDialog {

    private CtrlPrincipal ctrlPrincipal;
    private Turma turma;
    private List<MatrizCurricular> listaMatriz;
    private List<Curso> listaCursos;

    public JDCadastrarTurma(java.awt.Frame parent, boolean modal, CtrlPrincipal ctrl, Turma turma) {
        super(parent, modal);
        initComponents();
        this.ctrlPrincipal = ctrl;
        this.turma = turma;
        ImageIcon icone = ctrlPrincipal.getCtrlTurma().setarIconeJanela();
        setIconImage(icone.getImage());
        identificarOrigem();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupPrioridade = new javax.swing.ButtonGroup();
        pnlGeral = new javax.swing.JPanel();
        pnlTurma = new javax.swing.JPanel();
        txtNomeTurma = new javax.swing.JTextField();
        lblNomeTurma = new javax.swing.JLabel();
        lblAno = new javax.swing.JLabel();
        spnAno = new javax.swing.JSpinner();
        spnSemestre = new javax.swing.JSpinner();
        lblNomeCurso3 = new javax.swing.JLabel();
        lblTturno = new javax.swing.JLabel();
        cbxCurso = new javax.swing.JComboBox<>();
        cbxMatriz = new javax.swing.JComboBox<>();
        cbxTurno = new javax.swing.JComboBox<>();
        lblCurso = new javax.swing.JLabel();
        lblMatriz = new javax.swing.JLabel();
        pnlRodape = new javax.swing.JPanel();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Turma");
        setResizable(false);

        pnlGeral.setBackground(new java.awt.Color(53, 151, 48));

        pnlTurma.setBackground(new java.awt.Color(0, 204, 102));
        pnlTurma.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Turma", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 1, 14))); // NOI18N

        txtNomeTurma.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N

        lblNomeTurma.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblNomeTurma.setText("Nome:");

        lblAno.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblAno.setText("Ano/Semestre:");

        spnAno.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        spnAno.setModel(new javax.swing.SpinnerNumberModel(2018, 2000, null, 1));

        spnSemestre.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        spnSemestre.setModel(new javax.swing.SpinnerNumberModel(1, 1, 2, 1));

        lblNomeCurso3.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblNomeCurso3.setText("/");

        lblTturno.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblTturno.setText("Turno:");

        cbxCurso.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        cbxCurso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cbxCurso.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxCursoItemStateChanged(evt);
            }
        });

        cbxMatriz.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        cbxMatriz.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cbxMatriz.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxMatrizItemStateChanged(evt);
            }
        });

        cbxTurno.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        cbxTurno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MATUTINO", "VESPERTINO", "NOTURNO" }));

        lblCurso.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblCurso.setText("Curso:");

        lblMatriz.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblMatriz.setText("Matriz Curricular:");

        javax.swing.GroupLayout pnlTurmaLayout = new javax.swing.GroupLayout(pnlTurma);
        pnlTurma.setLayout(pnlTurmaLayout);
        pnlTurmaLayout.setHorizontalGroup(
            pnlTurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTurmaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNomeTurma)
                    .addComponent(lblTturno)
                    .addComponent(lblCurso))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTurmaLayout.createSequentialGroup()
                        .addComponent(txtNomeTurma)
                        .addGap(18, 18, 18)
                        .addComponent(lblAno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(spnAno, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNomeCurso3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spnSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlTurmaLayout.createSequentialGroup()
                        .addComponent(cbxTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblMatriz)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxMatriz, 0, 126, Short.MAX_VALUE))
                    .addComponent(cbxCurso, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlTurmaLayout.setVerticalGroup(
            pnlTurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTurmaLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(pnlTurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomeTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomeTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNomeCurso3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnAno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlTurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlTurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMatriz, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxMatriz, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTturno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlRodape.setBackground(new java.awt.Color(0, 204, 102));
        pnlRodape.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnSalvar.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        btnSalvar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnSalvarKeyPressed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        btnCancelar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnCancelarKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout pnlRodapeLayout = new javax.swing.GroupLayout(pnlRodape);
        pnlRodape.setLayout(pnlRodapeLayout);
        pnlRodapeLayout.setHorizontalGroup(
            pnlRodapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRodapeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlRodapeLayout.setVerticalGroup(
            pnlRodapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRodapeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRodapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlGeralLayout = new javax.swing.GroupLayout(pnlGeral);
        pnlGeral.setLayout(pnlGeralLayout);
        pnlGeralLayout.setHorizontalGroup(
            pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGeralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlRodape, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlTurma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlGeralLayout.setVerticalGroup(
            pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGeralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    public void identificarOrigem() {
        preencherComboCurso();
        if (turma != null){ 
            setarCamposComInstancia();
        }
    }

    public void setarCamposComInstancia() {
        setarCurso();
        setarMatriz();
        setarTurno();
        txtNomeTurma.setText(turma.getNome());
        spnAno.setValue(turma.getAno());
        spnSemestre.setValue(turma.getSemestre());        
    }
    
    public void setarCurso(){
        
        Curso curso;

        for (int i = 0; i < listaCursos.size(); i++) {

            curso = listaCursos.get(i);
            if (curso.getId() == turma.getMatriz().getCurso().getId()) {
                cbxCurso.setSelectedIndex(i);
                preencherComboMatriz(curso.getId());
                break;
            }
        }
    }
    
    public void setarMatriz(){
        
        MatrizCurricular matriz;
        
        for (int i = 0; i < listaMatriz.size(); i++) {

            matriz = listaMatriz.get(i);
            if (matriz.getId() == turma.getMatriz().getId()) {
                cbxMatriz.setSelectedIndex(i);
                break;
            }
        }
    }
    
    public void setarTurno(){
        
        if(turma.getTurno().equals("MATUTINO")){
            cbxTurno.setSelectedIndex(0);
        }else if(turma.getTurno().equals("VESPERTINO")){
            cbxTurno.setSelectedIndex(1);
        }else{
            cbxTurno.setSelectedIndex(2);
        } 
    }
 
    public void preencherComboCurso(){ 
        listaCursos = ctrlPrincipal.getCtrlCurso().listar();
        cbxCurso.removeAllItems();
        cbxCurso.setModel(new DefaultComboBoxModel(listaCursos.toArray()));
        
        if(listaCursos.size() > 0){
            Curso curso = (Curso) cbxCurso.getSelectedItem();
            preencherComboMatriz(curso.getId());
        }  
    }
    
     public void preencherComboMatriz(int id) {
        listaMatriz = ctrlPrincipal.getCtrlMatriz().filtrarMatrizCurso(id);
        cbxMatriz.removeAllItems();
        cbxMatriz.setModel(new DefaultComboBoxModel(listaMatriz.toArray())); 
    }
    
    public void desabilitarCampos(){
        txtNomeTurma.setEnabled(false);
        cbxTurno.setEnabled(false);
        cbxCurso.setEnabled(false);
        cbxMatriz.setEnabled(false);
        spnAno.setEnabled(false);
        spnSemestre.setEnabled(false);
        btnSalvar.setEnabled(false);
        btnCancelar.setText("Sair");
    }

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        String nome = txtNomeTurma.getText();
        String turno = cbxTurno.getSelectedItem().toString();
        int ano = (int) spnAno.getValue();
        int semestre = (int) spnSemestre.getValue();
        MatrizCurricular matriz = (MatrizCurricular) cbxMatriz.getSelectedItem();
        
        int resposta = 0;
        
        if(turma == null){
            resposta = ctrlPrincipal.getCtrlTurma().cadastrar(nome, turno, ano, semestre, matriz);  
        }else{
            resposta = ctrlPrincipal.getCtrlTurma().alterar(nome, turno, ano, semestre, matriz, turma);
        }
        
        if (resposta == 0) {
            desabilitarCampos();
        }  
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnSalvarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSalvarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnSalvarActionPerformed(null);
        }
    }//GEN-LAST:event_btnSalvarKeyPressed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnCancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCancelarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.dispose();
        }
    }//GEN-LAST:event_btnCancelarKeyPressed

    private void cbxMatrizItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxMatrizItemStateChanged
        Eixo eixo = (Eixo) cbxMatriz.getSelectedItem();
        if(eixo != null)
            preencherComboMatriz(eixo.getId());
    }//GEN-LAST:event_cbxMatrizItemStateChanged

    private void cbxCursoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxCursoItemStateChanged
        Curso curso = (Curso) cbxCurso.getSelectedItem();
        if(curso != null)
            preencherComboMatriz(curso.getId());
    }//GEN-LAST:event_cbxCursoItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.ButtonGroup btnGroupPrioridade;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbxCurso;
    private javax.swing.JComboBox<String> cbxMatriz;
    private javax.swing.JComboBox<String> cbxTurno;
    private javax.swing.JLabel lblAno;
    private javax.swing.JLabel lblCurso;
    private javax.swing.JLabel lblMatriz;
    private javax.swing.JLabel lblNomeCurso3;
    private javax.swing.JLabel lblNomeTurma;
    private javax.swing.JLabel lblTturno;
    private javax.swing.JPanel pnlGeral;
    private javax.swing.JPanel pnlRodape;
    private javax.swing.JPanel pnlTurma;
    private javax.swing.JSpinner spnAno;
    private javax.swing.JSpinner spnSemestre;
    private javax.swing.JTextField txtNomeTurma;
    // End of variables declaration//GEN-END:variables
}

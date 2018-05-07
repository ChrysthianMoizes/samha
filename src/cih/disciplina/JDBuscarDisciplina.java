package cih.disciplina;

import cci.CtrlMensagem;
import cci.CtrlPrincipal;
import cci.JTableUtil;
import cdp.Curso;
import cdp.Disciplina;
import cdp.MatrizCurricular;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.util.List;

public class JDBuscarDisciplina extends javax.swing.JDialog {

    private CtrlPrincipal ctrlPrincipal;
    private List<Disciplina> listaDisciplinas;
    private Frame pai;
    
    public JDBuscarDisciplina(java.awt.Frame parent, boolean modal, CtrlPrincipal ctrl) {
        super(parent, modal);
        initComponents();
        this.pai = parent;
        this.ctrlPrincipal = ctrl;
        setarBackground();
        alterarLarguraTabela();
    }
    
    public void alterarLarguraTabela(){
        tblDisciplina.getColumnModel().getColumn(0).setPreferredWidth(270);
        tblDisciplina.getColumnModel().getColumn(1).setPreferredWidth(5);
        tblDisciplina.getColumnModel().getColumn(2).setPreferredWidth(30);  
    }
    
    private void setarBackground(){
        pnlGeral.setBackground(ctrlPrincipal.setarCorPanelExterior());
        pnlBuscarDisciplina.setBackground(ctrlPrincipal.setarCorPanelInterior());
        pnlRodape.setBackground(ctrlPrincipal.setarCorPanelInterior());
        rbtnObrigatoria.setBackground(ctrlPrincipal.setarCorPanelInterior());
        rbtnOptativa.setBackground(ctrlPrincipal.setarCorPanelInterior());
        rbtnEspecial.setBackground(ctrlPrincipal.setarCorPanelInterior());
    }
    
    public void atualizarTabela(){
        
        lblMensagem.setText("");
        
        String colunaFiltro = cbxFiltro.getSelectedItem().toString().toLowerCase();
        MatrizCurricular matriz = (MatrizCurricular) cbxMatriz.getSelectedItem();
        
        if(matriz == null){
            setarMensagem("Curso não possui matriz associada.");
            JTableUtil.limparTabela(tblDisciplina);
        }else{
        
            if(colunaFiltro.equals("curso")){
                ctrlPrincipal.getCtrlDisciplina().filtrarPorMatriz(colunaFiltro, matriz.getId(), tblDisciplina); 
            }else{

                char tipo = (char) btnGroup.getSelection().getMnemonic();
                String filtro = "";

                switch (tipo) {
                    case 'B':
                        filtro = "OBRIGATÓRIA";
                        break;
                    case 'P':
                        filtro = "OPTATIVA";
                        break;          
                    default:
                        filtro = "ESPECIAL";
                        break;
                }
                ctrlPrincipal.getCtrlDisciplina().filtrarPorTipo(filtro, matriz.getId(), tblDisciplina); 
            } 
        }  
    }
    
    public void preencherComboCurso(){
        ctrlPrincipal.getCtrlDisciplina().preencherComboCurso(cbxCurso, cbxMatriz);
    }
    
    public void alterarComboFiltro(){
        
        JTableUtil.limparTabela(tblDisciplina);
        lblMensagem.setText("");
   
        if(cbxFiltro.getSelectedIndex() == 0){
            
            cbxCurso.setEnabled(true);
            cbxMatriz.setEnabled(true);
            rbtnObrigatoria.setEnabled(false);
            rbtnOptativa.setEnabled(false);
            rbtnEspecial.setEnabled(false);
            atualizarTabela();
      
        }else{
            
            cbxCurso.setEnabled(false);
            cbxMatriz.setEnabled(false);
            rbtnObrigatoria.setEnabled(true);
            rbtnObrigatoria.setSelected(true);
            rbtnOptativa.setEnabled(true);
            rbtnEspecial.setEnabled(true);
            atualizarTabela();
        }
    }

    public List<Disciplina> getListaDisciplinas() {
        return listaDisciplinas;
    }

    public void setListaDisciplinas(List<Disciplina> listaDisciplinas) {
        this.listaDisciplinas = listaDisciplinas;
    }
    
    public void setarMensagem(String mensagem){
        lblMensagem.setText(mensagem);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroup = new javax.swing.ButtonGroup();
        pnlGeral = new javax.swing.JPanel();
        pnlRodape = new javax.swing.JPanel();
        btnAlterar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        pnlBuscarDisciplina = new javax.swing.JPanel();
        jLabelFiltrar = new javax.swing.JLabel();
        cbxFiltro = new javax.swing.JComboBox<>();
        jScrollPaneDisciplinas = new javax.swing.JScrollPane();
        tblDisciplina = new javax.swing.JTable();
        rbtnEspecial = new javax.swing.JRadioButton();
        rbtnObrigatoria = new javax.swing.JRadioButton();
        rbtnOptativa = new javax.swing.JRadioButton();
        cbxCurso = new javax.swing.JComboBox<>();
        cbxMatriz = new javax.swing.JComboBox<>();
        lblMensagem = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar Disciplina");
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

        btnCancelar.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/close.png"))); // NOI18N
        btnCancelar.setToolTipText("Cancelar");
        btnCancelar.setBorder(null);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlRodapeLayout.setVerticalGroup(
            pnlRodapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRodapeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRodapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRodapeLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlRodapeLayout.createSequentialGroup()
                        .addGroup(pnlRodapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnAlterar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnExcluir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pnlBuscarDisciplina.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 1, 14))); // NOI18N

        jLabelFiltrar.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabelFiltrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/filter.png"))); // NOI18N
        jLabelFiltrar.setToolTipText("Filtrar");

        cbxFiltro.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        cbxFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Curso", "Tipo" }));
        cbxFiltro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxFiltroItemStateChanged(evt);
            }
        });

        jScrollPaneDisciplinas.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N

        tblDisciplina.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        tblDisciplina.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Período", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPaneDisciplinas.setViewportView(tblDisciplina);

        btnGroup.add(rbtnEspecial);
        rbtnEspecial.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        rbtnEspecial.setMnemonic('e');
        rbtnEspecial.setText("Especial");
        rbtnEspecial.setEnabled(false);
        rbtnEspecial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnEspecialActionPerformed(evt);
            }
        });

        btnGroup.add(rbtnObrigatoria);
        rbtnObrigatoria.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        rbtnObrigatoria.setMnemonic('b');
        rbtnObrigatoria.setSelected(true);
        rbtnObrigatoria.setText("Obrigatória");
        rbtnObrigatoria.setEnabled(false);
        rbtnObrigatoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnObrigatoriaActionPerformed(evt);
            }
        });

        btnGroup.add(rbtnOptativa);
        rbtnOptativa.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        rbtnOptativa.setMnemonic('p');
        rbtnOptativa.setText("Optativa");
        rbtnOptativa.setEnabled(false);
        rbtnOptativa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnOptativaActionPerformed(evt);
            }
        });

        cbxCurso.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        cbxCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCursoActionPerformed(evt);
            }
        });

        cbxMatriz.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        cbxMatriz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMatrizActionPerformed(evt);
            }
        });

        lblMensagem.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        lblMensagem.setForeground(new java.awt.Color(229, 0, 0));

        javax.swing.GroupLayout pnlBuscarDisciplinaLayout = new javax.swing.GroupLayout(pnlBuscarDisciplina);
        pnlBuscarDisciplina.setLayout(pnlBuscarDisciplinaLayout);
        pnlBuscarDisciplinaLayout.setHorizontalGroup(
            pnlBuscarDisciplinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBuscarDisciplinaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBuscarDisciplinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneDisciplinas, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlBuscarDisciplinaLayout.createSequentialGroup()
                        .addComponent(jLabelFiltrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addGroup(pnlBuscarDisciplinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlBuscarDisciplinaLayout.createSequentialGroup()
                                .addComponent(rbtnObrigatoria)
                                .addGap(18, 18, 18)
                                .addComponent(rbtnOptativa)
                                .addGap(18, 18, 18)
                                .addComponent(rbtnEspecial))
                            .addComponent(cbxCurso, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(cbxMatriz, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlBuscarDisciplinaLayout.setVerticalGroup(
            pnlBuscarDisciplinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBuscarDisciplinaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlBuscarDisciplinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBuscarDisciplinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbxCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbxMatriz, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlBuscarDisciplinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnEspecial)
                    .addComponent(rbtnOptativa)
                    .addComponent(rbtnObrigatoria))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPaneDisciplinas, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout pnlGeralLayout = new javax.swing.GroupLayout(pnlGeral);
        pnlGeral.setLayout(pnlGeralLayout);
        pnlGeralLayout.setHorizontalGroup(
            pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGeralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlBuscarDisciplina, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlRodape, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlGeralLayout.setVerticalGroup(
            pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGeralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlBuscarDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlRodape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlGeral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlGeral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        ctrlPrincipal.getCtrlDisciplina().transitarTelas(tblDisciplina, pai);
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnAlterarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAlterarKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            btnAlterarActionPerformed(null);
        }
    }//GEN-LAST:event_btnAlterarKeyPressed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnCancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCancelarKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            this.dispose();
        }
    }//GEN-LAST:event_btnCancelarKeyPressed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        ctrlPrincipal.getCtrlDisciplina().instanciarTelaCadastroDisciplina(null, pai);
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnCadastrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCadastrarKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            btnCadastrarActionPerformed(null);
        }
    }//GEN-LAST:event_btnCadastrarKeyPressed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        ctrlPrincipal.getCtrlDisciplina().excluir(tblDisciplina);
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnExcluirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnExcluirKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            btnExcluirActionPerformed(null);
        }
    }//GEN-LAST:event_btnExcluirKeyPressed

    private void cbxFiltroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxFiltroItemStateChanged
        alterarComboFiltro();       
    }//GEN-LAST:event_cbxFiltroItemStateChanged

    private void rbtnObrigatoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnObrigatoriaActionPerformed
        atualizarTabela();
    }//GEN-LAST:event_rbtnObrigatoriaActionPerformed

    private void rbtnOptativaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnOptativaActionPerformed
       atualizarTabela();
    }//GEN-LAST:event_rbtnOptativaActionPerformed

    private void rbtnEspecialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnEspecialActionPerformed
        atualizarTabela();
    }//GEN-LAST:event_rbtnEspecialActionPerformed

    private void cbxMatrizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMatrizActionPerformed
        atualizarTabela();
    }//GEN-LAST:event_cbxMatrizActionPerformed

    private void cbxCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCursoActionPerformed
       Curso curso = (Curso) cbxCurso.getSelectedItem();
        if(curso != null){
           ctrlPrincipal.getCtrlDisciplina().preencherComboMatriz(curso.getId(), cbxMatriz);
           atualizarTabela();
        }
    }//GEN-LAST:event_cbxCursoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.ButtonGroup btnGroup;
    private javax.swing.JComboBox<String> cbxCurso;
    private javax.swing.JComboBox<String> cbxFiltro;
    private javax.swing.JComboBox<String> cbxMatriz;
    private javax.swing.JLabel jLabelFiltrar;
    private javax.swing.JScrollPane jScrollPaneDisciplinas;
    private javax.swing.JLabel lblMensagem;
    private javax.swing.JPanel pnlBuscarDisciplina;
    private javax.swing.JPanel pnlGeral;
    private javax.swing.JPanel pnlRodape;
    private javax.swing.JRadioButton rbtnEspecial;
    private javax.swing.JRadioButton rbtnObrigatoria;
    private javax.swing.JRadioButton rbtnOptativa;
    private javax.swing.JTable tblDisciplina;
    // End of variables declaration//GEN-END:variables
}

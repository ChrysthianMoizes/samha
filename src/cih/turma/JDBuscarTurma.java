package cih.turma;

import cci.CtrlMensagem;
import cci.CtrlPrincipal;
import cci.JTableUtil;
import cdp.Curso;
import cdp.MatrizCurricular;
import cdp.Turma;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

public class JDBuscarTurma extends javax.swing.JDialog {

    private CtrlPrincipal ctrlPrincipal;
    private List<Turma> listaTurmas;
    private List<Curso> listaCursos;
    private List<MatrizCurricular> listaMatriz;
    private Frame pai;
    
    public JDBuscarTurma(java.awt.Frame parent, boolean modal, CtrlPrincipal ctrl) {
        super(parent, modal);
        initComponents();
        this.pai = parent;
        this.ctrlPrincipal = ctrl;
        setarBackground();
    }
    
    private void setarBackground(){
        pnlGeral.setBackground(ctrlPrincipal.setarCorPanelExterior());
        pnlBuscarTurma.setBackground(ctrlPrincipal.setarCorPanelInterior());
        pnlRodape.setBackground(ctrlPrincipal.setarCorPanelInterior());
    }
    
    public void atualizarTabela(){
        
        JTableUtil.limparTabela(tblTurma);
        if(listaTurmas != null){
            if(listaTurmas.size() > 0){
                listaTurmas.forEach((turma) -> {
                    JTableUtil.addLinha(tblTurma, turma.toArray() );
                });
            }
        }
    }
    
    public void preencherComboCurso(){
        
        if(listaCursos == null)
            listaCursos = ctrlPrincipal.getCtrlCurso().listar();
           
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
        pnlBuscarTurma = new javax.swing.JPanel();
        jLabelFiltrar = new javax.swing.JLabel();
        cbxFiltro = new javax.swing.JComboBox<>();
        txtFiltro = new javax.swing.JTextField();
        jScrollPaneTurmas = new javax.swing.JScrollPane();
        tblTurma = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        cbxCurso = new javax.swing.JComboBox<>();
        cbxMatriz = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar Turma");
        setIconImage(null);
        setResizable(false);

        pnlGeral.setBackground(new java.awt.Color(53, 151, 48));

        pnlRodape.setBackground(new java.awt.Color(0, 204, 102));
        pnlRodape.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnAlterar.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
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

        btnCadastrar.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        btnCadastrar.setText("Novo");
        btnCadastrar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
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
        btnExcluir.setText("Excluir");
        btnExcluir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        pnlBuscarTurma.setBackground(new java.awt.Color(0, 204, 102));
        pnlBuscarTurma.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 1, 14))); // NOI18N

        jLabelFiltrar.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabelFiltrar.setText("Filtrar por:");

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
                "Nome", "Matriz Curricular", "Curso", "Turno"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPaneTurmas.setViewportView(tblTurma);

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/icone-pesquisar-reduzido.png"))); // NOI18N
        btnBuscar.setToolTipText("Filtrar");
        btnBuscar.setBorder(null);
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
        cbxCurso.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxCursoItemStateChanged(evt);
            }
        });

        cbxMatriz.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        cbxMatriz.setEnabled(false);
        cbxMatriz.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxMatrizItemStateChanged(evt);
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
                        .addComponent(jScrollPaneTurmas, javax.swing.GroupLayout.PREFERRED_SIZE, 723, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlBuscarTurmaLayout.createSequentialGroup()
                        .addComponent(jLabelFiltrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlBuscarTurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlBuscarTurmaLayout.createSequentialGroup()
                                .addComponent(cbxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtFiltro))
                            .addGroup(pnlBuscarTurmaLayout.createSequentialGroup()
                                .addComponent(cbxCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbxMatriz, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(11, 11, 11)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlBuscarTurmaLayout.setVerticalGroup(
            pnlBuscarTurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBuscarTurmaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlBuscarTurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtFiltro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBuscarTurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxMatriz, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPaneTurmas, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlGeralLayout = new javax.swing.GroupLayout(pnlGeral);
        pnlGeral.setLayout(pnlGeralLayout);
        pnlGeralLayout.setHorizontalGroup(
            pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGeralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlBuscarTurma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlRodape, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlGeralLayout.setVerticalGroup(
            pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGeralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlBuscarTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlRodape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            btnBuscarActionPerformed(null);
        }
    }//GEN-LAST:event_txtFiltroKeyPressed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        String colunaFiltro = cbxFiltro.getSelectedItem().toString().toLowerCase();
        String filtro = txtFiltro.getText();
        
        if(colunaFiltro.toLowerCase().equals("curso")){
            MatrizCurricular matriz = (MatrizCurricular) cbxMatriz.getSelectedItem();
            if(matriz != null){
                filtro = String.valueOf(matriz.getId());
                listaTurmas = ctrlPrincipal.getCtrlTurma().buscar(colunaFiltro, filtro);

            }else{
                CtrlMensagem.exibirMensagemAviso(pai, "Curso não possui matriz associada");
                listaTurmas = null;
            }    
        }else
            listaTurmas = ctrlPrincipal.getCtrlTurma().buscar(colunaFiltro, filtro);            
        
         atualizarTabela(); 
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnBuscarKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            btnBuscarActionPerformed(null);
        }
    }//GEN-LAST:event_btnBuscarKeyPressed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed

        try {
            Turma turma = (Turma) JTableUtil.getDadosLinhaSelecionada(tblTurma);
            ctrlPrincipal.getCtrlTurma().instanciarTelaCadastroTurma(turma, pai);
            btnBuscarActionPerformed(null);
        } catch (Exception ex) {
            CtrlMensagem.exibirMensagemErro(this, "Selecione uma turma");
        }
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
        ctrlPrincipal.getCtrlTurma().instanciarTelaCadastroTurma(null, pai);
        btnBuscarActionPerformed(null);
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnCadastrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCadastrarKeyPressed
        btnCadastrarActionPerformed(null);
    }//GEN-LAST:event_btnCadastrarKeyPressed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        
        try {
            Turma turma = (Turma) JTableUtil.getDadosLinhaSelecionada(tblTurma);
            int confirmacao = CtrlMensagem.exibirMensagemConfirmacao(this, "Confirmar Exclusão ?");
            if (confirmacao == 0) {
                ctrlPrincipal.getCtrlTurma().excluir(turma);
                btnBuscarActionPerformed(null);
            }
            
        } catch (Exception ex) {
            CtrlMensagem.exibirMensagemErro(this, "Selecione uma turma");
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnExcluirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnExcluirKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            btnExcluirActionPerformed(null);
        }
    }//GEN-LAST:event_btnExcluirKeyPressed

    private void cbxFiltroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxFiltroItemStateChanged
        JTableUtil.limparTabela(tblTurma);
        if(cbxFiltro.getSelectedIndex() == 0){
            
            cbxCurso.removeAllItems();
            cbxCurso.setEnabled(false);
            cbxMatriz.removeAllItems();
            cbxMatriz.setEnabled(false); 
            txtFiltro.setEnabled(true);
            
        }else if(cbxFiltro.getSelectedIndex() == 1){
            
            cbxCurso.setEnabled(true);
            cbxMatriz.setEnabled(true);
            preencherComboCurso();
            txtFiltro.setText("");
            txtFiltro.setEnabled(false);    
        }
    }//GEN-LAST:event_cbxFiltroItemStateChanged

    private void cbxCursoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxCursoItemStateChanged
        JTableUtil.limparTabela(tblTurma);    
        Curso curso = (Curso) cbxCurso.getSelectedItem();
            if(curso != null)
                preencherComboMatriz(curso.getId());
    }//GEN-LAST:event_cbxCursoItemStateChanged

    private void cbxMatrizItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxMatrizItemStateChanged
       JTableUtil.limparTabela(tblTurma); 
    }//GEN-LAST:event_cbxMatrizItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.ButtonGroup btnGroup;
    private javax.swing.JComboBox<String> cbxCurso;
    private javax.swing.JComboBox<String> cbxFiltro;
    private javax.swing.JComboBox<String> cbxMatriz;
    private javax.swing.JLabel jLabelFiltrar;
    private javax.swing.JScrollPane jScrollPaneTurmas;
    private javax.swing.JPanel pnlBuscarTurma;
    private javax.swing.JPanel pnlGeral;
    private javax.swing.JPanel pnlRodape;
    private javax.swing.JTable tblTurma;
    private javax.swing.JTextField txtFiltro;
    // End of variables declaration//GEN-END:variables
}

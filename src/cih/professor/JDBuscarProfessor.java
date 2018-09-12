package cih.professor;

import cci.CtrlPrincipal;
import cci.JTableUtil;
import cdp.Coordenadoria;
import cdp.Professor;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.util.List;

public class JDBuscarProfessor extends javax.swing.JDialog {

    private CtrlPrincipal ctrlPrincipal;
    private List<Professor> listaProfessores;
    private List<Coordenadoria> listaCoordenadorias;
    private Frame pai;
    
    public JDBuscarProfessor(java.awt.Frame parent, boolean modal, CtrlPrincipal ctrl) {
        super(parent, modal);
        initComponents();
        this.pai = parent;
        this.ctrlPrincipal = ctrl;
        setarBackground();
        alterarLarguraTabela();
    }
    
    public void alterarLarguraTabela(){
        tblProfessor.getColumnModel().getColumn(0).setPreferredWidth(200);
        tblProfessor.getColumnModel().getColumn(1).setPreferredWidth(10);
        tblProfessor.getColumnModel().getColumn(2).setPreferredWidth(150);  
    }
    
    private void setarBackground(){
        pnlGeral.setBackground(ctrlPrincipal.setarCorPanelExterior());
        pnlBuscarProfessor.setBackground(ctrlPrincipal.setarCorPanelInterior());
        pnlRodape.setBackground(ctrlPrincipal.setarCorPanelInterior());
    }
    
    public void preencherComboCoordenadorias(){
        ctrlPrincipal.getCtrlProfessor().preencherComboCoordenadorias(cbxCoordenadoria);
    }
    
    public void atualizarTabela(){
        
        lblMensagem.setText("");
        
        String colunaFiltro = cbxFiltro.getSelectedItem().toString().toLowerCase();
        String filtro = txtFiltro.getText();
        
        if(cbxFiltro.getSelectedIndex() == 2){
            Coordenadoria coordenadoria = (Coordenadoria) cbxCoordenadoria.getSelectedItem();
            filtro = String.valueOf(coordenadoria.getId());
        }
        
        ctrlPrincipal.getCtrlProfessor().listarProfessores(colunaFiltro, filtro, tblProfessor);        
    }
    
    private void alterarComboFiltro(){
        
        lblMensagem.setText("");
        txtFiltro.setText("");

        if(cbxFiltro.getSelectedIndex() == 2){
            cbxCoordenadoria.setEnabled(true);
            txtFiltro.setEnabled(false);
            btnBuscar.setEnabled(false);
            preencherComboCoordenadorias();
            atualizarTabela();
            
        }else{
            cbxCoordenadoria.removeAllItems();
            cbxCoordenadoria.setEnabled(false);
            txtFiltro.setEnabled(true);
            btnBuscar.setEnabled(true);
        }
    }

    public List<Professor> getListaProfessores() {
        return listaProfessores;
    }

    public void setListaProfessores(List<Professor> listaProfessores) {
        this.listaProfessores = listaProfessores;
    }

    public List<Coordenadoria> getListaCoordenadorias() {
        return listaCoordenadorias;
    }

    public void setListaCoordenadorias(List<Coordenadoria> listaCoordenadorias) {
        this.listaCoordenadorias = listaCoordenadorias;
    }
    
    public void setarMensagem(String mensagem){
        lblMensagem.setText(mensagem);
    }
       
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popUpMenu = new javax.swing.JPopupMenu();
        menuItemRemoverRestricoes = new javax.swing.JMenuItem();
        pnlGeral = new javax.swing.JPanel();
        pnlRodape = new javax.swing.JPanel();
        btnAlterar = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        pnlBuscarProfessor = new javax.swing.JPanel();
        lblFiltrar = new javax.swing.JLabel();
        cbxFiltro = new javax.swing.JComboBox<>();
        txtFiltro = new javax.swing.JTextField();
        jScrollPaneProfessores = new javax.swing.JScrollPane();
        tblProfessor = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        cbxCoordenadoria = new javax.swing.JComboBox<>();
        lblMensagem = new javax.swing.JLabel();
        btnMenu = new javax.swing.JButton();

        menuItemRemoverRestricoes.setText("Remover Restrições dos Professores");
        menuItemRemoverRestricoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemRemoverRestricoesActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar Professor");
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRodapeLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlRodapeLayout.createSequentialGroup()
                        .addGroup(pnlRodapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnAlterar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnExcluir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pnlBuscarProfessor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 1, 14))); // NOI18N

        lblFiltrar.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblFiltrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/filter.png"))); // NOI18N
        lblFiltrar.setToolTipText("Filtrar");

        cbxFiltro.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        cbxFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nome", "Matricula", "Coordenadoria" }));
        cbxFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxFiltroActionPerformed(evt);
            }
        });

        txtFiltro.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        txtFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFiltroKeyPressed(evt);
            }
        });

        jScrollPaneProfessores.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N

        tblProfessor.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        tblProfessor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Matrícula", "Coordenadoria"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProfessor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProfessorMouseClicked(evt);
            }
        });
        jScrollPaneProfessores.setViewportView(tblProfessor);

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/icone-pesquisar-reduzido.png"))); // NOI18N
        btnBuscar.setToolTipText("Filtrar");
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

        cbxCoordenadoria.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        cbxCoordenadoria.setEnabled(false);
        cbxCoordenadoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCoordenadoriaActionPerformed(evt);
            }
        });

        lblMensagem.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        lblMensagem.setForeground(new java.awt.Color(229, 0, 0));

        btnMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/menu.png"))); // NOI18N
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBuscarProfessorLayout = new javax.swing.GroupLayout(pnlBuscarProfessor);
        pnlBuscarProfessor.setLayout(pnlBuscarProfessorLayout);
        pnlBuscarProfessorLayout.setHorizontalGroup(
            pnlBuscarProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBuscarProfessorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBuscarProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneProfessores, javax.swing.GroupLayout.PREFERRED_SIZE, 723, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlBuscarProfessorLayout.createSequentialGroup()
                        .addGroup(pnlBuscarProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlBuscarProfessorLayout.createSequentialGroup()
                                .addComponent(lblFiltrar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlBuscarProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbxCoordenadoria, 0, 504, Short.MAX_VALUE)
                            .addComponent(txtFiltro))
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlBuscarProfessorLayout.setVerticalGroup(
            pnlBuscarProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBuscarProfessorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlBuscarProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(cbxFiltro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(txtFiltro)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlBuscarProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbxCoordenadoria, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(btnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(13, 13, 13)
                .addComponent(jScrollPaneProfessores, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(pnlBuscarProfessor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlRodape, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlGeralLayout.setVerticalGroup(
            pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGeralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlBuscarProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        ctrlPrincipal.getCtrlProfessor().transitarTelas(tblProfessor, pai);
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnAlterarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAlterarKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            btnAlterarActionPerformed(null);
        }
    }//GEN-LAST:event_btnAlterarKeyPressed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        ctrlPrincipal.getCtrlProfessor().instanciarTelaCadastroProfessor(null, pai);
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnCadastrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCadastrarKeyPressed
        btnCadastrarActionPerformed(null);
    }//GEN-LAST:event_btnCadastrarKeyPressed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        setarMensagem("");
        ctrlPrincipal.getCtrlProfessor().excluir(tblProfessor);    
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnExcluirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnExcluirKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            btnExcluirActionPerformed(null);
        }
    }//GEN-LAST:event_btnExcluirKeyPressed

    private void cbxCoordenadoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCoordenadoriaActionPerformed
        atualizarTabela();
    }//GEN-LAST:event_cbxCoordenadoriaActionPerformed

    private void cbxFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxFiltroActionPerformed
        JTableUtil.removerLinhas(tblProfessor);
        alterarComboFiltro();
    }//GEN-LAST:event_cbxFiltroActionPerformed

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        popUpMenu.add(menuItemRemoverRestricoes);
        popUpMenu.show(btnMenu, lblFiltrar.getX(), lblFiltrar.getY());
    }//GEN-LAST:event_btnMenuActionPerformed

    private void menuItemRemoverRestricoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemRemoverRestricoesActionPerformed
        ctrlPrincipal.getCtrlProfessor().removerTodasRestricoesProfessores();
    }//GEN-LAST:event_menuItemRemoverRestricoesActionPerformed

    private void tblProfessorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProfessorMouseClicked
        if(evt.getClickCount() == 2){
            ctrlPrincipal.getCtrlProfessor().transitarTelas(tblProfessor, pai);
        }
    }//GEN-LAST:event_tblProfessorMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnMenu;
    private javax.swing.JComboBox<String> cbxCoordenadoria;
    private javax.swing.JComboBox<String> cbxFiltro;
    private javax.swing.JScrollPane jScrollPaneProfessores;
    private javax.swing.JLabel lblFiltrar;
    private javax.swing.JLabel lblMensagem;
    private javax.swing.JMenuItem menuItemRemoverRestricoes;
    private javax.swing.JPanel pnlBuscarProfessor;
    private javax.swing.JPanel pnlGeral;
    private javax.swing.JPanel pnlRodape;
    private javax.swing.JPopupMenu popUpMenu;
    private javax.swing.JTable tblProfessor;
    private javax.swing.JTextField txtFiltro;
    // End of variables declaration//GEN-END:variables
}

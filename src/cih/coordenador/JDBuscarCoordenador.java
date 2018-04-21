package cih.coordenador;

import cci.CtrlPrincipal;
import cci.JTableUtil;
import cdp.CoordenadorCurso;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.util.List;

public class JDBuscarCoordenador extends javax.swing.JDialog {

    private CtrlPrincipal ctrlPrincipal;
    private Frame pai;
    
    public JDBuscarCoordenador(java.awt.Frame parent, boolean modal, CtrlPrincipal ctrl) {
        super(parent, modal);
        initComponents();
        this.pai = parent;
        this.ctrlPrincipal = ctrl;
        setarBackground();
    }
    
    private void setarBackground(){
        pnlGeral.setBackground(ctrlPrincipal.setarCorPanelExterior());
        pnlBuscarCoordenador.setBackground(ctrlPrincipal.setarCorPanelInterior());
        pnlRodape.setBackground(ctrlPrincipal.setarCorPanelInterior());
        rdbCoordenadorAcademico.setBackground(ctrlPrincipal.setarCorPanelInterior());
        rdbCoordenadorCurso.setBackground(ctrlPrincipal.setarCorPanelInterior());
        rdbCoordenadorPedagogico.setBackground(ctrlPrincipal.setarCorPanelInterior());
    }
    
    public void alterarComboFiltro(){
        
        if(cbxFiltro.getSelectedIndex() == 2){
            rdbCoordenadorAcademico.setSelected(true);
            rdbCoordenadorAcademico.setEnabled(true);
            rdbCoordenadorCurso.setEnabled(true);
            rdbCoordenadorPedagogico.setEnabled(true);
            txtFiltro.setText("");
            txtFiltro.setEnabled(false);
            btnBuscar.setEnabled(false);
        }else{
            rdbCoordenadorAcademico.setEnabled(false);
            rdbCoordenadorCurso.setEnabled(false);
            rdbCoordenadorPedagogico.setEnabled(false);
            txtFiltro.setEnabled(true);
            btnBuscar.setEnabled(true);
        }     
    }
    
    public void atualizarTabela(){
        String colunaFiltro = cbxFiltro.getSelectedItem().toString().toLowerCase();
        String filtro = txtFiltro.getText();
        
        if(colunaFiltro.toLowerCase().equals("tipo")){
            
            char tipo = (char) btnGroup.getSelection().getMnemonic();
            
            switch (tipo) {
                case 'A':
                    filtro = "COORDENADOR ACADÊMICO";
                    break;
                case 'C':
                    filtro = "COORDENADOR DE CURSO";
                    break;
                default:
                    filtro = "COORDENADOR PEDAGÓGICO";
                    break;
            }  
        }
        ctrlPrincipal.getCtrlCoordenador().listarCoordenadores(colunaFiltro, filtro, tblCoordenador);
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
        pnlBuscarCoordenador = new javax.swing.JPanel();
        jLabelFiltrar = new javax.swing.JLabel();
        cbxFiltro = new javax.swing.JComboBox<>();
        txtFiltro = new javax.swing.JTextField();
        jScrollPaneCoordenadores = new javax.swing.JScrollPane();
        tblCoordenador = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        rdbCoordenadorAcademico = new javax.swing.JRadioButton();
        rdbCoordenadorCurso = new javax.swing.JRadioButton();
        rdbCoordenadorPedagogico = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar Coordenador");
        setIconImage(null);
        setResizable(false);

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
                .addGap(6, 6, 6))
        );

        pnlBuscarCoordenador.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 0, 14))); // NOI18N

        jLabelFiltrar.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabelFiltrar.setText("Filtrar por:");

        cbxFiltro.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        cbxFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nome", "Matricula", "Tipo" }));
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

        tblCoordenador.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblCoordenador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Matrícula", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPaneCoordenadores.setViewportView(tblCoordenador);

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

        btnGroup.add(rdbCoordenadorAcademico);
        rdbCoordenadorAcademico.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        rdbCoordenadorAcademico.setMnemonic('a');
        rdbCoordenadorAcademico.setSelected(true);
        rdbCoordenadorAcademico.setText("COORDENADOR ACADÊMICO");
        rdbCoordenadorAcademico.setEnabled(false);
        rdbCoordenadorAcademico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbCoordenadorAcademicoActionPerformed(evt);
            }
        });

        btnGroup.add(rdbCoordenadorCurso);
        rdbCoordenadorCurso.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        rdbCoordenadorCurso.setMnemonic('c');
        rdbCoordenadorCurso.setText("COORDENADOR DE CURSO");
        rdbCoordenadorCurso.setEnabled(false);
        rdbCoordenadorCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbCoordenadorCursoActionPerformed(evt);
            }
        });

        btnGroup.add(rdbCoordenadorPedagogico);
        rdbCoordenadorPedagogico.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        rdbCoordenadorPedagogico.setMnemonic('p');
        rdbCoordenadorPedagogico.setText("COORDENADOR PEDAGÓGICO");
        rdbCoordenadorPedagogico.setEnabled(false);
        rdbCoordenadorPedagogico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbCoordenadorPedagogicoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBuscarCoordenadorLayout = new javax.swing.GroupLayout(pnlBuscarCoordenador);
        pnlBuscarCoordenador.setLayout(pnlBuscarCoordenadorLayout);
        pnlBuscarCoordenadorLayout.setHorizontalGroup(
            pnlBuscarCoordenadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBuscarCoordenadorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBuscarCoordenadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPaneCoordenadores, javax.swing.GroupLayout.PREFERRED_SIZE, 721, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlBuscarCoordenadorLayout.createSequentialGroup()
                        .addComponent(jLabelFiltrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlBuscarCoordenadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlBuscarCoordenadorLayout.createSequentialGroup()
                                .addComponent(rdbCoordenadorAcademico)
                                .addGap(18, 18, 18)
                                .addComponent(rdbCoordenadorCurso)
                                .addGap(18, 18, 18)
                                .addComponent(rdbCoordenadorPedagogico))
                            .addGroup(pnlBuscarCoordenadorLayout.createSequentialGroup()
                                .addComponent(cbxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlBuscarCoordenadorLayout.setVerticalGroup(
            pnlBuscarCoordenadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBuscarCoordenadorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBuscarCoordenadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFiltro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlBuscarCoordenadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbCoordenadorAcademico)
                    .addComponent(rdbCoordenadorCurso)
                    .addComponent(rdbCoordenadorPedagogico))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPaneCoordenadores, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlGeralLayout = new javax.swing.GroupLayout(pnlGeral);
        pnlGeral.setLayout(pnlGeralLayout);
        pnlGeralLayout.setHorizontalGroup(
            pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGeralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlBuscarCoordenador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlRodape, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlGeralLayout.setVerticalGroup(
            pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGeralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlBuscarCoordenador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlRodape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlGeral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
        ctrlPrincipal.getCtrlCoordenador().transitarTelas(tblCoordenador, pai);
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
        ctrlPrincipal.getCtrlCoordenador().instanciarTelaCadastroCoordenador(pai, null);
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnCadastrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCadastrarKeyPressed
        btnCadastrarActionPerformed(null);
    }//GEN-LAST:event_btnCadastrarKeyPressed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        ctrlPrincipal.getCtrlCoordenador().excluir(tblCoordenador);
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnExcluirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnExcluirKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            btnExcluirActionPerformed(null);
        }
    }//GEN-LAST:event_btnExcluirKeyPressed

    private void cbxFiltroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxFiltroItemStateChanged
        JTableUtil.limparTabela(tblCoordenador);
        alterarComboFiltro();
    }//GEN-LAST:event_cbxFiltroItemStateChanged

    private void rdbCoordenadorAcademicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbCoordenadorAcademicoActionPerformed
        atualizarTabela();
    }//GEN-LAST:event_rdbCoordenadorAcademicoActionPerformed

    private void rdbCoordenadorCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbCoordenadorCursoActionPerformed
        atualizarTabela();
    }//GEN-LAST:event_rdbCoordenadorCursoActionPerformed

    private void rdbCoordenadorPedagogicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbCoordenadorPedagogicoActionPerformed
        atualizarTabela();
    }//GEN-LAST:event_rdbCoordenadorPedagogicoActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.ButtonGroup btnGroup;
    private javax.swing.JComboBox<String> cbxFiltro;
    private javax.swing.JLabel jLabelFiltrar;
    private javax.swing.JScrollPane jScrollPaneCoordenadores;
    private javax.swing.JPanel pnlBuscarCoordenador;
    private javax.swing.JPanel pnlGeral;
    private javax.swing.JPanel pnlRodape;
    private javax.swing.JRadioButton rdbCoordenadorAcademico;
    private javax.swing.JRadioButton rdbCoordenadorCurso;
    private javax.swing.JRadioButton rdbCoordenadorPedagogico;
    private javax.swing.JTable tblCoordenador;
    private javax.swing.JTextField txtFiltro;
    // End of variables declaration//GEN-END:variables
}

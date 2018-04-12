package cih.curso;

import cci.CtrlMensagem;
import cci.CtrlPrincipal;
import cci.JTableUtil;
import cdp.Curso;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.ImageIcon;

public class JDBuscarCurso extends javax.swing.JDialog {

    private CtrlPrincipal ctrlPrincipal;
    private List<Curso> listaCursos;
    private Frame pai;
    
    public JDBuscarCurso(java.awt.Frame parent, boolean modal, CtrlPrincipal ctrl) {
        super(parent, modal);
        initComponents();
        this.pai = parent;
        this.ctrlPrincipal = ctrl;
        ImageIcon icone = ctrlPrincipal.getCtrlCurso().setarIconeJanela();
        setIconImage(icone.getImage());
        btnBuscarActionPerformed(null);
    }
    
    public void atualizarTabela(){
        
        JTableUtil.limparTabela(tblCurso);
        
        if(listaCursos.size() > 0){
            listaCursos.forEach((curso) -> {
                JTableUtil.addLinha(tblCurso, curso.toArray() );
            });
        }
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
        pnlBuscarCurso = new javax.swing.JPanel();
        jLabelFiltrar = new javax.swing.JLabel();
        cbxFiltro = new javax.swing.JComboBox<>();
        txtFiltro = new javax.swing.JTextField();
        jScrollPaneProfessores = new javax.swing.JScrollPane();
        tblCurso = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        rbtnPosGraduacao = new javax.swing.JRadioButton();
        rbtnEnsinoMedio = new javax.swing.JRadioButton();
        rbtnGraduacao = new javax.swing.JRadioButton();
        rbtnMestrado = new javax.swing.JRadioButton();
        rbtnDoutorado = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar Curso");
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

        pnlBuscarCurso.setBackground(new java.awt.Color(0, 204, 102));
        pnlBuscarCurso.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 1, 14))); // NOI18N

        jLabelFiltrar.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabelFiltrar.setText("Filtrar por:");

        cbxFiltro.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        cbxFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nome", "Nivel" }));
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

        jScrollPaneProfessores.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N

        tblCurso.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        tblCurso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Nível"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPaneProfessores.setViewportView(tblCurso);

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

        rbtnPosGraduacao.setBackground(new java.awt.Color(0, 204, 102));
        btnGroup.add(rbtnPosGraduacao);
        rbtnPosGraduacao.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        rbtnPosGraduacao.setMnemonic('p');
        rbtnPosGraduacao.setText("Pós-Graduação");
        rbtnPosGraduacao.setEnabled(false);

        rbtnEnsinoMedio.setBackground(new java.awt.Color(0, 204, 102));
        btnGroup.add(rbtnEnsinoMedio);
        rbtnEnsinoMedio.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        rbtnEnsinoMedio.setMnemonic('e');
        rbtnEnsinoMedio.setSelected(true);
        rbtnEnsinoMedio.setText("Ensino Médio");
        rbtnEnsinoMedio.setEnabled(false);

        rbtnGraduacao.setBackground(new java.awt.Color(0, 204, 102));
        btnGroup.add(rbtnGraduacao);
        rbtnGraduacao.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        rbtnGraduacao.setMnemonic('g');
        rbtnGraduacao.setText("Graduação");
        rbtnGraduacao.setEnabled(false);

        rbtnMestrado.setBackground(new java.awt.Color(0, 204, 102));
        btnGroup.add(rbtnMestrado);
        rbtnMestrado.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        rbtnMestrado.setMnemonic('m');
        rbtnMestrado.setText("Mestrado");
        rbtnMestrado.setEnabled(false);

        rbtnDoutorado.setBackground(new java.awt.Color(0, 204, 102));
        btnGroup.add(rbtnDoutorado);
        rbtnDoutorado.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        rbtnDoutorado.setMnemonic('d');
        rbtnDoutorado.setText("Doutorado");
        rbtnDoutorado.setEnabled(false);

        javax.swing.GroupLayout pnlBuscarCursoLayout = new javax.swing.GroupLayout(pnlBuscarCurso);
        pnlBuscarCurso.setLayout(pnlBuscarCursoLayout);
        pnlBuscarCursoLayout.setHorizontalGroup(
            pnlBuscarCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBuscarCursoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBuscarCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneProfessores, javax.swing.GroupLayout.PREFERRED_SIZE, 723, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlBuscarCursoLayout.createSequentialGroup()
                        .addComponent(jLabelFiltrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlBuscarCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlBuscarCursoLayout.createSequentialGroup()
                                .addComponent(rbtnEnsinoMedio)
                                .addGap(18, 18, 18)
                                .addComponent(rbtnGraduacao)
                                .addGap(18, 18, 18)
                                .addComponent(rbtnPosGraduacao)
                                .addGap(18, 18, 18)
                                .addComponent(rbtnMestrado)
                                .addGap(18, 18, 18)
                                .addComponent(rbtnDoutorado)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(pnlBuscarCursoLayout.createSequentialGroup()
                                .addComponent(cbxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtFiltro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        pnlBuscarCursoLayout.setVerticalGroup(
            pnlBuscarCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBuscarCursoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlBuscarCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtFiltro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlBuscarCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnPosGraduacao)
                    .addComponent(rbtnGraduacao)
                    .addComponent(rbtnEnsinoMedio)
                    .addComponent(rbtnMestrado)
                    .addComponent(rbtnDoutorado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPaneProfessores, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlGeralLayout = new javax.swing.GroupLayout(pnlGeral);
        pnlGeral.setLayout(pnlGeralLayout);
        pnlGeralLayout.setHorizontalGroup(
            pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGeralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlBuscarCurso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlRodape, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlGeralLayout.setVerticalGroup(
            pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGeralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlBuscarCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        
        if(colunaFiltro.toLowerCase().equals("nivel")){
            
            char tipo = (char) btnGroup.getSelection().getMnemonic();
            
            switch (tipo) {
                case 'E':
                    filtro = "ENSINO MÉDIO INTEGRADO";
                    break;
                case 'G':
                    filtro = "GRADUAÇÃO";
                    break;
                case 'P':
                    filtro = "PÓS-GRADUAÇÃO";
                    break;
                    
                case 'M':
                    filtro = "MESTRADO";
                    break;
                    
                default:
                    filtro = "DOUTORADO";
                    break;
            }  
        } 

        listaCursos = ctrlPrincipal.getCtrlCurso().buscar(colunaFiltro, filtro);
        atualizarTabela();
        
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnBuscarKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            btnBuscarActionPerformed(null);
        }
    }//GEN-LAST:event_btnBuscarKeyPressed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed

        try {
            Curso curso = (Curso) JTableUtil.getDadosLinhaSelecionada(tblCurso);
            ctrlPrincipal.getCtrlCurso().instanciarTelaCadastroCurso(curso, pai);
            btnBuscarActionPerformed(null);
        } catch (Exception ex) {
            CtrlMensagem.exibirMensagemErro(this, "Selecione um curso");
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
        ctrlPrincipal.getCtrlCurso().instanciarTelaCadastroCurso(null, pai);
        btnBuscarActionPerformed(null);
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnCadastrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCadastrarKeyPressed
        btnCadastrarActionPerformed(null);
    }//GEN-LAST:event_btnCadastrarKeyPressed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        
        try {
            Curso curso = (Curso) JTableUtil.getDadosLinhaSelecionada(tblCurso);
            int confirmacao = CtrlMensagem.exibirMensagemConfirmacao(this, "Confirmar Exclusão ?");
            if (confirmacao == 0) {
                ctrlPrincipal.getCtrlCurso().excluir(curso);
                btnBuscarActionPerformed(null);
            }
            
        } catch (Exception ex) {
            CtrlMensagem.exibirMensagemErro(this, "Selecione um curso");
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnExcluirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnExcluirKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            btnExcluirActionPerformed(null);
        }
    }//GEN-LAST:event_btnExcluirKeyPressed

    private void cbxFiltroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxFiltroItemStateChanged
        if(cbxFiltro.getSelectedIndex() == 1){
            rbtnEnsinoMedio.setEnabled(true);
            rbtnGraduacao.setEnabled(true);
            rbtnPosGraduacao.setEnabled(true);
            rbtnMestrado.setEnabled(true);
            rbtnDoutorado.setEnabled(true);
            txtFiltro.setText("");
            txtFiltro.setEnabled(false);
        }else{
            rbtnEnsinoMedio.setEnabled(false);
            rbtnGraduacao.setEnabled(false);
            rbtnPosGraduacao.setEnabled(false);
            rbtnMestrado.setEnabled(false);
            rbtnDoutorado.setEnabled(false);
            txtFiltro.setEnabled(true);
        }
    }//GEN-LAST:event_cbxFiltroItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.ButtonGroup btnGroup;
    private javax.swing.JComboBox<String> cbxFiltro;
    private javax.swing.JLabel jLabelFiltrar;
    private javax.swing.JScrollPane jScrollPaneProfessores;
    private javax.swing.JPanel pnlBuscarCurso;
    private javax.swing.JPanel pnlGeral;
    private javax.swing.JPanel pnlRodape;
    private javax.swing.JRadioButton rbtnDoutorado;
    private javax.swing.JRadioButton rbtnEnsinoMedio;
    private javax.swing.JRadioButton rbtnGraduacao;
    private javax.swing.JRadioButton rbtnMestrado;
    private javax.swing.JRadioButton rbtnPosGraduacao;
    private javax.swing.JTable tblCurso;
    private javax.swing.JTextField txtFiltro;
    // End of variables declaration//GEN-END:variables
}

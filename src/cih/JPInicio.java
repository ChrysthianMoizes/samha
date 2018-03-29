package cih;

import cci.CtrlPrincipal;

public class JPInicio extends javax.swing.JPanel {
      
    private CtrlPrincipal ctrlPrincipal;
    private FrmPrincipal frmPrincipal;

    public JPInicio(FrmPrincipal frmPrincipal, CtrlPrincipal ctrl) {
        initComponents();
        this.ctrlPrincipal = ctrl;
        this.frmPrincipal = frmPrincipal;
        identificarPermissaoJPInicio();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnProfessor = new javax.swing.JButton();
        btnCoordenador = new javax.swing.JButton();
        btnCurso = new javax.swing.JButton();
        btnDisciplina = new javax.swing.JButton();
        btnCoordenadoria = new javax.swing.JButton();
        btnEixo = new javax.swing.JButton();
        btnMatriz = new javax.swing.JButton();
        btnTurma = new javax.swing.JButton();

        setLayout(new java.awt.GridLayout(2, 4, 5, 5));

        btnProfessor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/professor.png"))); // NOI18N
        btnProfessor.setText("Professores");
        btnProfessor.setToolTipText("");
        btnProfessor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProfessor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfessorActionPerformed(evt);
            }
        });
        add(btnProfessor);

        btnCoordenador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/coordenador.png"))); // NOI18N
        btnCoordenador.setText("Coordenadores");
        btnCoordenador.setToolTipText("");
        btnCoordenador.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCoordenador.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCoordenador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCoordenadorActionPerformed(evt);
            }
        });
        add(btnCoordenador);

        btnCurso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/curso.png"))); // NOI18N
        btnCurso.setText("Cursos");
        btnCurso.setToolTipText("");
        btnCurso.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCurso.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCursoActionPerformed(evt);
            }
        });
        add(btnCurso);

        btnDisciplina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/disciplina.png"))); // NOI18N
        btnDisciplina.setText("Disciplinas");
        btnDisciplina.setToolTipText("");
        btnDisciplina.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDisciplina.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisciplinaActionPerformed(evt);
            }
        });
        add(btnDisciplina);

        btnCoordenadoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/corrdenadoria.png"))); // NOI18N
        btnCoordenadoria.setText("Coordenadorias");
        btnCoordenadoria.setToolTipText("");
        btnCoordenadoria.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCoordenadoria.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCoordenadoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCoordenadoriaActionPerformed(evt);
            }
        });
        add(btnCoordenadoria);

        btnEixo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/eixo.png"))); // NOI18N
        btnEixo.setText("Eixos");
        btnEixo.setToolTipText("");
        btnEixo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEixo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEixo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEixoActionPerformed(evt);
            }
        });
        add(btnEixo);

        btnMatriz.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/matriz_curricular.png"))); // NOI18N
        btnMatriz.setText("Matrizes Curriculares");
        btnMatriz.setToolTipText("");
        btnMatriz.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMatriz.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMatriz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMatrizActionPerformed(evt);
            }
        });
        add(btnMatriz);

        btnTurma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/turma.png"))); // NOI18N
        btnTurma.setText("Turmas");
        btnTurma.setToolTipText("");
        btnTurma.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTurma.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTurmaActionPerformed(evt);
            }
        });
        add(btnTurma);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCoordenadoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCoordenadoriaActionPerformed
        //frmPrincipal.trocarPanel(ciInterface.getCiGeral().instanciarJPCrud(frmPrincipal, Modulo.PROPRIEDADE));
    }//GEN-LAST:event_btnCoordenadoriaActionPerformed

    private void btnCoordenadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCoordenadorActionPerformed
        //frmPrincipal.trocarPanel(ciInterface.getCiGeral().instanciarJPServico(frmPrincipal, Modulo.SERVICO));
    }//GEN-LAST:event_btnCoordenadorActionPerformed

    private void btnDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisciplinaActionPerformed
        //frmPrincipal.trocarPanel(ciInterface.getCiGeral().instanciarJPCrud(frmPrincipal, Modulo.TIPO_MAQUINA));
    }//GEN-LAST:event_btnDisciplinaActionPerformed

    private void btnMatrizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatrizActionPerformed
        //frmPrincipal.trocarPanel(ciInterface.getCiGeral().instanciarJPCrud(frmPrincipal, Modulo.FUNCIONARIO));
    }//GEN-LAST:event_btnMatrizActionPerformed

    private void btnCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCursoActionPerformed
        //frmPrincipal.trocarPanel(ciInterface.getCiGeral().instanciarJPCrud(frmPrincipal, Modulo.MAQUINA));
    }//GEN-LAST:event_btnCursoActionPerformed

    private void btnEixoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEixoActionPerformed
       //frmPrincipal.trocarPanel(ciInterface.getCiGeral().instanciarJPCrud(frmPrincipal, Modulo.TIPO_SERVICO));
    }//GEN-LAST:event_btnEixoActionPerformed

    private void btnProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfessorActionPerformed
        //frmPrincipal.trocarPanel(ciInterface.getCiGeral().instanciarJPCrud(frmPrincipal, Modulo.PRODUTOR));
    }//GEN-LAST:event_btnProfessorActionPerformed

    private void btnTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTurmaActionPerformed
        //frmPrincipal.trocarPanel(ciInterface.getCiGeral().instanciarJPConfiguracoes(frmPrincipal));
    }//GEN-LAST:event_btnTurmaActionPerformed
 
    private void identificarPermissaoJPInicio(){
        //jButtonConfiguracoes.setEnabled(ciInterface.getCiGeral().identificarPermissaoJPInicio());
    }
    
    public void setjButtonProdutor(java.awt.event.ActionEvent evt) {
        //jButtonProdutorActionPerformed(evt);
    }
    
    public void setjButtonPropriedade(java.awt.event.ActionEvent evt) {
        //jButtonPropriedadeActionPerformed(evt);
    }

    public void setjButtonFuncionario(java.awt.event.ActionEvent evt) {
        //jButtonFuncionarioActionPerformed(evt);
    }

    public void setjButtonMaquina(java.awt.event.ActionEvent evt) {
        //jButtonMaquinaActionPerformed(evt);
    }

    public void setjButtonServico(java.awt.event.ActionEvent evt) {
        //jButtonServicoActionPerformed(evt);
    }

    public void setjButtonTipoMaquina(java.awt.event.ActionEvent evt) {
        //jButtonTipoMaquinaActionPerformed(evt);
    }

    public void setjButtonTipoServico(java.awt.event.ActionEvent evt) {
        //jButtonTipoServicoActionPerformed(evt);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCoordenador;
    private javax.swing.JButton btnCoordenadoria;
    private javax.swing.JButton btnCurso;
    private javax.swing.JButton btnDisciplina;
    private javax.swing.JButton btnEixo;
    private javax.swing.JButton btnMatriz;
    private javax.swing.JButton btnProfessor;
    private javax.swing.JButton btnTurma;
    // End of variables declaration//GEN-END:variables
}

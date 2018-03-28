package cih;

//import cci.CIInterface;
//import cci.util.Modulo;

public class JPInicio extends javax.swing.JPanel {
      
    //private CIInterface ciInterface;
    private FrmPrincipal frmPrincipal;

    public JPInicio(FrmPrincipal frmPrincipal) {
        initComponents();
        //this.ciInterface = ciInterface;
        this.frmPrincipal = frmPrincipal;
        identificarPermissaoJPInicio();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonProdutor = new javax.swing.JButton();
        jButtonServico = new javax.swing.JButton();
        jButtonMaquina = new javax.swing.JButton();
        jButtonTipoMaquina = new javax.swing.JButton();
        jButtonPropriedade = new javax.swing.JButton();
        jButtonTipoServico = new javax.swing.JButton();
        jButtonFuncionario = new javax.swing.JButton();
        jButtonConfiguracoes = new javax.swing.JButton();

        setLayout(new java.awt.GridLayout(2, 4, 5, 5));

        jButtonProdutor.setText("Professores");
        jButtonProdutor.setToolTipText("");
        jButtonProdutor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonProdutor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonProdutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProdutorActionPerformed(evt);
            }
        });
        add(jButtonProdutor);

        jButtonServico.setText("Coordenadores");
        jButtonServico.setToolTipText("");
        jButtonServico.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonServico.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonServicoActionPerformed(evt);
            }
        });
        add(jButtonServico);

        jButtonMaquina.setText("Cursos");
        jButtonMaquina.setToolTipText("");
        jButtonMaquina.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonMaquina.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonMaquina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMaquinaActionPerformed(evt);
            }
        });
        add(jButtonMaquina);

        jButtonTipoMaquina.setText("Disciplinas");
        jButtonTipoMaquina.setToolTipText("");
        jButtonTipoMaquina.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonTipoMaquina.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonTipoMaquina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTipoMaquinaActionPerformed(evt);
            }
        });
        add(jButtonTipoMaquina);

        jButtonPropriedade.setText("Coordenadorias");
        jButtonPropriedade.setToolTipText("");
        jButtonPropriedade.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonPropriedade.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonPropriedade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPropriedadeActionPerformed(evt);
            }
        });
        add(jButtonPropriedade);

        jButtonTipoServico.setText("Eixos");
        jButtonTipoServico.setToolTipText("");
        jButtonTipoServico.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonTipoServico.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonTipoServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTipoServicoActionPerformed(evt);
            }
        });
        add(jButtonTipoServico);

        jButtonFuncionario.setText("Matrizes Curriculares");
        jButtonFuncionario.setToolTipText("");
        jButtonFuncionario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonFuncionario.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFuncionarioActionPerformed(evt);
            }
        });
        add(jButtonFuncionario);

        jButtonConfiguracoes.setText("Turmas");
        jButtonConfiguracoes.setToolTipText("");
        jButtonConfiguracoes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonConfiguracoes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonConfiguracoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfiguracoesActionPerformed(evt);
            }
        });
        add(jButtonConfiguracoes);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPropriedadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPropriedadeActionPerformed
        //frmPrincipal.trocarPanel(ciInterface.getCiGeral().instanciarJPCrud(frmPrincipal, Modulo.PROPRIEDADE));
    }//GEN-LAST:event_jButtonPropriedadeActionPerformed

    private void jButtonServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonServicoActionPerformed
        //frmPrincipal.trocarPanel(ciInterface.getCiGeral().instanciarJPServico(frmPrincipal, Modulo.SERVICO));
    }//GEN-LAST:event_jButtonServicoActionPerformed

    private void jButtonTipoMaquinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTipoMaquinaActionPerformed
        //frmPrincipal.trocarPanel(ciInterface.getCiGeral().instanciarJPCrud(frmPrincipal, Modulo.TIPO_MAQUINA));
    }//GEN-LAST:event_jButtonTipoMaquinaActionPerformed

    private void jButtonFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFuncionarioActionPerformed
        //frmPrincipal.trocarPanel(ciInterface.getCiGeral().instanciarJPCrud(frmPrincipal, Modulo.FUNCIONARIO));
    }//GEN-LAST:event_jButtonFuncionarioActionPerformed

    private void jButtonMaquinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMaquinaActionPerformed
        //frmPrincipal.trocarPanel(ciInterface.getCiGeral().instanciarJPCrud(frmPrincipal, Modulo.MAQUINA));
    }//GEN-LAST:event_jButtonMaquinaActionPerformed

    private void jButtonTipoServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTipoServicoActionPerformed
       //frmPrincipal.trocarPanel(ciInterface.getCiGeral().instanciarJPCrud(frmPrincipal, Modulo.TIPO_SERVICO));
    }//GEN-LAST:event_jButtonTipoServicoActionPerformed

    private void jButtonProdutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProdutorActionPerformed
        //frmPrincipal.trocarPanel(ciInterface.getCiGeral().instanciarJPCrud(frmPrincipal, Modulo.PRODUTOR));
    }//GEN-LAST:event_jButtonProdutorActionPerformed

    private void jButtonConfiguracoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfiguracoesActionPerformed
        //frmPrincipal.trocarPanel(ciInterface.getCiGeral().instanciarJPConfiguracoes(frmPrincipal));
    }//GEN-LAST:event_jButtonConfiguracoesActionPerformed
 
    private void identificarPermissaoJPInicio(){
        //jButtonConfiguracoes.setEnabled(ciInterface.getCiGeral().identificarPermissaoJPInicio());
    }
    
    public void setjButtonProdutor(java.awt.event.ActionEvent evt) {
        jButtonProdutorActionPerformed(evt);
    }
    
    public void setjButtonPropriedade(java.awt.event.ActionEvent evt) {
        jButtonPropriedadeActionPerformed(evt);
    }

    public void setjButtonFuncionario(java.awt.event.ActionEvent evt) {
        jButtonFuncionarioActionPerformed(evt);
    }

    public void setjButtonMaquina(java.awt.event.ActionEvent evt) {
        jButtonMaquinaActionPerformed(evt);
    }

    public void setjButtonServico(java.awt.event.ActionEvent evt) {
        jButtonServicoActionPerformed(evt);
    }

    public void setjButtonTipoMaquina(java.awt.event.ActionEvent evt) {
        jButtonTipoMaquinaActionPerformed(evt);
    }

    public void setjButtonTipoServico(java.awt.event.ActionEvent evt) {
        jButtonTipoServicoActionPerformed(evt);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConfiguracoes;
    private javax.swing.JButton jButtonFuncionario;
    private javax.swing.JButton jButtonMaquina;
    private javax.swing.JButton jButtonProdutor;
    private javax.swing.JButton jButtonPropriedade;
    private javax.swing.JButton jButtonServico;
    private javax.swing.JButton jButtonTipoMaquina;
    private javax.swing.JButton jButtonTipoServico;
    // End of variables declaration//GEN-END:variables
}

package cih.principal;

import cci.CtrlMensagem;
import cci.CtrlPrincipal;
import cdp.CoordenadorAcademico;
import cdp.CoordenadorCurso;
import cdp.CoordenadorPedagogico;
import cdp.Usuario;
import cgt.Constantes;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JLabel;

public class FrmInicio extends javax.swing.JFrame {

    private CtrlPrincipal ctrlPrincipal;
    
    public FrmInicio(CtrlPrincipal ctrlPrincipal){
        this.ctrlPrincipal = ctrlPrincipal;
        initComponents();
        setarBackground();
    } 
    
     private void setarBackground(){
         pnlPrincipal.setBackground(ctrlPrincipal.setarCorPanelExterior());
         toolBar.setBackground(ctrlPrincipal.setarCorPanelExterior());
     }
    
    public void atualizarInfoSistema(){
        Usuario coordenador = ctrlPrincipal.getGtPrincipal().getCoordAtual();
        Date dataAtual = Calendar.getInstance().getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String data = formatter.format(dataAtual);
        lblDataAtual.setText(data);
        
        if(coordenador != null){
        
            if(coordenador instanceof CoordenadorCurso)
                lblNomeCoordenador.setText(((CoordenadorCurso)coordenador).getProfessor().getNome());
            else if(coordenador instanceof CoordenadorAcademico)
                lblNomeCoordenador.setText(((CoordenadorAcademico)coordenador).getServidor().getNome());
            else
                lblNomeCoordenador.setText(((CoordenadorPedagogico)coordenador).getServidor().getNome());
        
        }
    }
    
    public void identificarUsuario(int permissao){
        
        if(permissao == Constantes.PERMISSAO_COORD){
            btnCoordenador.setEnabled(false);
        }else if(permissao == Constantes.PERMISSAO_VIEW){
            btnAlocar.setEnabled(false);
            btnCoordenador.setEnabled(false);
            btnCurso.setEnabled(false);
            btnDisciplina.setEnabled(false);
            btnProfessor.setEnabled(false);
            btnTurma.setEnabled(false);
            btnOferta.setEnabled(false);
        }
    }

    public String getNomeCoordenador(){
        String[] nome = lblNomeCoordenador.getText().split(" ");
        return nome[0];
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        toolBar = new javax.swing.JToolBar();
        jSeparator12 = new javax.swing.JSeparator();
        btnProfessor = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnCoordenador = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        btnCurso = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        btnDisciplina = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JToolBar.Separator();
        btnTurma = new javax.swing.JButton();
        jSeparator9 = new javax.swing.JToolBar.Separator();
        btnAlocar = new javax.swing.JButton();
        jSeparator10 = new javax.swing.JToolBar.Separator();
        btnOferta = new javax.swing.JButton();
        jSeparator15 = new javax.swing.JToolBar.Separator();
        btnRelatorio = new javax.swing.JButton();
        jSeparator16 = new javax.swing.JToolBar.Separator();
        btnSair = new javax.swing.JButton();
        jSeparator13 = new javax.swing.JSeparator();
        pnlPrincipal = new javax.swing.JPanel();
        lblDataAtual = new javax.swing.JLabel();
        lblNomeCoordenador = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Apoio à Montagem de Horários Acadêmicos");

        toolBar.setBackground(new java.awt.Color(0, 153, 102));
        toolBar.setBorder(null);
        toolBar.setFloatable(false);
        toolBar.setRollover(true);
        toolBar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jSeparator12.setBackground(new java.awt.Color(0, 153, 102));
        toolBar.add(jSeparator12);

        btnProfessor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/professor.png"))); // NOI18N
        btnProfessor.setToolTipText("Professores");
        btnProfessor.setFocusable(false);
        btnProfessor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProfessor.setOpaque(false);
        btnProfessor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfessorActionPerformed(evt);
            }
        });
        toolBar.add(btnProfessor);

        jSeparator2.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        toolBar.add(jSeparator2);

        btnCoordenador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/coordenador.png"))); // NOI18N
        btnCoordenador.setToolTipText("Coordenadores");
        btnCoordenador.setFocusable(false);
        btnCoordenador.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCoordenador.setOpaque(false);
        btnCoordenador.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCoordenador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCoordenadorActionPerformed(evt);
            }
        });
        toolBar.add(btnCoordenador);

        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));
        toolBar.add(jSeparator4);

        btnCurso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/curso.png"))); // NOI18N
        btnCurso.setToolTipText("Curso");
        btnCurso.setFocusable(false);
        btnCurso.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCurso.setOpaque(false);
        btnCurso.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCursoActionPerformed(evt);
            }
        });
        toolBar.add(btnCurso);

        jSeparator7.setForeground(new java.awt.Color(255, 255, 255));
        toolBar.add(jSeparator7);

        btnDisciplina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/disciplina.png"))); // NOI18N
        btnDisciplina.setToolTipText("Disciplina");
        btnDisciplina.setFocusable(false);
        btnDisciplina.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDisciplina.setOpaque(false);
        btnDisciplina.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisciplinaActionPerformed(evt);
            }
        });
        toolBar.add(btnDisciplina);

        jSeparator8.setForeground(new java.awt.Color(255, 255, 255));
        toolBar.add(jSeparator8);

        btnTurma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/turma.png"))); // NOI18N
        btnTurma.setToolTipText("Turma");
        btnTurma.setFocusable(false);
        btnTurma.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTurma.setOpaque(false);
        btnTurma.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTurmaActionPerformed(evt);
            }
        });
        toolBar.add(btnTurma);

        jSeparator9.setForeground(new java.awt.Color(255, 255, 255));
        toolBar.add(jSeparator9);

        btnAlocar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/alocacao.png"))); // NOI18N
        btnAlocar.setToolTipText("Alocação");
        btnAlocar.setFocusable(false);
        btnAlocar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAlocar.setOpaque(false);
        btnAlocar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAlocar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlocarActionPerformed(evt);
            }
        });
        toolBar.add(btnAlocar);

        jSeparator10.setForeground(new java.awt.Color(255, 255, 255));
        toolBar.add(jSeparator10);

        btnOferta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/oferta-white.png"))); // NOI18N
        btnOferta.setToolTipText("Oferta");
        btnOferta.setFocusable(false);
        btnOferta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOferta.setOpaque(false);
        btnOferta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnOferta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOfertaActionPerformed(evt);
            }
        });
        toolBar.add(btnOferta);

        jSeparator15.setForeground(new java.awt.Color(255, 255, 255));
        toolBar.add(jSeparator15);

        btnRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/relatorio.png"))); // NOI18N
        btnRelatorio.setToolTipText("Relatórios");
        btnRelatorio.setFocusable(false);
        btnRelatorio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRelatorio.setOpaque(false);
        btnRelatorio.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatorioActionPerformed(evt);
            }
        });
        toolBar.add(btnRelatorio);

        jSeparator16.setForeground(new java.awt.Color(255, 255, 255));
        toolBar.add(jSeparator16);

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/sair.png"))); // NOI18N
        btnSair.setToolTipText("Sair");
        btnSair.setFocusable(false);
        btnSair.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSair.setOpaque(false);
        btnSair.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        toolBar.add(btnSair);

        jSeparator13.setBackground(new java.awt.Color(0, 153, 102));
        jSeparator13.setForeground(new java.awt.Color(0, 153, 102));
        toolBar.add(jSeparator13);

        getContentPane().add(toolBar, java.awt.BorderLayout.PAGE_START);

        pnlPrincipal.setBackground(new java.awt.Color(0, 153, 102));

        lblDataAtual.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        lblDataAtual.setForeground(new java.awt.Color(240, 240, 240));
        lblDataAtual.setText("00/00/0000");

        lblNomeCoordenador.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        lblNomeCoordenador.setForeground(new java.awt.Color(240, 240, 240));
        lblNomeCoordenador.setText("User");

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addContainerGap(927, Short.MAX_VALUE)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDataAtual, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNomeCoordenador, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addContainerGap(471, Short.MAX_VALUE)
                .addComponent(lblNomeCoordenador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDataAtual)
                .addContainerGap())
        );

        getContentPane().add(pnlPrincipal, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfessorActionPerformed
        ctrlPrincipal.getCtrlProfessor().instanciarTelaBuscaProfessor(this);
    }//GEN-LAST:event_btnProfessorActionPerformed

    private void btnCoordenadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCoordenadorActionPerformed
        ctrlPrincipal.getCtrlCoordenador().instanciarTelaBuscaCoordenador(this);
    }//GEN-LAST:event_btnCoordenadorActionPerformed

    private void btnCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCursoActionPerformed
        ctrlPrincipal.getCtrlCurso().instanciarTelaBuscaCurso(this);
    }//GEN-LAST:event_btnCursoActionPerformed

    private void btnDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisciplinaActionPerformed
        ctrlPrincipal.getCtrlDisciplina().instanciarTelaBuscaDisciplina(this);
    }//GEN-LAST:event_btnDisciplinaActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        ctrlPrincipal.encerrarSessao();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTurmaActionPerformed
        ctrlPrincipal.getCtrlTurma().instanciarTelaBuscaTurma(this);
    }//GEN-LAST:event_btnTurmaActionPerformed

    private void btnAlocarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlocarActionPerformed
        ctrlPrincipal.getCtrlAlocacao().instanciarTelaAlocacao(this);
    }//GEN-LAST:event_btnAlocarActionPerformed

    private void btnOfertaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOfertaActionPerformed
        ctrlPrincipal.getCtrlOferta().instanciarTelaOferta(this);
    }//GEN-LAST:event_btnOfertaActionPerformed

    private void btnRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorioActionPerformed
    CtrlMensagem.exibirMensagemAviso(this, "Módulo de Relatórios ainda não está disponível.");
    }//GEN-LAST:event_btnRelatorioActionPerformed
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlocar;
    private javax.swing.JButton btnCoordenador;
    private javax.swing.JButton btnCurso;
    private javax.swing.JButton btnDisciplina;
    private javax.swing.JButton btnOferta;
    private javax.swing.JButton btnProfessor;
    private javax.swing.JButton btnRelatorio;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnTurma;
    private javax.swing.JToolBar.Separator jSeparator10;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JToolBar.Separator jSeparator15;
    private javax.swing.JToolBar.Separator jSeparator16;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JToolBar.Separator jSeparator8;
    private javax.swing.JToolBar.Separator jSeparator9;
    private javax.swing.JLabel lblDataAtual;
    private javax.swing.JLabel lblNomeCoordenador;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JToolBar toolBar;
    // End of variables declaration//GEN-END:variables
}

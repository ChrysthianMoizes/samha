package cih.principal;

import cci.CtrlPrincipal;
import cdp.Coordenador;
import java.awt.Frame;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;

public class FrmInicio extends javax.swing.JFrame {

    private CtrlPrincipal ctrlPrincipal;
    
    public FrmInicio(CtrlPrincipal ctrlPrincipal){
        this.ctrlPrincipal = ctrlPrincipal;
        initComponents();
        atualizarInfoSistema();
        ImageIcon icone = ctrlPrincipal.setarIconeJanela();
        setIconImage(icone.getImage());
        this.setExtendedState(Frame.MAXIMIZED_BOTH);
        
        //ImageIcon icon = new ImageIcon("build/classes/cih/img/background.jpg");
        //icon.setImage(icon.getImage().getScaledInstance(lblBackground.getWidth(),lblBackground.getHeight() , 1));
        //lblBackground.setIcon(icon);
    } 
    
    private void atualizarInfoSistema(){
        Coordenador coord = ctrlPrincipal.getGtPrincipal().getCoordAtual();
        Date dataAtual = Calendar.getInstance().getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String data = formatter.format(dataAtual);
        if(coord != null){
            lblNomeCoordenador.setText(coord.getNome());
            lblDataAtual.setText(data);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        toolBar = new javax.swing.JToolBar();
        jSeparator12 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JToolBar.Separator();
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
        btnMatriz = new javax.swing.JButton();
        jSeparator10 = new javax.swing.JToolBar.Separator();
        btnAlocacao = new javax.swing.JButton();
        jSeparator11 = new javax.swing.JToolBar.Separator();
        btnOferta = new javax.swing.JButton();
        jSeparator15 = new javax.swing.JToolBar.Separator();
        btnSair = new javax.swing.JButton();
        jSeparator13 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        lblCoordenador = new javax.swing.JLabel();
        lblNomeCoordenador = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        lblDataAtual = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        toolBar.setBackground(new java.awt.Color(0, 153, 102));
        toolBar.setBorder(null);
        toolBar.setFloatable(false);
        toolBar.setRollover(true);
        toolBar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        toolBar.add(jSeparator12);
        toolBar.add(jSeparator3);

        btnProfessor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/professor.png"))); // NOI18N
        btnProfessor.setToolTipText("Professores");
        btnProfessor.setFocusable(false);
        btnProfessor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProfessor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfessorActionPerformed(evt);
            }
        });
        toolBar.add(btnProfessor);
        toolBar.add(jSeparator2);

        btnCoordenador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/coordenador.png"))); // NOI18N
        btnCoordenador.setToolTipText("Coordenadores");
        btnCoordenador.setFocusable(false);
        btnCoordenador.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCoordenador.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCoordenador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCoordenadorActionPerformed(evt);
            }
        });
        toolBar.add(btnCoordenador);
        toolBar.add(jSeparator4);

        btnCurso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/curso.png"))); // NOI18N
        btnCurso.setToolTipText("Curso");
        btnCurso.setFocusable(false);
        btnCurso.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCurso.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCursoActionPerformed(evt);
            }
        });
        toolBar.add(btnCurso);
        toolBar.add(jSeparator7);

        btnDisciplina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/disciplina.png"))); // NOI18N
        btnDisciplina.setToolTipText("Disciplina");
        btnDisciplina.setFocusable(false);
        btnDisciplina.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDisciplina.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisciplinaActionPerformed(evt);
            }
        });
        toolBar.add(btnDisciplina);
        toolBar.add(jSeparator8);

        btnTurma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/turma.png"))); // NOI18N
        btnTurma.setToolTipText("Turma");
        btnTurma.setFocusable(false);
        btnTurma.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTurma.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(btnTurma);
        toolBar.add(jSeparator9);

        btnMatriz.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/matriz_curricular.png"))); // NOI18N
        btnMatriz.setToolTipText("Matriz Curricular");
        btnMatriz.setFocusable(false);
        btnMatriz.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMatriz.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(btnMatriz);
        toolBar.add(jSeparator10);

        btnAlocacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/alocacao.png"))); // NOI18N
        btnAlocacao.setFocusable(false);
        btnAlocacao.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAlocacao.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(btnAlocacao);
        toolBar.add(jSeparator11);

        btnOferta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/oferta.png"))); // NOI18N
        btnOferta.setToolTipText("Oferta");
        btnOferta.setFocusable(false);
        btnOferta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOferta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnOferta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOfertaActionPerformed(evt);
            }
        });
        toolBar.add(btnOferta);
        toolBar.add(jSeparator15);

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/sair.png"))); // NOI18N
        btnSair.setToolTipText("Sair");
        btnSair.setFocusable(false);
        btnSair.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSair.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        toolBar.add(btnSair);
        toolBar.add(jSeparator13);

        getContentPane().add(toolBar, java.awt.BorderLayout.PAGE_START);

        jPanel1.setBackground(new java.awt.Color(0, 153, 102));

        lblCoordenador.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        lblCoordenador.setText("Coordenador:");

        lblNomeCoordenador.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        lblNomeCoordenador.setText("User");

        lblData.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        lblData.setText("Data:");

        lblDataAtual.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        lblDataAtual.setText("00/00/0000");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(894, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblDataAtual))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblCoordenador)
                        .addGap(65, 65, 65)
                        .addComponent(lblNomeCoordenador)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(387, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCoordenador)
                    .addComponent(lblNomeCoordenador))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblData)
                    .addComponent(lblDataAtual))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

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

    private void btnOfertaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOfertaActionPerformed
        ctrlPrincipal.instanciarFrameOferta();
    }//GEN-LAST:event_btnOfertaActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        ctrlPrincipal.encerrarSessao();
    }//GEN-LAST:event_btnSairActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlocacao;
    private javax.swing.JButton btnCoordenador;
    private javax.swing.JButton btnCurso;
    private javax.swing.JButton btnDisciplina;
    private javax.swing.JButton btnMatriz;
    private javax.swing.JButton btnOferta;
    private javax.swing.JButton btnProfessor;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnTurma;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar.Separator jSeparator10;
    private javax.swing.JToolBar.Separator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JToolBar.Separator jSeparator15;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JToolBar.Separator jSeparator8;
    private javax.swing.JToolBar.Separator jSeparator9;
    private javax.swing.JLabel lblCoordenador;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblDataAtual;
    private javax.swing.JLabel lblNomeCoordenador;
    private javax.swing.JToolBar toolBar;
    // End of variables declaration//GEN-END:variables
}

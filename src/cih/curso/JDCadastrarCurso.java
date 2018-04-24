package cih.curso;

import cci.CtrlMensagem;
import cci.CtrlPrincipal;
import cdp.Coordenadoria;
import cdp.Curso;
import cdp.Eixo;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

public class JDCadastrarCurso extends javax.swing.JDialog {

    private CtrlPrincipal ctrlPrincipal;
    private Curso curso;
    private List<Coordenadoria> listaCoordenadorias;
    private List<Eixo> listaEixos;

    public JDCadastrarCurso(java.awt.Frame parent, boolean modal, CtrlPrincipal ctrl, Curso curso) {
        super(parent, modal);
        initComponents();
        this.ctrlPrincipal = ctrl;
        this.curso = curso;
        setarBackground();
    }
    
    private void setarBackground(){
        pnlGeral.setBackground(ctrlPrincipal.setarCorPanelExterior());
        pnlCoordenadoria.setBackground(ctrlPrincipal.setarCorPanelInterior());
        pnlCurso.setBackground(ctrlPrincipal.setarCorPanelInterior());
        pnlEixo.setBackground(ctrlPrincipal.setarCorPanelInterior());
        pnlRodape.setBackground(ctrlPrincipal.setarCorPanelInterior());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlGeral = new javax.swing.JPanel();
        pnlEixo = new javax.swing.JPanel();
        txtNomeEixo = new javax.swing.JTextField();
        cbxEixo = new javax.swing.JComboBox<>();
        btnAdicionarEixo = new javax.swing.JButton();
        btnRemoverEixo = new javax.swing.JButton();
        lblNomeEixo = new javax.swing.JLabel();
        pnlRodape = new javax.swing.JPanel();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        pnlCurso = new javax.swing.JPanel();
        lblNivel = new javax.swing.JLabel();
        cbxNivel = new javax.swing.JComboBox<>();
        lblNomeCurso = new javax.swing.JLabel();
        txtNomeCurso = new javax.swing.JTextField();
        lblPeriodos = new javax.swing.JLabel();
        spnPeriodos = new javax.swing.JSpinner();
        pnlCoordenadoria = new javax.swing.JPanel();
        txtNomeCoordenadoria = new javax.swing.JTextField();
        cbxCoordenadoria = new javax.swing.JComboBox<>();
        btnAdicionarCoordenadoria = new javax.swing.JButton();
        btnRemoverCoordenadoria = new javax.swing.JButton();
        lblNomeCoordenadoria = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Curso");
        setResizable(false);

        pnlGeral.setBackground(new java.awt.Color(53, 151, 48));

        pnlEixo.setBackground(new java.awt.Color(0, 204, 102));
        pnlEixo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Eixo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 1, 14))); // NOI18N

        txtNomeEixo.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N

        cbxEixo.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        cbxEixo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cbxEixo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxEixoItemStateChanged(evt);
            }
        });

        btnAdicionarEixo.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        btnAdicionarEixo.setText("Adicionar");
        btnAdicionarEixo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnAdicionarEixo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarEixoActionPerformed(evt);
            }
        });
        btnAdicionarEixo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnAdicionarEixoKeyPressed(evt);
            }
        });

        btnRemoverEixo.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        btnRemoverEixo.setText("Remover");
        btnRemoverEixo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnRemoverEixo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverEixoActionPerformed(evt);
            }
        });
        btnRemoverEixo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnRemoverEixoKeyPressed(evt);
            }
        });

        lblNomeEixo.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblNomeEixo.setText("Nome:");

        javax.swing.GroupLayout pnlEixoLayout = new javax.swing.GroupLayout(pnlEixo);
        pnlEixo.setLayout(pnlEixoLayout);
        pnlEixoLayout.setHorizontalGroup(
            pnlEixoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEixoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNomeEixo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlEixoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbxEixo, 0, 400, Short.MAX_VALUE)
                    .addComponent(txtNomeEixo))
                .addGap(18, 18, 18)
                .addGroup(pnlEixoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdicionarEixo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemoverEixo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlEixoLayout.setVerticalGroup(
            pnlEixoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEixoLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(pnlEixoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionarEixo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomeEixo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNomeEixo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlEixoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRemoverEixo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxEixo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        pnlCurso.setBackground(new java.awt.Color(0, 204, 102));
        pnlCurso.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Curso", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 1, 14))); // NOI18N

        lblNivel.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblNivel.setText("Nível:");

        cbxNivel.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        cbxNivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ENSINO MÉDIO INTEGRADO", "GRADUAÇÃO", "PÓS-GRADUAÇÃO", "MESTRADO", "DOUTORADO" }));

        lblNomeCurso.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblNomeCurso.setText("Nome:");

        txtNomeCurso.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N

        lblPeriodos.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblPeriodos.setText("Anos/Períodos:");

        spnPeriodos.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        spnPeriodos.setModel(new javax.swing.SpinnerNumberModel(8, 0, null, 1));

        javax.swing.GroupLayout pnlCursoLayout = new javax.swing.GroupLayout(pnlCurso);
        pnlCurso.setLayout(pnlCursoLayout);
        pnlCursoLayout.setHorizontalGroup(
            pnlCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCursoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNivel)
                    .addComponent(lblNomeCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCursoLayout.createSequentialGroup()
                        .addComponent(cbxNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(lblPeriodos)
                        .addGap(18, 18, 18)
                        .addComponent(spnPeriodos))
                    .addComponent(txtNomeCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlCursoLayout.setVerticalGroup(
            pnlCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCursoLayout.createSequentialGroup()
                .addGroup(pnlCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomeCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomeCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPeriodos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnPeriodos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlCoordenadoria.setBackground(new java.awt.Color(0, 204, 102));
        pnlCoordenadoria.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Coordenadoria", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 1, 14))); // NOI18N

        txtNomeCoordenadoria.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N

        cbxCoordenadoria.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        cbxCoordenadoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        btnAdicionarCoordenadoria.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        btnAdicionarCoordenadoria.setText("Adicionar");
        btnAdicionarCoordenadoria.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnAdicionarCoordenadoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarCoordenadoriaActionPerformed(evt);
            }
        });
        btnAdicionarCoordenadoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnAdicionarCoordenadoriaKeyPressed(evt);
            }
        });

        btnRemoverCoordenadoria.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        btnRemoverCoordenadoria.setText("Remover");
        btnRemoverCoordenadoria.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnRemoverCoordenadoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverCoordenadoriaActionPerformed(evt);
            }
        });
        btnRemoverCoordenadoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnRemoverCoordenadoriaKeyPressed(evt);
            }
        });

        lblNomeCoordenadoria.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblNomeCoordenadoria.setText("Nome:");

        javax.swing.GroupLayout pnlCoordenadoriaLayout = new javax.swing.GroupLayout(pnlCoordenadoria);
        pnlCoordenadoria.setLayout(pnlCoordenadoriaLayout);
        pnlCoordenadoriaLayout.setHorizontalGroup(
            pnlCoordenadoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCoordenadoriaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNomeCoordenadoria, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCoordenadoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbxCoordenadoria, 0, 400, Short.MAX_VALUE)
                    .addComponent(txtNomeCoordenadoria))
                .addGap(18, 18, 18)
                .addGroup(pnlCoordenadoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdicionarCoordenadoria, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemoverCoordenadoria, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlCoordenadoriaLayout.setVerticalGroup(
            pnlCoordenadoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCoordenadoriaLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(pnlCoordenadoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionarCoordenadoria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomeCoordenadoria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNomeCoordenadoria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCoordenadoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRemoverCoordenadoria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxCoordenadoria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlGeralLayout = new javax.swing.GroupLayout(pnlGeral);
        pnlGeral.setLayout(pnlGeralLayout);
        pnlGeralLayout.setHorizontalGroup(
            pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGeralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlCurso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlCoordenadoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlEixo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlRodape, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlGeralLayout.setVerticalGroup(
            pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGeralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlEixo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlCoordenadoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlRodape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

    public void setarCamposComInstancia(Curso curso) {
        txtNomeCurso.setText(curso.getNome());
        spnPeriodos.setValue(curso.getQtPeriodos());
    }
    
    public void desabilitarCamposIniciais(){
        txtNomeEixo.setEnabled(false);
        txtNomeCoordenadoria.setEnabled(false);
        btnAdicionarEixo.setEnabled(false);
        btnAdicionarCoordenadoria.setEnabled(false);
        btnRemoverEixo.setEnabled(false);
        btnRemoverCoordenadoria.setEnabled(false);  
    }
    
    public void setarEixo(Curso curso){
        ctrlPrincipal.getCtrlCurso().setarEixo(curso, cbxEixo, cbxCoordenadoria);
    }
    
    public void setarCoordenadoria(){
        ctrlPrincipal.getCtrlCurso().setarCoordenadoria(cbxCoordenadoria);
    }
    
    public void setarNivel(){
        ctrlPrincipal.getCtrlCurso().setarNivel(cbxNivel);
    }
    
    public void preencherComboEixos(){ 
        ctrlPrincipal.getCtrlCurso().preencherComboEixos(cbxEixo, cbxCoordenadoria);
    }
    
    public void desabilitarCampos(){
        txtNomeCurso.setEnabled(false);
        cbxNivel.setEnabled(false);
        spnPeriodos.setEnabled(false);
        btnSalvar.setEnabled(false);
        btnCancelar.setText("Sair");
        txtNomeCoordenadoria.setEnabled(false);
        txtNomeCoordenadoria.setText("");
        txtNomeEixo.setText("");
        txtNomeEixo.setEnabled(false);
        btnAdicionarCoordenadoria.setEnabled(false);
        btnAdicionarEixo.setEnabled(false);
        btnRemoverCoordenadoria.setEnabled(false);
        btnRemoverEixo.setEnabled(false);
    }
    
    public void desabilitarCombos(){
        cbxEixo.setEnabled(false);
        cbxCoordenadoria.setEnabled(false);
    }

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try{
            String nome = txtNomeCurso.getText();
            String nivel = cbxNivel.getSelectedItem().toString();
            int periodos = (int) spnPeriodos.getValue();
            Coordenadoria coordenadoria = (Coordenadoria) cbxCoordenadoria.getSelectedItem();
            ctrlPrincipal.getCtrlCurso().validarOperacao(coordenadoria, nome, nivel, periodos);
        }catch(Exception e){
            CtrlMensagem.exibirMensagemAviso(this, "Todos os campos devem ser preenchidos");
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

    private void btnAdicionarEixoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarEixoActionPerformed
        ctrlPrincipal.getCtrlCurso().adicionarEixo(txtNomeEixo);
    }//GEN-LAST:event_btnAdicionarEixoActionPerformed

    private void btnRemoverEixoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverEixoActionPerformed
        ctrlPrincipal.getCtrlCurso().removerEixo(cbxEixo);
    }//GEN-LAST:event_btnRemoverEixoActionPerformed

    private void btnAdicionarCoordenadoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarCoordenadoriaActionPerformed
        Eixo eixo = (Eixo) cbxEixo.getSelectedItem();
        ctrlPrincipal.getCtrlCurso().adicionarCoordenadoria(txtNomeCoordenadoria, eixo, cbxCoordenadoria);       
    }//GEN-LAST:event_btnAdicionarCoordenadoriaActionPerformed

    private void btnRemoverCoordenadoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverCoordenadoriaActionPerformed
        ctrlPrincipal.getCtrlCurso().removerCoordenadoria(cbxEixo, cbxCoordenadoria);
    }//GEN-LAST:event_btnRemoverCoordenadoriaActionPerformed

    private void cbxEixoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxEixoItemStateChanged
        Eixo eixo = (Eixo) cbxEixo.getSelectedItem();
        if(eixo != null)
            ctrlPrincipal.getCtrlCurso().preencherComboCoordenadorias(eixo.getId(), cbxCoordenadoria);
    }//GEN-LAST:event_cbxEixoItemStateChanged

    private void btnAdicionarEixoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAdicionarEixoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnAdicionarEixoActionPerformed(null);
        }
    }//GEN-LAST:event_btnAdicionarEixoKeyPressed

    private void btnRemoverEixoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnRemoverEixoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnRemoverEixoActionPerformed(null);
        }
    }//GEN-LAST:event_btnRemoverEixoKeyPressed

    private void btnAdicionarCoordenadoriaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAdicionarCoordenadoriaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnAdicionarCoordenadoriaActionPerformed(null);
        }
    }//GEN-LAST:event_btnAdicionarCoordenadoriaKeyPressed

    private void btnRemoverCoordenadoriaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnRemoverCoordenadoriaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnRemoverCoordenadoriaActionPerformed(null);
        }
    }//GEN-LAST:event_btnRemoverCoordenadoriaKeyPressed

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Coordenadoria> getListaCoordenadorias() {
        return listaCoordenadorias;
    }

    public void setListaCoordenadorias(List<Coordenadoria> listaCoordenadorias) {
        this.listaCoordenadorias = listaCoordenadorias;
    }

    public List<Eixo> getListaEixos() {
        return listaEixos;
    }

    public void setListaEixos(List<Eixo> listaEixos) {
        this.listaEixos = listaEixos;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarCoordenadoria;
    private javax.swing.JButton btnAdicionarEixo;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRemoverCoordenadoria;
    private javax.swing.JButton btnRemoverEixo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbxCoordenadoria;
    private javax.swing.JComboBox<String> cbxEixo;
    private javax.swing.JComboBox<String> cbxNivel;
    private javax.swing.JLabel lblNivel;
    private javax.swing.JLabel lblNomeCoordenadoria;
    private javax.swing.JLabel lblNomeCurso;
    private javax.swing.JLabel lblNomeEixo;
    private javax.swing.JLabel lblPeriodos;
    private javax.swing.JPanel pnlCoordenadoria;
    private javax.swing.JPanel pnlCurso;
    private javax.swing.JPanel pnlEixo;
    private javax.swing.JPanel pnlGeral;
    private javax.swing.JPanel pnlRodape;
    private javax.swing.JSpinner spnPeriodos;
    private javax.swing.JTextField txtNomeCoordenadoria;
    private javax.swing.JTextField txtNomeCurso;
    private javax.swing.JTextField txtNomeEixo;
    // End of variables declaration//GEN-END:variables
}

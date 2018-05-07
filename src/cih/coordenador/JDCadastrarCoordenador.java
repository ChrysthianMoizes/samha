package cih.coordenador;

import cci.CtrlPrincipal;
import cdp.CoordenadorAcademico;
import cdp.CoordenadorCurso;
import cdp.CoordenadorPedagogico;
import cdp.Coordenadoria;
import cdp.Curso;
import cdp.Professor;
import cdp.Usuario;
import java.awt.event.KeyEvent;
import java.util.List;

public class JDCadastrarCoordenador extends javax.swing.JDialog {
    
    private CtrlPrincipal ctrlPrincipal;
    private Usuario coordenador;
    private List<Professor> listaProfessores;
    private List<Coordenadoria> listaCoordenadorias;

    public JDCadastrarCoordenador(java.awt.Frame parent, boolean modal, CtrlPrincipal ctrl) {
        super(parent, modal);
        initComponents();
        this.ctrlPrincipal = ctrl;
        setarBackground();
    }
    
    private void setarBackground(){
        pnlGeral.setBackground(ctrlPrincipal.setarCorPanelExterior());
        pnlAcesso.setBackground(ctrlPrincipal.setarCorPanelInterior());
        pnlCoordenador.setBackground(ctrlPrincipal.setarCorPanelInterior());
        pnlDadosPessoais.setBackground(ctrlPrincipal.setarCorPanelInterior());
        pnlRodape.setBackground(ctrlPrincipal.setarCorPanelInterior());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlGeral = new javax.swing.JPanel();
        pnlCoordenador = new javax.swing.JPanel();
        cbxTipo = new javax.swing.JComboBox<>();
        cbxProfessor = new javax.swing.JComboBox<>();
        lblTipo = new javax.swing.JLabel();
        lblProfessor = new javax.swing.JLabel();
        cbxCurso = new javax.swing.JComboBox<>();
        pnlDadosPessoais = new javax.swing.JPanel();
        lblMatricula = new javax.swing.JLabel();
        txtMatricula = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        lblNome1 = new javax.swing.JLabel();
        pnlRodape = new javax.swing.JPanel();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        pnlAcesso = new javax.swing.JPanel();
        lblLogin = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtSenha = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Coordenador");
        setResizable(false);

        pnlGeral.setBackground(new java.awt.Color(0, 153, 102));

        pnlCoordenador.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Coordenador", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 0, 14))); // NOI18N

        cbxTipo.setBackground(new java.awt.Color(0, 204, 0));
        cbxTipo.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        cbxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "COORDENADOR ACADÊMICO", "COORDENADOR DE CURSO", "COORDENADOR PEDAGÓGICO" }));
        cbxTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTipoActionPerformed(evt);
            }
        });

        cbxProfessor.setBackground(new java.awt.Color(0, 204, 0));
        cbxProfessor.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        cbxProfessor.setEnabled(false);
        cbxProfessor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxProfessorItemStateChanged(evt);
            }
        });

        lblTipo.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblTipo.setText("Tipo:");

        lblProfessor.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblProfessor.setText("Professor:");

        cbxCurso.setBackground(new java.awt.Color(0, 204, 0));
        cbxCurso.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        cbxCurso.setEnabled(false);

        javax.swing.GroupLayout pnlCoordenadorLayout = new javax.swing.GroupLayout(pnlCoordenador);
        pnlCoordenador.setLayout(pnlCoordenadorLayout);
        pnlCoordenadorLayout.setHorizontalGroup(
            pnlCoordenadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCoordenadorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCoordenadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTipo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCoordenadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxCurso, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlCoordenadorLayout.createSequentialGroup()
                        .addComponent(lblProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 307, Short.MAX_VALUE))
                    .addComponent(cbxProfessor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlCoordenadorLayout.setVerticalGroup(
            pnlCoordenadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCoordenadorLayout.createSequentialGroup()
                .addGroup(pnlCoordenadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipo)
                    .addComponent(lblProfessor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCoordenadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbxTipo, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(cbxProfessor))
                .addGap(9, 9, 9)
                .addComponent(cbxCurso, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlDadosPessoais.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados Pessoais", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 0, 14))); // NOI18N

        lblMatricula.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblMatricula.setText("Matrícula:");

        txtMatricula.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N

        txtNome.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N

        lblNome1.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblNome1.setText("Nome:");

        javax.swing.GroupLayout pnlDadosPessoaisLayout = new javax.swing.GroupLayout(pnlDadosPessoais);
        pnlDadosPessoais.setLayout(pnlDadosPessoaisLayout);
        pnlDadosPessoaisLayout.setHorizontalGroup(
            pnlDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosPessoaisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDadosPessoaisLayout.createSequentialGroup()
                        .addComponent(lblNome1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNome))
                    .addGroup(pnlDadosPessoaisLayout.createSequentialGroup()
                        .addComponent(lblMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlDadosPessoaisLayout.setVerticalGroup(
            pnlDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosPessoaisLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(pnlDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNome1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlRodape.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnSalvar.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/save.png"))); // NOI18N
        btnSalvar.setToolTipText("Salvar");
        btnSalvar.setBorder(null);
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

        javax.swing.GroupLayout pnlRodapeLayout = new javax.swing.GroupLayout(pnlRodape);
        pnlRodape.setLayout(pnlRodapeLayout);
        pnlRodapeLayout.setHorizontalGroup(
            pnlRodapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRodapeLayout.createSequentialGroup()
                .addContainerGap(423, Short.MAX_VALUE)
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
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnlAcesso.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados de Acesso", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 0, 14))); // NOI18N

        lblLogin.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/user.png"))); // NOI18N
        lblLogin.setToolTipText("Usuário");

        lblSenha.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblSenha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cih/img/lock.png"))); // NOI18N
        lblSenha.setToolTipText("Senha");

        txtUsuario.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        txtUsuario.setToolTipText("Digite o nome de usuário");

        txtSenha.setToolTipText("Digite a senha");

        javax.swing.GroupLayout pnlAcessoLayout = new javax.swing.GroupLayout(pnlAcesso);
        pnlAcesso.setLayout(pnlAcessoLayout);
        pnlAcessoLayout.setHorizontalGroup(
            pnlAcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAcessoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAcessoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblSenha)
                        .addGap(18, 18, 18)
                        .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlAcessoLayout.createSequentialGroup()
                        .addComponent(lblLogin)
                        .addGap(18, 18, 18)
                        .addComponent(txtUsuario)))
                .addContainerGap())
        );
        pnlAcessoLayout.setVerticalGroup(
            pnlAcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAcessoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlAcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlGeralLayout = new javax.swing.GroupLayout(pnlGeral);
        pnlGeral.setLayout(pnlGeralLayout);
        pnlGeralLayout.setHorizontalGroup(
            pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGeralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlCoordenador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlGeralLayout.createSequentialGroup()
                        .addComponent(pnlDadosPessoais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlRodape, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlGeralLayout.setVerticalGroup(
            pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGeralLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(pnlCoordenador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlDadosPessoais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
   
    public void setarCamposComInstancia(Usuario coordenador){
        
        txtUsuario.setText(coordenador.getLogin());
        txtSenha.setText(coordenador.getSenha());
        
        if(coordenador instanceof CoordenadorAcademico){
            txtNome.setText(((CoordenadorAcademico) coordenador).getServidor().getNome());
            txtMatricula.setText(((CoordenadorAcademico) coordenador).getServidor().getMatricula());
        }else if(coordenador instanceof CoordenadorCurso){
            txtNome.setText(((CoordenadorCurso) coordenador).getProfessor().getNome());
            txtMatricula.setText(((CoordenadorCurso) coordenador).getProfessor().getMatricula());
        }else{
            txtNome.setText(((CoordenadorPedagogico) coordenador).getServidor().getNome());
            txtMatricula.setText(((CoordenadorPedagogico) coordenador).getServidor().getMatricula());
        }
    }
    
    public void limparCampos(){
        cbxTipo.setSelectedIndex(0);
        alterarComboTipo();
        txtSenha.setText("");
        txtUsuario.setText("");
    }
    
    public void alterarComboTipo(){
        switch (cbxTipo.getSelectedIndex()) {
            case 1:
                ctrlPrincipal.getCtrlCoordenador().preencherComboProfessor(cbxProfessor);
                ctrlPrincipal.getCtrlCoordenador().preencherComboCurso(cbxCurso);
                cbxProfessor.setEnabled(true);
                cbxCurso.setEnabled(true);
                txtNome.setEditable(false);
                txtMatricula.setEditable(false);
                break;
            default:
                cbxProfessor.removeAllItems();
                cbxProfessor.setEnabled(false);
                cbxCurso.removeAllItems();
                cbxCurso.setEnabled(false);
                txtNome.setEditable(true);
                txtMatricula.setEditable(true);
                txtMatricula.setText("");
                txtNome.setText("");
                break;
        }
    }
    
    public void desabilitarComboTipoCoordenador(boolean opcao){
        cbxTipo.setEnabled(opcao);
    }
    
    public void desabilitarComboProfessor(boolean opcao){ 
        cbxProfessor.setEnabled(opcao);
    }
    
    public void desabilitarComboCurso(boolean opcao){ 
        cbxCurso.setEnabled(opcao);
    }
    
    public void desabilitarCampos(){
        
        cbxTipo.setEnabled(false);
        txtNome.setEnabled(false);
        txtMatricula.setEnabled(false);
        txtSenha.setEnabled(false);
        txtUsuario.setEnabled(false);
        btnSalvar.setEnabled(false);
        btnCancelar.setText("Sair");
    }
    
    public void selecionarTipoCoordenador(Usuario coordenador){
        
        if(coordenador instanceof CoordenadorAcademico){
            cbxTipo.setSelectedIndex(0);
        }else if( coordenador instanceof CoordenadorCurso){
            ctrlPrincipal.getCtrlCoordenador().preencherComboProfessor(cbxProfessor);
            cbxTipo.setSelectedIndex(1);
            cbxTipo.setEnabled(false);
            txtNome.setEditable(false);
            txtMatricula.setEditable(false);
        }else
            cbxTipo.setSelectedIndex(2); 
    }
    
    public void setarCamposProfessor(Professor professor){
        if(professor != null){
            txtNome.setText(professor.getNome());
            txtMatricula.setText(professor.getMatricula());
        }   
    }

    public Usuario getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(Usuario coordenador) {
        this.coordenador = coordenador;
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
  
    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        
        String tipo = (String) cbxTipo.getSelectedItem();
        String nome = txtNome.getText();
        String matricula = txtMatricula.getText();
        String login = txtUsuario.getText();
        String senha = txtSenha.getText();
        Professor professor = (Professor) cbxProfessor.getSelectedItem();
        Curso curso = (Curso) cbxCurso.getSelectedItem();
        
        ctrlPrincipal.getCtrlCoordenador().validarOperacao(professor, curso, tipo, login, senha, nome, matricula);
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnSalvarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSalvarKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            btnSalvarActionPerformed(null);
        }
    }//GEN-LAST:event_btnSalvarKeyPressed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnCancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCancelarKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            this.dispose();
        }
    }//GEN-LAST:event_btnCancelarKeyPressed

    private void cbxProfessorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxProfessorItemStateChanged
        Professor prof = (Professor) cbxProfessor.getSelectedItem();
        setarCamposProfessor(prof);
        txtSenha.setText("");
        txtUsuario.setText("");
    }//GEN-LAST:event_cbxProfessorItemStateChanged

    private void cbxTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTipoActionPerformed
        alterarComboTipo();
    }//GEN-LAST:event_cbxTipoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbxCurso;
    private javax.swing.JComboBox<String> cbxProfessor;
    private javax.swing.JComboBox<String> cbxTipo;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblMatricula;
    private javax.swing.JLabel lblNome1;
    private javax.swing.JLabel lblProfessor;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JPanel pnlAcesso;
    private javax.swing.JPanel pnlCoordenador;
    private javax.swing.JPanel pnlDadosPessoais;
    private javax.swing.JPanel pnlGeral;
    private javax.swing.JPanel pnlRodape;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtNome;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}

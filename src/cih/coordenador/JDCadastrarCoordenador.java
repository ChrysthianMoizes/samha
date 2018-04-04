package cih.coordenador;

import cci.CtrlPrincipal;
import cdp.Coordenador;
import cdp.Coordenadoria;
import cdp.Professor;
import cdp.ProfessorCoordenador;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

public class JDCadastrarCoordenador extends javax.swing.JDialog {
    
    private CtrlPrincipal ctrlPrincipal;
    private Coordenador coordenador;
    private List<Professor> listaProfessores;
    private List<Coordenadoria> listaCoordenadorias;

    public JDCadastrarCoordenador(java.awt.Frame parent, boolean modal, CtrlPrincipal ctrl, Coordenador coord) {
        super(parent, modal);
        initComponents();
        this.ctrlPrincipal = ctrl;
        this.coordenador = coord; // SE O COORDENADOR VIER NULO SIGNIFICA Q O CENARIO É CADASTRAR
        identificarOrigem();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlGeral = new javax.swing.JPanel();
        pnlAcesso = new javax.swing.JPanel();
        lblLogin = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        txtSenha = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        pnlCoordenador = new javax.swing.JPanel();
        cbxTipo = new javax.swing.JComboBox<>();
        cbxProfessor = new javax.swing.JComboBox<>();
        cbxCoordenadoria = new javax.swing.JComboBox<>();
        lblCoordenadoria = new javax.swing.JLabel();
        lblTipo = new javax.swing.JLabel();
        lblProfessor = new javax.swing.JLabel();
        pnlDadosPessoais = new javax.swing.JPanel();
        lblMatricula = new javax.swing.JLabel();
        txtMatricula = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        lblNome1 = new javax.swing.JLabel();
        pnlRodape = new javax.swing.JPanel();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Coordenador");
        setResizable(false);

        pnlGeral.setBackground(new java.awt.Color(53, 151, 48));

        pnlAcesso.setBackground(new java.awt.Color(0, 204, 102));
        pnlAcesso.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados de Acesso", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 0, 14))); // NOI18N

        lblLogin.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblLogin.setText("Login:");

        lblSenha.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblSenha.setText("Senha:");

        txtSenha.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N

        txtUsuario.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N

        javax.swing.GroupLayout pnlAcessoLayout = new javax.swing.GroupLayout(pnlAcesso);
        pnlAcesso.setLayout(pnlAcessoLayout);
        pnlAcessoLayout.setHorizontalGroup(
            pnlAcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAcessoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlAcessoLayout.createSequentialGroup()
                        .addComponent(lblLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlAcessoLayout.createSequentialGroup()
                        .addComponent(lblSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSenha)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlAcessoLayout.setVerticalGroup(
            pnlAcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAcessoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 20, Short.MAX_VALUE)
                .addGroup(pnlAcessoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        pnlCoordenador.setBackground(new java.awt.Color(0, 204, 102));
        pnlCoordenador.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Coordenador", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 0, 14))); // NOI18N

        cbxTipo.setBackground(new java.awt.Color(0, 204, 0));
        cbxTipo.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        cbxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "COORDENADOR ACADÊMICO", "COORDENADOR DE CURSO", "COORDENADOR PEDAGÓGICO" }));
        cbxTipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxTipoItemStateChanged(evt);
            }
        });

        cbxProfessor.setBackground(new java.awt.Color(0, 204, 0));
        cbxProfessor.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N

        cbxCoordenadoria.setBackground(new java.awt.Color(0, 204, 0));
        cbxCoordenadoria.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N

        lblCoordenadoria.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblCoordenadoria.setText("Coordenadoria:");

        lblTipo.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblTipo.setText("Tipo:");

        lblProfessor.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblProfessor.setText("Professor:");

        javax.swing.GroupLayout pnlCoordenadorLayout = new javax.swing.GroupLayout(pnlCoordenador);
        pnlCoordenador.setLayout(pnlCoordenadorLayout);
        pnlCoordenadorLayout.setHorizontalGroup(
            pnlCoordenadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCoordenadorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCoordenadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCoordenadorLayout.createSequentialGroup()
                        .addComponent(lblCoordenadoria)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxCoordenadoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlCoordenadorLayout.createSequentialGroup()
                        .addGroup(pnlCoordenadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlCoordenadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCoordenadorLayout.createSequentialGroup()
                                .addComponent(lblProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(cbxProfessor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        pnlCoordenadorLayout.setVerticalGroup(
            pnlCoordenadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCoordenadorLayout.createSequentialGroup()
                .addGroup(pnlCoordenadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCoordenadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCoordenadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCoordenadoria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxCoordenadoria, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlDadosPessoais.setBackground(new java.awt.Color(0, 204, 102));
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
                        .addComponent(lblMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlDadosPessoaisLayout.createSequentialGroup()
                        .addComponent(lblNome1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlDadosPessoaisLayout.setVerticalGroup(
            pnlDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosPessoaisLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(pnlDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNome1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addContainerGap(415, Short.MAX_VALUE)
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

        javax.swing.GroupLayout pnlGeralLayout = new javax.swing.GroupLayout(pnlGeral);
        pnlGeral.setLayout(pnlGeralLayout);
        pnlGeralLayout.setHorizontalGroup(
            pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGeralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlCoordenador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlDadosPessoais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlAcesso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlRodape, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlGeralLayout.setVerticalGroup(
            pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGeralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlCoordenador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlDadosPessoais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    public void identificarOrigem(){    
        if(coordenador != null){
            setarCamposComInstancia();
        }else{
            cbxProfessor.setEnabled(false);
            cbxCoordenadoria.setEnabled(false);
        }
    }
    
    public void setarCamposComInstancia(){
        selecionarTipoCoordenador();
        txtNome.setText(coordenador.getNome());
        txtMatricula.setText(coordenador.getMatricula());
        txtUsuario.setText(coordenador.getUsuario().getLogin());
        txtSenha.setText(coordenador.getUsuario().getSenha());
    }
    
    public void selecionarTipoCoordenador(){
        
        switch (coordenador.getTipo()) {
            
            case "COORDENADOR ACADÊMICO":
                cbxTipo.setSelectedIndex(0);
                cbxProfessor.setEnabled(false);
                cbxCoordenadoria.setEnabled(false);
                break;
                
            case "COORDENADOR DE CURSO":
                preencherComboProfessor();
                ProfessorCoordenador profCoord = (ProfessorCoordenador) coordenador;
                cbxCoordenadoria.setModel(new DefaultComboBoxModel(profCoord.getCoordenadoria().toArray()));
                cbxCoordenadoria.setSelectedIndex(0);
                preencherComboCoordenadorias();
                cbxTipo.setSelectedIndex(1);
                cbxTipo.setEnabled(false);
                txtNome.setEditable(false);
                txtMatricula.setEditable(false);
                break;
                
            default:
                cbxTipo.setSelectedIndex(2); 
                cbxProfessor.setEditable(false);
                break;
        }
    }
   
    public void preencherComboProfessor() {
        
        if(listaProfessores == null){
            listaProfessores = ctrlPrincipal.getCtrlProfessor().consultar();
            cbxProfessor.setModel(new DefaultComboBoxModel(listaProfessores.toArray()));
        }else
            cbxProfessor.setModel(new DefaultComboBoxModel(listaProfessores.toArray()));
        
        if(coordenador != null){
            Professor profAtual;
            for(int i = 0; i < listaProfessores.size(); i++){
                profAtual = (Professor) listaProfessores.get(i);
                if(profAtual.getMatricula().equals(coordenador.getMatricula())){
                    cbxProfessor.setSelectedIndex(i);
                    break;
                }
            }
        }
    }
    
    public void preencherComboCoordenadorias(){
        
        if(listaCoordenadorias == null){
            listaCoordenadorias = ctrlPrincipal.getCtrlCoordenadoria().filtrarCoordenadoresNulos();
            cbxCoordenadoria.setModel(new DefaultComboBoxModel(listaCoordenadorias.toArray())); 
        }else
            cbxCoordenadoria.setModel(new DefaultComboBoxModel(listaCoordenadorias.toArray())); 
    }

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        
        String tipo = (String) cbxTipo.getSelectedItem();
        String nome = txtNome.getText();
        String matricula = txtMatricula.getText();
        String login = txtUsuario.getText();
        String senha = txtSenha.getText();
        Professor professor = (Professor) cbxProfessor.getSelectedItem();
        Coordenadoria coordenadoria = (Coordenadoria) cbxCoordenadoria.getSelectedItem();
        
        if(coordenador == null)   
            ctrlPrincipal.getCtrlCoordenador().cadastrar(professor, coordenadoria, tipo, login, senha, nome, matricula);  
        else
            ctrlPrincipal.getCtrlCoordenador().alterar(coordenador, coordenadoria, professor, tipo, login, senha, nome, matricula);   
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

    private void cbxTipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxTipoItemStateChanged
        switch (cbxTipo.getSelectedIndex()) {
            case 1:
                preencherComboCoordenadorias();
                preencherComboProfessor();
                cbxProfessor.setEnabled(true);
                cbxCoordenadoria.setEnabled(true);
                txtNome.setEditable(false);
                txtMatricula.setEditable(false);
                break;
            default:
                cbxCoordenadoria.removeAllItems();
                cbxProfessor.removeAllItems();
                cbxProfessor.setEnabled(false);
                cbxCoordenadoria.setEnabled(false);
                txtNome.setEditable(true);
                txtMatricula.setEditable(true);
                break;
        }
    }//GEN-LAST:event_cbxTipoItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbxCoordenadoria;
    private javax.swing.JComboBox<String> cbxProfessor;
    private javax.swing.JComboBox<String> cbxTipo;
    private javax.swing.JLabel lblCoordenadoria;
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
    private javax.swing.JTextField txtSenha;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}

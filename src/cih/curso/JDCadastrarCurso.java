package cih.curso;

import cci.CtrlMensagem;
import cci.CtrlPrincipal;
import cdp.Coordenadoria;
import cdp.Curso;
import cdp.Professor;
import cdp.RestricaoProfessor;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

public class JDCadastrarCurso extends javax.swing.JDialog {

    private CtrlPrincipal ctrlPrincipal;
    private Professor professor;
    private List<RestricaoProfessor> listaRestricoes;
    private List<Coordenadoria> listaCoordenadorias;

    public JDCadastrarCurso(java.awt.Frame parent, boolean modal, CtrlPrincipal ctrl, Curso curso) {
        super(parent, modal);
        initComponents();
        this.ctrlPrincipal = ctrl;
        this.professor = professor;
        habilitarCamposRestricao(false);
        identificarOrigem();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupPrioridade = new javax.swing.ButtonGroup();
        pnlGeral = new javax.swing.JPanel();
        pnlEixo = new javax.swing.JPanel();
        txtNomeEixo = new javax.swing.JTextField();
        lblEixo = new javax.swing.JLabel();
        cbxCoordenadoria = new javax.swing.JComboBox<>();
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
        lblCoordenadoria = new javax.swing.JLabel();
        cbxCoordenadoria1 = new javax.swing.JComboBox<>();
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

        lblEixo.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblEixo.setText("Eixo:");

        cbxCoordenadoria.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        cbxCoordenadoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        btnAdicionarEixo.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        btnAdicionarEixo.setText("Adicionar");
        btnAdicionarEixo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnAdicionarEixo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarEixoActionPerformed(evt);
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

        lblNomeEixo.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblNomeEixo.setText("Nome:");

        javax.swing.GroupLayout pnlEixoLayout = new javax.swing.GroupLayout(pnlEixo);
        pnlEixo.setLayout(pnlEixoLayout);
        pnlEixoLayout.setHorizontalGroup(
            pnlEixoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEixoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEixoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNomeEixo)
                    .addComponent(lblEixo, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlEixoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbxCoordenadoria, 0, 400, Short.MAX_VALUE)
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
                    .addComponent(lblEixo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxCoordenadoria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdicionarEixo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlEixoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomeEixo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNomeEixo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemoverEixo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(lblNomeCurso)
                    .addComponent(lblNivel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCursoLayout.createSequentialGroup()
                        .addComponent(cbxNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(lblPeriodos)
                        .addGap(18, 18, 18)
                        .addComponent(spnPeriodos, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE))
                    .addComponent(txtNomeCurso))
                .addContainerGap())
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
        txtNomeCoordenadoria.setEnabled(false);

        lblCoordenadoria.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblCoordenadoria.setText("Coord.:");

        cbxCoordenadoria1.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        cbxCoordenadoria1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        btnAdicionarCoordenadoria.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        btnAdicionarCoordenadoria.setText("Adicionar");
        btnAdicionarCoordenadoria.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnAdicionarCoordenadoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarCoordenadoriaActionPerformed(evt);
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

        lblNomeCoordenadoria.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblNomeCoordenadoria.setText("Nome:");

        javax.swing.GroupLayout pnlCoordenadoriaLayout = new javax.swing.GroupLayout(pnlCoordenadoria);
        pnlCoordenadoria.setLayout(pnlCoordenadoriaLayout);
        pnlCoordenadoriaLayout.setHorizontalGroup(
            pnlCoordenadoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCoordenadoriaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCoordenadoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNomeCoordenadoria)
                    .addComponent(lblCoordenadoria, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCoordenadoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbxCoordenadoria1, 0, 400, Short.MAX_VALUE)
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
                    .addComponent(lblCoordenadoria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxCoordenadoria1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdicionarCoordenadoria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCoordenadoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomeCoordenadoria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNomeCoordenadoria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemoverCoordenadoria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlGeralLayout = new javax.swing.GroupLayout(pnlGeral);
        pnlGeral.setLayout(pnlGeralLayout);
        pnlGeralLayout.setHorizontalGroup(
            pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGeralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pnlCoordenadoria, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlEixo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlRodape, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlCurso, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlGeralLayout.setVerticalGroup(
            pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGeralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlEixo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlCoordenadoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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

    public void identificarOrigem() {
        preencherComboCoordenadorias();
        if (professor != null) {
            setarCamposComInstancia();
            listaRestricoes = ctrlPrincipal.getCtrlRestricao().filtrarPorProfessor(professor.getId());
            preencherListaRestricoes();
        }
    }

    public void setarCamposComInstancia() {

        txtNomeEixo.setText(professor.getNome());
        txtMatricula.setText(professor.getMatricula());
        txtCargaHoraria.setText(String.valueOf(professor.getCargaHoraria()));
        Coordenadoria coordenadoria;

        for (int i = 0; i < listaCoordenadorias.size(); i++) {

            coordenadoria = listaCoordenadorias.get(i);
            if (coordenadoria.getId() == professor.getCoordenadoria().getId()) {
                cbxCoordenadoria.setSelectedIndex(i);
                break;
            }
        }
    }

    public void preencherComboCoordenadorias() {

        if (listaCoordenadorias == null) {
            listaCoordenadorias = ctrlPrincipal.getCtrlCoordenadoria().filtrarCoordenadoresNulos();
        }

        cbxCoordenadoria.setModel(new DefaultComboBoxModel(listaCoordenadorias.toArray()));
    }

    public void preencherListaRestricoes() {
        if (listaRestricoes != null) {
            DefaultListModel defaultListModel = new DefaultListModel();
            lstRestricoes.removeAll();
            for (int i = 0; i < listaRestricoes.size(); i++) {
                defaultListModel.addElement(listaRestricoes.get(i).toString());
            }
            lstRestricoes.setModel(defaultListModel);
        }
    }

    public void desabilitarCamposProfessor(boolean opcao) {
        txtNomeEixo.setEnabled(opcao);
        txtMatricula.setEnabled(opcao);
        txtCargaHoraria.setEnabled(opcao);
        cbxCoordenadoria.setEnabled(opcao);
        btnSalvar.setEnabled(opcao);
        btnCancelar.setText("Sair");
    }

    public void habilitarCamposRestricao(boolean opcao) {
        txtNomeCurso.setEnabled(opcao);
        cbxNivel.setEnabled(opcao);
        cbxDias.setEnabled(opcao);
        lstRestricoes.setEnabled(opcao);
        chxAula1.setEnabled(opcao);
        chxAula2.setEnabled(opcao);
        chxAula3.setEnabled(opcao);
        chxAula4.setEnabled(opcao);
        chxAula5.setEnabled(opcao);
        chxAula6.setEnabled(opcao);
        rbtnAlta.setEnabled(opcao);
        rbtnBaixa.setEnabled(opcao);
        rbtnMedia.setEnabled(opcao);
        btnAdicionarEixo.setEnabled(opcao);
        btnRemoverEixo.setEnabled(opcao);
        btnLimpar.setEnabled(opcao);
        txtAreaDescricao.setEnabled(opcao);
    }

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        String nome = txtNomeEixo.getText();
        String matricula = txtMatricula.getText();
        String cargaHoraria = txtCargaHoraria.getText();
        Coordenadoria coordenadoria = (Coordenadoria) cbxCoordenadoria.getSelectedItem();

        if (professor == null) {
            professor = ctrlPrincipal.getCtrlProfessor().cadastrar(nome, matricula, cargaHoraria, coordenadoria);
        } else {
            professor = ctrlPrincipal.getCtrlProfessor().alterar(nome, matricula, cargaHoraria, coordenadoria, professor);
        }

        if (professor != null) {
            desabilitarCamposProfessor(false);
            habilitarCamposRestricao(true);
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

        String nome = txtNomeCurso.getText();
        String turno = cbxNivel.getSelectedItem().toString();
        String dia = cbxDias.getSelectedItem().toString();
        String descricao = txtAreaDescricao.getText();
        String prioridade;
        char priori = (char) btnGroupPrioridade.getSelection().getMnemonic();

        switch (priori) {
            case 'B':
                prioridade = "BAIXA";
                break;
            case 'M':
                prioridade = "MÉDIA";
                break;
            default:
                prioridade = "ALTA";
                break;
        }

        boolean aula1 = chxAula1.isSelected();
        boolean aula2 = chxAula2.isSelected();
        boolean aula3 = chxAula3.isSelected();
        boolean aula4 = chxAula4.isSelected();
        boolean aula5 = chxAula5.isSelected();
        boolean aula6 = chxAula6.isSelected();

        RestricaoProfessor restricao = ctrlPrincipal.getCtrlRestricao().cadastrar(
                nome, turno, dia, descricao, prioridade, aula1, aula2, aula3, aula4, aula5, aula6, professor);

        if (restricao != null) {
            listaRestricoes.add(restricao);
            preencherListaRestricoes();
        }
    }//GEN-LAST:event_btnAdicionarEixoActionPerformed

    private void btnRemoverEixoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverEixoActionPerformed

        int posicao = lstRestricoes.getSelectedIndex();
        RestricaoProfessor restricao = listaRestricoes.get(posicao);

        if (restricao != null) {
            int confirmacao = CtrlMensagem.exibirMensagemConfirmacao(this, "Confirmar Remoção ?");
            if (confirmacao == 0) {

                int resposta = ctrlPrincipal.getCtrlRestricao().excluir(restricao);
                if (resposta == 0) {
                    listaRestricoes.remove(posicao);
                    preencherListaRestricoes();
                }
            }
            btnLimparActionPerformed(null);
        } else {
            CtrlMensagem.exibirMensagemAviso(this, "Selecione uma Restrição para remover");
        }
    }//GEN-LAST:event_btnRemoverEixoActionPerformed

    private void btnAdicionarCoordenadoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarCoordenadoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdicionarCoordenadoriaActionPerformed

    private void btnRemoverCoordenadoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverCoordenadoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRemoverCoordenadoriaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarCoordenadoria;
    private javax.swing.JButton btnAdicionarEixo;
    private javax.swing.JButton btnCancelar;
    private javax.swing.ButtonGroup btnGroupPrioridade;
    private javax.swing.JButton btnRemoverCoordenadoria;
    private javax.swing.JButton btnRemoverEixo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbxCoordenadoria;
    private javax.swing.JComboBox<String> cbxCoordenadoria1;
    private javax.swing.JComboBox<String> cbxNivel;
    private javax.swing.JLabel lblCoordenadoria;
    private javax.swing.JLabel lblEixo;
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

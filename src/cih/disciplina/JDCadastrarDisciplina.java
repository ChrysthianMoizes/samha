package cih.disciplina;

import cci.CtrlMensagem;
import cci.CtrlPrincipal;
import cdp.Curso;
import cdp.Disciplina;
import cdp.Eixo;
import cdp.MatrizCurricular;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

public class JDCadastrarDisciplina extends javax.swing.JDialog {

    private CtrlPrincipal ctrlPrincipal;
    private Disciplina disciplina;
    private List<MatrizCurricular> listaMatriz;
    private List<Curso> listaCursos;

    public JDCadastrarDisciplina(java.awt.Frame parent, boolean modal, CtrlPrincipal ctrl, Disciplina disciplina) {
        super(parent, modal);
        initComponents();
        this.ctrlPrincipal = ctrl;
        this.disciplina = disciplina;
        setarBackground();
        identificarOrigem();
    }
    
    private void setarBackground(){
        pnlGeral.setBackground(ctrlPrincipal.setarCorPanelExterior());
        pnlCurso.setBackground(ctrlPrincipal.setarCorPanelInterior());
        pnlDisciplina.setBackground(ctrlPrincipal.setarCorPanelInterior());
        pnlMatrizCurricular.setBackground(ctrlPrincipal.setarCorPanelInterior());
        pnlRodape.setBackground(ctrlPrincipal.setarCorPanelInterior());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupPrioridade = new javax.swing.ButtonGroup();
        pnlGeral = new javax.swing.JPanel();
        pnlMatrizCurricular = new javax.swing.JPanel();
        txtNomeMatriz = new javax.swing.JTextField();
        btnAdicionarMatriz = new javax.swing.JButton();
        btnRemoverMatriz = new javax.swing.JButton();
        lblNomeMatriz = new javax.swing.JLabel();
        cbxMatriz = new javax.swing.JComboBox<>();
        lblAno = new javax.swing.JLabel();
        spnAno = new javax.swing.JSpinner();
        spnSemestre = new javax.swing.JSpinner();
        lblNomeCurso3 = new javax.swing.JLabel();
        pnlRodape = new javax.swing.JPanel();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        pnlDisciplina = new javax.swing.JPanel();
        lblTipo = new javax.swing.JLabel();
        cbxTipo = new javax.swing.JComboBox<>();
        lblNomeDisciplina = new javax.swing.JLabel();
        txtNomeDisciplina = new javax.swing.JTextField();
        lblPeriodo = new javax.swing.JLabel();
        spnPeriodo = new javax.swing.JSpinner();
        lblAulasSemanais = new javax.swing.JLabel();
        lblCargaHoraria = new javax.swing.JLabel();
        spnAulas = new javax.swing.JSpinner();
        spnCargaHoraria = new javax.swing.JSpinner();
        lblHoras = new javax.swing.JLabel();
        pnlCurso = new javax.swing.JPanel();
        cbxCurso = new javax.swing.JComboBox<>();
        lblNomeCurso = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Disciplina");
        setResizable(false);

        pnlGeral.setBackground(new java.awt.Color(53, 151, 48));

        pnlMatrizCurricular.setBackground(new java.awt.Color(0, 204, 102));
        pnlMatrizCurricular.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Matriz Curricular", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 1, 14))); // NOI18N

        txtNomeMatriz.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N

        btnAdicionarMatriz.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        btnAdicionarMatriz.setText("Adicionar");
        btnAdicionarMatriz.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnAdicionarMatriz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarMatrizActionPerformed(evt);
            }
        });
        btnAdicionarMatriz.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnAdicionarMatrizKeyPressed(evt);
            }
        });

        btnRemoverMatriz.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        btnRemoverMatriz.setText("Remover");
        btnRemoverMatriz.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnRemoverMatriz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverMatrizActionPerformed(evt);
            }
        });
        btnRemoverMatriz.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnRemoverMatrizKeyPressed(evt);
            }
        });

        lblNomeMatriz.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblNomeMatriz.setText("Nome:");

        cbxMatriz.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        cbxMatriz.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cbxMatriz.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxMatrizItemStateChanged(evt);
            }
        });

        lblAno.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblAno.setText("Ano/Semestre:");

        spnAno.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        spnAno.setModel(new javax.swing.SpinnerNumberModel(2018, 2000, null, 1));

        spnSemestre.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        spnSemestre.setModel(new javax.swing.SpinnerNumberModel(1, 1, 2, 1));

        lblNomeCurso3.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblNomeCurso3.setText("/");

        javax.swing.GroupLayout pnlMatrizCurricularLayout = new javax.swing.GroupLayout(pnlMatrizCurricular);
        pnlMatrizCurricular.setLayout(pnlMatrizCurricularLayout);
        pnlMatrizCurricularLayout.setHorizontalGroup(
            pnlMatrizCurricularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMatrizCurricularLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNomeMatriz, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlMatrizCurricularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMatrizCurricularLayout.createSequentialGroup()
                        .addComponent(lblAno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(spnAno, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNomeCurso3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spnSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMatrizCurricularLayout.createSequentialGroup()
                        .addComponent(txtNomeMatriz)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAdicionarMatriz, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMatrizCurricularLayout.createSequentialGroup()
                        .addComponent(cbxMatriz, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRemoverMatriz, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlMatrizCurricularLayout.setVerticalGroup(
            pnlMatrizCurricularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMatrizCurricularLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(pnlMatrizCurricularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionarMatriz, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomeMatriz, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNomeMatriz, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlMatrizCurricularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRemoverMatriz, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxMatriz, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlMatrizCurricularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnAno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNomeCurso3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        pnlDisciplina.setBackground(new java.awt.Color(0, 204, 102));
        pnlDisciplina.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Disciplina", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 1, 14))); // NOI18N

        lblTipo.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblTipo.setText("Tipo:");

        cbxTipo.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        cbxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "OBRIGATÓRIA", "OPTATIVA", "ESPECIAL" }));

        lblNomeDisciplina.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblNomeDisciplina.setText("Nome:");

        txtNomeDisciplina.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N

        lblPeriodo.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblPeriodo.setText("Período:");

        spnPeriodo.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        spnPeriodo.setModel(new javax.swing.SpinnerNumberModel(1, 0, null, 1));

        lblAulasSemanais.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblAulasSemanais.setText("Aulas semanais:");

        lblCargaHoraria.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblCargaHoraria.setText("Carga Horária:");

        spnAulas.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        spnAulas.setModel(new javax.swing.SpinnerNumberModel(4, 0, null, 1));

        spnCargaHoraria.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        spnCargaHoraria.setModel(new javax.swing.SpinnerNumberModel(60, 0, null, 30));

        lblHoras.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblHoras.setText("Hrs.");

        javax.swing.GroupLayout pnlDisciplinaLayout = new javax.swing.GroupLayout(pnlDisciplina);
        pnlDisciplina.setLayout(pnlDisciplinaLayout);
        pnlDisciplinaLayout.setHorizontalGroup(
            pnlDisciplinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDisciplinaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDisciplinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNomeDisciplina)
                    .addComponent(lblTipo))
                .addGap(12, 12, 12)
                .addGroup(pnlDisciplinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDisciplinaLayout.createSequentialGroup()
                        .addGroup(pnlDisciplinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlDisciplinaLayout.createSequentialGroup()
                                .addComponent(lblAulasSemanais)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(spnAulas, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(pnlDisciplinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDisciplinaLayout.createSequentialGroup()
                                .addComponent(lblPeriodo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(spnPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlDisciplinaLayout.createSequentialGroup()
                                .addComponent(lblCargaHoraria)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(spnCargaHoraria, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblHoras)))
                        .addGap(0, 2, Short.MAX_VALUE))
                    .addComponent(txtNomeDisciplina))
                .addContainerGap())
        );
        pnlDisciplinaLayout.setVerticalGroup(
            pnlDisciplinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDisciplinaLayout.createSequentialGroup()
                .addGroup(pnlDisciplinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomeDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomeDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDisciplinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCargaHoraria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnCargaHoraria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHoras, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDisciplinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAulasSemanais, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnAulas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlCurso.setBackground(new java.awt.Color(0, 204, 102));
        pnlCurso.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Curso", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 1, 14))); // NOI18N

        cbxCurso.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        cbxCurso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cbxCurso.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxCursoItemStateChanged(evt);
            }
        });

        lblNomeCurso.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblNomeCurso.setText("Nome:");

        javax.swing.GroupLayout pnlCursoLayout = new javax.swing.GroupLayout(pnlCurso);
        pnlCurso.setLayout(pnlCursoLayout);
        pnlCursoLayout.setHorizontalGroup(
            pnlCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCursoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNomeCurso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbxCurso, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlCursoLayout.setVerticalGroup(
            pnlCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCursoLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(pnlCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNomeCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlGeralLayout = new javax.swing.GroupLayout(pnlGeral);
        pnlGeral.setLayout(pnlGeralLayout);
        pnlGeralLayout.setHorizontalGroup(
            pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGeralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlDisciplina, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlMatrizCurricular, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlCurso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlRodape, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlGeralLayout.setVerticalGroup(
            pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGeralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlMatrizCurricular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        preencherComboCurso();
        if (disciplina != null){ 
            setarCamposComInstancia();
            txtNomeMatriz.setEnabled(false);          
            btnAdicionarMatriz.setEnabled(false);
            btnRemoverMatriz.setEnabled(false);
            spnAno.setEnabled(false);
            spnSemestre.setEnabled(false);
        }
    }

    public void setarCamposComInstancia() {
        setarCurso();
        setarMatriz();
        setarTipo();
        txtNomeDisciplina.setText(disciplina.getNome());
        spnCargaHoraria.setValue(disciplina.getCargaHoraria());
        spnAulas.setValue(disciplina.getQtAulas());
        spnPeriodo.setValue(disciplina.getPeriodo());           
    }
    
    public void setarCurso(){
        
        Curso curso;

        for (int i = 0; i < listaCursos.size(); i++) {

            curso = listaCursos.get(i);
            if (curso.getId() == disciplina.getMatriz().getCurso().getId()) {
                cbxCurso.setSelectedIndex(i);
                preencherComboMatriz(curso.getId());
                break;
            }
        }
    }
    
    public void setarMatriz(){
        
        MatrizCurricular matriz;
        
        for (int i = 0; i < listaMatriz.size(); i++) {

            matriz = listaMatriz.get(i);
            if (matriz.getId() == disciplina.getMatriz().getId()) {
                cbxMatriz.setSelectedIndex(i);
                break;
            }
        }
    }
    
    public void setarTipo(){
        
        if(disciplina.getTipo().equals("OBRIGATÓRIA")){
            cbxTipo.setSelectedIndex(0);
        }else if(disciplina.getTipo().equals("OPTATIVA")){
            cbxTipo.setSelectedIndex(1);
        }else{
            cbxTipo.setSelectedIndex(2);
        } 
    }
 
    public void preencherComboCurso(){ 
        listaCursos = ctrlPrincipal.getCtrlCurso().listar();
        cbxCurso.removeAllItems();
        cbxCurso.setModel(new DefaultComboBoxModel(listaCursos.toArray()));
        
        if(listaCursos.size() > 0){
            Curso curso = (Curso) cbxCurso.getSelectedItem();
            preencherComboMatriz(curso.getId());
        }  
    }
    
    public void preencherComboMatriz(int id) {
        listaMatriz = ctrlPrincipal.getCtrlMatriz().filtrarMatrizCurso(id);
        cbxMatriz.removeAllItems();
        cbxMatriz.setModel(new DefaultComboBoxModel(listaMatriz.toArray())); 
    }
    
    public void desabilitarCampos(){
        txtNomeDisciplina.setEnabled(false);
        cbxTipo.setEnabled(false);
        spnPeriodo.setEnabled(false);
        spnAulas.setEnabled(false);
        spnCargaHoraria.setEnabled(false);
        btnSalvar.setEnabled(false);
        btnCancelar.setText("Sair");
    }

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        String nome = txtNomeDisciplina.getText();
        String tipo = cbxTipo.getSelectedItem().toString();
        int cargaHoraria = (int) spnCargaHoraria.getValue();
        int periodo = (int) spnPeriodo.getValue();
        int qtAulas = (int) spnAulas.getValue();
        MatrizCurricular matriz = (MatrizCurricular) cbxMatriz.getSelectedItem();
        
        int resposta = 0;
        
        if(disciplina == null){
            resposta = ctrlPrincipal.getCtrlDisciplina().cadastrar(nome, tipo, periodo, cargaHoraria, qtAulas, matriz);  
        }else{
            resposta = ctrlPrincipal.getCtrlDisciplina().alterar(nome, tipo, periodo, cargaHoraria, qtAulas, matriz, disciplina);
        }
        
        if (resposta == 0) {
            desabilitarCampos();
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

    private void btnAdicionarMatrizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarMatrizActionPerformed
        
        String nome = txtNomeMatriz.getText();
        int ano = (int) spnAno.getValue();
        int semestre = (int) spnSemestre.getValue();
        Curso curso = (Curso) cbxCurso.getSelectedItem();
        int resposta = ctrlPrincipal.getCtrlMatriz().cadastrar(nome, ano, semestre, curso);
        
        if(resposta == 0){
            txtNomeMatriz.setText("");
            preencherComboMatriz(curso.getId());
            int posicao = listaMatriz.size();
            cbxMatriz.setSelectedIndex(posicao-1);  
        }      
    }//GEN-LAST:event_btnAdicionarMatrizActionPerformed

    private void btnRemoverMatrizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverMatrizActionPerformed
        int confirmacao = CtrlMensagem.exibirMensagemConfirmacao(this, "Confirmar Exclusão ?");
            if (confirmacao == 0) {
                MatrizCurricular matriz = (MatrizCurricular) cbxMatriz.getSelectedItem();
                int resposta = ctrlPrincipal.getCtrlMatriz().excluir(matriz);
                if(resposta == 0){
                    Curso curso = (Curso) cbxCurso.getSelectedItem();
                    preencherComboMatriz(curso.getId());
                }
            }
    }//GEN-LAST:event_btnRemoverMatrizActionPerformed

    private void cbxMatrizItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxMatrizItemStateChanged
        Eixo eixo = (Eixo) cbxMatriz.getSelectedItem();
        if(eixo != null)
            preencherComboMatriz(eixo.getId());
    }//GEN-LAST:event_cbxMatrizItemStateChanged

    private void btnAdicionarMatrizKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAdicionarMatrizKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnAdicionarMatrizActionPerformed(null);
        }
    }//GEN-LAST:event_btnAdicionarMatrizKeyPressed

    private void btnRemoverMatrizKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnRemoverMatrizKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnRemoverMatrizActionPerformed(null);
        }
    }//GEN-LAST:event_btnRemoverMatrizKeyPressed

    private void cbxCursoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxCursoItemStateChanged
        Curso curso = (Curso) cbxCurso.getSelectedItem();
        if(curso != null)
            preencherComboMatriz(curso.getId());
    }//GEN-LAST:event_cbxCursoItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarMatriz;
    private javax.swing.JButton btnCancelar;
    private javax.swing.ButtonGroup btnGroupPrioridade;
    private javax.swing.JButton btnRemoverMatriz;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbxCurso;
    private javax.swing.JComboBox<String> cbxMatriz;
    private javax.swing.JComboBox<String> cbxTipo;
    private javax.swing.JLabel lblAno;
    private javax.swing.JLabel lblAulasSemanais;
    private javax.swing.JLabel lblCargaHoraria;
    private javax.swing.JLabel lblHoras;
    private javax.swing.JLabel lblNomeCurso;
    private javax.swing.JLabel lblNomeCurso3;
    private javax.swing.JLabel lblNomeDisciplina;
    private javax.swing.JLabel lblNomeMatriz;
    private javax.swing.JLabel lblPeriodo;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JPanel pnlCurso;
    private javax.swing.JPanel pnlDisciplina;
    private javax.swing.JPanel pnlGeral;
    private javax.swing.JPanel pnlMatrizCurricular;
    private javax.swing.JPanel pnlRodape;
    private javax.swing.JSpinner spnAno;
    private javax.swing.JSpinner spnAulas;
    private javax.swing.JSpinner spnCargaHoraria;
    private javax.swing.JSpinner spnPeriodo;
    private javax.swing.JSpinner spnSemestre;
    private javax.swing.JTextField txtNomeDisciplina;
    private javax.swing.JTextField txtNomeMatriz;
    // End of variables declaration//GEN-END:variables
}

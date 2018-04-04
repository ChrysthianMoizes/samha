package cih.professor;
import cci.CtrlPrincipal;
import cdp.Coordenadoria;
import cdp.Professor;
import cdp.RestricaoProfessor;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

public class JDCadastrarProfessor extends javax.swing.JDialog {
    
    private CtrlPrincipal ctrlPrincipal;
    private Professor professor;
    private List<RestricaoProfessor> listaRestricoes;
    private List<Coordenadoria> listaCoordenadorias;

    public JDCadastrarProfessor(java.awt.Frame parent, boolean modal, CtrlPrincipal ctrl, Professor professor) {
        super(parent, modal);
        initComponents();
        this.ctrlPrincipal = ctrl;
        this.professor = professor;
        identificarOrigem();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupPrioridade = new javax.swing.ButtonGroup();
        pnlGeral = new javax.swing.JPanel();
        pnlDadosPessoais = new javax.swing.JPanel();
        lblCargaHoraria = new javax.swing.JLabel();
        txtMatricula = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        lblNome1 = new javax.swing.JLabel();
        lblMatricula1 = new javax.swing.JLabel();
        txtCargaHoraria = new javax.swing.JTextField();
        lblCoordenadoria = new javax.swing.JLabel();
        cbxCoordenadoria = new javax.swing.JComboBox<>();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        pnlRestricoes = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstRestricoes = new javax.swing.JList<>();
        lblDia = new javax.swing.JLabel();
        cbxDias = new javax.swing.JComboBox<>();
        lblTurno = new javax.swing.JLabel();
        cbxTurnos = new javax.swing.JComboBox<>();
        lblSemestre = new javax.swing.JLabel();
        spnAno = new javax.swing.JSpinner();
        spnSemestre = new javax.swing.JSpinner();
        lblBarra = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        pnlAulas = new javax.swing.JPanel();
        chxAula1 = new javax.swing.JCheckBox();
        chxAula2 = new javax.swing.JCheckBox();
        chxAula3 = new javax.swing.JCheckBox();
        chxAula4 = new javax.swing.JCheckBox();
        chxAula5 = new javax.swing.JCheckBox();
        chxAula6 = new javax.swing.JCheckBox();
        btnRemover = new javax.swing.JButton();
        btnAdicionar = new javax.swing.JButton();
        pnlDescricao = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAreaDescricao = new javax.swing.JTextArea();
        lblNomeRestricao = new javax.swing.JLabel();
        txtNomeRestricao = new javax.swing.JTextField();
        pnlPrioridade = new javax.swing.JPanel();
        rbtnBaixa = new javax.swing.JRadioButton();
        rbtnMedia = new javax.swing.JRadioButton();
        rbtnAlta = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Professor");
        setResizable(false);

        pnlGeral.setBackground(new java.awt.Color(53, 151, 48));

        pnlDadosPessoais.setBackground(new java.awt.Color(0, 204, 102));
        pnlDadosPessoais.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados Pessoais", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 1, 14))); // NOI18N

        lblCargaHoraria.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblCargaHoraria.setText("Carga Horária:");

        txtMatricula.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N

        txtNome.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N

        lblNome1.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblNome1.setText("Nome:");

        lblMatricula1.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblMatricula1.setText("Matrícula:");

        txtCargaHoraria.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N

        lblCoordenadoria.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblCoordenadoria.setText("Coordenadoria:");

        cbxCoordenadoria.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        cbxCoordenadoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

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

        javax.swing.GroupLayout pnlDadosPessoaisLayout = new javax.swing.GroupLayout(pnlDadosPessoais);
        pnlDadosPessoais.setLayout(pnlDadosPessoaisLayout);
        pnlDadosPessoaisLayout.setHorizontalGroup(
            pnlDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosPessoaisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDadosPessoaisLayout.createSequentialGroup()
                        .addGroup(pnlDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMatricula1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNome1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(pnlDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNome)
                            .addGroup(pnlDadosPessoaisLayout.createSequentialGroup()
                                .addComponent(txtMatricula)
                                .addGap(26, 26, 26)
                                .addComponent(lblCargaHoraria, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCargaHoraria, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnlDadosPessoaisLayout.createSequentialGroup()
                        .addComponent(lblCoordenadoria)
                        .addGap(18, 18, 18)
                        .addComponent(cbxCoordenadoria, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlDadosPessoaisLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlDadosPessoaisLayout.setVerticalGroup(
            pnlDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosPessoaisLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(pnlDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNome1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(pnlDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCargaHoraria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCargaHoraria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblMatricula1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCoordenadoria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxCoordenadoria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlRestricoes.setBackground(new java.awt.Color(0, 204, 102));
        pnlRestricoes.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Restrições", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 1, 14))); // NOI18N

        lstRestricoes.setBackground(new java.awt.Color(204, 255, 204));
        lstRestricoes.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        lstRestricoes.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lstRestricoes.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lstRestricoes.setEnabled(false);
        jScrollPane1.setViewportView(lstRestricoes);

        lblDia.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblDia.setText("Dia:");

        cbxDias.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        cbxDias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SEGUNDA-FEIRA", "TERÇA-FEIRA", "QUARTA-FEIRA", "QUINTA-FEIRA", "SEXTA-FEIRA" }));
        cbxDias.setEnabled(false);

        lblTurno.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblTurno.setText("Turno:");

        cbxTurnos.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        cbxTurnos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MATUTINO", "VESPERTINO", "NOTURNO" }));
        cbxTurnos.setEnabled(false);

        lblSemestre.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblSemestre.setText("Semestre:");

        spnAno.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        spnAno.setEnabled(false);

        spnSemestre.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        spnSemestre.setEnabled(false);

        lblBarra.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblBarra.setText("/");

        pnlAulas.setBackground(new java.awt.Color(0, 204, 102));
        pnlAulas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Aulas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 1, 14))); // NOI18N

        chxAula1.setBackground(new java.awt.Color(0, 204, 102));
        chxAula1.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        chxAula1.setText("Aula 1");
        chxAula1.setEnabled(false);

        chxAula2.setBackground(new java.awt.Color(0, 204, 102));
        chxAula2.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        chxAula2.setText("Aula 2");
        chxAula2.setEnabled(false);

        chxAula3.setBackground(new java.awt.Color(0, 204, 102));
        chxAula3.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        chxAula3.setText("Aula 3");
        chxAula3.setEnabled(false);

        chxAula4.setBackground(new java.awt.Color(0, 204, 102));
        chxAula4.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        chxAula4.setText("Aula 4");
        chxAula4.setEnabled(false);

        chxAula5.setBackground(new java.awt.Color(0, 204, 102));
        chxAula5.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        chxAula5.setText("Aula 5");
        chxAula5.setEnabled(false);

        chxAula6.setBackground(new java.awt.Color(0, 204, 102));
        chxAula6.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        chxAula6.setText("Aula 6");
        chxAula6.setEnabled(false);

        javax.swing.GroupLayout pnlAulasLayout = new javax.swing.GroupLayout(pnlAulas);
        pnlAulas.setLayout(pnlAulasLayout);
        pnlAulasLayout.setHorizontalGroup(
            pnlAulasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAulasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlAulasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlAulasLayout.createSequentialGroup()
                        .addComponent(chxAula4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chxAula5))
                    .addGroup(pnlAulasLayout.createSequentialGroup()
                        .addComponent(chxAula1)
                        .addGap(18, 18, 18)
                        .addComponent(chxAula2)))
                .addGap(18, 18, 18)
                .addGroup(pnlAulasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chxAula3)
                    .addComponent(chxAula6)))
        );
        pnlAulasLayout.setVerticalGroup(
            pnlAulasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAulasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAulasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chxAula1)
                    .addComponent(chxAula2)
                    .addComponent(chxAula3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlAulasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chxAula4)
                    .addComponent(chxAula5)
                    .addComponent(chxAula6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnRemover.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        btnRemover.setText("Remover");
        btnRemover.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnRemover.setEnabled(false);
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        btnAdicionar.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        btnAdicionar.setText("Adicionar");
        btnAdicionar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnAdicionar.setEnabled(false);
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        pnlDescricao.setBackground(new java.awt.Color(0, 204, 102));
        pnlDescricao.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descrição", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 0, 14))); // NOI18N

        txtAreaDescricao.setColumns(20);
        txtAreaDescricao.setRows(5);
        txtAreaDescricao.setEnabled(false);
        jScrollPane2.setViewportView(txtAreaDescricao);

        javax.swing.GroupLayout pnlDescricaoLayout = new javax.swing.GroupLayout(pnlDescricao);
        pnlDescricao.setLayout(pnlDescricaoLayout);
        pnlDescricaoLayout.setHorizontalGroup(
            pnlDescricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
        );
        pnlDescricaoLayout.setVerticalGroup(
            pnlDescricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
        );

        lblNomeRestricao.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblNomeRestricao.setText("Nome:");

        txtNomeRestricao.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        txtNomeRestricao.setEnabled(false);

        pnlPrioridade.setBackground(new java.awt.Color(0, 204, 102));
        pnlPrioridade.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Prioridade", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 1, 14))); // NOI18N

        rbtnBaixa.setBackground(new java.awt.Color(0, 204, 102));
        btnGroupPrioridade.add(rbtnBaixa);
        rbtnBaixa.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        rbtnBaixa.setMnemonic('b');
        rbtnBaixa.setText("Baixa");
        rbtnBaixa.setEnabled(false);

        rbtnMedia.setBackground(new java.awt.Color(0, 204, 102));
        btnGroupPrioridade.add(rbtnMedia);
        rbtnMedia.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        rbtnMedia.setMnemonic('m');
        rbtnMedia.setText("Média");
        rbtnMedia.setEnabled(false);

        rbtnAlta.setBackground(new java.awt.Color(0, 204, 102));
        btnGroupPrioridade.add(rbtnAlta);
        rbtnAlta.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        rbtnAlta.setMnemonic('a');
        rbtnAlta.setText("Alta");
        rbtnAlta.setEnabled(false);

        javax.swing.GroupLayout pnlPrioridadeLayout = new javax.swing.GroupLayout(pnlPrioridade);
        pnlPrioridade.setLayout(pnlPrioridadeLayout);
        pnlPrioridadeLayout.setHorizontalGroup(
            pnlPrioridadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrioridadeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPrioridadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbtnBaixa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rbtnMedia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rbtnAlta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlPrioridadeLayout.setVerticalGroup(
            pnlPrioridadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrioridadeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbtnBaixa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbtnMedia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbtnAlta)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlRestricoesLayout = new javax.swing.GroupLayout(pnlRestricoes);
        pnlRestricoes.setLayout(pnlRestricoesLayout);
        pnlRestricoesLayout.setHorizontalGroup(
            pnlRestricoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRestricoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlRestricoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRestricoesLayout.createSequentialGroup()
                        .addGroup(pnlRestricoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlRestricoesLayout.createSequentialGroup()
                                .addComponent(lblSemestre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spnAno, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblBarra, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spnSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblDia, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRestricoesLayout.createSequentialGroup()
                                .addComponent(lblNomeRestricao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNomeRestricao, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTurno)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlRestricoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxTurnos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxDias, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRestricoesLayout.createSequentialGroup()
                        .addGroup(pnlRestricoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRemover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(10, 10, 10)
                        .addComponent(pnlDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlRestricoesLayout.createSequentialGroup()
                        .addComponent(pnlAulas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlPrioridade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlRestricoesLayout.setVerticalGroup(
            pnlRestricoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRestricoesLayout.createSequentialGroup()
                .addGroup(pnlRestricoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRestricoesLayout.createSequentialGroup()
                        .addGroup(pnlRestricoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNomeRestricao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlRestricoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbxTurnos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblNomeRestricao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlRestricoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spnAno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlRestricoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(spnSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblBarra, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbxDias, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblDia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlRestricoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pnlPrioridade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlAulas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlRestricoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlRestricoesLayout.createSequentialGroup()
                                .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31))
                            .addComponent(pnlDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout pnlGeralLayout = new javax.swing.GroupLayout(pnlGeral);
        pnlGeral.setLayout(pnlGeralLayout);
        pnlGeralLayout.setHorizontalGroup(
            pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGeralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlDadosPessoais, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlRestricoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlGeralLayout.setVerticalGroup(
            pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGeralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlDadosPessoais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlRestricoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addComponent(pnlGeral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void identificarOrigem(){
        preencherComboCoordenadorias();
        if(professor != null){
            setarCamposComInstancia();
            //buscar restricoes com professor_id
        }
    }
    
    public void setarCamposComInstancia(){
        
        txtNome.setText(professor.getNome());
        txtMatricula.setText(professor.getMatricula());
        txtCargaHoraria.setText(String.valueOf(professor.getCargaHoraria()));
        Coordenadoria coordenadoria;
        
        for(int i = 0; i < listaCoordenadorias.size(); i++){
            
            coordenadoria = listaCoordenadorias.get(i);
            if(coordenadoria.getId() == professor.getCoordenadoria().getId()){
                cbxCoordenadoria.setSelectedIndex(i);
                break;
            }
            i++;      
        }      
    }
    
    public void preencherComboCoordenadorias(){
        
        if(listaCoordenadorias == null){
            listaCoordenadorias = ctrlPrincipal.getCtrlCoordenadoria().filtrarCoordenadoresNulos();
            cbxCoordenadoria.setModel(new DefaultComboBoxModel(listaCoordenadorias.toArray())); 
        }else
            cbxCoordenadoria.setModel(new DefaultComboBoxModel(listaCoordenadorias.toArray())); 
    }
    
    public void desabilitarCamposProfessor(boolean opcao){
        txtNome.setEnabled(opcao);
        txtMatricula.setEnabled(opcao);
        txtCargaHoraria.setEnabled(opcao);
        cbxCoordenadoria.setEnabled(opcao);
        btnSalvar.setEnabled(opcao);
        btnCancelar.setText("Sair");
    }
    
    public void habilitarCamposRestricao(boolean opcao){
        txtNomeRestricao.setEnabled(opcao);
        cbxTurnos.setEnabled(opcao);
        spnAno.setEnabled(opcao);
        spnSemestre.setEnabled(opcao);
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
        btnAdicionar.setEnabled(opcao);
        btnRemover.setEnabled(opcao);
        txtAreaDescricao.setEnabled(opcao);    
    }

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        
        String nome = txtNome.getText();
        String matricula = txtMatricula.getText();
        String cargaHoraria = txtCargaHoraria.getText();       
        Coordenadoria coordenadoria = (Coordenadoria) cbxCoordenadoria.getSelectedItem(); 
        
        if(professor == null){   
            int resposta = ctrlPrincipal.getCtrlProfessor().cadastrar(nome, matricula, cargaHoraria, coordenadoria);
            if(resposta == 0){
                desabilitarCamposProfessor(false);
                habilitarCamposRestricao(true);
            }
        }else{
            int resposta = ctrlPrincipal.getCtrlProfessor().alterar(nome, matricula, cargaHoraria, coordenadoria, professor);
            if(resposta == 0){
                desabilitarCamposProfessor(false);
                habilitarCamposRestricao(true);
            }
        }    
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

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        
        String nome = txtNomeRestricao.getText();
        String turno = cbxTurnos.getSelectedItem().toString();
        String dia = cbxDias.getSelectedItem().toString();
        String semestre = String.valueOf(spnAno.getValue()) + String.valueOf(spnSemestre.getValue());
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
                nome, turno, dia, semestre, descricao, prioridade, aula1, aula2, aula3, aula4, aula5, aula6, professor); 
            
        if(restricao != null){
            listaRestricoes.add(restricao);
            DefaultListModel defaultListModel = new DefaultListModel();
            defaultListModel.addElement(restricao);
            lstRestricoes.setModel(defaultListModel);
        }     
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        int posicao=  lstRestricoes.getSelectedIndex();
        RestricaoProfessor restricao = listaRestricoes.get(posicao);
        int resposta = ctrlPrincipal.getCtrlRestricao().excluir(restricao);
        if(resposta == 0){
            listaRestricoes.remove(posicao);
        }
    }//GEN-LAST:event_btnRemoverActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.ButtonGroup btnGroupPrioridade;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbxCoordenadoria;
    private javax.swing.JComboBox<String> cbxDias;
    private javax.swing.JComboBox<String> cbxTurnos;
    private javax.swing.JCheckBox chxAula1;
    private javax.swing.JCheckBox chxAula2;
    private javax.swing.JCheckBox chxAula3;
    private javax.swing.JCheckBox chxAula4;
    private javax.swing.JCheckBox chxAula5;
    private javax.swing.JCheckBox chxAula6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblBarra;
    private javax.swing.JLabel lblCargaHoraria;
    private javax.swing.JLabel lblCoordenadoria;
    private javax.swing.JLabel lblDia;
    private javax.swing.JLabel lblMatricula1;
    private javax.swing.JLabel lblNome1;
    private javax.swing.JLabel lblNomeRestricao;
    private javax.swing.JLabel lblSemestre;
    private javax.swing.JLabel lblTurno;
    private javax.swing.JList<String> lstRestricoes;
    private javax.swing.JPanel pnlAulas;
    private javax.swing.JPanel pnlDadosPessoais;
    private javax.swing.JPanel pnlDescricao;
    private javax.swing.JPanel pnlGeral;
    private javax.swing.JPanel pnlPrioridade;
    private javax.swing.JPanel pnlRestricoes;
    private javax.swing.JRadioButton rbtnAlta;
    private javax.swing.JRadioButton rbtnBaixa;
    private javax.swing.JRadioButton rbtnMedia;
    private javax.swing.JSpinner spnAno;
    private javax.swing.JSpinner spnSemestre;
    private javax.swing.JTextArea txtAreaDescricao;
    private javax.swing.JTextField txtCargaHoraria;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNomeRestricao;
    // End of variables declaration//GEN-END:variables
}

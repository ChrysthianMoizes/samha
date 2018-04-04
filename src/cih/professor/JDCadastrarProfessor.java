package cih.professor;
import cci.CtrlPrincipal;
import cdp.Coordenador;
import cdp.Coordenadoria;
import cdp.Professor;
import cdp.ProfessorCoordenador;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

public class JDCadastrarProfessor extends javax.swing.JDialog {
    
    private CtrlPrincipal ctrlPrincipal;
    private Professor professor;
    private List<Coordenadoria> listaCoordenadorias;

    public JDCadastrarProfessor(java.awt.Frame parent, boolean modal, CtrlPrincipal ctrl, Professor professor) {
        super(parent, modal);
        initComponents();
        this.ctrlPrincipal = ctrl;
        this.professor = professor; // SE O COORDENADOR VIER NULO SIGNIFICA Q O CENARIO É CADASTRAR
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
        pnlRodape = new javax.swing.JPanel();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        pnlRestricoes = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
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
        cxhAula1 = new javax.swing.JCheckBox();
        chxAula2 = new javax.swing.JCheckBox();
        chxAula3 = new javax.swing.JCheckBox();
        chxAula4 = new javax.swing.JCheckBox();
        chxAula5 = new javax.swing.JCheckBox();
        chxAula6 = new javax.swing.JCheckBox();
        btnRemover = new javax.swing.JButton();
        btnAdicionar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
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
        pnlDadosPessoais.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados Pessoais", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("MV Boli", 0, 14))); // NOI18N

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

        javax.swing.GroupLayout pnlDadosPessoaisLayout = new javax.swing.GroupLayout(pnlDadosPessoais);
        pnlDadosPessoais.setLayout(pnlDadosPessoaisLayout);
        pnlDadosPessoaisLayout.setHorizontalGroup(
            pnlDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosPessoaisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCoordenadoria)
                    .addComponent(lblMatricula1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNome1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNome)
                    .addGroup(pnlDadosPessoaisLayout.createSequentialGroup()
                        .addComponent(txtMatricula)
                        .addGap(26, 26, 26)
                        .addComponent(lblCargaHoraria, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCargaHoraria, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlDadosPessoaisLayout.createSequentialGroup()
                        .addComponent(cbxCoordenadoria, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                    .addGroup(pnlDadosPessoaisLayout.createSequentialGroup()
                        .addGroup(pnlDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCargaHoraria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCargaHoraria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlDadosPessoaisLayout.createSequentialGroup()
                        .addGroup(pnlDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMatricula1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(pnlDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCoordenadoria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxCoordenadoria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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

        pnlRestricoes.setBackground(new java.awt.Color(0, 204, 102));
        pnlRestricoes.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Restrições", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("MV Boli", 0, 14))); // NOI18N

        jList1.setBackground(new java.awt.Color(0, 204, 102));
        jList1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jList1.setFont(new java.awt.Font("MV Boli", 0, 14)); // NOI18N
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        lblDia.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblDia.setText("Dia:");

        cbxDias.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        cbxDias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SEGUNDA-FEIRA", "TERÇA-FEIRA", "QUARTA-FEIRA", "QUINTA-FEIRA", "SEXTA-FEIRA" }));

        lblTurno.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblTurno.setText("Turno:");

        cbxTurnos.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        cbxTurnos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MATUTINO", "VESPERTINO", "NOTURNO" }));

        lblSemestre.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblSemestre.setText("Semestre:");

        spnAno.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N

        spnSemestre.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N

        lblBarra.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblBarra.setText("/");

        pnlAulas.setBackground(new java.awt.Color(0, 204, 102));
        pnlAulas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Aulas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("MV Boli", 0, 14))); // NOI18N

        cxhAula1.setBackground(new java.awt.Color(0, 204, 102));
        cxhAula1.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        cxhAula1.setText("Aula 1");

        chxAula2.setBackground(new java.awt.Color(0, 204, 102));
        chxAula2.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        chxAula2.setText("Aula 2");

        chxAula3.setBackground(new java.awt.Color(0, 204, 102));
        chxAula3.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        chxAula3.setText("Aula 3");

        chxAula4.setBackground(new java.awt.Color(0, 204, 102));
        chxAula4.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        chxAula4.setText("Aula 4");

        chxAula5.setBackground(new java.awt.Color(0, 204, 102));
        chxAula5.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        chxAula5.setText("Aula 5");

        chxAula6.setBackground(new java.awt.Color(0, 204, 102));
        chxAula6.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        chxAula6.setText("Aula 6");

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
                        .addComponent(cxhAula1)
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
                    .addComponent(cxhAula1)
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

        btnAdicionar.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        btnAdicionar.setText("Adicionar");
        btnAdicionar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnAlterar.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        pnlDescricao.setBackground(new java.awt.Color(0, 204, 102));
        pnlDescricao.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descrição", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 0, 14))); // NOI18N

        txtAreaDescricao.setColumns(20);
        txtAreaDescricao.setRows(5);
        jScrollPane2.setViewportView(txtAreaDescricao);

        javax.swing.GroupLayout pnlDescricaoLayout = new javax.swing.GroupLayout(pnlDescricao);
        pnlDescricao.setLayout(pnlDescricaoLayout);
        pnlDescricaoLayout.setHorizontalGroup(
            pnlDescricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
        );
        pnlDescricaoLayout.setVerticalGroup(
            pnlDescricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );

        lblNomeRestricao.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lblNomeRestricao.setText("Nome:");

        txtNomeRestricao.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N

        pnlPrioridade.setBackground(new java.awt.Color(0, 204, 102));
        pnlPrioridade.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Prioridade", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 0, 14))); // NOI18N

        rbtnBaixa.setBackground(new java.awt.Color(0, 204, 102));
        btnGroupPrioridade.add(rbtnBaixa);
        rbtnBaixa.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        rbtnBaixa.setText("Baixa");

        rbtnMedia.setBackground(new java.awt.Color(0, 204, 102));
        btnGroupPrioridade.add(rbtnMedia);
        rbtnMedia.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        rbtnMedia.setText("Média");

        rbtnAlta.setBackground(new java.awt.Color(0, 204, 102));
        btnGroupPrioridade.add(rbtnAlta);
        rbtnAlta.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        rbtnAlta.setText("Alta");

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
                            .addComponent(btnAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRemover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addGroup(pnlRestricoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxTurnos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNomeRestricao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNomeRestricao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addGroup(pnlRestricoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlRestricoesLayout.createSequentialGroup()
                                .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(pnlDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlGeralLayout = new javax.swing.GroupLayout(pnlGeral);
        pnlGeral.setLayout(pnlGeralLayout);
        pnlGeralLayout.setHorizontalGroup(
            pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGeralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlRodape, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlRodape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
        if(professor != null){
            setarCamposComInstancia();
        }else{
           
        }
    }
    
    public void setarCamposComInstancia(){
        selecionarTipoCoordenador();
        txtNome.setText(professor.getNome());
        txtMatricula.setText(professor.getMatricula());
       
    }
    
    public void selecionarTipoCoordenador(){
        
       
    }  
    
    public void preencherComboCoordenadorias(){
        
        //if(listaCoordenadorias == null){
            listaCoordenadorias = ctrlPrincipal.getCtrlCoordenadoria().filtrarCoordenadoresNulos();
            //cbxCoordenadoria.setModel(new DefaultComboBoxModel(listaCoordenadorias.toArray())); 
        //}else
            //cbxCoordenadoria.setModel(new DefaultComboBoxModel(listaCoordenadorias.toArray())); 
    }

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        
       // String tipo = (String) cbxTipo.getSelectedItem();
        String nome = txtNome.getText();
        String matricula = txtMatricula.getText();
        //String login = txtUsuario.getText();
        //String senha = txtSenha.getText();
        //Professor professor = (Professor) cbxProfessor.getSelectedItem();
       // Coordenadoria coordenadoria = (Coordenadoria) cbxCoordenadoria.getSelectedItem();
        
        //if(professor == null)   
            //ctrlPrincipal.getCtrlCoordenador().cadastrar(professor, coordenadoria, tipo, login, senha, nome, matricula);  
        //else
            //ctrlPrincipal.getCtrlCoordenador().alterar(professor, coordenadoria, professor, tipo, login, senha, nome, matricula);   
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.ButtonGroup btnGroupPrioridade;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbxCoordenadoria;
    private javax.swing.JComboBox<String> cbxDias;
    private javax.swing.JComboBox<String> cbxTurnos;
    private javax.swing.JCheckBox chxAula2;
    private javax.swing.JCheckBox chxAula3;
    private javax.swing.JCheckBox chxAula4;
    private javax.swing.JCheckBox chxAula5;
    private javax.swing.JCheckBox chxAula6;
    private javax.swing.JCheckBox cxhAula1;
    private javax.swing.JList<String> jList1;
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
    private javax.swing.JPanel pnlAulas;
    private javax.swing.JPanel pnlDadosPessoais;
    private javax.swing.JPanel pnlDescricao;
    private javax.swing.JPanel pnlGeral;
    private javax.swing.JPanel pnlPrioridade;
    private javax.swing.JPanel pnlRestricoes;
    private javax.swing.JPanel pnlRodape;
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

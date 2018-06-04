package cci;

import cdp.Curso;
import cdp.Disciplina;
import cdp.MatrizCurricular;
import cgt.Constantes;
import cih.disciplina.JDBuscarDisciplina;
import cih.disciplina.JDCadastrarDisciplina;
import java.awt.Frame;
import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTable;

public class CtrlDisciplina extends CtrlGenerica{
    
    private CtrlPrincipal ctrlPrincipal;
    private JDBuscarDisciplina buscaDisciplina;
    private JDCadastrarDisciplina cadastraDisciplina;
    private Curso cursoSelecionado;

    public CtrlDisciplina(CtrlPrincipal ctrl) {
        this.ctrlPrincipal = ctrl;
    }
    
    public Image setarIconeJanela() {
        ImageIcon icone = new ImageIcon("build/classes/cih/img/matriz_curricular.png");
        return icone.getImage();
    }
    
    public void transitarTelas(JTable tabela, Frame pai){
        
        try {
            Disciplina disciplina = (Disciplina) JTableUtil.getDadosLinhaSelecionada(tabela);
            instanciarTelaCadastroDisciplina(disciplina, pai);
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            CtrlMensagem.exibirMensagemErro(buscaDisciplina, "Selecione uma disciplina");
        }
    }
    
    public void instanciarTelaBuscaDisciplina(Frame pai) {
        buscaDisciplina = new JDBuscarDisciplina(pai, true, ctrlPrincipal);
        buscaDisciplina.setIconImage(setarIconeJanela());
        buscaDisciplina.preencherComboCurso();
        buscaDisciplina.atualizarTabela();
        buscaDisciplina.setVisible(true);
        
    }

    public void instanciarTelaCadastroDisciplina(Disciplina disciplina, Frame pai) {
        cadastraDisciplina = new JDCadastrarDisciplina(pai, true, ctrlPrincipal, disciplina);
        cadastraDisciplina.setIconImage(setarIconeJanela());
        identificarOrigem(disciplina);
        cadastraDisciplina.setVisible(true);
    }
    
    public void cadastrar(String nome, String tipo, int periodo, int cargaHoraria, int qtAulas, MatrizCurricular matriz, String sigla) {

        String resposta = ctrlPrincipal.getGtPrincipal().getGtDisciplina().cadastrar(nome, tipo, periodo, cargaHoraria, qtAulas, matriz, sigla);

        if (resposta.equals(Constantes.CADASTRADO)) {
            CtrlMensagem.exibirMensagemSucesso(cadastraDisciplina, "Cadastrado com sucesso!");
            cadastraDisciplina.limparCampos();
            buscaDisciplina.atualizarTabela();
        } else
            CtrlMensagem.exibirMensagemErro(cadastraDisciplina, resposta);
    }
    
    public void alterar(String nome, String tipo, int periodo, int cargaHoraria, int qtAulas, MatrizCurricular matriz, Disciplina disciplina, String sigla) {

        String resposta = ctrlPrincipal.getGtPrincipal().getGtDisciplina().alterar(nome, tipo, periodo, cargaHoraria, qtAulas, matriz, disciplina, sigla);
        
        if (resposta.equals(Constantes.ALTERADO)) {
            CtrlMensagem.exibirMensagemSucesso(cadastraDisciplina, "Alterado Com sucesso!");
            cadastraDisciplina.desabilitarCampos();
            cadastraDisciplina.desabilitarCombos();
            buscaDisciplina.atualizarTabela();
        } else 
            CtrlMensagem.exibirMensagemErro(cadastraDisciplina, resposta);
    }
    
    public List filtrarPorMatrizPeriodo(int matriz, int periodo){
        return ctrlPrincipal.getGtPrincipal().getGtDisciplina().filtrarPorMatrizPeriodo(matriz, periodo);
    }
    
    public void excluir(JTable tabela) {

        try {
            Disciplina disciplina = (Disciplina) JTableUtil.getDadosLinhaSelecionada(tabela);
            int confirmacao = CtrlMensagem.exibirMensagemConfirmacao(buscaDisciplina, "Confirmar Exclusão ?");
            if (confirmacao == 0) {
                String resposta = ctrlPrincipal.getGtPrincipal().getGtDisciplina().excluir(disciplina);
                if (resposta.equals(Constantes.EXCLUIDO)) {
                    CtrlMensagem.exibirMensagemSucesso(buscaDisciplina, "Excluído com sucesso!");
                    buscaDisciplina.atualizarTabela();
                } else 
                    CtrlMensagem.exibirMensagemErro(buscaDisciplina, resposta);
            }
        } catch (Exception ex) {
            CtrlMensagem.exibirMensagemErro(buscaDisciplina, "Selecione uma disciplina");
        }   
    }
    
    public void filtrarPorMatrizPeriodo(String coluna, int idMatriz, JTable tabela, int periodo){
        
        List listaDisciplinas = ctrlPrincipal.getGtPrincipal().getGtDisciplina().filtrarPorMatrizPeriodo(coluna, idMatriz, periodo);
        listarEmTabela(listaDisciplinas, tabela, buscaDisciplina, "toArray");
        
        if(listaDisciplinas.isEmpty())
            buscaDisciplina.setarMensagem("Nenhuma disciplina encontrada.");
    }
    
    public void filtrarPorTipoPeriodo(String tipo, int idMatriz, JTable tabela, int periodo){
        
        List listaDisciplinas = ctrlPrincipal.getGtPrincipal().getGtDisciplina().filtrarPorTipoPeriodo(tipo, idMatriz, periodo);
        listarEmTabela(listaDisciplinas, tabela, buscaDisciplina, "toArray");
        
        if(listaDisciplinas.isEmpty())
            buscaDisciplina.setarMensagem("Nenhuma disciplina encontrada.");
    }
    
    //======================================= TELA DE CADASTRO ===============================================
    
    public void validarOperacao(MatrizCurricular matriz, String nome, String tipo, int periodo, int cargaHoraria, int qtAulas, String sigla){  
        
        Disciplina disciplina = cadastraDisciplina.getDisciplina();
        
        if(validarCampos(nome)){
            
            if(disciplina == null)   
                cadastrar(nome, tipo, periodo, cargaHoraria, qtAulas, matriz, sigla);
            else
                alterar(nome, tipo, periodo, cargaHoraria, qtAulas, matriz, disciplina, sigla);
        }else
            CtrlMensagem.exibirMensagemAviso(cadastraDisciplina, "Todos os campos devem ser preenchidos");
    }
    
    public void identificarOrigem(Disciplina disciplina){
        cadastraDisciplina.preencherComboCurso();
        if(disciplina != null){
            cadastraDisciplina.setDisciplina(disciplina);
            cadastraDisciplina.setarCurso(disciplina);
            cadastraDisciplina.setarMatriz();
            cadastraDisciplina.setarTipo();
            cadastraDisciplina.desabilitarCamposIniciais();
            cadastraDisciplina.setarCamposComInstancia(disciplina);
        }
    }
    
    public void preencherComboCurso(JComboBox cbxCurso, JComboBox cbxMatriz){ 
        
        List listaCursos = ctrlPrincipal.getCtrlCurso().listar();
        if(cadastraDisciplina != null)
            cadastraDisciplina.setListaCursos(listaCursos);
        preencherCombo(cbxCurso, listaCursos);
        
        if(!listaCursos.isEmpty()){
            
            Curso curso = (Curso) cbxCurso.getSelectedItem();
            
            if(getCursoSelecionado() == null)
                setCursoSelecionado(curso);
            
            if(cadastraDisciplina != null){
                cadastraDisciplina.setarPeriodoMaximo(curso.getQtPeriodos());
                setarCursoCadastro(cbxCurso, cbxMatriz);
                preencherComboMatriz(getCursoSelecionado().getId(), cbxMatriz);
            }else
                preencherComboMatriz(curso.getId(), cbxMatriz);
        }
    }

    public void preencherComboMatriz(int id, JComboBox cbxMatriz) {
        
        List listaMatriz = ctrlPrincipal.getCtrlMatriz().filtrarMatrizCurso(id);
        cbxMatriz.removeAllItems();
        
        if(cadastraDisciplina != null){
            cadastraDisciplina.setListaMatriz(listaMatriz);
            cadastraDisciplina.setarPeriodoMaximo(getCursoSelecionado().getQtPeriodos());
        }
        preencherCombo(cbxMatriz, listaMatriz);   
    }
    
    public void setarCurso(Disciplina disciplina, JComboBox cbxCurso, JComboBox cbxMatriz){
        
        List listaCursos = cadastraDisciplina.getListaCursos();
        Curso curso;

        for (int i = 0; i < listaCursos.size(); i++) {

            curso = (Curso) listaCursos.get(i);
            if (curso.getId() == disciplina.getMatriz().getCurso().getId()) {
                cbxCurso.setSelectedIndex(i);
                preencherComboMatriz(curso.getId(), cbxMatriz);
                break;
            }
        }
    }
    
    public void setarCursoCadastro(JComboBox cbxCurso, JComboBox cbxMatriz){
        
        List listaCursos = cadastraDisciplina.getListaCursos();
        Curso curso;

        for (int i = 0; i < listaCursos.size(); i++) {

            curso = (Curso) listaCursos.get(i);
            if (curso.getId() == getCursoSelecionado().getId()) {
                cadastraDisciplina.setarPeriodoMaximo(getCursoSelecionado().getQtPeriodos());
                cbxCurso.setSelectedIndex(i);
                preencherComboMatriz(curso.getId(), cbxMatriz);
                break;
            }
        }
    }
    
    public void setarMatriz(JComboBox cbxMatriz){
        
        List listaMatriz = cadastraDisciplina.getListaMatriz();
        Disciplina disciplina = cadastraDisciplina.getDisciplina();
        
        MatrizCurricular matriz;
        
        for (int i = 0; i < listaMatriz.size(); i++) {

            matriz = (MatrizCurricular) listaMatriz.get(i);
            if (matriz.getId() == disciplina.getMatriz().getId()) {
                cbxMatriz.setSelectedIndex(i);
                break;
            }
        }
    }
    
    public void setarTipo(JComboBox cbxTipo){
        
        Disciplina disciplina = cadastraDisciplina.getDisciplina();
        
        switch (disciplina.getTipo()) {
            
            case "OBRIGATÓRIA":
                cbxTipo.setSelectedIndex(0);
                break;
            case "OPTATIVA":
                cbxTipo.setSelectedIndex(1);
                break; 
            default:
                cbxTipo.setSelectedIndex(2);
                break;
        }
    }
    
    public void adicionarMatriz(String nome, int ano, int semestre, Curso curso, JComboBox cbxMatriz){
        
        int resposta = ctrlPrincipal.getCtrlMatriz().cadastrar(nome, ano, semestre, curso);
        
        if(resposta == 0){
            cadastraDisciplina.limparCamposMatriz();
            preencherComboMatriz(curso.getId(), cbxMatriz);  
        }    
    }
    
    public void removerMatriz(JComboBox cbxCurso, JComboBox cbxMatriz){
        
        try{
            MatrizCurricular matriz = (MatrizCurricular) cbxMatriz.getSelectedItem();
            if(matriz != null){
                int confirmacao = CtrlMensagem.exibirMensagemConfirmacao(cadastraDisciplina, "Confirmar Exclusão ?");
                if (confirmacao == 0) {

                    int resposta = ctrlPrincipal.getCtrlMatriz().excluir(matriz);
                    if (resposta == 0) {
                        Curso curso = (Curso) cbxCurso.getSelectedItem();
                        preencherComboMatriz(curso.getId(), cbxMatriz);
                    }
                }
            }else
                CtrlMensagem.exibirMensagemAviso(cadastraDisciplina, "Lista de matrizes vazia");
        }catch(Exception e){
            CtrlMensagem.exibirMensagemAviso(cadastraDisciplina, "Lista de matrizes vazia");
        }
    }
    
    public boolean validarCampos(String nome){
        
        if((nome.equals("")))
            return false;
        return true;
    } 

    public Curso getCursoSelecionado() {
        return cursoSelecionado;
    }

    public void setCursoSelecionado(Curso cursoSelecionado) {
        this.cursoSelecionado = cursoSelecionado;
    }

}

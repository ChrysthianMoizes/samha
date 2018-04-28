package cci;

import cdp.Curso;
import cdp.Disciplina;
import cdp.MatrizCurricular;
import cgt.Constantes;
import cgt.GtDisciplina;
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
    private GtDisciplina gtDisciplina;
    private JDBuscarDisciplina buscaDisciplina;
    private JDCadastrarDisciplina cadastraDisciplina;

    public CtrlDisciplina(CtrlPrincipal ctrl) {
        this.ctrlPrincipal = ctrl;
        gtDisciplina = new GtDisciplina();
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
        buscaDisciplina.setVisible(true);
    }

    public void instanciarTelaCadastroDisciplina(Disciplina disciplina, Frame pai) {
        cadastraDisciplina = new JDCadastrarDisciplina(pai, true, ctrlPrincipal, disciplina);
        cadastraDisciplina.setIconImage(setarIconeJanela());
        identificarOrigem(disciplina);
        cadastraDisciplina.setVisible(true);
    }
    
    public void cadastrar(String nome, String tipo, int periodo, int cargaHoraria, int qtAulas, MatrizCurricular matriz) {

        String resposta = gtDisciplina.cadastrar(nome, tipo, periodo, cargaHoraria, qtAulas, matriz);

        if (resposta.equals(Constantes.CADASTRADO)) {
            CtrlMensagem.exibirMensagemSucesso(cadastraDisciplina, "Cadastrado com sucesso!");
            cadastraDisciplina.limparCampos();
            buscaDisciplina.atualizarTabela();
        } else
            CtrlMensagem.exibirMensagemErro(cadastraDisciplina, resposta);
    }
    
    public void alterar(String nome, String tipo, int periodo, int cargaHoraria, int qtAulas, MatrizCurricular matriz, Disciplina disciplina) {

        String resposta = gtDisciplina.alterar(nome, tipo, periodo, cargaHoraria, qtAulas, matriz, disciplina);
        
        if (resposta.equals(Constantes.ALTERADO)) {
            CtrlMensagem.exibirMensagemSucesso(cadastraDisciplina, "Alterado Com sucesso!");
            cadastraDisciplina.desabilitarCampos();
            cadastraDisciplina.desabilitarCombos();
            buscaDisciplina.atualizarTabela();
        } else 
            CtrlMensagem.exibirMensagemErro(cadastraDisciplina, resposta);
    }
    
    public List filtrarPorMatrizPeriodo(int matriz, int periodo){
        return gtDisciplina.filtrarPorMatrizPeriodo(matriz, periodo);
    }
    
    public void excluir(JTable tabela) {

        try {
            Disciplina disciplina = (Disciplina) JTableUtil.getDadosLinhaSelecionada(tabela);
            int confirmacao = CtrlMensagem.exibirMensagemConfirmacao(buscaDisciplina, "Confirmar Exclusão ?");
            if (confirmacao == 0) {
                String resposta = gtDisciplina.excluir(disciplina);
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
    
    public void listarDisciplinas(String coluna, String texto, JTable tabela){
        
        List listaDisciplinas = gtDisciplina.buscar(coluna, texto);
        listarEmTabela(listaDisciplinas, tabela, buscaDisciplina, "toArray");
        
        if(listaDisciplinas.size() == 0)
            buscaDisciplina.setarMensagem("Nenhuma disciplina encontrada.");
    }
    
    //======================================= TELA DE CADASTRO ===============================================
    
    public void validarOperacao(MatrizCurricular matriz, String nome, String tipo, int periodo, int cargaHoraria, int qtAulas){  
        
        Disciplina disciplina = cadastraDisciplina.getDisciplina();
        
        if(validarCampos(nome)){
            
            if(disciplina == null)   
                cadastrar(nome, tipo, periodo, cargaHoraria, qtAulas, matriz);
            else
                alterar(nome, tipo, periodo, cargaHoraria, qtAulas, matriz, disciplina);
        }else
            CtrlMensagem.exibirMensagemAviso(cadastraDisciplina, "Todos os campos devem ser preenchidos");
    }
    
    public void identificarOrigem(Disciplina disciplina){
        cadastraDisciplina.preencherComboCurso();
        if(disciplina != null){
            cadastraDisciplina.setDisciplina(disciplina);
            cadastraDisciplina.setarCamposComInstancia(disciplina);
            cadastraDisciplina.setarCurso(disciplina);
            cadastraDisciplina.setarMatriz();
            cadastraDisciplina.setarTipo();
            cadastraDisciplina.desabilitarCamposIniciais();
        }
    }
    
    public void preencherComboCurso(JComboBox cbxCurso, JComboBox cbxMatriz){ 
        
        List listaCursos = ctrlPrincipal.getCtrlCurso().listar();
        if(cadastraDisciplina != null)
            cadastraDisciplina.setListaCursos(listaCursos);
        preencherCombo(cbxCurso, listaCursos);
        
        if(listaCursos.size() > 0){
            
            Curso curso = (Curso) cbxCurso.getSelectedItem();
            
            if(cadastraDisciplina != null)
                cadastraDisciplina.setarPeriodoMaximo(curso.getQtPeriodos());
            
            preencherComboMatriz(curso.getId(), cbxMatriz);
        }
    }

    public void preencherComboMatriz(int id, JComboBox cbxMatriz) {
        
        List listaMatriz = ctrlPrincipal.getCtrlMatriz().filtrarMatrizCurso(id);
        if(cadastraDisciplina != null){
            cadastraDisciplina.setListaMatriz(listaMatriz);
            cbxMatriz.removeAllItems();
        }
        if(listaMatriz.size() > 0)
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
        
        if(disciplina.getTipo().equals("OBRIGATÓRIA")){
            cbxTipo.setSelectedIndex(0);
        }else if(disciplina.getTipo().equals("OPTATIVA")){
            cbxTipo.setSelectedIndex(1);
        }else{
            cbxTipo.setSelectedIndex(2);
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
}

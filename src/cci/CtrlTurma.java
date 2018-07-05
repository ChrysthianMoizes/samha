package cci;

import cdp.Curso;
import cdp.MatrizCurricular;
import cdp.Turma;
import cgt.Constantes;
import cih.turma.JDBuscarTurma;
import cih.turma.JDCadastrarTurma;
import java.awt.Frame;
import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTable;

public class CtrlTurma extends CtrlGenerica{
    
    private CtrlPrincipal ctrlPrincipal;
    private JDBuscarTurma buscaTurma;
    private JDCadastrarTurma cadastraTurma;

    public CtrlTurma(CtrlPrincipal ctrl) {
        this.ctrlPrincipal = ctrl;
    }
    
    public Image setarIconeJanela() {
        ImageIcon icone = new ImageIcon("src/cih/img/turma.png");
        return icone.getImage();
    }
    
    public void transitarTelas(JTable tabela, Frame pai){
        
        try {
            Turma turma = (Turma) JTableUtil.getDadosLinhaSelecionada(tabela);
            instanciarTelaCadastroTurma(turma, pai);
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            CtrlMensagem.exibirMensagemErro(buscaTurma, "Selecione uma turma");
        }
    }
    
    public void instanciarTelaBuscaTurma(Frame pai) {
        buscaTurma = new JDBuscarTurma(pai, true, ctrlPrincipal);
        buscaTurma.setIconImage(setarIconeJanela());
        buscaTurma.atualizarTabela();
        buscaTurma.setVisible(true);
    }

    public void instanciarTelaCadastroTurma(Turma turma, Frame pai) {
        cadastraTurma = new JDCadastrarTurma(pai, true, ctrlPrincipal, turma);
        cadastraTurma.setIconImage(setarIconeJanela());
        identificarOrigem(turma);
        cadastraTurma.setVisible(true);
    }
    
    public void cadastrar(String nome, String turno, int ano, int semestre, MatrizCurricular matriz) {

        String resposta = ctrlPrincipal.getGtPrincipal().getGtTurma().cadastrar(nome, turno, ano, semestre, matriz);

        if (resposta.equals(Constantes.CADASTRADO)) {
            CtrlMensagem.exibirMensagemSucesso(cadastraTurma, "Cadastrado com sucesso!");
            cadastraTurma.desabilitarCampos();
            buscaTurma.atualizarTabela();
        } else {
            CtrlMensagem.exibirMensagemErro(cadastraTurma, resposta);
        }
    }
    
    public void alterar(String nome, String turno ,int ano, int semestre, MatrizCurricular matriz, Turma turma) {

        String resposta = ctrlPrincipal.getGtPrincipal().getGtTurma().alterar(nome, turno, ano, semestre, matriz, turma);
        
        if (resposta.equals(Constantes.ALTERADO)) {
            CtrlMensagem.exibirMensagemSucesso(cadastraTurma, "Alterado Com sucesso!");
            cadastraTurma.desabilitarCampos();
            buscaTurma.atualizarTabela();
        } else 
            CtrlMensagem.exibirMensagemErro(cadastraTurma, resposta);
    }
    
    public void listarTurmas(String coluna, String texto, JTable tabela, JCheckBox chxAtiva){
        
        List listaTurmas = ctrlPrincipal.getGtPrincipal().getGtTurma().buscar(coluna, texto);
        
        if(chxAtiva.isSelected()){
            int ano = buscaTurma.getAno();
            int semestre = buscaTurma.getSemestre();
            listaTurmas = ctrlPrincipal.getGtPrincipal().getGtTurma().filtrarTurmasAtivas(listaTurmas, ano, semestre);
        }
        
        listarEmTabela(listaTurmas, tabela, buscaTurma, "toArray");
        
        if(listaTurmas.isEmpty())
            buscaTurma.setarMensagem("Nenhuma turma encontrada.");
    }
    
    public List listar(){
        return ctrlPrincipal.getGtPrincipal().getGtTurma().listar();
    }
    
    public List<Turma> buscar(String coluna, String texto) {
        return ctrlPrincipal.getGtPrincipal().getGtTurma().buscar(coluna, texto);
    }
    
    public List<Turma> filtrarPorCurso(int id) {
        return ctrlPrincipal.getGtPrincipal().getGtTurma().buscarPorCurso(id);
    }
    
    public List<Turma> filtrarPorEixo(int id) {
        return ctrlPrincipal.getGtPrincipal().getGtTurma().buscarPorEixo(id);
    }
    
    public void excluir(JTable tabela) {

        try {
            Turma turma = (Turma) JTableUtil.getDadosLinhaSelecionada(tabela);
            int confirmacao = CtrlMensagem.exibirMensagemConfirmacao(buscaTurma, "Confirmar Exclusão ?");
            if (confirmacao == 0) {
                String resposta = ctrlPrincipal.getGtPrincipal().getGtTurma().excluir(turma);
                if (resposta.equals(Constantes.EXCLUIDO)) {
                    CtrlMensagem.exibirMensagemSucesso(buscaTurma, "Excluído com sucesso!");
                    buscaTurma.atualizarTabela();
                } else 
                    CtrlMensagem.exibirMensagemErro(buscaTurma, resposta);
            }
        } catch (Exception ex) {
            CtrlMensagem.exibirMensagemErro(buscaTurma, "Selecione uma turma");
        }   
    }
    
    public void setarTurmaSelecionada(Turma turmaSelecionada, List<Turma> listaTurmas, JComboBox cbxTurma, boolean alterandoAnoSemestre){
        
        if(alterandoAnoSemestre && turmaSelecionada != null){
            for(int indice = 0; indice < listaTurmas.size(); indice++){
                Turma turmaLista = listaTurmas.get(indice);
                if(turmaLista.getId() == turmaSelecionada.getId()){
                    cbxTurma.setSelectedIndex(indice);
                    break;
                }
            }
        }
    }
    
    // ========================================= TELA DE CADASTRO ======================================================
    
    public void validarOperacao(MatrizCurricular matriz, String nome, String turno, int ano, int semestre){  
        
        Turma turma = cadastraTurma.getTurma();
        
        if(validarCampos(nome)){
            
            if(turma == null)   
                cadastrar(nome, turno, ano, semestre, matriz);
            else
                alterar(nome, turno, ano, semestre, matriz, turma);
        }else
            CtrlMensagem.exibirMensagemAviso(cadastraTurma, "Todos os campos devem ser preenchidos");
    }
    
    public void identificarOrigem(Turma turma){
        cadastraTurma.preencherComboCurso();
        if(turma != null){
            cadastraTurma.setTurma(turma);
            cadastraTurma.setarCamposComInstancia(turma);
            cadastraTurma.setarCurso(turma);
            cadastraTurma.setarMatriz();
            cadastraTurma.setarTurno();
        }
    }
    
    public void preencherComboCurso(JComboBox cbxCurso, JComboBox cbxMatriz){ 
        
        List listaCursos = ctrlPrincipal.getCtrlCurso().listar();
        if((cadastraTurma != null) && (cadastraTurma.isVisible()))
            cadastraTurma.setListaCursos(listaCursos);
        preencherCombo(cbxCurso, listaCursos);
        
        if(cadastraTurma != null){
            if(listaCursos.size() > 0){
                Curso curso = (Curso) cbxCurso.getSelectedItem();
                preencherComboMatriz(curso.getId(), cbxMatriz);
            }
        }
    }

    public void preencherComboMatriz(int id, JComboBox cbxMatriz) {
        
        List listaMatriz = ctrlPrincipal.getCtrlMatriz().filtrarMatrizCurso(id);
        if((cadastraTurma != null) && (cadastraTurma.isVisible()))
            cadastraTurma.setListaMatriz(listaMatriz);
        
        if(listaMatriz.size() > 0)
            preencherCombo(cbxMatriz, listaMatriz);   
    }
    
    public void setarCurso(Turma turma, JComboBox cbxCurso, JComboBox cbxMatriz){
        
        List listaCursos = ctrlPrincipal.getCtrlCurso().listar();
        
        Curso curso;

        for (int i = 0; i < listaCursos.size(); i++) {

            curso = (Curso) listaCursos.get(i);
            if (curso.getId() == turma.getMatriz().getCurso().getId()) {
                cbxCurso.setSelectedIndex(i);
                preencherComboMatriz(curso.getId(), cbxMatriz);
                break;
            }
        }
    }
    
    public void setarMatriz(JComboBox cbxMatriz){
               
        Turma turma = cadastraTurma.getTurma();
        List listaMatriz = ctrlPrincipal.getCtrlMatriz().filtrarMatrizCurso(turma.getMatriz().getCurso().getId());
        
        MatrizCurricular matriz;
        
        for (int i = 0; i < listaMatriz.size(); i++) {

            matriz = (MatrizCurricular) listaMatriz.get(i);
            if (matriz.getId() == turma.getMatriz().getId()) {
                cbxMatriz.setSelectedIndex(i);
                break;
            }
        }
    }
    
    public void setarTurno(JComboBox cbxTurno){
        
        Turma turma = cadastraTurma.getTurma();
        
        switch (turma.getTurno()) {
            case "MATUTINO":
                cbxTurno.setSelectedIndex(0);
                break;
            case "VESPERTINO":
                cbxTurno.setSelectedIndex(1);
                break; 
            default:
                cbxTurno.setSelectedIndex(2);
                break;
        }
    }
    
    public boolean validarCampos(String nome){
        
        if((nome.equals("")))
            return false;
        return true;
    }
}

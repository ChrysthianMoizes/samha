package cci;

import cdp.Curso;
import cdp.MatrizCurricular;
import cdp.Turma;
import cgt.Constantes;
import cgt.GtTurma;
import cih.turma.JDBuscarTurma;
import cih.turma.JDCadastrarTurma;
import java.awt.Frame;
import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTable;

public class CtrlTurma extends CtrlGenerica{
    
    private CtrlPrincipal ctrlPrincipal;
    private GtTurma gtTurma;
    private JDBuscarTurma buscaTurma;
    private JDCadastrarTurma cadastraTurma;

    public CtrlTurma(CtrlPrincipal ctrl) {
        this.ctrlPrincipal = ctrl;
        gtTurma = new GtTurma();
    }
    
    public Image setarIconeJanela() {
        ImageIcon icone = new ImageIcon("build/classes/cih/img/turma.png");
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
        buscaTurma.setVisible(true);
    }

    public void instanciarTelaCadastroTurma(Turma turma, Frame pai) {
        cadastraTurma = new JDCadastrarTurma(pai, true, ctrlPrincipal, turma);
        cadastraTurma.setIconImage(setarIconeJanela());
        identificarOrigem(turma);
        cadastraTurma.setVisible(true);
    }
    
    public void cadastrar(String nome, String turno, int ano, int semestre, MatrizCurricular matriz) {

        String resposta = gtTurma.cadastrar(nome, turno, ano, semestre, matriz);

        if (resposta.equals(Constantes.CADASTRADO)) {
            CtrlMensagem.exibirMensagemSucesso(cadastraTurma, "Cadastrado com sucesso!");
            cadastraTurma.desabilitarCampos();
            buscaTurma.atualizarTabela();
        } else {
            CtrlMensagem.exibirMensagemErro(cadastraTurma, resposta);
        }
    }
    
    public void alterar(String nome, String turno ,int ano, int semestre, MatrizCurricular matriz, Turma turma) {

        String resposta = gtTurma.alterar(nome, turno, ano, semestre, matriz, turma);
        
        if (resposta.equals(Constantes.ALTERADO)) {
            CtrlMensagem.exibirMensagemSucesso(cadastraTurma, "Alterado Com sucesso!");
            cadastraTurma.desabilitarCampos();
            buscaTurma.atualizarTabela();
        } else 
            CtrlMensagem.exibirMensagemErro(cadastraTurma, resposta);
    }
    
    public void listarTurmas(String coluna, String texto, JTable tabela){
        List listaTurmas = gtTurma.buscar(coluna, texto);
        listarEmTabela(listaTurmas, tabela, buscaTurma);
    }
    
    public List<Turma> buscar(String coluna, String texto) {
        return gtTurma.buscar(coluna, texto);
    }
    
    public List<Turma> buscarPorCurso(int id) {
        return gtTurma.buscarPorCurso(id);
    }
    
    public void excluir(JTable tabela) {

        try {
            Turma turma = (Turma) JTableUtil.getDadosLinhaSelecionada(tabela);
            int confirmacao = CtrlMensagem.exibirMensagemConfirmacao(buscaTurma, "Confirmar Exclusão ?");
            if (confirmacao == 0) {
                String resposta = gtTurma.excluir(turma);
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
        if(cadastraTurma != null)
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
        if(cadastraTurma != null)
            cadastraTurma.setListaMatriz(listaMatriz);
        
        if(listaMatriz.size() > 0)
            preencherCombo(cbxMatriz, listaMatriz);   
    }
    
    public void setarCurso(Turma turma, JComboBox cbxCurso, JComboBox cbxMatriz){
        
        List listaCursos = cadastraTurma.getListaCursos();
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
        
        List listaMatriz = cadastraTurma.getListaMatriz();
        Turma turma = cadastraTurma.getTurma();
        
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
        
        if(turma.getTurno().equals("MATUTINO")){
            cbxTurno.setSelectedIndex(0);
        }else if(turma.getTurno().equals("VESPERTINO")){
            cbxTurno.setSelectedIndex(1);
        }else{
            cbxTurno.setSelectedIndex(2);
        } 
    }
    
    public boolean validarCampos(String nome){
        
        if((nome.equals("")))
            return false;
        return true;
    }
}

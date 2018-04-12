package cci;

import cdp.Coordenadoria;
import cdp.Curso;
import cgt.Constantes;
import cgt.GtCurso;
import cih.curso.JDBuscarCurso;
import cih.curso.JDCadastrarCurso;
import java.awt.Frame;
import java.util.List;
import javax.swing.ImageIcon;

public class CtrlCurso {
    
    private CtrlPrincipal ctrlPrincipal;
    private JDBuscarCurso buscaCurso;
    private JDCadastrarCurso cadastraCurso;
    private GtCurso gtCurso;

    public CtrlCurso(CtrlPrincipal ctrl) {
        this.ctrlPrincipal = ctrl;
        gtCurso = new GtCurso();
    }
    
    public ImageIcon setarIconeJanela() {
        ImageIcon icone = new ImageIcon("build/classes/cih/img/curso.png");
        return icone;
    }
    
    public void instanciarTelaBuscaCurso(Frame pai) {
        buscaCurso = new JDBuscarCurso(pai, true, ctrlPrincipal);
        buscaCurso.setVisible(true);
    }

    public void instanciarTelaCadastroCurso(Curso curso, Frame pai) {
        cadastraCurso = new JDCadastrarCurso(pai, true, ctrlPrincipal, curso);
        cadastraCurso.setVisible(true);
    }
    
    public int cadastrar(String nome, String nivel, int periodos, Coordenadoria coordenadoria) {

        String resposta = gtCurso.cadastrar(nome, nivel, periodos, coordenadoria);

        if (resposta.equals(Constantes.CADASTRADO)) {
            ctrlPrincipal.getCtrlMensagem().exibirMensagemSucesso(cadastraCurso, "Cadastrado com sucesso!");
            return 0;
        } else {
            ctrlPrincipal.getCtrlMensagem().exibirMensagemErro(cadastraCurso, resposta);
            return 1;
        }
    }
    
    public int alterar(Curso curso, String nome, String nivel, int periodos, Coordenadoria coordenadoria) {

        String resposta = gtCurso.alterar(curso, nome, nivel, periodos, coordenadoria);
        
        if (resposta.equals(Constantes.ALTERADO)) {
            ctrlPrincipal.getCtrlMensagem().exibirMensagemSucesso(cadastraCurso, "Alterado Com sucesso!");
            return 0;
        } else {
            ctrlPrincipal.getCtrlMensagem().exibirMensagemErro(cadastraCurso, resposta);
            return 1;
        }
    }
    
    public List<Curso> buscar(String coluna, String texto) {
        return gtCurso.buscar(coluna, texto);
    }
    
    public List<Curso> listar() {
       return gtCurso.listar();
    }
    
    public void excluir(Curso curso) {

        String resposta = gtCurso.excluir(curso);
        if (resposta.equals(Constantes.EXCLUIDO)) {
            ctrlPrincipal.getCtrlMensagem().exibirMensagemSucesso(buscaCurso, "Excluído com sucesso!");
        } else {
            ctrlPrincipal.getCtrlMensagem().exibirMensagemErro(buscaCurso, resposta);
        }
    }    
}

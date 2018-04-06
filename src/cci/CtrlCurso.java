package cci;

import cdp.Curso;
import cgt.Constantes;
import cgt.GtCurso;
import cih.curso.JDBuscarCurso;
import cih.curso.JDCadastrarCurso;
import java.awt.Frame;
import java.util.List;

public class CtrlCurso {
    
    private CtrlPrincipal ctrlPrincipal;
    private JDBuscarCurso buscaCurso;
    private JDCadastrarCurso cadastraCurso;
    private GtCurso gtCurso;

    public CtrlCurso(CtrlPrincipal ctrl) {
        this.ctrlPrincipal = ctrl;
        gtCurso = new GtCurso();
    }
    
    public void instanciarTelaBuscaCurso(Frame pai) {
        buscaCurso = new JDBuscarCurso(pai, true, ctrlPrincipal);
        buscaCurso.setVisible(true);
    }

    public void instanciarTelaCadastroCurso(Curso curso, Frame pai) {
        cadastraCurso = new JDCadastrarCurso(pai, true, ctrlPrincipal, curso);
        cadastraCurso.setVisible(true);
    }
    
    public List<Curso> buscar(String coluna, String texto) {
        return gtCurso.buscar(coluna, texto);
    }
    
    public void excluir(Curso curso) {

        String resposta = gtCurso.excluir(curso);
        if (resposta.equals(Constantes.EXCLUIDO)) {
            ctrlPrincipal.getCtrlMensagem().exibirMensagemSucesso(buscaCurso, "Excluído com sucesso!");
        } else {
            ctrlPrincipal.getCtrlMensagem().exibirMensagemErro(buscaCurso, resposta);
        }
    }
    
    /*public void cadastrar(Professor professor, Coordenadoria coordenadoria, String tipo, String login, String senha, String nome, String matricula) {

        String resposta = gtCoordenador.cadastrar(professor, coordenadoria, tipo, login, senha, nome, matricula);

        if (resposta.equals(Constantes.CADASTRADO)) {
            ctrlPrincipal.getCtrlMensagem().exibirMensagemSucesso(cadastraCoord, "Cadastrado Com sucesso!");
        } else {
            ctrlPrincipal.getCtrlMensagem().exibirMensagemErro(cadastraCoord, resposta);
        }
    }

    public void alterar(Coordenador coordenador, Coordenadoria coordenadoria, Professor professor, String tipo, String login, String senha, String nome, String matricula) {

        String resposta = gtCoordenador.alterar(coordenador, coordenadoria, professor, tipo, login, senha, nome, matricula);
        if (resposta.equals(Constantes.ALTERADO)) {
            ctrlPrincipal.getCtrlMensagem().exibirMensagemSucesso(cadastraCoord, "Alterado Com sucesso!");
        } else {
            ctrlPrincipal.getCtrlMensagem().exibirMensagemErro(cadastraCoord, resposta);
        }
    }

    

    */
    
}

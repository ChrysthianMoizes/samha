package cci;

import cdp.Curso;
import cdp.MatrizCurricular;
import cdp.Turma;
import cgt.Constantes;
import cgt.GtTurma;
import cih.turma.JDBuscarTurma;
import cih.turma.JDCadastrarTurma;
import java.awt.Frame;
import java.util.List;
import javax.swing.ImageIcon;

public class CtrlTurma {
    
    private CtrlPrincipal ctrlPrincipal;
    private GtTurma gtTurma;
    private JDBuscarTurma buscaTurma;
    private JDCadastrarTurma cadastraTurma;

    public CtrlTurma(CtrlPrincipal ctrl) {
        this.ctrlPrincipal = ctrl;
        gtTurma = new GtTurma();
    }
    
    public ImageIcon setarIconeJanela() {
        ImageIcon icone = new ImageIcon("build/classes/cih/img/turma.png");
        return icone;
    }
    
    public void instanciarTelaBuscaTurma(Frame pai) {
        buscaTurma = new JDBuscarTurma(pai, true, ctrlPrincipal);
        buscaTurma.setVisible(true);
    }

    public void instanciarTelaCadastroTurma(Turma turma, Frame pai) {
        cadastraTurma = new JDCadastrarTurma(pai, true, ctrlPrincipal, turma);
        cadastraTurma.setVisible(true);
    }
    
    public int cadastrar(String nome, String turno, int ano, int semestre, Curso curso, MatrizCurricular matriz) {

        String resposta = gtTurma.cadastrar(nome, turno, ano, semestre, curso, matriz);

        if (resposta.equals(Constantes.CADASTRADO)) {
            ctrlPrincipal.getCtrlMensagem().exibirMensagemSucesso(cadastraTurma, "Cadastrado com sucesso!");
            return 0;
        } else {
            ctrlPrincipal.getCtrlMensagem().exibirMensagemErro(cadastraTurma, resposta);
            return 1;
        }
    }
    
    public int alterar(String nome, String turno ,int ano, int semestre, Curso curso, MatrizCurricular matriz, Turma turma) {

        String resposta = gtTurma.alterar(nome, turno, ano, semestre, curso, matriz, turma);
        
        if (resposta.equals(Constantes.ALTERADO)) {
            ctrlPrincipal.getCtrlMensagem().exibirMensagemSucesso(cadastraTurma, "Alterado Com sucesso!");
            return 0;
        } else {
            ctrlPrincipal.getCtrlMensagem().exibirMensagemErro(cadastraTurma, resposta);
            return 1;
        }
    }
    
    public List<Turma> buscar(String coluna, String texto) {
        return gtTurma.buscar(coluna, texto);
    }
    
    public void excluir(Turma turma) {

        String resposta = gtTurma.excluir(turma);
        if (resposta.equals(Constantes.EXCLUIDO)) {
            ctrlPrincipal.getCtrlMensagem().exibirMensagemSucesso(buscaTurma, "Excluído com sucesso!");
        } else {
            ctrlPrincipal.getCtrlMensagem().exibirMensagemErro(buscaTurma, resposta);
        }
    } 
}

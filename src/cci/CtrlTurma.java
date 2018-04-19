package cci;

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

public class CtrlTurma {
    
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
    
    public void instanciarTelaBuscaTurma(Frame pai) {
        buscaTurma = new JDBuscarTurma(pai, true, ctrlPrincipal);
        buscaTurma.setIconImage(setarIconeJanela());
        buscaTurma.setVisible(true);
    }

    public void instanciarTelaCadastroTurma(Turma turma, Frame pai) {
        cadastraTurma = new JDCadastrarTurma(pai, true, ctrlPrincipal, turma);
        cadastraTurma.setIconImage(setarIconeJanela());
        cadastraTurma.setVisible(true);
    }
    
    public int cadastrar(String nome, String turno, int ano, int semestre, MatrizCurricular matriz) {

        String resposta = gtTurma.cadastrar(nome, turno, ano, semestre, matriz);

        if (resposta.equals(Constantes.CADASTRADO)) {
            CtrlMensagem.exibirMensagemSucesso(cadastraTurma, "Cadastrado com sucesso!");
            return 0;
        } else {
            CtrlMensagem.exibirMensagemErro(cadastraTurma, resposta);
            return 1;
        }
    }
    
    public int alterar(String nome, String turno ,int ano, int semestre, MatrizCurricular matriz, Turma turma) {

        String resposta = gtTurma.alterar(nome, turno, ano, semestre, matriz, turma);
        
        if (resposta.equals(Constantes.ALTERADO)) {
            CtrlMensagem.exibirMensagemSucesso(cadastraTurma, "Alterado Com sucesso!");
            return 0;
        } else {
            CtrlMensagem.exibirMensagemErro(cadastraTurma, resposta);
            return 1;
        }
    }
    
    public List<Turma> buscar(String coluna, String texto) {
        return gtTurma.buscar(coluna, texto);
    }
    
    public List<Turma> buscarPorCurso(int id) {
        return gtTurma.buscarPorCurso(id);
    }
    
    public void excluir(Turma turma) {

        String resposta = gtTurma.excluir(turma);
        if (resposta.equals(Constantes.EXCLUIDO)) {
            CtrlMensagem.exibirMensagemSucesso(buscaTurma, "Excluído com sucesso!");
        } else {
            CtrlMensagem.exibirMensagemErro(buscaTurma, resposta);
        }
    } 
}

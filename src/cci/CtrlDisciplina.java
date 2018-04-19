package cci;

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

public class CtrlDisciplina {
    
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
    
    public void instanciarTelaBuscaDisciplina(Frame pai) {
        buscaDisciplina = new JDBuscarDisciplina(pai, true, ctrlPrincipal);
        buscaDisciplina.setIconImage(setarIconeJanela());
        buscaDisciplina.setVisible(true);
    }

    public void instanciarTelaCadastroDisciplina(Disciplina disciplina, Frame pai) {
        cadastraDisciplina = new JDCadastrarDisciplina(pai, true, ctrlPrincipal, disciplina);
        cadastraDisciplina.setIconImage(setarIconeJanela());
        cadastraDisciplina.setVisible(true);
    }
    
    public int cadastrar(String nome, String tipo, int periodo, int cargaHoraria, int qtAulas, MatrizCurricular matriz) {

        String resposta = gtDisciplina.cadastrar(nome, tipo, periodo, cargaHoraria, qtAulas, matriz);

        if (resposta.equals(Constantes.CADASTRADO)) {
            CtrlMensagem.exibirMensagemSucesso(cadastraDisciplina, "Cadastrado com sucesso!");
            return 0;
        } else {
            CtrlMensagem.exibirMensagemErro(cadastraDisciplina, resposta);
            return 1;
        }
    }
    
    public int alterar(String nome, String tipo, int periodo, int cargaHoraria, int qtAulas, MatrizCurricular matriz, Disciplina disciplina) {

        String resposta = gtDisciplina.alterar(nome, tipo, periodo, cargaHoraria, qtAulas, matriz, disciplina);
        
        if (resposta.equals(Constantes.ALTERADO)) {
            CtrlMensagem.exibirMensagemSucesso(cadastraDisciplina, "Alterado Com sucesso!");
            return 0;
        } else {
            CtrlMensagem.exibirMensagemErro(cadastraDisciplina, resposta);
            return 1;
        }
    }
    
    public List<Disciplina> buscar(String coluna, String texto) {
        return gtDisciplina.buscar(coluna, texto);
    }
    
    public void excluir(Disciplina disciplina) {

        String resposta = gtDisciplina.excluir(disciplina);
        if (resposta.equals(Constantes.EXCLUIDO)) {
            CtrlMensagem.exibirMensagemSucesso(buscaDisciplina, "Excluído com sucesso!");
        } else {
            CtrlMensagem.exibirMensagemErro(buscaDisciplina, resposta);
        }
    } 
}

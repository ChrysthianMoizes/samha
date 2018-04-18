package cci;

import cdp.Coordenadoria;
import cdp.Professor;
import cgt.Constantes;
import cgt.GtProfessor;
import cih.professor.JDBuscarProfessor;
import cih.professor.JDCadastrarProfessor;
import java.awt.Frame;
import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;

public class CtrlProfessor {

    private GtProfessor gtProfessor;
    private JDBuscarProfessor buscaProf;
    private JDCadastrarProfessor cadastraProf;
    private CtrlPrincipal ctrlPrincipal;

    public CtrlProfessor(CtrlPrincipal ctrl) {
        gtProfessor = new GtProfessor();
        ctrlPrincipal = ctrl;
    }
    
    public Image setarIconeJanela() {
        ImageIcon icone = new ImageIcon("build/classes/cih/img/professor.png");
        return icone.getImage();
    }

    public void instanciarTelaBuscaProfessor(Frame pai) {
        buscaProf = new JDBuscarProfessor(pai, true, ctrlPrincipal);
        buscaProf.setIconImage(setarIconeJanela());
        buscaProf.setVisible(true);
    }

    public void instanciarTelaCadastroProfessor(Professor prof, Frame pai) {
        cadastraProf = new JDCadastrarProfessor(pai, true, ctrlPrincipal, prof);
        cadastraProf.setIconImage(setarIconeJanela());
        cadastraProf.setVisible(true);
    }

    public List<Professor> buscar(String coluna, String texto) {
        return gtProfessor.buscar(coluna, texto);
    }

    public Professor cadastrar(String nome, String matricula, int cargaHoraria, Coordenadoria coordenadoria) {

        Professor professor = gtProfessor.cadastrar(nome, matricula, cargaHoraria, coordenadoria);
        if (professor != null) {
            ctrlPrincipal.getCtrlMensagem().exibirMensagemSucesso(cadastraProf, "Cadastrado com sucesso!");
            return professor;
        } else {
            ctrlPrincipal.getCtrlMensagem().exibirMensagemErro(cadastraProf, "Erro ao cadastrar");
            return null;
        }
    }

    public Professor alterar(String nome, String matricula, int cargaHoraria, Coordenadoria coordenadoria, Professor professor) {

        Professor prof = gtProfessor.alterar(nome, matricula, cargaHoraria, coordenadoria, professor);
        if (prof != null) {
            ctrlPrincipal.getCtrlMensagem().exibirMensagemSucesso(cadastraProf, "Alterado com sucesso!");
            return prof;
        }else{
            ctrlPrincipal.getCtrlMensagem().exibirMensagemErro(cadastraProf, "Erro ao alterar");
            return null;
        }
    }

    public List<Professor> consultar() {
        return gtProfessor.consultar();
    }

    public void excluir(Professor professor) {

        String resposta = gtProfessor.excluir(professor);
        if (resposta.equals(Constantes.EXCLUIDO)) {
            ctrlPrincipal.getCtrlMensagem().exibirMensagemSucesso(buscaProf, "Excluído com sucesso!");
        } else {
            ctrlPrincipal.getCtrlMensagem().exibirMensagemErro(buscaProf, resposta);
        }
    }
}

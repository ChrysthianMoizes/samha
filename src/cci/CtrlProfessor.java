package cci;

import cdp.Professor;
import cgt.GtProfessor;
import cih.professor.JDBuscarProfessor;
import cih.professor.JDCadastrarProfessor;
import java.awt.Frame;
import java.util.List;

public class CtrlProfessor {
    
    private GtProfessor gtProfessor;
    private JDBuscarProfessor buscaProf;
    private JDCadastrarProfessor cadastraProf;
    private CtrlPrincipal ctrlPrincipal;

    public CtrlProfessor(CtrlPrincipal ctrl) {
        gtProfessor = new GtProfessor();
        ctrlPrincipal = ctrl;
    }
    
    public void instanciarTelaBuscaProfessor(Frame pai){
        buscaProf = new JDBuscarProfessor(pai, true, ctrlPrincipal);
        buscaProf.setVisible(true);
    }
    
    public void instanciarTelaCadastroProfessor(Professor prof, Frame pai){
        cadastraProf = new JDCadastrarProfessor(pai, true, ctrlPrincipal, prof);
        cadastraProf.setVisible(true);
    }
    
    public List<Professor> buscar(String coluna, String texto) {
       return gtProfessor.buscar(coluna, texto);
    }
    
    public List<Professor> consultar(){
       return gtProfessor.consultar();
    }
    
    public void excluir(Professor professor){
        try{   
            gtProfessor.excluir(professor); 
            ctrlPrincipal.getCtrlMensagem().exibirMensagemSucesso(buscaProf, "Excluído com sucesso!");
        }catch(Exception e){
            ctrlPrincipal.getCtrlMensagem().exibirMensagemErro(buscaProf, e.getMessage());
        }
    }
}

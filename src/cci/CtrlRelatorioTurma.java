package cci;

import cdp.Curso;
import cdp.Eixo;
import cdp.Turma;
import java.util.List;
import javax.swing.JComboBox;

public class CtrlRelatorioTurma {
    
    private CtrlPrincipal ctrlPrincipal;
    
    public CtrlRelatorioTurma(CtrlPrincipal ctrl){
        this.ctrlPrincipal = ctrl;
    }
    
    public void identificarFiltroRelatorioTurma(JComboBox cbxEixo, JComboBox cbxCurso, JComboBox cbxTurma, int ano, int semestre, char tipo){
        
        Eixo eixo = (Eixo) cbxEixo.getSelectedItem();
        Curso curso = (Curso) cbxCurso.getSelectedItem();
        Turma turma = (Turma) cbxTurma.getSelectedItem();
        
        switch(tipo){
            
            case 'A': gerarRelatorioTodasTurmas(ano, semestre); break;
            case 'E': gerarRelatorioPorEixo(eixo, ano, semestre); break;
            case 'C': gerarRelatorioPorCurso(curso, ano, semestre); break;
            case 'T': gerarRelatorioPorTurma(turma, ano, semestre); break;
            default: break;
            
        }  
    }
    
    public void gerarRelatorioTodasTurmas(int ano, int semestre){
        
        List<Turma> turmas = ctrlPrincipal.getCtrlTurma().listar();
        for(Turma turma : turmas){
            gerarRelatorioPorTurma(turma, ano, semestre);
        }   
    }
    
    public void gerarRelatorioPorEixo(Eixo eixo, int ano, int semestre){
        
        if(eixo != null){
            List<Turma> turmas = ctrlPrincipal.getCtrlTurma().filtrarPorEixo(eixo.getId());
            for(Turma turma : turmas){
                gerarRelatorioPorTurma(turma, ano, semestre);
            }   
        } 
    }
    
    public void gerarRelatorioPorCurso(Curso curso, int ano, int semestre){
        
        if(curso != null){
            List<Turma> turmas = ctrlPrincipal.getCtrlTurma().filtrarPorCurso(curso.getId());
            for(Turma turma : turmas){
                gerarRelatorioPorTurma(turma, ano, semestre);
            }
        }
    }
    
    public void gerarRelatorioPorTurma(Turma turma, int ano, int semestre){

        if(turma != null){
            List lista = ctrlPrincipal.getCtrlAula().filtrarAulasTurmaAnoSemestre(ano, semestre, turma.getId());
         
            //tratar lista
            ctrlPrincipal.getCtrlRelatorio().gerarRelatorio(lista);
            
        }
    }
    
}

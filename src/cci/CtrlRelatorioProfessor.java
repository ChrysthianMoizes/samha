package cci;

import cdp.Coordenadoria;
import cdp.Eixo;
import cdp.Professor;
import java.util.List;
import javax.swing.JComboBox;

public class CtrlRelatorioProfessor {
    
    private CtrlPrincipal ctrlPrincipal;
    
    public CtrlRelatorioProfessor(CtrlPrincipal ctrl){
        this.ctrlPrincipal = ctrl;
    }
    
    public void identificarFiltroRelatorioProfessor(JComboBox cbxEixo, JComboBox cbxCoordenadoria, JComboBox cbxProfessor, int ano, int semestre, char tipo){
        
        Eixo eixo = (Eixo) cbxEixo.getSelectedItem();
        Coordenadoria coordenadoria = (Coordenadoria) cbxCoordenadoria.getSelectedItem();
        Professor professor = (Professor) cbxProfessor.getSelectedItem();
        
        switch(tipo){
            
            case 'A': gerarRelatorioTodosProfessores(ano, semestre); break;
            case 'E': gerarRelatorioPorEixo(eixo, ano, semestre); break;
            case 'C': gerarRelatorioPorCoordenadoria(coordenadoria, ano, semestre); break;
            case 'P': gerarRelatorioPorProfessor(professor, ano, semestre); break;
            default: break;
            
        }  
    }
    
    public void gerarRelatorioTodosProfessores(int ano, int semestre){
        
        List<Professor> listaProfessores = ctrlPrincipal.getCtrlProfessor().consultar();
        for(Professor prof : listaProfessores){
            gerarRelatorioPorProfessor(prof, ano, semestre);
        }   
    }
    
    public void gerarRelatorioPorEixo(Eixo eixo, int ano, int semestre){
        
        if(eixo != null){
            List<Professor> listaProfessores = ctrlPrincipal.getCtrlProfessor().filtrarPorEixo(eixo.getId());
            for(Professor prof : listaProfessores){
                gerarRelatorioPorProfessor(prof, ano, semestre);
            }   
        } 
    }
    
    public void gerarRelatorioPorCoordenadoria(Coordenadoria coordenadoria, int ano, int semestre){
        
        if(coordenadoria != null){
            List<Professor> listaProfessores = ctrlPrincipal.getCtrlProfessor().filtrarPorCoordenadoria(coordenadoria.getId());
            for(Professor prof : listaProfessores){
                gerarRelatorioPorProfessor(prof, ano, semestre);
            }
        }
    }
    
    public void gerarRelatorioPorProfessor(Professor professor, int ano, int semestre){

        if(professor != null){
            List[] aulas = ctrlPrincipal.getCtrlAula().filtrarOrdenarAulasDiaProfessorAnoSemestre(professor.getId(), ano, semestre);
            List lista = ctrlPrincipal.getCtrlRelatorio().preencherListaAulasVazias(aulas);
            ctrlPrincipal.getCtrlRelatorio().gerarRelatorio(lista);
        }
    }
    
}

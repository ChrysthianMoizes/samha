package cci;

import cdp.Coordenadoria;
import cdp.Eixo;
import cdp.Professor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
            
            case 'P':
                
                if(professor != null){
                    CtrlMensagem.exibirMensagemSucesso(null, "Gerando Relatório. Aguarde!");
                    gerarRelatorioPorProfessor(professor, ano, semestre);
                    CtrlMensagem.exibirMensagemSucesso(null, "Relatório Gerado com Sucesso!");
                }else
                    CtrlMensagem.exibirMensagemErro(null, "Professor não encontrado.");
                break;
                
            default: break;
        }  
    }
    
    public void gerarRelatorioTodosProfessores(int ano, int semestre){
        
        CtrlMensagem.exibirMensagemSucesso(null, "Gerando Relatório. Aguarde!");
        
        List<Professor> listaProfessores = ctrlPrincipal.getCtrlProfessor().consultar();
        for(Professor prof : listaProfessores){
            gerarRelatorioPorProfessor(prof, ano, semestre);
        } 
        
        CtrlMensagem.exibirMensagemSucesso(null, "Relatório Gerado com Sucesso!");
    }
    
    public void gerarRelatorioPorEixo(Eixo eixo, int ano, int semestre){
        
        if(eixo != null){
            CtrlMensagem.exibirMensagemSucesso(null, "Gerando Relatório. Aguarde!");
            
            List<Professor> listaProfessores = ctrlPrincipal.getCtrlProfessor().filtrarPorEixo(eixo.getId());
            for(Professor prof : listaProfessores){
                gerarRelatorioPorProfessor(prof, ano, semestre);
            }
            CtrlMensagem.exibirMensagemSucesso(null, "Relatório Gerado com Sucesso!");
        }else
            CtrlMensagem.exibirMensagemErro(null, "Eixo não encontrado."); 
    }
    
    public void gerarRelatorioPorCoordenadoria(Coordenadoria coordenadoria, int ano, int semestre){
        
        if(coordenadoria != null){
            CtrlMensagem.exibirMensagemSucesso(null, "Gerando Relatório. Aguarde!");
            
            List<Professor> listaProfessores = ctrlPrincipal.getCtrlProfessor().filtrarPorCoordenadoria(coordenadoria.getId());
            for(Professor prof : listaProfessores){
                gerarRelatorioPorProfessor(prof, ano, semestre);
            }
            CtrlMensagem.exibirMensagemSucesso(null, "Relatório Gerado com Sucesso!");
        }else
            CtrlMensagem.exibirMensagemErro(null, "Coordenadoria não encontrada.");
    }
    
    public void gerarRelatorioPorProfessor(Professor professor, int ano, int semestre){

        if(professor != null){
            List[] aulas = ctrlPrincipal.getCtrlAula().filtrarOrdenarAulasDiaProfessorAnoSemestre(professor.getId(), ano, semestre);
            List lista = ctrlPrincipal.getCtrlRelatorio().preencherListaAulasVazias(aulas);
            
            String nomeRelatorio = "relatorioProfessor";
            
            Map parametros = new HashMap();
            parametros.put("professor", professor.getNome());
            parametros.put("coordenadoria", professor.getCoordenadoria());
            String semestreCorrente = ano + "/" + semestre;
            parametros.put("ano", semestreCorrente);
            
            String nomeExport = "Professores/" + professor.getNome() + "-" + ano + "-" + semestre;
            
            ctrlPrincipal.getCtrlRelatorio().gerarRelatorio(lista, parametros, nomeRelatorio, nomeExport);
        }else
            CtrlMensagem.exibirMensagemErro(null, "Professor não encontrado.");
    }
}

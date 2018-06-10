package cci;

import cdp.Curso;
import cdp.Eixo;
import cdp.Turma;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
            case 'T': 
                
                if(turma != null){
                    CtrlMensagem.exibirMensagemSucesso(null, "Gerando Relatório. Aguarde!");
                    gerarRelatorioPorTurma(turma, ano, semestre);
                    CtrlMensagem.exibirMensagemSucesso(null, "Relatório Gerado com Sucesso!");
                }else
                    CtrlMensagem.exibirMensagemErro(null, "Turma não encontrada.");
                break;
                
            default: break;
            
        }  
    }
    
    public void gerarRelatorioTodasTurmas(int ano, int semestre){
        
        CtrlMensagem.exibirMensagemSucesso(null, "Gerando Relatório. Aguarde!");
        
        List<Turma> turmas = ctrlPrincipal.getCtrlTurma().listar();
        for(Turma turma : turmas){
            gerarRelatorioPorTurma(turma, ano, semestre);
        }
        
        CtrlMensagem.exibirMensagemSucesso(null, "Relatório Gerado com Sucesso!");
    }
    
    public void gerarRelatorioPorEixo(Eixo eixo, int ano, int semestre){
        
        if(eixo != null){
            
            CtrlMensagem.exibirMensagemSucesso(null, "Gerando Relatório. Aguarde!");
            
            List<Turma> turmas = ctrlPrincipal.getCtrlTurma().filtrarPorEixo(eixo.getId());
            for(Turma turma : turmas){
                gerarRelatorioPorTurma(turma, ano, semestre);
            }
            
            CtrlMensagem.exibirMensagemSucesso(null, "Relatório Gerado com Sucesso!");
        }else
            CtrlMensagem.exibirMensagemErro(null, "Eixo não encontrado."); 
    }
    
    public void gerarRelatorioPorCurso(Curso curso, int ano, int semestre){
        
        if(curso != null){
            
            CtrlMensagem.exibirMensagemSucesso(null, "Gerando Relatório. Aguarde!");
            
            List<Turma> turmas = ctrlPrincipal.getCtrlTurma().filtrarPorCurso(curso.getId());
            for(Turma turma : turmas){
                gerarRelatorioPorTurma(turma, ano, semestre);
            }
            
            CtrlMensagem.exibirMensagemSucesso(null, "Relatório Gerado com Sucesso!");
        }else
            CtrlMensagem.exibirMensagemErro(null, "Curso não encontrado.");
    }
    
    public void gerarRelatorioPorTurma(Turma turma, int ano, int semestre){

        if(turma != null){
            
            List[] aulas = ctrlPrincipal.getCtrlAula().filtrarOrdenarAulasTurmaDiaAnoSemestre(turma.getId(), ano, semestre);
            List lista = ctrlPrincipal.getCtrlRelatorio().preencherListaAulasVazias(aulas);
            
            String nomeRelatorio = "relatorioTurma";
            
            Map parametros = new HashMap();
            parametros.put("turma", turma.getNome());
            parametros.put("curso", turma.getMatriz().getCurso().getNome());
            String semestreCorrente = ano + "/" + semestre;
            parametros.put("ano", semestreCorrente);
            
            String nomeExport = "Turmas/" + turma.getNome() + "-" + ano + "-" + semestre;
            
            ctrlPrincipal.getCtrlRelatorio().gerarRelatorio(lista, parametros, nomeRelatorio, nomeExport);
        }else
            CtrlMensagem.exibirMensagemErro(null, "Turma não encontrada.");
    }
}

package cci;

import cdp.Curso;
import cdp.Eixo;
import cdp.Turma;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JComboBox;
import net.sf.jasperreports.engine.JRException;

public class CtrlRelatorioTurma {
    
    private CtrlPrincipal ctrlPrincipal;
    
    public CtrlRelatorioTurma(CtrlPrincipal ctrl){
        this.ctrlPrincipal = ctrl;
    }
    
    public void identificarFiltroRelatorioTurma(JComboBox cbxEixo, JComboBox cbxCurso, JComboBox cbxTurma, int ano, int semestre, char tipo){
        
        Eixo eixo = (Eixo) cbxEixo.getSelectedItem();
        Curso curso = (Curso) cbxCurso.getSelectedItem();
        Turma turma = (Turma) cbxTurma.getSelectedItem();
        
        try{
        
            CtrlMensagem.exibirMensagemSucesso(null, "Gerando Relatório. Aguarde!");
            
            switch(tipo){

                case 'A': gerarRelatorioTodasTurmas(ano, semestre); break;
                case 'E': gerarRelatorioPorEixo(eixo, ano, semestre); break;
                case 'C': gerarRelatorioPorCurso(curso, ano, semestre); break;
                case 'T': 

                    if(turma != null)
                       gerarRelatorioPorTurma(turma, ano, semestre); 
                    else
                        CtrlMensagem.exibirMensagemErro(null, "Turma não encontrada.");
                    break;

                default: break;    
            }
        
            CtrlMensagem.exibirMensagemSucesso(null, "Relatório Gerado com Sucesso!");
            
        }catch(JRException ex){
            CtrlMensagem.exibirMensagemErro(null, "Erro ao gerar Relatório: " + ex.getMessage());
        }
    }
    
    public void gerarRelatorioTodasTurmas(int ano, int semestre) throws JRException{
        
        List<Turma> turmas = ctrlPrincipal.getCtrlTurma().listar();  
        for(Turma turma : turmas){
            gerarRelatorioPorTurma(turma, ano, semestre);
        }
    }
    
    public void gerarRelatorioPorEixo(Eixo eixo, int ano, int semestre) throws JRException{
        
        if(eixo != null){
            
            List<Turma> turmas = ctrlPrincipal.getCtrlTurma().filtrarPorEixo(eixo.getId());
            for(Turma turma : turmas){
                gerarRelatorioPorTurma(turma, ano, semestre);
            }
               
        }else
            CtrlMensagem.exibirMensagemErro(null, "Eixo não encontrado."); 
    }
    
    public void gerarRelatorioPorCurso(Curso curso, int ano, int semestre) throws JRException{
        
        if(curso != null){
            
            List<Turma> turmas = ctrlPrincipal.getCtrlTurma().filtrarPorCurso(curso.getId());
            for(Turma turma : turmas){
                gerarRelatorioPorTurma(turma, ano, semestre);
            }
        }else
            CtrlMensagem.exibirMensagemErro(null, "Curso não encontrado.");
    }
    
    public void gerarRelatorioPorTurma(Turma turma, int ano, int semestre) throws JRException{

        if(turma != null){
            
            List[] aulas = ctrlPrincipal.getCtrlAula().filtrarOrdenarAulasTurmaDiaAnoSemestre(turma.getId(), ano, semestre);
            List lista = ctrlPrincipal.getCtrlRelatorio().preencherListaAulasVazias(aulas);
            
            String nomeRelatorio = "relatorioTurma";
            
            Map parametros = gerarHashTurma(turma, ano, semestre);
            
            String diretorio = ctrlPrincipal.getCtrlRelatorio().criarDiretorioArquivamento("Turmas", ano, semestre);
            String nomeExport = diretorio + turma.getNome() + "-" + ano + "-" + semestre + ".pdf";
            
            ctrlPrincipal.getCtrlRelatorio().gerarRelatorio(lista, parametros, nomeRelatorio, nomeExport);
        }else
            CtrlMensagem.exibirMensagemErro(null, "Turma não encontrada.");
    }
    
    public Map gerarHashTurma(Turma turma, int ano, int semestre){
        
        Map hash = new HashMap();
        hash.put("turma", turma.getNome());
        hash.put("curso", turma.getMatriz().getCurso().getNome());
        String semestreCorrente = ano + "/" + semestre;
        hash.put("ano", semestreCorrente);
            
        return hash;
    }
}

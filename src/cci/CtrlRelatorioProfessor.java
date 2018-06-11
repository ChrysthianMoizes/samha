package cci;

import cdp.Coordenadoria;
import cdp.Eixo;
import cdp.Professor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JComboBox;
import net.sf.jasperreports.engine.JRException;

public class CtrlRelatorioProfessor {
    
    private CtrlPrincipal ctrlPrincipal;
    
    public CtrlRelatorioProfessor(CtrlPrincipal ctrl){
        this.ctrlPrincipal = ctrl;
    }
    
    public void identificarFiltroRelatorioProfessor(JComboBox cbxEixo, JComboBox cbxCoordenadoria, JComboBox cbxProfessor, int ano, int semestre, char tipo){
        
        Eixo eixo = (Eixo) cbxEixo.getSelectedItem();
        Coordenadoria coordenadoria = (Coordenadoria) cbxCoordenadoria.getSelectedItem();
        Professor professor = (Professor) cbxProfessor.getSelectedItem();
        
        try {
        
            CtrlMensagem.exibirMensagemSucesso(null, "Gerando Relatório. Aguarde!");
            
            switch(tipo){

                case 'A': gerarRelatorioTodosProfessores(ano, semestre); break;
                case 'E': gerarRelatorioPorEixo(eixo, ano, semestre); break;
                case 'C': gerarRelatorioPorCoordenadoria(coordenadoria, ano, semestre); break;

                case 'P':

                    if(professor != null)
                        gerarRelatorioPorProfessor(professor, ano, semestre);
                    else
                        CtrlMensagem.exibirMensagemErro(null, "Professor não encontrado.");
                    break;

                default: break;
            }
            CtrlMensagem.exibirMensagemSucesso(null, "Relatório Gerado com Sucesso!");
        
        } catch (JRException ex) {
            CtrlMensagem.exibirMensagemErro(null, "Erro ao gerar Relatório: " + ex.getMessage());
        }
    }
    
    public void gerarRelatorioTodosProfessores(int ano, int semestre) throws JRException{

        List<Professor> listaProfessores = ctrlPrincipal.getCtrlProfessor().consultar();
        for(Professor prof : listaProfessores){
            gerarRelatorioPorProfessor(prof, ano, semestre);
        }
    }
    
    public void gerarRelatorioPorEixo(Eixo eixo, int ano, int semestre) throws JRException{
        
        if(eixo != null){
            
            List<Professor> listaProfessores = ctrlPrincipal.getCtrlProfessor().filtrarPorEixo(eixo.getId());  
            for(Professor prof : listaProfessores){
                gerarRelatorioPorProfessor(prof, ano, semestre);
            }
        }else
            CtrlMensagem.exibirMensagemErro(null, "Eixo não encontrado."); 
    }
    
    public void gerarRelatorioPorCoordenadoria(Coordenadoria coordenadoria, int ano, int semestre) throws JRException{
        
        if(coordenadoria != null){

            List<Professor> listaProfessores = ctrlPrincipal.getCtrlProfessor().filtrarPorCoordenadoria(coordenadoria.getId());  
            for(Professor prof : listaProfessores){
                gerarRelatorioPorProfessor(prof, ano, semestre);
            }            
        }else
            CtrlMensagem.exibirMensagemErro(null, "Coordenadoria não encontrada.");
    }
    
    public void gerarRelatorioPorProfessor(Professor professor, int ano, int semestre) throws JRException{

        if(professor != null){
            List[] aulas = ctrlPrincipal.getCtrlAula().filtrarOrdenarAulasDiaProfessorAnoSemestre(professor.getId(), ano, semestre);
            List lista = ctrlPrincipal.getCtrlRelatorio().preencherListaAulasVazias(aulas);
            
            String nomeRelatorio = "relatorioTeste";
            
            Map parametros = gerarHashProfessor(professor, ano, semestre);
            
            String diretorio = ctrlPrincipal.getCtrlRelatorio().criarDiretorioArquivamento("Professores", ano, semestre);
            String nomeExport = diretorio + professor.getNome() + "-" + ano + "-" + semestre + ".pdf";
            
            ctrlPrincipal.getCtrlRelatorio().gerarRelatorio(lista, parametros, nomeRelatorio, nomeExport);
        }else
            CtrlMensagem.exibirMensagemErro(null, "Professor não encontrado.");
    }
    
    public Map gerarHashProfessor(Professor professor, int ano, int semestre){
        
        Map hash = new HashMap();
        hash.put("professor", professor.getNome());
        hash.put("coordenadoria", professor.getCoordenadoria().getNome());
        String semestreCorrente = ano + "/" + semestre;
        hash.put("ano", semestreCorrente);

       return hash; 
    }
}

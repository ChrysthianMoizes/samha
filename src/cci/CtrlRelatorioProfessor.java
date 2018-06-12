package cci;

import cdp.Aula;
import cdp.Coordenadoria;
import cdp.Eixo;
import cdp.Professor;
import cih.relatorio.JDRelatorioProfessor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JComboBox;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRRuntimeException;

public class CtrlRelatorioProfessor {
    
    private CtrlPrincipal ctrlPrincipal;
    private String pastaRaiz = "Professores";
    
    public CtrlRelatorioProfessor(CtrlPrincipal ctrl){
        this.ctrlPrincipal = ctrl;
    }
    
    public void identificarFiltroRelatorioProfessor(JComboBox cbxEixo, JComboBox cbxCoordenadoria, JComboBox cbxProfessor, int ano, int semestre, char tipo, JDRelatorioProfessor janela){
        
        Eixo eixo = (Eixo) cbxEixo.getSelectedItem();
        Coordenadoria coordenadoria = (Coordenadoria) cbxCoordenadoria.getSelectedItem();
        Professor professor = (Professor) cbxProfessor.getSelectedItem();
        
        janela.gerandoRelatorio();
        
        try {

            switch(tipo){

                case 'A': gerarRelatorioTodosProfessores(ano, semestre); break;
                case 'E': gerarRelatorioPorEixo(eixo, ano, semestre); break;
                case 'C': gerarRelatorioPorCoordenadoria(coordenadoria, ano, semestre); break;

                case 'P':

                    if(professor != null)
                        gerarRelatorioPorProfessor(professor, ano, semestre);
                    else
                        CtrlMensagem.exibirMensagemErro(janela, "Professor não encontrado.");
                    break;

                default: break;
            }
            CtrlMensagem.exibirMensagemSucesso(janela, "Relatório Gerado com Sucesso!");

        } catch (JRException ex) {
            CtrlMensagem.exibirMensagemErro(janela, "Erro ao gerar Relatório: " + ex.getMessage());

        } catch (FileNotFoundException | JRRuntimeException e){
            CtrlMensagem.exibirMensagemAviso(janela, "Feche todos os relatórios de Professores antes de iniciar.");
        }

        janela.relatorioGerado();
    }
    
    public void gerarRelatorioTodosProfessores(int ano, int semestre) throws JRException, FileNotFoundException{

        List<Professor> listaProfessores = ctrlPrincipal.getCtrlProfessor().consultar();
        for(Professor prof : listaProfessores){
            gerarRelatorioPorProfessor(prof, ano, semestre);
        }
    }
    
    public void gerarRelatorioPorEixo(Eixo eixo, int ano, int semestre) throws JRException, FileNotFoundException{
        
        if(eixo != null){
            
            List<Professor> listaProfessores = ctrlPrincipal.getCtrlProfessor().filtrarPorEixo(eixo.getId());  
            for(Professor prof : listaProfessores){
                gerarRelatorioPorProfessor(prof, ano, semestre);
            }
        }else
            CtrlMensagem.exibirMensagemErro(null, "Eixo não encontrado."); 
    }
    
    public void gerarRelatorioPorCoordenadoria(Coordenadoria coordenadoria, int ano, int semestre) throws JRException, FileNotFoundException{
        
        if(coordenadoria != null){

            List<Professor> listaProfessores = ctrlPrincipal.getCtrlProfessor().filtrarPorCoordenadoria(coordenadoria.getId());  
            for(Professor prof : listaProfessores){
                gerarRelatorioPorProfessor(prof, ano, semestre);
            }            
        }else
            CtrlMensagem.exibirMensagemErro(null, "Coordenadoria não encontrada.");
    }
    
    public void gerarRelatorioPorProfessor(Professor professor, int ano, int semestre) throws JRException, FileNotFoundException{

        if(professor != null){
            List[] aulas = ctrlPrincipal.getCtrlAula().filtrarOrdenarAulasDiaProfessorAnoSemestre(professor.getId(), ano, semestre);
            List lista = ctrlPrincipal.getCtrlRelatorio().preencherListaAulasVazias(aulas);
            
            List relatorio = new ArrayList();
            relatorio.add(new Aula());
            
            String nomeRelatorio = "relatorioGenerico";
            
            Map parametros = gerarHashProfessor(professor, ano, semestre, lista);
            
            String diretorio = ctrlPrincipal.getCtrlRelatorio().obterDiretorioArquivamento(pastaRaiz, ano, semestre);
            String nomeExport = diretorio + professor.getNome() + "-" + ano + "-" + semestre + ".pdf";
            
            ctrlPrincipal.getCtrlRelatorio().gerarRelatorio(relatorio, parametros, nomeRelatorio, nomeExport);
        }else
            CtrlMensagem.exibirMensagemErro(null, "Professor não encontrado.");
    }
    
    public Map gerarHashProfessor(Professor professor, int ano, int semestre, List lista){
        
        Map hash = new HashMap();
        
        String anoSemestre = ano + "/" + semestre;
        hash.put("ano", anoSemestre);
        
        hash.put("nome", professor.getNome());
        hash.put("setor", professor.getCoordenadoria().getNome() + "\t" + anoSemestre);
        hash.putAll(transformarListaEmHash(lista));

       return hash; 
    }
    
    public Map transformarListaEmHash(List<Aula> lista){
        
        Map hash = new HashMap();
        
        for(Aula aula: lista){
            String key = String.valueOf(aula.getDia()) + String.valueOf(aula.getNumero());
            String turma = aula.getOferta().getTurma().getNome();
            String sigla = aula.getAlocacao().getDisciplina().getSigla();
            hash.put(key, turma + "\n" + sigla);
        }
        
        return hash;
    }
    
    public void abrirPastaProfessor(int ano, int semestre, JDRelatorioProfessor janela){
        
        String diretorio = ctrlPrincipal.getCtrlRelatorio().obterDiretorioArquivamento(pastaRaiz, ano, semestre);
        try {  
            Runtime.getRuntime().exec("explorer.exe " + diretorio.replace("/", "\\"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            CtrlMensagem.exibirMensagemErro(janela, "Não foi possível encontrar a pasta especificada.");
        }
    }
}

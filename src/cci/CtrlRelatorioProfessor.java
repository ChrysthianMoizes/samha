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
        List professores = obterListaProfessores(eixo, coordenadoria, professor, tipo);
        
        if(professores != null)
            iniciarThreadRelatorioProfessor(janela, professores, ano, semestre);

    }
    
    public void iniciarThreadRelatorioProfessor(JDRelatorioProfessor janela, List<Professor> listaProfessores, int ano, int semestre){
        
        new Thread() {
            @Override
            public void run() {
                try {
                    janela.gerandoRelatorio();
                   
                    for(Professor prof : listaProfessores){
                        gerarRelatorioPorProfessor(prof, ano, semestre);
                    }
                    
                    CtrlMensagem.exibirMensagemSucesso(janela, "Relatório Gerado com Sucesso!");
                    janela.relatorioGerado();
                } catch (JRException ex) {
                    janela.relatorioGerado();
                    CtrlMensagem.exibirMensagemErro(janela, "Erro ao gerar Relatório: " + ex.getMessage());

                } catch (FileNotFoundException | JRRuntimeException e){
                    janela.relatorioGerado();
                    CtrlMensagem.exibirMensagemAviso(janela, "Feche todos os relatórios de Professores antes de iniciar.");  
                }
            }
        }.start();
        
    }
    
    public List obterListaProfessores(Eixo eixo, Coordenadoria coordenadoria, Professor professor, char tipo){
        
        switch(tipo){

            case 'A': return listarTodosProfessores();
            case 'E': return listarProfessoresEixo(eixo);
            case 'C': return listarProfessoresCoordenadoria(coordenadoria);
            case 'P': 
                    if(professor != null){
                        List lista = new ArrayList();
                        lista.add(professor);
                        return lista;
                    }

            default: return null;
        }
    }
    
    public List listarTodosProfessores(){
        List<Professor> listaProfessores = ctrlPrincipal.getCtrlProfessor().consultar();
        return listaProfessores;
    }
    
    public List listarProfessoresEixo(Eixo eixo){
        
        if(eixo != null){
            
            List<Professor> listaProfessores = ctrlPrincipal.getCtrlProfessor().filtrarPorEixo(eixo.getId());  
            return listaProfessores;
        }else
            CtrlMensagem.exibirMensagemErro(null, "Eixo não encontrado.");
        return null;
    }
    
    public List listarProfessoresCoordenadoria(Coordenadoria coordenadoria){
        
        if(coordenadoria != null){
            List<Professor> listaProfessores = ctrlPrincipal.getCtrlProfessor().filtrarPorCoordenadoria(coordenadoria.getId());  
            return listaProfessores;
        }else
            CtrlMensagem.exibirMensagemErro(null, "Coordenadoria não encontrada.");
        return null;
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

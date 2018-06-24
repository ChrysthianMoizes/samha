package cci;

import cdp.Aula;
import cdp.Curso;
import cdp.Eixo;
import cdp.Turma;
import cih.relatorio.JDRelatorioTurma;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JComboBox;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRRuntimeException;

public class CtrlRelatorioTurma {
    
    private CtrlPrincipal ctrlPrincipal;
    private String pastaRaiz = "Turmas";
    
    public CtrlRelatorioTurma(CtrlPrincipal ctrl){
        this.ctrlPrincipal = ctrl;
    }
    
    public void identificarFiltroRelatorioTurma(JComboBox cbxEixo, JComboBox cbxCurso, JComboBox cbxTurma, int ano, int semestre, char tipo, JDRelatorioTurma janela){
        
        Eixo eixo = (Eixo) cbxEixo.getSelectedItem();
        Curso curso = (Curso) cbxCurso.getSelectedItem();
        Turma turma = (Turma) cbxTurma.getSelectedItem();
        
        List lista = obterListaTurmas(eixo, curso, turma, tipo);
        if(lista != null){
            if(!lista.isEmpty())
                iniciarThreadRelatorioTurma(janela, lista, ano, semestre);
            else
                CtrlMensagem.exibirMensagemAviso(janela, "Nenhuma turma encontrada.");
        }else
            CtrlMensagem.exibirMensagemAviso(janela, "Nenhuma turma encontrada.");    
    }
    
    public void iniciarThreadRelatorioTurma(JDRelatorioTurma janela, List<Turma> listaTurmas, int ano, int semestre){
        
        new Thread(){
            @Override
            public void run() {
                
                try{
            
                    janela.gerandoRelatorio();
                    
                    for(Turma turma : listaTurmas){
                        gerarRelatorioTurma(turma, ano, semestre);
                    }

                    janela.relatorioGerado();
                    CtrlMensagem.exibirMensagemSucesso(janela, "Relatório Gerado com Sucesso!");
                    
                }catch(JRException ex){
                    janela.relatorioGerado();
                    CtrlMensagem.exibirMensagemErro(janela, "Erro ao gerar Relatório: " + ex.getMessage());

                } catch (FileNotFoundException | JRRuntimeException e){
                    janela.relatorioGerado();
                    CtrlMensagem.exibirMensagemAviso(janela, "Feche todos os relatórios de Turmas antes de iniciar.");
                }  
            }
        }.start();
        
    }
    
    public List obterListaTurmas(Eixo eixo, Curso curso, Turma turma, char tipo){
        
        switch(tipo){

            case 'A': return listarTodasTurmas();
            case 'E': return listarTurmasEixo(eixo);
            case 'C': return listarTurmasCurso(curso);
            case 'T': 

                    if(turma != null){
                        List lista = new ArrayList();
                        lista.add(turma);
                        return lista;
                    }
            default: return null;    
        }
    }
    
    public List listarTodasTurmas(){
        
        List<Turma> turmas = ctrlPrincipal.getCtrlTurma().listar();  
        return turmas;
    }
    
    public List listarTurmasEixo(Eixo eixo){
        
        if(eixo != null){
            
            List<Turma> turmas = ctrlPrincipal.getCtrlTurma().filtrarPorEixo(eixo.getId());
            return turmas;
        }else
            CtrlMensagem.exibirMensagemErro(null, "Eixo não encontrado.");
        return null;
    }
    
    public List listarTurmasCurso(Curso curso){
        
        if(curso != null){
            
            List<Turma> turmas = ctrlPrincipal.getCtrlTurma().filtrarPorCurso(curso.getId());
            return turmas;
        }else
            CtrlMensagem.exibirMensagemErro(null, "Curso não encontrado.");
        return null;
    }
    
    public void gerarRelatorioTurma(Turma turma, int ano, int semestre) throws JRException, FileNotFoundException{

        if(turma != null){
            
            boolean estahAtiva = ctrlPrincipal.getGtPrincipal().getGtTurma().verificarTurmaAtiva(turma, ano, semestre);
            
            if(estahAtiva){
            
                List[] aulas = ctrlPrincipal.getCtrlAula().filtrarOrdenarAulasTurmaDiaAnoSemestre(turma.getId());
                List lista = ctrlPrincipal.getGtPrincipal().getGtRelatorio().preencherListaAulasVazias(aulas);

                List relatorio = new ArrayList();
                relatorio.add(new Aula());

                String nomeRelatorio = "relatorioGenerico";

                Map parametros = gerarHashTurma(turma, ano, semestre, lista);

                String diretorio = ctrlPrincipal.getCtrlRelatorio().obterDiretorioArquivamento(pastaRaiz, ano, semestre);
                String nomeExport = diretorio + turma.getNome() + "-" + ano + "-" + semestre + ".pdf";

                ctrlPrincipal.getCtrlRelatorio().gerarRelatorio(relatorio, parametros, nomeRelatorio, nomeExport);
            }
            
        }else
            CtrlMensagem.exibirMensagemErro(null, "Turma não encontrada.");
    }
    
    public Map gerarHashTurma(Turma turma, int ano, int semestre, List lista){
        
        Map hash = new HashMap();
        
        String periodoAtual = ctrlPrincipal.getGtPrincipal().getGtTurma().obterAnoPeriodoAtual(ano, semestre, turma);
        String anoSemestre = ano + "/" + semestre;
        
        hash.put("nome", turma.getNome() + " - " + periodoAtual);
        hash.put("setor", turma.getMatriz().getCurso().getNome() + "\t" + anoSemestre);
        hash.putAll(transformarListaEmHash(lista));
        return hash;
    }
    
    public Map transformarListaEmHash(List<Aula> lista){
        
        Map hash = new HashMap();
        
        for(Aula aula: lista){
            
            String professor = aula.getAlocacao().getProfessor1().getPrimeiroNome();
            String key = String.valueOf(aula.getDia()) + String.valueOf(aula.getNumero());
            String sigla = aula.getAlocacao().getDisciplina().getSigla();
            
            if(aula.getAlocacao().getProfessor2() != null){
                professor = professor + "|" + aula.getAlocacao().getProfessor2().getPrimeiroNome();
            }  
            hash.put(key, sigla + "\n" + professor);
        }
        
        return hash;
    }
    
    public void abrirPastaTurma(int ano, int semestre, JDRelatorioTurma janela){
        
        String diretorio = ctrlPrincipal.getCtrlRelatorio().obterDiretorioArquivamento(pastaRaiz, ano, semestre);
        try {  
            Runtime.getRuntime().exec("explorer " + diretorio.replace("/", "\\"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            CtrlMensagem.exibirMensagemErro(janela, "Não foi possível encontrar a pasta especificada.");
        }
    }
}

package cgt;

import cdp.Alocacao;
import cdp.Aula;
import cdp.Disciplina;
import cdp.Oferta;
import cdp.Professor;
import cdp.Turma;
import java.util.ArrayList;
import java.util.List;

public class GtRelatorio {

    private GtPrincipal gtPrincipal;
    
    public GtRelatorio(GtPrincipal gt){
        gtPrincipal = gt;
    }
    
    public List preencherListaAulasVazias(List[] aulas){
    
        Aula aula;
        Aula[] vetorAulas;
        
        List lista = new ArrayList<>();
        
        for(int dia = 0; dia < Constantes.LINHA; dia++){
            
            vetorAulas = preencherVetorAulas(aulas[dia]);
            
            for(int numero = 0; numero < 16; numero++){
                
                aula = vetorAulas[numero];
                
                if(aula == null){
                    aula = gerarAulaVazia(dia, numero);
                }
                lista.add(aula);
            }
        }
        return lista;
    }
    
    public Aula[] preencherVetorAulas(List<Aula> lista){
    
        Aula[] vetorAulas = new Aula[16];
        
        for(Aula aula : lista){
            vetorAulas[aula.getNumero()] = aula;
        }
        return vetorAulas;
    }    
    
    public Aula gerarAulaVazia(int dia, int numero){
        
        Aula aula = new Aula();
        
        aula.setDia(dia);
        aula.setNumero(numero);
        aula.setAlocacao(gerarAlocacaoVazia());
        aula.setOferta(gerarOfertaVazia());
        return aula;
    }
    
    public Oferta gerarOfertaVazia(){
        
        Oferta oferta = new Oferta();
        oferta.setTurma(gerarTurmaVazia());
        return oferta;
    }
    
    public Turma gerarTurmaVazia(){
        
        Turma turma = new Turma();
        turma.setNome("");
        
        return turma;
    }
    
    public Alocacao gerarAlocacaoVazia(){
        
        Alocacao alocacao = new Alocacao();
        alocacao.setProfessor1(gerarProfessorVazio());
        alocacao.setProfessor2(null);
        alocacao.setDisciplina(gerarDisciplinaVazia());
        
        return alocacao;
    }
    
    public Disciplina gerarDisciplinaVazia(){
        
        Disciplina disciplina = new Disciplina();
        disciplina.setNome("");
        disciplina.setSigla("");
        
        return disciplina;
    }
    
    public Professor gerarProfessorVazio(){
        Professor professor = new Professor();
        professor.setNome("");
        return professor;
    }
    
    public boolean verificarTurmaAtiva(Turma turma, int anoAtual, int semestreAtual){
        
        int anoInicial = turma.getAno();
        int semestreInicial = turma.getSemestre();
        String p = null;
        
        if(turma.getMatriz().getCurso().getNivel().equals("ENSINO MÉDIO INTEGRADO")){
         
            p = calcularAnoAtual(anoAtual, anoInicial);
        }else{

            p = calcularPeriodoAtual(anoAtual, semestreAtual, anoInicial, semestreInicial);
        }
        
        int anoPeriodo = Integer.valueOf(p);
        
        if(anoPeriodo > turma.getMatriz().getCurso().getQtPeriodos())
            return false;
        
        return true;
    }
    
    public String obterAnoPeriodoAtual(int anoAtual, int semestreAtual, Turma turma){
        
        int anoInicial = turma.getAno();
        int semestreInicial = turma.getSemestre();
        
        String nivel = null;
        String periodoAtual = null;
        
        if(turma.getMatriz().getCurso().getNivel().equals("ENSINO MÉDIO INTEGRADO")){
            nivel = "º ANO";
            periodoAtual = calcularAnoAtual(anoAtual, anoInicial);
        }else{
            nivel = "º PERÍODO";
            periodoAtual = calcularPeriodoAtual(anoAtual, semestreAtual, anoInicial, semestreInicial);
        }

        return periodoAtual + nivel;
    }
    
    public String calcularAnoAtual(int anoAtual, int anoInicial){
        
        int qtAnos = (anoAtual - anoInicial) + 1;
        String ano = String.valueOf(qtAnos);
        
        return ano;
    }
    
    public String calcularPeriodoAtual(int anoAtual, int semestreAtual, int anoInicial, int semestreInicial){
        
        int qtAnos = ((anoAtual - anoInicial) * 2);
        
        if(semestreAtual == semestreInicial){
            qtAnos+=1;
        }else if(semestreAtual == 2 && semestreInicial == 1){
            qtAnos+=2;
        }
        
        String periodo = String.valueOf(qtAnos);
        
        return periodo;
    }
}

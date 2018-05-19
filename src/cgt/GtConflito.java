package cgt;

import cdp.Aula;
import cdp.Professor;
import cdp.RestricaoProfessor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GtConflito {
    
    private GtPrincipal gtPrincipal;
    private List[] vetor;
    
    public GtConflito(GtPrincipal gt) {
        this.gtPrincipal = gt;
    }
      
    public List validarOferta(Aula aula){
 
        Professor professor = aula.getAlocacao().getProfessor1();
        
        List mensagens = validar(aula, professor.getId(), 1);
        
        if(aula.getAlocacao().getDisciplina().getTipo().equals(Constantes.ESPECIAL)){
            Professor professor2 = aula.getAlocacao().getProfessor2();
            List msg = validar(aula, professor2.getId(), 2);
            mensagens.addAll(msg);
        }
   
        return mensagens;
    }
    
    public List validar(Aula aula, int idProfessor, int numeroProfessor){
        
        List mensagens = new ArrayList<>();
        
        String mensagemConflitoTurma = identificarConflitoTurma(aula, idProfessor);
        if(mensagemConflitoTurma != null) mensagens.add(mensagemConflitoTurma);
        
        //String mensagemConflitoInstituicao = identificarConflitoRestricaoInstituicao(aula, numeroProfessor);
        //if(mensagemConflitoInstituicao != null) mensagens.add(mensagemConflitoInstituicao);
        
        String mensagemConflitoRestricaoProfessor = identificarConflitoRestricaoProfessor(aula, idProfessor);
        if(mensagemConflitoRestricaoProfessor != null) mensagens.add(mensagemConflitoRestricaoProfessor);
        
        return mensagens;
    }
    
    public String identificarConflitoTurma(Aula aula, int idProfessor){
           
        List aulas = gtPrincipal.getGdPrincipal().getGdAula().identificarConflitoAula(aula.getAlocacao().getAno(), aula.getAlocacao().getSemestre(), 
                idProfessor, aula.getNumero(), aula.getDia(), aula.getTurno());
        
        if(aulas.size() <= 1){

            if(!aulas.isEmpty()){
                
                Aula aulaLista = (Aula) aulas.get(0);
                
                if(aulaLista.getId() == aula.getId())
                    return null;
                else
                    return montarMensagemConflitoTurma(aulas, aula);
            }else
                return null;
        }else
            return montarMensagemConflitoTurma(aulas, aula);
    }
    
    public String montarMensagemConflitoTurma(List aulas, Aula aulaAtual){
        
        Aula aula;
        String novaMensagem = "0 Professor está em outra turma neste horário: ";

        for(int i = 0; i < aulas.size(); i++){
            aula = (Aula) aulas.get(i);
            if(aula.getOferta().getTurma().getId() != aulaAtual.getOferta().getTurma().getId())
                novaMensagem = novaMensagem + aula.getOferta().getTurma().getNome() + " - " + aula.getAlocacao().getDisciplina().getNome() + ". ";           
        }     
        return novaMensagem;
    }
    
    public String identificarConflitoRestricaoInstituicao(Aula aula, int numeroProfessor){
        
        String mensagem = null;
        int idProfessor = aula.getAlocacao().getProfessor1().getId();
        
        if(numeroProfessor != 1)
            idProfessor = aula.getAlocacao().getProfessor2().getId();
        preencherVetorAulas(aula, idProfessor);
        
        return mensagem;
    }
    
    public void preencherVetorAulas(Aula aula, int idProfessor){
        
        int ano = aula.getAlocacao().getAno();
        int semestre = aula.getAlocacao().getSemestre();
        int dia = aula.getDia();
        
        vetor = new List[Constantes.LINHA];
        
        for(int linha = 0; linha < Constantes.LINHA; linha++){
            
            vetor[linha] = gtPrincipal.getGdPrincipal().getGdAula().filtrarAulasDiaProfessorAnoSemestre(linha, idProfessor, ano, semestre);
            
            if(dia == linha && aula.getId() == 0)
                vetor[linha].add(aula);
            
            Collections.sort(vetor[linha]);
        }
    }
    
    public String montarMensagemConflitoTempoMaximo(){
        
        List aulas;
        Aula primeiraAula, ultimaAula;
        double horarioInicial, horarioFinal, tempo;
        
        for(int dia = 0; dia < Constantes.LINHA; dia++){
            aulas = vetor[dia];
            
            if(aulas.size() > 1){
                primeiraAula = (Aula) aulas.get(0);
                ultimaAula = (Aula) aulas.get(aulas.size() - 1);
                horarioInicial = obterHorarioInicial(primeiraAula);
                horarioFinal = obterHorarioFinal(ultimaAula);
                tempo = horarioFinal - horarioInicial;
                
                if(tempo > primeiraAula.getOferta().getTempoMaximoTrabalho()){
                    return "TEM CONFLITO NESSA POHHA!";
                }
            }
        }
        return null;
    }
    
    public String montarMensagemConflitoIntervaloMinimo(){
        return null;
    }
    
    public double obterHorarioInicial(Aula aula){
        
        String turno = aula.getTurno();
        int numero = aula.getNumero();
        
        double horarioInicial = 5; // Horario.horarioInicial(numero + obterNumeroTurno(turno));
        
        return horarioInicial;
    }
    
    public double obterHorarioFinal(Aula aula){
        
        String turno = aula.getTurno();
        int numero = aula.getNumero();
        
        double horarioFinal = 5; // Horario.horarioFinal(numero + obterNumeroTurno(turno));
        
        return horarioFinal;
    }
    
    public int obterNumeroTurno(String turno){
        
        switch(turno){ 
            case Constantes.MATUTINO: return 0;
            case Constantes.VESPERTINO: return 6;
            default: return 12;    
        }
    }
        
    public String identificarConflitoRestricaoProfessor(Aula aula, int idProfessor){
        
        List listaRestricoes = gtPrincipal.getGdPrincipal().getGdRestricao().identificarConflitoRestricao(idProfessor, aula.getDia(), aula.getTurno());
        
        if(listaRestricoes.isEmpty()){
            return null;
        }else
            return montarMensagemConflitoRestricaoProfessor(listaRestricoes, aula);
    }
    
    public String montarMensagemConflitoRestricaoProfessor(List lista, Aula aula){
        
        boolean resposta; 
        RestricaoProfessor restricao;
                
        for(int i = 0; i < lista.size(); i++){

            restricao = (RestricaoProfessor) lista.get(i);
            resposta = identificarNumeroAulaConflitante(restricao, aula.getNumero());

            if(resposta) 
                return "1 " + restricao.getProfessor().getPrimeiroNome().toUpperCase() + " possui uma restrição neste horário: " + restricao.getNome().toUpperCase();    
        }
        return null;
    }
    
    public boolean identificarNumeroAulaConflitante(RestricaoProfessor restricao, int numero){
            
        switch(numero){

            case 0: return restricao.isAula1();
            case 1: return restricao.isAula2();
            case 2: return restricao.isAula3();
            case 3: return restricao.isAula4();
            case 4: return restricao.isAula5();
            case 5: return restricao.isAula6();
        }
        return false;
    }
    
}

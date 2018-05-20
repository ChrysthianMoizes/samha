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
        
        mensagem = identificarConflitoTempoMaximo();
        
        if(mensagem == null)
            mensagem = identificarConflitoIntervaloMinimo();
        
        return mensagem;
    }
    
    public void preencherVetorAulas(Aula aula, int idProfessor){
        
        int ano = aula.getAlocacao().getAno();
        int semestre = aula.getAlocacao().getSemestre();
        int dia = aula.getDia();
        List lista;
        
        vetor = new List[Constantes.LINHA];
        
        for(int linha = 0; linha < Constantes.LINHA; linha++){
            
            vetor[linha] = gtPrincipal.getGdPrincipal().getGdAula().filtrarAulasDiaProfessorAnoSemestre(linha, idProfessor, ano, semestre);
            
            if(dia == linha && aula.getId() == 0)
                vetor[linha].add(aula);
            
            lista = vetor[linha];
            Collections.sort(lista);
        }
    }
    
    public String identificarConflitoTempoMaximo(){
        
        List aulas;
        Aula primeiraAula, ultimaAula;
        double tempo;
        
        for(int dia = 0; dia < Constantes.LINHA; dia++){
            aulas = vetor[dia];
            
            if(aulas.size() > 1){
                
                primeiraAula = (Aula) aulas.get(0);
                ultimaAula = (Aula) aulas.get(aulas.size() - 1);
                
                tempo = calcularHoras(primeiraAula, ultimaAula);
                
                if(tempo > primeiraAula.getOferta().getTempoMaximoTrabalho())
                    return montarMensagemTempoMaximo(ultimaAula, primeiraAula);
            }
        }
        return null;
    }
    
    public String montarMensagemTempoMaximo(Aula ultima, Aula primeira){
        
        String mensagem = null;
        String nomeProfessor = ultima.getAlocacao().getProfessor1().getPrimeiroNome();
        
        String tipoUltima = ultima.getAlocacao().getDisciplina().getTipo();
        String tipoPrimeira = primeira.getAlocacao().getDisciplina().getTipo();
        
        String dia = obterStringDia(primeira.getDia());
        double horarioInicial = obterHorarioInicial(primeira);
        double horarioFinal = obterHorarioFinal(ultima);
        
        if(tipoUltima.equals(Constantes.ESPECIAL) || tipoPrimeira.equals(Constantes.ESPECIAL)){
            mensagem = "Um professor da disciplina ESPECIAL possui um tempo máximo de trabalho superior ao permitido: " 
                    + dia + " " + horarioInicial + " às " + horarioFinal + ".";
        }else{  
            mensagem = "O Professor " + nomeProfessor + " possui um tempo máximo de trabalho superior ao permitido: " 
                    + dia + " " + horarioInicial + " às " + horarioFinal + ".";     
        }
        return mensagem;
    }    
    
    public String identificarConflitoIntervaloMinimo(){
        
        List aulasDiaAtual, aulasDiaAnterior;
        Aula primeiraAula, ultimaAula;
        double tempo;
        
        for(int dia = 1; dia < Constantes.LINHA; dia++){
            
            aulasDiaAnterior = vetor[dia-1];
            aulasDiaAtual = vetor[dia];
            
            if(!aulasDiaAnterior.isEmpty() && !aulasDiaAtual.isEmpty()){
                
                ultimaAula = (Aula) aulasDiaAnterior.get(aulasDiaAnterior.size() - 1);
                primeiraAula = (Aula) aulasDiaAtual.get(0);
                
                tempo = calcularHoras(primeiraAula, ultimaAula);
                
                if(tempo < primeiraAula.getOferta().getIntervaloMinimo())
                    return montarMensagemIntervaloMinimo(ultimaAula, primeiraAula);
            }
        } 
        return null;
    }
    
    public String montarMensagemIntervaloMinimo(Aula ultima, Aula primeira){
    
        String mensagem = null;
        String nomeProfessor = ultima.getAlocacao().getProfessor1().getPrimeiroNome();
        
        String tipoUltima = ultima.getAlocacao().getDisciplina().getTipo();
        String tipoPrimeira = primeira.getAlocacao().getDisciplina().getTipo();
        
        String diaAnterior = obterStringDia(ultima.getDia());
        String diaAtual = obterStringDia(primeira.getDia());
        double horarioFinal = obterHorarioFinal(ultima);
        double horarioInicial = obterHorarioInicial(primeira);
     
        if(tipoUltima.equals(Constantes.ESPECIAL) || tipoPrimeira.equals(Constantes.ESPECIAL)){
            mensagem = "Um professor da disciplina ESPECIAL possui um intervalo mínimo de descanso inferior ao permitido: " 
                    + diaAnterior + " " + horarioFinal + " à " + diaAtual + " " + horarioInicial + ".";
        }else{  
            mensagem = "O Professor " + nomeProfessor + " possui um intervalo mínimo de descanso inferior ao permitido: " 
                    + diaAnterior + " " + horarioFinal + " à " + diaAtual + " " + horarioInicial + ".";     
        }
        return mensagem;
    }    
    
    public double obterHorarioInicial(Aula aula){
        
        String turno = aula.getTurno();
        int numero = aula.getNumero();
        
        double horarioInicial = Horarios.horarioInicial(numero + obterNumeroTurno(turno));
        
        return horarioInicial;
    }
    
    public double obterHorarioFinal(Aula aula){
        
        String turno = aula.getTurno();
        int numero = aula.getNumero();
        
        double horarioFinal = Horarios.horarioFinal(numero + obterNumeroTurno(turno));
        
        return horarioFinal;
    }
    
    public double calcularHoras(Aula primeira, Aula ultima){
        
        double horarioFinal = obterHorarioFinal(ultima);
        double horarioInicial = obterHorarioInicial(primeira);
        
        double tempo = horarioFinal - horarioInicial;
        
        return tempo;
    }
    
    public int obterNumeroTurno(String turno){
        
        switch(turno){ 
            case Constantes.MATUTINO: return 0;
            case Constantes.VESPERTINO: return 6;
            default: return 12;    
        }
    }
    
    public String obterStringDia(int dia){

        switch(dia){
            
            case 0:
                return Constantes.SEGUNDA;
            case 1:
                return Constantes.TERCA;
            case 2:
                return Constantes.QUARTA;
            case 3:
                return Constantes.QUINTA;    
            default:
                return Constantes.SEXTA; 
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

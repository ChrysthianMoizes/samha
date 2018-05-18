package cgt;

import cdp.Aula;
import cdp.Professor;
import cdp.RestricaoProfessor;
import java.util.List;

public class GtConflito {
    
    private GtPrincipal gtPrincipal;
    
    public GtConflito(GtPrincipal gt) {
        this.gtPrincipal = gt;
    }
    
    public String validarOferta(Aula aula){
        
        String mensagem = null;
        Professor professor = aula.getAlocacao().getProfessor1();
        
        mensagem = identificarConflitoTurma(aula, professor.getId(), mensagem, 1);
        
        if(aula.getAlocacao().getDisciplina().getTipo().toLowerCase().equals(Constantes.ESPECIAL))         
            mensagem = validarDisciplinaEspecial(mensagem, aula);
              
        return mensagem;
    }
    
    public String validarDisciplinaEspecial(String mensagem, Aula aula){
        
        Professor professor2 = aula.getAlocacao().getProfessor2();
        String mensagem2 = identificarConflitoTurma(aula, professor2.getId(), mensagem, 2);

        if(mensagem != null){
            if(mensagem2 != null)
                mensagem = mensagem + "\n\n" + identificarConflitoTurma(aula, professor2.getId(), mensagem, 2);
        }else
            mensagem = mensagem2;

        return mensagem;
    }
    
    public String identificarConflitoTurma(Aula aula, int idProfessor, String mensagem, int numeroProfessor){
        
        int ano = aula.getAlocacao().getAno();
        int semestre = aula.getAlocacao().getSemestre();
        int numero = aula.getNumero();
        int dia = aula.getDia();
        String turno = aula.getTurno();
        
        List aulas = gtPrincipal.getGdPrincipal().getGdAula().identificarConflitoAula(ano, semestre, idProfessor, numero, dia, turno);
        
        if(aulas.size() <= 1){
            
            List listaRestricoes = gtPrincipal.getGdPrincipal().getGdRestricao().identificarConflitoRestricao(idProfessor, dia, turno);
            
            if(aulas.isEmpty()){
                return montarMensagemRestricaoInstituicao(mensagem, listaRestricoes, aula, numeroProfessor); 
                
            }else{
                
                Aula aulaLista = (Aula) aulas.get(0);
                
                if(aulaLista.getId() == aula.getId())
                    return montarMensagemRestricaoInstituicao(mensagem, listaRestricoes, aula, numeroProfessor);
                else
                    return montarMensagemConflitoTurma(aulas, aula);
            }
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
    
    public String montarMensagemRestricaoInstituicao(String mensagem, List listaRestricoes, Aula aula, int numeroProfessor){
        
        List aulas;
        int ano = aula.getAlocacao().getAno();
        int semestre = aula.getAlocacao().getSemestre();
        
        if(numeroProfessor == 1)
            aulas = gtPrincipal.getGdPrincipal().getGdAula().filtrarAulasProfessor1AnoSemestre(aula.getAlocacao().getProfessor1().getId(), ano, semestre);
        else
            aulas = gtPrincipal.getGdPrincipal().getGdAula().filtrarAulasProfessor2AnoSemestre(aula.getAlocacao().getProfessor2().getId(), ano, semestre);
        
        //VERIFICAR SE AS AULAS DO PROFESSOR ESTÃO ULTRAPASSANDO O TEMPO MÁXIMO E O INTERVALO MÍNIMO
        
        if(mensagem == null)
            mensagem = montarMensagemConflitoRestricaoProfessor(mensagem, listaRestricoes, aula);
        
        return mensagem;
    }
    
    public String montarMensagemConflitoRestricaoProfessor(String mensagem, List listaRestricoes, Aula aula){
        if(listaRestricoes.isEmpty()){
            return null;
        }else
            return identificarConflitoRestricaoProfessor(listaRestricoes, aula, mensagem);
    }
    
    public String identificarConflitoRestricaoProfessor(List lista, Aula aula, String mensagem){
        
        boolean resposta; 
        RestricaoProfessor restricao;
                
        for(int i = 0; i < lista.size(); i++){

            restricao = (RestricaoProfessor) lista.get(i);
            resposta = identificarNumeroAulaConflitante(restricao, aula.getNumero());

            if(resposta) 
                return "1 " + restricao.getProfessor().getPrimeiroNome().toUpperCase() + " possui uma restrição neste horário: " + restricao.getNome().toUpperCase();    
        }
        return mensagem;
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

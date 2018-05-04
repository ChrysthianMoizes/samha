package cgt;

import cdp.Aula;
import cdp.Professor;
import cdp.RestricaoProfessor;
import cgd.GdAula;
import cgd.GdOferta;
import cgd.GdRestricao;
import java.util.List;

public class GtOferta {
    
    private GdOferta gdOferta;
    private GdAula gdAula;
    private GdRestricao gdRestricao;

    public GtOferta() {
        gdOferta = new GdOferta();
        gdAula = new GdAula();
        gdRestricao = new GdRestricao();
    }
    
    public String validarOferta(Aula aula){

        String mensagem = null;
        
        Professor professor = aula.getAlocacao().getProfessor1();
        Professor professor2;
        
        mensagem = identificarConflitoTurma(aula, professor.getId(), mensagem);
        
        if(aula.getAlocacao().getDisciplina().getTipo().toLowerCase().equals(Constantes.ESPECIAL)){
            professor2 = aula.getAlocacao().getProfessor2();
            mensagem = identificarConflitoTurma(aula, professor2.getId(), mensagem);
        }
        
        return mensagem;
    }
    
    public String identificarConflitoTurma(Aula aula, int idProfessor, String mensagem){
        
        int ano = aula.getAlocacao().getAno();
        int semestre = aula.getAlocacao().getSemestre();
        int numero = aula.getNumero();
        String dia = aula.getDia();
        String turno = aula.getTurno();
        
        List listaAulas = gdAula.identificarConflitoAula(ano, semestre, idProfessor, numero, dia, turno);

        if(listaAulas.size() == 0){

            List listaRestricoes = gdRestricao.identificarConflitoRestricao(idProfessor, dia, turno);

            if(listaRestricoes.size() == 0){
                return mensagem;

            }else
                return identificarConflitoRestricao(listaAulas, aula, mensagem);            
        }else {
            Aula a = (Aula) listaAulas.get(0);
            return "0 Professor está em outra turma neste horário: " + a.getOferta().getTurma().getNome() + " - " + a.getAlocacao().getDisciplina().getNome();       
        }
    }
    
    public String identificarConflitoRestricao(List lista, Aula aula, String mensagem){
        
        boolean resposta; 
        RestricaoProfessor restricao;
                
        for(int i = 0; i < lista.size(); i++){

            restricao = (RestricaoProfessor) lista.get(i);
            resposta = identificarNumeroAulaConflitante(restricao, aula.getNumero());

            if(resposta)
                return "1 Professor possui uma restrição neste horário: " + restricao.getNome().toUpperCase();    
        }
        return mensagem;
    }
    
    public boolean identificarNumeroAulaConflitante(RestricaoProfessor restricao, int numero){
            
        switch(numero){

            case 1: return restricao.isAula1();
            case 2: return restricao.isAula2();
            case 3: return restricao.isAula3();
            case 4: return restricao.isAula4();
            case 5: return restricao.isAula5();
            case 6: return restricao.isAula6();
        }
        return false;
    }
}

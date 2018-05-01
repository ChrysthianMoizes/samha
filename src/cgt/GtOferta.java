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
        
        String mensagem = "";
        
        Professor professor = aula.getAlocacao().getProfessor1(); 
        int ano = aula.getAlocacao().getAno();
        int semestre = aula.getAlocacao().getSemestre();
        int idProfessor = professor.getId();
        int numero = aula.getNumero();
        String dia = aula.getDia();
        String turno = aula.getTurno();
        
        List listaAulas = gdAula.filtrarParaValidacao(ano, semestre, idProfessor, numero, dia, turno);
        
        if(listaAulas.size() == 0){
            
            List listaRestricoes = gdRestricao.filtrarParaValidacao(idProfessor, dia, turno);
            
            if(listaRestricoes.size() == 0)
                return null;  
            
            else{
                
                RestricaoProfessor restricao;  
                boolean resposta; 
                
                for(int i = 0; i < listaRestricoes.size(); i++){
                    
                    restricao = (RestricaoProfessor) listaRestricoes.get(i);
                    resposta = identificarConflitoRestricao(restricao, aula);
                    
                    if(resposta){
                        mensagem = "1 Professor possui uma restrição neste horário: " + restricao.getNome().toUpperCase();
                        return mensagem;
                    }
                }
            }
            return null;
        }else{
            Aula a = (Aula) listaAulas.get(0);
            mensagem = "0 Professor está em outra turma neste horário: " + a.getOferta().getTurma().getNome() + " - " + a.getAlocacao().getDisciplina().getNome();       
            return mensagem;
        }
    }
    
    public boolean identificarConflitoRestricao(RestricaoProfessor restricao, Aula aula){
            
        switch(aula.getNumero()){

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

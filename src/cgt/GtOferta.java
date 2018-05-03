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
        boolean especial = false;
        
        List listaAulas;
        List listaRestricoes;
        RestricaoProfessor restricao;
        
        if(aula.getAlocacao().getDisciplina().getTipo().toLowerCase().equals(Constantes.ESPECIAL)){
            especial = true;
        }
        
        listaAulas = gdAula.filtrarParaValidacao(ano, semestre, idProfessor, numero, dia, turno);
        
        if(listaAulas.size() == 0){
            
            listaRestricoes = gdRestricao.filtrarParaValidacao(idProfessor, dia, turno);
            
            if(listaRestricoes.size() == 0){
                
                if(especial){
                    int idProfessor2 = aula.getAlocacao().getProfessor2().getId();
                    listaAulas = gdAula.filtrarParaValidacao(ano, semestre, idProfessor, numero, dia, turno);

                    if(listaAulas.size() == 0){
            
                        listaRestricoes = gdRestricao.filtrarParaValidacao(idProfessor2, dia, turno);
                        
                        if(listaRestricoes.size() == 0){
                            return null;
                            
                        }else{
                             
                            boolean resposta; 
                
                            for(int i = 0; i < listaRestricoes.size(); i++){
                    
                                restricao = (RestricaoProfessor) listaRestricoes.get(i);
                                resposta = identificarConflitoRestricao(restricao, aula);

                                if(resposta){
                                    mensagem = "Professor 2 possui uma restrição neste horário: " + restricao.getNome().toUpperCase();
                                    return "1 " + mensagem;
                                }
                            }
                        }
                            
                    }else {
                        Aula a = (Aula) listaAulas.get(0);
                        mensagem = "Professor 2 está em outra turma neste horário: " + a.getOferta().getTurma().getNome() + " - " + a.getAlocacao().getDisciplina().getNome();       
                        return "0 " + mensagem;
                    }     
                }        
                return null;
                
            }else{

                boolean resposta; 
                
                for(int i = 0; i < listaRestricoes.size(); i++){
                    
                    restricao = (RestricaoProfessor) listaRestricoes.get(i);
                    resposta = identificarConflitoRestricao(restricao, aula);
                    
                    if(resposta){
                        mensagem = "Professor possui uma restrição neste horário: " + restricao.getNome().toUpperCase();
                        return "1 " + mensagem;
                    }
                }
            }
            return null;
        }else{
            Aula a = (Aula) listaAulas.get(0);
            mensagem = "Professor está em outra turma neste horário: " + a.getOferta().getTurma().getNome() + " - " + a.getAlocacao().getDisciplina().getNome();       
            return "0 " + mensagem;
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

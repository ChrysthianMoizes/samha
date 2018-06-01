package cgt;

import cdp.Aula;
import cdp.Professor;
import cdp.RestricaoProfessor;
import java.util.ArrayList;
import java.util.List;

public class GtConflito {
    
    private GtPrincipal gtPrincipal;
    
    public GtConflito(GtPrincipal gt) {
        this.gtPrincipal = gt;
    }
      
    public List validarOferta(Aula aula){
 
        Professor professor = aula.getAlocacao().getProfessor1();
        
        List mensagens = identificarConflitos(aula, professor.getId(), 1);
        
        if(aula.getAlocacao().getDisciplina().getTipo().equals(Constantes.ESPECIAL)){
            Professor professor2 = aula.getAlocacao().getProfessor2();
            List msg = identificarConflitos(aula, professor2.getId(), 2);
            mensagens.addAll(msg);
        }
   
        return mensagens;
    }
    
    public List identificarConflitos(Aula aula, int idProfessor, int numeroProfessor){
        
        List mensagens = new ArrayList<>();
        
        String mensagemConflitoTurma = identificarConflitoTurma(aula, idProfessor);
        if(mensagemConflitoTurma != null) mensagens.add(mensagemConflitoTurma);
        
        List mensagemConflitoInstituicao = gtPrincipal.getGtInstituicao().identificarConflitoRestricaoInstituicao(aula, numeroProfessor);
        mensagens.addAll(mensagemConflitoInstituicao);
        
        String mensagemConflitoRestricaoProfessor = identificarConflitoRestricaoProfessor(aula, idProfessor);
        if(mensagemConflitoRestricaoProfessor != null) mensagens.add(mensagemConflitoRestricaoProfessor);
        
        return mensagens;
    }
    
    public String identificarConflitoTurma(Aula aula, int idProfessor){
           
        List listaAulasBanco = gtPrincipal.getGdPrincipal().getGdAula().identificarConflitoAula(aula.getAlocacao().getAno(), aula.getAlocacao().getSemestre(), idProfessor, aula.getNumero(), aula.getDia());
        listaAulasBanco = removerAulaListaBanco(listaAulasBanco, aula);
        
        if(listaAulasBanco.isEmpty())
            return null;
        else
            return montarMensagemConflitoTurma(listaAulasBanco);
    }
    
    public List removerAulaListaBanco(List listaAulasBanco, Aula aula){
        
        Aula aulaLista;
        
        for(int i = 0; i < listaAulasBanco.size(); i++){
            
            aulaLista = (Aula) listaAulasBanco.get(i);
            
            if(aulaLista.getId() == aula.getId()){
                listaAulasBanco.remove(i);    
            }else if(aula.getOferta().getTurma().getId() == aulaLista.getOferta().getTurma().getId()){
                if(aula.getNumero() == aulaLista.getNumero()){
                    listaAulasBanco.remove(i);
                }
            }    
        }
        
        return listaAulasBanco;
    }
    
    public String montarMensagemConflitoTurma(List aulas){
        
        Aula aulaLista;
        String novaMensagem = "Este Professor está em outra(s) turma(s) neste horário: ";

        for(int i = 0; i < aulas.size(); i++){
            aulaLista = (Aula) aulas.get(i);
            novaMensagem = novaMensagem + aulaLista.getOferta().getTurma().getNome() + " - " + aulaLista.getAlocacao().getDisciplina().getNome() + ". ";           
        }     
        return novaMensagem;
    }
        
    public String identificarConflitoRestricaoProfessor(Aula aula, int idProfessor){
        
        String turno = obterStringTurno(aula.getTurno());
        
        List listaRestricoes = gtPrincipal.getGdPrincipal().getGdRestricao().identificarConflitoRestricao(idProfessor, aula.getDia(), turno);
        
        if(listaRestricoes.isEmpty())
            return null;
        else
            return montarMensagemConflitoRestricaoProfessor(listaRestricoes, aula);
    }
    
    public String montarMensagemConflitoRestricaoProfessor(List lista, Aula aula){
        
        boolean resposta; 
        RestricaoProfessor restricao;
                
        for(int i = 0; i < lista.size(); i++){

            restricao = (RestricaoProfessor) lista.get(i);
            resposta = identificarNumeroAulaConflitante(restricao, aula.getNumero());

            if(resposta) 
                return restricao.getProfessor().getPrimeiroNome().toUpperCase() + " possui uma restrição neste horário: " + restricao.getNome().toUpperCase();    
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
    
    public String obterStringTurno(int turno){
        
        switch(turno){ 
            case 0: return Constantes.MATUTINO;
            case 6: return Constantes.VESPERTINO;
            default: return Constantes.NOTURNO;    
        }
    }
    
    public boolean validarQuantidadeAulasDisciplina(Aula aula){
        
        if(aula != null){
            
            int cont  = 0;
            int qtAulas = aula.getAlocacao().getDisciplina().getQtAulas();
            int idDisciplina = aula.getAlocacao().getDisciplina().getId();

            Aula aulaAux;

            for(int linha = 0; linha < Constantes.LINHA; linha++){

                for(int coluna = 0; coluna < Constantes.COLUNA; coluna++){

                    aulaAux = gtPrincipal.getGtAula().getAulaMatriz(linha, coluna);

                    if(aulaAux != null){
                        if(aulaAux.getAlocacao().getDisciplina().getId() == idDisciplina){
                            cont++;
                        }
                    }
                }
            }
            return cont == qtAulas;
        }
        return true;
    }
}

package cgt;

import cdp.Alocacao;
import cdp.Aula;
import cdp.Oferta;
import cdp.Professor;
import cdp.RestricaoProfessor;
import cdp.Turma;
import java.util.List;

public class GtOferta {

    private GtPrincipal gtPrincipal;
    private Aula[][] matriz;
    private Oferta ofertaSelecionada;
    
    public GtOferta(GtPrincipal gt) {
        gtPrincipal = gt;
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
        
        List listaAulas = gtPrincipal.getGdPrincipal().getGdAula().identificarConflitoAula(ano, semestre, idProfessor, numero, dia, turno);

        if(listaAulas.isEmpty()){

            List listaRestricoes = gtPrincipal.getGdPrincipal().getGdRestricao().identificarConflitoRestricao(idProfessor, dia, turno);

            if(listaRestricoes.isEmpty()){
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
    
    public int obterInteiroDia(String dia){
    
        switch(dia){
            
            case Constantes.SEGUNDA:
                return 0;
            case Constantes.TERCA:
                return 1;
            case Constantes.QUARTA:
                return 2;
            case Constantes.QUINTA:
                return 3;    
            default:
                return 4; 
        }  
    }
    
    public Aula identificarAula(Alocacao alocacao, int dia, String turno, int numero){
        
        Aula aula = getAulaMatriz(dia, numero);
        
        if(aula == null)
            return gerarNovaAula(alocacao, dia, turno, numero);   
        else
            return alterarAula(aula, alocacao, dia, turno, numero);        
    }
    
    public Aula gerarNovaAula(Alocacao alocacao, int dia, String turno, int numero){
        
        Aula novaAula = new Aula();
        
        novaAula.setAlocacao(alocacao);
        novaAula.setDia(obterStringDia(dia));
        novaAula.setNumero(numero);
        novaAula.setTurno(turno);

        setAulaMatriz(dia, numero, novaAula);

        if(getOfertaSelecionada() != null)
            novaAula.setOferta(getOfertaSelecionada());

        return novaAula; 
    }
    
    public Aula alterarAula(Aula aula, Alocacao alocacao, int dia, String turno, int numero){
        
        aula.setAlocacao(alocacao);
        aula.setDia(obterStringDia(dia));
        aula.setNumero(numero);
        aula.setTurno(turno);

        setAulaMatriz(dia, numero, aula);
        return aula;
    }
    
    public String salvarOferta(int ano, int semestre, int tempoMaximo, int intervaloMinimo, Turma turma){

        try {
            
            if(getOfertaSelecionada() == null){

                Oferta oferta = new Oferta();

                oferta.setAno(ano);
                oferta.setIntervaloMinimo(intervaloMinimo);
                oferta.setSemestre(semestre);
                oferta.setTempoMaximoTrabalho(tempoMaximo);
                oferta.setTurma(turma);

                gtPrincipal.getGdPrincipal().getGdOferta().cadastrarOferta(oferta, matriz);
                setOfertaSelecionada(oferta);               
            }
            
            gtPrincipal.getGdPrincipal().getGdOferta().cadastrarAulas(matriz); 
            return Constantes.CADASTRADO;
            
        } catch (Exception ex) {
            return ex.getMessage();
        } 
    }
    
    public void identificarOferta(int ano, int semestre, String turno, int idTurma){
        
        Oferta oferta = gtPrincipal.getGdPrincipal().getGdOferta().filtrarOferta(ano, semestre, idTurma);
        setOfertaSelecionada(oferta);
        gerarMatriz();
        
        if(oferta != null){  
            List listaAulas = gtPrincipal.getGdPrincipal().getGdAula().filtrarAulasTurno(turno, oferta.getId());
            preencherMatrizOferta(listaAulas);
        }
    }
    
    public void preencherMatrizOferta(List lista){
               
        Aula aula; 
        for(int linha = 0; linha < Constantes.LINHA; linha++){
            aula = (Aula) lista.get(linha);
            aula.setOferta(getOfertaSelecionada());
            for(int coluna = 0; coluna < Constantes.COLUNA; coluna++){
                setAulaMatriz(linha, coluna, aula);
            }
        }  
    }
    
    public void gerarMatriz(){
        matriz = new Aula[Constantes.LINHA][Constantes.COLUNA];
    }
    
    public Aula getAulaMatriz(int linha, int coluna){
        return (Aula) matriz[linha][coluna];
    }
    
    public void setAulaMatriz(int linha, int coluna, Aula aula){
        matriz[linha][coluna] = aula;    
    }

    public Oferta getOfertaSelecionada() {
        return ofertaSelecionada;
    }

    public void setOfertaSelecionada(Oferta ofertaSelecionada) {
        this.ofertaSelecionada = ofertaSelecionada;
    }
}

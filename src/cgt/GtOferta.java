package cgt;

import cdp.Alocacao;
import cdp.Aula;
import cdp.Oferta;
import cdp.Professor;
import cdp.RestricaoProfessor;
import cdp.Turma;
import java.util.ArrayList;
import java.util.List;

public class GtOferta {

    private GtPrincipal gtPrincipal;
    private Aula[][] matriz;
    private Oferta ofertaSelecionada;
    private List listaAulasRemovidas;
    
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
        
        List aulas = gtPrincipal.getGdPrincipal().getGdAula().identificarConflitoAula(ano, semestre, idProfessor, numero, dia, turno);
        
        if(aulas.size() <= 1){
            
            List listaRestricoes = gtPrincipal.getGdPrincipal().getGdRestricao().identificarConflitoRestricao(idProfessor, dia, turno);
            
            if(aulas.isEmpty()){
                return montarStringConflitoRestricao(mensagem, listaRestricoes, aula); 
                
            }else{
                
                Aula aulaLista = (Aula) aulas.get(0);
                
                if(aulaLista.getId() == aula.getId())
                    return montarStringConflitoRestricao(mensagem, listaRestricoes, aula);
                else
                    return montarStringConflitoTurma(aulas);
            }
        }else
            return montarStringConflitoTurma(aulas);
    }
    
    public String montarStringConflitoTurma(List aulas){
        
        Aula aula;
        String novaMensagem = "0 Professor está em outra turma neste horário: ";

        for(int i = 0; i< aulas.size(); i++){
            aula = (Aula) aulas.get(0);
            novaMensagem = novaMensagem + aula.getOferta().getTurma().getNome() + " - " + aula.getAlocacao().getDisciplina().getNome() + ". ";
        }     
        return novaMensagem;
    }
    
    public String montarStringConflitoRestricao(String mensagem, List listaRestricoes, Aula aula){
        if(listaRestricoes.isEmpty())
            return mensagem;
        else
            return identificarConflitoRestricao(listaRestricoes, aula, mensagem);
    }
    
    public String identificarConflitoRestricao(List lista, Aula aula, String mensagem){
        
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
    
    public void importarAulaLista(int linha, int coluna, Aula origem){
        
        Aula destino = getAulaMatriz(linha, coluna);
        
        if(destino == null){
            setAulaMatriz(linha, coluna, origem);
        }else{
            Aula aulaAlterada = alterarAula(destino, origem.getAlocacao(), obterInteiroDia(origem.getDia()), origem.getTurno(), origem.getNumero());
            setAulaMatriz(linha, coluna, aulaAlterada);
        }
    }
    
    public void moverAulaMatriz(int linha, int coluna, Aula origem){
        
        Aula destino = getAulaMatriz(linha, coluna);
        
        String d = origem.getDia();
        int numero = origem.getNumero();
        
        origem.setDia(obterStringDia(linha));
        origem.setNumero(coluna);
        
        if(destino == null){
            setAulaMatriz(obterInteiroDia(d), numero, null);
            setAulaMatriz(linha, coluna, origem);          
        }else{
            
            Aula aulaAux = destino;
            
            setAulaMatriz(linha, coluna, origem);
            aulaAux.setDia(d);
            aulaAux.setNumero(numero);
            setAulaMatriz(obterInteiroDia(d), numero, aulaAux);
        }
    }
    
    public void removerAula(Aula aula){
        
        if(aula != null){
            setAulaMatriz(obterInteiroDia(aula.getDia()), aula.getNumero(), null);
            getListaAulasRemovidas().add(aula);
        }
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

                gtPrincipal.getGdPrincipal().getGdOferta().cadastrarAulasOferta(oferta, matriz);
                setOfertaSelecionada(oferta);
                return Constantes.CADASTRADO;
            }
            
            gtPrincipal.getGdPrincipal().getGdOferta().atualizarAulasOferta(matriz, listaAulasRemovidas); 
            return Constantes.CADASTRADO;
            
        } catch (Exception ex) {
            return ex.getMessage();
        } 
    }
    
    public void identificarOferta(int ano, int semestre, String turno, int idTurma){
        
        Oferta oferta = gtPrincipal.getGdPrincipal().getGdOferta().filtrarOferta(ano, semestre, idTurma);
        setOfertaSelecionada(oferta);
        gerarEstruturasArmazenamento();
        
        if(oferta != null){  
            List aulas = gtPrincipal.getGdPrincipal().getGdAula().filtrarAulasTurno(turno, oferta.getId());
            preencherMatrizOferta(aulas);
        }
    }
    
    public void preencherMatrizOferta(List lista){
               
        Aula aula; 
        for(int linha = 0; linha < lista.size(); linha++){
            aula = (Aula) lista.get(linha);
            aula.setOferta(getOfertaSelecionada());
            setAulaMatriz(obterInteiroDia(aula.getDia()), aula.getNumero(), aula);   
        }  
    }
    
    public void gerarEstruturasArmazenamento(){
        if(matriz == null){
           matriz = new Aula[Constantes.LINHA][Constantes.COLUNA];
            listaAulasRemovidas = new ArrayList<>(); 
        }else{
            limparEstruturasArmazenamento();
        }
    }
    
    public void limparEstruturasArmazenamento(){
        
        listaAulasRemovidas.clear();
  
        for(int linha = 0; linha < Constantes.LINHA; linha++){
            for(int coluna = 0; coluna < Constantes.COLUNA; coluna++){
                setAulaMatriz(linha, coluna, null);
            }
        }
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

    public List getListaAulasRemovidas() {
        return listaAulasRemovidas;
    }

    public void setListaAulasRemovidas(List listaAulasRemovidas) {
        this.listaAulasRemovidas = listaAulasRemovidas;
    }
    
    public List listarAulasProfessor(int idProfessor, int ano, int semestre, int numeroProfessor){
        if(numeroProfessor == 1)
            return gtPrincipal.getGdPrincipal().getGdAula().filtrarAulasProfessor1AnoSemestre(idProfessor, ano, semestre);
        else
            return gtPrincipal.getGdPrincipal().getGdAula().filtrarAulasProfessor2AnoSemestre(idProfessor, ano, semestre);
    }
}

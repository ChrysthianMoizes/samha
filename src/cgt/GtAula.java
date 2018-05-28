package cgt;

import cdp.Alocacao;
import cdp.Aula;
import cdp.Oferta;
import java.util.ArrayList;
import java.util.List;

public class GtAula {
    
    private GtPrincipal gtPrincipal;
    private Aula[][] matriz;
    private List listaAulasRemovidas;

    public GtAula(GtPrincipal gt) {
        this.gtPrincipal = gt;
    }
    
    public Aula gerarNovaAula(Alocacao alocacao, int dia, String turno, int numero){
        
        Aula novaAula = new Aula();
        Oferta oferta = gtPrincipal.getGtOferta().getOfertaSelecionada();
        int trn = gtPrincipal.getGtAula().obterNumeroTurno(turno);
        novaAula.setAlocacao(alocacao);
        novaAula.setDia(dia);
        novaAula.setNumero(numero+trn);
        novaAula.setTurno(trn);
        novaAula.setOferta(oferta);

        return novaAula; 
    }
    
    public Aula alterarAula(Aula aula, Alocacao alocacao, int dia, int turno, int numero){
        
        aula.setAlocacao(alocacao);
        aula.setDia(dia);
        aula.setNumero(numero);
        aula.setTurno(turno);
        setAulaMatriz(dia, numero, aula);
        return aula;
    }
    
    public void importarAulaLista(Aula origem){
        
        Aula destino = getAulaMatriz(origem.getDia(), origem.getNumero());
        
        if(destino == null){
            setAulaMatriz(origem.getDia(), origem.getNumero(), origem);
        }else{
            Aula aulaAlterada = alterarAula(destino, origem.getAlocacao(), origem.getDia(), origem.getTurno(), origem.getNumero());
            setAulaMatriz(origem.getDia(), origem.getNumero(), aulaAlterada);
        }
    }
    
    public void moverAulaMatriz(int linha, int coluna, int turno, Aula origem){
        
        Aula destino = getAulaMatriz(linha, (coluna + turno));
        
        int dia = origem.getDia();
        int numero = origem.getNumero();
        
        origem.setDia(linha);
        origem.setNumero(coluna + turno);
        
        if(destino == null){
            setAulaMatriz(dia, numero, null);
            setAulaMatriz(linha, (coluna + turno), origem);          
        }else{
            
            Aula aulaAux = destino;
            
            setAulaMatriz(linha, (coluna + turno), origem);
            aulaAux.setDia(dia);
            aulaAux.setNumero(numero);
            setAulaMatriz(dia, numero, aulaAux);
        }
    }
    
    public void removerAula(Aula aula){
        
        if(aula != null){
            setAulaMatriz(aula.getDia(), aula.getNumero(), null);
            if(aula.getId() != 0)
                getListaAulasRemovidas().add(aula);
        }
    }
    
    public String salvarAulas(){

        try {
            
            gtPrincipal.getGdPrincipal().getGdAula().salvarAulasOferta(matriz, listaAulasRemovidas);
            preencherMatrizOferta(gtPrincipal.getGtOferta().getOfertaSelecionada());
            return Constantes.CADASTRADO;
            
        } catch (Exception ex) {
            return ex.getMessage();
        } 
    }
    
    public void preencherMatrizOferta(Oferta oferta){
        
        gerarEstruturasArmazenamento();
        
        List lista = gtPrincipal.getGdPrincipal().getGdAula().filtrarAulasOferta(oferta.getId());
        
        Aula aula;
        for(int linha = 0; linha < lista.size(); linha++){
            aula = (Aula) lista.get(linha);
            aula.setOferta(oferta);
            setAulaMatriz(aula.getDia(), aula.getNumero(), aula);   
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
    
    public List listarAulasProfessor(int idProfessor, int ano, int semestre, int numeroProfessor){
        if(numeroProfessor == 1)
            return gtPrincipal.getGdPrincipal().getGdAula().filtrarAulasProfessor1AnoSemestre(idProfessor, ano, semestre);
        else
            return gtPrincipal.getGdPrincipal().getGdAula().filtrarAulasProfessor2AnoSemestre(idProfessor, ano, semestre);
    }
    
    public int obterNumeroTurno(String turno){
        
        switch(turno.toUpperCase()){ 
            case Constantes.MATUTINO: return 0;
            case Constantes.VESPERTINO: return 6;
            default: return 12;    
        }
    }
    
    public Aula getAulaMatriz(int linha, int coluna){
        return (Aula) matriz[linha][coluna];
    }
    
    public void setAulaMatriz(int linha, int coluna, Aula aula){
        matriz[linha][coluna] = aula;    
    }
    
    public List getListaAulasRemovidas() {
        return listaAulasRemovidas;
    }

    public void setListaAulasRemovidas(List listaAulasRemovidas) {
        this.listaAulasRemovidas = listaAulasRemovidas;
    }
    
    public List filtrarAulasProfessorAnoSemestre(int ano, int semestre, int id){
        return gtPrincipal.getGdPrincipal().getGdAula().filtrarAulasProfessorAnoSemestre(id, ano, semestre);
    }
}

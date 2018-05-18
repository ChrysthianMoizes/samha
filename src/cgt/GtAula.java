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
    
    public Aula identificarAula(Alocacao alocacao, int dia, String turno, int numero){
        
        Aula aula = getAulaMatriz(dia, numero);
        
        if(aula == null)
            return gerarNovaAula(alocacao, dia, turno, numero);   
        else
            return alterarAula(aula, alocacao, dia, turno, numero);        
    }
    
    public Aula gerarNovaAula(Alocacao alocacao, int dia, String turno, int numero){
        
        Aula novaAula = new Aula();
        Oferta oferta = gtPrincipal.getGtOferta().getOfertaSelecionada();
        
        novaAula.setAlocacao(alocacao);
        novaAula.setDia(dia);
        novaAula.setNumero(numero);
        novaAula.setTurno(turno);
        novaAula.setOferta(oferta);

        return novaAula; 
    }
    
    public Aula alterarAula(Aula aula, Alocacao alocacao, int dia, String turno, int numero){
        
        aula.setAlocacao(alocacao);
        aula.setDia(dia);
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
            Aula aulaAlterada = alterarAula(destino, origem.getAlocacao(), origem.getDia(), origem.getTurno(), origem.getNumero());
            setAulaMatriz(linha, coluna, aulaAlterada);
        }
    }
    
    public void moverAulaMatriz(int linha, int coluna, Aula origem){
        
        Aula destino = getAulaMatriz(linha, coluna);
        
        int d = origem.getDia();
        int numero = origem.getNumero();
        
        origem.setDia(linha);
        origem.setNumero(coluna);
        
        if(destino == null){
            setAulaMatriz(d, numero, null);
            setAulaMatriz(linha, coluna, origem);          
        }else{
            
            Aula aulaAux = destino;
            
            setAulaMatriz(linha, coluna, origem);
            aulaAux.setDia(d);
            aulaAux.setNumero(numero);
            setAulaMatriz(d, numero, aulaAux);
        }
    }
    
    public void removerAula(Aula aula){
        
        if(aula != null){
            setAulaMatriz(aula.getDia(), aula.getNumero(), null);
            getListaAulasRemovidas().add(aula);
        }
    }
    
    public String atualizarAulas(){

        try {
            
            gtPrincipal.getGdPrincipal().getGdAula().atualizarAulasOferta(matriz, listaAulasRemovidas); 
            return Constantes.CADASTRADO;
            
        } catch (Exception ex) {
            return ex.getMessage();
        } 
    }
    
    public void preencherMatrizOferta(List lista){
               
        Aula aula;
        Oferta oferta = gtPrincipal.getGtOferta().getOfertaSelecionada();
        
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
}

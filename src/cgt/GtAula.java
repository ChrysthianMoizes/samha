package cgt;

import cdp.Alocacao;
import cdp.Aula;

public class GtAula {
    
    private Aula[][] matriz;
    
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
        //novaAula.setDia(obterStringDia(dia));
        novaAula.setNumero(numero);
        novaAula.setTurno(turno);

        //if(getOfertaSelecionada() != null)
         //   novaAula.setOferta(getOfertaSelecionada());

        return novaAula; 
    }
    
    public Aula alterarAula(Aula aula, Alocacao alocacao, int dia, String turno, int numero){
        
        aula.setAlocacao(alocacao);
       // aula.setDia(obterStringDia(dia));
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
            /*obterInteiroDia(origem.getDia())*/
            Aula aulaAlterada = alterarAula(destino, origem.getAlocacao(), 0, origem.getTurno(), origem.getNumero());
            setAulaMatriz(linha, coluna, aulaAlterada);
        }
    }
    
    public void moverAulaMatriz(int linha, int coluna, Aula origem){
        
        Aula destino = getAulaMatriz(linha, coluna);
        
        String d = origem.getDia();
        int numero = origem.getNumero();
        
        //origem.setDia(obterStringDia(linha));
        origem.setNumero(coluna);
        
        if(destino == null){
            //setAulaMatriz(obterInteiroDia(d), numero, null);
            setAulaMatriz(linha, coluna, origem);          
        }else{
            
            Aula aulaAux = destino;
            
            setAulaMatriz(linha, coluna, origem);
            aulaAux.setDia(d);
            aulaAux.setNumero(numero);
            //setAulaMatriz(obterInteiroDia(d), numero, aulaAux);
        }
    }
    
    public void removerAula(Aula aula){
        
        if(aula != null){
            //setAulaMatriz(obterInteiroDia(aula.getDia()), aula.getNumero(), null);
            //getListaAulasRemovidas().add(aula);
        }
    }
    
    public Aula getAulaMatriz(int linha, int coluna){
        return (Aula) matriz[linha][coluna];
    }
    
    public void setAulaMatriz(int linha, int coluna, Aula aula){
        matriz[linha][coluna] = aula;    
    }
}

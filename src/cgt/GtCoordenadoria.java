package cgt;

import cdp.Coordenadoria;
import cgd.GdCoordenadoria;
import java.util.List;

public class GtCoordenadoria {
    
    private GdCoordenadoria gdCoordenadoria;

    public GtCoordenadoria() {        
        gdCoordenadoria = new GdCoordenadoria();
    }
    
    public List<Coordenadoria> filtrarCoordenadoresNulos() {
        return gdCoordenadoria.filtrarCoordenadoresNulos("nome", "");
    }
    
    public List<Coordenadoria> buscar(String coluna, String texto) {
        return gdCoordenadoria.buscar(coluna.toLowerCase(), texto);
    }

    public List<Coordenadoria> listar() {
       return gdCoordenadoria.consultar(Coordenadoria.class);
    }    
}

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
        return gdCoordenadoria.filtrarCoordenadoresNulos("coordenador_id", "NULO");
    }
    
    
}

package cci;

import cdp.Coordenadoria;
import cgt.GtCoordenadoria;
import java.util.List;

public class CtrlCoordenadoria {
    
    private GtCoordenadoria gtCoordenadoria;

    public CtrlCoordenadoria() {
        gtCoordenadoria = new GtCoordenadoria();
    }
   
    public List<Coordenadoria> filtrarCoordenadoresNulos() {
        return gtCoordenadoria.filtrarCoordenadoresNulos();
    }
    
}

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
    
    public List<Coordenadoria> buscar(String coluna, String texto) {
       return gtCoordenadoria.buscar(coluna, texto);
    }
    
    public List<Coordenadoria> listar() {
       return gtCoordenadoria.listar();
    }
}

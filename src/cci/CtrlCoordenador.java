package cci;

import cih.JDBuscarCoordenador;
import java.awt.Frame;

public class CtrlCoordenador {
    
    private JDBuscarCoordenador buscaCoord;
    private CtrlPrincipal ctrlPrincipal;

    public CtrlCoordenador(CtrlPrincipal ctrl) {
        this.ctrlPrincipal = ctrl;
    }
    
    public void instanciarTelaBuscaCoordenador(Frame pai){
        buscaCoord = new JDBuscarCoordenador(pai, true, ctrlPrincipal);
        buscaCoord.setVisible(true);
    }
    
    public void instanciarTelaCadastroCoordenador(Frame pai){
        buscaCoord = new JDBuscarCoordenador(pai, true, ctrlPrincipal);
        buscaCoord.setVisible(true);
    }
    
}

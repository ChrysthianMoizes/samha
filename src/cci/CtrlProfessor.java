package cci;

import cdp.Professor;
import cgt.GtProfessor;
import java.util.List;

public class CtrlProfessor {
    
    private GtProfessor gtProfessor;

    public CtrlProfessor() {
        gtProfessor = new GtProfessor();
    }
    
    public List<Professor> consultar(){
       return gtProfessor.consultar();
    }  
}

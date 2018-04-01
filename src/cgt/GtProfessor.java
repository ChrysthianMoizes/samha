package cgt;

import cdp.Professor;
import cgd.GdProfessor;
import java.util.List;

public class GtProfessor {
    
    private GdProfessor gdProfessor;

    public GtProfessor() { 
        gdProfessor = new GdProfessor();
    }
    
    public List<Professor> consultar(){
       return gdProfessor.consultar(Professor.class);
    }   
}

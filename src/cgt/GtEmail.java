package cgt;

import cdp.Professor;
import java.io.File;

public class GtEmail {
    
    private GtPrincipal gtPrincipal;
    
    public GtEmail(GtPrincipal gt){
        gtPrincipal = gt;
    }
    
    public void enviarEmailProfessor(Professor professor, File arquivo, String senha){
        
        String emailCoordenador = gtPrincipal.getGtCoordenador().obterEmailCoordenadorAtual();
        
        
        
    }
    
}

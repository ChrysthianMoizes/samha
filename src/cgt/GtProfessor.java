package cgt;

import cdp.Professor;
import cgd.GdProfessor;
import java.sql.SQLException;
import java.util.List;

public class GtProfessor {
    
    private GdProfessor gdProfessor;

    public GtProfessor() { 
        gdProfessor = new GdProfessor();
    }
    
    public List<Professor> buscar(String coluna, String texto) {
        
        if(coluna.toLowerCase().equals("coordenadoria")){
            coluna = "coordenadoria_id";
            return gdProfessor.filtrarPorCoordenadoria(coluna, texto);
        }else
            return gdProfessor.buscar(coluna.toLowerCase(), texto);
    }
    
    public List<Professor> consultar(){
       return gdProfessor.consultar(Professor.class);
    }
    
    public void excluir(Professor professor) throws SQLException, ClassNotFoundException{
        gdProfessor.excluir(professor);
    }
}

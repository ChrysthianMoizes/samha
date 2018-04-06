package cgt;

import cdp.Curso;
import cgd.GdCurso;
import java.util.List;

public class GtCurso {
    
    private GdCurso gdCurso;
    private GtTurma gtTurma;

    public GtCurso() {
        gdCurso = new GdCurso();
        gtTurma = new GtTurma();
    }
    
    public List<Curso> buscar(String coluna, String texto) {
        return gdCurso.buscar(coluna.toLowerCase(), texto);
    }
    
    public String excluir(Curso curso) {

        try {
            
            List turmas = gtTurma.filtrarPorCurso(curso.getId());
            if(turmas == null){
                gdCurso.excluir(curso);
                return Constantes.EXCLUIDO;
            }else
                return "Curso possui turmas associadas";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
}

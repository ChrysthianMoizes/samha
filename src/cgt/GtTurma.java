package cgt;

import cdp.Turma;
import cgd.GdTurma;
import java.util.List;

public class GtTurma {
    
    private GdTurma gdTurma;

    public GtTurma() {
        gdTurma = new GdTurma();
    }
    
    public List<Turma> filtrarPorCurso(int id) {
        return gdTurma.filtrarPorCurso("curso.id", id);
    }
    
}

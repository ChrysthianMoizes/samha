package cgt;

import cdp.Curso;
import cdp.MatrizCurricular;
import cdp.Turma;
import cgd.GdTurma;
import java.util.List;

public class GtTurma {
    
    private GdTurma gdTurma;

    public GtTurma() {
        gdTurma = new GdTurma();
    }
    
    public String cadastrar(String nome, String turno, int ano, int semestre, Curso curso, MatrizCurricular matriz) {

        try {
           
            Turma turma = new Turma();
           
            turma.setAno(ano);
            turma.setCurso(curso);
            turma.setMatriz(matriz);
            turma.setNome(nome.toUpperCase());
            turma.setSemestre(semestre);
            turma.setTurno(turno.toUpperCase());
            
            gdTurma.cadastrar(turma);           
            return Constantes.CADASTRADO;
            
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
    
    public String alterar(String nome, String turno, int ano, int semestre, Curso curso, MatrizCurricular matriz, Turma turma){
        
        try {
            
            turma.setAno(ano);
            turma.setCurso(curso);
            turma.setMatriz(matriz);
            turma.setNome(nome.toUpperCase());
            turma.setSemestre(semestre);
            turma.setTurno(turno.toUpperCase());
            
            gdTurma.alterar(turma);
       
            return Constantes.ALTERADO;
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
    
    public List<Turma> buscar(String coluna, String texto) {
        
        if(coluna.toLowerCase().equals("curso")){
            coluna = "curso.id";
            return gdTurma.filtrarPorCurso(coluna.toLowerCase(), Integer.valueOf(texto));
        }
        return gdTurma.buscar(coluna.toLowerCase(), texto);
    }
    
    public String excluir(Turma turma) {

        try {
            //verificar se a turma possui oferta
            List oferta = null; 
            if(oferta.size() == 0){
                gdTurma.excluir(turma);
                return Constantes.EXCLUIDO;
            }else
                return "Turma possui ofertas cadastradas";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }  
    
}

package cgt;

import cdp.Coordenadoria;
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
    
    public String cadastrar(String nome, String nivel, int periodos, Coordenadoria coordenadoria) {

        try {
           
            Curso curso = new Curso();
            curso.setNome(nome);
            curso.setNivel(nivel);
            curso.setQtPeriodos(periodos);
            curso.setCoordenadoria(coordenadoria);
            
            gdCurso.cadastrar(curso);
            
            return Constantes.CADASTRADO;
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
    
    public String alterar(Curso curso, String nome, String nivel, int periodos, Coordenadoria coordenadoria){
        
        try {
          
            curso.setNome(nome);
            curso.setNivel(nivel);
            curso.setQtPeriodos(periodos);
            curso.setCoordenadoria(coordenadoria);
            
            gdCurso.alterar(curso);
       
            return Constantes.ALTERADO;
        } catch (Exception ex) {
            return ex.getMessage();
        }
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

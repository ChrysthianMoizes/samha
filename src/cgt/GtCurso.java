package cgt;

import cdp.Coordenadoria;
import cdp.Curso;
import cgd.GdCoordenadoria;
import cgd.GdCurso;
import java.util.List;

public class GtCurso {
    
    private GdCurso gdCurso;
    private GtTurma gtTurma;
    private GdCoordenadoria gdCoordenadoria;

    public GtCurso() {
        gdCurso = new GdCurso();
        gtTurma = new GtTurma();
        gdCoordenadoria = new GdCoordenadoria();
    }
    
    public String cadastrar(String nome, String nivel, int periodos, Coordenadoria coordenadoria) {

        try {
           
            Curso curso = new Curso();
            curso.setNome(nome.toUpperCase());
            curso.setNivel(nivel);
            curso.setQtPeriodos(periodos);
            curso.setCoordenadoria(coordenadoria);
            
            gdCurso.cadastrar(curso);
            coordenadoria.setCurso(curso);
            gdCoordenadoria.alterar(coordenadoria);
            
            return Constantes.CADASTRADO;
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
    
    public String alterar(Curso curso, String nome, String nivel, int periodos, Coordenadoria coordenadoria){
        
        try {
          
            curso.setNome(nome.toUpperCase());
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
        if(coluna.toLowerCase().equals("nome"))
            return gdCurso.buscar(coluna.toLowerCase(), texto);
        else
            return gdCurso.buscarPorNivel(coluna.toLowerCase(), texto);  
    }
    
    public List<Curso> listar() {
       return gdCurso.consultar(Curso.class);
    }
    
    public String excluir(Curso curso) {

        try {
            
            List turmas = gtTurma.filtrarPorCurso(curso.getId());
            if(turmas.size() == 0){
                gdCurso.excluir(curso);
                return Constantes.EXCLUIDO;
            }else
                return "Curso possui turmas associadas";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
}

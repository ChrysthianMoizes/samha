package cgt;

import cdp.Coordenadoria;
import cdp.Curso;
import cgd.GdCoordenadoria;
import cgd.GdCurso;
import cgd.GdMatriz;
import cgd.GdTurma;
import java.util.List;

public class GtCurso {
    
    private GdCurso gdCurso;
    private GdTurma gdTurma;
    private GdCoordenadoria gdCoordenadoria;
    private GdMatriz gdMatriz;

    public GtCurso() {
        gdCurso = new GdCurso();
        gdTurma = new GdTurma();
        gdCoordenadoria = new GdCoordenadoria();
        gdMatriz = new GdMatriz();
    }
    
    public String cadastrar(String nome, String nivel, int periodos, Coordenadoria coordenadoria) {

        try {
           
            validarCampos(nome, nivel, periodos, coordenadoria);
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
            validarCampos(nome, nivel, periodos, coordenadoria);
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
            List matrizes = gdMatriz.filtrarMatrizCurso("curso.id", curso.getId());
            
            if (matrizes.size() == 0) {        
                
                List turmas = gdTurma.filtrarPorCurso(curso.getId());
                if (turmas.size() == 0) {
                    
                    Coordenadoria coordenadoria = curso.getCoordenadoria();
                    coordenadoria.setCurso(null);
                    gdCoordenadoria.alterar(coordenadoria);
                    gdCurso.excluir(curso);
                    
                    return Constantes.EXCLUIDO;
                } else {
                    return "Curso possui turmas associadas";
                }
            } else {
                return "Curso possui matrizes associadas";
            }
            
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
    
    public void validarCampos(String nome, String nivel, int periodos, Coordenadoria coordenadoria) throws SAMHAException{
        
        if((nome.equals("")))
            throw new SAMHAException(1);
        
        if(nivel.equals(""))
            throw new SAMHAException(9);
        
        if(periodos <= 0)
            throw new SAMHAException(10);
        
        if(coordenadoria == null)
            throw new SAMHAException(11);
    }
}

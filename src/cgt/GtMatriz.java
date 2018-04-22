package cgt;

import cdp.Curso;
import cdp.MatrizCurricular;
import cgd.GdDisciplina;
import cgd.GdMatriz;
import java.util.List;

public class GtMatriz {
    
    private GdMatriz gdMatriz;
    private GdDisciplina gdDisciplina;

    public GtMatriz() {
        gdMatriz = new GdMatriz();
        gdDisciplina = new GdDisciplina();
    }
    
    public String cadastrar(String nome, int ano, int semestre, Curso curso) {

        try {
            validarCampos(nome, curso);
            MatrizCurricular matriz = new MatrizCurricular();
            matriz.setNome(nome.toUpperCase());
            matriz.setAno(ano);
            matriz.setCurso(curso);
            matriz.setSemestre(semestre);
            
            gdMatriz.cadastrar(matriz);
            return Constantes.CADASTRADO;
            
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
    
    public String excluir(MatrizCurricular matriz) {

        try {
            
            List disciplinas = gdDisciplina.filtrar("matriz.id", matriz.getId());
            
            if(disciplinas.size() == 0){
                gdMatriz.excluir(matriz);
                return Constantes.EXCLUIDO;
                 
            }else
                return "Matriz possui disciplinas associadas";
            
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
    
    public List<MatrizCurricular> filtrarMatrizCurso(int id) {
        return gdMatriz.filtrarMatrizCurso("curso.id", id);
    }
    
    public void validarCampos(String nome, Curso curso) throws SAMHAException{
        
        if((nome.equals("")))
            throw new SAMHAException(1);
        
        if(curso == null)
            throw new SAMHAException(8);
    }     
}

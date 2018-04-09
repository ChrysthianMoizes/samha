package cgt;

import cdp.Disciplina;
import cdp.MatrizCurricular;
import cgd.GdDisciplina;
import java.util.List;

public class GtDisciplina {
    
    private GdDisciplina gdDisciplina;
    
    public GtDisciplina(){
        gdDisciplina = new GdDisciplina();
    }
      
    public String cadastrar(String nome, String tipo, int periodo, int cargaHoraria, int qtAulas, MatrizCurricular matriz) {

        try {
           
            Disciplina disciplina = new Disciplina();
            
            disciplina.setCargaHoraria(cargaHoraria);
            disciplina.setMatriz(matriz);
            disciplina.setNome(nome);
            disciplina.setPeriodo(periodo);
            disciplina.setQtAulas(qtAulas);
            disciplina.setTipo(tipo);
            
            gdDisciplina.cadastrar(disciplina);           
            return Constantes.CADASTRADO;
            
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
    
    public String alterar(String nome, String tipo, int periodo, int cargaHoraria, int qtAulas, MatrizCurricular matriz, Disciplina disciplina){
        
        try {
            
            disciplina.setCargaHoraria(cargaHoraria);
            disciplina.setMatriz(matriz);
            disciplina.setNome(nome);
            disciplina.setPeriodo(periodo);
            disciplina.setQtAulas(qtAulas);
            disciplina.setTipo(tipo);
            
            gdDisciplina.alterar(disciplina);
       
            return Constantes.ALTERADO;
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
    
    public List<Disciplina> buscar(String coluna, String texto) {
        
        if(coluna.toLowerCase().equals("curso")){
            coluna = "matriz.curso.id";
            return gdDisciplina.filtrarPorCurso(coluna.toLowerCase(), Integer.valueOf(texto));
        }
        return gdDisciplina.buscar(coluna.toLowerCase(), texto);
    }
    
    public String excluir(Disciplina disciplina) {

        try {
            //verificar se a disciplina está associada a alguma alocação = criar gdLocacao
            List turmas = null; //gtTurma.filtrarPorCurso(disciplina.getId());
            if(turmas == null){
                gdDisciplina.excluir(disciplina);
                return Constantes.EXCLUIDO;
            }else
                return "Curso possui turmas associadas";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }   
}

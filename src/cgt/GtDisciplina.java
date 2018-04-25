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
            validarCampos(nome, tipo, periodo, cargaHoraria, qtAulas, matriz);
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
            validarCampos(nome, tipo, periodo, cargaHoraria, qtAulas, matriz);
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
            coluna = "matriz.id";
            return gdDisciplina.filtrar(coluna.toLowerCase(), Integer.valueOf(texto));
        }
        return gdDisciplina.buscar(coluna.toLowerCase(), texto);
    }
    
    public List filtrarPorMatrizPeriodo(int matriz, int periodo){
        return gdDisciplina.filtrarPorMatrizPeriodo(matriz, periodo);
    }
    
    public String excluir(Disciplina disciplina) {

        try {
            //verificar se a disciplina está associada a alguma alocação = criar gdLocacao
            List alocacao = null; 
            if(alocacao == null){
                gdDisciplina.excluir(disciplina);
                return Constantes.EXCLUIDO;
            }else
                return "Disciplina está associada a uma alocação";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
    
    public void validarCampos(String nome, String tipo, int periodos, int cargaHoraria, int qtAulas, MatrizCurricular matriz) throws SAMHAException{
        
        if((nome.equals("")))
            throw new SAMHAException(1);
        
        if(tipo.equals(""))
            throw new SAMHAException(16);
        
        if(periodos <= 0)
            throw new SAMHAException(10);
        
        if(cargaHoraria <= 0)
            throw new SAMHAException(5);
        
        if(qtAulas <= 0)
            throw new SAMHAException(14);
        
        if(matriz == null)
            throw new SAMHAException(13);
    }
}

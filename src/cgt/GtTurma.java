package cgt;

import cdp.MatrizCurricular;
import cdp.Turma;
import cgd.GdTurma;
import java.util.Collections;
import java.util.List;

public class GtTurma {
    
    private GdTurma gdTurma;

    public GtTurma() {
        gdTurma = new GdTurma();
    }
    
    public String cadastrar(String nome, String turno, int ano, int semestre, MatrizCurricular matriz) {

        try {
            validarCampos(nome, turno, matriz);
            Turma turma = new Turma();
           
            turma.setAno(ano);
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
    
    public String alterar(String nome, String turno, int ano, int semestre, MatrizCurricular matriz, Turma turma){
        
        try {
            validarCampos(nome, turno, matriz);
            turma.setAno(ano);
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
        
        List lista;
        
        if(coluna.toLowerCase().equals("curso"))
            lista = gdTurma.filtrarPorCurso(Integer.valueOf(texto));
        else
            lista= gdTurma.buscar(coluna.toLowerCase(), texto);
        
        Collections.sort(lista);
        return lista;
    }
    
    public List<Turma> buscarPorCurso(int id) {
        
        List lista = gdTurma.filtrarPorCurso(id);
        Collections.sort(lista);
        return lista;
    }
    
    public String excluir(Turma turma) {

        try {
            //verificar se a turma possui oferta
            List oferta = null; 
            if(oferta == null){
                gdTurma.excluir(turma);
                return Constantes.EXCLUIDO;
            }else
                return "Turma possui ofertas cadastradas";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
    
    public void validarCampos(String nome, String turno, MatrizCurricular matriz) throws SAMHAException{
        
        if((nome.equals("")))
            throw new SAMHAException(1);
        
        if(turno.equals(""))
            throw new SAMHAException(15);
        
        if(matriz == null)
            throw new SAMHAException(13);
    }
    
}

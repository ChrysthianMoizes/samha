package cgt;

import cdp.MatrizCurricular;
import cdp.Turma;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class GtTurma {

    private GtPrincipal gtPrincipal;

    public GtTurma(GtPrincipal gt) {
        gtPrincipal = gt;
    }
    
    public String cadastrar(String nome, String turno, int ano, int semestre, MatrizCurricular matriz) {

        try {
            gtPrincipal.identificarPermissaoPadrao();
            validarCampos(nome, turno, matriz);
            Turma turma = new Turma();
           
            turma.setAno(ano);
            turma.setMatriz(matriz);
            turma.setNome(nome.toUpperCase());
            turma.setSemestre(semestre);
            turma.setTurno(turno.toUpperCase());
            
            gtPrincipal.getGdPrincipal().getGdTurma().cadastrar(turma);           
            return Constantes.CADASTRADO;
            
        } catch (SAMHAException | ClassNotFoundException | SQLException ex) {
            return ex.getMessage();
        }
    }
    
    public String alterar(String nome, String turno, int ano, int semestre, MatrizCurricular matriz, Turma turma){
        
        try {
            gtPrincipal.identificarPermissaoPadrao();
            validarCampos(nome, turno, matriz);
            turma.setAno(ano);
            turma.setMatriz(matriz);
            turma.setNome(nome.toUpperCase());
            turma.setSemestre(semestre);
            turma.setTurno(turno.toUpperCase());
            
            gtPrincipal.getGdPrincipal().getGdTurma().alterar(turma);
       
            return Constantes.ALTERADO;
        } catch (SAMHAException | ClassNotFoundException | SQLException ex) {
            return ex.getMessage();
        }
    }
    
    public List<Turma> buscar(String coluna, String texto) {
        
        List lista;
        
        if(coluna.toLowerCase().equals("curso"))
            lista = gtPrincipal.getGdPrincipal().getGdTurma().filtrarPorCurso(Integer.valueOf(texto));
        else
            lista= gtPrincipal.getGdPrincipal().getGdTurma().buscar(coluna.toLowerCase(), texto);
        
        Collections.sort(lista);
        return lista;
    }
    
    public List<Turma> buscarPorCurso(int id) {
        
        List lista = gtPrincipal.getGdPrincipal().getGdTurma().filtrarPorCurso(id);
        Collections.sort(lista);
        return lista;
    }
    
    public List<Turma> buscarPorEixo(int id) {
        
        List lista = gtPrincipal.getGdPrincipal().getGdTurma().filtrarPorEixo(id);
        Collections.sort(lista);
        return lista;
    }
    
    public List listar(){
        List lista = gtPrincipal.getGdPrincipal().getGdTurma().consultar(Turma.class);
        Collections.sort(lista);
        return lista;
    }
    
    public String excluir(Turma turma) {

        try {
            gtPrincipal.identificarPermissaoPadrao();
            //verificar se a turma possui oferta
            List oferta = null; 
            if(oferta == null){
                gtPrincipal.getGdPrincipal().getGdTurma().excluir(turma);
                return Constantes.EXCLUIDO;
            }else
                return "Turma possui ofertas cadastradas";
        } catch (SAMHAException | ClassNotFoundException | SQLException ex) {
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

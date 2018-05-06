package cgt;

import cdp.CoordenadorCurso;
import cdp.Coordenadoria;
import cdp.Professor;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class GtProfessor {

    private GtPrincipal gtPrincipal;

    public GtProfessor(GtPrincipal gt) {
        gtPrincipal = gt;

    }

    public Professor cadastrar(String nome, String matricula, int cargaHoraria, Coordenadoria coordenadoria) {

        try {
            validarCampos(nome, matricula, coordenadoria);
            Professor professor = new Professor();
            professor.setNome(nome);
            professor.setMatricula(matricula);
            professor.setCargaHoraria(cargaHoraria);
            professor.setCoordenadoria(coordenadoria);
            gtPrincipal.getGdPrincipal().getGdProfessor().cadastrar(professor);
            return professor;
        } catch (Exception ex) {
            return null;
        }
    }
    
    public Professor alterar(String nome, String matricula, int cargaHoraria, Coordenadoria coordenadoria, Professor professor) {

        try {
            validarCampos(nome, matricula, coordenadoria);
            professor.setNome(nome);
            professor.setMatricula(matricula);
            professor.setCargaHoraria(cargaHoraria);
            professor.setCoordenadoria(coordenadoria);
            gtPrincipal.getGdPrincipal().getGdProfessor().alterar(professor);
            return professor;
        } catch (Exception ex) {
            return null;
        }
    }

    public List<Professor> buscar(String coluna, String texto) {
        
        List lista = gtPrincipal.getGdPrincipal().getGdProfessor().buscar(coluna.toLowerCase(), texto);
        Collections.sort(lista);
        return lista;      
    }
    
    public List<Professor> filtrarPorCoordenadoria(int id){
        
        List lista = gtPrincipal.getGdPrincipal().getGdProfessor().filtrarPorCoordenadoria(id);
        Collections.sort(lista);
        return lista;
    }
    
    public List<Professor> filtrarPorEixo(int id){
        
        List lista = gtPrincipal.getGdPrincipal().getGdProfessor().filtrarPorEixo(id);
        Collections.sort(lista);
        return lista;
    }

    public List<Professor> consultar() {
        List lista = gtPrincipal.getGdPrincipal().getGdProfessor().consultar(Professor.class);
        Collections.sort(lista);
        return lista;
    }

    public String excluir(Professor professor){
        
        try {
            
            CoordenadorCurso coordenador = gtPrincipal.getGdPrincipal().getGdCoordenador().identificarCoordenadorCurso(professor.getId());
            
            if(coordenador == null){
                gtPrincipal.getGdPrincipal().getGdRestricao().excluirRestricoes("professor.id", professor.getId());
                gtPrincipal.getGdPrincipal().getGdProfessor().excluir(professor);
                return Constantes.EXCLUIDO;
            }else
                return "Professor não pode ser excluído pois também é um coordenador";
            
        } catch (SQLException | ClassNotFoundException ex) {
            return ex.getMessage();
        }
    }

    public void validarCampos(String nome, String matricula, Coordenadoria coordenadoria) throws Exception {
        
        if (nome.equals(""))
            throw new SAMHAException(1);
        
        if (matricula.equals("")) 
            throw new SAMHAException(2);
        
        if(coordenadoria == null)
            throw new SAMHAException(11);    
    }
}

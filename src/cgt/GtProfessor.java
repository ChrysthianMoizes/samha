package cgt;

import cdp.CoordenadorCurso;
import cdp.Coordenadoria;
import cdp.Professor;
import cgd.GdCoordenador;
import cgd.GdProfessor;
import cgd.GdRestricao;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class GtProfessor {

    private GdProfessor gdProfessor;
    private GdCoordenador gdCoordenador;
    private GdRestricao gdRestricao;

    public GtProfessor() {
        gdProfessor = new GdProfessor();
        gdCoordenador = new GdCoordenador();
        gdRestricao = new GdRestricao();
    }

    public Professor cadastrar(String nome, String matricula, int cargaHoraria, Coordenadoria coordenadoria) {

        try {
            validarCampos(nome, matricula, coordenadoria);
            Professor professor = new Professor();
            professor.setNome(nome);
            professor.setMatricula(matricula);
            professor.setCargaHoraria(cargaHoraria);
            professor.setCoordenadoria(coordenadoria);
            gdProfessor.cadastrar(professor);
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
            gdProfessor.alterar(professor);
            return professor;
        } catch (Exception ex) {
            return null;
        }
    }

    public List<Professor> buscar(String coluna, String texto) {
        
        List lista = gdProfessor.buscar(coluna.toLowerCase(), texto);
        Collections.sort(lista);
        return lista;      
    }
    
    public List<Professor> filtrarPorCoordenadoria(int id){
        
        List lista = gdProfessor.filtrarPorCoordenadoria("coordenadoria.id", id);
        Collections.sort(lista);
        return lista;
    }

    public List<Professor> consultar() {
        List lista = gdProfessor.consultar(Professor.class);
        Collections.sort(lista);
        return lista;
    }

    public String excluir(Professor professor){
        
        try {
            
            CoordenadorCurso coordenador = gdCoordenador.identificarCoordenadorCurso(professor.getId());
            
            if(coordenador == null){
                gdRestricao.excluirRestricoes("professor.id", professor.getId());
                gdProfessor.excluir(professor);
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

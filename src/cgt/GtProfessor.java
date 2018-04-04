package cgt;

import cdp.Coordenadoria;
import cdp.Professor;
import cgd.GdProfessor;
import java.sql.SQLException;
import java.util.List;

public class GtProfessor {

    private GdProfessor gdProfessor;

    public GtProfessor() {
        gdProfessor = new GdProfessor();
    }

    public Professor cadastrar(String nome, String matricula, String cargaHoraria, Coordenadoria coordenadoria) {

        try {
            validarCampos(nome, matricula, cargaHoraria);
            Professor professor = new Professor();
            professor.setNome(nome);
            professor.setMatricula(matricula);
            professor.setCargaHoraria(Double.parseDouble(cargaHoraria));
            professor.setCoordenadoria(coordenadoria);
            gdProfessor.cadastrar(professor);
            return professor;
        } catch (Exception ex) {
            return null;
        }
    }
    
    public Professor alterar(String nome, String matricula, String cargaHoraria, Coordenadoria coordenadoria, Professor professor) {

        try {
            validarCampos(nome, matricula, cargaHoraria);
            professor.setNome(nome);
            professor.setMatricula(matricula);
            professor.setCargaHoraria(Double.parseDouble(cargaHoraria));
            professor.setCoordenadoria(coordenadoria);
            gdProfessor.alterar(professor);
            return professor;
        } catch (Exception ex) {
            return null;
        }
    }

    public List<Professor> buscar(String coluna, String texto) {

        if (coluna.toLowerCase().equals("coordenadoria")) {
            coluna = "coordenadoria_id";
            return gdProfessor.filtrarPorCoordenadoria(coluna, Integer.parseInt(texto));
        } else 
            return gdProfessor.buscar(coluna.toLowerCase(), texto);      
    }

    public List<Professor> consultar() {
        return gdProfessor.consultar(Professor.class);
    }

    public String excluir(Professor professor){
        try {
            gdProfessor.excluir(professor);
            return Constantes.EXCLUIDO;
        } catch (SQLException | ClassNotFoundException ex) {
            return ex.getMessage();
        }
    }

    public void validarCampos(String nome, String matricula, String cargaHoraria) throws Exception {
        if (nome.equals("")) {
            throw new SAMHAException(1);
        }
        if (matricula.equals("")) {
            throw new SAMHAException(2);
        }
        if (cargaHoraria.equals("")) {
            throw new SAMHAException(5);
        }
    }
}

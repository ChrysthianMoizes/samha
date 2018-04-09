package cgt;

import cdp.Coordenadoria;
import cdp.Professor;
import cgd.GdProfessor;
import cgd.GdRestricao;
import java.sql.SQLException;
import java.util.List;

public class GtProfessor {

    private GdProfessor gdProfessor;
    private GdRestricao gdRestricao;

    public GtProfessor() {
        gdProfessor = new GdProfessor();
        gdRestricao = new GdRestricao();
    }

    public Professor cadastrar(String nome, String matricula, int cargaHoraria, Coordenadoria coordenadoria) {

        try {
            validarCampos(nome, matricula);
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
            validarCampos(nome, matricula);
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
            gdRestricao.excluirRestricoes("professor.id", professor.getId());
            gdProfessor.excluir(professor);
            return Constantes.EXCLUIDO;
        } catch (SQLException | ClassNotFoundException ex) {
            return ex.getMessage();
        }
    }

    public void validarCampos(String nome, String matricula) throws Exception {
        if (nome.equals("")) {
            throw new SAMHAException(1);
        }
        if (matricula.equals("")) {
            throw new SAMHAException(2);
        }
    }
}

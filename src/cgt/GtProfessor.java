package cgt;

import cdp.CoordenadorCurso;
import cdp.Coordenadoria;
import cdp.Professor;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class GtProfessor {

    private GtPrincipal gtPrincipal;
    private Professor professorSelecionado;

    public GtProfessor(GtPrincipal gt) {
        gtPrincipal = gt;
        setProfessorSelecionado(null);
    }

    public String cadastrar(String nome, String matricula, int cargaHoraria, Coordenadoria coordenadoria) {

        try {
            gtPrincipal.identificarPermissaoPadrao();
            validarCampos(nome, matricula, coordenadoria);
            Professor professor = new Professor();
            professor.setNome(nome);
            professor.setMatricula(matricula);
            professor.setCargaHoraria(cargaHoraria);
            professor.setCoordenadoria(coordenadoria);
            gtPrincipal.getGdPrincipal().getGdProfessor().cadastrar(professor);
            setProfessorSelecionado(professor);
            return Constantes.CADASTRADO;
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
    
    public String alterar(String nome, String matricula, int cargaHoraria, Coordenadoria coordenadoria, Professor professor) {

        try {
            gtPrincipal.identificarPermissaoPadrao();
            validarCampos(nome, matricula, coordenadoria);
            professor.setNome(nome);
            professor.setMatricula(matricula);
            professor.setCargaHoraria(cargaHoraria);
            professor.setCoordenadoria(coordenadoria);
            gtPrincipal.getGdPrincipal().getGdProfessor().alterar(professor);
            setProfessorSelecionado(professor);
            return Constantes.ALTERADO;
        } catch (Exception ex) {
            return ex.getMessage();
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
            gtPrincipal.identificarPermissaoPadrao();
            CoordenadorCurso coordenador = gtPrincipal.getGdPrincipal().getGdCoordenador().identificarCoordenadorCurso(professor.getId());
            
            if(coordenador == null){
                gtPrincipal.getGdPrincipal().getGdProfessor().excluirProfessor(professor);
                return Constantes.EXCLUIDO;
            }else
                return "Professor não pode ser excluído pois também é um coordenador";
            
        } catch (SAMHAException ex) {
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

    public Professor getProfessorSelecionado() {
        return professorSelecionado;
    }

    public void setProfessorSelecionado(Professor professorSelecionado) {
        this.professorSelecionado = professorSelecionado;
    }
}

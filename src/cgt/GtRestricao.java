package cgt;

import cdp.Professor;
import cdp.RestricaoProfessor;
import cgd.GdRestricao;
import java.util.List;

public class GtRestricao {
    
    private GdRestricao gdRestricao;
    
    public GtRestricao(){
        gdRestricao = new GdRestricao();
    }
    
    public RestricaoProfessor montarRestricao(String nome, String turno, String dia, String semestre, String descricao, String prioridade, 
            boolean aula1, boolean aula2, boolean aula3, boolean aula4, boolean aula5, boolean aula6){
  
        RestricaoProfessor restricao = new RestricaoProfessor();
        restricao.setAula1(aula1);
        restricao.setAula2(aula2);
        restricao.setAula3(aula3);
        restricao.setAula4(aula4);
        restricao.setAula5(aula5);
        restricao.setAula6(aula6);
        
        restricao.setDescricao(descricao);
        restricao.setDia(dia.toUpperCase());
        restricao.setNome(nome);
        restricao.setPrioridade(prioridade.toUpperCase());
        restricao.setSemestre(semestre);
        restricao.setTurno(turno);
        restricao.setProfessor(null);
        
        return restricao;
    }
    
    public String cadastrar() {

        try {
            //validarCampos(nome, matricula, cargaHoraria);
            //Professor professor = new Professor();
            //professor.setNome(nome);
            //professor.setMatricula(matricula);
            //professor.setCargaHoraria(Double.parseDouble(cargaHoraria));
            //professor.setCoordenadoria(coordenadoria);
            //professor.setRestricoes(listaRestricoes);
            //gdProfessor.cadastrar(professor);
            return Constantes.CADASTRADO;
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
    
    public String alterar() {

        try {
            //validarCampos(nome, matricula, cargaHoraria);
            
            return Constantes.ALTERADO;
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public List<Professor> buscar(String coluna, String texto) {
        return null;

        //if (coluna.toLowerCase().equals("coordenadoria")) {
            //coluna = "coordenadoria_id";
           // return gdProfessor.filtrarPorCoordenadoria(coluna, texto);
        //} else {
           // return gdProfessor.buscar(coluna.toLowerCase(), texto);
        //}
    }

    public List<Professor> consultar() {
        return null;
        //return gdProfessor.consultar(Professor.class);
    }

    public String excluir(Professor professor){
        return null;
        //try {
            //gdProfessor.excluir(professor);
            //return Constantes.EXCLUIDO;
        //} catch (SQLException | ClassNotFoundException ex) {
            //return ex.getMessage();
        //}
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

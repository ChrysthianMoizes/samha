package cgt;

import cgd.GdRestricao;

public class GtRestricao {
    
    private GdRestricao gdRestricao;
    
    public GtRestricao(){
        gdRestricao = new GdRestricao();
    }
    
    public String cadastrar(String nome, String matricula, String cargaHoraria, Coordenadoria coordenadoria, List<RestricaoProfessor> listaRestricoes) {

        try {
            validarCampos(nome, matricula, cargaHoraria);
            Professor professor = new Professor();
            professor.setNome(nome);
            professor.setMatricula(matricula);
            professor.setCargaHoraria(Double.parseDouble(cargaHoraria));
            professor.setCoordenadoria(coordenadoria);
            professor.setRestricoes(listaRestricoes);
            gdProfessor.cadastrar(professor);
            return Constantes.CADASTRADO;
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
    
    public String alterar(String nome, String matricula, String cargaHoraria, Coordenadoria coordenadoria, List<RestricaoProfessor> listaRestricoes, Professor professor) {

        try {
            validarCampos(nome, matricula, cargaHoraria);
            professor.setNome(nome);
            professor.setMatricula(matricula);
            professor.setCargaHoraria(Double.parseDouble(cargaHoraria));
            professor.setCoordenadoria(coordenadoria);
            professor.setRestricoes(listaRestricoes);
            gdProfessor.alterar(professor);
            return Constantes.ALTERADO;
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public List<Professor> buscar(String coluna, String texto) {

        if (coluna.toLowerCase().equals("coordenadoria")) {
            coluna = "coordenadoria_id";
            return gdProfessor.filtrarPorCoordenadoria(coluna, texto);
        } else {
            return gdProfessor.buscar(coluna.toLowerCase(), texto);
        }
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

package cgt;

import cdp.Professor;
import cdp.RestricaoProfessor;
import cgd.GdRestricao;
import java.sql.SQLException;
import java.util.List;

public class GtRestricao {

    private GdRestricao gdRestricao;

    public GtRestricao() {
        gdRestricao = new GdRestricao();
    }

    public RestricaoProfessor cadastrar(String nome, String turno, String dia, String descricao, String prioridade,
            boolean aula1, boolean aula2, boolean aula3, boolean aula4, boolean aula5, boolean aula6, Professor professor) {

        try {

            try {
                validarCampos(nome, descricao);
            } catch (Exception ex) {
                return null;
            }

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
            restricao.setTurno(turno.toUpperCase());
            restricao.setProfessor(professor);
            gdRestricao.cadastrar(restricao);
            return restricao;
        } catch (SQLException | ClassNotFoundException ex) {
            return null;
        }
    }

    public List<RestricaoProfessor> filtrarPorProfessor(int id) {
        return gdRestricao.filtrarPorProfessor(id);
    }

    public String excluir(RestricaoProfessor restricao) {
        try {
            gdRestricao.excluir(restricao);
            return Constantes.EXCLUIDO;
        } catch (SQLException | ClassNotFoundException ex) {
            return ex.getMessage();
        }
    }

    public void validarCampos(String nome, String descricao) throws Exception {
        if (nome.equals("")) {
            throw new SAMHAException(1);
        }
        if (descricao.equals("")) {
            throw new SAMHAException(6);
        }
    }
}

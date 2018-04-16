package cgt;

import cdp.Coordenador;
import cdp.Coordenadoria;
import cdp.Professor;
import cdp.ProfessorCoordenador;
import cdp.Usuario;
import cgd.GdCoordenador;
import java.sql.SQLException;
import java.util.List;

public class GtCoordenador {

    private GdCoordenador gdCoordenador;

    public GtCoordenador() {
        gdCoordenador = new GdCoordenador();
    }

    public String cadastrar(Professor professor, Coordenadoria coordenadoria, String tipo, String login, String senha, String nome, String matricula) {

        try {
            validarCampos(nome, matricula, login, senha);
            Usuario usuario = new Usuario();
            usuario.setLogin(login);
            usuario.setSenha(senha);

            if (tipo.toLowerCase().equals(Constantes.COORD_CURSO)) {

                ProfessorCoordenador profCoord = new ProfessorCoordenador();
                profCoord.setProfessor(professor);
                profCoord.setCoordenadoria(coordenadoria);
                profCoord.setTipo(tipo.toUpperCase());
                profCoord.setUsuario(usuario);
                profCoord.setNome(nome);
                profCoord.setMatricula(matricula);
                gdCoordenador.cadastrar(profCoord);

            } else {

                Coordenador coordenador = new Coordenador();
                coordenador.setMatricula(matricula);
                coordenador.setNome(nome);
                coordenador.setTipo(tipo.toUpperCase());
                coordenador.setUsuario(usuario);
                gdCoordenador.cadastrar(coordenador);
            }
            return Constantes.CADASTRADO;
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public String alterar(Coordenador coordenador, Coordenadoria coordenadoria, Professor professor, String tipo, String login, String senha, String nome, String matricula) {

        try {
            validarCampos(nome, matricula, login, senha);
            coordenador.setNome(nome);
            coordenador.setMatricula(matricula);
            coordenador.getUsuario().setLogin(login);
            coordenador.getUsuario().setSenha(senha);
            coordenador.setTipo(tipo.toUpperCase());

            if (tipo.toLowerCase().equals(Constantes.COORD_CURSO)) {

                ProfessorCoordenador profCoord = (ProfessorCoordenador) coordenador;
                profCoord.setId(coordenador.getId());
                profCoord.setCoordenadoria(coordenadoria);
                profCoord.setProfessor(professor);
                gdCoordenador.alterar(profCoord);

            } else {
                gdCoordenador.alterar(coordenador);
            }
            return Constantes.ALTERADO;
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public String excluir(Coordenador coordenador) {

        try {
            if (coordenador.getTipo().toLowerCase().equals(Constantes.COORD_CURSO)) {

                ProfessorCoordenador profCoord = (ProfessorCoordenador) coordenador;
                gdCoordenador.excluir(profCoord);

            } else {
                gdCoordenador.excluir(coordenador);
            }
            return Constantes.EXCLUIDO;
        } catch (SQLException | ClassNotFoundException ex) {
            return ex.getMessage();
        }
    }

    public List<Coordenador> buscar(String coluna, String texto) {
        if(coluna.toLowerCase().equals("tipo"))
            return gdCoordenador.filtrarPorTipo(coluna.toLowerCase(), texto);
        else
            return gdCoordenador.buscar(coluna.toLowerCase(), texto);
    }

    public void validarCampos(String nome, String matricula, String login, String senha) throws Exception {
        if (nome.equals("")) {
            throw new SAMHAException(1);
        }
        if (matricula.equals("")) {
            throw new SAMHAException(2);
        }
        if (login.equals("")) {
            throw new SAMHAException(3);
        }
        if (senha.equals("")) {
            throw new SAMHAException(4);
        }
    }
}

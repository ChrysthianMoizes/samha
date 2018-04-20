package cgt;

import cdp.Coordenador;
import cdp.Professor;
import cdp.Usuario;
import cgd.GdCoordenador;
import java.util.List;

public class GtCoordenador {

    private GdCoordenador gdCoordenador;

    public GtCoordenador() {
        gdCoordenador = new GdCoordenador();
    }

    public String cadastrar(Professor professor, String tipo, String login, String senha, String nome, String matricula) {

        try {
            validarCampos(nome, matricula, login, senha, tipo, professor);
            Usuario usuario = new Usuario();
            usuario.setLogin(login);
            usuario.setSenha(senha);
            
            Coordenador coordenador = new Coordenador();
            coordenador.setMatricula(matricula);
            coordenador.setNome(nome);
            coordenador.setTipo(tipo.toUpperCase());
            coordenador.setUsuario(usuario);
            
            if(tipo.toLowerCase().equals(Constantes.COORD_CURSO)){
                coordenador.setProfessor(professor);
                professor.getCoordenadoria().setCoordenador(coordenador);
            }
            gdCoordenador.cadastrar(coordenador);
            
            return Constantes.CADASTRADO;
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public String alterar(Coordenador coordenador, Professor professor, String tipo, String login, String senha, String nome, String matricula) {

        try {
            
            validarCampos(nome, matricula, login, senha, tipo, professor);
            coordenador.setNome(nome);
            coordenador.setMatricula(matricula);
            coordenador.getUsuario().setLogin(login);
            coordenador.getUsuario().setSenha(senha);
            coordenador.setTipo(tipo.toUpperCase());

            if(tipo.toLowerCase().equals(Constantes.COORD_CURSO)){
                coordenador.setProfessor(professor);
                professor.getCoordenadoria().setCoordenador(coordenador);
            }
            
            gdCoordenador.alterar(coordenador);
            
            return Constantes.ALTERADO;
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public String excluir(Coordenador coordenador) {

        try {
            if(coordenador.getTipo().toLowerCase().equals(Constantes.COORD_CURSO))
                gdCoordenador.excluirCoordenador(coordenador);
            else
                gdCoordenador.excluir(coordenador);
            
            return Constantes.EXCLUIDO;
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public List<Coordenador> buscar(String coluna, String texto) {
        if(coluna.toLowerCase().equals("tipo"))
            return gdCoordenador.filtrarPorTipo(coluna.toLowerCase(), texto);
        else
            return gdCoordenador.buscar(coluna.toLowerCase(), texto);
    }

    public void validarCampos(String nome, String matricula, String login, String senha, String tipo, Professor professor) throws Exception {
        
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
        
        if(tipo.toLowerCase().equals(Constantes.COORD_CURSO)){
            if(professor == null){
                throw new SAMHAException(7);
            }
        }
    }
}

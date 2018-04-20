package cgt;

import cdp.CoordenadorAcademico;
import cdp.CoordenadorCurso;
import cdp.Professor;
import cdp.Servidor;
import cdp.Usuario;
import cgd.GdUsuario;
import java.util.List;

public class GtCoordenador {

    private GdUsuario gdCoordenador;

    public GtCoordenador() {
        gdCoordenador = new GdUsuario();
    }

    public String cadastrar(Professor professor, String tipo, String login, String senha, String nome, String matricula) {

        try {
            validarCampos(nome, matricula, login, senha, tipo, professor);
            
            if(tipo.toLowerCase().equals(Constantes.COORD_CURSO)){
                CoordenadorCurso coordCurso = new CoordenadorCurso();
                coordCurso.setLogin(login);
                coordCurso.setSenha(senha);
                coordCurso.setProfessor(professor);
                professor.getCoordenadoria().setCoordenador(coordCurso);
                gdCoordenador.cadastrar(coordCurso);
            }else{
                
                Servidor servidor = new Servidor();
                
                servidor.setMatricula(matricula);
                servidor.setNome(nome);
                
                CoordenadorAcademico coordAcademico = new CoordenadorAcademico();
                coordAcademico.setLogin(login);
                coordAcademico.setSenha(senha);
                coordAcademico.setServidor(servidor);
                gdCoordenador.cadastrar(coordAcademico);
            }
                   
            return Constantes.CADASTRADO;
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public String alterar(CoordenadorCurso coordenador, Professor professor, String tipo, String login, String senha, String nome, String matricula) {

        try {
            
            validarCampos(nome, matricula, login, senha, tipo, professor);
            //coordenador.setNome(nome);
            //coordenador.setMatricula(matricula);
            coordenador.setLogin(login);
            coordenador.setSenha(senha);
            coordenador.setProfessor(professor);

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

    public String excluir(Usuario usuario) {

        try {
            if(usuario instanceof CoordenadorCurso)
                gdCoordenador.excluirCoordenadorCurso((CoordenadorCurso)usuario);
            else
                gdCoordenador.excluir(usuario);
            
            return Constantes.EXCLUIDO;
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public List<CoordenadorCurso> buscarCoordenadoresCurso(String coluna, String texto) {
        if(coluna.toLowerCase().equals("tipo"))
            return gdCoordenador.filtrarPorTipo(coluna.toLowerCase(), texto);
        else
            return gdCoordenador.buscarCoordenadoresCurso(coluna.toLowerCase(), texto);
    }
    
    public List<CoordenadorAcademico> buscarCoordenadoresAcademicos(String coluna, String texto) {
        if(coluna.toLowerCase().equals("tipo"))
            return gdCoordenador.filtrarPorTipo(coluna.toLowerCase(), texto);
        else
            return gdCoordenador.buscarCoordenadoresAcademico(coluna.toLowerCase(), texto);
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

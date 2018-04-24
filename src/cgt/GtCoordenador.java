package cgt;

import cdp.CoordenadorAcademico;
import cdp.CoordenadorCurso;
import cdp.CoordenadorPedagogico;
import cdp.Professor;
import cdp.Servidor;
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
                            
                if(tipo.toLowerCase().equals(Constantes.COORD_ACAD)){

                    CoordenadorAcademico coordAcademico = new CoordenadorAcademico();
                    coordAcademico.setLogin(login);
                    coordAcademico.setSenha(senha);
                    coordAcademico.setServidor(servidor);
                    gdCoordenador.cadastrar(coordAcademico);

                }else{
                    
                    CoordenadorPedagogico coorPedagogico = new CoordenadorPedagogico();
                    coorPedagogico.setLogin(login);
                    coorPedagogico.setSenha(senha);
                    coorPedagogico.setServidor(servidor);
                    gdCoordenador.cadastrar(coorPedagogico);
                }
            }            
            return Constantes.CADASTRADO;
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public String alterar(Usuario coordenador, Professor professor, String tipo, String login, String senha, String nome, String matricula) {

        try {
            
            validarCampos(nome, matricula, login, senha, tipo, professor);
            coordenador.setLogin(login);
            coordenador.setSenha(senha);

            if(coordenador instanceof CoordenadorAcademico){
                
                ((CoordenadorAcademico) coordenador).getServidor().setMatricula(matricula);
                ((CoordenadorAcademico) coordenador).getServidor().setNome(nome);
                
            }else if(coordenador instanceof CoordenadorCurso){
                ((CoordenadorCurso) coordenador).setProfessor(professor);
                ((CoordenadorCurso) coordenador).getProfessor().getCoordenadoria().setCoordenador(((CoordenadorCurso) coordenador));        
            
            }else{
                ((CoordenadorPedagogico) coordenador).getServidor().setMatricula(matricula);
                ((CoordenadorPedagogico) coordenador).getServidor().setNome(nome);
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
        return gdCoordenador.buscarCoordenadoresCurso(coluna.toLowerCase(), texto);
    }
    
    public List<CoordenadorAcademico> buscarCoordenadoresAcademicos(String coluna, String texto) {
        return gdCoordenador.buscarCoordenadoresAcademicos(coluna.toLowerCase(), texto);
    }
    
    public List<CoordenadorPedagogico> buscarCoordenadoresPedagogicos(String coluna, String texto) {
        return gdCoordenador.buscarCoordenadoresPedagogicos(coluna.toLowerCase(), texto);
    }
    
    public List buscarCoordenadoresPorTipo(String tipo){
        
        if(tipo.toLowerCase().equals(Constantes.COORD_ACAD))
            return gdCoordenador.consultar(CoordenadorAcademico.class);
        else if(tipo.toLowerCase().equals(Constantes.COORD_CURSO))
            return gdCoordenador.consultar(CoordenadorCurso.class);
        else
            return gdCoordenador.consultar(CoordenadorPedagogico.class);
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

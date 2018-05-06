package cgt;

import cdp.ComparadorUsuario;
import cdp.CoordenadorAcademico;
import cdp.CoordenadorCurso;
import cdp.CoordenadorPedagogico;
import cdp.Curso;
import cdp.Professor;
import cdp.Servidor;
import cdp.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GtCoordenador {

    private GtPrincipal gtPrincipal;

    public GtCoordenador(GtPrincipal gt) {
        gtPrincipal = gt;
    }

    public String cadastrar(Professor professor, Curso curso, String tipo, String login, String senha, String nome, String matricula) {

        try {
            gtPrincipal.identificarPermissaoAdmin();
            validarCampos(nome, matricula, login, senha, tipo, professor, curso);
            
            if(tipo.toLowerCase().equals(Constantes.COORD_CURSO)){
                
                CoordenadorCurso coordCurso = new CoordenadorCurso();
                coordCurso.setLogin(login);
                coordCurso.setSenha(senha);
                coordCurso.setProfessor(professor);
                
                if(curso.getCoordenador() == null){
                    gtPrincipal.getGdPrincipal().getGdCoordenador().cadastrarCoordenadorCurso(curso, coordCurso);
                }else
                    return "Curso já possui coordenador associado.";
 
            }else{
                
                Servidor servidor = new Servidor();
                
                servidor.setMatricula(matricula);
                servidor.setNome(nome);
                            
                if(tipo.toLowerCase().equals(Constantes.COORD_ACAD)){

                    CoordenadorAcademico coordAcademico = new CoordenadorAcademico();
                    coordAcademico.setLogin(login);
                    coordAcademico.setSenha(senha);
                    coordAcademico.setServidor(servidor);
                    gtPrincipal.getGdPrincipal().getGdCoordenador().cadastrar(coordAcademico);

                }else{
                    
                    CoordenadorPedagogico coorPedagogico = new CoordenadorPedagogico();
                    coorPedagogico.setLogin(login);
                    coorPedagogico.setSenha(senha);
                    coorPedagogico.setServidor(servidor);
                    gtPrincipal.getGdPrincipal().getGdCoordenador().cadastrar(coorPedagogico);
                }
            }            
            return Constantes.CADASTRADO;
            
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public String alterar(Usuario coordenador, Professor professor, Curso curso, String tipo, String login, String senha, String nome, String matricula) {

        try {
            gtPrincipal.identificarPermissaoAdmin();
            validarCampos(nome, matricula, login, senha, tipo, professor, curso);
            coordenador.setLogin(login);
            coordenador.setSenha(senha);

            if(coordenador instanceof CoordenadorAcademico){
                
                ((CoordenadorAcademico) coordenador).getServidor().setMatricula(matricula);
                ((CoordenadorAcademico) coordenador).getServidor().setNome(nome);
                gtPrincipal.getGdPrincipal().getGdCoordenador().alterar(coordenador);
                
            }else if(coordenador instanceof CoordenadorCurso){
                ((CoordenadorCurso) coordenador).setProfessor(professor);
                
                if(curso.getCoordenador().getId() == coordenador.getId()){
                    gtPrincipal.getGdPrincipal().getGdCoordenador().alterarCoordenadorCurso(curso, (CoordenadorCurso) coordenador);
                }else
                    return "Curso já possui coordenador associado.";
 
            }else{
                ((CoordenadorPedagogico) coordenador).getServidor().setMatricula(matricula);
                ((CoordenadorPedagogico) coordenador).getServidor().setNome(nome);
                gtPrincipal.getGdPrincipal().getGdCoordenador().alterar(coordenador);
            }                       
            
            return Constantes.ALTERADO;
            
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public String excluir(Usuario usuario) {

        try {
            gtPrincipal.identificarPermissaoAdmin();
            if(usuario instanceof CoordenadorCurso)
                gtPrincipal.getGdPrincipal().getGdCoordenador().excluirCoordenadorCurso((CoordenadorCurso)usuario);
            else
                gtPrincipal.getGdPrincipal().getGdCoordenador().excluir(usuario);
            
            return Constantes.EXCLUIDO;
            
        } catch (SAMHAException | ClassNotFoundException | SQLException ex) {
            return ex.getMessage();
        }
    }

    public List<CoordenadorCurso> listarCoordenadores(String coluna, String texto) {
        
        List listaCoordenadoresCurso = gtPrincipal.getGdPrincipal().getGdCoordenador().buscarCoordenadoresCurso(coluna.toLowerCase(), texto);
        List listaCoordenadoresAcademicos = gtPrincipal.getGdPrincipal().getGdCoordenador().buscarCoordenadoresAcademicos(coluna.toLowerCase(), texto);
        List listaCoordenadoresPedagogicos = gtPrincipal.getGdPrincipal().getGdCoordenador().buscarCoordenadoresPedagogicos(coluna.toLowerCase(), texto);

        List listaCoordenadores = new ArrayList<>();

        listaCoordenadores.addAll(listaCoordenadoresAcademicos);
        listaCoordenadores.addAll(listaCoordenadoresCurso);
        listaCoordenadores.addAll(listaCoordenadoresPedagogicos);
        Collections.sort(listaCoordenadores, new ComparadorUsuario());
        
        return listaCoordenadores;
    }
    
    public List buscarCoordenadoresPorTipo(String tipo){
        
        List lista;
        
        switch (tipo.toLowerCase()) {
            
            case Constantes.COORD_ACAD:
                lista = gtPrincipal.getGdPrincipal().getGdCoordenador().consultar(CoordenadorAcademico.class);
                break;
            case Constantes.COORD_CURSO:
                lista = gtPrincipal.getGdPrincipal().getGdCoordenador().consultar(CoordenadorCurso.class);
                break;
            default:
                lista = gtPrincipal.getGdPrincipal().getGdCoordenador().consultar(CoordenadorPedagogico.class);
                break;
        }
        
        Collections.sort(lista, new ComparadorUsuario());
        return lista;
    }

    public void validarCampos(String nome, String matricula, String login, String senha, String tipo, Professor professor, Curso curso) throws Exception {
        
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
            if(curso == null){
                throw new SAMHAException(12);
            }    
        }
    }
}

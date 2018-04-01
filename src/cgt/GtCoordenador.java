package cgt;

import cdp.Coordenador;
import cdp.Coordenadoria;
import cdp.Professor;
import cdp.ProfessorCoordenador;
import cdp.Usuario;
import cgd.GdCoordenador;
import java.util.List;

public class GtCoordenador {
    
    private GdCoordenador gdCoordenador;

    public GtCoordenador() {
        gdCoordenador = new GdCoordenador();
    }
     
    public void cadastrar(Professor professor, Coordenadoria coordenadoria, String tipo, String login, String senha, String nome, String matricula) throws Exception{
       
        validarCampos(nome, matricula, login, senha);
        Usuario usuario = new Usuario(login, senha);
              
        if(tipo.equals("COORDENADOR DE CURSO")){
            ProfessorCoordenador profCoord = new ProfessorCoordenador(professor, coordenadoria, tipo, usuario, nome, matricula);
            gdCoordenador.cadastrar(profCoord);
        }else{
            Coordenador coordenador = new Coordenador(tipo, usuario, nome, matricula);
            gdCoordenador.cadastrar(coordenador); 
        }    
    } 
    
    public void alterar(Coordenador coordenador, Coordenadoria coordenadoria, Professor professor, String tipo, String login, String senha, String nome, String matricula) throws Exception{
       
        validarCampos(nome, matricula, login, senha);
        coordenador.setNome(nome);
        coordenador.setMatricula(matricula);
        coordenador.getUsuario().setLogin(login);
        coordenador.getUsuario().setSenha(senha);
        coordenador.setTipo(tipo);
           
        if(tipo.equals("COORDENADOR DE CURSO")){
            ProfessorCoordenador profCoord = (ProfessorCoordenador) coordenador;
            profCoord.setId(coordenador.getId());
            profCoord.setCoordenadoria(coordenadoria);
            profCoord.setProfessor(professor);
            gdCoordenador.alterar(profCoord);
        }else
            gdCoordenador.alterar(coordenador);   
    } 
    
    public List<Coordenador> buscar(String coluna, String texto) {
        return gdCoordenador.buscar(coluna, texto);
    }

    public void validarCampos(String nome, String matricula, String login, String senha) throws Exception {
            if(nome.equals(""))
                throw new SAMHAException(1);
            if(matricula.equals(""))
                throw new SAMHAException(2);
            if(login.equals(""))
                throw new SAMHAException(3);
            if(senha.equals(""))
                throw new SAMHAException(4);
        }    
}

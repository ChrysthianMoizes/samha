package cgt;

import cdp.Coordenador;
import cdp.Coordenadoria;
import cdp.Curso;
import cdp.Eixo;
import cgd.GdCoordenador;
import cgd.GdCoordenadoria;
import cgd.GdCurso;
import java.util.List;

public class GtCoordenadoria {
    
    private GdCoordenadoria gdCoordenadoria;
    private GdCoordenador gdCoordenador;
    private GdCurso gdCurso;

    public GtCoordenadoria() {        
        gdCoordenadoria = new GdCoordenadoria();
        gdCoordenador = new GdCoordenador();
        gdCurso = new GdCurso();
    }
    
    public String cadastrar(String nome, Eixo eixo) {

        try {
            Coordenadoria coordenadoria = new Coordenadoria();
            coordenadoria.setNome(nome.toUpperCase());
            coordenadoria.setEixo(eixo);
            
            gdCoordenadoria.cadastrar(coordenadoria);
            return Constantes.CADASTRADO;
            
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
    
    public String excluir(Coordenadoria coordenadoria) {

        try {
            
            //Coordenador coordenador = gdCoordenador.filtrarProfessorCoordenadorUnico("coordenadoria.id", coordenadoria.getId());
            
            if(coordenadoria.getCoordenador() == null){
                
                Curso curso = gdCurso.filtrarCursoUnico("coordenadoria.id", coordenadoria.getId());
                
                if(curso == null){
                    gdCoordenadoria.excluir(coordenadoria);
                    return Constantes.EXCLUIDO;
                }else
                    return "Coordenadoria possui curso associado";  
            }else
                return "Coordenadoria possui coordenador associado";
            
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
    
    public List<Coordenadoria> buscar(String coluna, String texto) {
        return gdCoordenadoria.buscar(coluna.toLowerCase(), texto);
    }
    
    public List<Coordenadoria> filtrarCoordenadoriasEixo(int id) {
        return gdCoordenadoria.filtrarCoordenadoriasEixo("eixo.id", id);
    }

    public List<Coordenadoria> listar() {
       return gdCoordenadoria.consultar(Coordenadoria.class);
    }    
}

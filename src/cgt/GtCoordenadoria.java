package cgt;

import cdp.Coordenadoria;
import cdp.Eixo;
import cgd.GdCoordenador;
import cgd.GdCoordenadoria;
import cgd.GdCurso;
import cgd.GdProfessor;
import java.util.Collections;
import java.util.List;

public class GtCoordenadoria {
    
    private GdCoordenadoria gdCoordenadoria;
    private GdCoordenador gdCoordenador;
    private GdCurso gdCurso;
    private GdProfessor gdProfessor;

    public GtCoordenadoria() {        
        gdCoordenadoria = new GdCoordenadoria();
        gdCoordenador = new GdCoordenador();
        gdCurso = new GdCurso();
        gdProfessor = new GdProfessor();
    }
    
    public String cadastrar(String nome, Eixo eixo) {

        try {
            validarCampos(nome, eixo);
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
           
            if(coordenadoria.getCurso().getCoordenador() == null){
                
                if(coordenadoria.getCurso() == null){
                                     
                    List listaProfessores = gdProfessor.filtrarPorCoordenadoria("coordenadoria.id", coordenadoria.getId());
                    
                    if(listaProfessores.size() == 0){
                        gdCoordenadoria.excluir(coordenadoria);
                        return Constantes.EXCLUIDO;
                        
                    }else
                        return "Coordenadoria possui professores associados";                    
                }else
                    return "Coordenadoria possui curso associado";  
            }else
                return "Coordenadoria possui coordenador associado";
            
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
    
    public List<Coordenadoria> buscar(String coluna, String texto) {
        
        List lista = gdCoordenadoria.buscar(coluna.toLowerCase(), texto);
        Collections.sort(lista);
        return lista;
    }
    
    public List<Coordenadoria> filtrarCoordenadoriasEixo(int id) {
        List lista = gdCoordenadoria.filtrarCoordenadoriasEixo("eixo.id", id);
        Collections.sort(lista);
        return lista;
    }

    public List<Coordenadoria> listar() {
        List lista = gdCoordenadoria.consultar(Coordenadoria.class);
        Collections.sort(lista);
        return lista;
    }

    public void validarCampos(String nome, Eixo eixo) throws SAMHAException{
        
        if((nome.equals("")))
            throw new SAMHAException(1);
        
        if(eixo == null)
            throw new SAMHAException(8);
    }       
}

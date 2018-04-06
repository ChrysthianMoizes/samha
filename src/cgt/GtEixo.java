package cgt;

import cdp.Eixo;
import cgd.GdEixo;
import java.util.List;

public class GtEixo {
    
    private GdEixo gdEixo;

    public GtEixo() {  
        gdEixo = new GdEixo();
    }
    
    public String cadastrar(String nome) {

        try {
            Eixo eixo = new Eixo();
            eixo.setNome(nome);
            
            gdEixo.cadastrar(eixo);
            return Constantes.CADASTRADO;
            
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
    
    public String excluir(Eixo eixo) {

        try {
            if (coordenador.getTipo().equals("COORDENADOR DE CURSO")) {

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
   
    public List<Eixo> consultar() {
        return gdEixo.consultar(Eixo.class);
    }
}

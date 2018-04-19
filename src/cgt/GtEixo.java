package cgt;

import cdp.Eixo;
import cgd.GdEixo;
import java.util.List;

public class GtEixo {
    
    private GdEixo gdEixo;
    private GtCoordenadoria gtCoordenadoria;

    public GtEixo() {  
        gdEixo = new GdEixo();
        gtCoordenadoria = new GtCoordenadoria();
    }
    
    public String cadastrar(String nome) {

        try {
            validarCampos(nome);
            Eixo eixo = new Eixo();
            eixo.setNome(nome.toUpperCase());
            
            gdEixo.cadastrar(eixo);
            return Constantes.CADASTRADO;
            
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
    
    public String excluir(Eixo eixo) {

        try {
            
            List coordenadorias = gtCoordenadoria.filtrarCoordenadoriasEixo(eixo.getId());
            
            if(coordenadorias.size() == 0){
                gdEixo.excluir(eixo);
                return Constantes.EXCLUIDO;
            }else
                return "Eixo possui coordenadorias associadas";
            
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
   
    public List<Eixo> consultar() {
        return gdEixo.consultar(Eixo.class);
    }
    
    public void validarCampos(String nome) throws SAMHAException{
        
        if((nome.equals("")))
            throw new SAMHAException(1);
    }
}

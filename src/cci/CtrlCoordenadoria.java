package cci;

import cdp.Coordenadoria;
import cdp.Eixo;
import cgt.Constantes;
import cgt.GtCoordenadoria;
import java.util.List;

public class CtrlCoordenadoria {
    
    private GtCoordenadoria gtCoordenadoria;
    private CtrlPrincipal ctrlPrincipal;

    public CtrlCoordenadoria(CtrlPrincipal ctrl) {
        gtCoordenadoria = new GtCoordenadoria();
        this.ctrlPrincipal = ctrl;
    }
    
    public int cadastrar(String nome, Eixo eixo){
        
        String resposta = gtCoordenadoria.cadastrar(nome, eixo);

        if (resposta.equals(Constantes.CADASTRADO)) {
            return 0;
        } else {
            ctrlPrincipal.getCtrlMensagem().exibirMensagemErro(null, resposta);
            return 1;
        }   
    }
    
    public int excluir(Coordenadoria coordenadoria) {

        String resposta = gtCoordenadoria.excluir(coordenadoria);
        if (resposta.equals(Constantes.EXCLUIDO)) {
            return 0;
        } else {
            ctrlPrincipal.getCtrlMensagem().exibirMensagemErro(null, resposta);
            return 1;
        }
    }
    
    public List<Coordenadoria> filtrarCoordenadoriasEixo(int id) {
        return gtCoordenadoria.filtrarCoordenadoriasEixo(id);
    }
    
    public List<Coordenadoria> buscar(String coluna, String texto) {
       return gtCoordenadoria.buscar(coluna, texto);
    }
    
    public List<Coordenadoria> listar() {
       return gtCoordenadoria.listar();
    }
}

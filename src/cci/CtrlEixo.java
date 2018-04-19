package cci;

import cdp.Eixo;
import cgt.Constantes;
import cgt.GtEixo;
import java.util.List;

public class CtrlEixo {
    
    private CtrlPrincipal ctrlPrincipal;
    private GtEixo gtEixo;

    public CtrlEixo(CtrlPrincipal ctrl) {
        ctrlPrincipal = ctrl;
        gtEixo = new GtEixo();
    }
    
    public int cadastrar(String nome){
        
        if(validarCampos(nome)){
        
            String resposta = gtEixo.cadastrar(nome);

            if (resposta.equals(Constantes.CADASTRADO)) {
                CtrlMensagem.exibirMensagemSucesso(null, "Cadastrado Com sucesso!");
                return 0;
            } else {
                CtrlMensagem.exibirMensagemErro(null, resposta);
                return 1;
            } 
        }else{
            CtrlMensagem.exibirMensagemAviso(null, "Campo NOME inválido");
            return 1;
        }
    }
    
    public int excluir(Eixo eixo) {

        String resposta = gtEixo.excluir(eixo);
        if (resposta.equals(Constantes.EXCLUIDO)) {
            return 0;
        } else {
            CtrlMensagem.exibirMensagemErro(null, resposta);
            return 1;
        }
    }
    
    public List<Eixo> consultar() {
        return gtEixo.consultar();
    }
    
    public boolean validarCampos(String nome){
        
        if((nome.equals("")))
            return false;
        return true;
    }
}

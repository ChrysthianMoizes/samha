package cci;

import cdp.Eixo;
import cgt.Constantes;
import java.util.List;

public class CtrlEixo {
    
    private CtrlPrincipal ctrlPrincipal;

    public CtrlEixo(CtrlPrincipal ctrl) {
        ctrlPrincipal = ctrl;
    }
    
    public int cadastrar(String nome){
        
        if(validarCampos(nome)){
        
            String resposta = ctrlPrincipal.getGtPrincipal().getGtEixo().cadastrar(nome);

            if (resposta.equals(Constantes.CADASTRADO)) {
                CtrlMensagem.exibirMensagemSucesso(null, "Cadastrado Com sucesso!");
                return 0;
            } else {
                CtrlMensagem.exibirMensagemErro(null, resposta);
                return 1;
            } 
        }else{
            CtrlMensagem.exibirMensagemAviso(null, "Campo nome do EIXO inválido");
            return 1;
        }
    }
    
    public int excluir(Eixo eixo) {

        String resposta = ctrlPrincipal.getGtPrincipal().getGtEixo().excluir(eixo);
        if (resposta.equals(Constantes.EXCLUIDO)) {
            return 0;
        } else {
            CtrlMensagem.exibirMensagemErro(null, resposta);
            return 1;
        }
    }
    
    public List<Eixo> consultar() {
        return ctrlPrincipal.getGtPrincipal().getGtEixo().consultar();
    }
    
    public boolean validarCampos(String nome){
        
        if((nome.equals("")))
            return false;
        return true;
    }
}

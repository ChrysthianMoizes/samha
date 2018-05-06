package cci;

import cdp.Coordenadoria;
import cdp.Eixo;
import cgt.Constantes;
import java.util.List;

public class CtrlCoordenadoria {
    
    private CtrlPrincipal ctrlPrincipal;

    public CtrlCoordenadoria(CtrlPrincipal ctrl) {
        this.ctrlPrincipal = ctrl;
    }
    
    public int cadastrar(String nome, Eixo eixo){
        
        if (validarCampos(nome)) {

            String resposta = ctrlPrincipal.getGtPrincipal().getGtCoordenadoria().cadastrar(nome, eixo);

            if (resposta.equals(Constantes.CADASTRADO)) {
                CtrlMensagem.exibirMensagemSucesso(null, "Cadastrado Com sucesso!");
                return 0;
            } else {
                CtrlMensagem.exibirMensagemErro(null, resposta);
                return 1;
            }
        } else {
            CtrlMensagem.exibirMensagemAviso(null, "Campo nome da COORDENADORIA inválido");
            return 1;
        }
    }
    
    public int excluir(Coordenadoria coordenadoria) {

        String resposta = ctrlPrincipal.getGtPrincipal().getGtCoordenadoria().excluir(coordenadoria);
        if (resposta.equals(Constantes.EXCLUIDO)) {
            return 0;
        } else {
            CtrlMensagem.exibirMensagemErro(null, resposta);
            return 1;
        }
    }
    
    public List<Coordenadoria> filtrarCoordenadoriasEixo(int id) {
        return ctrlPrincipal.getGtPrincipal().getGtCoordenadoria().filtrarCoordenadoriasEixo(id);
    }
    
    public List<Coordenadoria> buscar(String coluna, String texto) {
       return ctrlPrincipal.getGtPrincipal().getGtCoordenadoria().buscar(coluna, texto);
    }
    
    public List<Coordenadoria> consultar() {
       return ctrlPrincipal.getGtPrincipal().getGtCoordenadoria().listar();
    }
    
    public boolean validarCampos(String nome){
        
        if((nome.equals("")))
            return false;
        return true;
    }
}

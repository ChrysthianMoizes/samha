package cci;

import cdp.Curso;
import cdp.MatrizCurricular;
import cgt.Constantes;
import java.util.List;

public class CtrlMatriz {
    
    private CtrlPrincipal ctrlPrincipal;

    public CtrlMatriz(CtrlPrincipal ctrl) {
        this.ctrlPrincipal = ctrl;
    }
    
    public int cadastrar(String nome, int ano, int semestre, Curso curso){
        
        if(validarCampos(nome)){
            
            String resposta = ctrlPrincipal.getGtPrincipal().getGtMatriz().cadastrar(nome, ano, semestre, curso);

            if (resposta.equals(Constantes.CADASTRADO)) {
                return 0;
            } else {
                CtrlMensagem.exibirMensagemErro(null, resposta);
                return 1;
            }   
        }else{
            CtrlMensagem.exibirMensagemAviso(null, "Campo nome da MATRIZ inválido");
            return 1;
        }
    }
    
    public int excluir(MatrizCurricular matriz) {

        String resposta = ctrlPrincipal.getGtPrincipal().getGtMatriz().excluir(matriz);
        if (resposta.equals(Constantes.EXCLUIDO)) {
            return 0;
        } else {
            CtrlMensagem.exibirMensagemErro(null, resposta);
            return 1;
        }
    }
    
    public List<MatrizCurricular> filtrarMatrizCurso(int id) {
        return ctrlPrincipal.getGtPrincipal().getGtMatriz().filtrarMatrizCurso(id);
    }
    
    public boolean validarCampos(String nome){
        
        if((nome.equals("")))
            return false;
        return true;
    } 
}

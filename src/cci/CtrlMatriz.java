package cci;

import cdp.Curso;
import cdp.MatrizCurricular;
import cgt.Constantes;
import cgt.GtMatriz;
import java.util.List;

public class CtrlMatriz {
    
    private CtrlPrincipal ctrlPrincipal;
    private GtMatriz gtMatriz;

    public CtrlMatriz(CtrlPrincipal ctrl) {
        this.ctrlPrincipal = ctrl;
        gtMatriz = new GtMatriz();
    }
    
    public int cadastrar(String nome, int ano, int semestre, Curso curso){
        
        String resposta = gtMatriz.cadastrar(nome, ano, semestre, curso);

        if (resposta.equals(Constantes.CADASTRADO)) {
            return 0;
        } else {
            CtrlMensagem.exibirMensagemErro(null, resposta);
            return 1;
        }   
    }
    
    public int excluir(MatrizCurricular matriz) {

        String resposta = gtMatriz.excluir(matriz);
        if (resposta.equals(Constantes.EXCLUIDO)) {
            return 0;
        } else {
            CtrlMensagem.exibirMensagemErro(null, resposta);
            return 1;
        }
    }
    
    public List<MatrizCurricular> filtrarMatrizCurso(int id) {
        return gtMatriz.filtrarMatrizCurso(id);
    }
    
}

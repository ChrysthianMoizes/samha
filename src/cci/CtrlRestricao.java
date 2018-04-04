package cci;

import cdp.RestricaoProfessor;
import cgt.GtRestricao;

public class CtrlRestricao {
    
    private GtRestricao gtRestricao;

    public CtrlRestricao() {
        gtRestricao = new GtRestricao();
    }
    
    public RestricaoProfessor montarRestricao(String nome, String turno, String dia, String semestre, String descricao, String prioridade, 
            boolean aula1, boolean aula2, boolean aula3, boolean aula4, boolean aula5, boolean aula6){
        
        return gtRestricao.montarRestricao(nome, turno, dia, semestre, descricao, prioridade, aula1, aula2, aula3, aula4, aula5, aula6);
    }
    
    public void cadastrar() {

        //String resposta = gtProfessor.cadastrar(nome, matricula, cargaHoraria, coordenadoria, listaRestricoes);
        //if (resposta.equals(Constantes.CADASTRADO))
            //ctrlPrincipal.getCtrlMensagem().exibirMensagemSucesso(cadastraProf, "Cadastrado com sucesso!");
        //else
            //ctrlPrincipal.getCtrlMensagem().exibirMensagemErro(cadastraProf, resposta);
    }
    
    public void alterar() {

        //String resposta = gtProfessor.alterar(nome, matricula, cargaHoraria, coordenadoria, listaRestricoes, professor);
        //if (resposta.equals(Constantes.ALTERADO))
          //  ctrlPrincipal.getCtrlMensagem().exibirMensagemSucesso(cadastraProf, "Alterado com sucesso!");
       // else
         //   ctrlPrincipal.getCtrlMensagem().exibirMensagemErro(cadastraProf, resposta);
    }

    public void excluir() {
        
            //String resposta = gtProfessor.excluir(professor);
            //if(resposta.equals(Constantes.EXCLUIDO))
                //ctrlPrincipal.getCtrlMensagem().exibirMensagemSucesso(buscaProf, "Excluído com sucesso!");
           // else
               //ctrlPrincipal.getCtrlMensagem().exibirMensagemErro(buscaProf, resposta);
    }
    
}

package cci;

import cgt.GtRestricao;

public class CtrlRestricao {
    
    private GtRestricao gtRestricao;

    public CtrlRestricao() {
        gtRestricao = new GtRestricao();
    }
    
    public void cadastrar(String nome, String matricula, String cargaHoraria, Coordenadoria coordenadoria, List<RestricaoProfessor> listaRestricoes) {

        String resposta = gtProfessor.cadastrar(nome, matricula, cargaHoraria, coordenadoria, listaRestricoes);
        if (resposta.equals(Constantes.CADASTRADO))
            ctrlPrincipal.getCtrlMensagem().exibirMensagemSucesso(cadastraProf, "Cadastrado com sucesso!");
        else
            ctrlPrincipal.getCtrlMensagem().exibirMensagemErro(cadastraProf, resposta);
    }
    
    public void alterar(String nome, String matricula, String cargaHoraria, Coordenadoria coordenadoria, List<RestricaoProfessor> listaRestricoes, Professor professor) {

        String resposta = gtProfessor.alterar(nome, matricula, cargaHoraria, coordenadoria, listaRestricoes, professor);
        if (resposta.equals(Constantes.ALTERADO))
            ctrlPrincipal.getCtrlMensagem().exibirMensagemSucesso(cadastraProf, "Alterado com sucesso!");
        else
            ctrlPrincipal.getCtrlMensagem().exibirMensagemErro(cadastraProf, resposta);
    }

    public List<Professor> consultar() {
        return gtProfessor.consultar();
    }

    public void excluir(Professor professor) {
        
            String resposta = gtProfessor.excluir(professor);
            if(resposta.equals(Constantes.EXCLUIDO))
                ctrlPrincipal.getCtrlMensagem().exibirMensagemSucesso(buscaProf, "Excluído com sucesso!");
            else
                ctrlPrincipal.getCtrlMensagem().exibirMensagemErro(buscaProf, resposta);
    }
    
}

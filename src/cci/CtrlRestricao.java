package cci;

import cdp.Professor;
import cdp.RestricaoProfessor;
import cgt.Constantes;
import java.util.List;

public class CtrlRestricao {

    private CtrlPrincipal ctrlPrincipal;

    public CtrlRestricao(CtrlPrincipal ctrl) {
        this.ctrlPrincipal = ctrl;
    }

    public RestricaoProfessor cadastrar(String nome, String turno, int dia, String descricao, String prioridade,
            boolean aula1, boolean aula2, boolean aula3, boolean aula4, boolean aula5, boolean aula6, Professor professor) {

        RestricaoProfessor restricao = ctrlPrincipal.getGtPrincipal().getGtRestricao().cadastrar(nome, turno, dia, descricao, prioridade, aula1, aula2, aula3, aula4, aula5, aula6, professor);

        if (restricao == null) {
            CtrlMensagem.exibirMensagemErro(null, "Todos os campos devem ser preenchidos");
        }
        return restricao;
    }
    
    public List<RestricaoProfessor> filtrarPorProfessor(int id) {
        return ctrlPrincipal.getGtPrincipal().getGtRestricao().filtrarPorProfessor(id);
    }

    public int excluir(RestricaoProfessor restricao) {

        String resposta = ctrlPrincipal.getGtPrincipal().getGtRestricao().excluir(restricao);
        if (resposta.equals(Constantes.EXCLUIDO)) {
            return 0;
        } else {
            CtrlMensagem.exibirMensagemErro(null, resposta);
            return 1;
        }
    }
}

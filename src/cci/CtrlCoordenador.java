package cci;

import cdp.Coordenador;
import cdp.Coordenadoria;
import cdp.Professor;
import cgt.Constantes;
import cgt.GtCoordenador;
import cih.coordenador.JDBuscarCoordenador;
import cih.coordenador.JDCadastrarCoordenador;
import java.awt.Frame;
import java.util.List;
import javax.swing.ImageIcon;

public class CtrlCoordenador {

    private JDBuscarCoordenador buscaCoord;
    private JDCadastrarCoordenador cadastraCoord;
    private CtrlPrincipal ctrlPrincipal;
    private GtCoordenador gtCoordenador;

    public CtrlCoordenador(CtrlPrincipal ctrl) {
        this.ctrlPrincipal = ctrl;
        gtCoordenador = new GtCoordenador();
    }
    
    public ImageIcon setarIconeJanela() {
        ImageIcon icone = new ImageIcon("build/classes/cih/img/coordenador.png");
        return icone;
    }

    public void instanciarTelaBuscaCoordenador(Frame pai) {
        buscaCoord = new JDBuscarCoordenador(pai, true, ctrlPrincipal);
        buscaCoord.setVisible(true);
    }

    public void instanciarTelaCadastroCoordenador(Coordenador coord, Frame pai) {
        cadastraCoord = new JDCadastrarCoordenador(pai, true, ctrlPrincipal, coord);
        cadastraCoord.setVisible(true);
    }

    public void cadastrar(Professor professor, Coordenadoria coordenadoria, String tipo, String login, String senha, String nome, String matricula) {

        String resposta = gtCoordenador.cadastrar(professor, coordenadoria, tipo, login, senha, nome, matricula);

        if (resposta.equals(Constantes.CADASTRADO)) {
            ctrlPrincipal.getCtrlMensagem().exibirMensagemSucesso(cadastraCoord, "Cadastrado Com sucesso!");
        } else {
            ctrlPrincipal.getCtrlMensagem().exibirMensagemErro(cadastraCoord, resposta);
        }
    }

    public void alterar(Coordenador coordenador, Coordenadoria coordenadoria, Professor professor, String tipo, String login, String senha, String nome, String matricula) {

        String resposta = gtCoordenador.alterar(coordenador, coordenadoria, professor, tipo, login, senha, nome, matricula);
        if (resposta.equals(Constantes.ALTERADO)) {
            ctrlPrincipal.getCtrlMensagem().exibirMensagemSucesso(cadastraCoord, "Alterado Com sucesso!");
        } else {
            ctrlPrincipal.getCtrlMensagem().exibirMensagemErro(cadastraCoord, resposta);
        }
    }

    public void excluir(Coordenador coordenador) {

        String resposta = gtCoordenador.excluir(coordenador);
        if (resposta.equals(Constantes.EXCLUIDO)) {
            ctrlPrincipal.getCtrlMensagem().exibirMensagemSucesso(buscaCoord, "Excluído com sucesso!");
        } else {
            ctrlPrincipal.getCtrlMensagem().exibirMensagemErro(buscaCoord, resposta);
        }
    }

    public List<Coordenador> buscar(String coluna, String texto) {
        return gtCoordenador.buscar(coluna, texto);
    }
}

package cci;

import cgd.Config;
import cgt.GtPrincipal;
import cgt.Constantes;
import cih.principal.FrmPrincipal;
import cih.principal.FrmValidarAcesso;
import cih.principal.JPInicio;
import java.awt.Frame;
import javax.swing.ImageIcon;

public final class CtrlPrincipal {

    private Config config;
    private Frame frmValidarAcesso;
    private Frame frmPrincipal;
    private JPInicio inicio;
    private static int permissao;
    private GtPrincipal gtPrincipal;
    private CtrlProfessor ctrlProfessor;
    private CtrlCoordenador ctrlCoordenador;
    private CtrlMensagem ctrlMensagem;
    private CtrlCoordenadoria ctrlCoordenadoria;
    private CtrlRestricao ctrlRestricao;
    private CtrlCurso ctrlCurso;
    private CtrlEixo ctrlEixo;
    private CtrlDisciplina ctrlDisciplina;
    private CtrlMatriz ctrlMatriz;

    public CtrlPrincipal() {
        config = new Config();
        gtPrincipal = new GtPrincipal();
        ctrlCoordenador = new CtrlCoordenador(this);
        ctrlProfessor = new CtrlProfessor(this);
        ctrlCoordenadoria = new CtrlCoordenadoria(this);
        ctrlRestricao = new CtrlRestricao(this);
        ctrlCurso = new CtrlCurso(this);
        ctrlEixo = new CtrlEixo(this);
        ctrlDisciplina = new CtrlDisciplina(this);
        ctrlMatriz = new CtrlMatriz(this);
        instanciarFrameValidarAcesso();
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CtrlPrincipal();
            }
        });
    }

    public void instanciarFrameValidarAcesso() {
        frmValidarAcesso = new FrmValidarAcesso(this);
        frmValidarAcesso.setVisible(true);
    }

    public void instanciarFramePrincipal() {
        frmPrincipal = new FrmPrincipal(this);
        frmPrincipal.setExtendedState(Frame.MAXIMIZED_BOTH);
        frmPrincipal.setVisible(true);
    }

    public JPInicio instanciarPainelInicio(FrmPrincipal pai) {
        inicio = new JPInicio(pai, this);
        return inicio;
    }

    public ImageIcon setarIconeJanela() {
        ImageIcon icone = new ImageIcon("build/classes/cih/img/logo.jpg");
        return icone;
    }

    public void validarAcesso(String login, String senha) {

        int permissao = gtPrincipal.validarAcesso(login, senha);
        setPermissao(permissao);
        if (permissao == Constantes.PERMISSAO_NEGADA) {
            CtrlMensagem.exibirMensagemErro(null, "Acesso Negado!");
        } else {
            instanciarFramePrincipal();
            frmValidarAcesso.dispose();
        }
    }

    public void encerrarSessao() {

        int confirmacao = CtrlMensagem.exibirMensagemConfirmacao(frmPrincipal, "Deseja Sair ?");
        if (confirmacao == 0) {
            gtPrincipal.encerrarSessao();
            instanciarFrameValidarAcesso();
            frmPrincipal.dispose();
        }
    }

    public Config getConfig() {
        return config;
    }

    public void setConfig(Config config) {
        this.config = config;
    }

    public Frame getFrmValidarAcesso() {
        return frmValidarAcesso;
    }

    public void setFrmValidarAcesso(Frame frmValidarAcesso) {
        this.frmValidarAcesso = frmValidarAcesso;
    }

    public Frame getFrmPrincipal() {
        return frmPrincipal;
    }

    public void setFrmPrincipal(Frame frmPrincipal) {
        this.frmPrincipal = frmPrincipal;
    }

    public static int getPermissao() {
        return permissao;
    }

    public static void setPermissao(int permissao) {
        CtrlPrincipal.permissao = permissao;
    }

    public GtPrincipal getGtPrincipal() {
        return gtPrincipal;
    }

    public CtrlProfessor getCtrlProfessor() {
        return ctrlProfessor;
    }

    public CtrlCoordenador getCtrlCoordenador() {
        return ctrlCoordenador;
    }

    public CtrlMensagem getCtrlMensagem() {
        return ctrlMensagem;
    }

    public CtrlCoordenadoria getCtrlCoordenadoria() {
        return ctrlCoordenadoria;
    }

    public CtrlRestricao getCtrlRestricao() {
        return ctrlRestricao;
    }

    public CtrlCurso getCtrlCurso() {
        return ctrlCurso;
    }

    public CtrlEixo getCtrlEixo() {
        return ctrlEixo;
    }

    public CtrlDisciplina getCtrlDisciplina() {
        return ctrlDisciplina;
    }

    public CtrlMatriz getCtrlMatriz() {
        return ctrlMatriz;
    }
}

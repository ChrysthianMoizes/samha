package cci;

import cgd.Config;
import cgt.GtPrincipal;
import cgt.Constantes;
import cih.principal.FrmInicio;
import cih.oferta.FrmOferta;
import cih.principal.FrmValidarAcesso;
import cih.principal.JPInicio;
import java.awt.Frame;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public final class CtrlPrincipal {

    private Config config;
    private FrmValidarAcesso frmValidarAcesso;
    private FrmInicio frmInicio;
    private Frame frmOferta;
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
    private CtrlTurma ctrlTurma;

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
        ctrlTurma = new CtrlTurma(this);
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
    
    public Image setarIconeJanela() {
        ImageIcon icone = new ImageIcon("build/classes/cih/img/logo.png");
        return icone.getImage();
    }

    public void instanciarFrameValidarAcesso() {
        frmValidarAcesso = new FrmValidarAcesso(this);
        frmValidarAcesso.setIconImage(setarIconeJanela());
        frmValidarAcesso.setVisible(true);
    }

    public void instanciarFrameOferta() {
        frmOferta = new FrmOferta(this);
        frmOferta.setVisible(true);
    }

    public JPInicio instanciarPainelInicio(FrmOferta pai) {
        inicio = new JPInicio(pai, this);
        return inicio;
    }
     
    public void instanciarFrameInicio() {
        frmInicio = new FrmInicio(this);
        frmInicio.identificarUsuario(getPermissao());
        frmInicio.setIconImage(setarIconeJanela());
        frmInicio.atualizarInfoSistema();
        frmInicio.setExtendedState(Frame.MAXIMIZED_BOTH);
        frmInicio.setVisible(true);
    }
    
    public BufferedImage setarBackground() {
        try {
            return ImageIO.read(new File("build/classes/cih/img/background.jpg"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public void validarAcesso(String login, String senha) {

        int permissao = gtPrincipal.validarAcesso(login, senha);
        setPermissao(permissao);
        if (permissao == Constantes.PERMISSAO_NEGADA) {
            CtrlMensagem.exibirMensagemErro(null, "Acesso Negado!");
        } else {
            instanciarFrameInicio();
            frmValidarAcesso.dispose();
        }
    }

    public void encerrarSessao() {

        int confirmacao = CtrlMensagem.exibirMensagemConfirmacao(frmInicio, "Deseja Sair ?");
        if (confirmacao == 0) {
            gtPrincipal.encerrarSessao();
            instanciarFrameValidarAcesso();
            frmInicio.dispose();
        }
    }

    public Config getConfig() {
        return config;
    }

    public void setConfig(Config config) {
        this.config = config;
    }
    
    public Frame getFrmOferta() {
        return frmOferta;
    }

    public void setFrmOferta(Frame frmOferta) {
        this.frmOferta = frmOferta;
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

    public CtrlTurma getCtrlTurma() {
        return ctrlTurma;
    }
}

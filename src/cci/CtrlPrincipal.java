package cci;

import cgd.Config;
import cgt.GtPrincipal;
import cgt.Constantes;
import cih.principal.FrmInicio;
import cih.principal.FrmValidarAcesso;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.UnsupportedLookAndFeelException;

public final class CtrlPrincipal {

    private Config config;
    private FrmValidarAcesso frmValidarAcesso;
    private FrmInicio frmInicio;
    private static int permissao;
    
    private GtPrincipal gtPrincipal;
    private CtrlProfessor ctrlProfessor;
    private CtrlCoordenador ctrlCoordenador;
    private CtrlCoordenadoria ctrlCoordenadoria;
    private CtrlRestricao ctrlRestricao;
    private CtrlCurso ctrlCurso;
    private CtrlEixo ctrlEixo;
    private CtrlDisciplina ctrlDisciplina;
    private CtrlMatriz ctrlMatriz;
    private CtrlTurma ctrlTurma;
    private CtrlAlocacao ctrlAlocacao;
    private CtrlOferta ctrlOferta;
    private CtrlConflito ctrlConflito;
    private CtrlAula ctrlAula;
    private CtrlRelatorio ctrlRelatorio;
    private CtrlValidacaoTurmas ctrlValidacao;

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
        ctrlAlocacao = new CtrlAlocacao(this);
        ctrlOferta = new CtrlOferta(this);
        ctrlConflito = new CtrlConflito(this);
        ctrlAula = new CtrlAula(this);
        ctrlRelatorio = new CtrlRelatorio(this);
        ctrlValidacao = new CtrlValidacaoTurmas(this);
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
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CtrlPrincipal();
            }
        });
    }
    
    public Image setarIconeJanela() {
        ImageIcon icone = new ImageIcon("build/classes/cih/img/logo-white.png");
        return icone.getImage();
    }
    
    public Color setarCorPanelExterior(){
        Color cor = new Color(0, 153, 102);
        return cor;
    }
    
    public Color setarCorPanelInterior(){
        Color cor = new Color(240, 240, 240);
        return cor;
    }

    public void instanciarFrameValidarAcesso() {
        frmValidarAcesso = new FrmValidarAcesso(this);
        frmValidarAcesso.setIconImage(setarIconeJanela());
        frmValidarAcesso.setVisible(true);
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

        int perm = gtPrincipal.validarAcesso(login, senha);
        setPermissao(perm);
        if (perm == Constantes.PERMISSAO_NEGADA) {
            CtrlMensagem.exibirMensagemErro(null, "Acesso Negado!");
            frmValidarAcesso.limparCampos();
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

    public CtrlAlocacao getCtrlAlocacao() {
        return ctrlAlocacao;
    } 

    public CtrlOferta getCtrlOferta() {
        return ctrlOferta;
    }

    public CtrlConflito getCtrlConflito() {
        return ctrlConflito;
    } 

    public CtrlAula getCtrlAula() {
        return ctrlAula;
    }

    public CtrlRelatorio getCtrlRelatorio() {
        return ctrlRelatorio;
    }

    public CtrlValidacaoTurmas getCtrlValidacao() {
        return ctrlValidacao;
    }
}

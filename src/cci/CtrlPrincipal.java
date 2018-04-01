package cci;

import cgd.Config;
import cgt.GtPrincipal;
import cgt.Permissao;
import cih.FrmPrincipal;
import cih.FrmValidarAcesso;
import cih.JPInicio;
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
    
    public CtrlPrincipal() {
        config = new Config();
        gtPrincipal = new GtPrincipal();
        ctrlCoordenador = new CtrlCoordenador(this);
        ctrlProfessor = new CtrlProfessor();
        ctrlCoordenadoria = new CtrlCoordenadoria();
        instanciarFrameValidarAcesso();
    }
    
    public static void main(String args[]){
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }   
        }catch(Exception e){}
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CtrlPrincipal();
            }   
        });
    }
    
    public void instanciarFrameValidarAcesso(){
        frmValidarAcesso = new FrmValidarAcesso(this);
        frmValidarAcesso.setVisible(true);
    }
    
    public void instanciarFramePrincipal(){
        frmPrincipal = new FrmPrincipal(this);
        frmPrincipal.setExtendedState(Frame.MAXIMIZED_BOTH);
        frmPrincipal.setVisible(true);
    }
    
    public JPInicio instanciarPainelInicio(FrmPrincipal pai){
        inicio = new JPInicio(pai, this); 
        return inicio;
    }
    
    public ImageIcon setarIconesJanela(){  
        ImageIcon icone = new ImageIcon("build/classes/cih/img/logo.jpg");
        return icone;
    }
    
    public void validarAcesso(String login, String senha) {
 
        int permissao = 1;//gtPrincipal.validarAcesso(login, senha);
        setPermissao(permissao);
        
        if(permissao == Permissao.PERMISSAO_NEGADA){
            CtrlMensagem.exibirMensagemErro(null, "Acesso Negado!");
            
        }else{
            instanciarFramePrincipal();
            frmValidarAcesso.dispose(); 
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

    public void setGtPrincipal(GtPrincipal gtPrincipal) {
        this.gtPrincipal = gtPrincipal;
    }

    public CtrlProfessor getCtrlProfessor() {
        return ctrlProfessor;
    }

    public void setCtrlProfessor(CtrlProfessor ctrlProfessor) {
        this.ctrlProfessor = ctrlProfessor;
    }

    public CtrlCoordenador getCtrlCoordenador() {
        return ctrlCoordenador;
    }

    public void setCtrlCoordenador(CtrlCoordenador ctrlCoordenador) {
        this.ctrlCoordenador = ctrlCoordenador;
    }

    public CtrlMensagem getCtrlMensagem() {
        return ctrlMensagem;
    }

    public void setCtrlMensagem(CtrlMensagem ctrlMensagem) {
        this.ctrlMensagem = ctrlMensagem;
    }

    public CtrlCoordenadoria getCtrlCoordenadoria() {
        return ctrlCoordenadoria;
    }

    public void setCtrlCoordenadoria(CtrlCoordenadoria ctrlCoordenadoria) {
        this.ctrlCoordenadoria = ctrlCoordenadoria;
    }
}

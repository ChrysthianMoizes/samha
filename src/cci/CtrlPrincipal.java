package cci;

import cgd.Config;
import cgt.GtPrincipal;
import cgt.Permissao;
import cih.FrmPrincipal;
import cih.FrmValidarAcesso;
import java.awt.Frame;
import javax.swing.ImageIcon;

public final class CtrlPrincipal {
    
    private Config config;
    private Frame frmValidarAcesso;
    private Frame frmPrincipal;
    private static int permissao;
    private GtPrincipal gtPrincipal;
    
    public CtrlPrincipal() {
        //config = new Config();
        gtPrincipal = new GtPrincipal();
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
        frmPrincipal = new FrmPrincipal();
        frmPrincipal.setExtendedState(Frame.MAXIMIZED_BOTH);
        frmPrincipal.setVisible(true);
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
}

package cci;

import cgd.Config;
import cih.FrmPrincipal;
import cih.FrmValidarAcesso;
import java.awt.Frame;

public final class CtrlPrincipal {
    
    private final Config config;
    private Frame frmValidarAcesso;

    public CtrlPrincipal() {
        config = new Config();
        instanciarFrameValidarAcesso();
    }
    
    public static void main(String args[]){
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
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
}

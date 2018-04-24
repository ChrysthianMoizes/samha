package cci;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.swing.JDialog;

public class AtualizarInterface implements Runnable{

    private JDialog janela;
    
    public AtualizarInterface(JDialog janela) {
        this.janela = janela;   
    }

    @Override
    public void run() {
        
        try {
            Thread.sleep(5 * 1000);
            boolean rodar = true;
            
            if(janela.isVisible()){
                rodar = true;
                
                janela.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
                Method metodo = janela.getClass().getMethod("atualizarTabela", null);
                metodo.invoke(janela, null);     
                janela.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);   
            }else
                rodar = false;

            if(rodar)
                this.run();
            
        } catch (InterruptedException | NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            CtrlMensagem.exibirMensagemErro(janela, ex.getMessage());
        }
    } 
}

package cci;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.swing.JDialog;

public class ThreadAtualizaInterface implements Runnable{

    private JDialog janela;
    
    public ThreadAtualizaInterface(JDialog janela) {
        this.janela = janela;   
    }

    @Override
    public void run() {
        boolean executar = true;
        try {
            Thread.sleep(5 * 1000);
            
            if(janela.isVisible()){
                executar = true;
                
                janela.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
                Method metodo = janela.getClass().getMethod("atualizarTabela", null);
                metodo.invoke(janela, null);     
                janela.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);   
            }else
                executar = false;

            if(executar)
                this.run();
            
        } catch (InterruptedException | NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            CtrlMensagem.exibirMensagemErro(janela, ex.getMessage());
        }
    } 
}

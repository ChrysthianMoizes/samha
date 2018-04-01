package cci;

import java.awt.Component;
import javax.swing.JOptionPane;

public class CtrlMensagem {
    
    public static void exibirMensagemSucesso(Component janela, String mensagem){
        JOptionPane.showMessageDialog(janela, mensagem, "Ok!:", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void exibirMensagemErro(Component janela, String mensagem){
        JOptionPane.showMessageDialog(janela, mensagem, "Erro:", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void exibirMensagemAviso(Component janela, String mensagem){
        JOptionPane.showMessageDialog(janela, mensagem, "Aviso:", JOptionPane.WARNING_MESSAGE);
    }
    
    public static int exibirMensagemConfirmacao(Component janela, String mensagem){
        return JOptionPane.showConfirmDialog(janela, mensagem, "Confirmar:", JOptionPane.YES_NO_OPTION);
    }
}

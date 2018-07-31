package cci;

import java.awt.Component;
import javax.swing.JOptionPane;

public class CtrlMensagem {
    
    public static void exibirMensagemSucesso(Component janela, String mensagem){
        JOptionPane.showMessageDialog(janela, mensagem, "Sucesso:", JOptionPane.INFORMATION_MESSAGE);
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
    
    public static int exibirMensagemConfirmacaoCancelar(Component janela, String mensagem){
        return JOptionPane.showConfirmDialog(janela, mensagem, "Confirmar:", JOptionPane.YES_NO_CANCEL_OPTION);
    }
    
    public static void exibirMensagemRetornoDados(Component janela, Object mensagem, String titulo){
        JOptionPane.showMessageDialog(janela, mensagem , titulo, JOptionPane.PLAIN_MESSAGE);   
    }
    
    public static int exibirMensagemInputDados(Component janela, Object mensagem, String titulo){
        return JOptionPane.showConfirmDialog(janela, mensagem, titulo, JOptionPane.YES_NO_OPTION);
    }
}

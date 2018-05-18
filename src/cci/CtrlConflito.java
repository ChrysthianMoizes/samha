package cci;

import cdp.Aula;
import cgt.Constantes;
import cih.oferta.JDOferta;
import java.awt.Color;
import javax.swing.JTable;

public class CtrlConflito {
    
    private CtrlPrincipal ctrlPrincipal;
    private JDOferta jdOferta;
    
    public CtrlConflito(CtrlPrincipal ctrl) {
        this.ctrlPrincipal = ctrl;
    }
    
    public void validarOferta(JTable tabela, JDOferta tela){
        
        setJdOferta(tela);
        
        jdOferta.limparNotificacoes();
        int conflitos = 0;
        
        for(int linha = 0; linha < Constantes.LINHA; linha++){
            
            for(int coluna = 0; coluna < Constantes.COLUNA; coluna++){
                
                Aula aula = (Aula) ctrlPrincipal.getGtPrincipal().getGtAula().getAulaMatriz(linha, coluna);
                
                if(aula != null){
                    String mensagem = ctrlPrincipal.getGtPrincipal().getGtConflito().validarOferta(aula);
                    if(mensagem != null){
                        conflitos++;
                        String notificacao = mensagem.substring(2);
                        exibirNotificação(notificacao, aula, Color.RED);
                    }
                    pintarCelulaTabela(mensagem, linha, coluna, tabela);
                }
            }
        }
        if(conflitos == 0){
            Color cor = new Color(53,151,48);
            jdOferta.exibirNotificacao("Nenhum conflito encontrado!", cor);       
        }
        jdOferta.validarOferta(false);
    }
    
    public void exibirNotificação(String notificacao, Aula aula, Color cor){
        int numero = aula.getNumero() + 1; 
        jdOferta.exibirNotificacao(aula.getDia() + ": Aula " + numero + ".\n" + notificacao+"\n\n", cor);     
    }
    
    public void pintarCelulaTabela(String mensagem, int linha, int coluna, JTable tabela){
        
//        if(mensagem != null){
//            
//            int codigo = mensagem.charAt(0);
//            
//            if(codigo == 0)
//                render.setCor(Color.RED);
//               celula.setBackground(Color.RED);  
//            else
//                render.setCor(Color.YELLOW);
//               celula.setBackground(Color.YELLOW); 
//        }else
//            render.setCor(Color.GREEN);
//            celula.setBackground(Color.GREEN);
//
//        render.prepareRenderer(null, linha, coluna);
    }

    public void setJdOferta(JDOferta jdOferta) {
        this.jdOferta = jdOferta;
    } 
}

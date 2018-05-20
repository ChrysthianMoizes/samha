package cci;

import cdp.Aula;
import cgt.Constantes;
import cih.oferta.JDOferta;
import java.awt.Color;
import java.util.List;
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

        for(int linha = 0; linha < Constantes.LINHA; linha++){ 
            for(int coluna = 0; coluna < Constantes.COLUNA; coluna++){
                
                Aula aula = (Aula) ctrlPrincipal.getGtPrincipal().getGtAula().getAulaMatriz(linha, coluna);
                
                if(aula != null){
                    List msg = ctrlPrincipal.getGtPrincipal().getGtConflito().validarOferta(aula);
                    exibirNotificacoes(msg, aula);
                }
            }
        }
        
        jdOferta.validarOferta(false);
    }
    
    public void exibirNotificacoes(List mensagens, Aula aula){
        
        int numero = aula.getNumero() + 1;
        String mensagem = null;
        String notificacao;
        String dia = ctrlPrincipal.getGtPrincipal().getGtConflito().obterStringDia(aula.getDia());
        
        if(!mensagens.isEmpty()){
            
            for(int i = 0; i < mensagens.size(); i++){
                mensagem = (String) mensagens.get(i);
                notificacao = mensagem.substring(2);
                jdOferta.exibirNotificacao(dia + ": Aula " + numero + ".\n" + notificacao +"\n\n", Color.RED);
                pintarCelulaTabela(Color.ORANGE, aula.getDia(), aula.getNumero(), jdOferta.getTblTurma());
            }
        }else{
            pintarCelulaTabela(Color.GREEN, aula.getDia(), aula.getNumero(), jdOferta.getTblTurma());
            jdOferta.exibirNotificacao(dia + " - Aula "+ (aula.getNumero()+1) + ".\nNenhum conflito encontrado!\n\n", new Color(53,151,48)); 
        }           
    }
    
    public void pintarCelulaTabela(Color cor, int linha, int coluna, JTable tabela){
        
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

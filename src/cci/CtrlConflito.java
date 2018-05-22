package cci;

import cdp.Aula;
import cgt.Constantes;
import cih.oferta.JDOferta;
import java.awt.Color;
import java.util.ArrayList;
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
        List mensagens = new ArrayList<>();
        jdOferta.limparNotificacoes();
        Aula aula;

        for(int linha = 0; linha < Constantes.LINHA; linha++){ 
            for(int coluna = 0; coluna < Constantes.COLUNA; coluna++){
                
                aula = (Aula) ctrlPrincipal.getGtPrincipal().getGtAula().getAulaMatriz(linha, coluna);
                
                if(aula != null){
                    List msg = ctrlPrincipal.getGtPrincipal().getGtConflito().validarOferta(aula);
                    mensagens.addAll(msg);
                    exibirNotificacoesConflito(msg, aula);
                }
            }
        }
        
        if(mensagens.isEmpty()){
            Color cor = ctrlPrincipal.setarCorPanelExterior();
            jdOferta.limparNotificacoes();
            jdOferta.exibirNotificacao("Nenhum conflito de aulas encontrado!\n\n", cor); 
        }
        
        jdOferta.validarOferta(false);
    }
    
    public void exibirNotificacoesConflito(List mensagens, Aula aula){
        
        int numero = aula.getNumero() + 1;
        String mensagem = null;
        String notificacao;
        String dia = ctrlPrincipal.getGtPrincipal().getGtConflito().obterStringDia(aula.getDia());
        
        if(!mensagens.isEmpty()){
            
            mensagem = (String) mensagens.get(0);
            int codigo = mensagem.charAt(0);
            
            for(int i = 0; i < mensagens.size(); i++){
                mensagem = (String) mensagens.get(i);
                notificacao = mensagem.substring(2);
                jdOferta.exibirNotificacao(dia + ": Aula " + numero + ".\n" + notificacao +"\n\n", Color.RED);
                identificarTipoConflito(aula.getDia(), aula.getNumero(), codigo);
            }
        }else
            identificarTipoConflito(aula.getDia(), aula.getNumero(), 3);
    }
    
    public void identificarTipoConflito(int dia, int numero, int codigo){
        
        switch(codigo){
            
            case 0: 
                pintarCelulaTabela(Color.RED, dia, numero, jdOferta.getTblTurma());
                break;
            case 1: 
                pintarCelulaTabela(Color.ORANGE, dia, numero, jdOferta.getTblTurma());
                break;
            case 2: 
                pintarCelulaTabela(Color.YELLOW, dia, numero, jdOferta.getTblTurma());
                break;
            default: 
                pintarCelulaTabela(Color.GREEN, dia, numero, jdOferta.getTblTurma());
                break;
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
    
    //============================================== VALIDAR QUANTIDADE DE AULAS DE DISCIPLINA ========================================================
    
    public void validarQuantidadeAulasDisciplina(){
        
        Aula aula = null;
        boolean validado = true;
        List aulas = new ArrayList<>();
                
        for(int linha = 0; linha < Constantes.LINHA; linha++){ 
            
            for(int coluna = 0; coluna < Constantes.COLUNA; coluna++){
                
                aula = (Aula) ctrlPrincipal.getGtPrincipal().getGtAula().getAulaMatriz(linha, coluna);
                validado = ctrlPrincipal.getGtPrincipal().getGtConflito().validarQuantidadeAulasDisciplina(aula);
                
                if(!validado){
                    if(!existeDisciplinaLista(aula, aulas))
                        aulas.add(aula);
                }  
            }
        }
        exibirNotificacoesDisciplina(aulas);
    }
    
    public boolean existeDisciplinaLista(Aula aula, List aulas){
        
        Aula aulaAux;
        for(int i = 0; i < aulas.size(); i++){
            aulaAux = (Aula) aulas.get(i);
            if(aula.getAlocacao().getDisciplina().getId() == aulaAux.getAlocacao().getDisciplina().getId()){
                return true;
            }
        }
        return false;
    }
    
    public void exibirNotificacoesDisciplina(List aulas){
    
        String sigla;
        int qtAulas;
        Aula aula;
 
        for(int i = 0; i < aulas.size(); i++){
            
            aula = (Aula) aulas.get(i);
            sigla = aula.getAlocacao().getDisciplina().getSigla();
            qtAulas = aula.getAlocacao().getDisciplina().getQtAulas();
            jdOferta.exibirNotificacao(sigla + ": Quantidade de aulas diferente da especificada: " + qtAulas + " aulas.\n\n", Color.RED);
        } 
    }    
}

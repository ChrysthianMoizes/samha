package cci;

import cdp.Aula;
import cgt.Constantes;
import cih.oferta.JDOferta;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;

public class CtrlConflito {
    
    private RenderizadorCelulas render;
    private CtrlPrincipal ctrlPrincipal;
    private JDOferta jdOferta;
    private Color corErro = new Color(255, 73, 73);
    
    public CtrlConflito(CtrlPrincipal ctrl) {
        this.ctrlPrincipal = ctrl;
        render = new RenderizadorCelulas(ctrlPrincipal, 1);
    }
    
    public void validarOferta(JTable tabela, JDOferta tela){
        
        render.gerarMatrizCores();
        
        setJdOferta(tela);
        List mensagens = new ArrayList<>();
        jdOferta.limparNotificacoes();
        Aula aula;
        
        ctrlPrincipal.getGtPrincipal().getGtInstituicao().instanciarVetoresInstituicao();
        
        for(int linha = 0; linha < Constantes.LINHA; linha++){ 
            for(int coluna = 0; coluna < Constantes.COLUNA; coluna++){
                
                aula = (Aula) ctrlPrincipal.getGtPrincipal().getGtAula().getAulaMatriz(linha, coluna);
                
                if(aula != null){
                    List msg = ctrlPrincipal.getGtPrincipal().getGtConflito().validarOferta(aula);
                    mensagens.addAll(msg);
                    exibirNotificacoesConflito(msg, aula);
                }else
                    pintarCelula(linha, coluna, Color.WHITE); 
            }
        }
        
        if(mensagens.isEmpty()){
            jdOferta.limparNotificacoes();
            jdOferta.exibirNotificacao("Nenhum conflito de aulas encontrado!\n\n", ctrlPrincipal.setarCorPanelExterior()); 
        }
        
        jdOferta.validarOferta(false);
    }
    
    public void exibirNotificacoesConflito(List mensagens, Aula aula){
        
        int numero = aula.getNumero() + 1;
        String dia = ctrlPrincipal.getGtPrincipal().getGtInstituicao().obterStringDia(aula.getDia());
        
        String mensagem;
        if(!mensagens.isEmpty()){
            for(int i = 0; i < mensagens.size(); i++){
                mensagem = (String) mensagens.get(i);
                jdOferta.exibirNotificacao(dia + ": Aula " + numero + ".\n" + mensagem +"\n\n", Color.RED);
            }
            pintarCelula(aula.getDia(), aula.getNumero(), corErro);
        }else
            pintarCelula(aula.getDia(), aula.getNumero(), Color.WHITE);   
    }
    
    public void pintarCelula(int linha, int coluna, Color cor){
        render.setColorMatriz(linha, coluna, cor);
        jdOferta.getTblTurma().repaint();
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

    public RenderizadorCelulas getRender() {
        return render;
    }
}

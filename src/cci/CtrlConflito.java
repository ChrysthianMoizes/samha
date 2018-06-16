package cci;

import cdp.Aula;
import cgt.Constantes;
import cih.oferta.JDOferta;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;

public class CtrlConflito {
    
    private RenderizadorCelulas renderTabelaTurma;
    private CtrlPrincipal ctrlPrincipal;
    private JDOferta jdOferta;
    private Color corErro = new Color(255, 73, 73);
    private List[] vetorTempoMaximo;
    private List[] vetorIntervalo;
    
    public CtrlConflito(CtrlPrincipal ctrl) {
        this.ctrlPrincipal = ctrl;
        renderTabelaTurma = new RenderizadorCelulas(ctrlPrincipal, 1);
    }
    
    public void validarOferta(JTable tabela, JDOferta tela){
        
        renderTabelaTurma.gerarMatrizCores();
        
        setJdOferta(tela);
        List mensagens = new ArrayList<>();
        jdOferta.limparNotificacoes();
        Aula aula;
        
        instanciarVetoresRestricaoInstituicao();
        
        for(int linha = 0; linha < Constantes.LINHA; linha++){ 
            for(int coluna = 0; coluna < Constantes.COLUNA; coluna++){
                
                aula = (Aula) ctrlPrincipal.getGtPrincipal().getGtAula().getAulaMatriz(linha, coluna);
                
                if(aula != null){
                    
                    List msg = ctrlPrincipal.getGtPrincipal().getGtConflito().validarAula(aula);
                    
                    if(msg.isEmpty())
                        pintarCelulaTabelaTurma(aula.getDia(), aula.getNumero(), Color.WHITE);
                    else
                        pintarCelulaTabelaTurma(aula.getDia(), aula.getNumero(), corErro);
                    
                    mensagens.addAll(msg);
                    exibirNotificacoesConflito(msg, aula);
                }else
                    pintarCelulaTabelaTurma(linha, coluna, Color.WHITE); 
            }
        }
        
        if(mensagens.isEmpty()){
            jdOferta.limparNotificacoes();
            jdOferta.exibirNotificacao("Nenhum conflito encontrado!\n\n", ctrlPrincipal.setarCorPanelExterior()); 
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
                mensagem = identificarTipoMensagem(mensagem, aula);
                
                if(mensagem != null)
                    jdOferta.exibirNotificacao(dia + ": Aula " + numero + ".\n" + mensagem +"\n\n", Color.RED);
            }
        }  
    }
    
    public String identificarTipoMensagem(String mensagem, Aula aula){
        
        int idProfessor = aula.getAlocacao().getProfessor1().getId();
        int dia = aula.getDia();
        
        char c = mensagem.charAt(0);
        int codigo = c - 48;
        
        String notificacao;
        
        switch (codigo) {
            case 0:
                if(!identificarProfessor(vetorTempoMaximo, idProfessor, dia)){
                    vetorTempoMaximo[dia].add(idProfessor);
                    notificacao = mensagem.substring(2);
                    return notificacao;
                }   break;
            case 1:
                if(!identificarProfessor(vetorIntervalo, idProfessor, dia)){
                    vetorIntervalo[dia].add(idProfessor);
                    
                    if(dia == 0)
                        vetorIntervalo[dia + 1].add(idProfessor);
                    
                    notificacao = mensagem.substring(2);
                    return notificacao;
                }   break;
            default:
                return mensagem;
        }
        return null;
    }
    
    public void pintarCelulaTabelaTurma(int linha, int coluna, Color cor){
        renderTabelaTurma.setColorMatriz(linha, coluna, cor);
        if(jdOferta != null)
            jdOferta.getTblTurma().repaint();
    }
    
    public void limparCorCelulasTabelaTurma(){
        for(int linha = 0; linha < Constantes.LINHA; linha++){  
            for(int coluna = 0; coluna < Constantes.COLUNA; coluna++){
                pintarCelulaTabelaTurma(linha, coluna, Color.WHITE);
            }   
        }
    }
    
    public void setJdOferta(JDOferta jdOferta) {
        this.jdOferta = jdOferta;
    }
    
    public boolean identificarProfessor(List[] vetor, int idProfessor, int dia){
        
        List<Integer> aulas = vetor[dia];
        
        for(Integer id : aulas){
            if(id == idProfessor)
                return true;
        }
        return false;
    }
    
    public void instanciarVetoresRestricaoInstituicao(){
              
        if(vetorIntervalo == null || vetorTempoMaximo == null){
        
            vetorTempoMaximo = new List[Constantes.LINHA];
            vetorIntervalo = new List[Constantes.LINHA];

            for(int linha = 0; linha < Constantes.LINHA; linha++){
                vetorTempoMaximo[linha] = new ArrayList<>();
                vetorIntervalo[linha] = new ArrayList<>();
            }  
        }else
            limparVetoresInstituicao();
    }
    
    public void limparVetoresInstituicao(){
        for(int linha = 0; linha < Constantes.LINHA; linha++){
            vetorTempoMaximo[linha].clear();
            vetorIntervalo[linha].clear();
        }
    }
    
    //============================================== VALIDAR QUANTIDADE DE AULAS DE DISCIPLINA ========================================================
    
    public void validarQuantidadeAulasDisciplina(){      
        List aulas = identificarAulasIncorretas();
        exibirNotificacoesDisciplina(aulas);     
    }
    
    public List identificarAulasIncorretas(){
        
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
        return aulas;   
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
        return renderTabelaTurma;
    }
}

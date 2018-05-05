package cci;

import cdp.Aula;
import cdp.Curso;
import cdp.Turma;
import cgt.GtAlocacao;
import cgt.GtOferta;
import cih.oferta.JDOferta;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTable;

public class CtrlOferta extends CtrlGenerica{
    
    private CtrlPrincipal ctrlPrincipal;
    private GtOferta gtOferta;
    private GtAlocacao gtAlocacao;
    private JDOferta jdOferta;
    private RenderizadorCelulas render;

    public CtrlOferta(CtrlPrincipal ctrl) {
        ctrlPrincipal = ctrl;
        gtOferta = new GtOferta();
        gtAlocacao = new GtAlocacao();
        render = new RenderizadorCelulas();
    }
    
    public void instanciarTelaOferta(Frame pai) {
        jdOferta = new JDOferta(pai, true, ctrlPrincipal);
        jdOferta.setIconImage(setarIconeJanela());
        jdOferta.preencherComboCurso();
        jdOferta.setVisible(true);
    }
    
    public Image setarIconeJanela() {
        ImageIcon icone = new ImageIcon("build/classes/cih/img/oferta-white.png");
        return icone.getImage();
    }
    
    public void preencherComboCurso(JComboBox cbxCurso, JComboBox cbxTurma){ 
       
        List listaCursos = ctrlPrincipal.getCtrlCurso().listar();
        preencherCombo(cbxCurso, listaCursos);
        
        if(listaCursos.size() > 0){
            Curso curso = (Curso) cbxCurso.getSelectedItem();
            preencherComboTurma(curso.getId(), cbxTurma);
        }  
    }
    
    public void preencherComboTurma(int id, JComboBox cbxTurma) {
        List listaTurmas = ctrlPrincipal.getCtrlTurma().buscar("curso", String.valueOf(id));
        preencherCombo(cbxTurma, listaTurmas);
        
        if(listaTurmas.size() > 0){
            jdOferta.atualizarLista();
        }
    }
    
    public void preencherListaAlocacoes(int ano, int semestre, JComboBox cbxTurma, JList lstAlocacoes){
        
        Turma turma = (Turma) cbxTurma.getSelectedItem();
        
        if(turma != null){
            List listaAlocacoes = gtAlocacao.filtrarPorAnoSemestreMatriz(ano, semestre, turma.getMatriz().getId());
            jdOferta.setListaAlocacoes(listaAlocacoes);
            preencherJList(listaAlocacoes, lstAlocacoes);  
            
            if(listaAlocacoes.size() == 0)
                jdOferta.setarMensagem("Nenhuma alocação encontrada.");
        }
    }
    
    public void validarOfertas(JTable tabela){
        
        for(int linha = 0; linha < 5; linha++){
            
            for(int coluna = 0; coluna < 6; coluna++){
                Aula aula = (Aula) tabela.getValueAt(linha, coluna);
                
                if(aula != null){
                    String mensagem = gtOferta.validarOferta(aula);
                    exibirNotificação(mensagem, linha, coluna);
                    pintarCelulaTabela(mensagem, linha, coluna, tabela);
                }
            }
        }  
    }
 
    public void exibirNotificação(String mensagem, int linha, int coluna){
        
        if(mensagem != null){
            String notificacao = mensagem.substring(2);
            jdOferta.exibirNotificação("Linha " + linha + ", Coluna " + coluna + ": " + notificacao);
        }
    }
    
    public void pintarCelulaTabela(String mensagem, int linha, int coluna, JTable tabela){
        
        if(mensagem != null){
            
            int codigo = mensagem.charAt(0);
            
            if(codigo == 0)
                render.setCor(Color.RED);
               //celula.setBackground(Color.RED);  
            else
                render.setCor(Color.YELLOW);
               //celula.setBackground(Color.YELLOW); 
        }else
            render.setCor(Color.GREEN);
            //celula.setBackground(Color.GREEN);

        render.prepareRenderer(null, linha, coluna);
    }
}

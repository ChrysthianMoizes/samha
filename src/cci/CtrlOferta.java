package cci;

import cdp.Curso;
import cdp.Turma;
import cgt.GtAlocacao;
import cgt.GtOferta;
import cih.oferta.JDOferta;
import java.awt.Frame;
import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JList;

public class CtrlOferta extends CtrlGenerica{
    
    private CtrlPrincipal ctrlPrincipal;
    private GtOferta gtOferta;
    private GtAlocacao gtAlocacao;
    private JDOferta jdOferta;

    public CtrlOferta(CtrlPrincipal ctrl) {
        ctrlPrincipal = ctrl;
        gtOferta = new GtOferta();
        gtAlocacao = new GtAlocacao();
    }
    
    public void instanciarTelaOferta(Frame pai) {
        jdOferta = new JDOferta(pai, true, ctrlPrincipal);
        jdOferta.setIconImage(setarIconeJanela());
        jdOferta.preencherComboCurso();
        jdOferta.setVisible(true);
    }
    
    public Image setarIconeJanela() {
        ImageIcon icone = new ImageIcon("build/classes/cih/img/oferta.png");
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
            preencherJList(listaAlocacoes, lstAlocacoes);  
            
            if(listaAlocacoes.size() == 0)
                jdOferta.setarMensagem("Nenhuma alocação encontrada.");
        }
    }
 
}

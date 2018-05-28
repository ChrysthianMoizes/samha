package cci;

import cdp.Coordenadoria;
import cdp.Curso;
import cdp.Eixo;
import cdp.Turma;
import cih.relatorio.JDTipoRelatorio;
import cih.relatorio.JDRelatorioProfessor;
import cih.relatorio.JDRelatorioTurma;
import java.awt.Frame;
import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

public class CtrlRelatorio extends CtrlGenerica{
    
    private CtrlPrincipal ctrlPrincipal;
    private JDTipoRelatorio jdTipoRelatorio;
    private JDRelatorioTurma jdRelatorioTurma;
    private JDRelatorioProfessor jdRelatorioProfessor;
    
    public CtrlRelatorio(CtrlPrincipal ctrl){
        this.ctrlPrincipal = ctrl;
    }
    
    public void instanciarTelaRelatorioTurma(Frame pai){
        jdRelatorioTurma = new JDRelatorioTurma(pai, true, ctrlPrincipal);
        jdRelatorioTurma.setIconImage(setarIconeJanela());
        jdRelatorioTurma.preencherComboEixo();
        jdRelatorioTurma.preencherComboCurso();
        jdRelatorioTurma.preencherComboTurma();
        jdRelatorioTurma.setarTurno();
        jdRelatorioTurma.setVisible(true);
    }
    
    public void instanciarTelaRelatorioProfessor(Frame pai){
        jdRelatorioProfessor = new JDRelatorioProfessor(pai, true, ctrlPrincipal);
        jdRelatorioProfessor.setIconImage(setarIconeJanela());
        jdRelatorioProfessor.preencherComboEixo();
        jdRelatorioProfessor.preencherComboCoordenadoria();
        jdRelatorioProfessor.preencherComboProfessor();
        jdRelatorioProfessor.setVisible(true);
    }
    
    public void instanciarTelaTipoRelatorio(Frame pai){
        jdTipoRelatorio = new JDTipoRelatorio(pai, true, ctrlPrincipal);
        jdTipoRelatorio.setIconImage(setarIconeJanela());
        jdTipoRelatorio.setVisible(true);
    }
    
    public Image setarIconeJanela() {
        ImageIcon icone = new ImageIcon("build/classes/cih/img/relatorio.png");
        return icone.getImage();
    }
    
    public void identificarTipoRelatorio(Frame pai, char tipo){  
        switch(tipo){
            
            case 'P': 
                instanciarTelaRelatorioProfessor(pai);
                break;
            case 'T': 
                instanciarTelaRelatorioTurma(pai);
                break;
            default: break;
        }          
    }
    
    public void preencherComboEixos(JComboBox cbxEixo){ 
        
        List listaEixos = ctrlPrincipal.getCtrlEixo().consultar();
        preencherCombo(cbxEixo, listaEixos);
       
    }
    
    public void preencherComboCoordenadoria(JComboBox cbxEixo, JComboBox cbxCoordenadoria){
        
        Eixo eixo = (Eixo) cbxEixo.getSelectedItem();
        
        if(eixo != null){
            
            List listaCoordenadorias = ctrlPrincipal.getCtrlCoordenadoria().filtrarCoordenadoriasEixo(eixo.getId());
            preencherCombo(cbxCoordenadoria, listaCoordenadorias);
        }
        
    }
    
    public void preencherComboCurso(JComboBox cbxEixo, JComboBox cbxCurso, JComboBox cbxTurma){ 
       
        Eixo eixo = (Eixo) cbxEixo.getSelectedItem();
        
        if(eixo != null){
            
            List listaCursos = ctrlPrincipal.getCtrlCurso().filtrarPorEixo(eixo.getId());
            preencherCombo(cbxCurso, listaCursos);
        }
    }
    
    public void preencherComboTurma(JComboBox cbxCurso, JComboBox cbxTurma) {
        
        Curso curso = (Curso) cbxCurso.getSelectedItem();
        
        if(curso != null){
            List listaTurmas = ctrlPrincipal.getCtrlTurma().buscarPorCurso(curso.getId());
            preencherCombo(cbxTurma, listaTurmas);           
        }  
    }
    
    public void preencherComboProfessor(JComboBox cbxCoordenadoria, JComboBox cbxProfessor){
        
        Coordenadoria coord = (Coordenadoria) cbxCoordenadoria.getSelectedItem();
    
        if(coord != null){
            
            List listaProfessores = ctrlPrincipal.getCtrlProfessor().filtrarPorCoordenadoria(coord.getId());
            preencherCombo(cbxProfessor, listaProfessores);   
        }
    
    }
    
    public void setarTurno(JComboBox cbxTurma, JComboBox cbxTurno){
        
        Turma turma = (Turma) cbxTurma.getSelectedItem();
        
        if(turma != null){ 
            ctrlPrincipal.getCtrlOferta().setarTurno(turma.getTurno(), cbxTurno);
        }
    }
}

package cci;

import cdp.Aula;
import cdp.Coordenadoria;
import cdp.Curso;
import cdp.Eixo;
import cdp.Oferta;
import cdp.Professor;
import cdp.Turma;
import cgt.Constantes;
import cih.relatorio.JDTipoRelatorio;
import cih.relatorio.JDRelatorioProfessor;
import cih.relatorio.JDRelatorioTurma;
import java.awt.Frame;
import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTable;

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
        jdRelatorioTurma.identificarOferta();
        jdRelatorioTurma.ativarFiltroNenhum();
        jdRelatorioTurma.setVisible(true);
    }
    
    public void instanciarTelaRelatorioProfessor(Frame pai){
        jdRelatorioProfessor = new JDRelatorioProfessor(pai, true, ctrlPrincipal);
        jdRelatorioProfessor.setIconImage(setarIconeJanela());
        jdRelatorioProfessor.preencherComboEixo();
        jdRelatorioProfessor.preencherComboCoordenadoria();
        jdRelatorioProfessor.preencherComboProfessor();
        jdRelatorioProfessor.preencherTabelaProfessor();
        jdRelatorioProfessor.ativarFiltroNenhum();
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
    
    public void identificarOferta(int ano, int semestre, JComboBox cbxTurma){

        Turma turma = (Turma) cbxTurma.getSelectedItem();
        Oferta oferta = null;
        
        if(turma != null){
            jdRelatorioTurma.setarTurma(turma.getNome());
            oferta = ctrlPrincipal.getGtPrincipal().getGdPrincipal().getGdOferta().filtrarOferta(ano, semestre, turma.getId());
            
            if(oferta != null){
                ctrlPrincipal.getGtPrincipal().getGtAula().preencherMatrizOferta(oferta);
            }
        }else
            jdRelatorioTurma.setarTurma("Turma");
        
        jdRelatorioTurma.preencherTabelaTurma(oferta);
    }
    
    public void preencherTabelaTurma(JTable tblTurma, JComboBox cbxTurno, Oferta oferta){
        
        JTableUtil.limparCelulasTabela(tblTurma);

        if(oferta != null){
            
            String turno = (String) cbxTurno.getSelectedItem();        
            int t = ctrlPrincipal.getGtPrincipal().getGtAula().obterNumeroTurno(turno);
            
            Aula aula;

            for(int linha = 0; linha < Constantes.LINHA; linha++){

                for(int coluna = t; coluna < (Constantes.AULAS + t); coluna++){
                    aula = ctrlPrincipal.getGtPrincipal().getGtAula().getAulaMatriz(linha, coluna);
                    if(aula != null)
                        tblTurma.setValueAt(aula, linha, aula.getNumero() - t);
                }  
            }
        }
    }
    
    public void preencherTabelaProfessor(int ano, int semestre, JComboBox cbxProfessor, JTable tblProfessor){
        
        Professor professor = (Professor) cbxProfessor.getSelectedItem();
        
        if(professor != null){
            jdRelatorioProfessor.setarProfessor(professor.getNome());
            List listaAulas = ctrlPrincipal.getGtPrincipal().getGtAula().filtrarAulasProfessorAnoSemestre(ano, semestre, professor.getId());
            ctrlPrincipal.getCtrlOferta().preencherTabelaProfessor(tblProfessor, listaAulas);
            
        }else{
            jdRelatorioProfessor.setarProfessor("Professor");
            JTableUtil.limparCelulasTabela(tblProfessor);
        }    
    }
    
    public void gerarRelatorioProfessor(JComboBox cbxEixo, JComboBox cbxCoordenadoria, JComboBox cbxProfessor, int ano, int semestre, char tipo){
        
        
    }
    
    public void gerarRelatorioTurma(JComboBox cbxEixo, JComboBox cbxCurso, JComboBox cbxTurma, int ano, int semestre, char tipo){
        
    }
}

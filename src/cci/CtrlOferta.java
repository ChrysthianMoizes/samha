package cci;

import cdp.Alocacao;
import cdp.Aula;
import cdp.Curso;
import cdp.Disciplina;
import cdp.Professor;
import cdp.Turma;
import cgt.Constantes;
import cgt.Horarios;
import cih.oferta.JDOferta;
import java.awt.Frame;
import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTable;

public class CtrlOferta extends CtrlGenerica{
    
    private CtrlPrincipal ctrlPrincipal;
    private JDOferta jdOferta;
    private RenderizadorCelulas render;
    private List listaAlocacoes;
    private boolean abrindoTela = true;

    public CtrlOferta(CtrlPrincipal ctrl) {
        ctrlPrincipal = ctrl;
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
        
        if(listaCursos.size() > 0)
            preencherComboTurma(cbxCurso, cbxTurma);  
    }
    
    public void preencherComboTurma(JComboBox cbxCurso, JComboBox cbxTurma) {
        
        jdOferta.setarTurma("");
        Curso curso = (Curso) cbxCurso.getSelectedItem();
        if(curso != null){
            List listaTurmas = ctrlPrincipal.getCtrlTurma().buscar("curso", String.valueOf(curso.getId()));
            preencherCombo(cbxTurma, listaTurmas);
            jdOferta.atualizarTela();
        }  
    }
    
    public void atualizarTela(int ano, int semestre, int tempoMaximo, int intervaloMinimo, 
            JComboBox cbxTurma, JComboBox cbxTurno, JList lstAlocacoes, JTable tblTurma){
        
        JTableUtil.limparCelulasTabela(tblTurma);
        jdOferta.limparNotificacoes();
        jdOferta.setarMensagem("");
        
        Turma turma = (Turma) cbxTurma.getSelectedItem();
        
        if(turma != null){
            
            if(isAbrindoTela()){
                setarTurno(turma.getTurno(), cbxTurno);
                setAbrindoTela(false);
            }    
            String turno = (String) cbxTurno.getSelectedItem(); 
            identificarOferta(ano, semestre, tempoMaximo, intervaloMinimo, turma, tblTurma, turno);
            validarOferta(tblTurma);
        }
        
        preencherListaAlocacoes(ano, semestre, turma, lstAlocacoes, tblTurma);
        
        zerarTabelaProfessor();
    }
    
    public void preencherListaAlocacoes(int ano, int semestre, Turma turma, JList lstAlocacoes, JTable tblTurma){
        
        List listaAlocacoes = null;
        
        if(turma != null){ 
            
            listaAlocacoes = ctrlPrincipal.getGtPrincipal().getGtAlocacao().filtrarPorAnoSemestreMatriz(ano, semestre, turma.getMatriz().getId());
            setListaAlocacoes(listaAlocacoes);
            
            if(listaAlocacoes.isEmpty())
                jdOferta.setarMensagem("Nenhuma alocação encontrada.");
        }else
            jdOferta.setarMensagem("Nenhuma turma encontrada.");
        
        preencherJList(listaAlocacoes, lstAlocacoes);
    }
    
    public void identificarOferta(int ano, int semestre, int tempoMaximo, int intervaloMinimo, Turma turma, JTable tblTurma, String turno){
        jdOferta.validarOferta(false);
        ctrlPrincipal.getGtPrincipal().getGtOferta().identificarOferta(ano, semestre, tempoMaximo, intervaloMinimo, turno, turma);
        jdOferta.setarTurma(turma.getNome());
        ctrlPrincipal.getCtrlAula().preencherTabelaAulas(tblTurma);
    }
    
    public void zerarTabelaProfessor(){
        jdOferta.setarProfessor("");
        jdOferta.getCbxQuantidadeProfessor().setSelectedIndex(0);
        jdOferta.getCbxQuantidadeProfessor().setEnabled(false);
        JTableUtil.limparCelulasTabela(jdOferta.getTblProfessor());
    }
    
    public void setarTurno(String turno, JComboBox cbxTurno){
        switch(turno){
            case Constantes.MATUTINO: cbxTurno.setSelectedIndex(0); break;
            case Constantes.VESPERTINO: cbxTurno.setSelectedIndex(1); break;
            default: cbxTurno.setSelectedIndex(2); break;
        }   
    }
    
    public void alterarTurno(String turno, JTable tblTurma){
     
        switch(turno){
            
            case Constantes.MATUTINO: 
                tblTurma.getColumnModel().getColumn(0).setHeaderValue(Horarios.MATUTINO_1);
                tblTurma.getColumnModel().getColumn(1).setHeaderValue(Horarios.MATUTINO_2);
                tblTurma.getColumnModel().getColumn(2).setHeaderValue(Horarios.MATUTINO_3);
                tblTurma.getColumnModel().getColumn(3).setHeaderValue(Horarios.MATUTINO_4);
                tblTurma.getColumnModel().getColumn(4).setHeaderValue(Horarios.MATUTINO_5);
                tblTurma.getColumnModel().getColumn(5).setHeaderValue(Horarios.MATUTINO_6);
                break;
                
            case Constantes.VESPERTINO: 
                tblTurma.getColumnModel().getColumn(0).setHeaderValue(Horarios.VESPERTINO_1);
                tblTurma.getColumnModel().getColumn(1).setHeaderValue(Horarios.VESPERTINO_2);
                tblTurma.getColumnModel().getColumn(2).setHeaderValue(Horarios.VESPERTINO_3);
                tblTurma.getColumnModel().getColumn(3).setHeaderValue(Horarios.VESPERTINO_4);
                tblTurma.getColumnModel().getColumn(4).setHeaderValue(Horarios.VESPERTINO_5);
                tblTurma.getColumnModel().getColumn(5).setHeaderValue(Horarios.VESPERTINO_6);
                break;
                
            default:
                tblTurma.getColumnModel().getColumn(0).setHeaderValue(Horarios.NOTURNO_1);
                tblTurma.getColumnModel().getColumn(1).setHeaderValue(Horarios.NOTURNO_2);
                tblTurma.getColumnModel().getColumn(2).setHeaderValue(Horarios.NOTURNO_3);
                tblTurma.getColumnModel().getColumn(3).setHeaderValue(Horarios.NOTURNO_4);
                tblTurma.getColumnModel().getColumn(4).setHeaderValue(Horarios.NOTURNO_5);
                tblTurma.getColumnModel().getColumn(5).setHeaderValue(Horarios.NOTURNO_6);
                break;
        }
        jdOferta.repaint();
    }    
    
    public void validarOferta(JTable tabela){
        ctrlPrincipal.getCtrlConflito().validarOferta(tabela, jdOferta);
    }

    public List getListaAlocacoes() {
        return listaAlocacoes;
    }

    public void setListaAlocacoes(List listaAlocacoes) {
        this.listaAlocacoes = listaAlocacoes;
    }

    public boolean isAbrindoTela() {
        return abrindoTela;
    }

    public void setAbrindoTela(boolean abrindoTela) {
        this.abrindoTela = abrindoTela;
    }

    public JDOferta getJdOferta() {
        return jdOferta;
    }

    //================================================= TABELA DE PROFESSOR ================================================================
    
    public void preencherHorarioProfessor(JList lstAlocacoes, JTable tblProfessor, JComboBox cbxQuantidadeProfessor){
        
        if (!listaAlocacoes.isEmpty()) {
            
            int indice = lstAlocacoes.getSelectedIndex();
            Alocacao alocacao = (Alocacao) listaAlocacoes.get(indice);
            
            Disciplina disciplina = alocacao.getDisciplina();

            if(disciplina.getTipo().equals(Constantes.ESPECIAL))
                cbxQuantidadeProfessor.setEnabled(true);
            else{
                cbxQuantidadeProfessor.setEnabled(false);
                cbxQuantidadeProfessor.setSelectedIndex(0);
            }
            alterarProfessorCombo(lstAlocacoes, tblProfessor, cbxQuantidadeProfessor);
        }
    }
    
    public void alterarProfessorCombo(JList lstAlocacoes, JTable tblProfessor, JComboBox cbxQuantidadeProfessor){
        
        int numero = cbxQuantidadeProfessor.getSelectedIndex();
        List listaAulas;
        Professor professor;
        int indice = lstAlocacoes.getSelectedIndex();
        
        if(indice >= 0){
            
            Alocacao alocacao = (Alocacao) listaAlocacoes.get(indice);
            int ano = alocacao.getAno();
            int semestre = alocacao.getSemestre();

            if(numero == 0){
                professor = alocacao.getProfessor1();
                listaAulas = ctrlPrincipal.getGtPrincipal().getGtAula().listarAulasProfessor(professor.getId(), ano, semestre, 1);
            }else{
                professor = alocacao.getProfessor2();
                listaAulas = ctrlPrincipal.getGtPrincipal().getGtAula().listarAulasProfessor(professor.getId(), ano, semestre, 2);
            }
            jdOferta.setarProfessor(professor.getNome());
            preencherTabelaProfessor(tblProfessor, listaAulas);
        } 
    }
    
    public void preencherTabelaProfessor(JTable tblProfessor, List listaAulas){
 
        JTableUtil.limparCelulasTabela(tblProfessor);
        
        Aula aula;
        int linha, coluna, turno;
        
        for(int i = 0; i < listaAulas.size(); i++){
            aula = (Aula) listaAulas.get(i);
            linha = aula.getDia();
            turno = ctrlPrincipal.getGtPrincipal().getGtConflito().obterNumeroTurno(aula.getTurno());
            coluna = (aula.getNumero() + turno);
            tblProfessor.setValueAt(aula.getOferta().getTurma().getNome(), linha, coluna);
        }   
    }
}

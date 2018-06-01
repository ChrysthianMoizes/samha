package cci;

import cdp.Alocacao;
import cdp.Aula;
import cdp.Curso;
import cdp.Disciplina;
import cdp.Oferta;
import cdp.Professor;
import cdp.Turma;
import cgt.Constantes;
import cgt.Horarios;
import cih.oferta.JDOferta;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JToggleButton;

public class CtrlOferta extends CtrlGenerica{
    
    private CtrlPrincipal ctrlPrincipal;
    private JDOferta jdOferta;
    private List listaAlocacoes;
    private boolean abrindoTela = true;
    private boolean[] vetorProfessores;
    private String nomeProfessor;
    private RenderizadorCelulas renderTabelaProfessor;

    public CtrlOferta(CtrlPrincipal ctrl) {
        ctrlPrincipal = ctrl;
        renderTabelaProfessor = new RenderizadorCelulas(ctrlPrincipal, 2);
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
            JComboBox cbxTurma, JComboBox cbxTurno, JList lstAlocacoes, JTable tblTurma, JToggleButton btnCQD){
        
        
        if(ctrlPrincipal.getCtrlAula().isTemAlteracoes()){
            String mensagem = "Deseja salvar as alterações feitas ?";
            int confirmacao = CtrlMensagem.exibirMensagemConfirmacao(jdOferta, mensagem);
                if (confirmacao == 0) {
                    jdOferta.salvarAulas();
                    ctrlPrincipal.getCtrlAula().setTemAlteracoes(false);
                }
        }
        
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
            validarOferta(tblTurma, btnCQD);
        }
        
        preencherListaAlocacoes(ano, semestre, turma, lstAlocacoes, tblTurma);
        setarAlocacao();
    }
    
    public void atualizarOferta(int tempoMaximo, int intervaloMinimo){
        ctrlPrincipal.getGtPrincipal().getGtOferta().atualizarOferta(tempoMaximo, intervaloMinimo);
    }
    
    public void preencherListaAlocacoes(int ano, int semestre, Turma turma, JList lstAlocacoes, JTable tblTurma){
        
        List listaAlocacoes = null;
        setListaAlocacoes(listaAlocacoes);
        if(turma != null){ 
            
            listaAlocacoes = ctrlPrincipal.getGtPrincipal().getGtAlocacao().filtrarPorAnoSemestreMatriz(ano, semestre, turma.getMatriz().getId());
            setListaAlocacoes(listaAlocacoes);
            
            iniciarVetorProfessores(listaAlocacoes.size());
            
            if(listaAlocacoes.isEmpty())
                jdOferta.setarMensagem("Nenhuma alocação encontrada.");
            
        }else{
            ctrlPrincipal.getGtPrincipal().getGtAula().limparEstruturasArmazenamento();
            jdOferta.setarMensagem("Nenhuma turma encontrada.");
        }
        
        preencherJList(listaAlocacoes, lstAlocacoes); 
    }
    
    public void setarAlocacao(){
        if(listaAlocacoes != null && !listaAlocacoes.isEmpty()){
                jdOferta.getLstAlocacoes().setSelectedIndex(0);
                jdOferta.preencherHorarioProfessor();
        }else
            zerarTabelaProfessor();   
    }
    
    public void identificarOferta(int ano, int semestre, int tempoMaximo, int intervaloMinimo, Turma turma, JTable tblTurma, String turno){
        
        jdOferta.validarOferta(false);
        ctrlPrincipal.getGtPrincipal().getGtOferta().identificarOferta(ano, semestre, tempoMaximo, intervaloMinimo, turno, turma);
        
        jdOferta.setarTurma(turma.getNome());
        
        Oferta oferta = ctrlPrincipal.getGtPrincipal().getGtOferta().getOfertaSelecionada();
        atualizarTempoMaximoIntervaloMinimo(oferta);
        
        ctrlPrincipal.getCtrlAula().preencherTabelaAulas(tblTurma, turno);
    }
    
    public void atualizarTempoMaximoIntervaloMinimo(Oferta oferta){
        
        jdOferta.getSpnTempoMaximo().setEnabled(false);
        jdOferta.setarTempoMaximo((int) oferta.getTempoMaximoTrabalho());
        jdOferta.getSpnTempoMaximo().setEnabled(true);
        
        jdOferta.getSpnIntervalo().setEnabled(false);
        jdOferta.setarIntervaloMinimo((int) oferta.getIntervaloMinimo());
        jdOferta.getSpnIntervalo().setEnabled(true);
        
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
    }    
    
    public void validarOferta(JTable tabela, JToggleButton btnCQD){
        ctrlPrincipal.getCtrlConflito().validarOferta(tabela, jdOferta);
        if(btnCQD.isSelected()){
            btnCQD.setBackground(Color.BLUE);
            ctrlPrincipal.getCtrlConflito().validarQuantidadeAulasDisciplina();
        }else
            btnCQD.setBackground(new Color(240, 240, 240));
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
        int indice = lstAlocacoes.getSelectedIndex();
        
        if(indice >= 0){
            
            Alocacao alocacao = (Alocacao) listaAlocacoes.get(indice);
            int ano = alocacao.getAno();
            int semestre = alocacao.getSemestre();
            Professor professor = alocacao.getProfessor1();
            
            if(numero == 1)
                professor = alocacao.getProfessor2();

            listaAulas = ctrlPrincipal.getGtPrincipal().getGtAula().filtrarAulasProfessorAnoSemestre(ano, semestre, professor.getId());
            
            jdOferta.setarProfessor(professor.getNome());
            setNomeProfessor(professor.getNome());
            preencherTabelaProfessor(tblProfessor, listaAulas, indice, professor.getId(), (numero + 1));
        } 
    }
    
    public void preencherTabelaProfessor(JTable tblProfessor, List listaAulas, int indice, int idProfessor, int numero){
 
        Color corErro = new Color(255, 73, 73);
        renderTabelaProfessor.gerarMatrizCores();
        JTableUtil.limparCelulasTabela(tblProfessor);

        Aula aula;        
        for(int i = 0; i < listaAulas.size(); i++){
            aula = (Aula) listaAulas.get(i);
            
            tblProfessor.setValueAt(aula.getOferta().getTurma().getNome(), aula.getDia(), aula.getNumero());
            
            if(identificarConflitoAulaProfessor(aula, idProfessor, numero))
                pintarCelula(aula.getDia(), aula.getNumero(), corErro);
            else
                pintarCelula(aula.getDia(), aula.getNumero(), Color.WHITE);
        }
        
        if(!vetorProfessores[indice])
            exibirMensagemProfessorDesatualizado();
    }
    
    public boolean identificarConflitoAulaProfessor(Aula aula, int idProfessor, int numero){
        
        String conflitoTurma = ctrlPrincipal.getGtPrincipal().getGtConflito().identificarConflitoTurma(aula, idProfessor);
        if(conflitoTurma != null)
            return true;
         
        String conflitoRestricaoProfessor = ctrlPrincipal.getGtPrincipal().getGtConflito().identificarConflitoRestricaoProfessor(aula, idProfessor);
        if(conflitoRestricaoProfessor != null)
            return true;
        
        List conflitoInstituicao = ctrlPrincipal.getGtPrincipal().getGtInstituicao().identificarConflitoRestricaoInstituicao(aula, numero);
        if(!conflitoInstituicao.isEmpty())
            return true;
        
        return false;
    }

    public void pintarCelula(int linha, int coluna, Color cor){
        renderTabelaProfessor.setColorMatriz(linha, coluna, cor);
        jdOferta.getTblProfessor().repaint();
    }    
    
    public void zerarTabelaProfessor(){
        jdOferta.setarProfessor("");
        jdOferta.getCbxQuantidadeProfessor().setSelectedIndex(0);
        jdOferta.getCbxQuantidadeProfessor().setEnabled(false);
        JTableUtil.limparCelulasTabela(jdOferta.getTblProfessor());
    }
    
    public void desatualizarVetorProfessor(int indice){  
        if(indice >= 0){
            vetorProfessores[indice] = false;
            exibirMensagemProfessorDesatualizado();
        }
    }
    
    public void exibirMensagemProfessorDesatualizado(){
        String nomeProfessor = getNomeProfessor();
        jdOferta.setarProfessor(nomeProfessor + " - Aulas desatualizadas", Color.RED); 
    }
    
    public void identificarProfessor(Aula aula){
        
        Alocacao alocacao;
        for(int indice = 0; indice < listaAlocacoes.size(); indice++){
            alocacao = (Alocacao) listaAlocacoes.get(indice);
            if(alocacao.getProfessor1().getId() == aula.getAlocacao().getProfessor1().getId()){
                setNomeProfessor(alocacao.getProfessor1().getNome());
                desatualizarVetorProfessor(indice);
                jdOferta.getLstAlocacoes().setSelectedIndex(indice);
            }
        }  
    }
    
    public void iniciarVetorProfessores(int tam){
        vetorProfessores = new boolean[tam];
        limparVetorProfessores();
    }
    
    public void limparVetorProfessores(){
        
        if(vetorProfessores != null){
            for(int i = 0; i < vetorProfessores.length; i++)
                vetorProfessores[i] = true;     
        }
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    public RenderizadorCelulas getRenderTabelaProfessor() {
        return renderTabelaProfessor;
    }
}

package cci;

import cdp.Alocacao;
import cdp.Curso;
import cdp.Disciplina;
import cdp.Eixo;
import cdp.MatrizCurricular;
import cgt.Constantes;
import cih.alocacao.JDAlocacao;
import cih.alocacao.JDCargaHoraria;
import java.awt.Frame;
import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.JTable;

public class CtrlAlocacao extends CtrlGenerica{
    
    private CtrlPrincipal ctrlPrincipal;
    private JDAlocacao jdAlocacao;
    private JDCargaHoraria jdCargaHoraria;
    private Eixo eixoSelecionado;

    public CtrlAlocacao(CtrlPrincipal ctrl) {
        ctrlPrincipal = ctrl;
    }
    
    public Image setarIconeJanela() {
        ImageIcon icone = new ImageIcon("build/classes/cih/img/alocacao.png");
        return icone.getImage();
    }
    
    public void instanciarTelaAlocacao(Frame pai) {
        jdAlocacao = new JDAlocacao(pai, true, ctrlPrincipal);
        jdAlocacao.setIconImage(setarIconeJanela());
        jdAlocacao.preencherComboCurso();
        jdAlocacao.preencherComboEixo();
        identificarUltimaAlocacao();
        jdAlocacao.atualizarTabela();
        jdAlocacao.setVisible(true);
        
    }
     
    public void instanciarTelaCargaHoraria(Frame pai){
        
        if(jdCargaHoraria == null){
            jdCargaHoraria = new JDCargaHoraria(pai, true, ctrlPrincipal);
            jdCargaHoraria.setIconImage(setarIconeJanela()); 
        }
        
        jdCargaHoraria.atualizarTabela();
        
        if(jdCargaHoraria != null)
            jdCargaHoraria.setVisible(true);             
    }
    
    public void identificarUltimaAlocacao(){
        
        Alocacao ultimaAlocacao = ctrlPrincipal.getGtPrincipal().getGtAlocacao().identificarUltimaAlocacao();
        if(ultimaAlocacao != null){
            jdAlocacao.setAno(ultimaAlocacao.getAno());
            jdAlocacao.setSemestre(ultimaAlocacao.getSemestre());
        }
    }
    
    public void cadastrar(JList lstProfessores, JList lstDisciplinas, JSpinner spnAno, JSpinner spnSemestre) {
        
        List professores = lstProfessores.getSelectedValuesList();
        Disciplina disciplina = (Disciplina) lstDisciplinas.getSelectedValue();
        int ano = (int) spnAno.getValue();
        int semestre = (int) spnSemestre.getValue();
        
        String resposta = ctrlPrincipal.getGtPrincipal().getGtAlocacao().cadastrar(professores, disciplina, ano, semestre);

        if (resposta.equals(Constantes.CADASTRADO)) {
            jdAlocacao.atualizarTabela();
        } else {
            CtrlMensagem.exibirMensagemErro(jdAlocacao, resposta);
        }
    }
    
    public void listarAlocacoes(int ano, int semestre, int periodo, JTable tabela, JComboBox cbxMatriz){
        
        MatrizCurricular matriz = (MatrizCurricular) cbxMatriz.getSelectedItem();
        
        if(matriz != null){
            
            List listaAlocacoes = ctrlPrincipal.getGtPrincipal().getGtAlocacao().filtrarPorAnoSemestreMatriz(ano, semestre, periodo, matriz.getId());
            listarEmTabela(listaAlocacoes, tabela, jdAlocacao, "toArray");
               
        if( listaAlocacoes.isEmpty())
                jdAlocacao.setarMensagem("Nenhuma alocação encontrada.");
        
        if(jdCargaHoraria != null)
            jdCargaHoraria.atualizarTabela();
        
        }else
            jdAlocacao.setarMensagem("Matriz Curricular não foi selecionada.");

    }
    
    public void listarCargaHorariaProfessores(JTable tabela){
        
        if(getEixoSelecionado() != null){
            
            List listaProfessores = ctrlPrincipal.getCtrlProfessor().filtrarPorEixo(getEixoSelecionado().getId());
            
            int ano = jdAlocacao.getAno();
            int semestre = jdAlocacao.getSemestre();
            
            List listaCargasHorarias = ctrlPrincipal.getGtPrincipal().getGtAlocacao().calcularCargaHorariaProfessor(ano, semestre, listaProfessores);
            listarEmTabela(listaCargasHorarias, tabela, jdCargaHoraria, "toArrayCargaHoraria");

        }else{
            jdCargaHoraria = null;
            CtrlMensagem.exibirMensagemAviso(jdCargaHoraria, "Selecione uma coordenadoria");
        }
    }
    
    public void excluir(JTable tabela) {
        
        try {
            Alocacao alocacao = (Alocacao) JTableUtil.getDadosLinhaSelecionada(tabela);
            int confirmacao = CtrlMensagem.exibirMensagemConfirmacao(this.jdAlocacao, "Confirmar Remoção ?");
            if (confirmacao == 0) {
                String resposta = ctrlPrincipal.getGtPrincipal().getGtAlocacao().excluir(alocacao);
                if (resposta.equals(Constantes.EXCLUIDO)){ 
                    jdAlocacao.atualizarTabela();
                }else 
                    CtrlMensagem.exibirMensagemErro(this.jdAlocacao, resposta);   
            }    
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            CtrlMensagem.exibirMensagemErro(jdAlocacao, "Selecione uma alocação");
        }
    }
    
    public void preencherComboCurso(JComboBox cbxCurso, JComboBox cbxMatriz){ 
        
        List listaCursos = ctrlPrincipal.getCtrlCurso().listar();
        preencherCombo(cbxCurso, listaCursos);
        
        if(!listaCursos.isEmpty())
            preencherComboMatriz(cbxCurso, cbxMatriz);   
    }

    public void preencherComboMatriz(JComboBox cbxCurso, JComboBox cbxMatriz) {
        
        Curso curso = (Curso) cbxCurso.getSelectedItem();
        if(curso != null){
            jdAlocacao.setarPeriodoMaximo(curso.getQtPeriodos());
            List listaMatriz = ctrlPrincipal.getCtrlMatriz().filtrarMatrizCurso(curso.getId());
            preencherCombo(cbxMatriz, listaMatriz); 
            jdAlocacao.preencherListaDisciplinas();
            jdAlocacao.atualizarTabela();
        }    
    }
    
    public void preencherComboEixos(JComboBox cbxEixo){ 
        
        List listaEixos = ctrlPrincipal.getCtrlEixo().consultar();
        preencherCombo(cbxEixo, listaEixos);
        
        if(listaEixos.size() > 0)
            jdAlocacao.preencherListaProfessores();  
    }
    
    public void preencherListaDisciplinas(JComboBox cbxMatriz, JList lstDisciplinas, JSpinner spnPeriodo) {
        
        int periodo = (int) spnPeriodo.getValue();
        MatrizCurricular matriz = (MatrizCurricular) cbxMatriz.getSelectedItem();
        List listaDisciplinas = null;
        
        if(matriz != null)
            listaDisciplinas = ctrlPrincipal.getCtrlDisciplina().filtrarPorMatrizPeriodo(matriz.getId(), periodo);     
        else
            jdAlocacao.setarMensagem("Curso não possui matriz cadastrada.");
        
        preencherJList(listaDisciplinas, lstDisciplinas); 
    }
    
    public void preencherListaProfessores(JComboBox cbxEixo, JList lstProfessores) {
        
        Eixo eixo = (Eixo) cbxEixo.getSelectedItem();
        
        if(eixo != null){
            
            setEixoSelecionado(eixo);
        
            if(jdCargaHoraria != null)
                jdCargaHoraria.atualizarTabela();      

            List listaProfessores = ctrlPrincipal.getCtrlProfessor().filtrarPorEixo(eixo.getId());
            preencherJList(listaProfessores, lstProfessores);
        }else
            jdAlocacao.setarMensagem("Eixo não selecionado.");
    }

    public Eixo getEixoSelecionado() {
        return eixoSelecionado;
    }

    public void setEixoSelecionado(Eixo eixo) {
        this.eixoSelecionado = eixo;
    }
    
    public void identificarDisciplinaEspecial(JList lstDisciplinas){
        
        Disciplina disciplina = (Disciplina) lstDisciplinas.getSelectedValue();
        
        if(disciplina != null){
            if(disciplina.getTipo().equals(Constantes.ESPECIAL))
                jdAlocacao.setarAtalho("Pressione Ctrl para selecionar 2 professores.");
            else
                jdAlocacao.setarAtalho("Selecione 1 professor.");
        }
        
    }
}

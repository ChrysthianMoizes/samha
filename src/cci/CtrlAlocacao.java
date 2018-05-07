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
    private JDAlocacao cadastraAlocacao;
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
        cadastraAlocacao = new JDAlocacao(pai, true, ctrlPrincipal);
        cadastraAlocacao.setIconImage(setarIconeJanela());
        cadastraAlocacao.preencherComboCurso();
        cadastraAlocacao.preencherComboEixo();
        identificarUltimaAlocacao();
        cadastraAlocacao.atualizarTabela();
        cadastraAlocacao.setVisible(true);
        
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
            cadastraAlocacao.setAno(ultimaAlocacao.getAno());
            cadastraAlocacao.setSemestre(ultimaAlocacao.getSemestre());
        }
    }
    
    public void cadastrar(JList lstProfessores, JList lstDisciplinas, JSpinner spnAno, JSpinner spnSemestre) {
        
        List professores = lstProfessores.getSelectedValuesList();
        Disciplina disciplina = (Disciplina) lstDisciplinas.getSelectedValue();
        int ano = (int) spnAno.getValue();
        int semestre = (int) spnSemestre.getValue();
        
        String resposta = ctrlPrincipal.getGtPrincipal().getGtAlocacao().cadastrar(professores, disciplina, ano, semestre);

        if (resposta.equals(Constantes.CADASTRADO)) {
            cadastraAlocacao.atualizarTabela();
        } else {
            CtrlMensagem.exibirMensagemErro(cadastraAlocacao, resposta);
        }
    }
    
    public void listarAlocacoes(int ano, int semestre, JTable tabela, JComboBox cbxMatriz){
        
        MatrizCurricular matriz = (MatrizCurricular) cbxMatriz.getSelectedItem();
        
        if(matriz != null){
            
            List listaAlocacoes = ctrlPrincipal.getGtPrincipal().getGtAlocacao().filtrarPorAnoSemestreMatriz(ano, semestre, matriz.getId());
            listarEmTabela(listaAlocacoes, tabela, cadastraAlocacao, "toArray");
               
        if( listaAlocacoes.isEmpty())
                cadastraAlocacao.setarMensagem("Nenhuma alocação encontrada.");
        
        if(jdCargaHoraria != null)
            jdCargaHoraria.atualizarTabela();
        
        }else
            cadastraAlocacao.setarMensagem("Matriz Curricular não foi selecionada.");

    }
    
    public void listarCargaHorariaProfessores(JTable tabela){
        
        if(getEixoSelecionado() != null){
            
            List listaProfessores = ctrlPrincipal.getCtrlProfessor().filtrarPorEixo(getEixoSelecionado().getId());
            
            int ano = cadastraAlocacao.getAno();
            int semestre = cadastraAlocacao.getSemestre();
            
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
            int confirmacao = CtrlMensagem.exibirMensagemConfirmacao(this.cadastraAlocacao, "Confirmar Remoção ?");
            if (confirmacao == 0) {
                String resposta = ctrlPrincipal.getGtPrincipal().getGtAlocacao().excluir(alocacao);
                if (resposta.equals(Constantes.EXCLUIDO)){ 
                    cadastraAlocacao.atualizarTabela();
                }else 
                    CtrlMensagem.exibirMensagemErro(this.cadastraAlocacao, resposta);   
            }    
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            CtrlMensagem.exibirMensagemErro(cadastraAlocacao, "Selecione uma alocação");
        }
    }
    
    public void preencherComboCurso(JComboBox cbxCurso, JComboBox cbxMatriz){ 
        
        List listaCursos = ctrlPrincipal.getCtrlCurso().listar();
        preencherCombo(cbxCurso, listaCursos);
        
        if(listaCursos.size() > 0){
            Curso curso = (Curso) cbxCurso.getSelectedItem();
            preencherComboMatriz(cbxCurso, cbxMatriz);
            cadastraAlocacao.setarPeriodoMaximo(curso.getQtPeriodos());
        }
    }

    public void preencherComboMatriz(JComboBox cbxCurso, JComboBox cbxMatriz) {
        
        Curso curso = (Curso) cbxCurso.getSelectedItem();
        if(curso != null){
            cadastraAlocacao.setarPeriodoMaximo(curso.getQtPeriodos());
            List listaMatriz = ctrlPrincipal.getCtrlMatriz().filtrarMatrizCurso(curso.getId());
            preencherCombo(cbxMatriz, listaMatriz); 
            cadastraAlocacao.preencherListaDisciplinas();
        }    
    }
    
    public void preencherComboEixos(JComboBox cbxEixo){ 
        
        List listaEixos = ctrlPrincipal.getCtrlEixo().consultar();
        preencherCombo(cbxEixo, listaEixos);
        
        if(listaEixos.size() > 0)
            cadastraAlocacao.preencherListaProfessores();  
    }
    
    public void preencherListaDisciplinas(JComboBox cbxMatriz, JList lstDisciplinas, JSpinner spnPeriodo) {
        
        int periodo = (int) spnPeriodo.getValue();
        MatrizCurricular matriz = (MatrizCurricular) cbxMatriz.getSelectedItem();
        if(matriz != null){
            List listaDisciplinas = ctrlPrincipal.getCtrlDisciplina().filtrarPorMatrizPeriodo(matriz.getId(), periodo);
            preencherJList(listaDisciplinas, lstDisciplinas);  
        }else{
            preencherJList(null, lstDisciplinas);
            cadastraAlocacao.setarMensagem("Curso não possui matriz cadastrada.");
        }
    }
    
    public void preencherListaProfessores(JComboBox cbxEixo, JList lstProfessores) {
        
        cadastraAlocacao.setarMensagem("");
        Eixo eixo = (Eixo) cbxEixo.getSelectedItem();
        
        if(eixo != null){
            
            setEixoSelecionado(eixo);
        
            if(jdCargaHoraria != null)
                jdCargaHoraria.atualizarTabela();      

            List listaProfessores = ctrlPrincipal.getCtrlProfessor().filtrarPorEixo(eixo.getId());
            preencherJList(listaProfessores, lstProfessores);
        }else
            cadastraAlocacao.setarMensagem("Eixo não selecionado.");
    }

    public Eixo getEixoSelecionado() {
        return eixoSelecionado;
    }

    public void setEixoSelecionado(Eixo eixo) {
        this.eixoSelecionado = eixo;
    }
}

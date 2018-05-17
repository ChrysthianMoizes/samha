package cci;

import cdp.Alocacao;
import cdp.Aula;
import cdp.Curso;
import cdp.Disciplina;
import cdp.Professor;
import cdp.Turma;
import cgt.Constantes;
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
    private JDOferta jdOferta;
    private RenderizadorCelulas render;
    private List listaAlocacoes;
    private boolean dropInterno = false;
    private boolean abrindoTela = true;
    private Aula aulaSelecionada;

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
            validarOfertas(tblTurma);
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
        preencherTabelaAulas(tblTurma);
    }
    
    public void preencherTabelaAulas(JTable tblTurma){
 
        JTableUtil.limparCelulasTabela(tblTurma);
        Aula aula;
        
        for(int linha = 0; linha < Constantes.LINHA; linha++){
            
            for(int coluna = 0; coluna < Constantes.COLUNA; coluna++){
                aula = ctrlPrincipal.getGtPrincipal().getGtOferta().getAulaMatriz(linha, coluna);
                if(aula != null)
                    tblTurma.setValueAt(aula, linha, coluna);
            }  
        }
    }
    
    public void gerarAula(JList lstAlocacoes, JTable tblTurma, JComboBox cbxTurno){
        
        Aula aula = null;
        
        int indice = lstAlocacoes.getSelectedIndex();
        
        int coluna = tblTurma.getSelectedColumn();
        int linha = tblTurma.getSelectedRow();

        if((linha >= 0) && (coluna >= 0)){

            String turno = (String) cbxTurno.getSelectedItem();
            Alocacao alocacao = (Alocacao) getListaAlocacoes().get(indice);
            aula = ctrlPrincipal.getGtPrincipal().getGtOferta().gerarNovaAula(alocacao, linha, turno, coluna);
                
        }       
        setAulaSelecionada(aula);
    }
    
    public void arrastarAula(int linha, int coluna, Aula aula){
        
        if(aula != null && !isDropInterno())    // ARRASTAR DA LISTA         
            ctrlPrincipal.getGtPrincipal().getGtOferta().importarAulaLista(linha, coluna, aula);  
        else if(aula != null && isDropInterno())  // ARRASTAR DA TABELA
            ctrlPrincipal.getGtPrincipal().getGtOferta().moverAulaMatriz(linha, coluna, aula);  
        else
            CtrlMensagem.exibirMensagemErro(jdOferta, "Aula nula");
        
        preencherTabelaAulas(jdOferta.getTblTurma());
    }
    
    public void identificarOrigem(int linha, int coluna){
        
        jdOferta.validarOferta(true);
        
        int indice = jdOferta.getLstAlocacoes().getSelectedIndex();
        
        if(indice >= 0 && !isDropInterno())
            jdOferta.gerarAula();

        arrastarAula(linha, coluna, getAulaSelecionada());
        jdOferta.getTblTurma().setValueAt(getAulaSelecionada(), linha, coluna);

        setAulaSelecionada(null);
    }
    
    public void removerAula(JTable tblTurma){
        
        jdOferta.validarOferta(true);
        int coluna = tblTurma.getSelectedColumn();
        int linha = tblTurma.getSelectedRow();
        
        Aula aula = (Aula) tblTurma.getValueAt(linha, coluna);
        ctrlPrincipal.getGtPrincipal().getGtOferta().removerAula(aula);
        tblTurma.setValueAt(null, linha, coluna);
        setAulaSelecionada(null);
        setDropInterno(false);
    }
    
    public void atualizarAulas(JComboBox cbxTurma){
        
        jdOferta.limparNotificacoes();
        Turma turma = (Turma) cbxTurma.getSelectedItem();       
        
        if(turma != null){
            
            String resposta = ctrlPrincipal.getGtPrincipal().getGtOferta().atualizarAulas();

            if(resposta.equals(Constantes.CADASTRADO))
                CtrlMensagem.exibirMensagemSucesso(jdOferta, "Salvo com Sucesso!");
            else
                CtrlMensagem.exibirMensagemErro(jdOferta, resposta);
            
            jdOferta.atualizarTela();
        }else
            CtrlMensagem.exibirMensagemErro(jdOferta, "Nenhuma turma selecionada.");
        
        zerarTabelaProfessor();
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
                tblTurma.getColumnModel().getColumn(0).setHeaderValue(Constantes.MATUTINO_1);
                tblTurma.getColumnModel().getColumn(1).setHeaderValue(Constantes.MATUTINO_2);
                tblTurma.getColumnModel().getColumn(2).setHeaderValue(Constantes.MATUTINO_3);
                tblTurma.getColumnModel().getColumn(3).setHeaderValue(Constantes.MATUTINO_4);
                tblTurma.getColumnModel().getColumn(4).setHeaderValue(Constantes.MATUTINO_5);
                tblTurma.getColumnModel().getColumn(5).setHeaderValue(Constantes.MATUTINO_6);
                break;
                
            case Constantes.VESPERTINO: 
                tblTurma.getColumnModel().getColumn(0).setHeaderValue(Constantes.VESPERTINO_1);
                tblTurma.getColumnModel().getColumn(1).setHeaderValue(Constantes.VESPERTINO_2);
                tblTurma.getColumnModel().getColumn(2).setHeaderValue(Constantes.VESPERTINO_3);
                tblTurma.getColumnModel().getColumn(3).setHeaderValue(Constantes.VESPERTINO_4);
                tblTurma.getColumnModel().getColumn(4).setHeaderValue(Constantes.VESPERTINO_5);
                tblTurma.getColumnModel().getColumn(5).setHeaderValue(Constantes.VESPERTINO_6);
                break;
                
            default:
                tblTurma.getColumnModel().getColumn(0).setHeaderValue(Constantes.NOTURNO_1);
                tblTurma.getColumnModel().getColumn(1).setHeaderValue(Constantes.NOTURNO_2);
                tblTurma.getColumnModel().getColumn(2).setHeaderValue(Constantes.NOTURNO_3);
                tblTurma.getColumnModel().getColumn(3).setHeaderValue(Constantes.NOTURNO_4);
                tblTurma.getColumnModel().getColumn(4).setHeaderValue(Constantes.NOTURNO_5);
                tblTurma.getColumnModel().getColumn(5).setHeaderValue(Constantes.NOTURNO_6);
                break;
        }
        jdOferta.repaint();
    }    
    
    public void validarOfertas(JTable tabela){
        
        jdOferta.limparNotificacoes();
        int conflitos = 0;
        
        for(int linha = 0; linha < Constantes.LINHA; linha++){
            
            for(int coluna = 0; coluna < Constantes.COLUNA; coluna++){
                
                Aula aula = (Aula) ctrlPrincipal.getGtPrincipal().getGtOferta().getAulaMatriz(linha, coluna);
                
                if(aula != null){
                    String mensagem = ctrlPrincipal.getGtPrincipal().getGtOferta().validarOferta(aula);
                    if(mensagem != null){
                        conflitos++;
                        String notificacao = mensagem.substring(2);
                        exibirNotificação(notificacao, aula, Color.RED);
                    }
                    pintarCelulaTabela(mensagem, linha, coluna, tabela);
                }
            }
        }
        if(conflitos == 0){
            Color cor = new Color(53,151,48);
            jdOferta.exibirNotificacao("Nenhum conflito encontrado!", cor);       
        }
        jdOferta.validarOferta(false);
    }
 
    public void exibirNotificação(String notificacao, Aula aula, Color cor){
        int numero = aula.getNumero() + 1; 
        jdOferta.exibirNotificacao(aula.getDia() + ": Aula " + numero + ".\n" + notificacao+"\n\n", cor);     
    }
    
    public void pintarCelulaTabela(String mensagem, int linha, int coluna, JTable tabela){
        
//        if(mensagem != null){
//            
//            int codigo = mensagem.charAt(0);
//            
//            if(codigo == 0)
//                render.setCor(Color.RED);
//               celula.setBackground(Color.RED);  
//            else
//                render.setCor(Color.YELLOW);
//               celula.setBackground(Color.YELLOW); 
//        }else
//            render.setCor(Color.GREEN);
//            celula.setBackground(Color.GREEN);
//
//        render.prepareRenderer(null, linha, coluna);
    }

    public List getListaAlocacoes() {
        return listaAlocacoes;
    }

    public void setListaAlocacoes(List listaAlocacoes) {
        this.listaAlocacoes = listaAlocacoes;
    }

    public boolean isDropInterno() {
        return dropInterno;
    }

    public void setDropInterno(boolean dropInterno) {
        this.dropInterno = dropInterno;
    }

    public boolean isAbrindoTela() {
        return abrindoTela;
    }

    public void setAbrindoTela(boolean abrindoTela) {
        this.abrindoTela = abrindoTela;
    }

    public Aula getAulaSelecionada() {
        return aulaSelecionada;
    }

    public void setAulaSelecionada(Aula aulaSelecionada) {
        this.aulaSelecionada = aulaSelecionada;
    }
    
    //================================================= TABELA DE PROFESSOR ================================================================
    
    public void preencherHorarioProfessor(JList lstAlocacoes, JTable tblProfessor, JComboBox cbxQuantidadeProfessor){
        
        if (!listaAlocacoes.isEmpty()) {
            
            int indice = lstAlocacoes.getSelectedIndex();
            Alocacao alocacao = (Alocacao) listaAlocacoes.get(indice);
            
            Disciplina disciplina = alocacao.getDisciplina();

            if(disciplina.getTipo().toLowerCase().equals(Constantes.ESPECIAL))
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
                listaAulas = ctrlPrincipal.getGtPrincipal().getGtOferta().listarAulasProfessor(professor.getId(), ano, semestre, 1);
            }else{
                professor = alocacao.getProfessor2();
                listaAulas = ctrlPrincipal.getGtPrincipal().getGtOferta().listarAulasProfessor(professor.getId(), ano, semestre, 2);
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
            linha = ctrlPrincipal.getGtPrincipal().getGtOferta().obterInteiroDia(aula.getDia());
            turno = calcularNumeroTurno(aula.getTurno());
            coluna = (aula.getNumero() + turno);
            tblProfessor.setValueAt(aula.getOferta().getTurma().getNome(), linha, coluna);
        }   
    }
    
    public int calcularNumeroTurno(String turno){
        
        switch (turno.toUpperCase()) {
            case Constantes.MATUTINO:
                return 0;
            case Constantes.VESPERTINO:
                return 6;
            default:
                return 12;
        }
    }
}

package cci;

import cdp.Alocacao;
import cdp.Aula;
import cdp.Turma;
import cgt.Constantes;
import cih.oferta.JDOferta;
import java.awt.Color;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTable;

public class CtrlAula {
    
    private CtrlPrincipal ctrlPrincipal;
    private boolean dropInterno = false;
    private boolean temAlteracoes = false;
    private Aula aulaSelecionada;
    private JDOferta jdOferta;
    
    public CtrlAula(CtrlPrincipal ctrl){
        this.ctrlPrincipal = ctrl;
    }
    
    public void identificarOrigem(int linha, int coluna){
        
        setJdOferta(ctrlPrincipal.getCtrlOferta().getJdOferta());
        
        if(ctrlPrincipal.getGtPrincipal().getGtOferta().getOfertaSelecionada() != null){
            
            jdOferta.validarOferta(true);

            int indice = jdOferta.getLstAlocacoes().getSelectedIndex();

            ctrlPrincipal.getCtrlOferta().desatualizarVetorProfessor(indice);

            if(indice >= 0 && !isDropInterno())
                jdOferta.gerarAula();

            arrastarAula(linha, coluna, getAulaSelecionada());
            preencherTabelaAulas(jdOferta.getTblTurma(), (String) jdOferta.getCbxTurno().getSelectedItem());
            setAulaSelecionada(null);
            setTemAlteracoes(true);
        }else{
            CtrlMensagem.exibirMensagemErro(jdOferta, "Esta turma não está ativa neste ano/período.");
        }
    }
    
    public void preencherTabelaAulas(JTable tblTurma, String turno){
        
        JTableUtil.limparCelulasTabela(tblTurma);
        
        if(ctrlPrincipal.getGtPrincipal().getGtOferta().getOfertaSelecionada() != null){
            
            int t = ctrlPrincipal.getGtPrincipal().getGtAula().obterNumeroTurno(turno);
            ctrlPrincipal.getCtrlConflito().getRender().setTurno(t);
            
            Aula aula;

            for(int linha = 0; linha < Constantes.LINHA; linha++){

                for(int coluna = t; coluna < (Constantes.AULAS + t); coluna++){
                    aula = ctrlPrincipal.getGtPrincipal().getGtAula().getAulaMatriz(linha, coluna);
                    if(aula != null)
                        tblTurma.setValueAt(aula, linha, aula.getNumero() - t);
                }  
            }
        }
        setTemAlteracoes(false);
    }
    
    public void gerarAula(JList lstAlocacoes, JTable tblTurma, JComboBox cbxTurno){
        
        Aula aula = null;
        
        int indice = lstAlocacoes.getSelectedIndex();
        
        int coluna = tblTurma.getSelectedColumn();
        int linha = tblTurma.getSelectedRow();

        if((linha >= 0) && (coluna >= 0)){

            String turno = (String) cbxTurno.getSelectedItem();
            Alocacao alocacao = (Alocacao) ctrlPrincipal.getCtrlOferta().getListaAlocacoes().get(indice);
            aula = ctrlPrincipal.getGtPrincipal().getGtAula().gerarNovaAula(alocacao, linha, turno, coluna);             
        }       
        setAulaSelecionada(aula);
    }
    
    public void arrastarAula(int linha, int coluna, Aula aula){
        
        ctrlPrincipal.getCtrlConflito().pintarCelulaTabelaTurma(linha, coluna, Color.WHITE);
        
        String t = (String) jdOferta.getCbxTurno().getSelectedItem();
        int turno = ctrlPrincipal.getGtPrincipal().getGtAula().obterNumeroTurno(t);
        
        if(aula != null && !isDropInterno()){    // ARRASTAR DA LISTA         
            ctrlPrincipal.getGtPrincipal().getGtAula().importarAulaLista(aula);
            ctrlPrincipal.getCtrlConflito().pintarCelulaTabelaTurma(aula.getDia(), aula.getNumero(), Color.WHITE);
        }else if(aula != null && isDropInterno()){  // ARRASTAR DA TABELA
            ctrlPrincipal.getCtrlConflito().pintarCelulaTabelaTurma(aula.getDia(), aula.getNumero(), Color.WHITE);
            ctrlPrincipal.getGtPrincipal().getGtAula().moverAulaMatriz(linha, coluna, turno, aula);  
        }else
            CtrlMensagem.exibirMensagemAviso(jdOferta, "Selecione uma aula válida.");
        
        jdOferta.getTblTurma().setValueAt(getAulaSelecionada(), linha, coluna);
    }

    public void removerAula(JTable tblTurma){
        
        setJdOferta(ctrlPrincipal.getCtrlOferta().getJdOferta());
        jdOferta.validarOferta(true);
        
        int coluna = tblTurma.getSelectedColumn();
        int linha = tblTurma.getSelectedRow();
        
        Aula aula = (Aula) tblTurma.getValueAt(linha, coluna);
        
        ctrlPrincipal.getCtrlOferta().identificarProfessor(aula);
        
        ctrlPrincipal.getCtrlConflito().pintarCelulaTabelaTurma(aula.getDia(), aula.getNumero(), Color.WHITE);
        ctrlPrincipal.getGtPrincipal().getGtAula().removerAula(aula);
        tblTurma.setValueAt(null, linha, coluna);
        setAulaSelecionada(null);
        setDropInterno(false);
        setTemAlteracoes(true);
    }
    
    public void salvarAulas(JComboBox cbxTurma){
        
        setJdOferta(ctrlPrincipal.getCtrlOferta().getJdOferta()); 
        Turma turma = (Turma) cbxTurma.getSelectedItem();
        int indice = jdOferta.getLstAlocacoes().getSelectedIndex();
        
        if(turma != null){
            
            String resposta = ctrlPrincipal.getGtPrincipal().getGtAula().salvarAulas();

            if(resposta.equals(Constantes.CADASTRADO)){
                CtrlMensagem.exibirMensagemSucesso(jdOferta, "As aulas foram salvas com Sucesso!");
                setTemAlteracoes(false);
                ctrlPrincipal.getCtrlOferta().limparVetorProfessores();
                jdOferta.atualizarTela();
            }else
                CtrlMensagem.exibirMensagemErro(jdOferta, resposta);
        }else
            CtrlMensagem.exibirMensagemErro(jdOferta, "Nenhuma turma selecionada.");
        
        if(indice >= 0){
            jdOferta.getLstAlocacoes().setSelectedIndex(indice);
            jdOferta.preencherHorarioProfessor();
        }else
            ctrlPrincipal.getCtrlOferta().zerarTabelaProfessor();
    }

    public boolean isDropInterno() {
        return dropInterno;
    }

    public void setDropInterno(boolean dropInterno) {
        this.dropInterno = dropInterno;
    }

    public boolean isTemAlteracoes() {
        return temAlteracoes;
    }

    public void setTemAlteracoes(boolean temAlteracoes) {
        this.temAlteracoes = temAlteracoes;
    }

    public Aula getAulaSelecionada() {
        return aulaSelecionada;
    }

    public void setAulaSelecionada(Aula aulaSelecionada) {
        this.aulaSelecionada = aulaSelecionada;
    }

    public JDOferta getJdOferta() {
        return jdOferta;
    }

    public void setJdOferta(JDOferta jdOferta) {
        this.jdOferta = jdOferta;
    }
    
    public void sair(String turma){
        
        setJdOferta(ctrlPrincipal.getCtrlOferta().getJdOferta());

        if(isTemAlteracoes()){
            
            String mensagem = "Deseja salvar as alterações feitas em " + turma + " ?";
            int confirmacao = CtrlMensagem.exibirMensagemConfirmacaoCancelar(jdOferta, mensagem);
            
                if (confirmacao == 0){ 
                    jdOferta.salvarAulas();
                    ctrlPrincipal.getGtPrincipal().getGtAula().gerarEstruturasArmazenamento();
                    ctrlPrincipal.getCtrlOferta().limparCorCelulasTabelaProfessor();
                    ctrlPrincipal.getGtPrincipal().getGtAula().setListaAulasAnoSemestre(null);
                    jdOferta.dispose();
                }else if(confirmacao == 1){
                    setTemAlteracoes(false);
                    ctrlPrincipal.getGtPrincipal().getGtAula().gerarEstruturasArmazenamento();
                    ctrlPrincipal.getCtrlOferta().limparCorCelulasTabelaProfessor();
                    ctrlPrincipal.getGtPrincipal().getGtAula().setListaAulasAnoSemestre(null);
                    jdOferta.dispose();
                }
                
        }else{
            ctrlPrincipal.getGtPrincipal().getGtAula().gerarEstruturasArmazenamento();
            ctrlPrincipal.getCtrlOferta().limparCorCelulasTabelaProfessor();
            ctrlPrincipal.getGtPrincipal().getGtAula().setListaAulasAnoSemestre(null);
            jdOferta.dispose();
        }
    } 
    
    public void desfazer(String turma, int ano, int semestre){
        
        setJdOferta(ctrlPrincipal.getCtrlOferta().getJdOferta());
        
        if(isTemAlteracoes()){
            String mensagem = "Deseja desfazer as alterações feitas em " + turma + " ?";
            int confirmacao = CtrlMensagem.exibirMensagemConfirmacao(jdOferta, mensagem);
                if (confirmacao == 0) {
                    setTemAlteracoes(false);
                    ctrlPrincipal.getGtPrincipal().getGtAula().preencherListaAulasAnoSemestre(ano, semestre);
                    jdOferta.atualizarTela();
                }
        }else
            CtrlMensagem.exibirMensagemAviso(jdOferta, "Nenhuma alteração encontrada.");
    }
    
    public List filtrarAulasProfessorAnoSemestre(int id){
        return ctrlPrincipal.getGtPrincipal().getGtAula().filtrarAulasProfessorLista(id);
    }
    
    public List filtrarAulasTurmaAnoSemestre(int id){
        return ctrlPrincipal.getGtPrincipal().getGtAula().filtrarAulasTurmaLista(id);
    }
    
    public List[] filtrarOrdenarAulasTurmaDiaAnoSemestre(int id){
        return ctrlPrincipal.getGtPrincipal().getGtAula().filtrarOrdenarAulasTurmaDiaLista(id);
    }
    
    public List[] filtrarOrdenarAulasDiaProfessorAnoSemestre(int idProfessor){
        return ctrlPrincipal.getGtPrincipal().getGtAula().filtrarOrdenarAulasProfessorDiaLista(idProfessor);
    }
}

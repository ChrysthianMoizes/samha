package cci;

import cdp.Alocacao;
import cdp.Aula;
import cdp.Curso;
import cdp.Turma;
import cgt.Constantes;
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
    private boolean dropInterno = false;
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
        
        if(listaCursos.size() > 0){
            Curso curso = (Curso) cbxCurso.getSelectedItem();
            preencherComboTurma(curso.getId(), cbxTurma);
        }  
    }
    
    public void preencherComboTurma(int id, JComboBox cbxTurma) {
        
        List listaTurmas = ctrlPrincipal.getCtrlTurma().buscar("curso", String.valueOf(id));
        preencherCombo(cbxTurma, listaTurmas);
        jdOferta.atualizarTela();
        
    }
    
    public void atualizarTela(int ano, int semestre, JComboBox cbxTurma, JComboBox cbxTurno, JList lstAlocacoes, JTable tblTurma){
        
        JTableUtil.limparCelulasTabela(tblTurma);
        jdOferta.limparNotificacoes();
        Turma turma = (Turma) cbxTurma.getSelectedItem();
        String turno = (String) cbxTurno.getSelectedItem();
        
        identificarOferta(ano, semestre, turma, tblTurma, turno);
        preencherListaAlocacoes(ano, semestre, turma, cbxTurno, lstAlocacoes, tblTurma);    
    }
    
    public void preencherListaAlocacoes(int ano, int semestre, Turma turma, JComboBox cbxTurno, JList lstAlocacoes, JTable tblTurma){
        
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
    
    public void identificarOferta(int ano, int semestre, Turma turma, JTable tblTurma, String turno){
        
        if(turma != null){
            ctrlPrincipal.getGtPrincipal().getGtOferta().identificarOferta(ano, semestre, turno, turma.getId());
            alterarTurno(turno, tblTurma);
            preencherTabelaAulas(tblTurma);
            validarOfertas(tblTurma);
        }
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
    
    public Aula gerarAula(JList lstAlocacoes, JTable tblTurma, JComboBox cbxTurno){
        
        Aula aula = null;
        int posicao = lstAlocacoes.getSelectedIndex();
        
        if(posicao >= 0){
            
            int coluna = tblTurma.getSelectedColumn();
            int linha = tblTurma.getSelectedRow();
            
            if((linha >= 0) && (coluna >= 0)){
                
                String turno = (String) cbxTurno.getSelectedItem();
                Alocacao alocacao = (Alocacao) getListaAlocacoes().get(posicao);
                aula = ctrlPrincipal.getGtPrincipal().getGtOferta().gerarNovaAula(alocacao, linha, turno, coluna);
                
            }else
                exibirNotificação("1 Selecione uma célula da tabela.", -1, -1);
        }
        
        return aula;
    }
    
    public void importarAulaLista(int linha, int coluna, Aula aula){
        
        if(aula != null && !isDropInterno()){    // ESTOU ARRASTANDO DA LISTA         
            ctrlPrincipal.getGtPrincipal().getGtOferta().importarAulaLista(linha, coluna, aula);
            
        }else if(aula != null && isDropInterno()){  // ESTOU ARRASTANDO DA TABELA
            ctrlPrincipal.getGtPrincipal().getGtOferta().moverAulaMatriz(linha, coluna, aula);
            preencherTabelaAulas(jdOferta.getTblTurma());
        }   
    }
    
    public Aula identificarOrigem(){
        
        int indice = jdOferta.getLstAlocacoes().getSelectedIndex();
        
        if(indice >= 0 && !isDropInterno())
            return (Aula) jdOferta.gerarAula();
        else 
            return getAulaSelecionada();
    }
    
    public void removerAulaTabela(){     
        ctrlPrincipal.getGtPrincipal().getGtOferta().removerAula(getAulaSelecionada()); 
    }
    
    public void salvarOferta(int ano, int semestre, int tempoMaximo, int intervaloMinimo, JComboBox cbxTurma){
        
        jdOferta.limparNotificacoes();
        Turma turma = (Turma) cbxTurma.getSelectedItem();
        
        if(turma != null){
            
            String resposta = ctrlPrincipal.getGtPrincipal().getGtOferta().salvarOferta(ano, semestre, tempoMaximo, intervaloMinimo, turma);

            if(resposta.equals(Constantes.CADASTRADO)){
                CtrlMensagem.exibirMensagemSucesso(jdOferta, "Aulas inseridas com sucesso!");

            }else
                CtrlMensagem.exibirMensagemErro(jdOferta, resposta);
        }else
            CtrlMensagem.exibirMensagemErro(jdOferta, "Nenhuma turma selecionada.");
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
        
        for(int linha = 0; linha < Constantes.LINHA; linha++){
            
            for(int coluna = 0; coluna < Constantes.COLUNA; coluna++){
                
                Aula aula = (Aula) ctrlPrincipal.getGtPrincipal().getGtOferta().getAulaMatriz(linha, coluna);
                
                if(aula != null){
                    String mensagem = ctrlPrincipal.getGtPrincipal().getGtOferta().validarOferta(aula);
                    exibirNotificação(mensagem, linha, coluna);
                    pintarCelulaTabela(mensagem, linha, coluna, tabela);
                }
            }
        }  
    }
 
    public void exibirNotificação(String mensagem, int linha, int coluna){
        
        if(mensagem != null){
            String notificacao = mensagem.substring(2);
            jdOferta.exibirNotificacao("Linha " + linha + ", Coluna " + coluna + ": " + notificacao+"\n");
        }
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

    public Aula getAulaSelecionada() {
        return aulaSelecionada;
    }

    public void setAulaSelecionada(Aula aulaSelecionada) {
        this.aulaSelecionada = aulaSelecionada;
    }
}

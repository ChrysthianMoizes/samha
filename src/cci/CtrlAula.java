package cci;

import cdp.Alocacao;
import cdp.Aula;
import cdp.Turma;
import cgt.Constantes;
import cih.oferta.JDOferta;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTable;

public class CtrlAula {
    
    private CtrlPrincipal ctrlPrincipal;
    private boolean dropInterno = false;
    private Aula aulaSelecionada;
    private JDOferta jdOferta;
    
    public CtrlAula(CtrlPrincipal ctrl){
        this.ctrlPrincipal = ctrl;
    }
    
    public void identificarOrigem(int linha, int coluna){
        
        setJdOferta(ctrlPrincipal.getCtrlOferta().getJdOferta());

        jdOferta.validarOferta(true);
        
        int indice = jdOferta.getLstAlocacoes().getSelectedIndex();
        
        if(indice >= 0 && !isDropInterno())
            jdOferta.gerarAula();

        arrastarAula(linha, coluna, getAulaSelecionada());
        jdOferta.getTblTurma().setValueAt(getAulaSelecionada(), linha, coluna);

        setAulaSelecionada(null);
    }
    
    public void preencherTabelaAulas(JTable tblTurma){
 
        JTableUtil.limparCelulasTabela(tblTurma);
        Aula aula;
        
        for(int linha = 0; linha < Constantes.LINHA; linha++){
            
            for(int coluna = 0; coluna < Constantes.COLUNA; coluna++){
                aula = ctrlPrincipal.getGtPrincipal().getGtAula().getAulaMatriz(linha, coluna);
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
            Alocacao alocacao = (Alocacao) ctrlPrincipal.getCtrlOferta().getListaAlocacoes().get(indice);
            aula = ctrlPrincipal.getGtPrincipal().getGtAula().gerarNovaAula(alocacao, linha, turno, coluna);             
        }       
        setAulaSelecionada(aula);
    }
    
    public void arrastarAula(int linha, int coluna, Aula aula){
        
        if(aula != null && !isDropInterno())    // ARRASTAR DA LISTA         
            ctrlPrincipal.getGtPrincipal().getGtAula().importarAulaLista(linha, coluna, aula);  
        else if(aula != null && isDropInterno())  // ARRASTAR DA TABELA
            ctrlPrincipal.getGtPrincipal().getGtAula().moverAulaMatriz(linha, coluna, aula);  
        else
            CtrlMensagem.exibirMensagemErro(jdOferta, "Aula nula");
        
        preencherTabelaAulas(jdOferta.getTblTurma());
    }

    public void removerAula(JTable tblTurma){
        
        jdOferta.validarOferta(true);
        int coluna = tblTurma.getSelectedColumn();
        int linha = tblTurma.getSelectedRow();
        
        Aula aula = (Aula) tblTurma.getValueAt(linha, coluna);
        ctrlPrincipal.getGtPrincipal().getGtAula().removerAula(aula);
        tblTurma.setValueAt(null, linha, coluna);
        setAulaSelecionada(null);
        setDropInterno(false);
    }
    
    public void atualizarAulas(JComboBox cbxTurma){
        
        jdOferta.limparNotificacoes();
        Turma turma = (Turma) cbxTurma.getSelectedItem();       
        
        if(turma != null){
            
            String resposta = ctrlPrincipal.getGtPrincipal().getGtAula().atualizarAulas();

            if(resposta.equals(Constantes.CADASTRADO))
                CtrlMensagem.exibirMensagemSucesso(jdOferta, "Salvo com Sucesso!");
            else
                CtrlMensagem.exibirMensagemErro(jdOferta, resposta);
            
            jdOferta.atualizarTela();
        }else
            CtrlMensagem.exibirMensagemErro(jdOferta, "Nenhuma turma selecionada.");
        
        ctrlPrincipal.getCtrlOferta().zerarTabelaProfessor();
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

    public JDOferta getJdOferta() {
        return jdOferta;
    }

    public void setJdOferta(JDOferta jdOferta) {
        this.jdOferta = jdOferta;
    }
}

package cci;

import cdp.Alocacao;
import cdp.Aula;
import cdp.Curso;
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
        jdOferta.atualizarLista();
        
    }
    
    public void preencherListaAlocacoes(int ano, int semestre, JComboBox cbxTurma, JList lstAlocacoes){
        
        Turma turma = (Turma) cbxTurma.getSelectedItem();
        List listaAlocacoes = null;
        
        if(turma != null){
            
            listaAlocacoes = ctrlPrincipal.getGtPrincipal().getGtAlocacao().filtrarPorAnoSemestreMatriz(ano, semestre, turma.getMatriz().getId());
            jdOferta.setListaAlocacoes(listaAlocacoes);
            
            if(listaAlocacoes.isEmpty())
                jdOferta.setarMensagem("Nenhuma alocação encontrada.");
        }else
            jdOferta.setarMensagem("Nenhuma turma encontrada.");
        
        preencherJList(listaAlocacoes, lstAlocacoes);
    }
    
    public void gerarAula(JList lstAlocacoes, JTable tblTurma, List listaAlocacoes, JComboBox cbxTurno){
        
        int posicao = lstAlocacoes.getSelectedIndex();
        
        if(posicao >= 0){
            
            int coluna = tblTurma.getSelectedColumn();
            int linha = tblTurma.getSelectedRow();
            
            if((linha >= 0) && (coluna >= 0)){
                
                String dia = obterStringDia(linha);
                String turno = (String) cbxTurno.getSelectedItem();
                int numero = coluna;
                
                Alocacao alocacao = (Alocacao) listaAlocacoes.get(posicao);

                Aula aula = ctrlPrincipal.getGtPrincipal().getGtOferta().gerarAula(alocacao, dia, turno, numero);
                aula.setAlocacao(alocacao);

                tblTurma.setValueAt(aula, linha, coluna);
                
            }else
                jdOferta.setarMensagem("Selecione uma célula da tabela.");
        }
    }
    
    public String obterStringDia(int linha){
    
        switch(linha){
            
            case 0:
                return Constantes.SEGUNDA;
            case 1:
                return Constantes.TERCA;
            case 2:
                return Constantes.QUARTA;
            case 3:
                return Constantes.QUINTA;    
            default:
                return Constantes.SEXTA; 
        }  
    }

    public void alterarTurno(JComboBox cbxTurno, JTable tblTurma){
        
        String turno = (String) cbxTurno.getSelectedItem();
        
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
        
        for(int linha = 0; linha < 5; linha++){
            
            for(int coluna = 0; coluna < 6; coluna++){
                Aula aula = (Aula) tabela.getValueAt(linha, coluna);
                
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
            jdOferta.exibirNotificação("Linha " + linha + ", Coluna " + coluna + ": " + notificacao);
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
}

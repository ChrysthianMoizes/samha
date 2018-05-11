package cci;

import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JTableUtil {
    
    /**
     * Retorna o model do jTable convertido para (DefaultTableModel).
     * @param jTable
     * @return (DefaultTableModel) model
     */
    public static DefaultTableModel getModel(JTable jTable) {
        return ((DefaultTableModel) jTable.getModel());
    }
    
    /**
     * Obtem o indice da linha selecionada.
     * @param jTable
     * @return int
     */
    public static int getIndiceLinhaSelecionada(JTable jTable) {
        return jTable.getSelectedRow();
    }
    
    /**
     * Obtem os dados (Object) da linha selecionada.
     * @param jTable
     * @return Object
     * @throws Exception 
     */
    public static Object getDadosLinhaSelecionada(JTable jTable) throws Exception {
        int linhaSelecionada = jTable.getSelectedRow();
        int coluna = 0;
        if ( linhaSelecionada < 0 )
            throw new Exception("Nenhuma linha selecionada.");
        return getModel(jTable).getValueAt(linhaSelecionada, coluna);
    }
    
    /**
     * Converte os Object contidos nas linhas para uma lista.
     * @param jTable
     * @return List
     */
    public static List toList(JTable jTable) {
        int coluna = 0;
        List listaObjetos = new LinkedList();
        int qtdLinhas = jTable.getRowCount();
        for (int linha = 0; linha < qtdLinhas; linha++)
            listaObjetos.add(getModel(jTable).getValueAt(linha, coluna));
        return listaObjetos;
    }
    
    /**
     * Insere uma nova linha no final da jTable.
     * @param jTable
     * @param dadosLinha 
     */
    public static void addLinha(JTable jTable, Object[] dadosLinha) {
        getModel(jTable).addRow(dadosLinha);
    }
    
    /**
     * Remove a linha selecionada da jTable.
     * @param jTable
     */
    public static void removeLinhaSelecionada(JTable jTable) {
        if (getIndiceLinhaSelecionada(jTable) >= 0)
            getModel(jTable).removeRow(getIndiceLinhaSelecionada(jTable));
    }
    
    /**
     * Apaga todas as linhas da tabela.
     * @param jTable 
     */
    public static void removerLinhas(JTable jTable) {
        int qtdLinhas = jTable.getRowCount() - 1;
        for (int i = qtdLinhas; i >= 0; i--)
            getModel(jTable).removeRow(i);
    }
    
    /**
     * Limpa todas as celulas da tabela.
     * @param jTable 
     */
    public static void limparCelulasTabela(JTable jTable){
        
        int linhas = jTable.getRowCount();
        int colunas = jTable.getColumnCount();
        
        for(int linha = 0; linha < linhas; linha++){
            
            for(int coluna = 0; coluna < colunas; coluna++){
                jTable.setValueAt(null, linha, coluna);
            }  
        }
    }
    
    /**
     * Preenche a tabela com os dados da lista
     * @param jTable 
     */
    
    public static void preencherTabela(List lista, JTable tabela, String nomeMetodo) throws Exception{
     
        Method metodo;

        for(Object obj : lista){
            metodo = obj.getClass().getMethod(nomeMetodo, null);
            JTableUtil.addLinha(tabela, (Object[]) metodo.invoke(obj, null));  
        }            
    }
}

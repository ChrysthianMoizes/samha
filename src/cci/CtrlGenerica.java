package cci;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JTable;

public abstract class CtrlGenerica {
    
    public void preencherCombo(JComboBox combo, List lista){
        combo.setModel(new DefaultComboBoxModel(lista.toArray()));
    }
    
    public void listarEmTabela(List lista, JTable tabela, JDialog janela, String nomeMetodo){
        
        JTableUtil.removerLinhas(tabela);

        try {
            JTableUtil.preencherTabela(lista, tabela, nomeMetodo);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void preencherJList(List lista, JList lst){
        
        DefaultListModel defaultListModel = new DefaultListModel();
        lst.removeAll(); 
        if (lista != null) { 
            for (int i = 0; i < lista.size(); i++) {
                defaultListModel.addElement(lista.get(i));
            } 
        }
        lst.setModel(defaultListModel);
    }
}

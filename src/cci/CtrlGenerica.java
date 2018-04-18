package cci;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public abstract class CtrlGenerica {
    
    public void preencherCombo(JComboBox combo, List lista){
        combo.setModel(new DefaultComboBoxModel(lista.toArray()));
    }
}

package cci;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class RenderizadorCelulas extends DefaultTableCellRenderer{
    
    private Color cor = Color.BLACK;
    
    public RenderizadorCelulas() {
        super();
    }
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
            this.setHorizontalAlignment(CENTER);
            return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	}

//    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
//        
//        Component componente = super.prepareRenderer(renderer, row, column);
//        componente.setBackground(cor);
//        
//        cor = Color.WHITE;
//        
//        return componente;
//    }
//
//    public void setCor(Color cor) {
//        this.cor = cor;
//    }
}

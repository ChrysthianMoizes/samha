package cci;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class RenderizadorCelulas extends JTable{
    
    private Color cor = Color.BLACK;

    @Override
    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
        
        Component componente = super.prepareRenderer(renderer, row, column);
        componente.setBackground(cor);
        
        cor = Color.WHITE;
        
        return componente;
    }

    public void setCor(Color cor) {
        this.cor = cor;
    }
}

package cci;

import cgt.Constantes;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class RenderizadorCelulas extends DefaultTableCellRenderer{
    
    private CtrlPrincipal ctrlPrincipal;
    private int numeroTabela;
    private Color[][] cores;
    private int turno;
    
    public RenderizadorCelulas(CtrlPrincipal ctrl, int numeroTabela) {
        super();
        this.ctrlPrincipal = ctrl;
        this.numeroTabela = numeroTabela;
    }
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        
            this.setHorizontalAlignment(CENTER);
            
            if(numeroTabela == 1){
                
                Color cor = cores[row][column + turno];
                
                if(cor == null)
                    this.setBackground(Color.WHITE);
                else
                    this.setBackground(cor);
                       
            }else
                this.setBackground(Color.WHITE);
            
            return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	}

    public void gerarMatrizCores(){
        if(cores == null)
           cores = new Color[Constantes.LINHA][Constantes.COLUNA];
        else
            limparMatrizCores();     
    }
    
    public void limparMatrizCores(){

        for(int linha = 0; linha < Constantes.LINHA; linha++){
            for(int coluna = 0; coluna < Constantes.COLUNA; coluna++){
                setColorMatriz(linha, coluna, null);
            }
        }
    }
    
    public Color getColorMatriz(int linha, int coluna){
        return (Color) cores[linha][coluna];
    }
    
    public void setColorMatriz(int linha, int coluna, Color cor){
        cores[linha][coluna] = cor;    
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }
}

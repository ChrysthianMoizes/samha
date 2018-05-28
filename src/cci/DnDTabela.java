package cci;

import cdp.Aula;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.TransferHandler;

public class DnDTabela extends TransferHandler{
    
    private CtrlPrincipal ctrlPrincipal;

    public DnDTabela(CtrlPrincipal ctrl) {
        this.ctrlPrincipal = ctrl;
    } 
     
    @Override
    public int getSourceActions(JComponent c) {
        return DnDConstants.ACTION_COPY_OR_MOVE;
    }
     
    @Override
    public Transferable createTransferable(JComponent comp){
        
        JTable table=(JTable)comp;
        int row=table.getSelectedRow();
        int col=table.getSelectedColumn();
        
        Aula aula = (Aula)table.getModel().getValueAt(row,col);     
        
        ctrlPrincipal.getCtrlAula().setAulaSelecionada(aula);
        ctrlPrincipal.getCtrlAula().setDropInterno(true);
        
        StringSelection transferable = new StringSelection(aula.toString());
        return transferable;

    }
     
    @Override
    public boolean canImport(TransferHandler.TransferSupport info){
        return info.isDataFlavorSupported(DataFlavor.stringFlavor);
    }
     
    @Override
    public boolean importData(TransferSupport support) {
  
        if (!support.isDrop())
            return false;
        
        if (!canImport(support))
            return false;

        JTable.DropLocation dl = (JTable.DropLocation)support.getDropLocation();

        int row = dl.getRow();
        int col=dl.getColumn();
        
        ctrlPrincipal.getCtrlAula().identificarOrigem(row, col);
        ctrlPrincipal.getCtrlAula().setDropInterno(false);
        
        return true;
    }
}

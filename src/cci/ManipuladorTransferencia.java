package cci;

import cdp.Aula;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.io.IOException;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.TransferHandler;
import javax.swing.table.DefaultTableModel;

public class ManipuladorTransferencia extends TransferHandler{
     
    @Override
    public int getSourceActions(JComponent c) {
        return DnDConstants.ACTION_COPY_OR_MOVE;
    }
     
    @Override
    public Transferable createTransferable(JComponent comp){
        
        JTable table=(JTable)comp;
        int row=table.getSelectedRow();
        int col=table.getSelectedColumn();
        
        Object obj = (Object)table.getModel().getValueAt(row,col);
        
        StringSelection transferable = null;
        
        if(obj instanceof String)
            transferable = new StringSelection((String) obj);
        if(obj instanceof Aula)
            transferable = new StringSelection(obj.toString());
        
        table.getModel().setValueAt(null,row,col);
        
        return transferable;
    }
     
    @Override
    public boolean canImport(TransferHandler.TransferSupport info){
        if (!info.isDataFlavorSupported(DataFlavor.stringFlavor))
            return false;
        return true;
    }
     
    @Override
    public boolean importData(TransferSupport support) {
  
        if (!support.isDrop())
            return false;
        
        if (!canImport(support))
            return false;
        
        JTable table=(JTable)support.getComponent();
        DefaultTableModel tableModel=(DefaultTableModel)table.getModel();

       JTable.DropLocation dl = (JTable.DropLocation)support.getDropLocation();

        int row = dl.getRow();
        int col=dl.getColumn();

        String data;
        try {
            data = (String) support.getTransferable().getTransferData(DataFlavor.stringFlavor);
        } catch (UnsupportedFlavorException | IOException e) {
            return false;
        }

        tableModel.setValueAt(data, row, col);

        return true;
    }
}

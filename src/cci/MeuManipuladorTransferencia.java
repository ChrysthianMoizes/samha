package cci;

import java.awt.Image;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.TransferHandler;
import javax.swing.table.DefaultTableModel;

public class MeuManipuladorTransferencia extends TransferHandler{
    
    private JTable data;
    public MeuManipuladorTransferencia(){
    }
     
    public void setTable(JTable tab){
        data = tab;
    }
     
    @Override
    public int getSourceActions(JComponent c) {
        return COPY_OR_MOVE;
    }
     
    @Override
    public Transferable createTransferable(JComponent c)
    {
        JList list = (JList)c;
        if(list.getSelectedValue() instanceof Image)
        {
            return new ImageSelection((Image)list.getSelectedValue());
        }
        else if(list.getSelectedValue() instanceof String)
        {
            return new StringSelection((String)list.getSelectedValue());
        } 
        return null;
    }
     
    @Override
    public void exportDone(JComponent c, Transferable t, int action){
    } 
     
    @Override
    public boolean canImport(TransferHandler.TransferSupport ts){
        if(ts.isDataFlavorSupported(DataFlavor.imageFlavor))
            return true;
        return ts.isDataFlavorSupported(DataFlavor.stringFlavor);
    }
     
    @Override
    public boolean importData(TransferHandler.TransferSupport ts){
        
        JTable.DropLocation drop = (JTable.DropLocation)ts.getDropLocation();
         
        DefaultTableModel let = (DefaultTableModel)data.getModel();
         
        try{
            if(ts.getTransferable().isDataFlavorSupported(DataFlavor.stringFlavor)){
                let.setValueAt(ts.getTransferable().getTransferData(DataFlavor.stringFlavor), drop.getRow(), drop.getColumn());
            
            }else if(ts.getTransferable().isDataFlavorSupported(DataFlavor.imageFlavor)){
                let.setValueAt(ts.getTransferable().getTransferData(DataFlavor.imageFlavor), drop.getRow(), drop.getColumn());
            }
        }
        catch (UnsupportedFlavorException | IOException e){
            return false;
        }  
        return true;
    }
 
    private class ImageSelection implements Transferable
    {
        private Image data = null;
         
        public ImageSelection(Image i)
        {
            data = i;
        }
         
        @Override
        public Object getTransferData(DataFlavor d) throws UnsupportedFlavorException, IOException 
        {
            return data;
        }
 
        @Override
        public DataFlavor[] getTransferDataFlavors() 
        {
            DataFlavor[] r = {DataFlavor.imageFlavor}; 
            return r;
        }
 
        @Override
        public boolean isDataFlavorSupported(DataFlavor d) 
        {
            return d.equals(DataFlavor.imageFlavor);
        }
         
    }
}

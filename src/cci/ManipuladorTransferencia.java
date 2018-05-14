package cci;

import cdp.Aula;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.TransferHandler;
import javax.swing.table.DefaultTableModel;

public class ManipuladorTransferencia extends TransferHandler{
    
    private CtrlPrincipal ctrlPrincipal;

    public ManipuladorTransferencia(CtrlPrincipal ctrl) {
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
        
        Object obj = (Object)table.getModel().getValueAt(row,col);
        
        StringSelection transferable = new StringSelection(obj.toString());
        
        ctrlPrincipal.getCtrlOferta().setAulaSelecionada((Aula) obj);
        ctrlPrincipal.getCtrlOferta().setDropInterno(true);
        ctrlPrincipal.getCtrlOferta().removerAulaTabela();
        table.getModel().setValueAt(null,row,col);
        
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
        
        JTable table=(JTable)support.getComponent();
        DefaultTableModel tableModel=(DefaultTableModel)table.getModel();

       JTable.DropLocation dl = (JTable.DropLocation)support.getDropLocation();

        int row = dl.getRow();
        int col=dl.getColumn();
        
        Aula aula = ctrlPrincipal.getCtrlOferta().identificarOrigem();
        ctrlPrincipal.getCtrlOferta().importarAulaLista(row, col, aula);

        tableModel.setValueAt(aula, row, col);
        ctrlPrincipal.getCtrlOferta().setDropInterno(false);
        return true;
    }
}

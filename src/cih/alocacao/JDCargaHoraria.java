package cih.alocacao;

import cci.CtrlPrincipal;
import java.awt.Frame;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class JDCargaHoraria extends javax.swing.JDialog {
    
    private CtrlPrincipal ctrlPrincipal;
    private Frame pai;
    
    public JDCargaHoraria(java.awt.Frame parent, boolean modal, CtrlPrincipal ctrl) {
        super(parent, modal);
        initComponents();
        this.pai = parent;
        this.ctrlPrincipal = ctrl;
        this.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
        this.setModalityType(ModalityType.MODELESS);
        tblCargaHoraria.setBackground(ctrlPrincipal.setarCorPanelInterior());
        alterarLarguraTabela();
    }

    public void alterarLarguraTabela(){
        tblCargaHoraria.getColumnModel().getColumn(0).setPreferredWidth(250);
        tblCargaHoraria.getColumnModel().getColumn(1).setPreferredWidth(10);
    }
    
    public void atualizarTabela(){
        ctrlPrincipal.getCtrlAlocacao().listarCargaHorariaProfessores(tblCargaHoraria);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tblCargaHoraria = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Carga Horária - Professores");
        setMinimumSize(new java.awt.Dimension(50, 50));
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        setPreferredSize(new java.awt.Dimension(452, 500));

        tblCargaHoraria.setBackground(new java.awt.Color(240, 240, 240));
        tblCargaHoraria.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        tblCargaHoraria.setFont(new java.awt.Font("DialogInput", 0, 16)); // NOI18N
        tblCargaHoraria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Carga Horária"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCargaHoraria.setRowHeight(25);
        tblCargaHoraria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCargaHorariaMouseClicked(evt);
            }
        });
        ((DefaultTableCellRenderer)tblCargaHoraria.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        jScrollPane2.setViewportView(tblCargaHoraria);

        getContentPane().add(jScrollPane2, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tblCargaHorariaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCargaHorariaMouseClicked
       if(evt.getClickCount() == 2){
            ctrlPrincipal.getCtrlAlocacao().listarAlocacoesProfessor(pai, tblCargaHoraria);
        }
    }//GEN-LAST:event_tblCargaHorariaMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblCargaHoraria;
    // End of variables declaration//GEN-END:variables
}

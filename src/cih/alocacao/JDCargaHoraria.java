package cih.alocacao;

import cci.CtrlPrincipal;

public class JDCargaHoraria extends javax.swing.JDialog {
    
    private CtrlPrincipal ctrlPrincipal;

    public JDCargaHoraria(java.awt.Frame parent, boolean modal, CtrlPrincipal ctrl) {
        super(parent, modal);
        initComponents();
        this.ctrlPrincipal = ctrl;
        this.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
        this.setModalityType(ModalityType.MODELESS);
        alterarLarguraTabela();
    }

    public void alterarLarguraTabela(){
        tblCargaHoraria.getColumnModel().getColumn(0).setPreferredWidth(10);
        tblCargaHoraria.getColumnModel().getColumn(1).setPreferredWidth(10);
        tblCargaHoraria.getColumnModel().getColumn(2).setPreferredWidth(10);
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
        setTitle("Professores");
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        setPreferredSize(new java.awt.Dimension(452, 250));

        tblCargaHoraria.setBackground(new java.awt.Color(0, 153, 102));
        tblCargaHoraria.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        tblCargaHoraria.setFont(new java.awt.Font("DialogInput", 0, 18)); // NOI18N
        tblCargaHoraria.setForeground(new java.awt.Color(255, 255, 255));
        tblCargaHoraria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Matrícula", "Carga Horária"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCargaHoraria.setRowHeight(25);
        jScrollPane2.setViewportView(tblCargaHoraria);

        getContentPane().add(jScrollPane2, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblCargaHoraria;
    // End of variables declaration//GEN-END:variables
}

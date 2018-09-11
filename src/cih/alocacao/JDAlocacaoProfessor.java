package cih.alocacao;

import cci.CtrlPrincipal;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class JDAlocacaoProfessor extends javax.swing.JDialog {
    
    private CtrlPrincipal ctrlPrincipal;

    public JDAlocacaoProfessor(java.awt.Frame parent, boolean modal, CtrlPrincipal ctrl) {
        super(parent, modal);
        initComponents();
        this.ctrlPrincipal = ctrl;
        tblAlocacoes.setBackground(ctrlPrincipal.setarCorPanelInterior());
        alterarLarguraTabela();
    }

    public void alterarLarguraTabela(){
        tblAlocacoes.getColumnModel().getColumn(0).setPreferredWidth(250);
        tblAlocacoes.getColumnModel().getColumn(1).setPreferredWidth(5);
        tblAlocacoes.getColumnModel().getColumn(2).setPreferredWidth(5);
        tblAlocacoes.getColumnModel().getColumn(3).setPreferredWidth(5);
        tblAlocacoes.getColumnModel().getColumn(4).setPreferredWidth(100);
        tblAlocacoes.getColumnModel().getColumn(5).setPreferredWidth(10);
        tblAlocacoes.getColumnModel().getColumn(6).setPreferredWidth(10);
    }
   
    public JTable getTableAlocacoes(){
        return tblAlocacoes;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tblAlocacoes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Carga Horária - Professores");
        setMinimumSize(new java.awt.Dimension(350, 50));
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        setPreferredSize(new java.awt.Dimension(800, 200));

        tblAlocacoes.setBackground(new java.awt.Color(240, 240, 240));
        tblAlocacoes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        tblAlocacoes.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        tblAlocacoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Disciplina", "Turma", "Sigla", "Período", "Curso", "Qt. Aulas", "Completa"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ((DefaultTableCellRenderer)tblAlocacoes.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        jScrollPane2.setViewportView(tblAlocacoes);

        getContentPane().add(jScrollPane2, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblAlocacoes;
    // End of variables declaration//GEN-END:variables
}

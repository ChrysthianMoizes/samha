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
        setarBackground();
    }
    
    private void setarBackground(){
        pnlDireita.setBackground(ctrlPrincipal.setarCorPanelExterior());
        pnlEsquerda.setBackground(ctrlPrincipal.setarCorPanelExterior());
        pnlInferior.setBackground(ctrlPrincipal.setarCorPanelExterior());
        pnlSuperior.setBackground(ctrlPrincipal.setarCorPanelExterior());
    }
    
    public void atualizarTabela(){
        ctrlPrincipal.getCtrlAlocacao().listarCargaHorariaProfessores(tblCargaHoraria);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPrincipal = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCargaHoraria = new javax.swing.JTable();
        pnlInferior = new javax.swing.JPanel();
        pnlDireita = new javax.swing.JPanel();
        pnlSuperior = new javax.swing.JPanel();
        pnlEsquerda = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Carga Horária dos Professores");
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);

        pnlPrincipal.setLayout(new java.awt.BorderLayout());

        tblCargaHoraria.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
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
        jScrollPane2.setViewportView(tblCargaHoraria);

        pnlPrincipal.add(jScrollPane2, java.awt.BorderLayout.CENTER);
        pnlPrincipal.add(pnlInferior, java.awt.BorderLayout.PAGE_END);
        pnlPrincipal.add(pnlDireita, java.awt.BorderLayout.LINE_END);
        pnlPrincipal.add(pnlSuperior, java.awt.BorderLayout.PAGE_START);
        pnlPrincipal.add(pnlEsquerda, java.awt.BorderLayout.LINE_START);

        getContentPane().add(pnlPrincipal, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel pnlDireita;
    private javax.swing.JPanel pnlEsquerda;
    private javax.swing.JPanel pnlInferior;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JPanel pnlSuperior;
    private javax.swing.JTable tblCargaHoraria;
    // End of variables declaration//GEN-END:variables
}

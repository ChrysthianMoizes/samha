package cih.principal;

import cci.CtrlPrincipal;
import cdp.Coordenador;
import java.awt.Frame;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;

public class FrmInicio extends javax.swing.JFrame {

    private CtrlPrincipal ctrlPrincipal;
    
    public FrmInicio(CtrlPrincipal ctrlPrincipal){
        this.ctrlPrincipal = ctrlPrincipal;
        initComponents();
        atualizarInfoSistema();
        ImageIcon icone = ctrlPrincipal.setarIconeJanela();
        setIconImage(icone.getImage());
        this.setExtendedState(Frame.MAXIMIZED_BOTH);
    } 
    
    private void atualizarInfoSistema(){
        Coordenador coord = ctrlPrincipal.getGtPrincipal().getCoordAtual();
        Date dataAtual = Calendar.getInstance().getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String data = formatter.format(dataAtual);
        if(coord != null){
            //lblNomeCoordenador.setText(coord.getNome());
            //lblDataAtual.setText(data);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

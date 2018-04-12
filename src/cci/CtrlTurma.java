package cci;

import cdp.Turma;
import cgt.GtTurma;
import cih.turma.JDBuscarTurma;
import cih.turma.JDCadastrarTurma;
import java.awt.Frame;
import javax.swing.ImageIcon;

public class CtrlTurma {
    
    private CtrlPrincipal ctrlPrincipal;
    private GtTurma gtTurma;
    private JDBuscarTurma buscaTurma;
    private JDCadastrarTurma cadastraTurma;

    public CtrlTurma(CtrlPrincipal ctrl) {
        this.ctrlPrincipal = ctrl;
        gtTurma = new GtTurma();
    }
    
    public ImageIcon setarIconeJanela() {
        ImageIcon icone = new ImageIcon("build/classes/cih/img/turma.png");
        return icone;
    }
    
    public void instanciarTelaBuscaTurma(Frame pai) {
        buscaTurma = new JDBuscarTurma(pai, true, ctrlPrincipal);
        buscaTurma.setVisible(true);
    }

    public void instanciarTelaCadastroTurma(Turma turma, Frame pai) {
        cadastraTurma = new JDCadastrarTurma(pai, true, ctrlPrincipal, turma);
        cadastraTurma.setVisible(true);
    }
    
}

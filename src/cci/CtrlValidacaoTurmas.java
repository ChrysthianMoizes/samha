package cci;

import cdp.Turma;
import cih.oferta.JDOferta;
import java.util.List;

public class CtrlValidacaoTurmas {
    
    private CtrlPrincipal ctrlPrincipal;
    private JDOferta telaOferta;
    
    public CtrlValidacaoTurmas(CtrlPrincipal ctrl){
        this.ctrlPrincipal = ctrl;
    }
    
    public void confirmarValidacaoTurmas(int ano, int semestre){
        
        setTelaOferta(ctrlPrincipal.getCtrlOferta().getJdOferta());
        
        if(ctrlPrincipal.getCtrlAula().isTemAlteracoes()){
            
            String mensagem = "Você tem aulas que precisam ser salvas antes de realizar este processo.";
            CtrlMensagem.exibirMensagemAviso(telaOferta, mensagem);
            
        }else{
            
            String mensagem = "Este processo pode demorar algum tempo.\nTem certeza que deseja iniciar esta validação ?";
            int confirmacao = CtrlMensagem.exibirMensagemConfirmacao(telaOferta, mensagem);

            if (confirmacao == 0)
                validarTurmas(ano, semestre);  
        }
    }
    
    public void validarTurmas(int ano, int semestre){
        
        List listaTumas = identificarTurmasAtivas(ano, semestre);
        
        
        
    }
    
    public List identificarTurmasAtivas(int ano, int semestre){
        
        List<Turma>listaTumas = ctrlPrincipal.getCtrlTurma().listar();
        
        boolean estahAtiva = true;
        
        for(Turma turma : listaTumas){
            estahAtiva = calcularTempoCurso(turma, ano, semestre);
            if(!estahAtiva)
                listaTumas.remove(turma);
        }
        return listaTumas;
    }
    
    public boolean calcularTempoCurso(Turma turma, int anoAtual, int semestreAtual){
        
        if(turma.getMatriz().getCurso().getNivel().equals("ENSINO MEDIO")){
            
            return false;
            
        }else{
        
        
            int qtPeriodos = turma.getMatriz().getCurso().getQtPeriodos();

            int anoTurma = turma.getAno();
            int semestreTurma = turma.getSemestre();

            int resto = qtPeriodos % 2;
            int qtAnos = qtPeriodos / 2;

            anoTurma = anoTurma + qtAnos - 1;

            if(resto != 0){
                if(semestreTurma == 1)
                    semestreTurma++;
                else{
                    semestreTurma--;
                    anoTurma++;
                }    
            }

            if(anoAtual > anoTurma){
                return true;
            }else if(anoAtual == anoTurma){

                if(semestreAtual >= semestreTurma){
                    return true; 
                }else
                    return false;
            }
            return false;
        
        }
    }
    
    public void setTelaOferta(JDOferta telaOferta) {
        this.telaOferta = telaOferta;
    }
}

package cci;

import cdp.Aula;
import cdp.Turma;
import cih.oferta.JDOferta;
import java.awt.Color;
import java.util.ArrayList;
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
            
            String mensagem = "Este processo pode demorar algum tempo.\nDeseja iniciar esta validação ?";
            int confirmacao = CtrlMensagem.exibirMensagemConfirmacao(telaOferta, mensagem);

            if (confirmacao == 0)
                validarTurmas(ano, semestre);  
        }
    }
    
    public void validarTurmas(int ano, int semestre){
        
        new Thread() {
            @Override
            public void run() {
                
                telaOferta.validandoTurmas();
                
                List listaTurmas = ctrlPrincipal.getCtrlTurma().listar();
                telaOferta.limparNotificacoes();

                Turma turma;
                List listaAulas;

                ctrlPrincipal.getGtPrincipal().getGtInstituicao().setValidacaoGeral(true);

                List mensagens = new ArrayList<>();
                
                for(int i = 0; i < listaTurmas.size(); i++){
                    turma = (Turma) listaTurmas.get(i);
                    listaAulas = ctrlPrincipal.getCtrlAula().filtrarAulasTurmaAnoSemestre(turma.getId());
                    if(!listaAulas.isEmpty())
                        mensagens.addAll(identificarConflitos(turma, listaAulas));
                }

                ctrlPrincipal.getGtPrincipal().getGtInstituicao().setValidacaoGeral(false);
                
                if(mensagens.isEmpty()){
                    telaOferta.limparNotificacoes();
                    telaOferta.exibirNotificacao("Nenhum conflito encontrado!\n\n", ctrlPrincipal.setarCorPanelExterior()); 
                }
                
                telaOferta.turmasValidadas();
            }
        }.start();
 
    }
    
    public List identificarConflitos(Turma turma, List listaAulas){
        
        List mensagens = new ArrayList<>();
        
        Aula aula;
        
        for(int i = 0; i < listaAulas.size(); i++){
            aula = (Aula) listaAulas.get(i);
            List msg = ctrlPrincipal.getGtPrincipal().getGtConflito().validarAula(aula);
            exibirMensagens(msg, aula, turma);
            mensagens.addAll(msg);
        }
        return mensagens;
    }
    
    public void exibirMensagens(List mensagens, Aula aula, Turma turma){
        
        int numero = aula.getNumero() + 1;
        String dia = ctrlPrincipal.getGtPrincipal().getGtInstituicao().obterStringDia(aula.getDia());
        
        String mensagem;
        if(!mensagens.isEmpty()){
            
            telaOferta.exibirNotificacao("\n =========== " + turma.getNome() + " ==========" + "\n", Color.RED);
            
            for(int i = 0; i < mensagens.size(); i++){
                
                mensagem = (String) mensagens.get(i);
                mensagem = identificarTipoMensagem(mensagem, aula);
                
                setarMensagem(dia, numero, mensagem);
            }
        }  
    }
    
    public String identificarTipoMensagem(String mensagem, Aula aula){
       
        char c = mensagem.charAt(0);
        int codigo = c - 48;
        
        String notificacao;
        
        switch (codigo) {
            case 0:
                    notificacao = mensagem.substring(2);
                    return notificacao;
            case 1:
                    notificacao = mensagem.substring(2);
                    return notificacao;  
            default:
                return mensagem;
        }
    }
    
    public void setarMensagem(String dia, int numero, String mensagem){  
        telaOferta.exibirNotificacao(dia + ": Aula " + numero + ".\n" + mensagem +"\n\n", Color.RED);
    }

    public void setTelaOferta(JDOferta telaOferta) {
        this.telaOferta = telaOferta;
    }
}

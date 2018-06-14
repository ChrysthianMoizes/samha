package cci;

import cdp.Coordenadoria;
import cdp.Eixo;
import cdp.Professor;
import cih.relatorio.JDRelatorioProfessor;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import javax.swing.JComboBox;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRRuntimeException;

public class CtrlEmail {
    
    private CtrlPrincipal ctrlPrincipal;
    
    public CtrlEmail(CtrlPrincipal ctrl){
        ctrlPrincipal = ctrl;
    }
    
    public void identificarProfessoresEnvioEmail(JComboBox cbxEixo, JComboBox cbxCoordenadoria, JComboBox cbxProfessor, int ano, int semestre, char tipo, JDRelatorioProfessor janela){
        
        Eixo eixo = (Eixo) cbxEixo.getSelectedItem();
        Coordenadoria coordenadoria = (Coordenadoria) cbxCoordenadoria.getSelectedItem();
        Professor professor = (Professor) cbxProfessor.getSelectedItem();
        
        List professores = ctrlPrincipal.getCtrlRelatorioProfessor().obterListaProfessores(eixo, coordenadoria, professor, tipo);
        confirmarEnvioEmail(janela, professores, ano, semestre);
    }
    
    public void confirmarEnvioEmail(JDRelatorioProfessor janela, List professores, int ano, int semestre){
        
        int resposta = CtrlMensagem.exibirMensagemConfirmacao(janela, obterMensagemEnvioEmail());
        
        if(resposta == 0){
            String senha = CtrlMensagem.exibirEntradaSenhaEmail(janela);
            if(!senha.equals(""))
                iniciarThreadEnviarEmail(janela, professores, ano, semestre, senha);
            else
                CtrlMensagem.exibirMensagemErro(janela, "Senha inválida.");  
        }  
    }
    
    public String obterMensagemEnvioEmail(){
        
        String mensagem = "\u2022 O envio de email gera novamente os relatórios\n"
                        + "  dos professores do Filtro selecionado.\n"
                        + "\u2022 Só serão enviados emails para os professores\n"
                        + "  que possuirem um email válido.\n"
                        + "\u2022 Os e-mails serão enviados a partir do email cadastrado\n"
                        + "  para o coordenador atualmente logado no sistema.\n\n"
                        + "\t\t Deseja continuar ?";
        
        return mensagem;
    }
    
    public void iniciarThreadEnviarEmail(JDRelatorioProfessor janela, List<Professor> professores, int ano, int semestre, String senha){
        
        new Thread() {
            @Override
            public void run() {
                
                try {
                    
                    janela.gerandoRelatorio();
                   
                    for(Professor prof : professores){
                        ctrlPrincipal.getCtrlRelatorioProfessor().gerarRelatorioProfessor(prof, ano, semestre);
                    }
                    
                    janela.relatorioGerado();
                    
                    enviarEmail(professores, ano, semestre, janela, senha);

                } catch (JRException ex) {
                    janela.relatorioGerado();
                    CtrlMensagem.exibirMensagemErro(janela, "Erro ao gerar Relatório: " + ex.getMessage());

                } catch (FileNotFoundException | JRRuntimeException e){
                    janela.relatorioGerado();
                    CtrlMensagem.exibirMensagemAviso(janela, "Feche todos os relatórios de Professores antes de iniciar.");  
                }
            }
        }.start();
    }
    
    public void enviarEmail(List<Professor> professores, int ano, int semestre, JDRelatorioProfessor janela, String senha){
        
        new Thread() {
            @Override
            public void run() { 
                janela.enviandoEmails();
                for(Professor prof : professores){
                    File relatorio = obterRelatorioProfessor(prof, ano, semestre);
                    ctrlPrincipal.getGtPrincipal().getGtEmail().enviarEmailProfessor(prof, relatorio, senha);
                }
                janela.emailEnviado();
                //CtrlMensagem.exibirMensagemSucesso(janela, "E-mail(s) enviado(s) com Sucesso!");
            }
        }.start();   
    }
    
    public File obterRelatorioProfessor(Professor professor, int ano, int semestre){
        
        String diretorio = ctrlPrincipal.getCtrlRelatorio().obterDiretorioArquivamento("Professores", ano, semestre);
        String nomeArquivo = professor.getNome() + "-" + ano + "-" + semestre + ".pdf";
        
        File arquivo = new File(diretorio + nomeArquivo);
        return arquivo;
    }
}

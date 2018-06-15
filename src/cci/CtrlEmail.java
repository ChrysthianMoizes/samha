package cci;

import cdp.Coordenadoria;
import cdp.Eixo;
import cdp.Professor;
import cih.relatorio.JDRelatorioProfessor;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.util.List;
import javax.mail.MessagingException;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
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
            String senha = obterSenhaCoordenador(janela);
            if(!senha.isEmpty())
                iniciarThreadEnviarEmail(janela, professores, ano, semestre, senha);
            else
                CtrlMensagem.exibirMensagemErro(janela, "Senha muito curta. Tente novamente.");  
        }  
    }
    
    public String obterSenhaCoordenador(JDRelatorioProfessor janela){
        
        JPasswordField password = new JPasswordField(10);
	password.setEchoChar('*');
        
        JLabel rotulo = new JLabel("Informe sua senha:");
        rotulo.setFont(new Font("DialogInput", 0, 14));
        
        JPanel entUsuario = new JPanel();
        entUsuario.add(rotulo);
        entUsuario.add(password);
        
        CtrlMensagem.exibirEntradaSenhaEmail(janela, entUsuario);
        
        String senha = password.getText();
        return senha;
    }
    
    public String obterMensagemEnvioEmail(){
        
        String mensagem = "\u2022 O envio de e-mail gera novamente os relatórios\n"
                        + "  dos professores do Filtro selecionado.\n"
                        + "\u2022 Certifique-se de que os professores selecionados\n"
                        + "  possuem um email válido. Caso contrário, estes professores\n"
                        + "  não receberão e-mail."
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
                
                boolean sucesso = true;
                for(Professor prof : professores){
                    String relatorio = obterNomeRelatorioProfessor(prof, ano, semestre);
                    
                    try {
                        ctrlPrincipal.getGtPrincipal().getGtEmail().enviarEmailProfessor(prof, relatorio, senha, ano, semestre);
                        
                    } catch (MessagingException ex) {
                        CtrlMensagem.exibirMensagemErro(janela, "Erro ao enviar: E-mail ou senha podem estar incorretos.");
                        sucesso = false;
                        break;
                        
                    }
                }
                janela.emailEnviado();
                if(sucesso)
                    CtrlMensagem.exibirMensagemSucesso(janela, "E-mail(s) enviado(s) com Sucesso!");
            }
        }.start();   
    }
    
    public String obterNomeRelatorioProfessor(Professor professor, int ano, int semestre){
        
        String diretorio = ctrlPrincipal.getCtrlRelatorio().obterDiretorioArquivamento("Professores", ano, semestre);
        String nomeArquivo = professor.getNome() + "-" + ano + "-" + semestre + ".pdf";

        return diretorio + nomeArquivo;
    }
}

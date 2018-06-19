package cgt;

import cdp.Professor;
import cgt.services.WebServiceEmail;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public class GtEmail {
    
    private GtPrincipal gtPrincipal;
    
    public GtEmail(GtPrincipal gt){
        gtPrincipal = gt;
    }
    
    public void enviarEmailProfessor(Professor professor, String arquivo, String senha, int ano, int semestre) throws MessagingException, AddressException{
        
        String emailCoordenador = gtPrincipal.getGtCoordenador().obterEmailCoordenadorAtual();
        String matriculaCoordenador = gtPrincipal.getGtCoordenador().obterMatriculaCoordenadorAtual();
        String emailProfessor = professor.getEmail();
        
        String titulo = "Horários de aula " + ano + "/" + semestre;
        String mensagem = "Olá " + professor.getPrimeiroNome() + "!\n\n"
                + "Segue em anexo seus horários de aulas de " + ano + "/" + semestre + ":";
        
        String host = identificarHost(emailCoordenador);
        String remetente = identificarRemetente(emailCoordenador, matriculaCoordenador);
        
        if(emailProfessor != null){
            new WebServiceEmail(remetente, host, senha, emailProfessor, titulo, mensagem, arquivo);
        } 
    }
    
    public String identificarRemetente(String emailRemetente, String matriculaRemetente){
        
        String[] substring = emailRemetente.split("@", 2);
        char host = substring[1].charAt(0);

        switch (host) {

            case 'i':
                return matriculaRemetente;
            default:
                return emailRemetente;
        }
    }
    
    public String identificarHost(String remetente){
        
        String[] substring = remetente.split("@", 2);
        char host = substring[1].charAt(0);
        
        switch (host) {
            
            case 'g':
                return "smtp.gmail.com";
 
            case 'h':
                return "smtp.live.com";
                
            case 'i':
                return "smtp.ifes.edu.br";

            default:
                return "smtp.gmail.com";
        }
    }  
}

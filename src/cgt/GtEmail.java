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
        String emailProfessor = professor.getEmail();
        
        String titulo = "Horários de aula " + ano + "/" + semestre;
        String mensagem = "Olá " + professor.getPrimeiroNome() + "!\n\n"
                + "Segue em anexo seus horários de aulas de " + ano + "/" + semestre + ":";
        
        if(emailProfessor != null){
            new WebServiceEmail(emailCoordenador, senha, emailProfessor, titulo, mensagem, arquivo);
        } 
    }
    
}

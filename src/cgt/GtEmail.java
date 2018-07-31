package cgt;

import cdp.Aula;
import cdp.Disciplina;
import cdp.Professor;
import cgt.services.WebServiceEmail;
import java.util.ArrayList;
import java.util.List;
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
        String mensagem = montarMensagemEmail(professor, ano, semestre);
        
        String host = identificarHost(emailCoordenador);
        String remetente = identificarRemetente(emailCoordenador, matriculaCoordenador);
        
        if(emailProfessor != null){
            new WebServiceEmail(remetente, host, emailCoordenador, senha, emailProfessor, titulo, mensagem, arquivo);
        } 
    }
    
    public String montarMensagemEmail(Professor professor, int ano, int semestre){
        
        String mensagem = "\nOlá " + professor.getPrimeiroNome() + "!\n"
            + "Segue em anexo o arquivo contendo seus horários de aulas para o semestre de " + ano + "/" + semestre + ".\n\n"
            + "Você trabalhará as seguintes disciplinas:\n\n";
        
        List<Aula> aulas = gtPrincipal.getGtAula().filtrarAulasProfessorLista(professor.getId());
        List<Disciplina> disciplinas = new ArrayList<>();
        
        for(Aula aula : aulas){
            if(!disciplinas.contains(aula.getAlocacao().getDisciplina())){
                mensagem = mensagem + "=> " + aula.getOferta().getTurma().getNome() + ": "
                        + aula.getAlocacao().getDisciplina().getSigla() + " - " + aula.getAlocacao().getDisciplina().getNome() + ".\n";
                disciplinas.add(aula.getAlocacao().getDisciplina());
            }
        }
        
        mensagem = mensagem + "\nQualquer dúvida procure seu coordenador de curso.\n\n"
                + "Atenciosamente,";
        
        return mensagem;
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

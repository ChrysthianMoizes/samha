package cgt.services;

import java.util.*;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;

public class WebServiceEmail {

    public WebServiceEmail(String remetente, String host, String email, String senha, String dest, String titulo, String mensagem, String anexo) throws AddressException, MessagingException {

        String[] destinatario = { dest };
        enviarEmail(remetente, host, email, senha, destinatario, titulo, mensagem, anexo);
    }

    private void enviarEmail(String remetente, String host, String email, String senha, String[] destinatario, String titulo ,String mensagem, String anexo) throws AddressException, MessagingException {
        
        Properties props = obterPropriedades(remetente, host, senha);

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            
            message.setFrom(new InternetAddress(email));
            InternetAddress[] toAddress = new InternetAddress[destinatario.length];

            for( int i = 0; i < destinatario.length; i++ ) {
                toAddress[i] = new InternetAddress(destinatario[i]);
            }

            for( int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }

            message.setSubject(titulo);
            message.setText(mensagem);
            
            DataSource fds = new FileDataSource(anexo);
            MimeBodyPart mbp = new MimeBodyPart();
            
            mbp.setDisposition(Part.ATTACHMENT);
            mbp.setDataHandler(new DataHandler(fds));
            mbp.setFileName(fds.getName());

            Multipart mp = new MimeMultipart();   
            mp.addBodyPart(mbp);
            message.setContent(mp);
            
            Transport transport = session.getTransport("smtp");
            transport.connect(props.getProperty("mail.smtp.host"), props.getProperty("mail.smtp.user"), senha);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (AddressException ae) {
            throw ae;
        }
        catch (MessagingException me) {
            throw me;
        }
    }
    
    private static Properties obterPropriedades(String remetente, String host, String senha) {
        
        Properties p = System.getProperties();		
        p.put("mail.transport.protocol", "smtp");
        p.put("mail.smtp.starttls.enable","true");
        p.put("mail.smtp.auth", "true");
        p.put("mail.smtp.port", "587");
        p.put("mail.smtp.user", remetente);
        p.put("mail.smtp.password", senha);
        p.put("mail.smtp.host", host);
    
        return p;
    }
}

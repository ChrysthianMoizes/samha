package cgt.services;

import java.io.File;
import java.util.*;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;

public class WebServiceEmail {

    public WebServiceEmail(String remetente, String host, String email, String senha, String destinatario, String titulo, String mensagem, String anexo) throws AddressException, MessagingException {
        enviarEmail(remetente, host, email, senha, destinatario, titulo, mensagem, anexo);
    }

    private void enviarEmail(String remetente, String host, String email, String senha, String destinatario, String titulo ,String mensagem, String anexo) throws AddressException, MessagingException {
        
        try {
            
            Properties props = obterPropriedades(remetente, host, senha);
            Session session = Session.getDefaultInstance(props);
            
            MimeMessage message = new MimeMessage(session);
            
            message.setFrom(new InternetAddress(email));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            
            Multipart mp = new MimeMultipart();
            
            MimeBodyPart mbp = new MimeBodyPart();
            mbp.setText(mensagem);
            
            mp.addBodyPart(mbp);
            
            MimeBodyPart mbpAnexo = new MimeBodyPart();
            File arquivo = new File(anexo);
            mbpAnexo.setDataHandler(new DataHandler(new FileDataSource(arquivo)));
            mbpAnexo.setFileName(arquivo.getName());
            
            mp.addBodyPart(mbpAnexo);

            message.setSubject(titulo);
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

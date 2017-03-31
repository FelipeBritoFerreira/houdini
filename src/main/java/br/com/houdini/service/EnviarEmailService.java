package br.com.houdini.service;

import br.com.houdini.beans.Email;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by FBF0113 on 09/02/2017.
 */
@Component
public class EnviarEmailService {


    @Value("${email.destinatario}")
    private String destinatarios;

    @Value("${email.sender}")
    private String sender;

    @Value("${email.sender.titulo}")
    private String senderTitulo;


    private Log log = LogFactory.getLog(EnviarEmailService.class);


    public void enviarEmail(Email email) throws MessagingException {

        String[] listaDestinatarios = destinatarios.split(",");

        try {


            Properties props = new Properties();
            Session session = Session.getDefaultInstance(props, null);

            Message msg = new MimeMessage(session);

            msg.setFrom(new InternetAddress(sender, senderTitulo));
            msg.setReplyTo(new InternetAddress[] { new InternetAddress(sender) });

            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(listaDestinatarios[0]));

            for (  String dest : listaDestinatarios  ) {
                msg.addRecipient(Message.RecipientType.CC, new InternetAddress(dest));
            }

            msg.setSubject(email.getAssunto());
            msg.setContent(prepararMensagemHtml(email), "text/html");

            Transport.send(msg);

        } catch (AddressException e) {
            log.error(e);
            throw new AddressException(e.getMessage());
        } catch (MessagingException e) {
            log.error(e);
            throw new MessagingException(e.getMessage());
        } catch (Exception e) {
            log.error(e);
            throw new RuntimeException(e);
        }

    }




    private String prepararMensagemHtml(Email email) {

        StringBuilder msg = new StringBuilder();

        msg.append("<html><body><p><strong>Nome</strong>: ");
        msg.append(email.getNome());
        msg.append("</p><p><strong>E-mail:</strong>: ");
        msg.append(email.getEmail());
        msg.append("</p><p><strong>Mensagem:</strong> <br> ");
        msg.append(email.getMensagem());
        msg.append("</p></body></html>");

        return msg.toString();

    }



}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anfixmailapp.pl.confing;

import java.util.Properties;
import javafx.application.Application;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMailTLS {

	public static void main(String[] args) {

	}
        
        public String sendMail(String topic, String massage, String mailTo) {
            
                //Gmail
//		final String username = "skowronski.klaudiusz@gmail.com";
//		final String password = "Politechnika!@";
//
//		Properties props = new Properties();
//                props.setProperty("mail.transport.protocol", "smtp");     
//                props.setProperty("mail.host", "smtp.gmail.com");  
//		props.put("mail.smtp.auth", "true");
//		props.put("mail.smtp.starttls.enable", "true");
//		props.put("mail.smtp.host", "smtp.googlemail.com");
//		props.put("mail.smtp.port", "465");
//                props.put("mail.smtp.socketFactory.port", "465");  
//                props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");  
//                props.put("mail.smtp.socketFactory.fallback", "false");  
                
                //cartrack
                final String username = "kskowronski@cartrack.pl";
		final String password = "Politechnika!@";

		Properties props = new Properties();
                props.setProperty("mail.transport.protocol", "smtp");     
                props.setProperty("mail.host", "smtp.gmail.com");  
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "cartrack.nazwa.pl");
		props.put("mail.smtp.port", "465");
                props.put("mail.smtp.socketFactory.port", "465");  
                props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");  
                props.put("mail.smtp.socketFactory.fallback", "false");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("kskowronski@cartrack.pl")); // mail From
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailTo)); // mail TO
                        message.setRecipients(Message.RecipientType.CC, InternetAddress.parse("claude-plos@o2.pl")); // mail CC
                        
			message.setSubject(topic); // Temat
                        message.setContent(massage, "text/html; charset=utf-8");
                        // Wiadomosc
			//message.setT
                        

			Transport.send(message);

			System.out.println("Done");
                        
                        return "Done";

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}

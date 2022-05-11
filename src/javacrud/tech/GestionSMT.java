/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacrud.tech;

import java.util.Properties;
import java.util.Date;
import javacrud.model.Configuration;
import javax.mail.Session;
import javax.mail.PasswordAuthentication;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.activation.DataHandler;

/**
 *
 * @author r.bessede
 */
public class GestionSMT {
    
    Configuration c = new Configuration();
    private String user;
    private String password;
    private Session session;
    private MimeMessage message;
    String mailTo;
    String mailObj;
    String mailMsg;

    public GestionSMT() {
        this.user = c.getMailUser();
        this.password = c.getMailPass();
       
        initCon();
    }
    
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public MimeMessage getMessage() {
        return message;
    }

    public void setMessage(MimeMessage message) {
        this.message = message;
    }

    public void setMailTo(String mailTo) {
        this.mailTo = mailTo;
    }

    public void setMailObj(String mailObj) {
        this.mailObj = mailObj;
    }

    public void setMailMsg(String mailMsg) {
        this.mailMsg = mailMsg;
    }

    private void initCon() {
// Paramétrer l'objet "session" 
        Properties props = new Properties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", "mail.st2msi.net"); // hébergeur smtp
        props.put("mail.stmp.port", "465"); // port smtp
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.socketFactory.port", "465"); //SSL Port
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
        this.session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });
    }

    public void sendMsg() throws Exception { // exception traité par l'appelant
        this.message = new MimeMessage(session);
        this.message.setFrom(new InternetAddress(user));
        this.message.addRecipient(Message.RecipientType.TO, new InternetAddress(mailTo.strip()));
        this.message.addHeader("Content-type", "text/HTML; charset=UTF-8");
        this.message.addHeader("format", "flowed");
        this.message.addHeader("Content-Transfer-Encoding", "8bit");
        this.message.setHeader("X-Mailer", "st2msi.net/JavaMail version 1.6.2");
        this.message.setSentDate(new Date());
        this.message.setSubject(mailObj.strip(), "UTF-8");
        message.setText(mailMsg, "UTF-8");
        //send the message 
        session.setDebug(true); // passer à false en production
        Transport.send(message);
    }
    
    public void closeSMTPCon(){
        Properties propriete = new Properties();
        propriete = null;
    
    }

}

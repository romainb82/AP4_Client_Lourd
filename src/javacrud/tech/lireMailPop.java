/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javacrud.tech;

import javax.mail.*;
import java.util.Properties;

/**
 *
 * @author patrick
 */
public class lireMailPop {

    public static final String USERNAME = "propter.ipsum@st2msi.net";
    public static final String PASSWORD = "411_Client";

    public static void main(String[] args) throws Exception {
        //Properties props = new Properties();
        //props.put("mail.transport.protocol", "smtp");
        //props.put("mail.smtp.host", "mail.st2msi.net"); // hébergeur smtp
        //props.put("mail.stmp.port", "465"); // port smtp
        //props.put("mail.smtp.auth", "true");
        //props.put("mail.smtp.socketFactory.port", "465"); //SSL Port
        //props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
        //this.session = Session.getDefaultInstance(props,
        //        new javax.mail.Authenticator() {
        //    @Override
        //    protected PasswordAuthentication getPasswordAuthentication() {
        //        return new PasswordAuthentication(user, password);
        //    }
        // 1. Setup properties for the mail session.
        Properties props = new Properties();
        props.put("mail.store.protocol", "pop3");
        props.put("mail.pop3.host", "mail.st2msi.net");
        props.put("mail.pop3.port", "995");
        //props.put("mail.smtp.auth", "true");
        props.put("mail.pop3.socketFactory.port", "995");
        props.put("mail.pop3.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        
        props.put("mail.pop3.user", lireMailPop.USERNAME);
        //props.put("mail.pop3.socketFactory.fallback", "false");
        //props.put("mail.pop3.ssl.protocols", "TLSv1.2");
        

        // 2. Creates a javax.mail.Authenticator object.
        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(lireMailPop.USERNAME, lireMailPop.PASSWORD);
            }
        };

        // 3. Creating mail session.
        Session session = Session.getDefaultInstance(props, auth);

        // 4. Get the POP3 store provider and connect to the store.
        Store store = session.getStore("pop3");
        store.connect("mail.st2msi.net", lireMailPop.USERNAME, lireMailPop.PASSWORD);

        // 5. Get folder and open the INBOX folder in the store.
        Folder inbox = store.getFolder("INBOX");
        inbox.open(Folder.READ_ONLY);

        // 6. Retrieve the messages from the folder.
        Message[] messages = inbox.getMessages();
        for (Message message : messages) {
            message.writeTo(System.out);
        }

        // 7. Close folder and close store.
        inbox.close(false);
        store.close();
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javacrud.control;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.Arrays;
import javacrud.model.modelMail;
import javacrud.tech.UtilDB;
import javax.mail.Message;
import javax.swing.JOptionPane;

/**
 *
 * @author r.bessede
 */
public class MailDAO {
    
    public void insert(Message unMail) throws Exception{
        
        Connection con = UtilDB.getConnect();
        String sql = "INSERT INTO mail (expediteur, Destinataire, Objet, DateEnvoie, DateReception, ContenuMail) VALUES(?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,  unMail.getFrom()[0].toString()); 
        ps.setString(2, Arrays.toString(unMail.getReplyTo()));
        ps.setString(3, unMail.getSubject());
        ps.setString(4, unMail.getSentDate().toString() );
        if(unMail.getReceivedDate() != null){
             ps.setString(5, unMail.getReceivedDate().toString() );
        } else {
            ps.setString(5, "");
        } 
        ps.setString(6, unMail.getContent().toString());
        System.out.println("Requête sql : " + ps);
        ps.executeUpdate();
    }
}

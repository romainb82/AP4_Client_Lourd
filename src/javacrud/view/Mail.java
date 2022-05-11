/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacrud.view;
//package javacrud.tech;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javacrud.control.MailDAO;
import javacrud.model.Configuration;
import javacrud.model.Utilisateur;
import javacrud.tech.GestionSMT;
import javacrud.tech.UtilDB;
import javacrud.tech.lireMailPop;
import javax.mail.Authenticator;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author r.bessede
 */
public class Mail extends javax.swing.JFrame {

    public static final String USERNAME = "romain.bessede@st2msi.net";
    public static final String PASSWORD = "JpQ41_11;,kH";

    /**
     * Creates new form Mail
     */
    private GestionSMT gestionMail;
    
    public Mail(String destinataire)throws Exception  {
        initComponents();
        MailDAO maildo = new MailDAO();
        TexteMessage.setBackground(new java.awt.Color(255, 255, 255, 100));
        TexteDesti.setText(destinataire);
        this.gestionMail = new GestionSMT();
        
        //Lire Mail Pop
        Properties props = new Properties();
        props.put("mail.store.protocol", "pop3");
        props.put("mail.pop3.host", "mail.st2msi.net");
        props.put("mail.pop3.port", "995");
        //props.put("mail.smtp.auth", "true");
        props.put("mail.pop3.socketFactory.port", "995");
        props.put("mail.pop3.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        
        props.put("mail.pop3.user", USERNAME);
        //props.put("mail.pop3.socketFactory.fallback", "false");
        //props.put("mail.pop3.ssl.protocols", "TLSv1.2");
        

        // 2. Creates a javax.mail.Authenticator object.
        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USERNAME, PASSWORD);
            }
        };
        // 3. Creating mail session.
        Session session = Session.getDefaultInstance(props, auth);

        // 4. Get the POP3 store provider and connect to the store.
        Store store = session.getStore("pop3");
        store.connect("mail.st2msi.net", USERNAME, PASSWORD);

        // 5. Get folder and open the INBOX folder in the store.
        Folder inbox = store.getFolder("INBOX");
        inbox.open(Folder.READ_ONLY);

        // 6. Retrieve the messages from the folder.
        Message[] messages = inbox.getMessages();
        for (Message message : messages) {
            //message.writeTo(System.out);
        }
        Connection con = UtilDB.getConnect();
        
        String sql = "DELETE FROM mail";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.executeUpdate();
        for (int i = 1; i < messages.length; i++) {
            // stop after listing ten messages
            if (i > 10) {
              System.exit(0);
              inbox.close(true);
              store.close();
            }

            maildo.insert(messages[i]);
        }

       
            sql = "SELECT * FROM mail";
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            System.out.println("==============\n" + rs);

            DefaultTableModel uiTable = (DefaultTableModel) jTable1.getModel();
            
            int j = uiTable.getRowCount();
            //System.out.println(j);
            for (int i = j - 1; i >= 0; i--) {
                uiTable.removeRow(i);;
            }
            uiTable = (DefaultTableModel) jTable2.getModel();
            j = uiTable.getRowCount();
            //System.out.println(j);
            for (int i = j - 1; i >= 0; i--) {
                uiTable.removeRow(i);;
            }
            int i = 0;
            while( rs.next() ){
                if(rs.getString("expediteur").equals("romain.bessede@st2msi.net")){
                    uiTable = (DefaultTableModel) jTable2.getModel();
                } else {
                    uiTable = (DefaultTableModel) jTable1.getModel();
                }
                System.out.println(rs.getString("ContenuMail"));
                Object[] row = new Object[3];
                row[0] = rs.getString("DateEnvoie");
                row[1] = rs.getString("Objet");
                row[2] = rs.getString("expediteur");
                uiTable.addRow(row);
            }
        // 7. Close folder and close store.
        inbox.close(false);
        store.close();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        EnvoyerMail = new javax.swing.JPanel();
        Destinataire_Panel = new javax.swing.JLabel();
        TexteDesti = new javax.swing.JTextField();
        Objet_Panel = new javax.swing.JLabel();
        TexteObjet = new javax.swing.JTextField();
        Message_Panel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TexteMessage = new javax.swing.JTextArea();
        envoyer = new javax.swing.JButton();
        Abandonner = new javax.swing.JButton();
        MailEnvoyer = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        MailRecu = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 400));
        getContentPane().setLayout(null);

        Destinataire_Panel.setText("Destinataire : ");

        TexteDesti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TexteDestiActionPerformed(evt);
            }
        });

        Objet_Panel.setText("Objet : ");

        TexteObjet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TexteObjetActionPerformed(evt);
            }
        });

        Message_Panel.setText(" Message : ");

        TexteMessage.setColumns(20);
        TexteMessage.setRows(5);
        jScrollPane1.setViewportView(TexteMessage);

        envoyer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressource/valid_20.png"))); // NOI18N
        envoyer.setText("Envoyer");
        envoyer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                envoyerMouseClicked(evt);
            }
        });
        envoyer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                envoyerActionPerformed(evt);
            }
        });

        Abandonner.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressource/escape_20.png"))); // NOI18N
        Abandonner.setText("Abandonner");
        Abandonner.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AbandonnerMouseClicked(evt);
            }
        });
        Abandonner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbandonnerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout EnvoyerMailLayout = new javax.swing.GroupLayout(EnvoyerMail);
        EnvoyerMail.setLayout(EnvoyerMailLayout);
        EnvoyerMailLayout.setHorizontalGroup(
            EnvoyerMailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EnvoyerMailLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EnvoyerMailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EnvoyerMailLayout.createSequentialGroup()
                        .addComponent(envoyer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Abandonner))
                    .addGroup(EnvoyerMailLayout.createSequentialGroup()
                        .addGroup(EnvoyerMailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(EnvoyerMailLayout.createSequentialGroup()
                                .addComponent(Destinataire_Panel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TexteDesti, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(EnvoyerMailLayout.createSequentialGroup()
                                .addComponent(Objet_Panel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TexteObjet, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(EnvoyerMailLayout.createSequentialGroup()
                                .addComponent(Message_Panel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 86, Short.MAX_VALUE)))
                .addContainerGap())
        );
        EnvoyerMailLayout.setVerticalGroup(
            EnvoyerMailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EnvoyerMailLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EnvoyerMailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Destinataire_Panel)
                    .addComponent(TexteDesti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(EnvoyerMailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Objet_Panel)
                    .addComponent(TexteObjet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(EnvoyerMailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Message_Panel)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(EnvoyerMailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(envoyer)
                    .addComponent(Abandonner))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Envoyer Mail", EnvoyerMail);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Date Envoie", "Objet", "A qui "
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable2);

        javax.swing.GroupLayout MailEnvoyerLayout = new javax.swing.GroupLayout(MailEnvoyer);
        MailEnvoyer.setLayout(MailEnvoyerLayout);
        MailEnvoyerLayout.setHorizontalGroup(
            MailEnvoyerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
        );
        MailEnvoyerLayout.setVerticalGroup(
            MailEnvoyerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Mail Envoyé", MailEnvoyer);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Date Recu", "Objet", "Expéditeur"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout MailRecuLayout = new javax.swing.GroupLayout(MailRecu);
        MailRecu.setLayout(MailRecuLayout);
        MailRecuLayout.setHorizontalGroup(
            MailRecuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
        );
        MailRecuLayout.setVerticalGroup(
            MailRecuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Mail Reçu", MailRecu);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(0, 0, 420, 260);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void envoyerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_envoyerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_envoyerActionPerformed

    private void TexteDestiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TexteDestiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TexteDestiActionPerformed

    private void TexteObjetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TexteObjetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TexteObjetActionPerformed
    
    @SuppressWarnings("CallToPrintStackTrace")
    private void envoyerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_envoyerMouseClicked

        gestionMail.setMailTo(TexteDesti.getText().strip());
        gestionMail.setMailObj(TexteObjet.getText().strip());
        gestionMail.setMailMsg(TexteMessage.getText());
        try{
            gestionMail.sendMsg();
        } catch (Exception ev){
            ev.printStackTrace();
        }
    }//GEN-LAST:event_envoyerMouseClicked

    private void AbandonnerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AbandonnerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AbandonnerActionPerformed

    private void AbandonnerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AbandonnerMouseClicked
        // TODO add your handling code here:
        gestionMail.closeSMTPCon();
        gestionMail= null;
        this.dispose();
    }//GEN-LAST:event_AbandonnerMouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked



        // TODO add your handling code here:
    }//GEN-LAST:event_jTable2MouseClicked

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String args[])throws Exception   {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Mail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Configuration c = new Configuration();
                try {
                    new Mail(c.getMailUser()).setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(Mail.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Abandonner;
    private javax.swing.JLabel Destinataire_Panel;
    private javax.swing.JPanel EnvoyerMail;
    private javax.swing.JPanel MailEnvoyer;
    private javax.swing.JPanel MailRecu;
    private javax.swing.JLabel Message_Panel;
    private javax.swing.JLabel Objet_Panel;
    private javax.swing.JTextField TexteDesti;
    private javax.swing.JTextArea TexteMessage;
    private javax.swing.JTextField TexteObjet;
    private javax.swing.JButton envoyer;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}

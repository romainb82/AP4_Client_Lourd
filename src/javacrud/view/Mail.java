/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacrud.view;
//package javacrud.tech;

import javacrud.model.Configuration;
import javacrud.model.Utilisateur;
import javacrud.tech.GestionSMT;

/**
 *
 * @author r.bessede
 */
public class Mail extends javax.swing.JFrame {

    /**
     * Creates new form Mail
     */
    private GestionSMT gestionMail;
    
    public Mail(String destinataire) {
        initComponents();
        TexteMessage.setBackground(new java.awt.Color(255, 255, 255, 100));
        TexteDesti.setText(destinataire);
        this.gestionMail = new GestionSMT();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Destinataire_Panel = new javax.swing.JLabel();
        TexteDesti = new javax.swing.JTextField();
        Objet_Panel = new javax.swing.JLabel();
        TexteObjet = new javax.swing.JTextField();
        Message_Panel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TexteMessage = new javax.swing.JTextArea();
        envoyer = new javax.swing.JButton();
        Abandonner = new javax.swing.JButton();

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(envoyer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Abandonner)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Message_Panel)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Objet_Panel)
                        .addGap(18, 18, 18)
                        .addComponent(TexteObjet))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Destinataire_Panel)
                        .addGap(18, 18, 18)
                        .addComponent(TexteDesti, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(49, 49, 49))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Destinataire_Panel)
                    .addComponent(TexteDesti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Objet_Panel)
                    .addComponent(TexteObjet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Message_Panel)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(envoyer)
                    .addComponent(Abandonner))
                .addContainerGap())
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 11, 380, 280);

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

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
                new Mail(c.getMailUser()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Abandonner;
    private javax.swing.JLabel Destinataire_Panel;
    private javax.swing.JLabel Message_Panel;
    private javax.swing.JLabel Objet_Panel;
    private javax.swing.JTextField TexteDesti;
    private javax.swing.JTextArea TexteMessage;
    private javax.swing.JTextField TexteObjet;
    private javax.swing.JButton envoyer;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

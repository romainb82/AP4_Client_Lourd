/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javacrud.control;

import javacrud.model.Utilisateur;
import javacrud.tech.UtilDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeMap;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author r.bessede
 */
public class UtilisateurDAOImp implements UtilDAO {

    @Override
    public void create(Utilisateur utilisateur) {
        try {
            Connection con = UtilDB.getConnect();
            String sql = "INSERT INTO utilisateur (ut_pseudo, ut_nom, ut_prenom, ut_mp, ut_mail, ut_phrase, ut_adr1, ut_adr2, ut_cdpost, ut_numpost) VALUES(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, utilisateur.getUt_pseudo());
            ps.setString(2, utilisateur.getUt_nom());
            ps.setString(3, utilisateur.getUt_prenom());
            ps.setString(4, utilisateur.getUt_mp());
            ps.setString(5, utilisateur.getUt_mail());
            ps.setString(6, utilisateur.getUt_phrase());
            ps.setString(7, utilisateur.getUt_adr1());
            ps.setString(8, utilisateur.getUt_adr2());
            ps.setString(9, utilisateur.getUt_cdpost());
            ps.setString(10, utilisateur.getUt_numpost());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "DB : Enregistrement créé !");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "DB : Erreur lors de la création, de l'utilisateur !");
        }
    }

    @Override
    public void update(Utilisateur utilisateur) {
        try {
            Connection con = UtilDB.getConnect();
            String sql = "UPDATE Utilisateur SET ut_nom = ?, ut_prenom = ?, ut_mp = ?, ut_mail = ?, ut_phrase = ?, ut_adr1 = ?, ut_adr2 = ?, ut_cdpost = ?, ut_numpost = ? WHERE ut_pseudo = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, utilisateur.getUt_nom());
            ps.setString(2, utilisateur.getUt_prenom());
            ps.setString(3, utilisateur.getUt_mp());
            ps.setString(4, utilisateur.getUt_mail());
            ps.setString(5, utilisateur.getUt_phrase());
            ps.setString(6, utilisateur.getUt_adr1());
            ps.setString(7, utilisateur.getUt_adr2());
            ps.setString(8, utilisateur.getUt_cdpost());
            ps.setString(9, utilisateur.getUt_numpost());
            ps.setString(10, utilisateur.getUt_pseudo());
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "DB : Enregistrement mis à jour !");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "DB : Erreur lors de la mis à jour de l'utilisateur !");
        }
    }

    @Override
    public void delete(String pseudo) {
        try {
            Connection con = UtilDB.getConnect();
            String sql = "DELETE FROM Utilisateur WHERE ut_pseudo = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, pseudo);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "DB : Enregistrement supprimé avec succès !");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "DB : Erreur lors de la suppression de l'utilisateur !");
        }
    }

    @Override
    public Utilisateur get(String pseudo) {
        Utilisateur uti = new Utilisateur();
        return uti;
    }

    @Override
    public TreeMap<String, Utilisateur> list() {
        TreeMap<String, Utilisateur> list = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        try {
            Connection con = UtilDB.getConnect();
            String sql = "SELECT * FROM util_vue ORDER BY ut_pseudo";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Utilisateur ut = new Utilisateur();
                ut.setUt_pseudo(rs.getString("ut_pseudo"));
                ut.setUt_nom(rs.getString("ut_nom"));
                ut.setUt_prenom(rs.getString("ut_prenom"));
                ut.setUt_mp(rs.getString("ut_mp"));
                ut.setUt_mail(rs.getString("ut_mail"));
                ut.setUt_phrase(rs.getString("ut_phrase"));
                ut.setUt_adr1(rs.getString("ut_adr1"));
                ut.setUt_adr2(rs.getString("ut_adr2"));
                ut.setUt_cdpost(rs.getString("ut_cdpost"));
                ut.setUt_numpost(rs.getString("ut_numpost"));
                ut.setNom_Commune(rs.getString("Nom_Commune"));

                list.put(ut.getUt_pseudo(), ut);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "DB: Erreur lors du chargement des utilisateurs");
        }
        return list;
    }
}

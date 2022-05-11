/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javacrud.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import javacrud.tech.UtilDB;
import javacrud.model.Utilisateur;
import javacrud.model.Commune;

/**
 *
 * @author r.bessede
 */
public class VilleDAOImp implements VilleDAO{

    public HashMap<Integer, Commune> ville;
    private Integer num_postal;
    private Integer Code_Postal;
    private String Nom_Commune;

    public VilleDAOImp() {

    }

    public HashMap<Integer, Commune> getVille() {
        return ville;
    }

    public void setVille(HashMap<Integer, Commune> ville) {
        this.ville = ville;
    }

    public HashMap<Integer, Commune> SelectVille(Integer codePostal) throws Exception {
        
        HashMap<Integer, Commune> ville = new HashMap<>();
        
        Connection con = UtilDB.getConnect();
        Utilisateur u = new Utilisateur();
        
        String sql = "SELECT Num_Postal, Nom_Commune FROM codes_postaux WHERE Code_Postal = ? ORDER BY Num_Postal";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,codePostal.toString());
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Commune c = new Commune(codePostal.toString(),rs.getString("Num_Postal"),rs.getString("Nom_Commune"));
            ville.put(rs.getInt("Num_Postal"), c);
        }
        System.out.println(ville);
        return ville;
    }

    public Integer getNum_postal() {
        return num_postal;
    }

    public void setNum_postal(Integer num_postal) {
        this.num_postal = num_postal;
    }

    public Integer getCode_Postal() {
        return Code_Postal;
    }

    public void setCode_Postal(Integer Code_Postal) {
        this.Code_Postal = Code_Postal;
    }

    public String getNom_Commune() {
        return Nom_Commune;
    }

    public void setNom_Commune(String Nom_Commune) {
        this.Nom_Commune = Nom_Commune;
    }
}

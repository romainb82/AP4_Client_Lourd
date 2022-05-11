/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package javacrud.control;
import javacrud.model.Utilisateur;
import javacrud.model.Commune;
import java.util.HashMap;
/**
 *
 * @author r.bessedebrad
 */
public interface VilleDAO {
    public HashMap<Integer, Commune> ville = new HashMap<Integer, Commune>();   
}

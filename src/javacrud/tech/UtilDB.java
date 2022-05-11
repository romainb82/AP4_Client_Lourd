/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javacrud.tech;

import java.sql.Connection; // entre la déclaration du package et de la classe
import java.sql.DriverManager;
import javacrud.control.ConfigDAO;
import javacrud.model.Configuration;

/**
 *
 * @author r.bessede
 */
public class UtilDB {
    static Connection con;
    
    public static Connection getConnect() throws Exception{
        Configuration c = new Configuration();
        XMLLocal wml = new XMLLocal();
        ConfigDAO dao = new ConfigDAO();
        
        String url = "jdbc:mysql://" + dao.getConfiguration().getMysqlHost() + ":"+ dao.getConfiguration().getMysqlPort() + "/" + dao.getConfiguration().getMysqlDb();
        String user = dao.getConfiguration().getMysqlUser();
        String pass = dao.getConfiguration().getMysqlPass();
        
        System.out.println(user+ " : "+pass);
        if(con == null){
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
        }
        return con;
    }
    
    public void closeConnect() throws Exception {
        con.close();
    }

    

 
}

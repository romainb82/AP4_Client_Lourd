/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javacrud.control;

import java.util.List;
import javacrud.model.Configuration;
import javacrud.tech.XMLLocal;
import javax.swing.JOptionPane;
import org.jdom2.Document;
import org.jdom2.Element;

/**
 *
 * @author r.bessede
 */
public class ConfigDAO implements ConfigDAOInterface {

    public static Configuration getConfiguration() {
        Configuration c = new Configuration();
        try {
            Document docXML = (Document) XMLLocal.getDocument();
            Element docRoot = docXML.getRootElement();
            List<Element> lesParamsMail = docRoot.getChildren("mail");
            for (Element paramMail : lesParamsMail) {
                System.out.println(paramMail);
                c.setMailProtocole(paramMail.getChildText("protocol"));
                c.setMailHost(paramMail.getChildText("host"));
                c.setMailPort(paramMail.getChildText("port"));
                c.setMailUser(paramMail.getChildText("user"));
                c.setMailPass(paramMail.getChildText("password"));
            }
            List<Element> lesParamsMysql = docRoot.getChildren("mysql");
            for (Element paramMysql : lesParamsMysql) {
                c.setMysqlHost(paramMysql.getChildText("host"));
                c.setMysqlPort(paramMysql.getChildText("port"));
                c.setMysqlDb(paramMysql.getChildText("database"));
                c.setMysqlUser(paramMysql.getChildText("user"));
                c.setMysqlPass(paramMysql.getChildText("password"));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Config : Erreur d'initialisation");
        }
        return c;
    }

    public void initXMLFile() {
        try {
            Element config = new Element("configuration");
            Document docXML = new Document(config);

            Element mail = new Element("mail");
            mail.addContent(new Element("protocol").setText("smtp"));
            mail.addContent(new Element("host").setText("mail.st2msi.net"));
            mail.addContent(new Element("port").setText("465"));
            mail.addContent(new Element("user").setText("romain.bessede@st2msi.net"));
            mail.addContent(new Element("password").setText("JpQ41_11;,kH"));
            docXML.getRootElement().addContent(mail);

            Element mysql = new Element("mysql");
            mysql.addContent(new Element("host").setText("localhost"));
            mysql.addContent(new Element("port").setText("3306"));
            mysql.addContent(new Element("database").setText("gestion_utilisateur"));
            mysql.addContent(new Element("user").setText("mysql"));
            mysql.addContent(new Element("password").setText("azerty"));
            docXML.getRootElement().addContent(mysql);
            XMLLocal.saveDocument(docXML);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Config : Erreur lors de la création de config.xml");
        }
    }

    public static void saveXMLFile(Configuration c) {
        try {
            Element config = new Element("configuration");

            Document docXML = new Document(config);
            Element mail = new Element("mail");
            mail.addContent(new Element("protocol").setText(c.getMailProtocole()));
            mail.addContent(new Element("host").setText(c.getMailHost()));
            mail.addContent(new Element("port").setText(c.getMailPort()));
            mail.addContent(new Element("user").setText(c.getMailUser()));
            mail.addContent(new Element("password").setText(c.getMailPass()));
            docXML.getRootElement().addContent(mail);

            Element mysql = new Element("mysql");
            mysql.addContent(new Element("host").setText(c.getMysqlHost()));
            mysql.addContent(new Element("port").setText(c.getMysqlPort()));
            mysql.addContent(new Element("database").setText(c.getMysqlDb()));
            mysql.addContent(new Element("user").setText(c.getMysqlUser()));
            mysql.addContent(new Element("password").setText(c.getMysqlPass()));
            docXML.getRootElement().addContent(mysql);
            XMLLocal.saveDocument(docXML);
            JOptionPane.showMessageDialog(null, "Config : Configuration sauvegardée");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Config : Erreur sauvegarde config.xml");
        }

    }
}

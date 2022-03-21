/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javacrud.tech;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.File;
import java.nio.file.Paths;
import java.io.IOException;
import javax.imageio.ImageIO;
/**
 *
 * @author r.bessede
 */
public class GestionImg {

    public static BufferedImage reziseImg(BufferedImage image, int largeurCible, int hauteurCible) throws IOException {
        int hauteur = image.getHeight();
        int largeur = image.getWidth();
        int hauteurOut = hauteurCible;
        int largeurOut = largeurCible;
        int typeInt = image.getType();
        float ratioIn = hauteur / largeur;
        float ratioCible = hauteurCible / largeurCible;
        if (ratioIn > ratioCible) {
            largeurOut = largeur * hauteurCible / hauteur;
        } else {
            hauteurOut = hauteur * largeurCible / largeur;
        }
        BufferedImage imageOut = new BufferedImage(largeurOut, hauteurOut, typeInt);
        Graphics2D bGr = imageOut.createGraphics();
        bGr.drawImage(image, 0, 0, largeurOut, hauteurOut, null);
        bGr.dispose();
        return imageOut;
    }

}

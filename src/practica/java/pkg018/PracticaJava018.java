/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.java.pkg018;

import GUI.JFramePrincipal;
import java.text.ParseException;
import javax.swing.UnsupportedLookAndFeelException;
/**
 *
 * @author Alfonso Andrés
 */
public class PracticaJava018 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            javax.swing.UIManager.setLookAndFeel(new de.javasoft.plaf.synthetica.SyntheticaBlackEyeLookAndFeel());
        }catch(ParseException | UnsupportedLookAndFeelException e){}
        new JFramePrincipal().setVisible(true);
    }
}

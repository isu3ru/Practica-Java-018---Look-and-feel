/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import GUI.JPanelContenedor;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 *
 * @author estudiante
 */
public class ControladorJTextField extends java.awt.event.KeyAdapter{

    private JPanelContenedor jpanelcontenedor;

    public ControladorJTextField(JPanelContenedor jpanelcontenedor) {
        this.jpanelcontenedor = jpanelcontenedor;
    }
    
    public void keyTyped(KeyEvent e) {
        if(e.getSource().equals(jpanelcontenedor.getJTextField(2))||e.getSource().equals(jpanelcontenedor.getJTextField(3))){
            if(!Character.isDigit(e.getKeyChar())){
                e.consume();
                Toolkit.getDefaultToolkit().beep();
            }
        }else{
           if(Character.isDigit(e.getKeyChar())){
                e.consume();
                Toolkit.getDefaultToolkit().beep();
            }
        }
    }
    
}

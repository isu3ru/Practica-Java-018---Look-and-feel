/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import GUI.JPanelContenedor;
import javax.swing.event.ListSelectionEvent;

/**
 *
 * @author Alfonso Andrés
 */
public class ControladorJList implements javax.swing.event.ListSelectionListener{

    private JPanelContenedor jpanelcontenedor;
    
    public ControladorJList(JPanelContenedor parent) {
        this.jpanelcontenedor=parent;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        this.jpanelcontenedor.actualizarJTextField();
    }
    
}

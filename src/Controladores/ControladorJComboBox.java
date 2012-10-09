/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Dependencias.BaseDeDatos;
import GUI.JPanelContenedor;
import java.awt.event.ActionEvent;

/**
 *
 * @author Alfonso Andrés
 */
public class ControladorJComboBox implements java.awt.event.ActionListener{
    
    JPanelContenedor jpanelcontenedor1;

    public ControladorJComboBox(JPanelContenedor parent) {
        this.jpanelcontenedor1 = parent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "Listado":
                if(this.jpanelcontenedor1.isControladorEventos()){
                    int indice = this.jpanelcontenedor1.getIndiceEstudianteSeleccionado()-1;
                    if(this.jpanelcontenedor1.getEditing()){
                        this.jpanelcontenedor1.getButtonIngresar().doClick();
                        
                    }else{
                        if(indice>=0){
                        //    this.jpanelcontenedor1.setEstudiante(BaseDeDatos.getEstudiante(indice));
                            this.jpanelcontenedor1.setEstudiante(BaseDeDatos.getInstance().buscarEstudiante(this.jpanelcontenedor1.getEstudianteSeleccionado()));
                        }else{
                            this.jpanelcontenedor1.setEstudiante(null);
                        }
                        this.jpanelcontenedor1.bloquearCampos();
                    }
                }
                break;
            case "Materias":
                this.jpanelcontenedor1.cargarElementosJList();
                break;
            case "Semestre":
                break;
        }
    }
    
}

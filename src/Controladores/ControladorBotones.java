/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Dependencias.BaseDeDatos;
import Dependencias.Estudiante;
import GUI.JPanelContenedor;
import java.awt.event.ActionEvent;

/**
 *
 * @author Alfonso Andrés
 */
public class ControladorBotones implements java.awt.event.ActionListener{

    private JPanelContenedor jpanelcontenedor1;
    private boolean editar=false;
    
    public ControladorBotones(JPanelContenedor parent) {
        this.jpanelcontenedor1=parent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int indice;
        this.jpanelcontenedor1.setControladorEventos(false);
        switch(e.getActionCommand()){
            case "Ingresar":
                jpanelcontenedor1.setEditing(true);
                if(this.jpanelcontenedor1.isCamposBloqueados()){
                    this.jpanelcontenedor1.desbloquearCampos();
                    this.jpanelcontenedor1.borrarCampo();
                    if(!editar){
                        this.jpanelcontenedor1.setEstudianteSeleccionado(0);
                    }
                }else{
                    if(this.jpanelcontenedor1.datosNoEstanLlenos()){
                        javax.swing.JOptionPane.showMessageDialog(jpanelcontenedor1,"Por favor, complete todos los campos.");
                        this.jpanelcontenedor1.setEstudianteSeleccionado(0);
                    }else{
                        Estudiante est=this.jpanelcontenedor1.getEstudiante();
                        if(editar){
                            String mensaje;
                            if(BaseDeDatos.getInstance().editarEstudiante(est)){
                                mensaje = "Estudiante editado exitosamente.";
                                jpanelcontenedor1.setEditing(false);
                            }else 
                                mensaje = "ERROR, no se pudo editar el estudiante";
                            javax.swing.JOptionPane.showMessageDialog(jpanelcontenedor1, mensaje);
                            this.jpanelcontenedor1.bloquearCampos();
                            this.jpanelcontenedor1.actualizarNombre();
                            editar=false;
                        }else{
                            if(BaseDeDatos.getInstance().compararCedula(est.getCedula()))
                                javax.swing.JOptionPane.showMessageDialog(jpanelcontenedor1,"Datos ya existen.");
                            else{
                                String mensaje;
                                if(BaseDeDatos.getInstance().agregarEstudiante(est)){
                                    mensaje="Estudiante guardado exitosamente.";
                                    jpanelcontenedor1.setEditing(false);
                                }else 
                                    mensaje="ERROR, no hay cupos disponibles.";
                                javax.swing.JOptionPane.showMessageDialog(jpanelcontenedor1,mensaje);
                                this.jpanelcontenedor1.agregarNombre();
                                this.jpanelcontenedor1.bloquearCampos();
                                this.jpanelcontenedor1.setEstudianteSeleccionado(BaseDeDatos.getInstance().getCantidadEstudiantes());                               
                            }
                        } 
                    }
                }
                break;
            case "Editar":
                indice = this.jpanelcontenedor1.getIndiceEstudianteSeleccionado() - 1;
                if(indice>=0){
                    editar=true;
                    jpanelcontenedor1.setEditing(true);
                    this.jpanelcontenedor1.setEstudiante(BaseDeDatos.getInstance().buscarEstudiante(this.jpanelcontenedor1.getEstudiante()));
                    this.jpanelcontenedor1.desbloquearCampos();
                }
                break;
            default:
                indice=this.jpanelcontenedor1.getIndiceEstudianteSeleccionado()-1;
                if(indice>=0){
                    BaseDeDatos.getInstance().eliminarEstudiante(this.jpanelcontenedor1.getEstudiante());
                    this.jpanelcontenedor1.removerNombre();
                }else{
                    this.jpanelcontenedor1.setEstudiante(null);
                }
                this.jpanelcontenedor1.borrarCampo();
        }
        this.jpanelcontenedor1.setControladorEventos(true);
    }
    
}

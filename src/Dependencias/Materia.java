/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dependencias;

import java.util.ArrayList;

/**
 *
 * @author Alfonso Andrés
 */
public class Materia {
    
    private String nombre;
    private ArrayList<Seccion> secciones;

    public Materia(String nombre, ArrayList<Seccion> secciones) {
        this.nombre = nombre;
        this.secciones = secciones;
    }

    public Materia(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSecciones(ArrayList<Seccion> secciones) {
        this.secciones = secciones;
    }

    public ArrayList<Seccion> getSecciones() {
        return secciones;
    }
    
    public void setSeccion(Seccion secciones) {
        this.secciones.add(secciones);
    }

    public Seccion getSeccion(int i) {
        if(i > secciones.size()) {
            return null;
        }
        return secciones.get(i);
    }
    
    public boolean agregarEstudiante(Estudiante estudiante){
        for(Seccion seccion : secciones){
            if(estudiante.getSeccion() == seccion.getSeccion()){
                return seccion.agregarEstudiante(estudiante);
            }
        }
        return false;
    }
    
    public Estudiante editarEstudiante(Estudiante estudiante){
        if(!estudiante.getMateria().equals(nombre)){
            eliminarEstudiante(estudiante);
            return estudiante;
        }
        Estudiante editado = this.buscarEstudiante(estudiante.getCedula());
        if(editado == null) {
            return estudiante;
        }
        for(Seccion seccion : secciones){
            editado = seccion.editarEstudiante(estudiante);
            if(editado == null) {
                return editado;
            }
        }
        if(this.agregarEstudiante(estudiante)) {
            return null;
        }
        return estudiante;
    }
    
    public int getPosicionEstudiante(int cedula){
        int posicion=0;
        for(Seccion seccion : secciones){
            posicion += seccion.getPosicionEstudiante(cedula);
        }
        return posicion;
    }
    
    public int getCantidadEstudiantes(){
        int cantidad=0;
        for(Seccion seccion : secciones){
            cantidad += seccion.getCantidadEstudiantes();
        }
        return cantidad;
    }
    
    public boolean compararCedula(int cedula) {
        for(Seccion seccion : secciones){
            if(seccion.compararCedula(cedula)){
                return true;
            }
        }
        return false;
    }
    
    public Estudiante buscarEstudiante(int cedula){
        Estudiante estudiante;
        for(Seccion seccion : secciones){
            estudiante = seccion.buscarEstudiante(cedula);
            if(estudiante != null){
                return estudiante;
            }
        }
        return null;
    }
    
    public boolean eliminarEstudiante(int cedula){
        Boolean eliminado;
        for(Seccion seccion : secciones){
            eliminado = seccion.eliminarEstudianteCedula(cedula);
            if(eliminado) {
                return eliminado;
            }
        }
        return false;
    }
    
    public boolean eliminarEstudiante(Estudiante estudiante){
        return eliminarEstudiante(estudiante.getCedula());
    }
    
}

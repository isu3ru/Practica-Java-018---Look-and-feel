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
public class Seccion {
    
    private int cupos,seccion;
    private ArrayList<Estudiante> estudiantes;

    public Seccion(int cupos, int seccion) {
        this.cupos = cupos;
        this.seccion = seccion;
        estudiantes=new ArrayList<>();
    }
    
    public int getCupos() {
        return cupos;
    }

    public int getSeccion() {
        return seccion;
    }

    public void setCupos(int cupos) {
        this.cupos = cupos;
    }

    public void setSeccion(int seccion) {
        this.seccion = seccion;
    }
    
    public boolean agregarEstudiante(Estudiante estudiante){
        if(cupos <= 0)
            return false;
        this.estudiantes.add(estudiante);
        cupos--;
        return true;
    }
    
    public void editarEstudiante(int index,Estudiante estudiante){
        this.estudiantes.set(index, estudiante);
    }
    
    public Estudiante editarEstudiante(Estudiante estudiante){
        if(estudiante.getSeccion()!=seccion){
            eliminarEstudiante(estudiante);
            return estudiante;
        }
        for(int size=estudiantes.size(),i=0;i<size;i++){
            if(estudiante.getCedula()==estudiantes.get(i).getCedula()){
                estudiantes.set(i,estudiante);
                return null;
            }
        }
        return estudiante;
    }
    
    public void eliminarEstudiante(int index){
        estudiantes.remove(index);
        cupos++;
    }
    
    public boolean eliminarEstudianteCedula(int cedula){
        for(int i = 0, size = estudiantes.size(); i < size; i++) {
            if(estudiantes.get(i).getCedula() == cedula){
                estudiantes.remove(i);
                cupos++;
                return true;
            }
        }
        return false;
    }
    
    public boolean eliminarEstudiante(Estudiante estudiante){
        return eliminarEstudianteCedula(estudiante.getCedula());
    }
    
    public int getPosicionEstudiante(int cedula){
        for(int i=0,size=estudiantes.size();i<size;i++)
            if(estudiantes.get(i).getCedula()==cedula)
                return i+1;
        return 0;
    }
    
    public int getCantidadEstudiantes(){
        return estudiantes.size();
    }
    
    public boolean compararCedula(int cedula) {
        for (Estudiante estudiante : estudiantes)
            if (estudiante.getCedula() == cedula)
                return true;
        return false;
    }
    
    public Estudiante buscarEstudiante(int cedula){
        for (Estudiante estudiante : estudiantes)
            if (estudiante.getCedula() == cedula)
                return estudiante;
        return null;
    }
    
    @Override
    public String toString() {
        return "Seccion "+this.seccion+" - Cupos: "+this.cupos;
    }
    
}

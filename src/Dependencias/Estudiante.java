/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dependencias;

/**
 *
 * @author Alfonso Andrés
 */
public class Estudiante extends Persona{
    
    private String carrera;
    private String materia;
    private int seccion;
    

    public Estudiante(String carrera, String materia, int seccion, String nombre, String apellido, int cedula, int edad) {
        super(nombre, apellido, cedula, edad);
        this.carrera = carrera;
        this.materia = materia;
        this.seccion = seccion;
    }

    public String getCarrera() {
        return carrera;
    }

    public int getSeccion() {
        return seccion;
    }

    public void setSeccion(int seccion) {
        this.seccion = seccion;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }
    
    
    @Override
    public String toString(){
        return "C.I. "+super.getCedula()+" - "+super.getNombre()+" "+super.getApellido();
    }
}

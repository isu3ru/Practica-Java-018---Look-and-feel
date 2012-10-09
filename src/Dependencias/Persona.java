package Dependencias;

import java.io.Serializable;
public class Persona implements Serializable{
    
    private String nombre,apellido,sexo;
    private int cedula,edad;
    private static final long serialVersionUID = 10L;
    
    public Persona(){
    }
    
    public Persona(String nombre, String apellido, int cedula, int edad){
    	this.nombre = nombre;
    	this.apellido = apellido;
    	this.cedula = cedula;
        this.edad = edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public String getNombre() {
	return nombre;
    }
    
    public String getApellido() {
	return apellido;
    }
    
    public int getCedula(){
	return cedula;
    }
    
    public int getEdad(){
    	return edad;
    }
        
    public void setCedula(int cedula){
	this.cedula = cedula;
    }
    
}//Fin de la clase

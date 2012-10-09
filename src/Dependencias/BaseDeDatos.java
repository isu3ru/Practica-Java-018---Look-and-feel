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
public class BaseDeDatos {
    
    private final ArrayList<Estudiante> estudiantes = new ArrayList<>();
    private final ArrayList<Materia>materias = new ArrayList<>();
    public static enum Materias{
        CIRCUITOS_Y_SISTEMAS{
            @Override
            public String toString() {
                return "Circuitos y sistemas";
            }
        },
        ESTRUCTURAS_DE_DATOS{
            @Override
            public String toString() {
                return "Estructuras de datos";
            }
        },
        TALLER_DE_ESTRUCTURAS_DE_DATOS{
            @Override
            public String toString() {
                return "Taller de estructuras de datos";
            }
        },
        AUTOMATAS{
            @Override
            public String toString() {
                return "Teoria de automatas";
            }
        },
        COMPUTACION_GRAFICA_I{
            @Override
            public String toString() {
                return "Computacion grafica I";
            }
        },
        TALLER_DE_COMPUTACION_GRAFICA_I{
            @Override
            public String toString() {
                return "Taller de computacion grafica I";
            }
        },
        METODOS_NUMERICOS{
            @Override
            public String toString() {
                return "Metodos numericos";
            }
        },
        CANTIDAD;
    }
    private static BaseDeDatos instance;

    private BaseDeDatos() { }

    public static BaseDeDatos getInstance() {
        return instance == null ? (instance = new BaseDeDatos()) : instance;            
    }
    
    public void crearMaterias(){
        for(Materias materia : Materias.values()){
            if(materia == Materias.CANTIDAD)
                return;
            materias.add(new Materia(materia.toString(), crearSecciones(materia)));
        }
    }

    public void borrarMaterias(){
        materias.clear();
    }

    public String getNombreMateria(int i){
        return materias.get(i).getNombre();
    }
    
//    public String getNombreMaterias(int i) {
//        if(i == CIRCUITOS_Y_SISTEMAS)return "Circuitos y sistemas";
//        if(i == ESTRUCTURAS_DE_DATOS) return "Estructuras de datos";
//        if(i == TALLER_DE_ESTRUCTURAS_DE_DATOS) return "Taller de estructuras de datos";
//        if(i == AUTOMATAS) return "Teoria de automatas";
//        if(i == COMPUTACION_GRAFICA_I) return "Computacion grafica I";
//        if(i == TALLER_DE_COMPUTACION_GRAFICA_I) return "Taller de computacion grafica I";
//        return "Metodos numericos";
//    }

    private ArrayList<Seccion> crearSecciones(Materias materia) {
        ArrayList<Seccion> secciones = new ArrayList<>();
        if(materia == Materias.CIRCUITOS_Y_SISTEMAS || materia == Materias.METODOS_NUMERICOS){
            secciones.add(new Seccion(40,1));
            secciones.add(new Seccion(40,20));
        }else if(materia == Materias.TALLER_DE_COMPUTACION_GRAFICA_I)
            secciones.add(new Seccion(30,20));
        else
            secciones.add(new Seccion(30,1));
        return secciones;
    }
    
    public ArrayList<Seccion> getSecciones(int i){
        return materias.get(i).getSecciones();
    }
    
    public int getPosicionEstudiante(int cedula){
        int posicion=0;
        for(Materia materia : materias){
            posicion += materia.getPosicionEstudiante(cedula);
        }
        return posicion;
    }
    
    public boolean agregarEstudiante(Estudiante est){
        for(Materia materia : materias){
            if(materia.getNombre().equals(est.getMateria())){
                return materia.agregarEstudiante(est);
            }
        }
        return false;
    }
    
    public boolean editarEstudiante(Estudiante element){
        for(Materia materia : materias){
            if(materia.buscarEstudiante(element.getCedula()) != null){
                if(materia.editarEstudiante(element) == null)
                    return true;
                materia.eliminarEstudiante(element);
            }
        }
        return agregarEstudiante(element);
    }
    
    public int getCantidadEstudiantes(){
        int cantidad=0;
        for(Materia materia : materias){
            cantidad += materia.getCantidadEstudiantes();
        }
        return cantidad;
    }
    
    public void modificarEstudiante(int index,Estudiante element){
        estudiantes.set(index, element);
    }
    
    public void eliminarEstudiante(int index){
        estudiantes.remove(index);
    }
    
    public boolean eliminarEstudiante(Estudiante estudiante){
        for(Materia materia : materias){
            if(materia.eliminarEstudiante(estudiante.getCedula())){
                return true;
            }
        }
        return false;
    }
    
    public Estudiante buscarEstudiante(int cedula){
        Estudiante estudiante;
        for(Materia materia : materias){
            if((estudiante = materia.buscarEstudiante(cedula)) != null)
                return estudiante;
        }
        return null;
    }
    
    public Estudiante buscarEstudiante(Estudiante estudiante){
        return buscarEstudiante(estudiante.getCedula());
    }
    
    public Estudiante getEstudiante(int index){
        if(index >= estudiantes.size())
            return null;
        return estudiantes.get(index);
    }
    
    public boolean compararCedula(int cedula) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getCedula() == cedula)
                return true;
        }
        for(Materia materia : materias){
            if(materia.compararCedula(cedula))
                return true;
        }
        return false;
    }

}

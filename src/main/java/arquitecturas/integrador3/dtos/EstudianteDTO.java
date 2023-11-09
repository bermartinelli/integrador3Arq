package arquitecturas.integrador3.dtos;

import arquitecturas.integrador3.entities.Estudiante;
import jakarta.persistence.Column;

public class EstudianteDTO {

    private int dni;
    private String nombre;
    private String apellido;
    private int edad;
    private String genero;
    private String ciudadResidencia;
    private int lu;


    public EstudianteDTO(){

    }

    public EstudianteDTO(int dni, String nombre, String apellido, int edad, String genero, String ciudadResidencia, int lu) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.ciudadResidencia = ciudadResidencia;
        this.lu = lu;
    }

    public EstudianteDTO(Estudiante e){
        this.dni = e.getDni();
        this.nombre = e.getNombre();
        this.apellido = e.getApellido();
        this.edad = e.getEdad();
        this.genero = e.getGenero();
        this.ciudadResidencia = e.getCiudadResidencia();
        this.lu = e.getLu();
    }

    public int getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public String getGenero() {
        return genero;
    }

    public String getCiudadResidencia() {
        return ciudadResidencia;
    }

    public int getLu() {
        return lu;
    }
}

package arquitecturas.integrador3.dtos;

import arquitecturas.integrador3.entities.Carrera;
import arquitecturas.integrador3.entities.EstudianteCarrera;
import jakarta.persistence.*;

import java.util.Set;

public class CarreraDTO {

    private String nombre;

    private int duracion;

    public CarreraDTO(){}

    public CarreraDTO(Carrera c){
        this.nombre = c.getNombre();
        this.duracion = c.getDuracion();
    }


    public String getNombre() {
        return nombre;
    }

    public int getDuracion() {
        return duracion;
    }
}

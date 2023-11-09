package arquitecturas.integrador3.dtos;

import arquitecturas.integrador3.entities.Carrera;
import arquitecturas.integrador3.entities.Estudiante;
import arquitecturas.integrador3.entities.EstudianteCarrera;
import jakarta.persistence.*;

import java.sql.Timestamp;

public class EstudianteCarreraDTO {
    private Estudiante estudiante;
    private Carrera carrera;
    private Timestamp fechaInscripcion;
    private Timestamp fechaEgreso;
    private boolean graduado;
    private int antiguedad;

    public EstudianteCarreraDTO(){}

    public EstudianteCarreraDTO(EstudianteCarrera entity) {
        this.estudiante = entity.getEstudiante();
        this.carrera = entity.getCarrera();
        this.fechaInscripcion = entity.getFechaInscripcion();
        this.fechaEgreso = entity.getFechaEgreso();
        this.graduado = entity.isGraduado();
        this.antiguedad = entity.getAntiguedad();
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public Timestamp getFechaInscripcion() {
        return fechaInscripcion;
    }

    public Timestamp getFechaEgreso() {
        return fechaEgreso;
    }

    public boolean isGraduado() {
        return graduado;
    }

    public int getAntiguedad() {
        return antiguedad;
    }
}

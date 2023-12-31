package arquitecturas.integrador3.dtos;

import arquitecturas.integrador3.entities.EstudianteCarrera;

public class EstudianteCarreraDTO {
    private int idEstudiante;
    private int idCarrera;
    private int fechaInscripcion;
    private Integer fechaEgreso;
    private boolean graduado;
    private int antiguedad;

    public EstudianteCarreraDTO(){}

    public EstudianteCarreraDTO(EstudianteCarrera entity) {
        this.idEstudiante = entity.getEstudiante().getId();
        this.idCarrera = entity.getCarrera().getId();
        this.fechaInscripcion = entity.getFechaInscripcion();
        this.fechaEgreso = entity.getFechaEgreso();
        this.graduado = entity.isGraduado();
        this.antiguedad = entity.getAntiguedad();
    }



    public int getFechaInscripcion() {
        return fechaInscripcion;
    }

    public Integer getFechaEgreso() {
        return fechaEgreso;
    }

    public boolean isGraduado() {
        return graduado;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public int getIdCarrera() {
        return idCarrera;
    }
}

package arquitecturas.integrador3.dtos;

import arquitecturas.integrador3.entities.EstudianteCarrera;

public class EstudianteCarreraResponseDTO {
    private int idEstudiante;
    private int idCarrera;
    private int fechaInscripcion;

    private Integer fechaEgreso;



    public EstudianteCarreraResponseDTO(){}

    public EstudianteCarreraResponseDTO(EstudianteCarrera entity) {
        this.idEstudiante = entity.getEstudiante().getId();
        this.idCarrera = entity.getCarrera().getId();
        this.fechaInscripcion = entity.getFechaInscripcion();
        this.fechaEgreso = entity.getFechaEgreso();
    }


    public int getFechaInscripcion() {
        return fechaInscripcion;
    }

    public Integer getFechaEgreso() {
        return fechaEgreso;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public int getIdCarrera() {
        return idCarrera;
    }
}

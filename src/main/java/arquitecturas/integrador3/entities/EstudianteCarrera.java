package arquitecturas.integrador3.entities;

import arquitecturas.integrador3.dtos.EstudianteCarreraDTO;
import jakarta.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;

@Entity
@Table(name = "estudiante_carrera")
public class EstudianteCarrera {

    @Id
    @ManyToOne(targetEntity = Estudiante.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "estudiante_id", nullable = false)
    private Estudiante estudiante;

    @Id
    @ManyToOne(targetEntity = Carrera.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "carrera_id", nullable = false)
    private Carrera carrera;

    @Column(name = "fecha_inscripcion")
    private Timestamp fechaInscripcion;

    @Column(name = "fecha_egreso")
    private Timestamp fechaEgreso;

    @Column
    private boolean graduado;

    private int antiguedad;

    public EstudianteCarrera(){

    }

    public EstudianteCarrera(Estudiante e, Carrera c, Timestamp fechaInscripcion, Timestamp fechaEgreso){
        this.estudiante = e;
        this.carrera =c;
        this.fechaInscripcion = fechaInscripcion;
        this.fechaEgreso = fechaEgreso;
        this.antiguedad = this.getAntiguedad(fechaInscripcion);
        this.graduado = this.esGraduado(fechaEgreso);
    }

    public EstudianteCarrera(EstudianteCarreraDTO dto){
        this.estudiante = dto.getEstudiante();
        this.carrera =dto.getCarrera();
        this.fechaInscripcion = dto.getFechaInscripcion();
        this.fechaEgreso = dto.getFechaEgreso();
        this.antiguedad = dto.getAntiguedad();
        this.graduado = dto.isGraduado();
    }

    public int getAntiguedad(Timestamp fechaInscripcion){
        Calendar inscripcion = Calendar.getInstance();
        inscripcion.setTimeInMillis(this.fechaInscripcion.getTime());
        return Calendar.getInstance().get(Calendar.YEAR) - fechaInscripcion.getYear();
    }


    public boolean esGraduado(Timestamp fechaEgreso) {
        if(fechaEgreso != null) {
            return true;}
            else {return false;
        }
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

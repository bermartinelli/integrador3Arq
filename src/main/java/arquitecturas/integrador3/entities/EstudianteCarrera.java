package arquitecturas.integrador3.entities;

import arquitecturas.integrador3.dtos.EstudianteCarreraDTO;
import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Time;
import java.util.Calendar;
import java.util.Optional;

@Entity
@Table(name = "estudiante_carrera")
public class EstudianteCarrera implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = Estudiante.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "estudiante_id", nullable = false)
    private Estudiante estudiante;

    @ManyToOne(targetEntity = Carrera.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "carrera_id", nullable = false)
    private Carrera carrera;

    @Column(name = "fecha_inscripcion")
    private int fechaInscripcion;

    @Column(name = "fecha_egreso")
    private Integer fechaEgreso;

    @Column
    private boolean graduado;

    private int antiguedad;

    public EstudianteCarrera(){

    }

    public EstudianteCarrera(Estudiante e, Carrera c, Integer fechaInscripcion, Integer fechaEgreso){
        this.estudiante = e;
        this.carrera =c;
        this.fechaInscripcion = fechaInscripcion;
        this.fechaEgreso = fechaEgreso;
        this.antiguedad = this.getAntiguedad(fechaInscripcion);
        this.graduado = this.esGraduado(fechaEgreso);
    }

    public EstudianteCarrera(Estudiante e, Carrera c, Integer fechaInscripcion){
        this.estudiante = e;
        this.carrera =c;
        this.fechaInscripcion = fechaInscripcion;
        this.antiguedad = this.getAntiguedad(fechaInscripcion);
        this.graduado = this.esGraduado(fechaEgreso);
    }


    public EstudianteCarrera(EstudianteCarreraDTO dto){
        //tengo que de alguna manera encontrar el estudiante y la carrera por dni y por lu que es lo que me viene del DTO.
        //this.estudiante = dto.getEstudiante();
        //this.carrera =dto.getCarrera();
        this.fechaInscripcion = dto.getFechaInscripcion();
        this.fechaEgreso = dto.getFechaEgreso();
        this.antiguedad = dto.getAntiguedad();
        this.graduado = dto.isGraduado();
    }

    public int getAntiguedad(Integer fechaInscripcion){
        Calendar inscripcion = Calendar.getInstance();
        return Calendar.getInstance().get(Calendar.YEAR) - fechaInscripcion;
    }


    public boolean esGraduado(Integer fechaEgreso) {
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
}

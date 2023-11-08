package arquitecturas.integrador3.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Carrera {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "carrera_id")
    private int id;
    @Column
    private String nombre;

    @Column
    private int duracion;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "carrera")
    private Set<EstudianteCarrera> estudiantes;

    public Carrera(){
    }

    public Carrera(String nombre, int duracion){
        this.nombre = nombre;
        this.duracion = duracion;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    public Set<EstudianteCarrera> getEstudiantes() {
        return estudiantes;
    }
}

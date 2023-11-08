package arquitecturas.integrador3.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Estudiante {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column (name = "estudiante_id")
    private int id;

    @Column
    private int dni;

    @Column
    private String nombre;

    @Column
    private String apellido;

    @Column
    private int edad;

    @Column
    private String genero;

    @Column (name="ciudad")
    private String ciudadResidencia;

    @Column
    private int lu;

    @OneToMany (fetch = FetchType.LAZY, mappedBy = "estudiante")
    private Set<EstudianteCarrera> carreras;

    public Estudiante() {
    }


    public int getId() {
        return id;
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

    public Set<EstudianteCarrera> getCarreras() {
        return carreras;
    }
}

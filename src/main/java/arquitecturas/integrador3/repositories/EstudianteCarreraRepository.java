package arquitecturas.integrador3.repositories;

import arquitecturas.integrador3.dtos.ReporteCarreraDTO;
import arquitecturas.integrador3.entities.Carrera;
import arquitecturas.integrador3.entities.Estudiante;
import arquitecturas.integrador3.entities.EstudianteCarrera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudianteCarreraRepository extends JpaRepository<EstudianteCarrera, Integer> {

    //f) recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos.
    @Query ("SELECT c FROM EstudianteCarrera ec JOIN ec.carrera c GROUP BY ec.carrera ORDER BY COUNT(ec.estudiante) DESC")
    List<Carrera> getCarrerasConInscriptos();

    //g) recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia.
    @Query("SELECT e FROM Estudiante e JOIN e.carreras ec WHERE e.ciudadResidencia = :ciudad AND ec.carrera = :c GROUP BY ec.carrera")
    List<Estudiante> getEstudiantesPorCarreraCiudad(Carrera c, String ciudad);

    //h) generar un reporte de las carreras, que para cada carrera incluya información de los inscriptos y egresados por año.
    // Se deben ordenar las carreras alfabéticamente, y presentar los años de manera cronológica.

    @Query("SELECT c.nombre, eca.fechaInscripcion, COUNT(eca.estudiante), SUM(CASE WHEN eca.fechaEgreso IS NOT NULL THEN 1 ELSE 0 END) FROM Carrera c LEFT JOIN c.estudiantes eca GROUP BY c.nombre, eca.fechaInscripcion ORDER BY c.nombre ASC, eca.fechaInscripcion ASC")
    ReporteCarreraDTO getReporteCarreras();

}

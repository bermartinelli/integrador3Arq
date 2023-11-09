package arquitecturas.integrador3.repositories;

import arquitecturas.integrador3.entities.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {

    //c) recuperar todos los estudiantes, y especificar algún criterio de ordenamiento simple.
    @Query("SELECT e FROM Estudiante e ORDER BY e.lu ASC")
    List<Estudiante> OrdenarEstudiantesPorLU();

    //d) recuperar un estudiante, en bas ea sunúmero de libreta universitaria.
    //@Query("SELECT e FROM Estudiante E WHERE e.lu = :lu")
    Estudiante getEstudianteByLu(int lu);

    //e) recuperar todos los estudiantes, en base a su género.
    @Query("SELECT e FROM Estudiante e WHERE e.genero = :genero ORDER BY e.apellido DESC")
    List<Estudiante> getEstudiantesPorGenero(String genero);

}

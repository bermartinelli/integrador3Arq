package arquitecturas.integrador3.repositories;

import arquitecturas.integrador3.entities.Carrera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarreraRepository extends JpaRepository<Carrera, Integer> {

    //f) recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos.

}

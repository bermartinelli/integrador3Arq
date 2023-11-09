package arquitecturas.integrador3.repositories;

import arquitecturas.integrador3.entities.Carrera;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarreraRepository extends JpaRepository<Carrera, Integer> {

    Carrera getCarreraByNombre(String nombre);
}

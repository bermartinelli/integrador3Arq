package arquitecturas.integrador3.services;

import arquitecturas.integrador3.dtos.CarreraDTO;
import arquitecturas.integrador3.dtos.EstudianteDTO;
import arquitecturas.integrador3.entities.Carrera;
import arquitecturas.integrador3.entities.Estudiante;
import arquitecturas.integrador3.repositories.CarreraRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class CarreraService{
    @Autowired
    CarreraRepository repository;

    @Transactional
    public CarreraDTO save(CarreraDTO request){
        final var carrera = new Carrera(request);
        final var response = this.repository.save(carrera);
        return new CarreraDTO(response);
    }
}

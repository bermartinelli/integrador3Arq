package arquitecturas.integrador3.services;

import arquitecturas.integrador3.dtos.*;
import arquitecturas.integrador3.entities.Carrera;
import arquitecturas.integrador3.entities.Estudiante;
import arquitecturas.integrador3.entities.EstudianteCarrera;
import arquitecturas.integrador3.repositories.CarreraRepository;
import arquitecturas.integrador3.repositories.EstudianteCarreraRepository;
import arquitecturas.integrador3.repositories.EstudianteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteCarreraService {

    @Autowired
    EstudianteCarreraRepository repository;
    @Autowired
    CarreraRepository carreraRepository;
    @Autowired
    EstudianteRepository estudianteRepository;

    @Transactional
    public EstudianteCarreraResponseDTO save(EstudianteCarreraResponseDTO request) throws Exception{
        try {
            Optional<Estudiante> est = estudianteRepository.findById(request.getIdEstudiante());
            Optional<Carrera> carr = carreraRepository.findById(request.getIdCarrera());

            if (!est.isPresent() || !est.isPresent()){
                throw new Exception("El estudiante o la carrera no existen en el sistema");
            }

            final var estudianteCarrera = new EstudianteCarrera(est.get(), carr.get(), request.getFechaInscripcion(), request.getFechaEgreso());
            final var response = repository.save(estudianteCarrera);
            return new EstudianteCarreraResponseDTO(response);
        } catch (Exception e){
            System.out.print("HOLA chau");

            throw new Exception("Error al gaurdar el DTO");
        }
    }

    @Transactional
    public List<CarreraDTO> getCarrerasConInscriptos() throws Exception{
        var resultado = repository.getCarrerasConInscriptos();
        try{
            return resultado.stream().map(CarreraDTO::new).toList();
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public List<EstudianteDTO> getEstudiantesCarreraCiudad(String carrera, String ciudad) throws Exception{
        Carrera entity = carreraRepository.getCarreraByNombre(carrera);
        var result = repository.getEstudiantesPorCarreraCiudad(entity.getNombre(), ciudad);
        try{
            return result.stream().map(EstudianteDTO::new).toList();
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public ReporteCarreraDTO getReporte() throws Exception{
        try {
            return repository.getReporteCarreras();
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}

package arquitecturas.integrador3.services;

import arquitecturas.integrador3.dtos.CarreraDTO;
import arquitecturas.integrador3.dtos.EstudianteCarreraDTO;
import arquitecturas.integrador3.dtos.EstudianteDTO;
import arquitecturas.integrador3.dtos.ReporteCarreraDTO;
import arquitecturas.integrador3.entities.Carrera;
import arquitecturas.integrador3.entities.EstudianteCarrera;
import arquitecturas.integrador3.repositories.CarreraRepository;
import arquitecturas.integrador3.repositories.EstudianteCarreraRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteCarreraService {

    @Autowired
    EstudianteCarreraRepository repository;
    CarreraRepository carreraRepository;

    @Transactional
    public EstudianteCarreraDTO save(EstudianteCarreraDTO request){
        final var estudianteCarrera = new EstudianteCarrera(request);
        final var response = repository.save(estudianteCarrera);
        return new EstudianteCarreraDTO(response);
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
        var result = repository.getEstudiantesPorCarreraCiudad(entity, ciudad);
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

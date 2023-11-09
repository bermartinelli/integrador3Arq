package arquitecturas.integrador3.services;

import arquitecturas.integrador3.dtos.EstudianteDTO;
import arquitecturas.integrador3.entities.Estudiante;
import arquitecturas.integrador3.repositories.EstudianteRepository;
import jakarta.transaction.TransactionScoped;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository repository;

    @Transactional
    public EstudianteDTO save(EstudianteDTO request){
        final var estudiante = new Estudiante(request);
        final var response = this.repository.save(estudiante);
        return new EstudianteDTO(response);
    }

    @Transactional
    public List<EstudianteDTO> findEstudiantesByGenero(String genero) throws Exception {
        var resultado =  this.repository.getEstudiantesPorGenero(genero);
        try{
            return resultado.stream().map(EstudianteDTO::new).toList();
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public EstudianteDTO getEstudianteByLu(int lu) throws Exception {
        Estudiante result = repository.getEstudianteByLu(lu);
        try{
            return new EstudianteDTO(result);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public List<EstudianteDTO> getEstudiantesOrdenadosPorLu() throws Exception{
        var resultado =  this.repository.OrdenarEstudiantesPorLU();
        try{
            return resultado.stream().map(EstudianteDTO::new).toList();
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }



}

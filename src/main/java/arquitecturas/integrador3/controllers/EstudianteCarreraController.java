package arquitecturas.integrador3.controllers;

import arquitecturas.integrador3.dtos.EstudianteCarreraDTO;
import arquitecturas.integrador3.entities.EstudianteCarrera;
import arquitecturas.integrador3.services.EstudianteCarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/matriculados")
public class EstudianteCarreraController {

    @Autowired
    EstudianteCarreraService service;

    @PostMapping("")
    ResponseEntity<?> nuevaMatricula(@RequestBody EstudianteCarreraDTO dto){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.save(dto));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("NO SE PUDO MATRICULAR");
        }
    }

    @GetMapping("/carreras")
    ResponseEntity<?> getCarreraConInscriptos(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.getCarrerasConInscriptos());
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NO SE PUDO OBTENER");
        }
    }

    @GetMapping("/{carrera}&{ciudad}")
    ResponseEntity<?> getEstudiantesCarreraCiudad(@PathVariable String carrera, @PathVariable String ciudad){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.getEstudiantesCarreraCiudad(carrera, ciudad));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NO SE PUDO OBTENER");
        }
    }

    @GetMapping("/reporte")
    ResponseEntity<?> getReporteCarreras() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.getReporte());
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NO SE PUDO OBTENER");
        }
    }
}

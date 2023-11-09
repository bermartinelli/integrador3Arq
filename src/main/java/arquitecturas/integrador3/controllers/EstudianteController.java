package arquitecturas.integrador3.controllers;

import arquitecturas.integrador3.dtos.EstudianteDTO;
import arquitecturas.integrador3.services.EstudianteService;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    EstudianteService service;

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody EstudianteDTO request){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.save(request));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("NO SE PUDO CARGAR");
        }
    }

    @GetMapping("/listar/genero/{genero}")
    public ResponseEntity<?> getEstudiantesPorGenero(@PathVariable String genero){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.findEstudiantesByGenero(genero));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NO ENCONTRADO");
        }
    }

    @GetMapping("/lu/{lu}")
    public ResponseEntity<?> getEstudiantesPorLU(@PathVariable int lu){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.getEstudianteByLu(lu));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NO ENCONTRADO");
        }
    }

    @GetMapping("listar/lu")
        public ResponseEntity<?> getPorLu(){
            try {
                return ResponseEntity.status(HttpStatus.OK).body(service.getEstudiantesOrdenadosPorLu());
            } catch (Exception e){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NO ENCONTRADO");
            }
        }
}

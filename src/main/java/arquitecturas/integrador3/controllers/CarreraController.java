package arquitecturas.integrador3.controllers;

import arquitecturas.integrador3.dtos.CarreraDTO;
import arquitecturas.integrador3.dtos.EstudianteDTO;
import arquitecturas.integrador3.services.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/carreras")
public class CarreraController {

    @Autowired
    CarreraService service;

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody CarreraDTO request){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.save(request));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("NO SE PUDO CARGAR");
        }
    }

}
package edu.eci.arsw.myecischeduale.rest;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.arsw.myecischeduale.model.Scheduale;
import edu.eci.arsw.myecischeduale.service.SchedualeService;

@RestController
@RequestMapping("/api/scheduale")
public class SchedualeREST {
    
    @Autowired
    private SchedualeService schedualeService;

    @PostMapping
    private ResponseEntity<Scheduale> save (@RequestBody Scheduale scheduale){
        Scheduale temp = schedualeService.create(scheduale);
        try {
            return ResponseEntity.created(new URI("/api/scheduale"+temp.getId())).body(temp);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping
    private ResponseEntity<?> getAllScheduales (){
        try {
            List<Scheduale> data = schedualeService.getAllScheduales();
            return new ResponseEntity<>(data, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error al obtener los horarios", HttpStatus.NOT_FOUND);
        }
        
        
    }
}

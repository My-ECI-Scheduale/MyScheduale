package edu.eci.arsw.myecischeduale.rest;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.arsw.myecischeduale.model.Assignature;
import edu.eci.arsw.myecischeduale.model.AssignatureXScheduale;
import edu.eci.arsw.myecischeduale.model.CDate;
import edu.eci.arsw.myecischeduale.model.Scheduale;
import edu.eci.arsw.myecischeduale.service.AssignaturexSchedualeService;
import edu.eci.arsw.myecischeduale.service.CDateService;
import edu.eci.arsw.myecischeduale.service.SchedualeService;

@RestController
@RequestMapping("/api/scheduale")
public class SchedualeREST {

    @Autowired
    private SchedualeService schedualeService;
    @Autowired
    private AssignaturexSchedualeService assignaturexSchedualeService;
    @Autowired
    private CDateService cDateService;

    @PostMapping
    private ResponseEntity<Scheduale> save(@RequestBody Scheduale scheduale) {
        Scheduale temp = schedualeService.create(scheduale);
        try {
            return ResponseEntity.created(new URI("/api/scheduale" + temp.getId())).body(temp);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping
    private ResponseEntity<?> getAllScheduales() {
        try {
            List<Scheduale> data = schedualeService.getAllScheduales();
            return new ResponseEntity<>(data, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error al obtener los horarios", HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/one")
    private ResponseEntity<List<Assignature>> getScheduale() {
        try {
            List<AssignatureXScheduale> temp = assignaturexSchedualeService.getwithSchedualeID((long) 0);
            List<Assignature> res = new ArrayList<>();
            for (AssignatureXScheduale a : temp) {
                res.add(a.getAssignatureId());
            }
            return ResponseEntity.ok(res);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/assiganture")
    private ResponseEntity<List<CDate>> getAssignatureDAte(@PathParam("id")Long id){
        try {
            List<CDate> dias = cDateService.getCDates(id);
            return ResponseEntity.ok(dias);
        }catch(Exception e)
        {
        e.printStackTrace();
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

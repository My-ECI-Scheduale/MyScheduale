package edu.eci.arsw.myecischeduale.rest;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.arsw.myecischeduale.model.Schedule;
import edu.eci.arsw.myecischeduale.service.ScheduleService;

@RestController
@RequestMapping("/api/schedule")
public class ScheduleREST {
    
    @Autowired
    private ScheduleService scheduleService;

    @PostMapping
    private ResponseEntity<Schedule> guardar (@RequestBody Schedule schedule){
        Schedule temp = scheduleService.create(schedule);
        try {
            return ResponseEntity.created(new URI("/api/schedule"+temp.getId())).body(temp);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}

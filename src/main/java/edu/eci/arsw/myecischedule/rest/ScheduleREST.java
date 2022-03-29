package edu.eci.arsw.myecischedule.rest;

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

import edu.eci.arsw.myecischedule.model.Assignature;
import edu.eci.arsw.myecischedule.model.AssignatureXSchedule;
import edu.eci.arsw.myecischedule.model.CDate;
import edu.eci.arsw.myecischedule.model.Schedule;
import edu.eci.arsw.myecischedule.service.AssignaturexScheduleService;
import edu.eci.arsw.myecischedule.service.CDateService;
import edu.eci.arsw.myecischedule.service.ScheduleService;

@RestController
@RequestMapping("/api/schedule")
public class ScheduleREST {

    @Autowired
    private ScheduleService scheduleService;
    @Autowired
    private AssignaturexScheduleService assignaturexScheduleService;
    @Autowired
    private CDateService cDateService;

    @PostMapping
    private ResponseEntity<Schedule> save(@RequestBody Schedule schedule) {
        Schedule temp = scheduleService.create(schedule);
        try {
            return ResponseEntity.created(new URI("/api/schedule" + temp.getId())).body(temp);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping
    private ResponseEntity<?> getAllSchedules() {
        try {
            List<Schedule> data = scheduleService.getAllSchedules();
            return new ResponseEntity<>(data, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error al obtener los horarios", HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/one")
    private ResponseEntity<List<Assignature>> getSchedule() {
        try {
            List<AssignatureXSchedule> temp = assignaturexScheduleService.getwithScheduleID((long) 0);
            List<Assignature> res = new ArrayList<>();
            for (AssignatureXSchedule a : temp) {
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

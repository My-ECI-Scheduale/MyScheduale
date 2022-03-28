package edu.eci.arsw.myecischeduale.rest;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.arsw.myecischeduale.model.Task;
import edu.eci.arsw.myecischeduale.service.TaskService;

@RestController
@RequestMapping("/api/task")
public class TaskREST {

    @Autowired
    private TaskService taskService;

    @PostMapping
    private ResponseEntity<Task> save (@RequestBody Task task) {
        Task temp = taskService.create(task);
        try {
            return ResponseEntity.created(new URI("/api/task"+temp.getId())).body(temp);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping
    private ResponseEntity<?> getAllTasks (){
        try {
            List<Task> tasks = taskService.getAllTasks();
            return new ResponseEntity<>(tasks, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error al obtener los horarios",HttpStatus.NOT_FOUND);
        }
    }

    /*@PostMapping
    private ResponseEntity<Optional<Task>> getTaskByKanabanColumn(@PathParam("estado")String estado) {
        Optional<Task> tasks = taskService.findByKanbanName(estado);
        try {
            return ResponseEntity.created(new URI("/api/task"+estado)).body(tasks);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }*/
}

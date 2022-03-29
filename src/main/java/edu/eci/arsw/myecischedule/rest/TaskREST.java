package edu.eci.arsw.myecischedule.rest;

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

import edu.eci.arsw.myecischedule.model.Task;
import edu.eci.arsw.myecischedule.service.TaskService;

@RestController
@RequestMapping("/api/task")
public class TaskREST {

    @Autowired
    private TaskService taskService;

    @PostMapping("/save")
    private ResponseEntity<Boolean> save (@RequestBody Task task) {
        try {
            taskService.create(task);
            return ResponseEntity.ok(true);
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

    @GetMapping("/getByColumn")
    private ResponseEntity<List<Task>> getTaskByKanabanColumn(@PathParam("id")Long id) {
        List<Task> respuesta = taskService.findByIdKanbanColumn(id);
        return ResponseEntity.ok(respuesta);
    }
}

package edu.eci.arsw.myecischedule.rest;

import java.util.List;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.arsw.myecischedule.model.Customer;
import edu.eci.arsw.myecischedule.model.KanbanColumn;
import edu.eci.arsw.myecischedule.model.Packet;
import edu.eci.arsw.myecischedule.model.Task;
import edu.eci.arsw.myecischedule.service.CustomerService;
import edu.eci.arsw.myecischedule.service.KanbanColumnService;
import edu.eci.arsw.myecischedule.service.TaskService;

@RestController
@RequestMapping("/api/task")
public class TaskREST {

    @Autowired
    private TaskService taskService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private KanbanColumnService kanbanColumnService;

    @CrossOrigin
    @PostMapping("/save")
    private ResponseEntity<Boolean> save(@RequestBody Task task) {
        try {
            taskService.create(task);
            return ResponseEntity.ok(true);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @CrossOrigin
    @PostMapping("/create")
    private ResponseEntity<Packet> save(@PathParam("idcus") Long idcus, @PathParam("idcolum") Long idcolum) {
        try {
            Customer cus = customerService.findById(idcus).get();
            KanbanColumn kan = kanbanColumnService.findById(idcolum).get();
            Task temp = new Task(kan, cus, true, "");
            Task temp2 = taskService.createP(temp);
            Packet res = new Packet('E', temp2.getIdKanbanColumn().getId(), temp2.getIdCustomer().getName(),
                    temp2.getId(), temp2.getDescription(), temp2.isPublic(), temp2.getIdCustomer().getId());
            return ResponseEntity.ok(res);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @CrossOrigin
    @GetMapping
    private ResponseEntity<?> getAllTasks() {
        try {
            List<Task> tasks = taskService.getAllTasks();
            return new ResponseEntity<>(tasks, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error al obtener los horarios", HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin
    @GetMapping("/getByColumn")
    private ResponseEntity<List<Task>> getTaskByKanabanColumn(@PathParam("id") Long id) {
        List<Task> respuesta = taskService.findByIdKanbanColumn(id);
        return ResponseEntity.ok(respuesta);
    }
}

package edu.eci.arsw.myecischedule.rest;
import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.eci.arsw.myecischedule.model.KanbanColumn;
import edu.eci.arsw.myecischedule.model.Task;
import edu.eci.arsw.myecischedule.service.KanbanService;
import edu.eci.arsw.myecischedule.service.TaskService;

@RestController
@RequestMapping("/api/kanban")
public class KanbanREST {
    
    @Autowired
    private KanbanService kanbanService;

    @Autowired
    private TaskService taskService;

    @GetMapping("/getById")
    private ResponseEntity<List<Task>> getKanbanColumns(@PathParam("id")Long id){
        ArrayList<Task> result = new ArrayList<>();
        List<KanbanColumn> columns = kanbanService.getKanbanColumns(id);
        for (KanbanColumn col : columns) {
            result.addAll(taskService.findByIdKanbanColumn(col.getId()));
        }
        return ResponseEntity.ok(result);
    }
}

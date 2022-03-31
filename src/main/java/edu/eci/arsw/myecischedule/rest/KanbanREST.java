package edu.eci.arsw.myecischedule.rest;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.eci.arsw.myecischedule.model.KanbanColumn;
import edu.eci.arsw.myecischedule.service.KanbanService;

@RestController
@RequestMapping("/api/kanban")
public class KanbanREST {
    
    @Autowired
    private KanbanService kanbanService;


    @GetMapping("/getById")
    private ResponseEntity<List<KanbanColumn>> getKanbanColumns(@PathParam("id")Long id){
        List<KanbanColumn> columns = kanbanService.getKanbanColumns(id);
        return ResponseEntity.ok(columns);
    }
}

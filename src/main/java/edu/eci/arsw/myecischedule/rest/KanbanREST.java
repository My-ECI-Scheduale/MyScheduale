package edu.eci.arsw.myecischedule.rest;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.eci.arsw.myecischedule.model.KanbanColumn;
import edu.eci.arsw.myecischedule.model.Packet;
import edu.eci.arsw.myecischedule.model.Task;
import edu.eci.arsw.myecischedule.repository.CustomerRepository;
import edu.eci.arsw.myecischedule.repository.KanbanColumnRepository;
import edu.eci.arsw.myecischedule.repository.TaskRepository;
import edu.eci.arsw.myecischedule.service.KanbanService;

@RestController
@RequestMapping("/api/kanban")
public class KanbanREST {
    
    @Autowired
    private KanbanService kanbanService;
    @Autowired
	SimpMessagingTemplate msgt;
    @Autowired
    KanbanColumnRepository kanbanColumnRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    TaskRepository taskRepository;

    @GetMapping("/getById")
    private ResponseEntity<List<KanbanColumn>> getKanbanColumns(@PathParam("id")Long id){
        List<KanbanColumn> columns = kanbanService.getKanbanColumns(id);
        return ResponseEntity.ok(columns);
    }
    @PostMapping("/kanban.{num}")
    private void momPost(@RequestBody Packet ts ,@DestinationVariable String num){
        System.out.println(ts.toString());
        if(ts.getAction() != 'D'){
            msgt.convertAndSend("/topic/kanban."+num,ts);
            Task temp = taskRepository.getTask(ts.getIdtask());
            temp.setDescription(ts.getDescription());
            temp.setPublic(ts.isIpublic());
            if(ts.getIdcolumn()!=temp.getIdKanbanColumn().getId()){
                temp.setIdKanbanColumn(kanbanColumnRepository.getById(ts.getIdcolumn()));
            }
            taskRepository.save(temp);
        }else{
            msgt.convertAndSend("/topic/kanban."+num, ts);
            taskRepository.deleteById(ts.getIdtask());
        }
    }
}

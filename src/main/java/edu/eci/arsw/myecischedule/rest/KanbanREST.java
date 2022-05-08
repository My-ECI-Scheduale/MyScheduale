package edu.eci.arsw.myecischedule.rest;

import java.util.List;
import javax.websocket.server.PathParam;

import com.azure.messaging.webpubsub.WebPubSubServiceClient;
import com.azure.messaging.webpubsub.WebPubSubServiceClientBuilder;
import com.azure.messaging.webpubsub.models.WebPubSubContentType;
import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import edu.eci.arsw.myecischedule.model.KanbanColumn;
import edu.eci.arsw.myecischedule.model.Packet;
import edu.eci.arsw.myecischedule.model.Task;
import edu.eci.arsw.myecischedule.repository.CustomerRepository;
import edu.eci.arsw.myecischedule.repository.KanbanColumnRepository;
import edu.eci.arsw.myecischedule.repository.ModificationLogRepository;
import edu.eci.arsw.myecischedule.repository.TaskRepository;
import edu.eci.arsw.myecischedule.service.KanbanService;
import edu.eci.arsw.myecischedule.service.ModificationLogService;

@RestController
public class KanbanREST {

    static String connectionString = "Endpoint=https://topicmyecischedule.webpubsub.azure.com;AccessKey=yPArJMo6qAU6hHL3DO9XMd7+xyxoux8QBo3CkzJabYY=;Version=1.0;";
    static String hub = "schedule";
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
    @Autowired
    ModificationLogRepository modificationLogRepository;

    @CrossOrigin
    @GetMapping("/api/kanban/getById")
    private ResponseEntity<List<KanbanColumn>> getKanbanColumns(@PathParam("id") Long id) {
        List<KanbanColumn> columns = kanbanService.getKanbanColumns(id);
        return ResponseEntity.ok(columns);
    }

    @CrossOrigin
    @PostMapping("/api/kanban")
    private void momPost(@RequestBody Packet ts) {
        logs(ts);
        if (ts.getAction() != 'D') {
            sendtoTopic(ts);
            Task temp = taskRepository.getTask(ts.getIdtask());
            temp.setDescription(ts.getDescription());
            temp.setPublic(ts.isIpublic());
            if (ts.getIdcolumn() != temp.getIdKanbanColumn().getId()) {
                temp.setIdKanbanColumn(kanbanColumnRepository.getById(ts.getIdcolumn()));
            }
            taskRepository.save(temp);
        } else {
            sendtoTopic(ts);
            taskRepository.deleteById(ts.getIdtask());
        }
    }

    private void logs(Packet ts) {
        ModificationLogService t = new ModificationLogService();
        t.setModificationLog(ts);
        t.setModificationLogRepository(modificationLogRepository);
        t.start();
    }

    private void sendtoTopic(Packet ts) {
        WebPubSubServiceClient webPubSubServiceClient = new WebPubSubServiceClientBuilder()
                .connectionString(connectionString)
                .hub(hub)
                .buildClient();
        webPubSubServiceClient.sendToAll(new Gson().toJson(ts), WebPubSubContentType.APPLICATION_JSON);
    }
}

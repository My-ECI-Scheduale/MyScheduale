package edu.eci.arsw.myecischedule.rest;

import java.util.List;
import javax.websocket.server.PathParam;

import com.azure.messaging.servicebus.ServiceBusClientBuilder;
import com.azure.messaging.servicebus.ServiceBusMessage;
import com.azure.messaging.servicebus.ServiceBusSenderClient;
import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import edu.eci.arsw.myecischedule.model.KanbanColumn;
import edu.eci.arsw.myecischedule.model.Packet;
import edu.eci.arsw.myecischedule.model.Task;
import edu.eci.arsw.myecischedule.repository.CustomerRepository;
import edu.eci.arsw.myecischedule.repository.KanbanColumnRepository;
import edu.eci.arsw.myecischedule.repository.TaskRepository;
import edu.eci.arsw.myecischedule.service.KanbanService;

@RestController
public class KanbanREST {

    static String connectionString = "Endpoint=sb://myecischedule.servicebus.windows.net/;SharedAccessKeyName=RootManageSharedAccessKey;SharedAccessKey=lpgUwYkLzW82790Avf9OGBfStIelBGgkw8zr5BmtS/E=";
    static String topicName = "topicosmyecischeduale";
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

    @GetMapping("/api/kanban/getById")
    private ResponseEntity<List<KanbanColumn>> getKanbanColumns(@PathParam("id") Long id) {
        List<KanbanColumn> columns = kanbanService.getKanbanColumns(id);
        return ResponseEntity.ok(columns);
    }

    @PostMapping("/api/kanban")
    private void momPost(@RequestBody Packet ts) {
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

    private void sendtoTopic(Packet ts) {
        System.out.println("entro");
        // create a Service Bus Sender client for the queue
        ServiceBusSenderClient senderClient = new ServiceBusClientBuilder()
                .connectionString(connectionString)
                .sender()
                .topicName(topicName)
                .buildClient();

        // send one message to the topic
        ServiceBusMessage bus = new ServiceBusMessage(new Gson().toJson(ts));
        bus.setContentType("application/json");
        senderClient.sendMessage(bus);
    }
}

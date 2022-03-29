package edu.eci.arsw.myecischedule;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.*;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.*;
import edu.eci.arsw.myecischedule.model.KanbanColumn;
import edu.eci.arsw.myecischedule.model.Task;
import edu.eci.arsw.myecischedule.repository.CustomerRepository;
import edu.eci.arsw.myecischedule.repository.KanbanColumnRepository;
import edu.eci.arsw.myecischedule.repository.TaskRepository;

@Controller
public class STOMPMessagesHandler {

	@Autowired
	SimpMessagingTemplate msgt;
    @Autowired
    KanbanColumnRepository kanbanColumnRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    TaskRepository taskRepository;

	@MessageMapping("/kanban.{num}")
	public synchronized void handlePointEvent(Task ts ,@DestinationVariable String num,@PathParam("idcolumn")Long idColumn) throws Exception {
        System.out.println(ts.toString());
        KanbanColumn k = kanbanColumnRepository.getById(idColumn);
        Task temp = taskRepository.getById(ts.getId());
        ts.setIdCustomer(temp.getIdCustomer());
        ts.setLastDate(temp.getLastDate());
        ts.setCreationDate(temp.getCreationDate());
        ts.setIdKanbanColumn(k);
		msgt.convertAndSend("/topic/kanban."+num, ts);
        taskRepository.save(ts);
	}
}

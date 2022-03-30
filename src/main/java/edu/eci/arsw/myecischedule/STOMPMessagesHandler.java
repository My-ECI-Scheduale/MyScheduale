package edu.eci.arsw.myecischedule;

import org.springframework.beans.factory.annotation.*;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.*;
import edu.eci.arsw.myecischedule.model.Packet;
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
	public synchronized void handlePointEvent(Packet ts ,@DestinationVariable String num) throws Exception {
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

package edu.eci.arsw.myecischedule;

import org.springframework.beans.factory.annotation.*;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.*;
import edu.eci.arsw.myecischedule.model.KanbanColumn;
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
            KanbanColumn k = kanbanColumnRepository.getById(ts.getIdcolumn());
            System.out.println("XDXDXDXDXDXDXDXDXDXDXDXD"+ts.getTask().getId());
            Task temp = taskRepository.getTask(ts.getTask().getId());
            System.out.println("XDXDXDXDXDXDXDXDXDXDXDXD");
            System.out.println(temp.toString());
            ts.getTask().setIdCustomer(temp.getIdCustomer());
            System.out.println("XDXDXDXDXDXDXDXDXDXDXDXD");
            ts.getTask().setIdKanbanColumn(k);
            taskRepository.save(ts.getTask());
            msgt.convertAndSend("/topic/kanban."+num, ts);
        }else{
            msgt.convertAndSend("/topic/kanban."+num, ts);
            taskRepository.deleteById(ts.getTask().getId());
        }
	}
}

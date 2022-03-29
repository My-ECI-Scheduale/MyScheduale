package edu.eci.arsw.myecischedule.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arsw.myecischedule.model.Task;
import edu.eci.arsw.myecischedule.repository.TaskRepository;

@Service
public class TaskService {
    
    @Autowired
    private TaskRepository taskRepository;

    public void create (Task task){
        taskRepository.save(task);
    }

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public void delete(Task task){
        taskRepository.delete(task);
    }

    public Optional<Task> findById(Long id){
        return taskRepository.findById(id);
    }

    public List<Task> findByIdKanbanColumn(Long id) {
        return taskRepository.findByIdKanbanColumn(id);
    }
}

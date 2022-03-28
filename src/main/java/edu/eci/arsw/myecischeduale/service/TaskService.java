package edu.eci.arsw.myecischeduale.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arsw.myecischeduale.model.Task;
import edu.eci.arsw.myecischeduale.repository.TaskRepository;

@Service
public class TaskService {
    
    @Autowired
    private TaskRepository taskRepository;

    public Task create (Task task){
        return taskRepository.save(task);
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

    /*public Optional<Task> findByKanbanName(String estado) {
        return taskRepository.findByKanabanName(estado);
    }*/
}

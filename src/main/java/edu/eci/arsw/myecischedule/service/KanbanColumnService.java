package edu.eci.arsw.myecischedule.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arsw.myecischedule.model.KanbanColumn;
import edu.eci.arsw.myecischedule.repository.KanbanColumnRepository;

@Service
public class KanbanColumnService {
    
    @Autowired
    private KanbanColumnRepository kanbanColumnRepository;

    public KanbanColumn create (KanbanColumn kanbanColumn){
        return kanbanColumnRepository.save(kanbanColumn);
    }

    public List<KanbanColumn> getAllKanbanColumns(){
        return kanbanColumnRepository.findAll();
    }

    public void delete(KanbanColumn kanbanColumn){
        kanbanColumnRepository.delete(kanbanColumn);
    }

    public Optional<KanbanColumn> findById(Long id){
        return kanbanColumnRepository.findById(id);
    }

}

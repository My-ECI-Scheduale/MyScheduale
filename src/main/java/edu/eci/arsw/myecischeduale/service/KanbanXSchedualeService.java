package edu.eci.arsw.myecischeduale.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arsw.myecischeduale.model.AssignatureXScheduale;
import edu.eci.arsw.myecischeduale.repository.AssignatureXSchedualeRepository;

@Service
public class KanbanXSchedualeService {
    
    @Autowired
    private AssignatureXSchedualeRepository assignatureXSchedualeRepository;

    public AssignatureXScheduale create (AssignatureXScheduale assignatureXScheduale){
        return assignatureXSchedualeRepository.save(assignatureXScheduale);
    }

    public List<AssignatureXScheduale> getAllAssignatureXScheduales(){
        return assignatureXSchedualeRepository.findAll();
    }

    public void delete(AssignatureXScheduale assignatureXScheduale){
        assignatureXSchedualeRepository.delete(assignatureXScheduale);
    }

    public Optional<AssignatureXScheduale> findById(Long id){
        return assignatureXSchedualeRepository.findById(id);
    }
}

package edu.eci.arsw.myecischedule.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arsw.myecischedule.model.AssignatureXSchedule;
import edu.eci.arsw.myecischedule.repository.AssignatureXScheduleRepository;

@Service
public class KanbanXScheduleService {
    
    @Autowired
    private AssignatureXScheduleRepository assignatureXScheduleRepository;

    public AssignatureXSchedule create (AssignatureXSchedule assignatureXSchedule){
        return assignatureXScheduleRepository.save(assignatureXSchedule);
    }

    public List<AssignatureXSchedule> getAllAssignatureXSchedules(){
        return assignatureXScheduleRepository.findAll();
    }

    public void delete(AssignatureXSchedule assignatureXSchedule){
        assignatureXScheduleRepository.delete(assignatureXSchedule);
    }

    public Optional<AssignatureXSchedule> findById(Long id){
        return assignatureXScheduleRepository.findById(id);
    }
}

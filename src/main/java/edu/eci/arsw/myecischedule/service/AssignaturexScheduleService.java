package edu.eci.arsw.myecischedule.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arsw.myecischedule.model.AssignatureXSchedule;
import edu.eci.arsw.myecischedule.repository.AssignatureXScheduleRepository;

@Service
public class AssignaturexScheduleService {

    @Autowired
    private AssignatureXScheduleRepository assignatureXScheduleRepository;

    public AssignatureXSchedule create (AssignatureXSchedule assignature){
        return assignatureXScheduleRepository.save(assignature);
    }

    public List<AssignatureXSchedule> getAllAssignatures(){
        return assignatureXScheduleRepository.findAll();
    }

    public void delete(AssignatureXSchedule assignature){
        assignatureXScheduleRepository.delete(assignature);
    }
    public List<AssignatureXSchedule> getwithAssignatureID(Long id){
        return assignatureXScheduleRepository.getwithAssignatureID(id);
    }
    public List<AssignatureXSchedule> getwithScheduleID(Long id){
        return assignatureXScheduleRepository.getwithScheduleID(id);
    }

}

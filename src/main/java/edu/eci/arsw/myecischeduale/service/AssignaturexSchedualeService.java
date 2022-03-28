package edu.eci.arsw.myecischeduale.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arsw.myecischeduale.model.AssignatureXScheduale;
import edu.eci.arsw.myecischeduale.repository.AssignatureXSchedualeRepository;

@Service
public class AssignaturexSchedualeService {

    @Autowired
    private AssignatureXSchedualeRepository assignatureXSchedualeRepository;

    public AssignatureXScheduale create (AssignatureXScheduale assignature){
        return assignatureXSchedualeRepository.save(assignature);
    }

    public List<AssignatureXScheduale> getAllAssignatures(){
        return assignatureXSchedualeRepository.findAll();
    }

    public void delete(AssignatureXScheduale assignature){
        assignatureXSchedualeRepository.delete(assignature);
    }
    public List<AssignatureXScheduale> getwithAssignatureID(Long id){
        return assignatureXSchedualeRepository.getwithAssignatureID(id);
    }
    public List<AssignatureXScheduale> getwithSchedualeID(Long id){
        return assignatureXSchedualeRepository.getwithSchedualeID(id);
    }

}

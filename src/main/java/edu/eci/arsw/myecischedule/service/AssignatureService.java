package edu.eci.arsw.myecischedule.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arsw.myecischedule.model.Assignature;
import edu.eci.arsw.myecischedule.repository.AssignatureRepository;

@Service
public class AssignatureService {
    
    @Autowired
    private AssignatureRepository assignatureRepository;

    public Assignature create (Assignature assignature){
        return assignatureRepository.save(assignature);
    }

    public List<Assignature> getAllAssignatures(){
        return assignatureRepository.findAll();
    }

    public void delete(Assignature assignature){
        assignatureRepository.delete(assignature);
    }

    public Optional<Assignature> findById(Long id){
        return assignatureRepository.findById(id);
    }
}

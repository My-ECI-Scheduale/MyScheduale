package edu.eci.arsw.myecischeduale.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import edu.eci.arsw.myecischeduale.model.Scheduale;
import edu.eci.arsw.myecischeduale.repository.SchedualeRepository;

@Service
public class SchedualeService {
    
    @Autowired
    private SchedualeRepository schedualeRepository;

    public Scheduale create (Scheduale scheduale){
        return schedualeRepository.save(scheduale);
    }

    public List<Scheduale> getAllScheduales(){
        return schedualeRepository.findAll();
    }

    public void delete(Scheduale scheduale){
        schedualeRepository.delete(scheduale);
    }

    public Optional<Scheduale> findById(Long id){
        return schedualeRepository.findById(id);
    }
}

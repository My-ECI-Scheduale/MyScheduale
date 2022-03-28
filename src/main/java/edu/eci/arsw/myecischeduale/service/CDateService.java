package edu.eci.arsw.myecischeduale.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arsw.myecischeduale.model.CDate;
import edu.eci.arsw.myecischeduale.repository.CDateRepository;

@Service
public class CDateService {
    
    @Autowired
    private CDateRepository cdateRepository;

    public CDate create (CDate cdate){
        return cdateRepository.save(cdate);
    }

    public List<CDate> getAllCDates(){
        return cdateRepository.findAll();
    }

    public void delete(CDate cdate){
        cdateRepository.delete(cdate);
    }

    public Optional<CDate> findById(Long id){
        return cdateRepository.findById(id);
    }
    public List<CDate> getCDates(Long id){
        return cdateRepository.getCDates(id);
    }
}

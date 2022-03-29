package edu.eci.arsw.myecischedule.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import edu.eci.arsw.myecischedule.model.Schedule;
import edu.eci.arsw.myecischedule.repository.ScheduleRepository;

@Service
public class ScheduleService {
    
    @Autowired
    private ScheduleRepository scheduleRepository;

    public Schedule create (Schedule schedule){
        return scheduleRepository.save(schedule);
    }

    public List<Schedule> getAllSchedules(){
        return scheduleRepository.findAll();
    }

    public void delete(Schedule schedule){
        scheduleRepository.delete(schedule);
    }

    public Optional<Schedule> findById(Long id){
        return scheduleRepository.findById(id);
    }
}

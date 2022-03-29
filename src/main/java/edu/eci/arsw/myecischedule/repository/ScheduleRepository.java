package edu.eci.arsw.myecischedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.eci.arsw.myecischedule.model.Schedule;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule,Long>{
    
}

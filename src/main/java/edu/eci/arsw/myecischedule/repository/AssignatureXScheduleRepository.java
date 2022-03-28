package edu.eci.arsw.myecischedule.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.eci.arsw.myecischedule.model.AssignatureXSchedule;

@Repository
public interface AssignatureXScheduleRepository extends JpaRepository<AssignatureXSchedule,Long>{
    
    @Query("SELECT c FROM AssignatureXSchedule c WHERE assignature_id=:id")
    List<AssignatureXSchedule> getwithAssignatureID(@Param("id")Long id);

    @Query("SELECT c FROM AssignatureXSchedule c WHERE schedule_id=:id")
    List<AssignatureXSchedule> getwithScheduleID(@Param("id")Long id);

}

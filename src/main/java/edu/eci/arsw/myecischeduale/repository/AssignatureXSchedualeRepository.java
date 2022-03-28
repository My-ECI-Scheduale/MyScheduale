package edu.eci.arsw.myecischeduale.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.eci.arsw.myecischeduale.model.AssignatureXScheduale;

@Repository
public interface AssignatureXSchedualeRepository extends JpaRepository<AssignatureXScheduale,Long>{
    
    @Query("SELECT c FROM AssignatureXScheduale c WHERE assignature_id=:id")
    List<AssignatureXScheduale> getwithAssignatureID(@Param("id")Long id);

    @Query("SELECT c FROM AssignatureXScheduale c WHERE scheduale_id=:id")
    List<AssignatureXScheduale> getwithSchedualeID(@Param("id")Long id);

}

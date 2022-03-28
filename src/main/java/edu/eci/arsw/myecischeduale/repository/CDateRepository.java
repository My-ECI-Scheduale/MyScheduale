package edu.eci.arsw.myecischeduale.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.eci.arsw.myecischeduale.model.CDate;

@Repository
public interface CDateRepository extends JpaRepository<CDate,Long>{
    
    @Query("SELECT c FROM date c WHERE id_assignature=:id")
    List<CDate> getCDates(@Param("id") Long id);
}

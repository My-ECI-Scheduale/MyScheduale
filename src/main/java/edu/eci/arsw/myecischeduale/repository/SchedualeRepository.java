package edu.eci.arsw.myecischeduale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.eci.arsw.myecischeduale.model.Scheduale;

@Repository
public interface SchedualeRepository extends JpaRepository<Scheduale,Long>{
    
}

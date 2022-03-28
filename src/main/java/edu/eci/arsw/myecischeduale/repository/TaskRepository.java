package edu.eci.arsw.myecischeduale.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.eci.arsw.myecischeduale.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long>{

    /*@Query("SELECT t FROM Tasks t WHERE idKanbanColumn:=(SELECT IdKanban FROM KanbanColumn WHERE name:=estado)")
    Optional<Task> findByKanabanName(@Param("estado")String estado);*/
}

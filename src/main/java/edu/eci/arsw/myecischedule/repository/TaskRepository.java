package edu.eci.arsw.myecischedule.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.eci.arsw.myecischedule.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long>{
    @Query("select t from Task t where id_kanban_column =:idColumn")
    List<Task> findByIdKanbanColumn(@Param("idColumn") Long id);
}

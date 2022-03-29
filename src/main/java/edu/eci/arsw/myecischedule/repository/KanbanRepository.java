package edu.eci.arsw.myecischedule.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import edu.eci.arsw.myecischedule.model.KanbanColumn;
import edu.eci.arsw.myecischedule.model.Kanban;

@Repository
public interface KanbanRepository extends JpaRepository<Kanban,Long>{
    
    @Query("SELECT k FROM KanbanColumn k WHERE id_kanban=:idcolumn")
    List<KanbanColumn> getKanbanColumns(@Param("idcolumn")Long id);
}

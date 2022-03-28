package edu.eci.arsw.myecischeduale.model;


import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.EmbeddedId;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "AssignatureXScheduale")
public class AssignatureXScheduale{

    @EmbeddedId
    public EventId id;

    public AssignatureXScheduale() {}

    public AssignatureXScheduale(EventId id) {
        this.id = id;
    }
    public AssignatureXScheduale(Scheduale schedualeId, Assignature assignatureId) {
        this.id = new EventId(schedualeId,assignatureId);
    }

    public EventId getId() {
        return id;
    }

    public void setId(EventId id) {
        this.id = id;
    }
    public Scheduale getSchedualeId() {
        return id.getSchedualeId();
    }

    public void setSchedualeId(Scheduale schedualeId) {
        id.setSchedualeId(schedualeId);;
    }

    public Assignature getAssignatureId() {
        return id.getAssignatureId();
    }

    public void setAssignatureId(Assignature assignatureId) {
        id.setAssignatureId(assignatureId);
    }

}

@Embeddable
class EventId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "schedualeId", nullable = false)
    private Scheduale schedualeId;

    @ManyToOne
    @JoinColumn(name = "assignatureId", nullable = false)
    private Assignature assignatureId;

    
    public EventId(Scheduale schedualeId, Assignature assignatureId) {
        this.schedualeId = schedualeId;
        this.assignatureId = assignatureId;
    }
    public EventId(){}

    public Scheduale getSchedualeId() {
        return schedualeId;
    }

    public void setSchedualeId(Scheduale schedualeId) {
        this.schedualeId = schedualeId;
    }

    public Assignature getAssignatureId() {
        return assignatureId;
    }

    public void setAssignatureId(Assignature assignatureId) {
        this.assignatureId = assignatureId;
    }
}
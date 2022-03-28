package edu.eci.arsw.myecischedule.model;


import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.EmbeddedId;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "AssignatureXSchedule")
public class AssignatureXSchedule{

    @EmbeddedId
    public EventId id;

    public AssignatureXSchedule() {}

    public AssignatureXSchedule(EventId id) {
        this.id = id;
    }
    public AssignatureXSchedule(Schedule scheduleId, Assignature assignatureId) {
        this.id = new EventId(scheduleId,assignatureId);
    }

    public EventId getId() {
        return id;
    }

    public void setId(EventId id) {
        this.id = id;
    }
    public Schedule getScheduleId() {
        return id.getScheduleId();
    }

    public void setScheduleId(Schedule scheduleId) {
        id.setScheduleId(scheduleId);;
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
    @JoinColumn(name = "scheduleId", nullable = false)
    private Schedule scheduleId;

    @ManyToOne
    @JoinColumn(name = "assignatureId", nullable = false)
    private Assignature assignatureId;

    
    public EventId(Schedule scheduleId, Assignature assignatureId) {
        this.scheduleId = scheduleId;
        this.assignatureId = assignatureId;
    }
    public EventId(){}

    public Schedule getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Schedule scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Assignature getAssignatureId() {
        return assignatureId;
    }

    public void setAssignatureId(Assignature assignatureId) {
        this.assignatureId = assignatureId;
    }
}
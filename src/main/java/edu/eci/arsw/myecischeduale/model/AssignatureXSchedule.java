package edu.eci.arsw.myecischeduale.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "AssignatureXSchedule")
public class AssignatureXSchedule {
    @Id
    @ManyToOne
    @JoinColumn(name = "scheduleId", nullable = false)
    private Schedule scheduleId;
    @Id
    @ManyToOne
    @JoinColumn(name = "assignatureId", nullable = false)
    private Assignature assignatureId;

    public AssignatureXSchedule(Schedule scheduleId, Assignature assignatureId) {
        this.scheduleId = scheduleId;
        this.assignatureId = assignatureId;
    }

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

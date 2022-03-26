package edu.eci.arsw.myecischeduale.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AssignatureXScheduale")
public class AssignatureXScheduale {
    @Id
    private Scheduale schedualeId;
    @Id
    private Assignature assignatureId;

    public AssignatureXScheduale(Scheduale schedualeId, Assignature assignatureId) {
        this.schedualeId = schedualeId;
        this.assignatureId = assignatureId;
    }

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

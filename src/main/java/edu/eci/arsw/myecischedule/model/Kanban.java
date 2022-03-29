package edu.eci.arsw.myecischedule.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Kanban")
public class Kanban {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "creation_Date", nullable = false)
    private Date CreationDate;
    
    @ManyToOne
    @JoinColumn(name = "assignatureId", nullable = false)
    private Assignature assignatureid;

    public Kanban() {}

    public Long getId() {
        return id;
    }



    public Kanban(Long id, Date creationDate, Assignature assignatureid) {
        this.id = id;
        CreationDate = creationDate;
        this.assignatureid = assignatureid;
    }

    public Assignature getAssignatureid() {
        return assignatureid;
    }

    public void setAssignatureid(Assignature assignatureid) {
        this.assignatureid = assignatureid;
    }

    public Date getCreationDate() {
        return CreationDate;
    }

    public void setCreationDate(Date creationDate) {
        CreationDate = creationDate;
    }
    public void setId(Long id) {
        this.id = id;
    }



    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}

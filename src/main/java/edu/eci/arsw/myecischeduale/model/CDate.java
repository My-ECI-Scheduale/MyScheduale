package edu.eci.arsw.myecischeduale.model;


import java.util.Date;

<<<<<<< HEAD
=======
import javax.persistence.Column;
>>>>>>> kanban
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
<<<<<<< HEAD
=======
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
>>>>>>> kanban
import javax.persistence.Table;

@Entity
@Table(name = "Date")
public class CDate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
<<<<<<< HEAD
    private Date date;
    private Assignature idAssignature;

    public CDate(Long id, Date date, Assignature idAssignature) {
        this.id = id;
=======
    @Column(name = "Date", nullable = false)
    private Date date;
    @ManyToOne
    @JoinColumn(name = "IdAssignature", nullable = false)
    private Assignature idAssignature;

    public CDate(Date date, Assignature idAssignature) {
>>>>>>> kanban
        this.date = date;
        this.idAssignature = idAssignature;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public Assignature getIdAssignature() {
        return idAssignature;
    }
    public void setIdAssignature(Assignature idAssignature) {
        this.idAssignature = idAssignature;
    }

<<<<<<< HEAD

    

}
=======
}
>>>>>>> kanban

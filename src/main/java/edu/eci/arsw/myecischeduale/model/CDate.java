package edu.eci.arsw.myecischeduale.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Date")
public class CDate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date date;
    private Assignature idAssignature;

    public CDate(Long id, Date date, Assignature idAssignature) {
        this.id = id;
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


    

}

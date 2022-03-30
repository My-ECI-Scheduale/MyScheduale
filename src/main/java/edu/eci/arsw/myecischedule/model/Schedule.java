package edu.eci.arsw.myecischedule.model;


import java.io.Serializable;
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
@Table(name = "Schedules")
public class Schedule implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "CreationDate", nullable = false)
    private Date creationDate;
    @ManyToOne
    @JoinColumn(name = "Owner", nullable = false)
    private Customer owner;


    @Override
    public String toString() {
        return "{id:"+id+",CreationDate:"+creationDate+",Owner:"+owner.toString()+"}";
    }
    
    public Schedule(Customer owner) {
        this.creationDate = new Date();
        this.owner = owner;
    }

    public Schedule() {}

    public Long getId() {
        return id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Customer getOwner() {
        return owner;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }

}

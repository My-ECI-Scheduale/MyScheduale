package edu.eci.arsw.myecischeduale.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Scheduale")
public class Scheduale {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date creatioDate;
    private Customer owner;

    

    public Scheduale(Long id, Date creatioDate, Customer owner) {
        this.id = id;
        this.creatioDate = creatioDate;
        this.owner = owner;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Date getCreatioDate() {
        return creatioDate;
    }
    public void setCreatioDate(Date creatioDate) {
        this.creatioDate = creatioDate;
    }
    public Customer getOwner() {
        return owner;
    }
    public void setOwner(Customer owner) {
        this.owner = owner;
    }
    
}

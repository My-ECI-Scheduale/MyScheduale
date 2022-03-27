package edu.eci.arsw.myecischeduale.model;

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
    @ManyToOne
    @JoinColumn(name = "IdCDate", nullable = false)
    private CDate idCDate;

    public Kanban(CDate idCDate) {
        this.idCDate = idCDate;
    }

    public Kanban() {}

    public Long getId() {
        return id;
    }

    public CDate getIdCDate() {
        return idCDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setIdCDate(CDate idCDate) {
        this.idCDate = idCDate;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}

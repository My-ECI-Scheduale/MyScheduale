package edu.eci.arsw.myecischeduale.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Assignatures")
public class Assignature implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "Name", nullable = false)
    private String name;
    @Column(name = "Creditos", nullable = false)
    private int creditos;

    public Assignature(String name, int creditos) {
        this.name = name;
        this.creditos = creditos;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}

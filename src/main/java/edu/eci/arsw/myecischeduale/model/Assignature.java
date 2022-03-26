package edu.eci.arsw.myecischeduale.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Assignature")
public class Assignature {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Kanban kanban;
    
    public Assignature(Long id, String name, Kanban kanban) {
        this.id = id;
        this.name = name;
        this.kanban = kanban;
    }
    public Kanban getKanban() {
        return kanban;
    }
    public void setKanban(Kanban kanban) {
        this.kanban = kanban;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
}

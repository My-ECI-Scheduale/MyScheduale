package edu.eci.arsw.myecischeduale.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "KanbanColumns")
public class KanbanColumn {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "IdKanban", nullable = false)
    private Kanban idKanban;
    @Column(name = "Name", nullable = false)
    private String name;

    public KanbanColumn(Kanban idKanban, String name) {
        this.idKanban = idKanban;
        this.name = name;
    }

    public KanbanColumn() {}

    public void setId(Long id) {
        this.id = id;
    }

    public void setIdKanban(Kanban idKanban) {
        this.idKanban = idKanban;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public Kanban getIdKanban() {
        return idKanban;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}

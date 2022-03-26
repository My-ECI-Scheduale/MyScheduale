package edu.eci.arsw.myecischeduale.model;

<<<<<<< HEAD
=======
import javax.persistence.Column;
>>>>>>> kanban
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
<<<<<<< HEAD
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
    
=======
@Table(name = "Assignatures")
public class Assignature {
    
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
>>>>>>> kanban
}

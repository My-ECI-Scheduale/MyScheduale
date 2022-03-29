package edu.eci.arsw.myecischeduale.model;

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
@Table(name = "Tasks")
public class Task {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "IdKanbanColumn", nullable = false)
    private KanbanColumn idKanbanColumn;
    @ManyToOne
    @JoinColumn(name = "IdCustomer", nullable = false)
    private Customer idCustomer;
    @Column(name = "isPublic", nullable = false)
    private boolean isPublic;
    @Column(name = "Title", nullable = false)
    private String title;
    @Column(name = "Description", nullable = false)
    private String description;
    @Column(name = "CreationDate", nullable = false)
    private Date creationDate;
    @Column(name = "LastDate", nullable = false)
    private Date lastDate;

    

    public Task(Long id, KanbanColumn idKanbanColumn, Customer idCustomer, boolean isPublic, String title,
            String description, Date creationDate, Date lastDate) {
        this.id = id;
        this.idKanbanColumn = idKanbanColumn;
        this.idCustomer = idCustomer;
        this.isPublic = isPublic;
        this.title = title;
        this.description = description;
        this.creationDate = creationDate;
        this.lastDate = lastDate;
    }

    public Task() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public KanbanColumn getIdKanbanColumn() {
        return idKanbanColumn;
    }

    public void setIdKanbanColumn(KanbanColumn idKanbanColumn) {
        this.idKanbanColumn = idKanbanColumn;
    }

    public Customer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Customer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getLastDate() {
        return lastDate;
    }

    public void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }

    
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
    
}

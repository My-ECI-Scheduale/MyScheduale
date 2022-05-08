package edu.eci.arsw.myecischedule.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "ModificationLogs")
public class ModificationLog implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @CreationTimestamp
    @Column(name = "date", nullable = false, updatable = false)
    private Date created;

    private char action;
    private Long idcolumn;
    private String username;
    private Long idtask;
    private String description;
    private boolean ipublic;
    private Long idcustomer;
    private Long kanban;

    public ModificationLog() {
    }

    public ModificationLog(char action, Long idcolumn, String username, Long idtask,
            String description, boolean ipublic, Long idcustomer, Long kanban) {
        this.action = action;
        this.idcolumn = idcolumn;
        this.username = username;
        this.idtask = idtask;
        this.description = description;
        this.ipublic = ipublic;
        this.idcustomer = idcustomer;
        this.kanban = kanban;
    }

    public ModificationLog(Long id, Date created, char action, Long idcolumn, String username, Long idtask,
            String description, boolean ipublic, Long idcustomer, Long kanban) {
        this.id = id;
        this.created = created;
        this.action = action;
        this.idcolumn = idcolumn;
        this.username = username;
        this.idtask = idtask;
        this.description = description;
        this.ipublic = ipublic;
        this.idcustomer = idcustomer;
        this.kanban = kanban;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public char getAction() {
        return action;
    }

    public void setAction(char action) {
        this.action = action;
    }

    public Long getIdcolumn() {
        return idcolumn;
    }

    public void setIdcolumn(Long idcolumn) {
        this.idcolumn = idcolumn;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getIdtask() {
        return idtask;
    }

    public void setIdtask(Long idtask) {
        this.idtask = idtask;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isIpublic() {
        return ipublic;
    }

    public void setIpublic(boolean ipublic) {
        this.ipublic = ipublic;
    }

    public Long getIdcustomer() {
        return idcustomer;
    }

    public void setIdcustomer(Long idcustomer) {
        this.idcustomer = idcustomer;
    }

    public Long getKanban() {
        return kanban;
    }

    public void setKanban(Long kanban) {
        this.kanban = kanban;
    }

}

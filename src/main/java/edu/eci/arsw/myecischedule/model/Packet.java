package edu.eci.arsw.myecischedule.model;

public class Packet {
    private Task task;
    private char action;
    private Long idcolumn;

    public Packet(Task task, char action, Long idcolumn) {
        this.task = task;
        this.action = action;
        this.idcolumn = idcolumn;
    }
    public Task getTask() {
        return task;
    }
    public void setTask(Task task) {
        this.task = task;
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
    
}

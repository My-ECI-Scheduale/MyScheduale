package edu.eci.arsw.myecischedule.model;

public class Packet {
    private Task task;
    private char action;
    private Long idcolumn;
    private String username;

    public Packet(Task task, char action, Long idcolumn,String username) {
        this.task = task;
        this.action = action;
        this.idcolumn = idcolumn;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
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

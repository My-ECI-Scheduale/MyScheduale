package edu.eci.arsw.myecischedule.model;

import java.io.Serializable;

public class Packet implements Serializable{
    private char action;
    private Long idcolumn;
    private String username;
    private  Long idtask;
    private String description;
    private boolean ipublic;
    private Long idcustomer;

    

        
    public Packet(char action, Long idcolumn, String username, Long idtask, String description,
            boolean ipublic, Long idCustomer) {
        this.action = action;
        this.idcolumn = idcolumn;
        this.username = username;
        this.idtask = idtask;
        this.description = description;
        this.ipublic = ipublic;
        this.idcustomer = idCustomer;
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


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }





    public Long getIdtask() {
        return idtask;
    }


    public void setIdtask(Long idtask) {
        this.idtask = idtask;
    }


    @Override
    public String toString() {
        return "{action:"+action+",idcolumn:"+idcolumn+", username:"+username+"}";
    }


    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
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

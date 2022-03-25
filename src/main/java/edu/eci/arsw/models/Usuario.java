package edu.eci.arsw.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class Usuario {
    @Id
    public int id;
    public String name;
    public int semestre;
    public String programa;
}

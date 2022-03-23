package edu.eci.arsw.myecischeduale.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table
@Entity
public class Usuario {
    public int id;
    public String name;
    public int semestre;
    public String programa;
}

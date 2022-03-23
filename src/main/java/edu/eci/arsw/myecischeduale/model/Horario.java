package edu.eci.arsw.myecischeduale.model;

import java.util.HashMap;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table
@Entity
public class Horario {
    public int id;
    public HashMap<Integer,Asignatura> clases;
    public Usuario usuario;
    
}

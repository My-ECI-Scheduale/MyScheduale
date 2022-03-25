package edu.eci.arsw.models;

import java.util.HashMap;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class Horario {
    @Id
    public int id;
    public HashMap<Integer,Asignatura> clases;
    public Usuario usuario;
    
}

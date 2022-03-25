package edu.eci.arsw.models;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import edu.eci.arsw.myecischeduale.util.Tuple;

@Table
@Entity
public class Asignatura {
    @Id
    public int id;
    public ArrayList<Tuple<Date, Date>> sesiones;
    public String name;
    public int creditos;
    public String profesor;
    
}

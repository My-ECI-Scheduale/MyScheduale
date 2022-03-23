package edu.eci.arsw.myecischeduale.model;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.Table;

import edu.eci.arsw.myecischeduale.util.Tuple;

@Table
@Entity
public class Asignatura {
    public int id;
    public ArrayList<Tuple<Date, Date>> sesiones;
    public String name;
    public int creditos;
    public String profesor;
    
}

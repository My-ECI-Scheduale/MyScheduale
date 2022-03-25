package edu.eci.arsw.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Persona")
public class Person {
    @Id
    private int id;
}

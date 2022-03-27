package edu.eci.arsw.myecischeduale.model;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Date")
public class CDate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "Hora", nullable = false)
    private int hora;
    @Column(name = "Dia", nullable = false)
    private char dia;
    @ManyToOne
    @JoinColumn(name = "IdAssignature", nullable = false)
    private Assignature idAssignature;

    
    
    public CDate(Long id, int hora, char dia, Assignature idAssignature) {
        this.id = id;
        this.hora = hora;
        this.dia = dia;
        this.idAssignature = idAssignature;
    }

    public CDate() {}

    public Long getId() {
        return id;
    }
    public int getHora() {
        return hora;
    }
    public void setHora(int hora) {
        this.hora = hora;
    }
    public char getDia() {
        return dia;
    }
    public void setDia(char dia) {
        this.dia = dia;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    public Assignature getIdAssignature() {
        return idAssignature;
    }
    public void setIdAssignature(Assignature idAssignature) {
        this.idAssignature = idAssignature;
    }

}

package edu.eci.arsw.myecischeduale.model;



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
    @Column(name = "HoraInicio", nullable = false)
    private String horaInicio;
    @Column(name = "HoraFinal", nullable = false)
    private String horaFinal;
    @Column(name = "Dia", nullable = false)
    private char dia;
    @ManyToOne
    @JoinColumn(name = "IdAssignature", nullable = false)
    private Assignature idAssignature;

    
 

    public CDate() {}

    public Long getId() {
        return id;
    }

    public CDate(Long id, String horaInicio, String horaFinal, char dia, Assignature idAssignature) {
        this.id = id;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
        this.dia = dia;
        this.idAssignature = idAssignature;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(String horaFinal) {
        this.horaFinal = horaFinal;
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

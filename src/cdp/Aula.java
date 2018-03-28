package cdp;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Aula implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false)
    private int numero;
    
    @Column(nullable = false)
    private String dia;
    
    @Column(nullable = false)
    private String turno;
  
    @Column(nullable = false, precision = 2)
    private double horarioInicio;
    
    @Column(nullable = false, precision = 2)
    private double horarioTermino;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "alocacao_id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Alocacao alocacao;
     
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "oferta_id", nullable = false)
    private Oferta oferta;
    
    public Aula() {
    }

    public Aula(int id, int numero, String dia, String turno, double horarioInicio, double horarioTermino, Alocacao alocacao, Oferta oferta) {
        this.id = id;
        this.numero = numero;
        this.dia = dia;
        this.turno = turno;
        this.horarioInicio = horarioInicio;
        this.horarioTermino = horarioTermino;
        this.alocacao = alocacao;
        this.oferta = oferta;
    }

    public Aula(int numero, String dia, String turno, double horarioInicio, double horarioTermino, Alocacao alocacao, Oferta oferta) {
        this.numero = numero;
        this.dia = dia;
        this.turno = turno;
        this.horarioInicio = horarioInicio;
        this.horarioTermino = horarioTermino;
        this.alocacao = alocacao;
        this.oferta = oferta;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public double getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(double horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public double getHorarioTermino() {
        return horarioTermino;
    }

    public void setHorarioTermino(double horarioTermino) {
        this.horarioTermino = horarioTermino;
    }

    public Alocacao getAlocacao() {
        return alocacao;
    }

    public void setAlocacao(Alocacao alocacao) {
        this.alocacao = alocacao;
    }

    public Oferta getOferta() {
        return oferta;
    }

    public void setOferta(Oferta oferta) {
        this.oferta = oferta;
    }
}

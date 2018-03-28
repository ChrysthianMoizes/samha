package cdp;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Oferta implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false, unique = false)
    private String semestre;
    
    @Column(nullable = false, precision = 2)
    private double tempoMaximoTrabalho;
    
    @Column(nullable = false, precision = 2)
    private double intervaloMinimo;
    
    @OneToMany(mappedBy = "oferta", fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Collection<Aula> aulas;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "turma_id", nullable = false)
    private Turma turma;

    public Oferta() {
    }

    public Oferta(int id, String semestre, double tempoMaximoTrabalho, double intervaloMinimo, Collection<Aula> aulas, Turma turma) {
        this.id = id;
        this.semestre = semestre;
        this.tempoMaximoTrabalho = tempoMaximoTrabalho;
        this.intervaloMinimo = intervaloMinimo;
        this.aulas = aulas;
        this.turma = turma;
    }

    public Oferta(String semestre, double tempoMaximoTrabalho, double intervaloMinimo, Collection<Aula> aulas, Turma turma) {
        this.semestre = semestre;
        this.tempoMaximoTrabalho = tempoMaximoTrabalho;
        this.intervaloMinimo = intervaloMinimo;
        this.aulas = aulas;
        this.turma = turma;
    }

    public double getTempoMaximoTrabalho() {
        return tempoMaximoTrabalho;
    }

    public void setTempoMaximoTrabalho(double tempoMaximoTrabalho) {
        this.tempoMaximoTrabalho = tempoMaximoTrabalho;
    }

    public double getIntervaloMinimo() {
        return intervaloMinimo;
    }

    public void setIntervaloMinimo(double intervaloMinimo) {
        this.intervaloMinimo = intervaloMinimo;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public Collection<Aula> getAulas() {
        return aulas;
    }

    public void setAulas(Collection<Aula> aulas) {
        this.aulas = aulas;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    } 
}

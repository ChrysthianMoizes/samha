package cdp;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Aula implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false, precision = 2)
    private double horarioInicio;
    
    @Column(nullable = false, precision = 2)
    private double horarioTermino;
    
    @Column(nullable = false)
    private boolean disponivel = true;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "disciplina_id", nullable = false)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Disciplina disciplina;
    
    @OneToMany(mappedBy = "professor_id", fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Professor professor;
    
    public Aula() {
    }

    public Aula(int id, double horarioInicio, double horarioTermino, Disciplina disciplina) {
        this.id = id;
        this.horarioInicio = horarioInicio;
        this.horarioTermino = horarioTermino;
    }

    public Aula(double horarioInicio, double horarioTermino, Disciplina disciplina) {
        this.horarioInicio = horarioInicio;
        this.horarioTermino = horarioTermino;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    } 

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}

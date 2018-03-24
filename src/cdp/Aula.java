package cdp;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
    
    
    private DisciplinaProfessor disciplina;
    
    public Aula() {
    }

    public Aula(int id, double horarioInicio, double horarioTermino, DisciplinaProfessor disciplina) {
        this.id = id;
        this.horarioInicio = horarioInicio;
        this.horarioTermino = horarioTermino;
    }

    public Aula(double horarioInicio, double horarioTermino, DisciplinaProfessor disciplina) {
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

    public DisciplinaProfessor getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(DisciplinaProfessor disciplina) {
        this.disciplina = disciplina;
    } 

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}

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
public class Alocacao implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false)
    private String semestre;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "turma_id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Turma turma;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "disciplina_id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Disciplina disciplina;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "professor_id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Professor professor;

    public Alocacao() {
    }

    public Alocacao(int id, String semestre, Turma turma, Disciplina disciplina, Professor professor) {
        this.id = id;
        this.semestre = semestre;
        this.turma = turma;
        this.disciplina = disciplina;
        this.professor = professor;
    }

    public Alocacao(String semestre, Turma turma, Disciplina disciplina, Professor professor) {
        this.semestre = semestre;
        this.turma = turma;
        this.disciplina = disciplina;
        this.professor = professor;
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

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
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
}

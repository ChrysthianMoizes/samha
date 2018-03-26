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
import javax.persistence.OneToMany;
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
    
    @Column(nullable = false)
    private String ano;
    
    @Column(nullable = false, precision = 2)
    private double horarioInicio;
    
    @Column(nullable = false, precision = 2)
    private double horarioTermino;
    
    @Column(nullable = true)
    private boolean disponivel = true;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "disciplina_id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Disciplina disciplina;
    
    @OneToMany(mappedBy = "professor_id", fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Professor professor;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "turma_id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Turma turma;
    
    public Aula() {
    }

    public Aula(int id, int numero, String dia, String turno, String ano, double horarioInicio, double horarioTermino, Disciplina disciplina, Professor professor, Turma turma) {
        this.id = id;
        this.numero = numero;
        this.dia = dia;
        this.turno = turno;
        this.ano = ano;
        this.horarioInicio = horarioInicio;
        this.horarioTermino = horarioTermino;
        this.disciplina = disciplina;
        this.professor = professor;
        this.turma = turma;
    }

    public Aula(int numero, String dia, String turno, String ano, double horarioInicio, double horarioTermino, Disciplina disciplina, Professor professor, Turma turma) {
        this.numero = numero;
        this.dia = dia;
        this.turno = turno;
        this.ano = ano;
        this.horarioInicio = horarioInicio;
        this.horarioTermino = horarioTermino;
        this.disciplina = disciplina;
        this.professor = professor;
        this.turma = turma;
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

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
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

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
}

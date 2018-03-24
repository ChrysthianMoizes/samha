package cdp;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class RestricaoProfessor implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false)
    private String nome;
    
    @Column(nullable = false)
    private int prioridade;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "professor_id", nullable = false)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Professor professor;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dia_id", nullable = false)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Dia dia;
    
    public RestricaoProfessor(){    
    }

    public RestricaoProfessor(int id, String nome, int prioridade, int turno, Professor professor, Dia dia) {
        this.id = id;
        this.nome = nome;
        this.dia = dia;
        this.prioridade = prioridade;
        this.professor = professor;
    }

    public RestricaoProfessor(String nome, int prioridade, int turno, Professor professor, Dia dia) {
        this.nome = nome;
        this.dia = dia;
        this.prioridade = prioridade;
        this.professor = professor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Dia getDia() {
        return dia;
    }

    public void setDia(Dia dia) {
        this.dia = dia;
    }
    
    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}

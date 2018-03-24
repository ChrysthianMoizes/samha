package cdp;

import java.util.Collection;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "professor")
@PrimaryKeyJoinColumn(name = "professor_id")
public class Professor extends Servidor{
    
    @Column(nullable = false, unique = true)
    private String email;
    
    @Column(nullable = false, precision = 2)
    private double cargaHoraria;
    
    @OneToMany(mappedBy = "professor_id", fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Collection<RestricaoProfessor> restricoes;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "professor_turma",
            joinColumns = @JoinColumn(name = "professor_id", nullable = true),
            inverseJoinColumns = @JoinColumn(name = "turma_id"))
    @Cascade(CascadeType.SAVE_UPDATE)
    private Collection<Turma> turmas;
    
    public Professor() {
    }
    
    public Professor(String email, double cargaHoraria, int id, String nome, String matricula, Collection restricoes, Collection<Turma> turmas) {
        super(id, nome, matricula);
        this.email = email;
        this.cargaHoraria = cargaHoraria;
        this.restricoes = restricoes;
        this.turmas = turmas;
    }

    public Professor(String email, double cargaHoraria, String nome, String matricula, Collection restricoes, Collection<Turma> turmas) {
        super(nome, matricula);
        this.email = email;
        this.cargaHoraria = cargaHoraria;
        this.restricoes = restricoes;
        this.turmas = turmas;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(double cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Collection getRestricoes() {
        return restricoes;
    }

    public void setRestricoes(Collection restricoes) {
        this.restricoes = restricoes;
    }

    public Collection<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(Collection<Turma> turmas) {
        this.turmas = turmas;
    }
}

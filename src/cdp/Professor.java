package cdp;

import java.util.Collection;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;
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
    
    @OneToMany(mappedBy = "professor", fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Collection<RestricaoProfessor> restricoes;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "coordenadoria_id", nullable = false)
    private Coordenadoria coordenadoria;
    
    public Professor() {
    }

    public Professor(String email, double cargaHoraria, Collection<RestricaoProfessor> restricoes, Coordenadoria coordenadoria, int id, String nome, String matricula) {
        super(id, nome, matricula);
        this.email = email;
        this.cargaHoraria = cargaHoraria;
        this.restricoes = restricoes;
        this.coordenadoria = coordenadoria;
    }

    public Professor(String email, double cargaHoraria, Collection<RestricaoProfessor> restricoes, Coordenadoria coordenadoria, String nome, String matricula) {
        super(nome, matricula);
        this.email = email;
        this.cargaHoraria = cargaHoraria;
        this.restricoes = restricoes;
        this.coordenadoria = coordenadoria;
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

    public Coordenadoria getCoordenadoria() {
        return coordenadoria;
    }

    public void setCoordenadoria(Coordenadoria coordenadoria) {
        this.coordenadoria = coordenadoria;
    }
}

package cdp;

import java.util.Collection;
import javax.persistence.*;

@Entity
@Table(name = "professor")
@PrimaryKeyJoinColumn(name = "professor_id")
public class Professor extends Servidor{
    
    @Column(nullable = false, precision = 2)
    private double cargaHoraria;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "coordenadoria_id", nullable = false)
    private Coordenadoria coordenadoria;
    
    public Professor() {
    }

    public Professor(double cargaHoraria, Coordenadoria coordenadoria, int id, String nome, String matricula) {
        super(id, nome, matricula);
        this.cargaHoraria = cargaHoraria;
        this.coordenadoria = coordenadoria;
    }

    public Professor(double cargaHoraria, Collection<RestricaoProfessor> restricoes, Coordenadoria coordenadoria, String nome, String matricula) {
        super(nome, matricula);
        this.cargaHoraria = cargaHoraria;
        this.coordenadoria = coordenadoria;
    }

    public double getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(double cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Coordenadoria getCoordenadoria() {
        return coordenadoria;
    }

    public void setCoordenadoria(Coordenadoria coordenadoria) {
        this.coordenadoria = coordenadoria;
    }
    
    public Object[] toArray() {
        return new Object[] { this, getMatricula(), getCoordenadoria().getNome()};
    }
}

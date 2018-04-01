package cdp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "professor_coordenador")
@PrimaryKeyJoinColumn(name = "professor_coordenador_id")
public class ProfessorCoordenador extends Coordenador{
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "professor_id", nullable = false)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Professor professor;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "coordenadoria_id", nullable = false)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Coordenadoria coordenadoria;

    public ProfessorCoordenador() {
    }

    public ProfessorCoordenador(Professor professor, Coordenadoria coordenadoria, String tipo, Usuario usuario, int id, String nome, String matricula) {
        super(tipo, usuario, id, nome, matricula);
        this.professor = professor;
        this.coordenadoria = coordenadoria;
    }

    public ProfessorCoordenador(Professor Professor, Coordenadoria coordenadoria, String tipo, Usuario usuario, String nome, String matricula) {
        super(tipo, usuario, nome, matricula);
        this.professor = professor;
        this.coordenadoria = coordenadoria;
    }
    
    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Coordenadoria getCoordenadoria() {
        return coordenadoria;
    }

    public void setCoordenadoria(Coordenadoria coordenadoria) {
        this.coordenadoria = coordenadoria;
    }
}

package cdp;

import java.util.Collection;
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
public class ProfessorCoordenador extends Professor{
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "coordenador_id", nullable = false)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Coordenador coordenador;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "coordenadoria_id", nullable = false)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Coordenadoria coordenadoria;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "eixo_id", nullable = false)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Eixo eixo;

    public ProfessorCoordenador() {
    }

    public ProfessorCoordenador(Coordenador coordenador, Coordenadoria coordenadoria, Eixo eixo, String email, double cargaHoraria, int id, String nome, String matricula, Collection restricoes, Collection<Turma> turmas) {
        super(email, cargaHoraria, id, nome, matricula, restricoes, turmas);
        this.coordenador = coordenador;
        this.coordenadoria = coordenadoria;
        this.eixo = eixo;
    }

    public ProfessorCoordenador(Coordenador coordenador, Coordenadoria coordenadoria, Eixo eixo, String email, double cargaHoraria, String nome, String matricula, Collection restricoes, Collection<Turma> turmas) {
        super(email, cargaHoraria, nome, matricula, restricoes, turmas);
        this.coordenador = coordenador;
        this.coordenadoria = coordenadoria;
        this.eixo = eixo;
    }

    public Coordenador getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(Coordenador coordenador) {
        this.coordenador = coordenador;
    }

    public Coordenadoria getCoordenadoria() {
        return coordenadoria;
    }

    public void setCoordenadoria(Coordenadoria coordenadoria) {
        this.coordenadoria = coordenadoria;
    }

    public Eixo getEixo() {
        return eixo;
    }

    public void setEixo(Eixo eixo) {
        this.eixo = eixo;
    }
}

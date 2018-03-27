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
    @JoinColumn(name = "eixo_id", nullable = false)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Eixo eixo;

    public ProfessorCoordenador() {
    }

    public ProfessorCoordenador(Coordenador coordenador, Eixo eixo, String email, double cargaHoraria, Collection<RestricaoProfessor> restricoes, Coordenadoria coordenadoria, int id, String nome, String matricula) {
        super(email, cargaHoraria, restricoes, coordenadoria, id, nome, matricula);
        this.coordenador = coordenador;
        this.eixo = eixo;
    }

    public ProfessorCoordenador(Coordenador coordenador, Eixo eixo, String email, double cargaHoraria, Collection<RestricaoProfessor> restricoes, Coordenadoria coordenadoria, String nome, String matricula) {
        super(email, cargaHoraria, restricoes, coordenadoria, nome, matricula);
        this.coordenador = coordenador;
        this.eixo = eixo;
    }

    public Coordenador getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(Coordenador coordenador) {
        this.coordenador = coordenador;
    }
    
    public Eixo getEixo() {
        return eixo;
    }

    public void setEixo(Eixo eixo) {
        this.eixo = eixo;
    }
}

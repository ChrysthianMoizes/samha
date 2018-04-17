package cdp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "coordenador")
@PrimaryKeyJoinColumn(name = "coordenador_id")
public class Coordenador extends Servidor{
    
    @Column(nullable = false)
    private String tipo;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id", nullable = false)
    @Cascade(CascadeType.ALL)
    private Usuario usuario;           
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "professor_id", nullable = true)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Professor professor;

    public Coordenador() {
    }

    public Coordenador(String tipo, Usuario usuario, Professor professor, int id, String nome, String matricula) {
        super(id, nome, matricula);
        this.tipo = tipo;
        this.usuario = usuario;
        this.professor = professor;
    }

    public Coordenador(String tipo, Usuario usuario, Professor professor, String nome, String matricula) {
        super(nome, matricula);
        this.tipo = tipo;
        this.usuario = usuario;
        this.professor = professor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    
    public Object[] toArray() {
        return new Object[] { this, getMatricula(), getTipo() };
    }
}

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
    @Cascade(CascadeType.SAVE_UPDATE)
    private Usuario usuario;
            

    public Coordenador() {
    }

    public Coordenador(String tipo, Usuario usuario, int id, String nome, String matricula) {
        super(id, nome, matricula);
        this.tipo = tipo;
        this.usuario = usuario;
    }

    public Coordenador(String tipo, Usuario usuario, String nome, String matricula) {
        super(nome, matricula);
        this.tipo = tipo;
        this.usuario = usuario;
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
    
    public Object[] toArray() {
        return new Object[] { this, getMatricula(), getTipo() };
    }
}

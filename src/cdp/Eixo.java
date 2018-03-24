package cdp;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Eixo implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false, unique = true)
    private String nome;
    
    @OneToMany(mappedBy = "eixo_id", fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Collection<Coordenadoria> coordenadorias;

    public Eixo() {
    }

    public Eixo(int id, String nome, Collection<Coordenadoria> coordenadorias) {
        this.id = id;
        this.nome = nome;
        this.coordenadorias = coordenadorias;
    }

    public Eixo(String nome, Collection<Coordenadoria> coordenadorias) {
        this.nome = nome;
        this.coordenadorias = coordenadorias;
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

    public Collection<Coordenadoria> getCoordenadorias() {
        return coordenadorias;
    }

    public void setCoordenadorias(Collection<Coordenadoria> coordenadorias) {
        this.coordenadorias = coordenadorias;
    } 
}

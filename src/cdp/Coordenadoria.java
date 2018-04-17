package cdp;

import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


@Entity
public class Coordenadoria implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false, unique = true)
    private String nome;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "eixo_id", nullable = false)
    private Eixo eixo;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id", nullable = true)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Curso curso;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "coordenador_id", nullable = true)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Coordenador coordenador;
  
    public Coordenadoria() {
    }

    public Coordenadoria(int id, String nome, Eixo eixo, Curso curso, Coordenador coordenador) {
        this.id = id;
        this.nome = nome;
        this.eixo = eixo;
        this.curso = curso;
        this.coordenador = coordenador;
    }

    public Coordenadoria(String nome, Eixo eixo, Curso curso, Coordenador coordenador) {
        this.nome = nome;
        this.eixo = eixo;
        this.curso = curso;
        this.coordenador = coordenador;
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

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Eixo getEixo() {
        return eixo;
    }

    public void setEixo(Eixo eixo) {
        this.eixo = eixo;
    }

    public Coordenador getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(Coordenador coordenador) {
        this.coordenador = coordenador;
    }
    
    @Override
    public String toString() {
        return nome;
    }
    
    public Object[] toArray() {
        return new Object[] { this };
    }
}

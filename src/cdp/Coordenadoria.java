package cdp;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
public class Coordenadoria implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false, unique = true)
    private String nome;
    
    @Column(nullable = false, unique = false)
    private String eixo;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "curso_id", nullable = true)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Curso curso;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "coordenador_id", nullable = true)
    @Cascade(CascadeType.SAVE_UPDATE)
    private ProfessorCoordenador coordenador;
    
    @OneToMany(mappedBy = "coordenadoria", fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Collection<Professor> professores;
  
    public Coordenadoria() {
    }

    public Coordenadoria(int id, String nome, Curso curso, ProfessorCoordenador coordenador, Collection<Professor> professores, String eixo) {
        this.id = id;
        this.nome = nome;
        this.curso = curso;
        this.coordenador = coordenador;
        this.professores = professores;
        this.eixo = eixo;
    }

    public Coordenadoria(String nome, Curso curso, ProfessorCoordenador coordenador, Collection<Professor> professores, String eixo) {
        this.nome = nome;
        this.curso = curso;
        this.coordenador = coordenador;
        this.professores = professores;
        this.eixo = eixo;
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

    public ProfessorCoordenador getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(ProfessorCoordenador coordenador) {
        this.coordenador = coordenador;
    }

    public Collection<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(Collection<Professor> professores) {
        this.professores = professores;
    }

    public String getEixo() {
        return eixo;
    }

    public void setEixo(String eixo) {
        this.eixo = eixo;
    }
    
    @Override
    public String toString() {
        return nome;
    }
    
    public Object[] toArray() {
        return new Object[] { this };
    }
}

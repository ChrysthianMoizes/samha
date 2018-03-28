package cdp;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Turma implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false, unique = true)
    private String nome;
    
    @Column(nullable = false, unique = false)
    private String anoCriacao;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "matriz_curricular_id", nullable = false)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @Cascade(CascadeType.SAVE_UPDATE)
    private MatrizCurricular matriz;
    
    @OneToMany(mappedBy = "turma", fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Collection<Oferta> ofertas;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;
    
    @Column(nullable = false)
    private String turno;

    public Turma() {
    }

    public Turma(int id, String nome, String anoCriacao, String turno, MatrizCurricular matriz, Collection<Oferta> ofertas, Curso curso) {
        this.id = id;
        this.nome = nome;
        this.anoCriacao = anoCriacao;
        this.matriz = matriz;
        this.ofertas = ofertas;
        this.curso = curso;
        this.turno = turno;
    }

    public Turma(String nome, String anoCriacao, String turno, MatrizCurricular matriz, Collection<Oferta> ofertas, Curso curso) {
        this.nome = nome;
        this.anoCriacao = anoCriacao;
        this.matriz = matriz;
        this.ofertas = ofertas;
        this.curso = curso;
        this.turno = turno;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
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

    public String getAnoCriacao() {
        return anoCriacao;
    }

    public void setAnoCriacao(String anoCriacao) {
        this.anoCriacao = anoCriacao;
    }

    public MatrizCurricular getMatriz() {
        return matriz;
    }

    public void setMatriz(MatrizCurricular matriz) {
        this.matriz = matriz;
    }

    public Collection<Oferta> getOfertas() {
        return ofertas;
    }

    public void setOfertas(Collection<Oferta> ofertas) {
        this.ofertas = ofertas;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
}

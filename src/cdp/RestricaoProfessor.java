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
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "restricao_professor")
public class RestricaoProfessor implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false)
    private String nome;
    
    @Column(nullable = true)
    private String descricao;
    
    @Column(nullable = false)
    private int prioridade;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "professor_id", nullable = false)
    private Professor professor;
    
    @OneToMany(mappedBy = "restricao", fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Collection<Aula> aulas;
     
    public RestricaoProfessor(){    
    }

    public RestricaoProfessor(int id, String nome, String descricao, int prioridade, int turno, Professor professor, Collection<Aula> aulas) {
        this.id = id;
        this.nome = nome;
        this.aulas = aulas;
        this.prioridade = prioridade;
        this.professor = professor;
        this.descricao = descricao;
    }

    public RestricaoProfessor(String nome, String descricao, int prioridade, int turno, Professor professor, Collection<Aula> aulas) {
        this.nome = nome;
        this.aulas = aulas;
        this.prioridade = prioridade;
        this.professor = professor;
        this.descricao = descricao;
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

    public Collection<Aula> getAulas() {
        return aulas;
    }

    public void setAulas(Collection<Aula> aulas) {
        this.aulas = aulas;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}

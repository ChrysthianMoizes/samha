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
public class Horario implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false, unique = false)
    private String ano;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "restricao_instituicao_id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @Cascade(CascadeType.SAVE_UPDATE)
    private RestricaoInstituicao restricoes;
    
    @OneToMany(mappedBy = "horario", fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Collection<Aula> aulas;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "turma_id", nullable = false)
    private Turma turma;

    public Horario() {
    }

    public Horario(int id, String ano, RestricaoInstituicao restricoes, Collection<Aula> aulas, Turma turma) {
        this.id = id;
        this.ano = ano;
        this.restricoes = restricoes;
        this.aulas = aulas;
        this.turma = turma;
    }

    public Horario(String ano, RestricaoInstituicao restricoes, Collection<Aula> aulas, Turma turma) {
        this.ano = ano;
        this.restricoes = restricoes;
        this.aulas = aulas;
        this.turma = turma;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public RestricaoInstituicao getRestricoes() {
        return restricoes;
    }

    public void setRestricoes(RestricaoInstituicao restricoes) {
        this.restricoes = restricoes;
    }

    public Collection<Aula> getAulas() {
        return aulas;
    }

    public void setAulas(Collection<Aula> aulas) {
        this.aulas = aulas;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    } 
}

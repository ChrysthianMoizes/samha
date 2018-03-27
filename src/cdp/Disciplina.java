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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Disciplina implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false)
    private String nome;
    
    @Column(nullable = false)
    private String tipo;
    
    @Column(nullable = false, precision = 2)
    private double cargaHoraria;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "disciplina_professor",
            joinColumns = @JoinColumn(name = "disciplina_id", nullable = true),
            inverseJoinColumns = @JoinColumn(name = "professor_id"))
    @Cascade(CascadeType.SAVE_UPDATE)
    private Collection<Professor> professoresHabilitados;

    public Disciplina() {
    }

    public Disciplina(int id, String nome, String tipo, double cargaHoraria, Collection professoresHabilitados) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.cargaHoraria = cargaHoraria;
        this.professoresHabilitados = professoresHabilitados;
    }

    public Disciplina(String nome, String tipo, double cargaHoraria, Collection professoresHabilitados) {
        this.nome = nome;
        this.tipo = tipo;
        this.cargaHoraria = cargaHoraria;
        this.professoresHabilitados = professoresHabilitados;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(double cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Collection<Professor> getProfessoresHabilitados() {
        return professoresHabilitados;
    }

    public void setProfessoresHabilitados(Collection<Professor> professoresHabilitados) {
        this.professoresHabilitados = professoresHabilitados;
    } 
}

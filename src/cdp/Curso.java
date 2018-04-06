package cdp;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Curso implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false, unique = true)
    private String nome;
    
    @Column(nullable = false)
    private int qtPeriodos;
    
    @Column(nullable = false)
    private String nivel;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "coordenadoria_id", nullable = true)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Coordenadoria coordenadoria;

    public Curso() {
    }

    public Curso(int id, String nome, int qtPeriodos, String nivel, Coordenadoria coordenadoria) {
        this.id = id;
        this.nome = nome;
        this.qtPeriodos = qtPeriodos;
        this.nivel = nivel;
        this.coordenadoria = coordenadoria;
    }

    public Curso(String nome, int qtPeriodos, String nivel, Coordenadoria coordenadoria) {
        this.nome = nome;
        this.qtPeriodos = qtPeriodos;
        this.nivel = nivel;
        this.coordenadoria = coordenadoria;
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

    public int getQtPeriodos() {
        return qtPeriodos;
    }

    public void setQtPeriodos(int qtPeriodos) {
        this.qtPeriodos = qtPeriodos;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public Coordenadoria getCoordenadoria() {
        return coordenadoria;
    }

    public void setCoordenadoria(Coordenadoria coordenadoria) {
        this.coordenadoria = coordenadoria;
    }

    @Override
    public String toString() {
        return nome;
    }
   
    public Object[] toArray() {
        return new Object[] { this, getNivel() };
    }
}

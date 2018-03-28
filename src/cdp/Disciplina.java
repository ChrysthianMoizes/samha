package cdp;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
    
    @Column(nullable = false)
    private int qtAulas;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "matriz_id", nullable = false)
    private MatrizCurricular matriz;

    public Disciplina() {
    }

    public Disciplina(int id, String nome, String tipo, double cargaHoraria, int qtAulas, MatrizCurricular matriz) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.cargaHoraria = cargaHoraria;
        this.qtAulas = qtAulas;
        this.matriz = matriz;
    }

    public Disciplina(String nome, String tipo, double cargaHoraria, int qtAulas, MatrizCurricular matriz) {
        this.nome = nome;
        this.tipo = tipo;
        this.cargaHoraria = cargaHoraria;
        this.qtAulas = qtAulas;
        this.matriz = matriz;
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

    public int getQtAulas() {
        return qtAulas;
    }

    public void setQtAulas(int qtAulas) {
        this.qtAulas = qtAulas;
    }

    public MatrizCurricular getMatriz() {
        return matriz;
    }

    public void setMatriz(MatrizCurricular matriz) {
        this.matriz = matriz;
    }
}

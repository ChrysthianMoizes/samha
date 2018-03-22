package cdp;

import java.util.Collection;

public class Disciplina {
    
    private int id;
    private String nome;
    private int tipo;
    private double cargaHoraria;
    private Collection<Professor> professoresHabilitados;

    public Disciplina() {
    }

    public Disciplina(int id, String nome, int tipo, double cargaHoraria, Collection professoresHabilitados) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.cargaHoraria = cargaHoraria;
        this.professoresHabilitados = professoresHabilitados;
    }

    public Disciplina(String nome, int tipo, double cargaHoraria, Collection professoresHabilitados) {
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

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
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

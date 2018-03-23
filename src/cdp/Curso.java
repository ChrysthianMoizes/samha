package cdp;

import java.util.Collection;

public class Curso {
    
    private int id;
    private String nome;
    private int qtPeriodos;
    private String nivel;
    private Collection<Turma> turmas;

    public Curso() {
    }

    public Curso(int id, String nome, int qtPeriodos, Collection<Turma> turmas, String nivel) {
        this.id = id;
        this.nome = nome;
        this.qtPeriodos = qtPeriodos;
        this.turmas = turmas;
        this.nivel = nivel;
    }

    public Curso(String nome, int qtPeriodos, Collection<Turma> turmas, String nivel) {
        this.nome = nome;
        this.qtPeriodos = qtPeriodos;
        this.turmas = turmas;
        this.nivel = nivel;
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

    public Collection<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(Collection<Turma> turmas) {
        this.turmas = turmas;
    } 

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
}

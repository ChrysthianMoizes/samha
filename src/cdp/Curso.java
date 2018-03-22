package cdp;

import java.util.Collection;

public class Curso {
    
    private int id;
    private String nome;
    private int qtPeriodos;
    private Collection<Turma> turmas;

    public Curso() {
    }

    public Curso(int id, String nome, int qtPeriodos, Collection<Turma> turmas) {
        this.id = id;
        this.nome = nome;
        this.qtPeriodos = qtPeriodos;
        this.turmas = turmas;
    }

    public Curso(String nome, int qtPeriodos, Collection<Turma> turmas) {
        this.nome = nome;
        this.qtPeriodos = qtPeriodos;
        this.turmas = turmas;
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
}

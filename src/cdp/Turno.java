package cdp;

import java.util.Collection;

public class Turno {
    
    private int id;
    private String nome;
    private int qtAulas;
    private Collection<Aula> aulas;

    public Turno() {
    }

    public Turno(int id, String nome, int qtAulas, Collection<Aula> aulas) {
        this.id = id;
        this.nome = nome;
        this.qtAulas = qtAulas;
        this.aulas = aulas;
    }

    public Turno(String nome, int qtAulas, Collection<Aula> aulas) {
        this.nome = nome;
        this.qtAulas = qtAulas;
        this.aulas = aulas;
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

    public int getQtAulas() {
        return qtAulas;
    }

    public void setQtAulas(int qtAulas) {
        this.qtAulas = qtAulas;
    }

    public Collection<Aula> getAulas() {
        return aulas;
    }

    public void setAulas(Collection<Aula> aulas) {
        this.aulas = aulas;
    }
}

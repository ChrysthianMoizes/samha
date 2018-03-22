package cdp;

import java.io.Serializable;

public abstract class Servidor implements Serializable{
    
    private int id;
    private String nome;
    private String matricula;

    public Servidor() {
    }

    public Servidor(int id, String nome, String matricula) {
        this.id = id;
        this.nome = nome;
        this.matricula = matricula;
    }

    public Servidor(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
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

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}

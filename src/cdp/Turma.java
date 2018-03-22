package cdp;

import java.util.Collection;

public class Turma {
    
    private int id;
    private String nome;
    private String anoCriacao;
    private MatrizCurricular matriz;

    public Turma() {
    }

    public Turma(int id, String nome, String anoCriacao, MatrizCurricular matriz) {
        this.id = id;
        this.nome = nome;
        this.anoCriacao = anoCriacao;
        this.matriz = matriz;
    }

    public Turma(String nome, String anoCriacao, MatrizCurricular matriz) {
        this.nome = nome;
        this.anoCriacao = anoCriacao;
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

    public String getAnoCriacao() {
        return anoCriacao;
    }

    public void setAnoCriacao(String anoCriacao) {
        this.anoCriacao = anoCriacao;
    }

    public MatrizCurricular getMatriz() {
        return matriz;
    }

    public void setMatriz(MatrizCurricular matriz) {
        this.matriz = matriz;
    }
    
    
}

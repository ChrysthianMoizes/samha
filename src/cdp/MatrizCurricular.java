package cdp;

import java.util.Collection;

public class MatrizCurricular {
    
    private int id;
    private String nome;
    private String anoCriacao;
    private Collection<Disciplina> disciplinas;
    private Curso curso;

    public MatrizCurricular() {
    }

    public MatrizCurricular(int id, String nome, String anoCriacao, Collection<Disciplina> disciplinas, Curso curso) {
        this.id = id;
        this.nome = nome;
        this.anoCriacao = anoCriacao;
        this.disciplinas = disciplinas;
        this.curso = curso;
    }

    public MatrizCurricular(String nome, String anoCriacao, Collection<Disciplina> disciplinas, Curso curso) {
        this.nome = nome;
        this.anoCriacao = anoCriacao;
        this.disciplinas = disciplinas;
        this.curso = curso;
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

    public Collection<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(Collection<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}

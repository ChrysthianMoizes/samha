package cdp;

import java.util.Collection;

public class Coordenadoria {
    
    private int id;
    private String nome;
    private Curso curso;
    private ProfessorCoordenador coordenador;
    private Collection<Professor> professores;

    public Coordenadoria() {
    }

    public Coordenadoria(int id, String nome, Curso curso, ProfessorCoordenador coordenador, Collection<Professor> professores) {
        this.id = id;
        this.nome = nome;
        this.curso = curso;
        this.coordenador = coordenador;
        this.professores = professores;
    }

    public Coordenadoria(String nome, Curso curso, ProfessorCoordenador coordenador, Collection<Professor> professores) {
        this.nome = nome;
        this.curso = curso;
        this.coordenador = coordenador;
        this.professores = professores;
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

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public ProfessorCoordenador getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(ProfessorCoordenador coordenador) {
        this.coordenador = coordenador;
    }

    public Collection<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(Collection<Professor> professores) {
        this.professores = professores;
    }
}

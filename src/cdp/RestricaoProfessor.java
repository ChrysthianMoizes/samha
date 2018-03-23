package cdp;

import java.io.Serializable;

public class RestricaoProfessor implements Serializable{
    
    private int id;
    private String nome;
    private int prioridade;
    private Professor professor;
    private Dia dia;
    
    public RestricaoProfessor(){    
    }

    public RestricaoProfessor(int id, String nome, int prioridade, int turno, Professor professor, Dia dia) {
        this.id = id;
        this.nome = nome;
        this.dia = dia;
        this.prioridade = prioridade;
        this.professor = professor;
    }

    public RestricaoProfessor(String nome, int prioridade, int turno, Professor professor, Dia dia) {
        this.nome = nome;
        this.dia = dia;
        this.prioridade = prioridade;
        this.professor = professor;
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

    public Dia getDia() {
        return dia;
    }

    public void setDia(Dia dia) {
        this.dia = dia;
    }
    
    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}

package cdp;

import java.io.Serializable;
import java.util.List;

public class RestricaoProfessor implements Serializable{
    
    private int id;
    private String nome;
    private int dia;
    private List intervaloTempo;
    private int prioridade;
    private int turno;
    private Professor professor;
    
    public RestricaoProfessor(){    
    }

    public RestricaoProfessor(int id, String nome, int dia, List intervaloTempo, int prioridade, int turno, Professor professor) {
        this.id = id;
        this.nome = nome;
        this.dia = dia;
        this.intervaloTempo = intervaloTempo;
        this.prioridade = prioridade;
        this.turno = turno;
        this.professor = professor;
    }

    public RestricaoProfessor(String nome, int dia, List intervaloTempo, int prioridade, int turno, Professor professor) {
        this.nome = nome;
        this.dia = dia;
        this.intervaloTempo = intervaloTempo;
        this.prioridade = prioridade;
        this.turno = turno;
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

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public List getIntervaloTempo() {
        return intervaloTempo;
    }

    public void setIntervaloTempo(List intervaloTempo) {
        this.intervaloTempo = intervaloTempo;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}

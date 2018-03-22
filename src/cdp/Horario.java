
package cdp;

import java.util.Collection;

public class Horario {
    
    private int id;
    private String ano;
    private Turma turma;
    private Collection<RestricaoInstituicao> restricoes;
    private Collection<Turno> turnos;
    private Collection<DisciplinaProfessor> matutino;
    private Collection<DisciplinaProfessor> vespertino;
    private Collection<DisciplinaProfessor> noturno;

    public Horario() {
    }

    public Horario(int id, String ano, Turma turma, Collection<RestricaoInstituicao> restricoes, Collection<Turno> turnos, 
            Collection<DisciplinaProfessor> matutino, Collection<DisciplinaProfessor> vespertino, Collection<DisciplinaProfessor> noturno) {
        this.id = id;
        this.ano = ano;
        this.turma = turma;
        this.restricoes = restricoes;
        this.turnos = turnos;
        this.matutino = matutino;
        this.vespertino = vespertino;
        this.noturno = noturno;
    }

    public Horario(String ano, Turma turma, Collection<RestricaoInstituicao> restricoes, Collection<Turno> turnos, 
            Collection<DisciplinaProfessor> matutino, Collection<DisciplinaProfessor> vespertino, Collection<DisciplinaProfessor> noturno) {
        this.ano = ano;
        this.turma = turma;
        this.restricoes = restricoes;
        this.turnos = turnos;
        this.matutino = matutino;
        this.vespertino = vespertino;
        this.noturno = noturno;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Collection<RestricaoInstituicao> getRestricoes() {
        return restricoes;
    }

    public void setRestricoes(Collection<RestricaoInstituicao> restricoes) {
        this.restricoes = restricoes;
    }

    public Collection<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(Collection<Turno> turnos) {
        this.turnos = turnos;
    }

    public Collection<DisciplinaProfessor> getMatutino() {
        return matutino;
    }

    public void setMatutino(Collection<DisciplinaProfessor> matutino) {
        this.matutino = matutino;
    }

    public Collection<DisciplinaProfessor> getVespertino() {
        return vespertino;
    }

    public void setVespertino(Collection<DisciplinaProfessor> vespertino) {
        this.vespertino = vespertino;
    }

    public Collection<DisciplinaProfessor> getNoturno() {
        return noturno;
    }

    public void setNoturno(Collection<DisciplinaProfessor> noturno) {
        this.noturno = noturno;
    }  
}

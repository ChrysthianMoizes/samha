package cdp;

import java.util.Collection;

public class Horario {
    
    private int id;
    private String ano;
    private Turma turma;
    private RestricaoInstituicao restricoes;
    private Collection<Dia> dias;

    public Horario() {
    }

    public Horario(int id, String ano, Turma turma, RestricaoInstituicao restricoes, Collection<Dia> dias) {
        this.id = id;
        this.ano = ano;
        this.turma = turma;
        this.restricoes = restricoes;
    }

    public Horario(String ano, Turma turma, RestricaoInstituicao restricoes, Collection<Dia> dias) {
        this.ano = ano;
        this.turma = turma;
        this.restricoes = restricoes;
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

    public RestricaoInstituicao getRestricoes() {
        return restricoes;
    }

    public void setRestricoes(RestricaoInstituicao restricoes) {
        this.restricoes = restricoes;
    }

    public Collection<Dia> getDias() {
        return dias;
    }

    public void setDias(Collection<Dia> dias) {
        this.dias = dias;
    }
}

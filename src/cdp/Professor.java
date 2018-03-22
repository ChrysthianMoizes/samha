package cdp;

import java.util.Collection;

public class Professor extends Servidor{
    
    private String email;
    private double cargaHoraria;
    private Collection<RestricaoProfessor> restricoes;
    
    public Professor() {
    }
    
    public Professor(String email, double cargaHoraria, int id, String nome, String matricula, Collection restricoes) {
        super(id, nome, matricula);
        this.email = email;
        this.cargaHoraria = cargaHoraria;
        this.restricoes = restricoes;
    }

    public Professor(String email, double cargaHoraria, String nome, String matricula, Collection restricoes) {
        super(nome, matricula);
        this.email = email;
        this.cargaHoraria = cargaHoraria;
        this.restricoes = restricoes;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(double cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Collection getRestricoes() {
        return restricoes;
    }

    public void setRestricoes(Collection restricoes) {
        this.restricoes = restricoes;
    }
}

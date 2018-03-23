
package cdp;

import java.util.Collection;

public class Dia {
    
    private int id;
    private String nome;
    private Collection<Turno> turnos;

    public Dia() {
    }

    public Dia(int id, String nome, Collection<Turno> turnos) {
        this.id = id;
        this.nome = nome;
        this.turnos = turnos;
    }

    public Dia(String nome, Collection<Turno> turnos) {
        this.nome = nome;
        this.turnos = turnos;
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

    public Collection<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(Collection<Turno> turnos) {
        this.turnos = turnos;
    }
}

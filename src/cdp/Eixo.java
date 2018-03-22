package cdp;

import java.util.Collection;

public class Eixo {
    
    private int id;
    private String nome;
    private Collection<Coordenadoria> coordenadorias;

    public Eixo() {
    }

    public Eixo(int id, String nome, Collection<Coordenadoria> coordenadorias) {
        this.id = id;
        this.nome = nome;
        this.coordenadorias = coordenadorias;
    }

    public Eixo(String nome, Collection<Coordenadoria> coordenadorias) {
        this.nome = nome;
        this.coordenadorias = coordenadorias;
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

    public Collection<Coordenadoria> getCoordenadorias() {
        return coordenadorias;
    }

    public void setCoordenadorias(Collection<Coordenadoria> coordenadorias) {
        this.coordenadorias = coordenadorias;
    } 
}

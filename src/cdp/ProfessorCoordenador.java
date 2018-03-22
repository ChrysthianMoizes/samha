package cdp;

public class ProfessorCoordenador extends Servidor{
    
    private Coordenador coordenador;
    private Coordenadoria coordenadoria;
    private Eixo eixo;

    public ProfessorCoordenador() {
    }

    public ProfessorCoordenador(Coordenador coordenador, Coordenadoria coordenadoria, Eixo eixo) {
        this.coordenador = coordenador;
        this.coordenadoria = coordenadoria;
        this.eixo = eixo;
    }

    public ProfessorCoordenador(Coordenador coordenador, Coordenadoria coordenadoria, Eixo eixo, int id, String nome, String matricula) {
        super(id, nome, matricula);
        this.coordenador = coordenador;
        this.coordenadoria = coordenadoria;
        this.eixo = eixo;
    }

    public ProfessorCoordenador(Coordenador coordenador, Coordenadoria coordenadoria, Eixo eixo, String nome, String matricula) {
        super(nome, matricula);
        this.coordenador = coordenador;
        this.coordenadoria = coordenadoria;
        this.eixo = eixo;
    }

    public Coordenador getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(Coordenador coordenador) {
        this.coordenador = coordenador;
    }

    public Coordenadoria getCoordenadoria() {
        return coordenadoria;
    }

    public void setCoordenadoria(Coordenadoria coordenadoria) {
        this.coordenadoria = coordenadoria;
    }

    public Eixo getEixo() {
        return eixo;
    }

    public void setEixo(Eixo eixo) {
        this.eixo = eixo;
    }
}

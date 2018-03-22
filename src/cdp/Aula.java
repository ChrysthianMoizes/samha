package cdp;

public class Aula {
    
    private int id;
    private double horarioInicio;
    private double horarioTermino;

    public Aula() {
    }

    public Aula(int id, double horarioInicio, double horarioTermino) {
        this.id = id;
        this.horarioInicio = horarioInicio;
        this.horarioTermino = horarioTermino;
    }

    public Aula(double horarioInicio, double horarioTermino) {
        this.horarioInicio = horarioInicio;
        this.horarioTermino = horarioTermino;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(double horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public double getHorarioTermino() {
        return horarioTermino;
    }

    public void setHorarioTermino(double horarioTermino) {
        this.horarioTermino = horarioTermino;
    }
}

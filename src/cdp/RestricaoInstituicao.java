package cdp;

public class RestricaoInstituicao {
    
    private int id;
    private double tempoMaximoTrabalho;
    private double intervaloMinimo;

    public RestricaoInstituicao() {
    }

    public RestricaoInstituicao(int id, double tempoMaximoTrabalho, double intervaloMinimo) {
        this.id = id;
        this.tempoMaximoTrabalho = tempoMaximoTrabalho;
        this.intervaloMinimo = intervaloMinimo;
    }

    public RestricaoInstituicao(double tempoMaximoTrabalho, double intervaloMinimo) {
        this.tempoMaximoTrabalho = tempoMaximoTrabalho;
        this.intervaloMinimo = intervaloMinimo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTempoMaximoTrabalho() {
        return tempoMaximoTrabalho;
    }

    public void setTempoMaximoTrabalho(double tempoMaximoTrabalho) {
        this.tempoMaximoTrabalho = tempoMaximoTrabalho;
    }

    public double getIntervaloMinimo() {
        return intervaloMinimo;
    }

    public void setIntervaloMinimo(double intervaloMinimo) {
        this.intervaloMinimo = intervaloMinimo;
    }
}

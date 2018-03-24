package cdp;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "restricao_instituicao")
public class RestricaoInstituicao implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false, precision = 2)
    private double tempoMaximoTrabalho;
    
    @Column(nullable = false, precision = 2)
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

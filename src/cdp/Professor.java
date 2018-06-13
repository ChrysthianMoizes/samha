package cdp;

import java.util.Collection;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "professor")
@PrimaryKeyJoinColumn(name = "professor_id")
public class Professor extends Servidor implements Comparable<Object>{
    
    @Column(nullable = false)
    private int cargaHoraria;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "coordenadoria_id", nullable = false)
    private Coordenadoria coordenadoria;
    
    public Professor() {
    }

    public Professor(int cargaHoraria, Coordenadoria coordenadoria, int id, String nome, String matricula, String email) {
        super(id, nome, matricula, email);
        this.cargaHoraria = cargaHoraria;
        this.coordenadoria = coordenadoria;
    }

    public Professor(int cargaHoraria, Collection<RestricaoProfessor> restricoes, Coordenadoria coordenadoria, String nome, String matricula, String email) {
        super(nome, matricula, email);
        this.cargaHoraria = cargaHoraria;
        this.coordenadoria = coordenadoria;
    }
    
    public String getPrimeiroNome(){
        int espaco = this.getNome().indexOf(" ");
        if(espaco > 0){
            String primeiroNome = this.getNome().substring(0, espaco);
            return primeiroNome;
        }
        return getNome();
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Coordenadoria getCoordenadoria() {
        return coordenadoria;
    }

    public void setCoordenadoria(Coordenadoria coordenadoria) {
        this.coordenadoria = coordenadoria;
    }
    
    public Object[] toArray() {
        return new Object[] { this, getMatricula(), getCoordenadoria().getNome()};
    }
    
    public Object[] toArrayCargaHoraria() {
        return new Object[] { this, getCargaHoraria()};
    }

    @Override
    public int compareTo(Object o) {
        
        Professor other = (Professor) o;  
        return this.getNome().compareTo(other.getNome());
    }
}

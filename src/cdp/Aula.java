package cdp;

public class Aula {
    
    private int id;
    private double horarioInicio;
    private double horarioTermino;
    private DisciplinaProfessor disciplina;
    private boolean disponivel = true;

    public Aula() {
    }

    public Aula(int id, double horarioInicio, double horarioTermino, DisciplinaProfessor disciplina) {
        this.id = id;
        this.horarioInicio = horarioInicio;
        this.horarioTermino = horarioTermino;
    }

    public Aula(double horarioInicio, double horarioTermino, DisciplinaProfessor disciplina) {
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

    public DisciplinaProfessor getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(DisciplinaProfessor disciplina) {
        this.disciplina = disciplina;
    } 

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}

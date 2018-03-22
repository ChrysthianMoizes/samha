package cdp;

public class DisciplinaProfessor {
    
    private int id;
    private Disciplina disciplina;
    private Professor professor;

    public DisciplinaProfessor() {
    }

    public DisciplinaProfessor(int id, Disciplina disciplina, Professor professor) {
        this.id = id;
        this.disciplina = disciplina;
        this.professor = professor;
    }

    public DisciplinaProfessor(Disciplina disciplina, Professor professor) {
        this.disciplina = disciplina;
        this.professor = professor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}

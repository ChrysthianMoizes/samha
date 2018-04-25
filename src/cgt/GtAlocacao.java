package cgt;

import cdp.Alocacao;
import cdp.Disciplina;
import cdp.Professor;
import cgd.GdAlocacao;
import java.util.ArrayList;
import java.util.List;

public class GtAlocacao {
    
    private GdAlocacao gdAlocacao;
    
    public GtAlocacao(){
        gdAlocacao = new GdAlocacao();
    }
    
    public List calcularCargaHorariaProfessor(int ano, int semestre, List listaProfessores){
        
        List listaAlocacoes = gdAlocacao.filtrarPorAnoSemestre(ano, semestre);
        List listaCargaHoraria = new ArrayList<>();
        Alocacao alocacao;
        Professor professor;
        
        for(int i = 0; i < listaProfessores.size(); i++){
            professor = (Professor) listaProfessores.get(i);
            professor.setCargaHoraria(0);
            
            for(int j = 0; j < listaAlocacoes.size(); j++){
                
                alocacao = (Alocacao) listaAlocacoes.get(j);
                
                if(alocacao.getProfessor1().getId() == professor.getId()){
                    int cargaHoraria = professor.getCargaHoraria();
                    professor.setCargaHoraria(cargaHoraria + alocacao.getDisciplina().getQtAulas());
                } 
                
                if(alocacao.getDisciplina().getTipo().toLowerCase().equals(Constantes.ESPECIAL)){
                    
                    if(alocacao.getProfessor2().getId() == professor.getId()){
                        int cargaHoraria = professor.getCargaHoraria();
                        professor.setCargaHoraria(cargaHoraria + alocacao.getDisciplina().getQtAulas());
                    }  
                }               
            }
            listaCargaHoraria.add(professor);
        }
        return listaCargaHoraria;
    }
    
    public String cadastrar(List listaProfessores, Disciplina disciplina, int ano, int semestre) {

        try {
            
            validarCampos(listaProfessores, disciplina);
            Alocacao alocacao = new Alocacao(); 
            alocacao.setAno(ano);
            alocacao.setDisciplina(disciplina);
            alocacao.setSemestre(semestre);
            Professor professor = (Professor) listaProfessores.get(0);
            alocacao.setProfessor1(professor);

            if(disciplina.getTipo().toLowerCase().equals(Constantes.ESPECIAL)){
                Professor professor2 = (Professor) listaProfessores.get(1);
                alocacao.setProfessor2(professor2);
            }
            
            gdAlocacao.cadastrar(alocacao);
            return Constantes.CADASTRADO;
            
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
    
    public List filtrarPorAnoSemestre(int ano, int semestre){    
        return gdAlocacao.filtrarPorAnoSemestre(ano, semestre);  
    }
    
    public String excluir(Alocacao alocacao) {

        try {
            
            gdAlocacao.excluir(alocacao);
            return Constantes.EXCLUIDO;
            
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
    
    public void validarCampos(List listaProfessores, Disciplina disciplina) throws SAMHAException{
        
        if(disciplina == null)
            throw new SAMHAException(17);
        
        if(listaProfessores != null){
            
            Professor professor = (Professor) listaProfessores.get(0);
            if(professor == null)
                throw new SAMHAException(18);   
            
            if(disciplina.getTipo().toLowerCase().equals(Constantes.ESPECIAL)){
                
                Professor professor2 = (Professor) listaProfessores.get(1);
                if(professor2 == null)
                    throw new SAMHAException(21);
                
                if(listaProfessores.size() != 2)
                    throw new SAMHAException(19);
                  
            }else{
                
                if(listaProfessores.size() > 1)
                    throw new SAMHAException(20);
                     
            }
        }else
            throw new SAMHAException(18);     
    }
    
}

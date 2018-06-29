package cgt;

import cdp.Alocacao;
import cdp.Disciplina;
import cdp.Professor;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GtAlocacao {
    
    private GtPrincipal gtPrincipal;
    
    public GtAlocacao(GtPrincipal gt){
        gtPrincipal = gt;
    }
    
    public List calcularCargaHorariaProfessor(int ano, int semestre, List listaProfessores){
        
        List listaAlocacoes = gtPrincipal.getGdPrincipal().getGdAlocacao().filtrarPorAnoSemestre(ano, semestre);
        List listaCargaHoraria = new ArrayList<>();
        Alocacao alocacao;
        Professor professor;
        boolean adicionado;
        
        if(listaProfessores != null){
        
            for(int i = 0; i < listaProfessores.size(); i++){

                professor = (Professor) listaProfessores.get(i);
                professor.setCargaHoraria(0);
                adicionado = false;

                for(int j = 0; j < listaAlocacoes.size(); j++){

                    alocacao = (Alocacao) listaAlocacoes.get(j);

                    if(alocacao.getProfessor1().getId() == professor.getId())
                        adicionado = somarCargaHoraria(professor, alocacao);

                    if(alocacao.getDisciplina().getTipo().equals(Constantes.ESPECIAL)){
                        if(alocacao.getProfessor2().getId() == professor.getId())
                            adicionado = somarCargaHoraria(professor, alocacao);  
                    }               
                }
                if(adicionado)
                    listaCargaHoraria.add(professor);
            }
        }
        return listaCargaHoraria;
    }
    
    public boolean somarCargaHoraria(Professor professor, Alocacao alocacao){
        int cargaHoraria = professor.getCargaHoraria();
        professor.setCargaHoraria(cargaHoraria + alocacao.getDisciplina().getQtAulas());
        return true;
    }
    
    public String cadastrar(List listaProfessores, Disciplina disciplina, int ano, int semestre) {

        try {
            gtPrincipal.identificarPermissaoPadrao();
            validarCampos(listaProfessores, disciplina);    
            Alocacao alocacao = new Alocacao(); 
            alocacao.setAno(ano);
            alocacao.setDisciplina(disciplina);
            alocacao.setSemestre(semestre);
            Professor professor = (Professor) listaProfessores.get(0);
            alocacao.setProfessor1(professor);

            if(disciplina.getTipo().equals(Constantes.ESPECIAL)){
                Professor professor2 = (Professor) listaProfessores.get(1);
                alocacao.setProfessor2(professor2);
            }

            gtPrincipal.getGdPrincipal().getGdAlocacao().cadastrar(alocacao);
            return Constantes.CADASTRADO;
            
        } catch (SAMHAException | ClassNotFoundException | SQLException ex) {
            return ex.getMessage();
        }
    }
    
    public List filtrarPorAnoSemestreMatriz(int ano, int semestre, int periodo, int matriz){ 
        List lista = gtPrincipal.getGdPrincipal().getGdAlocacao().filtrarPorAnoSemestreMatriz(ano, semestre, periodo, matriz);  
        Collections.sort(lista);
        return lista;
    }
    
    public Alocacao identificarUltimaAlocacao(){
        Alocacao ultimaAlocacao = gtPrincipal.getGdPrincipal().getGdAlocacao().filtrarUltimaAlocacao();
        return ultimaAlocacao;
    }
    
    public String excluir(Alocacao alocacao) {

        try {
            gtPrincipal.identificarPermissaoPadrao();
            gtPrincipal.getGdPrincipal().getGdAlocacao().excluir(alocacao);
            return Constantes.EXCLUIDO;
            
        } catch (SAMHAException | ClassNotFoundException | SQLException ex) {
            return "Alocação está associada a uma Oferta.";
        }
    }
    
    public void validarCampos(List listaProfessores, Disciplina disciplina) throws SAMHAException{
        
        if(disciplina == null)
            throw new SAMHAException(17);
        
        if(!listaProfessores.isEmpty()){
            
            if(disciplina.getTipo().equals(Constantes.ESPECIAL)){
                
                if(listaProfessores.size() != 2)
                    throw new SAMHAException(19);
                
                Professor professor2 = (Professor) listaProfessores.get(1);
                if(professor2 == null)
                    throw new SAMHAException(21);
  
            }else{
                
                if(listaProfessores.size() > 1)
                    throw new SAMHAException(20);          
            }
        }else
            throw new SAMHAException(18);     
    }
}

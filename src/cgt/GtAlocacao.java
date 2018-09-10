package cgt;

import cdp.Alocacao;
import cdp.Aula;
import cdp.Disciplina;
import cdp.Professor;
import cdp.Turma;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GtAlocacao {
    
    private GtPrincipal gtPrincipal;
    
    public GtAlocacao(GtPrincipal gt){
        gtPrincipal = gt;
    }
    
    public List calcularCargaHorariaProfessor(int ano, int semestre, List listaProfessores){
        
        atualizarListaAulasAnoSemestre(ano, semestre);
        
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

                    int qtTurmas = filtrarQuantidadeTurmasAlocacao(alocacao.getId());
                    
                    if(alocacao.getProfessor1().getId() == professor.getId())
                        adicionado = somarCargaHoraria(professor, alocacao, qtTurmas);

                    if(alocacao.getDisciplina().getTipo().equals(Constantes.ESPECIAL)){
                        if(alocacao.getProfessor2().getId() == professor.getId())
                            adicionado = somarCargaHoraria(professor, alocacao, qtTurmas);  
                    }               
                }
                if(adicionado)
                    listaCargaHoraria.add(professor);
            }
        }
        return listaCargaHoraria;
    }
    
    public boolean somarCargaHoraria(Professor professor, Alocacao alocacao, double qtTurmas){
        
        double cargaHoraria = professor.getCargaHoraria();
        double qtAulas = (double) alocacao.getDisciplina().getCargaHoraria() / (double) 15;
  
        double total = cargaHoraria + (qtAulas * qtTurmas);
        
        DecimalFormat df = new DecimalFormat("0.##");
        String valor = df.format(total);

        double valorFormatado = Double.parseDouble(valor.replace(",", "."));    
        professor.setCargaHoraria(valorFormatado);
        
        return true;
    }
    
    public int filtrarQuantidadeTurmasAlocacao(int idAlocacao){

        List<Aula> listaAulas = gtPrincipal.getGtAula().filtrarAulasAlocacao(idAlocacao);
        
        List<Turma> listaTurmas = new ArrayList<>();
        
        for(Aula aula : listaAulas){
            Turma turma = aula.getOferta().getTurma();
            if(!listaTurmas.contains(turma)){
                listaTurmas.add(turma);
            }
        }
        
        if(listaTurmas.size() <= 1)
            return 1;

        return listaTurmas.size();
    }
    
    public List identificarQuantidadeUsoEmAulas(int ano, int semestre, List<Alocacao> listaAlocacoes){
        
        atualizarListaAulasAnoSemestre(ano, semestre);
        
        List aulas;
        int qtTurmas;
        
        for(Alocacao alocacao : listaAlocacoes){
            alocacao.setCompleta(false);
            qtTurmas = filtrarQuantidadeTurmasAlocacao(alocacao.getId());
            aulas = gtPrincipal.getGtAula().filtrarAulasAlocacao(alocacao.getId());
            if(aulas.size() == (alocacao.getDisciplina().getQtAulas() * qtTurmas)){
                alocacao.setCompleta(true);
            }
        }
        
        return listaAlocacoes;
    }
    
    
   public void atualizarListaAulasAnoSemestre(int ano, int semestre){
       if(gtPrincipal.getGtAula().getListaAulasAnoSemestre() == null){
            gtPrincipal.getGtAula().preencherListaAulasAnoSemestre(ano, semestre);
       }else{
           if(!gtPrincipal.getGtAula().getListaAulasAnoSemestre().isEmpty()){
               Aula aula = (Aula) gtPrincipal.getGtAula().getListaAulasAnoSemestre().get(0);
               if(aula.getOferta().getAno() != ano || aula.getOferta().getSemestre() != semestre)
                   gtPrincipal.getGtAula().preencherListaAulasAnoSemestre(ano, semestre);
           }else
               gtPrincipal.getGtAula().preencherListaAulasAnoSemestre(ano, semestre);
       }
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

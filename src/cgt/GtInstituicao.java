package cgt;

import cdp.Aula;
import cdp.Oferta;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GtInstituicao {
    
    private GtPrincipal gtPrincipal;
    private List[] vetorAulas;
    private List[] vetorTempoMaximo;
    private List[] vetorIntervalo;
    
    public GtInstituicao(GtPrincipal gt){
        this.gtPrincipal = gt;  
    }
    
    public void preencherVetorAulas(Aula aula, int idProfessor){
        
        int ano = aula.getAlocacao().getAno();
        int semestre = aula.getAlocacao().getSemestre();
        
        vetorAulas = new List[Constantes.LINHA];
        
        for(int linha = 0; linha < Constantes.LINHA; linha++){
            
            vetorAulas[linha] = gtPrincipal.getGdPrincipal().getGdAula().filtrarAulasDiaProfessorAnoSemestre(linha, idProfessor, ano, semestre);
            
            List aulasDia = vetorAulas[linha];
            Aula a, aulaMatriz;
            
            for(int col = 0; col < aulasDia.size(); col++){
                a = (Aula) aulasDia.get(col);
                aulaMatriz = gtPrincipal.getGtAula().getAulaMatriz(a.getDia(), a.getNumero());
                if(aulaMatriz == null && (a.getOferta().getTurma().getId() == aula.getOferta().getTurma().getId()))
                    vetorAulas[linha].remove(col);
            }

            for(int coluna = 0; coluna < Constantes.COLUNA; coluna++){
                a = gtPrincipal.getGtAula().getAulaMatriz(linha, coluna);
                if(a != null){
                    if(a.getId() == 0)
                        vetorAulas[linha].add(a);
                }
            }   
            Collections.sort(vetorAulas[linha]);
        }
    }
    
    public void limparVetoresInstituicao(){
        for(int linha = 0; linha < Constantes.LINHA; linha++){
            vetorTempoMaximo[linha].clear();
            vetorIntervalo[linha].clear();
        }
    }
    
    public void instanciarVetoresInstituicao(){
              
        if(vetorIntervalo == null && vetorTempoMaximo == null){
        
            vetorTempoMaximo = new List[Constantes.LINHA];
            vetorIntervalo = new List[Constantes.LINHA];

            for(int linha = 0; linha < Constantes.LINHA; linha++){
                vetorTempoMaximo[linha] = new ArrayList<>();
                vetorIntervalo[linha] = new ArrayList<>();
            }
            
        }else
            limparVetoresInstituicao();
    }
    
    public boolean identificarProfessor(List[] vetor, int chave, int dia){
        
        List<Integer> aulas = vetor[dia];
        
        for(Integer a : aulas){
            if(a == chave)
                return true;
        }
        return false;
    }
    
    public List identificarConflitoRestricaoInstituicao(Aula aula, int numeroProfessor){
        
        int idProfessor = aula.getAlocacao().getProfessor1().getId();
        int dia = aula.getDia();
        List mensagens = new ArrayList<>();
        
        if(numeroProfessor != 1)
            idProfessor = aula.getAlocacao().getProfessor2().getId();
        preencherVetorAulas(aula, idProfessor);
        
        if(!identificarProfessor(vetorTempoMaximo, idProfessor, dia)){
            vetorTempoMaximo[dia].add(idProfessor);
            String tempoMaximo = identificarConflitoTempoMaximo(dia, idProfessor);
            if(tempoMaximo != null) mensagens.add(tempoMaximo);
        }
       
        if(!identificarProfessor(vetorIntervalo, idProfessor, dia)){
            vetorIntervalo[dia].add(idProfessor);
            String intervalo = identificarConflitoIntervaloMinimo(dia, idProfessor);
            if(intervalo != null) mensagens.add(intervalo);
        }
        return mensagens;
    }
    
    public String identificarConflitoTempoMaximo(int dia, int idProfessor){
        
        Aula primeiraAula, ultimaAula;
        int tempo;
        
        Oferta oferta = gtPrincipal.getGtOferta().getOfertaSelecionada();
        List aulas = vetorAulas[dia];

        if(aulas.size() > 1){

            primeiraAula = (Aula) aulas.get(0);
            ultimaAula = (Aula) aulas.get(aulas.size() - 1);

            tempo = calcularDiferencaHoras(primeiraAula, ultimaAula, Constantes.TEMPO_MAXIMO);
            
            if(tempo > oferta.getTempoMaximoTrabalho())
                return montarMensagemTempoMaximo(ultimaAula, primeiraAula, tempo);
        }
        
        return null;
    }
    
    public String montarMensagemTempoMaximo(Aula ultima, Aula primeira, int tempo){
        
        String mensagem = null;
        String nomeProfessor = ultima.getAlocacao().getProfessor1().getPrimeiroNome();
        
        String tipoUltima = ultima.getAlocacao().getDisciplina().getTipo();
        String tipoPrimeira = primeira.getAlocacao().getDisciplina().getTipo();

        
        if(tipoUltima.equals(Constantes.ESPECIAL) || tipoPrimeira.equals(Constantes.ESPECIAL))
            mensagem = "1 Um professor(a) da disciplina ESPECIAL possui um tempo máximo de trabalho superior ao permitido:\n" 
                    + primeira.getOferta().getTurma().getNome() + " | " 
                    + ultima.getOferta().getTurma().getNome() + " - " +  tempo + " horas.";
        else  
            mensagem = "1 " + nomeProfessor + " possui um tempo máximo de trabalho superior ao permitido:\n" 
                    + primeira.getOferta().getTurma().getNome() + " | " 
                    + ultima.getOferta().getTurma().getNome() + " - " +  tempo + " horas.";     
        
        return mensagem;
    }    
    
    public String identificarConflitoIntervaloMinimo(int dia, int idProfessor){
        
        if(dia != 0){
            
            List aulasDiaAtual, aulasDiaAnterior;
            Aula primeiraAula, ultimaAula;
            int tempo;

            int diaAnterior = dia - 1;

            Oferta oferta = gtPrincipal.getGtOferta().getOfertaSelecionada();

            aulasDiaAnterior = vetorAulas[diaAnterior];
            aulasDiaAtual = vetorAulas[dia];

            if(!aulasDiaAnterior.isEmpty() && !aulasDiaAtual.isEmpty()){
                      
                primeiraAula = (Aula) aulasDiaAtual.get(0);
                ultimaAula = (Aula) aulasDiaAnterior.get(aulasDiaAnterior.size() - 1);
                
                tempo = calcularDiferencaHoras(primeiraAula, ultimaAula, Constantes.INTERVALO_MINIMO);

                if(tempo < oferta.getIntervaloMinimo())
                    return montarMensagemIntervaloMinimo(ultimaAula, primeiraAula, tempo);
            }
        }
         
        return null;
    }
    
    public String montarMensagemIntervaloMinimo(Aula ultima, Aula primeira, int tempo){
    
        String mensagem = null;
        String nomeProfessor = ultima.getAlocacao().getProfessor1().getPrimeiroNome();
        
        String tipoUltima = ultima.getAlocacao().getDisciplina().getTipo();
        String tipoPrimeira = primeira.getAlocacao().getDisciplina().getTipo();
        
        String diaAnterior = obterStringDia(ultima.getDia());
        String diaAtual = obterStringDia(primeira.getDia());
        
        String horarioFinal = obterHorarioFinal(ultima);
        String horarioInicial = obterHorarioInicial(primeira);
     
        if(tipoUltima.equals(Constantes.ESPECIAL) || tipoPrimeira.equals(Constantes.ESPECIAL)){
            mensagem = "1 Um professor(a) da disciplina ESPECIAL possui um intervalo mínimo de descanso inferior ao permitido: "  
                    + tempo + " horas. " + ultima.getOferta().getTurma().getNome() + ": " + diaAnterior + " - " + horarioFinal + ". "
                    + primeira.getOferta().getTurma().getNome() + ": " + diaAtual + " - " + horarioInicial + ".";
        }else{  
            mensagem = "1 " + nomeProfessor + " possui um intervalo mínimo de descanso inferior ao permitido: " + tempo + " horas.\n"
                    + ultima.getOferta().getTurma().getNome() + ": " + diaAnterior + " - " + horarioFinal + ".\n"
                    + primeira.getOferta().getTurma().getNome() + ": "+ diaAtual + " - " + horarioInicial + ".";     
        }
        return mensagem;
    }    
    
    public String obterHorarioInicial(Aula aula){
        
        String horarioInicial = Horarios.horarioInicial(aula.getNumero());
        return horarioInicial;
    }
    
    public String obterHorarioFinal(Aula aula){
        
        String horarioFinal = Horarios.horarioFinal(aula.getNumero());  
        return horarioFinal;
    }
    
    public int calcularDiferencaHoras(Aula primeira, Aula ultima, int flag){
        
        String horarioInicial = obterHorarioInicial(primeira);
        String horarioFinal = obterHorarioFinal(ultima);
        
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm").withResolverStyle(ResolverStyle.STRICT);
        
        LocalTime inicio = LocalTime.parse(horarioInicial, formato);
        LocalTime fim = LocalTime.parse(horarioFinal, formato);
        
        LocalTime diferenca = fim.minusHours(inicio.getHour()).minusMinutes(inicio.getMinute());
        String dif = diferenca.format(formato);

        String[] horas = dif.split(":");
        
        int qtHoras = Integer.parseInt(horas[0]);
        
        if(flag == Constantes.INTERVALO_MINIMO)
            return 24 - qtHoras;
        
        return qtHoras;
    }
    
    public String obterStringDia(int dia){

        switch(dia){
            
            case 0:
                return Constantes.SEGUNDA;
            case 1:
                return Constantes.TERCA;
            case 2:
                return Constantes.QUARTA;
            case 3:
                return Constantes.QUINTA;    
            default:
                return Constantes.SEXTA; 
        }  
    }
}

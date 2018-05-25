package cgt;

import cdp.Aula;
import cdp.Oferta;
import cdp.Professor;
import cdp.RestricaoProfessor;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GtConflito {
    
    private GtPrincipal gtPrincipal;
    private List[] vetor;
    
    public GtConflito(GtPrincipal gt) {
        this.gtPrincipal = gt;
    }
      
    public List validarOferta(Aula aula){
 
        Professor professor = aula.getAlocacao().getProfessor1();
        
        List mensagens = identificarConflitos(aula, professor.getId(), 1);
        
        if(aula.getAlocacao().getDisciplina().getTipo().equals(Constantes.ESPECIAL)){
            Professor professor2 = aula.getAlocacao().getProfessor2();
            List msg = identificarConflitos(aula, professor2.getId(), 2);
            mensagens.addAll(msg);
        }
   
        return mensagens;
    }
    
    public List identificarConflitos(Aula aula, int idProfessor, int numeroProfessor){
        
        List mensagens = new ArrayList<>();
        
        String mensagemConflitoTurma = identificarConflitoTurma(aula, idProfessor);
        if(mensagemConflitoTurma != null) mensagens.add(mensagemConflitoTurma);
        
        List mensagemConflitoInstituicao = identificarConflitoRestricaoInstituicao(aula, numeroProfessor);
        mensagens.addAll(mensagemConflitoInstituicao);
        
        String mensagemConflitoRestricaoProfessor = identificarConflitoRestricaoProfessor(aula, idProfessor);
        if(mensagemConflitoRestricaoProfessor != null) mensagens.add(mensagemConflitoRestricaoProfessor);
        
        return mensagens;
    }
    
    public String identificarConflitoTurma(Aula aula, int idProfessor){
           
        List aulas = gtPrincipal.getGdPrincipal().getGdAula().identificarConflitoAula(aula.getAlocacao().getAno(), aula.getAlocacao().getSemestre(), 
                idProfessor, aula.getNumero(), aula.getDia());
        
        if(aulas.size() <= 1){

            if(!aulas.isEmpty()){
                
                Aula aulaLista = (Aula) aulas.get(0);
                
                if(aulaLista.getId() == aula.getId())
                    return null;
                else
                    return montarMensagemConflitoTurma(aulas, aula);
            }else
                return null;
        }else
            return montarMensagemConflitoTurma(aulas, aula);
    }
    
    public String montarMensagemConflitoTurma(List aulas, Aula aulaAtual){
        
        Aula aula;
        String novaMensagem = "0 Professor está em outra turma neste horário: ";

        for(int i = 0; i < aulas.size(); i++){
            aula = (Aula) aulas.get(i);
            if(aula.getOferta().getTurma().getId() != aulaAtual.getOferta().getTurma().getId())
                novaMensagem = novaMensagem + aula.getOferta().getTurma().getNome() + " - " + aula.getAlocacao().getDisciplina().getNome() + ". ";           
        }     
        return novaMensagem;
    }
    
    public List identificarConflitoRestricaoInstituicao(Aula aula, int numeroProfessor){
        
        int idProfessor = aula.getAlocacao().getProfessor1().getId();
        List mensagens = new ArrayList<>();
        
        if(numeroProfessor != 1)
            idProfessor = aula.getAlocacao().getProfessor2().getId();
        preencherVetorAulas(aula, idProfessor);
        
        //passar id professor como parametro
        
        // verificar se prof existe na strutura
        
        String tempoMaximo = identificarConflitoTempoMaximo(aula.getDia());
        if(tempoMaximo != null) mensagens.add(tempoMaximo);
        
        //verificar se existe na strutura
        
        String intervalo = identificarConflitoIntervaloMinimo(aula.getDia());
        if(intervalo != null) mensagens.add(intervalo);
        
        return mensagens;
    }
    
    public void preencherVetorAulas(Aula aula, int idProfessor){
        
        int ano = aula.getAlocacao().getAno();
        int semestre = aula.getAlocacao().getSemestre();
        
        vetor = new List[Constantes.LINHA];
        
        for(int linha = 0; linha < Constantes.LINHA; linha++){
            
            vetor[linha] = gtPrincipal.getGdPrincipal().getGdAula().filtrarAulasDiaProfessorAnoSemestre(linha, idProfessor, ano, semestre);
            
            Aula a;
            for(int coluna = 0; coluna < Constantes.COLUNA; coluna++){
                a = gtPrincipal.getGtAula().getAulaMatriz(linha, coluna);
                if(a != null){
                    if(a.getId() == 0)
                        vetor[linha].add(a);
                }
            }
           
            Collections.sort(vetor[linha]);
        }
    }
    
    public String identificarConflitoTempoMaximo(int dia){
        
        Aula primeiraAula, ultimaAula;
        int tempo;
        
        Oferta oferta = gtPrincipal.getGtOferta().getOfertaSelecionada();
        List aulas = vetor[dia];

        if(aulas.size() > 1){

            primeiraAula = (Aula) aulas.get(0);
            
            //colocar na estrutura
            
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
            mensagem = "1 Um professor(a) da disciplina ESPECIAL possui um tempo máximo de trabalho superior ao permitido:\n" + primeira.getOferta().getTurma().getNome() + " | " 
                    + ultima.getOferta().getTurma().getNome() + " - " +  tempo + " horas.";
        else  
            mensagem = "1 " + nomeProfessor + " possui um tempo máximo de trabalho superior ao permitido:\n" + primeira.getOferta().getTurma().getNome() + " | " 
                    + ultima.getOferta().getTurma().getNome() + " - " +  tempo + " horas.";     
        
        return mensagem;
    }    
    
    public String identificarConflitoIntervaloMinimo(int dia){
        
        if(dia != 0){
            
            List aulasDiaAtual, aulasDiaAnterior;
            Aula primeiraAula, ultimaAula;
            int tempo;

            int diaAnterior = dia - 1;

            Oferta oferta = gtPrincipal.getGtOferta().getOfertaSelecionada();

            aulasDiaAnterior = vetor[diaAnterior];
            aulasDiaAtual = vetor[dia];

            if(!aulasDiaAnterior.isEmpty() && !aulasDiaAtual.isEmpty()){
                      
                primeiraAula = (Aula) aulasDiaAtual.get(0);
                
                //verificar se existe na strutura
                    //setar na estrutura
                
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
        
    public String identificarConflitoRestricaoProfessor(Aula aula, int idProfessor){
        
        String turno = obterStringTurno(aula.getTurno());
        
        List listaRestricoes = gtPrincipal.getGdPrincipal().getGdRestricao().identificarConflitoRestricao(idProfessor, aula.getDia(), turno);
        
        if(listaRestricoes.isEmpty()){
            return null;
        }else
            return montarMensagemConflitoRestricaoProfessor(listaRestricoes, aula);
    }
    
    public String montarMensagemConflitoRestricaoProfessor(List lista, Aula aula){
        
        boolean resposta; 
        RestricaoProfessor restricao;
                
        for(int i = 0; i < lista.size(); i++){

            restricao = (RestricaoProfessor) lista.get(i);
            resposta = identificarNumeroAulaConflitante(restricao, aula.getNumero());

            if(resposta) 
                return "2 " + restricao.getProfessor().getPrimeiroNome().toUpperCase() + " possui uma restrição neste horário: " + restricao.getNome().toUpperCase();    
        }
        return null;
    }
    
    public boolean identificarNumeroAulaConflitante(RestricaoProfessor restricao, int numero){
            
        switch(numero){

            case 0: return restricao.isAula1();
            case 1: return restricao.isAula2();
            case 2: return restricao.isAula3();
            case 3: return restricao.isAula4();
            case 4: return restricao.isAula5();
            case 5: return restricao.isAula6();
        }
        return false;
    }
    
    public String obterStringTurno(int turno){
        
        switch(turno){ 
            case 0: return Constantes.MATUTINO;
            case 6: return Constantes.VESPERTINO;
            default: return Constantes.NOTURNO;    
        }
    }
    
    public boolean validarQuantidadeAulasDisciplina(Aula aula){
        
        if(aula != null){
            
            int cont  = 0;
            int qtAulas = aula.getAlocacao().getDisciplina().getQtAulas();
            int idDisciplina = aula.getAlocacao().getDisciplina().getId();

            Aula aulaAux;

            for(int linha = 0; linha < Constantes.LINHA; linha++){

                for(int coluna = 0; coluna < Constantes.COLUNA; coluna++){

                    aulaAux = gtPrincipal.getGtAula().getAulaMatriz(linha, coluna);

                    if(aulaAux != null){
                        if(aulaAux.getAlocacao().getDisciplina().getId() == idDisciplina){
                            cont++;
                        }
                    }
                }
            }
            return cont == qtAulas;
        }
        return true;
    }
}

package cgt;

import cdp.Alocacao;
import cdp.Aula;
import cdp.Oferta;
import cdp.Professor;
import cdp.RestricaoProfessor;
import cdp.Turma;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GtOferta {

    private GtPrincipal gtPrincipal;
    private Aula[][] matriz;
    private Oferta ofertaSelecionada;
    private List listaAulasRemovidas;
    
    public GtOferta(GtPrincipal gt) {
        gtPrincipal = gt;
    }
    
    public String validarOferta(Aula aula){
        
        String mensagem = null;
        Professor professor = aula.getAlocacao().getProfessor1();
        
        mensagem = identificarConflitoTurma(aula, professor.getId(), mensagem, 1);
        
        if(aula.getAlocacao().getDisciplina().getTipo().toLowerCase().equals(Constantes.ESPECIAL))         
            mensagem = validarDisciplinaEspecial(mensagem, aula);
              
        return mensagem;
    }
    
    public String validarDisciplinaEspecial(String mensagem, Aula aula){
        
        Professor professor2 = aula.getAlocacao().getProfessor2();
        String mensagem2 = identificarConflitoTurma(aula, professor2.getId(), mensagem, 2);

        if(mensagem != null){
            if(mensagem2 != null)
                mensagem = mensagem + "\n\n" + identificarConflitoTurma(aula, professor2.getId(), mensagem, 2);
        }else
            mensagem = mensagem2;

        return mensagem;
    }
    
    public String identificarConflitoTurma(Aula aula, int idProfessor, String mensagem, int numeroProfessor){
        
        int ano = aula.getAlocacao().getAno();
        int semestre = aula.getAlocacao().getSemestre();
        int numero = aula.getNumero();
        String dia = aula.getDia();
        String turno = aula.getTurno();
        
        List aulas = gtPrincipal.getGdPrincipal().getGdAula().identificarConflitoAula(ano, semestre, idProfessor, numero, dia, turno);
        
        if(aulas.size() <= 1){
            
            List listaRestricoes = gtPrincipal.getGdPrincipal().getGdRestricao().identificarConflitoRestricao(idProfessor, dia, turno);
            
            if(aulas.isEmpty()){
                return montarMensagemRestricaoInstituicao(mensagem, listaRestricoes, aula, numeroProfessor); 
                
            }else{
                
                Aula aulaLista = (Aula) aulas.get(0);
                
                if(aulaLista.getId() == aula.getId())
                    return montarMensagemRestricaoInstituicao(mensagem, listaRestricoes, aula, numeroProfessor);
                else
                    return montarMensagemConflitoTurma(aulas, aula);
            }
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
    
    public String montarMensagemRestricaoInstituicao(String mensagem, List listaRestricoes, Aula aula, int numeroProfessor){
        
        List aulas;
        int ano = aula.getAlocacao().getAno();
        int semestre = aula.getAlocacao().getSemestre();
        
        if(numeroProfessor == 1)
            aulas = gtPrincipal.getGdPrincipal().getGdAula().filtrarAulasProfessor1AnoSemestre(aula.getAlocacao().getProfessor1().getId(), ano, semestre);
        else
            aulas = gtPrincipal.getGdPrincipal().getGdAula().filtrarAulasProfessor2AnoSemestre(aula.getAlocacao().getProfessor2().getId(), ano, semestre);
        
        //VERIFICAR SE AS AULAS DO PROFESSOR ESTÃO ULTRAPASSANDO O TEMPO MÁXIMO E O INTERVALO MÍNIMO
        
        if(mensagem == null)
            mensagem = montarMensagemConflitoRestricaoProfessor(mensagem, listaRestricoes, aula);
        
        return mensagem;
    }
    
    public String montarMensagemConflitoRestricaoProfessor(String mensagem, List listaRestricoes, Aula aula){
        if(listaRestricoes.isEmpty()){
            return null;
        }else
            return identificarConflitoRestricaoProfessor(listaRestricoes, aula, mensagem);
    }
    
    public String identificarConflitoRestricaoProfessor(List lista, Aula aula, String mensagem){
        
        boolean resposta; 
        RestricaoProfessor restricao;
                
        for(int i = 0; i < lista.size(); i++){

            restricao = (RestricaoProfessor) lista.get(i);
            resposta = identificarNumeroAulaConflitante(restricao, aula.getNumero());

            if(resposta) 
                return "1 " + restricao.getProfessor().getPrimeiroNome().toUpperCase() + " possui uma restrição neste horário: " + restricao.getNome().toUpperCase();    
        }
        return mensagem;
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
    
    public int obterInteiroDia(String dia){
    
        switch(dia){
            
            case Constantes.SEGUNDA:
                return 0;
            case Constantes.TERCA:
                return 1;
            case Constantes.QUARTA:
                return 2;
            case Constantes.QUINTA:
                return 3;    
            default:
                return 4; 
        }  
    }
    
    public Aula identificarAula(Alocacao alocacao, int dia, String turno, int numero){
        
        Aula aula = getAulaMatriz(dia, numero);
        
        if(aula == null)
            return gerarNovaAula(alocacao, dia, turno, numero);   
        else
            return alterarAula(aula, alocacao, dia, turno, numero);        
    }
    
    public Aula gerarNovaAula(Alocacao alocacao, int dia, String turno, int numero){
        
        Aula novaAula = new Aula();
        
        novaAula.setAlocacao(alocacao);
        novaAula.setDia(obterStringDia(dia));
        novaAula.setNumero(numero);
        novaAula.setTurno(turno);
        novaAula.setOferta(getOfertaSelecionada());

        return novaAula; 
    }
    
    public Aula alterarAula(Aula aula, Alocacao alocacao, int dia, String turno, int numero){
        
        aula.setAlocacao(alocacao);
        aula.setDia(obterStringDia(dia));
        aula.setNumero(numero);
        aula.setTurno(turno);

        setAulaMatriz(dia, numero, aula);
        return aula;
    }
    
    public void importarAulaLista(int linha, int coluna, Aula origem){
        
        Aula destino = getAulaMatriz(linha, coluna);
        
        if(destino == null){
            setAulaMatriz(linha, coluna, origem);
        }else{
            Aula aulaAlterada = alterarAula(destino, origem.getAlocacao(), obterInteiroDia(origem.getDia()), origem.getTurno(), origem.getNumero());
            setAulaMatriz(linha, coluna, aulaAlterada);
        }
    }
    
    public void moverAulaMatriz(int linha, int coluna, Aula origem){
        
        Aula destino = getAulaMatriz(linha, coluna);
        
        String d = origem.getDia();
        int numero = origem.getNumero();
        
        origem.setDia(obterStringDia(linha));
        origem.setNumero(coluna);
        
        if(destino == null){
            setAulaMatriz(obterInteiroDia(d), numero, null);
            setAulaMatriz(linha, coluna, origem);          
        }else{
            
            Aula aulaAux = destino;
            
            setAulaMatriz(linha, coluna, origem);
            aulaAux.setDia(d);
            aulaAux.setNumero(numero);
            setAulaMatriz(obterInteiroDia(d), numero, aulaAux);
        }
    }
    
    public void removerAula(Aula aula){
        
        if(aula != null){
            setAulaMatriz(obterInteiroDia(aula.getDia()), aula.getNumero(), null);
            getListaAulasRemovidas().add(aula);
        }
    }
    
    public String atualizarAulas(){

        try {
            
            gtPrincipal.getGdPrincipal().getGdOferta().atualizarAulasOferta(matriz, listaAulasRemovidas); 
            return Constantes.CADASTRADO;
            
        } catch (Exception ex) {
            return ex.getMessage();
        } 
    }
    
    public void identificarOferta(int ano, int semestre, int tempoMaximo, int intervaloMinimo, String turno, Turma turma){
        
        Oferta oferta = gtPrincipal.getGdPrincipal().getGdOferta().filtrarOferta(ano, semestre, turma.getId());
        
        if(oferta == null)
            oferta = gerarOferta(ano, semestre, tempoMaximo, intervaloMinimo, turma);

        setOfertaSelecionada(oferta);
        gerarEstruturasArmazenamento();
        
        if(oferta != null){
            List aulas = gtPrincipal.getGdPrincipal().getGdAula().filtrarAulasTurno(turno, oferta.getId());
            preencherMatrizOferta(aulas);
        }
    }
    
    public Oferta gerarOferta(int ano, int semestre, int tempoMaximo, int intervaloMinimo, Turma turma){
        
        try {
            Oferta oferta = new Oferta();

            oferta.setAno(ano);
            oferta.setIntervaloMinimo(intervaloMinimo);
            oferta.setSemestre(semestre);
            oferta.setTempoMaximoTrabalho(tempoMaximo);
            oferta.setTurma(turma);
            gtPrincipal.getGdPrincipal().getGdOferta().cadastrar(oferta);
            return oferta;
        } catch (SQLException | ClassNotFoundException ex) {
            return null;
        }   
    }    
    
    public void preencherMatrizOferta(List lista){
               
        Aula aula; 
        for(int linha = 0; linha < lista.size(); linha++){
            aula = (Aula) lista.get(linha);
            aula.setOferta(getOfertaSelecionada());
            setAulaMatriz(obterInteiroDia(aula.getDia()), aula.getNumero(), aula);   
        }  
    }
    
    public void gerarEstruturasArmazenamento(){
        if(matriz == null){
           matriz = new Aula[Constantes.LINHA][Constantes.COLUNA];
            listaAulasRemovidas = new ArrayList<>(); 
        }else{
            limparEstruturasArmazenamento();
        }
    }
    
    public void limparEstruturasArmazenamento(){
        
        listaAulasRemovidas.clear();
  
        for(int linha = 0; linha < Constantes.LINHA; linha++){
            for(int coluna = 0; coluna < Constantes.COLUNA; coluna++){
                setAulaMatriz(linha, coluna, null);
            }
        }
    }
    
    public Aula getAulaMatriz(int linha, int coluna){
        return (Aula) matriz[linha][coluna];
    }
    
    public void setAulaMatriz(int linha, int coluna, Aula aula){
        matriz[linha][coluna] = aula;    
    }

    public Oferta getOfertaSelecionada() {
        return ofertaSelecionada;
    }

    public void setOfertaSelecionada(Oferta ofertaSelecionada) {
        this.ofertaSelecionada = ofertaSelecionada;
    }

    public List getListaAulasRemovidas() {
        return listaAulasRemovidas;
    }

    public void setListaAulasRemovidas(List listaAulasRemovidas) {
        this.listaAulasRemovidas = listaAulasRemovidas;
    }
    
    public List listarAulasProfessor(int idProfessor, int ano, int semestre, int numeroProfessor){
        if(numeroProfessor == 1)
            return gtPrincipal.getGdPrincipal().getGdAula().filtrarAulasProfessor1AnoSemestre(idProfessor, ano, semestre);
        else
            return gtPrincipal.getGdPrincipal().getGdAula().filtrarAulasProfessor2AnoSemestre(idProfessor, ano, semestre);
    }
}

package cgt;

import cdp.Oferta;
import cdp.Turma;
import java.sql.SQLException;

public class GtOferta {

    private GtPrincipal gtPrincipal;
    private Oferta ofertaSelecionada;
    
    public GtOferta(GtPrincipal gt) {
        gtPrincipal = gt;
    }
    
    public void identificarOferta(int ano, int semestre, int tempoMaximo, int intervaloMinimo, String turno, Turma turma){
        
        Oferta oferta = gtPrincipal.getGdPrincipal().getGdOferta().filtrarOfertaAnoSemestreTurma(ano, semestre, turma.getId());
        
        if(oferta == null && gtPrincipal.getGtTurma().verificarTurmaAtiva(turma, ano, semestre)){
            oferta = gerarOferta(ano, semestre, tempoMaximo, intervaloMinimo, turma);
        }
        
        setOfertaSelecionada(oferta);
        gtPrincipal.getGtAula().preencherMatrizOferta(oferta);
        
    }
    
    public void atualizarOferta(int tempoMaximo, int intervaloMinimo){

        if(getOfertaSelecionada() != null){
            getOfertaSelecionada().setIntervaloMinimo(intervaloMinimo);
            getOfertaSelecionada().setTempoMaximoTrabalho(tempoMaximo);
            
            try {
                gtPrincipal.getGdPrincipal().getGdOferta().alterar(getOfertaSelecionada());
            } catch (SQLException | ClassNotFoundException ex) {
                System.out.println(ex.getMessage());
            }
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

    public Oferta getOfertaSelecionada() {
        return ofertaSelecionada;
    }

    public void setOfertaSelecionada(Oferta ofertaSelecionada) {
        this.ofertaSelecionada = ofertaSelecionada;
    }
    
    public Oferta filtrarUltimaOfertaTurma(int idTurma){
        return gtPrincipal.getGdPrincipal().getGdOferta().filtrarUltimaOfertaTurma(idTurma);
    }
}

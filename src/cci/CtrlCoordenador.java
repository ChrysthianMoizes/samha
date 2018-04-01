package cci;

import cdp.Coordenador;
import cdp.Coordenadoria;
import cdp.Professor;
import cgt.GtCoordenador;
import cih.JDBuscarCoordenador;
import cih.JDCadastrarCoordenador;
import java.awt.Frame;
import java.util.List;

public class CtrlCoordenador {
    
    private JDBuscarCoordenador buscaCoord;
    private JDCadastrarCoordenador cadastraCoord;
    private CtrlPrincipal ctrlPrincipal;
    private GtCoordenador gtCoordenador;

    public CtrlCoordenador(CtrlPrincipal ctrl) {
        this.ctrlPrincipal = ctrl;
        gtCoordenador = new GtCoordenador();
    }
    
    public void instanciarTelaBuscaCoordenador(Frame pai){
        buscaCoord = new JDBuscarCoordenador(pai, true, ctrlPrincipal);
        buscaCoord.setVisible(true);
    }
    
    public void instanciarTelaCadastroCoordenador(Coordenador coord, Frame pai){
        cadastraCoord = new JDCadastrarCoordenador(pai, true, ctrlPrincipal, coord);
        cadastraCoord.setVisible(true);
    }
    
    public void cadastrar(Professor professor, Coordenadoria coordenadoria, String tipo, String login, String senha, String nome, String matricula){
       try{
           gtCoordenador.cadastrar(professor, coordenadoria, tipo, login, senha, nome, matricula);
           ctrlPrincipal.getCtrlMensagem().exibirMensagemSucesso(cadastraCoord, "Cadastrado Com sucesso!");
       }catch(Exception e){
           ctrlPrincipal.getCtrlMensagem().exibirMensagemErro(cadastraCoord, e.getMessage());
       } 
    }
    
    public void alterar(Coordenador coordenador, Coordenadoria coordenadoria, Professor professor, String tipo, String login, String senha, String nome, String matricula){
       try{
           gtCoordenador.alterar(coordenador, coordenadoria, professor, tipo, login, senha, nome, matricula);
           ctrlPrincipal.getCtrlMensagem().exibirMensagemSucesso(cadastraCoord, "Alterado Com sucesso!");
       }catch(Exception e){
           ctrlPrincipal.getCtrlMensagem().exibirMensagemErro(cadastraCoord, e.getMessage());
       } 
    }
    
    public List<Coordenador> buscar(String coluna, String texto) {
       return gtCoordenador.buscar(coluna, texto);
    }
}

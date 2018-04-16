package cci;

import cdp.Coordenador;
import cdp.Coordenadoria;
import cdp.Professor;
import cdp.ProfessorCoordenador;
import cgt.Constantes;
import cgt.GtCoordenador;
import cih.coordenador.JDBuscarCoordenador;
import cih.coordenador.JDCadastrarCoordenador;
import static com.sun.corba.se.impl.util.Utility.printStackTrace;
import java.awt.Frame;
import java.awt.Image;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTable;

public class CtrlCoordenador extends CtrlGenerica{

    private JDBuscarCoordenador buscaCoord;
    private JDCadastrarCoordenador cadastraCoord;
    private CtrlPrincipal ctrlPrincipal;
    private GtCoordenador gtCoordenador;
    
    private Coordenador coordenador;
    private List<Professor> listaProfessores;
    private List<Coordenadoria> listaCoordenadorias;
    private List<Coordenador> listaCoordenadores;

    public CtrlCoordenador(CtrlPrincipal ctrl) {
        this.ctrlPrincipal = ctrl;
        gtCoordenador = new GtCoordenador();
    }
    
    public Image setarIconeJanela() {
        ImageIcon icone = new ImageIcon("build/classes/cih/img/coordenador.png");
        return icone.getImage();
    }
    
    public void transitarTelas(JTable tabela, Frame pai){
        
        try {
            Coordenador coord = (Coordenador) JTableUtil.getDadosLinhaSelecionada(tabela);
            setCoordenador(coord);
            ctrlPrincipal.getCtrlCoordenador().instanciarTelaCadastroCoordenador(pai);
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            CtrlMensagem.exibirMensagemErro(buscaCoord, "Selecione um coordenador");
        } 
    }

    public void instanciarTelaBuscaCoordenador(Frame pai) {
        buscaCoord = new JDBuscarCoordenador(pai, true, ctrlPrincipal);
        buscaCoord.setIconImage(setarIconeJanela());
        buscaCoord.setVisible(true);
    }

    public void instanciarTelaCadastroCoordenador(Frame pai) {
        cadastraCoord = new JDCadastrarCoordenador(pai, true, ctrlPrincipal);
        identificarOrigem();
        cadastraCoord.setIconImage(setarIconeJanela());
        cadastraCoord.setVisible(true);  
    }

    public void cadastrar(Professor professor, Coordenadoria coordenadoria, String tipo, String login, String senha, String nome, String matricula) {

        String resposta = gtCoordenador.cadastrar(professor, coordenadoria, tipo, login, senha, nome, matricula);

        if (resposta.equals(Constantes.CADASTRADO)) {
            ctrlPrincipal.getCtrlMensagem().exibirMensagemSucesso(cadastraCoord, "Cadastrado Com sucesso!");
        } else {
            ctrlPrincipal.getCtrlMensagem().exibirMensagemErro(cadastraCoord, resposta);
        }
    }

    public void alterar(Coordenador coordenador, Coordenadoria coordenadoria, Professor professor, String tipo, String login, String senha, String nome, String matricula) {

        String resposta = gtCoordenador.alterar(coordenador, coordenadoria, professor, tipo, login, senha, nome, matricula);
        if (resposta.equals(Constantes.ALTERADO)) {
            ctrlPrincipal.getCtrlMensagem().exibirMensagemSucesso(cadastraCoord, "Alterado Com sucesso!");
        } else {
            ctrlPrincipal.getCtrlMensagem().exibirMensagemErro(cadastraCoord, resposta);
        }
    }

    public void excluir(JTable tabela) {
        
        try {
            Coordenador coordenadorSelecionado = (Coordenador) JTableUtil.getDadosLinhaSelecionada(tabela);
            int confirmacao = CtrlMensagem.exibirMensagemConfirmacao(buscaCoord, "Confirmar Exclusão ?");
            if (confirmacao == 0) {
                String resposta = gtCoordenador.excluir(coordenadorSelecionado);
                if (resposta.equals(Constantes.EXCLUIDO)) 
                    CtrlMensagem.exibirMensagemSucesso(buscaCoord, "Excluído com sucesso!");
                else 
                    CtrlMensagem.exibirMensagemErro(buscaCoord, resposta);   
            }    
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            CtrlMensagem.exibirMensagemErro(buscaCoord, "Selecione um coordenador");
        }
    }

    public void listarCoordenadores(String coluna, String texto, JTable tabela) {
        
        listaCoordenadores = buscar(coluna, texto);
        JTableUtil.limparTabela(tabela);
        
        if(listaCoordenadores.size() > 0){
            try {
                JTableUtil.preencherTabela(listaCoordenadores, tabela);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
         }else
            CtrlMensagem.exibirMensagemAviso(buscaCoord, "Nenhum registro encontrado");
    }
    
    public List<Coordenador> buscar(String coluna, String texto) {
        return gtCoordenador.buscar(coluna, texto);
    }

    public Coordenador getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(Coordenador coordenador) {
        this.coordenador = coordenador;
    }

    public List<Professor> getListaProfessores() {
        return listaProfessores;
    }

    public void setListaProfessores(List<Professor> listaProfessores) {
        this.listaProfessores = listaProfessores;
    }

    public List<Coordenadoria> getListaCoordenadorias() {
        return listaCoordenadorias;
    }

    public void setListaCoordenadorias(List<Coordenadoria> listaCoordenadorias) {
        this.listaCoordenadorias = listaCoordenadorias;
    }
    
    //============================ TELA DE CADASTRO ============================================================
    
    public void identificarOrigem(){      
        if(coordenador != null){
            cadastraCoord.selecionarTipoCoordenador(coordenador);
            cadastraCoord.setarCamposComInstancia(coordenador);
        }else{
            cadastraCoord.desabilitarCombos();
        }
    }
    
    public void validarOperacao(Professor professor, Coordenadoria coordenadoria, String tipo, String login, String senha, String nome, String matricula){  
        
        if(validarCampos(nome, matricula, login, senha)){
            
            if(coordenador == null)   
                ctrlPrincipal.getCtrlCoordenador().cadastrar(professor, coordenadoria, tipo, login, senha, nome, matricula);  
            else
                ctrlPrincipal.getCtrlCoordenador().alterar(coordenador, coordenadoria, professor, tipo, login, senha, nome, matricula);
        }else
            CtrlMensagem.exibirMensagemAviso(cadastraCoord, "Todos os campos devem ser preenchidos");
    }
    
    public void preencherComboProfessor(JComboBox cbxProfessor) {
        
        preencherCombo(cbxProfessor, listaProfessores);
             
        if(coordenador != null){
            Professor profAtual;
            for(int i = 0; i < listaProfessores.size(); i++){
                profAtual = (Professor) listaProfessores.get(i);
                if(profAtual.getMatricula().equals(coordenador.getMatricula())){
                    cbxProfessor.setSelectedIndex(i);
                    break;
                }
            }
        }
    }
    
    public void preencherComboCoordenadoria(JComboBox cbxCoordenadoras) {
        preencherCombo(cbxCoordenadoras, listaCoordenadorias);
    }
    
    public boolean validarCampos(String nome, String matricula, String login, String senha){
        
        if((nome.equals("")) || (matricula.equals("")))
           return false;

        if((login.equals("")) || (senha.equals("")))
            return false;
  
        return true;  
    }    
}

package cci;

import cdp.Coordenador;
import cdp.Professor;
import cgt.Constantes;
import cgt.GtCoordenador;
import cih.coordenador.JDBuscarCoordenador;
import cih.coordenador.JDCadastrarCoordenador;
import java.awt.Frame;
import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTable;

public class CtrlCoordenador extends CtrlGenerica{

    private JDBuscarCoordenador buscaCoord;
    private JDCadastrarCoordenador cadastraCoord;
    private CtrlPrincipal ctrlPrincipal;
    private GtCoordenador gtCoordenador;

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
            Coordenador coordenador = (Coordenador) JTableUtil.getDadosLinhaSelecionada(tabela);  
            ctrlPrincipal.getCtrlCoordenador().instanciarTelaCadastroCoordenador(pai, coordenador);
            
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

    public void instanciarTelaCadastroCoordenador(Frame pai, Coordenador coordenador) {
        cadastraCoord = new JDCadastrarCoordenador(pai, true, ctrlPrincipal);
        cadastraCoord.setCoordenador(coordenador);
        identificarOrigem(coordenador);
        cadastraCoord.setIconImage(setarIconeJanela());
        cadastraCoord.setVisible(true);  
    }

    public void cadastrar(Professor professor, String tipo, String login, String senha, String nome, String matricula) {

        String resposta = gtCoordenador.cadastrar(professor, tipo, login, senha, nome, matricula);

        if (resposta.equals(Constantes.CADASTRADO)) {
            ctrlPrincipal.getCtrlMensagem().exibirMensagemSucesso(cadastraCoord, "Cadastrado Com sucesso!");
            cadastraCoord.desabilitarCombos();
            cadastraCoord.desabilitarCampos();
            buscaCoord.atualizarTabela();
        } else {
            ctrlPrincipal.getCtrlMensagem().exibirMensagemErro(cadastraCoord, resposta);
        }
    }

    public void alterar(Coordenador coordenador, Professor professor, String tipo, String login, String senha, String nome, String matricula) {

        String resposta = gtCoordenador.alterar(coordenador, professor, tipo, login, senha, nome, matricula);
        if (resposta.equals(Constantes.ALTERADO)) {
            CtrlMensagem.exibirMensagemSucesso(cadastraCoord, "Alterado Com sucesso!");
            cadastraCoord.desabilitarCombos();
            cadastraCoord.desabilitarCampos();
            buscaCoord.atualizarTabela();
        } else {
            CtrlMensagem.exibirMensagemErro(cadastraCoord, resposta);
        }
    }

    public void excluir(JTable tabela) {
        
        try {
            Coordenador coordenadorSelecionado = (Coordenador) JTableUtil.getDadosLinhaSelecionada(tabela);
            int confirmacao = CtrlMensagem.exibirMensagemConfirmacao(buscaCoord, "Confirmar Exclusão ?");
            if (confirmacao == 0) {
                String resposta = gtCoordenador.excluir(coordenadorSelecionado);
                if (resposta.equals(Constantes.EXCLUIDO)){ 
                    CtrlMensagem.exibirMensagemSucesso(buscaCoord, "Excluído com sucesso!");
                    buscaCoord.atualizarTabela();
                }else 
                    CtrlMensagem.exibirMensagemErro(buscaCoord, resposta);   
            }    
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            CtrlMensagem.exibirMensagemErro(buscaCoord, "Selecione um coordenador");
        }
    }

    public void listarCoordenadores(String coluna, String texto, JTable tabela) {
        
        List listaCoordenadores = buscar(coluna, texto);
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
    
    //============================ TELA DE CADASTRO ============================================================
    
    public void identificarOrigem(Coordenador coordenador){
        
        if(coordenador != null){
            cadastraCoord.selecionarTipoCoordenador(coordenador);
            cadastraCoord.setarCamposComInstancia(coordenador);
            cadastraCoord.desabilitarCombos();
        }
    }
    
    public void validarOperacao(Professor professor, String tipo, String login, String senha, String nome, String matricula){  
        
        Coordenador coordenador = cadastraCoord.getCoordenador();
        
        if(validarCampos(nome, matricula, login, senha)){
            
            if(coordenador == null)   
                cadastrar(professor, tipo, login, senha, nome, matricula);  
            else
                alterar(coordenador, professor, tipo, login, senha, nome, matricula);
        }else
            CtrlMensagem.exibirMensagemAviso(cadastraCoord, "Todos os campos devem ser preenchidos");
    }
    
    public void preencherComboProfessor(JComboBox cbxProfessor) {
        
        List listaProfessores = cadastraCoord.getListaProfessores();
        
        if(listaProfessores == null)
            listaProfessores = ctrlPrincipal.getCtrlProfessor().consultar();
        preencherCombo(cbxProfessor, listaProfessores);
        
        Professor prof = (Professor) cbxProfessor.getSelectedItem();
        cadastraCoord.setarCamposProfessor(prof); 
        
        Coordenador coordenador = cadastraCoord.getCoordenador();
        
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
        
        List listaCoordenadorias = cadastraCoord.getListaCoordenadorias();
        
        if(listaCoordenadorias == null)
            listaCoordenadorias = ctrlPrincipal.getCtrlCoordenadoria().consultar();
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

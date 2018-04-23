package cci;

import cdp.CoordenadorAcademico;
import cdp.CoordenadorCurso;
import cdp.Professor;
import cdp.Usuario;
import cgt.Constantes;
import cgt.GtCoordenador;
import cih.coordenador.JDBuscarCoordenador;
import cih.coordenador.JDCadastrarCoordenador;
import java.awt.Frame;
import java.awt.Image;
import java.util.ArrayList;
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
            Usuario coordenador = (Usuario) JTableUtil.getDadosLinhaSelecionada(tabela);  
            instanciarTelaCadastroCoordenador(pai, coordenador);
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            CtrlMensagem.exibirMensagemErro(buscaCoord, "Selecione um coordenador");
        } 
    }

    public void instanciarTelaBuscaCoordenador(Frame pai) {
        buscaCoord = new JDBuscarCoordenador(pai, true, ctrlPrincipal);
        new Thread(new AtualizarInterface(buscaCoord)).start();
        buscaCoord.setIconImage(setarIconeJanela());
        buscaCoord.setVisible(true);
    }

    public void instanciarTelaCadastroCoordenador(Frame pai, Usuario coordenador) {
        cadastraCoord = new JDCadastrarCoordenador(pai, true, ctrlPrincipal);
        identificarOrigem(coordenador);
        cadastraCoord.setIconImage(setarIconeJanela());
        cadastraCoord.setVisible(true);  
    }

    public void cadastrar(Professor professor, String tipo, String login, String senha, String nome, String matricula) {

        String resposta = gtCoordenador.cadastrar(professor, tipo, login, senha, nome, matricula);

        if (resposta.equals(Constantes.CADASTRADO)) {
            CtrlMensagem.exibirMensagemSucesso(cadastraCoord, "Cadastrado Com sucesso!");
            cadastraCoord.limparCampos();
            buscaCoord.atualizarTabela();
        } else {
            CtrlMensagem.exibirMensagemErro(cadastraCoord, resposta);
        }
    }

    public void alterar(Usuario coordenador, Professor professor, String tipo, String login, String senha, String nome, String matricula) {

        String resposta = gtCoordenador.alterar(coordenador, professor, tipo, login, senha, nome, matricula);
        if (resposta.equals(Constantes.ALTERADO)) {
            CtrlMensagem.exibirMensagemSucesso(cadastraCoord, "Alterado Com sucesso!");
            cadastraCoord.desabilitarComboTipoCoordenador();
            cadastraCoord.desabilitarComboProfessor(false);
            cadastraCoord.desabilitarCampos();
            buscaCoord.atualizarTabela();
        } else {
            CtrlMensagem.exibirMensagemErro(cadastraCoord, resposta);
        }
    }

    public void excluir(JTable tabela) {
        
        try {
            Usuario coordenadorSelecionado = (Usuario) JTableUtil.getDadosLinhaSelecionada(tabela);
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
        
        if(coluna.toLowerCase().equals("tipo")){
            
            List listaCoordenadores = gtCoordenador.buscarCoordenadoresPorTipo(texto);
            listarEmTabela(listaCoordenadores, tabela, buscaCoord);
            
        }else{
        
            List listaCoordenadoresCurso = gtCoordenador.buscarCoordenadoresCurso(coluna, texto);
            List listaCoordenadoresAcademicos = gtCoordenador.buscarCoordenadoresAcademicos(coluna, texto);
            List listaCoordenadoresPedagogicos = gtCoordenador.buscarCoordenadoresPedagogicos(coluna, texto);

            List listaCoordenadores = new ArrayList<>();

            listaCoordenadores.addAll(listaCoordenadoresAcademicos);
            listaCoordenadores.addAll(listaCoordenadoresCurso);
            listaCoordenadores.addAll(listaCoordenadoresPedagogicos);

            listarEmTabela(listaCoordenadores, tabela, buscaCoord);
        }
    }
    
    public List<CoordenadorAcademico> buscarCoordenadoresAcademicos(String coluna, String texto) {
        return gtCoordenador.buscarCoordenadoresAcademicos(coluna, texto);
    }
    
    //============================ TELA DE CADASTRO ============================================================
    
    public void identificarOrigem(Usuario coordenador){
        
        if(coordenador != null){
            cadastraCoord.setCoordenador(coordenador);
            cadastraCoord.selecionarTipoCoordenador(coordenador);
            cadastraCoord.setarCamposComInstancia(coordenador);
            cadastraCoord.desabilitarComboTipoCoordenador();
            if(coordenador instanceof CoordenadorCurso)
                cadastraCoord.desabilitarComboProfessor(true);
            else
                cadastraCoord.desabilitarComboProfessor(false);
        }
    }
    
    public void validarOperacao(Professor professor, String tipo, String login, String senha, String nome, String matricula){  
        
        Usuario coordenador = cadastraCoord.getCoordenador();
        
        if(validarCampos(nome, matricula, login, senha)){
            
            if(coordenador == null)   
                cadastrar(professor, tipo, login, senha, nome, matricula);  
            else
                alterar(coordenador, professor, tipo, login, senha, nome, matricula);
        }else
            CtrlMensagem.exibirMensagemAviso(cadastraCoord, "Todos os campos devem ser preenchidos");
    }
    
    public void preencherComboProfessor(JComboBox cbxProfessor) {
        
        CoordenadorCurso coordenador = (CoordenadorCurso) cadastraCoord.getCoordenador();

        List novaListaProfessores = listarProfessoresNaoCoordenadores();
        
        preencherCombo(cbxProfessor, novaListaProfessores);
          
        Professor prof = (Professor) cbxProfessor.getSelectedItem();
        cadastraCoord.setarCamposProfessor(prof);         
        
        if(coordenador != null){
            Professor profAtual;
            for(int i = 0; i < novaListaProfessores.size(); i++){
                profAtual = (Professor) novaListaProfessores.get(i);
                if(profAtual.getMatricula().equals(coordenador.getProfessor().getMatricula())){
                    cbxProfessor.setSelectedIndex(i);
                    break;
                }
            }
        }
    }
    
    public List listarProfessoresNaoCoordenadores(){
        
        List listaProfessores = ctrlPrincipal.getCtrlProfessor().consultar();
        List listaCoordenadores = gtCoordenador.buscarCoordenadoresPorTipo(Constantes.COORD_CURSO);
        List novaListaProfessores = new ArrayList<>();
        
        Professor professor;
        CoordenadorCurso coordenadorCurso;
        int cont = 0;

        for(int i = 0; i < listaProfessores.size(); i++){

            professor = (Professor) listaProfessores.get(i);

            for(int j = 0; j < listaCoordenadores.size(); j++){
                coordenadorCurso = (CoordenadorCurso) listaCoordenadores.get(j);
                if(professor.getId() == coordenadorCurso.getProfessor().getId()){
                    cont++;
                }
            }
            if(cont == 0)
                novaListaProfessores.add(professor);
            cont = 0;
        }
        
        return novaListaProfessores;
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

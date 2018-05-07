package cci;

import cdp.CoordenadorCurso;
import cdp.Curso;
import cdp.Professor;
import cdp.Usuario;
import cgt.Constantes;
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

    public CtrlCoordenador(CtrlPrincipal ctrl) {
        this.ctrlPrincipal = ctrl;
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
        buscaCoord.setIconImage(setarIconeJanela());
        buscaCoord.setVisible(true);
    }

    public void instanciarTelaCadastroCoordenador(Frame pai, Usuario coordenador) {
        cadastraCoord = new JDCadastrarCoordenador(pai, true, ctrlPrincipal);
        identificarOrigem(coordenador);
        cadastraCoord.setIconImage(setarIconeJanela());
        cadastraCoord.setVisible(true);  
    }

    public void cadastrar(Professor professor, Curso curso, String tipo, String login, String senha, String nome, String matricula) {

        String resposta = ctrlPrincipal.getGtPrincipal().getGtCoordenador().cadastrar(professor, curso, tipo, login, senha, nome, matricula);

        if (resposta.equals(Constantes.CADASTRADO)) {
            CtrlMensagem.exibirMensagemSucesso(cadastraCoord, "Cadastrado Com sucesso!");
            cadastraCoord.limparCampos();
            buscaCoord.atualizarTabela();
        } else {
            CtrlMensagem.exibirMensagemErro(cadastraCoord, resposta);
        }
    }

    public void alterar(Usuario coordenador, Professor professor, Curso curso, String tipo, String login, String senha, String nome, String matricula) {

        String resposta = ctrlPrincipal.getGtPrincipal().getGtCoordenador().alterar(coordenador, professor, curso, tipo, login, senha, nome, matricula);
        if (resposta.equals(Constantes.ALTERADO)) {
            CtrlMensagem.exibirMensagemSucesso(cadastraCoord, "Alterado Com sucesso!");
            cadastraCoord.desabilitarComboTipoCoordenador(false);
            cadastraCoord.desabilitarComboProfessor(false);
            cadastraCoord.desabilitarComboCurso(false);
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
                String resposta = ctrlPrincipal.getGtPrincipal().getGtCoordenador().excluir(coordenadorSelecionado);
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
        
        List listaCoordenadores;
        
        if(coluna.toLowerCase().equals("tipo"))
            listaCoordenadores = ctrlPrincipal.getGtPrincipal().getGtCoordenador().buscarCoordenadoresPorTipo(texto);   
            
        else
            listaCoordenadores = ctrlPrincipal.getGtPrincipal().getGtCoordenador().listarCoordenadores(coluna, texto);    
               
        listarEmTabela(listaCoordenadores, tabela, buscaCoord, "toArray");
        
        if(listaCoordenadores.isEmpty())
                buscaCoord.setarMensagem("Nenhum coordenador encontrado.");
    }
    
    //============================ TELA DE CADASTRO ============================================================
    
    public void identificarOrigem(Usuario coordenador){
        
        if(coordenador != null){
            cadastraCoord.setCoordenador(coordenador);
            cadastraCoord.selecionarTipoCoordenador(coordenador);
            cadastraCoord.setarCamposComInstancia(coordenador);
            cadastraCoord.desabilitarComboTipoCoordenador(false);
            cadastraCoord.desabilitarComboCurso(false);
            if(coordenador instanceof CoordenadorCurso)
                cadastraCoord.desabilitarComboProfessor(true);
            else
                cadastraCoord.desabilitarComboProfessor(false);
        }
    }
    
    public void validarOperacao(Professor professor, Curso curso, String tipo, String login, String senha, String nome, String matricula){  
        
        Usuario coordenador = cadastraCoord.getCoordenador();
        
        if(validarCampos(nome, matricula, login, senha)){
            
            if(coordenador == null)   
                cadastrar(professor, curso, tipo, login, senha, nome, matricula);  
            else
                alterar(coordenador, professor, curso, tipo, login, senha, nome, matricula);
        }else
            CtrlMensagem.exibirMensagemAviso(cadastraCoord, "Todos os campos devem ser preenchidos");
    }
    
    public void preencherComboProfessor(JComboBox cbxProfessor) {
        
        CoordenadorCurso coordenador = (CoordenadorCurso) cadastraCoord.getCoordenador();

        List novaListaProfessores = listarProfessoresNaoCoordenadores();
        if(coordenador != null)
            novaListaProfessores.add(coordenador.getProfessor());
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
    
    public void preencherComboCurso(JComboBox cbxCurso){      
        List listaCursos = ctrlPrincipal.getCtrlCurso().listar();
        preencherCombo(cbxCurso, listaCursos);     
    }
    
    public List listarProfessoresNaoCoordenadores(){
        
        List listaProfessores = ctrlPrincipal.getCtrlProfessor().consultar();
        List listaCoordenadores = ctrlPrincipal.getGtPrincipal().getGtCoordenador().buscarCoordenadoresPorTipo(Constantes.COORD_CURSO);
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

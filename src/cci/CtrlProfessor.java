package cci;

import cdp.Coordenadoria;
import cdp.Professor;
import cdp.RestricaoProfessor;
import cgt.Constantes;
import cgt.GtProfessor;
import cih.professor.JDBuscarProfessor;
import cih.professor.JDCadastrarProfessor;
import java.awt.Frame;
import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTable;

public class CtrlProfessor extends CtrlGenerica{

    private GtProfessor gtProfessor;
    private JDBuscarProfessor buscaProf;
    private JDCadastrarProfessor cadastraProf;
    private CtrlPrincipal ctrlPrincipal;

    public CtrlProfessor(CtrlPrincipal ctrl) {
        gtProfessor = new GtProfessor();
        ctrlPrincipal = ctrl;
    }
    
    public Image setarIconeJanela() {
        ImageIcon icone = new ImageIcon("build/classes/cih/img/professor.png");
        return icone.getImage();
    }
    
    public void transitarTelas(JTable tabela, Frame pai){
        
        try {
            Professor professor = (Professor) JTableUtil.getDadosLinhaSelecionada(tabela);
            instanciarTelaCadastroProfessor(professor, pai);
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            CtrlMensagem.exibirMensagemErro(buscaProf, "Selecione um professor");
        }
    }

    public void instanciarTelaBuscaProfessor(Frame pai) {
        buscaProf = new JDBuscarProfessor(pai, true, ctrlPrincipal);
        buscaProf.setIconImage(setarIconeJanela());
        buscaProf.setVisible(true);
    }

    public void instanciarTelaCadastroProfessor(Professor professor, Frame pai) {
        cadastraProf = new JDCadastrarProfessor(pai, true, ctrlPrincipal, professor);
        cadastraProf.setIconImage(setarIconeJanela());
        identificarOrigem(professor);
        cadastraProf.setVisible(true);
    }

    public List<Professor> buscar(String coluna, String texto) {      
        if (coluna.toLowerCase().equals("coordenadoria")) {
            return filtrarPorCoordenadoria(Integer.parseInt(texto));
        } else 
            return gtProfessor.buscar(coluna.toLowerCase(), texto);      
    }
    
    public List<Professor> filtrarPorCoordenadoria(int id){
        return gtProfessor.filtrarPorCoordenadoria(id);
    }
    
    public List<Professor> filtrarPorEixo(int id){
        return gtProfessor.filtrarPorEixo(id);
    }

    public void cadastrar(String nome, String matricula, int cargaHoraria, Coordenadoria coordenadoria) {

        Professor professor = gtProfessor.cadastrar(nome, matricula, cargaHoraria, coordenadoria);
        if (professor != null) {
            cadastraProf.setProfessor(professor);
            CtrlMensagem.exibirMensagemSucesso(cadastraProf, "Cadastrado com sucesso!");
            cadastraProf.desabilitarCamposProfessor(false);
            cadastraProf.habilitarCamposRestricao(true);
            buscaProf.atualizarTabela();
        } else {
            CtrlMensagem.exibirMensagemErro(cadastraProf, "Erro ao cadastrar");
        }
    }

    public void alterar(String nome, String matricula, int cargaHoraria, Coordenadoria coordenadoria, Professor professor) {

        Professor prof = gtProfessor.alterar(nome, matricula, cargaHoraria, coordenadoria, professor);
        if (prof != null) {
            cadastraProf.setProfessor(prof);
            CtrlMensagem.exibirMensagemSucesso(cadastraProf, "Alterado com sucesso!");
            cadastraProf.desabilitarCamposProfessor(false);
            cadastraProf.habilitarCamposRestricao(true);
            buscaProf.atualizarTabela();
        }else{
            CtrlMensagem.exibirMensagemErro(cadastraProf, "Erro ao alterar");
        }
    }

    public List<Professor> consultar() {
        return gtProfessor.consultar();
    }

    public void excluir(JTable tblProfessor) {

        try {
            Professor professor = (Professor) JTableUtil.getDadosLinhaSelecionada(tblProfessor);
            int confirmacao = CtrlMensagem.exibirMensagemConfirmacao(buscaProf, "Confirmar Exclusão ?");
            if (confirmacao == 0) {
                String resposta = gtProfessor.excluir(professor);
                if (resposta.equals(Constantes.EXCLUIDO)) {
                    CtrlMensagem.exibirMensagemSucesso(buscaProf, "Excluído com sucesso!");
                    buscaProf.atualizarTabela();
                } else {
                    CtrlMensagem.exibirMensagemErro(buscaProf, resposta);
                }
            }
        } catch (Exception ex) {
            CtrlMensagem.exibirMensagemErro(buscaProf, "Selecione um professor");
        }
    }
    
    public void listarProfessores(String coluna, String texto, JTable tabela) {
       
        List listaProfessores = buscar(coluna, texto);
        listarEmTabela(listaProfessores, tabela, buscaProf, "toArray");  
        
        if(listaProfessores.size() == 0)
            buscaProf.setarMensagem("Nenhum professor encontrado.");
    }
    
    //================================================= TELA DE CADASTRO ====================================================
    
    public void validarOperacao(String nome, String matricula, int cargaHoraria, Coordenadoria coordenadoria){  
        
        Professor professor = cadastraProf.getProfessor();
        
        if(validarCampos(nome, matricula, cargaHoraria, coordenadoria)){
            
            if(professor == null)   
                cadastrar(nome, matricula, cargaHoraria, coordenadoria);
            else
                alterar(nome, matricula, cargaHoraria, coordenadoria, professor);
        }else
            CtrlMensagem.exibirMensagemAviso(cadastraProf, "Todos os campos devem ser preenchidos corretamente");
    }
    
    public void identificarOrigem(Professor professor){
        cadastraProf.habilitarCamposRestricao(false);
        cadastraProf.preencherComboCoordenadorias();
        if(professor != null){
            cadastraProf.setProfessor(professor);
            cadastraProf.setarCoordenadoria();
            cadastraProf.setarCamposComInstancia(professor);
            cadastraProf.preencherListaRestricoes();
        }
    }
    
    public void preencherListaRestricoes(JList lstRestricoes) {
        
        Professor professor = cadastraProf.getProfessor();
        List listaRestricoes = ctrlPrincipal.getCtrlRestricao().filtrarPorProfessor(professor.getId());
        cadastraProf.setListaRestricoes(listaRestricoes);
        preencherJList(listaRestricoes, lstRestricoes);   
    }
    
    public void preencherComboCoordenadorias(JComboBox cbxCoordenadoria) {
        
        List listaCoordenadorias = ctrlPrincipal.getCtrlCoordenadoria().consultar();
        buscaProf.setListaCoordenadorias(listaCoordenadorias);
        
        if(cadastraProf != null)
            cadastraProf.setListaCoordenadorias(listaCoordenadorias);
        if(listaCoordenadorias.size() > 0){
            preencherCombo(cbxCoordenadoria, listaCoordenadorias);
        }    
    }
    
    public void setarCoordenadoria(JComboBox cbxCoordenadoria){
        
        List listaCoordenadorias = buscaProf.getListaCoordenadorias();
        cadastraProf.setListaCoordenadorias(listaCoordenadorias);
        Professor professor = cadastraProf.getProfessor();
        Coordenadoria coordenadoria;
        
        for (int i = 0; i < listaCoordenadorias.size(); i++) {

            coordenadoria = (Coordenadoria) listaCoordenadorias.get(i);
            if (coordenadoria.getId() == professor.getCoordenadoria().getId()) {
                cbxCoordenadoria.setSelectedIndex(i);
                break;
            }
        }
    }
    
    public void adicionarRestricao(String nome, String turno, String dia, String descricao, String prioridade,
            boolean aula1, boolean aula2, boolean aula3, boolean aula4, boolean aula5, boolean aula6, Professor professor){
        
        List listaRestricoes = cadastraProf.getListaRestricoes();
        
        RestricaoProfessor restricao = ctrlPrincipal.getCtrlRestricao().cadastrar(
                nome, turno, dia, descricao, prioridade, aula1, aula2, aula3, aula4, aula5, aula6, professor);

        if (restricao != null) {
            listaRestricoes.add(restricao);
            cadastraProf.setListaRestricoes(listaRestricoes);
            cadastraProf.limparTelaRestricao();
            cadastraProf.preencherListaRestricoes();
        }
    }
    
    public void removerRestricao(JList lstRestricoes){
        
        int posicao = lstRestricoes.getSelectedIndex();
        List listaRestricoes = cadastraProf.getListaRestricoes();
        RestricaoProfessor restricao = (RestricaoProfessor) listaRestricoes.get(posicao);

        if (restricao != null) {
            int confirmacao = CtrlMensagem.exibirMensagemConfirmacao(cadastraProf, "Confirmar Remoção ?");
            if (confirmacao == 0) {

                int resposta = ctrlPrincipal.getCtrlRestricao().excluir(restricao);
                if (resposta == 0) {
                    listaRestricoes.remove(posicao);
                    cadastraProf.setListaRestricoes(listaRestricoes);
                    cadastraProf.limparTelaRestricao();
                    preencherListaRestricoes(lstRestricoes);
                }
            }
        }else{
            CtrlMensagem.exibirMensagemAviso(cadastraProf, "Selecione uma Restrição");
        }
    }
    
    public boolean validarCampos(String nome, String matricula, int cargaHoraria, Coordenadoria coordenadoria){
        
        if((nome.equals("")))
            return false;
        if(matricula.equals(""))
            return false;
        if(cargaHoraria < 20)
            return false;
        if(coordenadoria == null)
            return false;
        return true;
    }
}

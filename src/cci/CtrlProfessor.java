package cci;

import cdp.Coordenadoria;
import cdp.Professor;
import cdp.RestricaoProfessor;
import cgt.Constantes;
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

    private JDBuscarProfessor buscaProf;
    private JDCadastrarProfessor cadastraProf;
    private CtrlPrincipal ctrlPrincipal;

    public CtrlProfessor(CtrlPrincipal ctrl) {
        ctrlPrincipal = ctrl;
    }
    
    public Image setarIconeJanela() {
        ImageIcon icone = new ImageIcon("src/cih/img/professor.png");
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
        buscaProf.atualizarTabela();
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
            return ctrlPrincipal.getGtPrincipal().getGtProfessor().buscar(coluna.toLowerCase(), texto);      
    }
    
    public List<Professor> filtrarPorCoordenadoria(int id){
        return ctrlPrincipal.getGtPrincipal().getGtProfessor().filtrarPorCoordenadoria(id);
    }
    
    public List<Professor> filtrarAtivosPorCoordenadoria(int id){
        return ctrlPrincipal.getGtPrincipal().getGtProfessor().filtrarAtivosPorCoordenadoria(id);
    }
    
    public List<Professor> filtrarAtivos(){
        return ctrlPrincipal.getGtPrincipal().getGtProfessor().consultarAtivos();
    }
    
    public List<Professor> filtrarPorEixo(int id){
        return ctrlPrincipal.getGtPrincipal().getGtProfessor().filtrarPorEixo(id);
    }
    
    public List<Professor> filtrarAtivosPorEixo(int id){
        return ctrlPrincipal.getGtPrincipal().getGtProfessor().filtrarAtivosPorEixo(id);
    }

    public void cadastrar(String nome, String matricula, int cargaHoraria, Coordenadoria coordenadoria, String email, boolean ativo) {

        String resposta = ctrlPrincipal.getGtPrincipal().getGtProfessor().cadastrar(nome, matricula, cargaHoraria, coordenadoria, email, ativo);
        
        if (resposta.equals(Constantes.CADASTRADO)) {
            
            Professor professor = ctrlPrincipal.getGtPrincipal().getGtProfessor().getProfessorSelecionado();
            cadastraProf.setProfessor(professor);
            
            CtrlMensagem.exibirMensagemSucesso(cadastraProf, "Cadastrado com sucesso!");
            cadastraProf.desabilitarCamposProfessor(false);
            cadastraProf.habilitarCamposRestricao(true);
            buscaProf.atualizarTabela();
            
        }else
            CtrlMensagem.exibirMensagemErro(cadastraProf, resposta);     
    }

    public void alterar(String nome, String matricula, int cargaHoraria, Coordenadoria coordenadoria, Professor professor, String email, boolean ativo) {

        String resposta = ctrlPrincipal.getGtPrincipal().getGtProfessor().alterar(nome, matricula, cargaHoraria, coordenadoria, professor, email, ativo);
        
        if (resposta.equals(Constantes.ALTERADO)) { 
            
            Professor prof = ctrlPrincipal.getGtPrincipal().getGtProfessor().getProfessorSelecionado();
            cadastraProf.setProfessor(prof);
            
            CtrlMensagem.exibirMensagemSucesso(cadastraProf, "Alterado com sucesso!");
            cadastraProf.desabilitarCamposProfessor(false);
            cadastraProf.habilitarCamposRestricao(true);
            buscaProf.atualizarTabela();
            
        }else
            CtrlMensagem.exibirMensagemErro(cadastraProf, resposta);    
    }

    public List<Professor> consultar() {
        return ctrlPrincipal.getGtPrincipal().getGtProfessor().consultar();
    }
    
    public List<Professor> consultarAtivos() {
        return ctrlPrincipal.getGtPrincipal().getGtProfessor().consultarAtivos();
    }

    public void excluir(JTable tblProfessor) {

        try {
            
            Professor professor = (Professor) JTableUtil.getDadosLinhaSelecionada(tblProfessor);

            int confirmacao = CtrlMensagem.exibirMensagemConfirmacao(buscaProf, "Confirmar Exclusão ?");
            if (confirmacao == 0) {
                String resposta = ctrlPrincipal.getGtPrincipal().getGtProfessor().excluir(professor);
                if (resposta.equals(Constantes.EXCLUIDO)) {
                    CtrlMensagem.exibirMensagemSucesso(buscaProf, "Excluído com sucesso!");
                    buscaProf.atualizarTabela();
                }else
                    CtrlMensagem.exibirMensagemErro(buscaProf, resposta);     
            }
        } catch (Exception ex) {
            CtrlMensagem.exibirMensagemErro(buscaProf, ex.getMessage());
        }
    }
    
    public void listarProfessores(String coluna, String texto, JTable tabela) {
       
        List listaProfessores = buscar(coluna, texto);
        listarEmTabela(listaProfessores, tabela, buscaProf, "toArray");  
        
        if(listaProfessores.isEmpty())
            buscaProf.setarMensagem("Nenhum professor encontrado.");
    }
    
    public void removerTodasRestricoesProfessores(){
        int confirmacao = CtrlMensagem.exibirMensagemConfirmacao(buscaProf, "Este processo remove TODAS as restrições cadastradas.\nDesaja confirmar essa operação ?");
        if(confirmacao == 0){
            
            String resposta = ctrlPrincipal.getGtPrincipal().getGtRestricao().excluirTodasRestricoes();
            
            if (resposta.equals(Constantes.EXCLUIDO)) {
                CtrlMensagem.exibirMensagemSucesso(buscaProf, "Restrições removidas com sucesso!");
            }else
                CtrlMensagem.exibirMensagemErro(buscaProf, resposta);  
        }
    }
    
    //================================================= TELA DE CADASTRO ====================================================
    
    public void validarOperacao(String nome, String matricula, int cargaHoraria, Coordenadoria coordenadoria, String email, boolean ativo){  
        
        Professor professor = cadastraProf.getProfessor();
        
        if(validarCampos(nome, matricula, coordenadoria)){
            
            if(professor == null)   
                cadastrar(nome, matricula, cargaHoraria, coordenadoria, email, ativo);
            else
                alterar(nome, matricula, cargaHoraria, coordenadoria, professor, email, ativo);
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
    
    public void adicionarRestricao(String nome, String turno, int dia, String descricao, String prioridade,
            boolean aula1, boolean aula2, boolean aula3, boolean aula4, boolean aula5, boolean aula6, Professor professor){
        
        RestricaoProfessor restricao = ctrlPrincipal.getCtrlRestricao().cadastrar(
                nome, turno, dia, descricao, prioridade, aula1, aula2, aula3, aula4, aula5, aula6, professor);

        if (restricao != null) {
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
    
    public boolean validarCampos(String nome, String matricula, Coordenadoria coordenadoria){
        
        if((nome.equals("")))
            return false;
        if(matricula.equals(""))
            return false;
        if(coordenadoria == null)
            return false;
        
        return true;
    }
}

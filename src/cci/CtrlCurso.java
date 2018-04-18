package cci;

import cdp.Coordenadoria;
import cdp.Curso;
import cdp.Eixo;
import cgt.Constantes;
import cgt.GtCurso;
import cih.curso.JDBuscarCurso;
import cih.curso.JDCadastrarCurso;
import java.awt.Frame;
import java.awt.Image;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;

public class CtrlCurso extends CtrlGenerica{
    
    private CtrlPrincipal ctrlPrincipal;
    private JDBuscarCurso buscaCurso;
    private JDCadastrarCurso cadastraCurso;
    private GtCurso gtCurso;

    public CtrlCurso(CtrlPrincipal ctrl) {
        this.ctrlPrincipal = ctrl;
        gtCurso = new GtCurso();
    }
    
    public Image setarIconeJanela() {
        ImageIcon icone = new ImageIcon("build/classes/cih/img/curso.png");
        return icone.getImage();
    }
    
    public void transitarTelas(JTable tabela, Frame pai){
        
        try {
            Curso curso = (Curso) JTableUtil.getDadosLinhaSelecionada(tabela);
            ctrlPrincipal.getCtrlCurso().instanciarTelaCadastroCurso(curso, pai);
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            CtrlMensagem.exibirMensagemErro(buscaCurso, "Selecione um curso");
        }
    }
    
    public void instanciarTelaBuscaCurso(Frame pai) {
        buscaCurso = new JDBuscarCurso(pai, true, ctrlPrincipal);
        buscaCurso.setIconImage(setarIconeJanela());
        buscaCurso.setVisible(true);
    }

    public void instanciarTelaCadastroCurso(Curso curso, Frame pai) {
        cadastraCurso = new JDCadastrarCurso(pai, true, ctrlPrincipal, curso);
        cadastraCurso.setIconImage(setarIconeJanela());
        identificarOrigem(curso);
        cadastraCurso.setVisible(true);
    }
    
    public void cadastrar(String nome, String nivel, int periodos, Coordenadoria coordenadoria) {

        String resposta = gtCurso.cadastrar(nome, nivel, periodos, coordenadoria);

        if (resposta.equals(Constantes.CADASTRADO)) {
            ctrlPrincipal.getCtrlMensagem().exibirMensagemSucesso(cadastraCurso, "Cadastrado com sucesso!");
            cadastraCurso.desabilitarCampos();
        } else {
            ctrlPrincipal.getCtrlMensagem().exibirMensagemErro(cadastraCurso, resposta);
        }
    }
    
    public void alterar(Curso curso, String nome, String nivel, int periodos, Coordenadoria coordenadoria) {

        String resposta = gtCurso.alterar(curso, nome, nivel, periodos, coordenadoria);
        
        if (resposta.equals(Constantes.ALTERADO)) {
            ctrlPrincipal.getCtrlMensagem().exibirMensagemSucesso(cadastraCurso, "Alterado Com sucesso!");
            cadastraCurso.desabilitarCampos();
        } else {
            ctrlPrincipal.getCtrlMensagem().exibirMensagemErro(cadastraCurso, resposta);
        }
    }
    
    public List<Curso> buscar(String coluna, String texto) {
        return gtCurso.buscar(coluna, texto);
    }
    
    public void listarCursos(String coluna, String texto, JTable tabela){
        
        List listaCursos = buscaCurso.getListaCursos();
        
        listaCursos = buscar(coluna, texto);
        JTableUtil.limparTabela(tabela);
        
        if(listaCursos.size() > 0){
   
            try {
                JTableUtil.preencherTabela(listaCursos, tabela);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
         }else
            CtrlMensagem.exibirMensagemAviso(buscaCurso, "Nenhum registro encontrado");
    }
    
    public List<Curso> listar() {
       return gtCurso.listar();
    }
    
    public void excluir(Curso curso) {

        String resposta = gtCurso.excluir(curso);
        if (resposta.equals(Constantes.EXCLUIDO)) {
            ctrlPrincipal.getCtrlMensagem().exibirMensagemSucesso(buscaCurso, "Excluído com sucesso!");
        } else {
            ctrlPrincipal.getCtrlMensagem().exibirMensagemErro(buscaCurso, resposta);
        }
    }

    //======================================= TELA DE CADASTRO ===============================================
    
    public void validarOperacao(Coordenadoria coordenadoria, String nome, String nivel, int periodos){  
        
        Curso curso = cadastraCurso.getCurso();
        
        if(validarCampos(nome)){
            
            if(curso == null)   
                cadastrar(nome, nivel, periodos, coordenadoria);  
            else
                alterar(curso, nome, nivel, periodos, coordenadoria);
        }else
            CtrlMensagem.exibirMensagemAviso(cadastraCurso, "Todos os campos devem ser preenchidos");
    }
    
    public void identificarOrigem(Curso curso){
        cadastraCurso.preencherComboEixos();
        if(curso != null){
            cadastraCurso.setarCamposComInstancia(curso);
            cadastraCurso.setarEixo();
            cadastraCurso.setarCoordenadoria();
            cadastraCurso.desabilitarCamposIniciais();
        }
    }
    
    public void setarEixo(JComboBox cbxEixo, JComboBox cbxCoordenadoria){
        
        List listaEixos = cadastraCurso.getListaEixos();
        Curso curso = cadastraCurso.getCurso();
        Eixo eixo;

        for (int i = 0; i < listaEixos.size(); i++) {

            eixo = (Eixo) listaEixos.get(i);
            if (eixo.getId() == curso.getCoordenadoria().getEixo().getId()) {
                cbxEixo.setSelectedIndex(i);
                preencherComboCoordenadorias(eixo.getId(), cbxCoordenadoria);
                break;
            }
        }
    }
    
    public void setarCoordenadoria(JComboBox cbxCoordenadoria){
        
        List listaCoordenadorias = cadastraCurso.getListaCoordenadorias();
        Curso curso = cadastraCurso.getCurso();
        Coordenadoria coordenadoria;
        
        for (int i = 0; i < listaCoordenadorias.size(); i++) {

            coordenadoria = (Coordenadoria) listaCoordenadorias.get(i);
            if (coordenadoria.getId() == curso.getCoordenadoria().getId()) {
                cbxCoordenadoria.setSelectedIndex(i);
                break;
            }
        }
    }
    
    public void preencherComboEixos(JComboBox cbxEixo, JComboBox cbxCoordenadoria){ 
        
        List listaEixos = cadastraCurso.getListaEixos();
        listaEixos = ctrlPrincipal.getCtrlEixo().consultar();
        preencherCombo(cbxEixo, listaEixos);
        
        if(listaEixos.size() > 0){
            Eixo eixo = (Eixo) cbxEixo.getSelectedItem();
            preencherComboCoordenadorias(eixo.getId(), cbxCoordenadoria);
        }
    }

    public void preencherComboCoordenadorias(int id, JComboBox cbxCoordenadoria) {
        
        List listaCoordenadorias = cadastraCurso.getListaCoordenadorias();
        listaCoordenadorias = ctrlPrincipal.getCtrlCoordenadoria().filtrarCoordenadoriasEixo(id);
        preencherCombo(cbxCoordenadoria, listaCoordenadorias);   
    }
    
    public void adicionarEixo(JTextField nome){
        
        int resposta = ctrlPrincipal.getCtrlEixo().cadastrar(nome.getText());
        if(resposta == 0){     
            nome.setText("");
            cadastraCurso.preencherComboEixos();
        } 
    }
    
    public void adicionarCoordenadoria(JTextField nome, Eixo eixo, JComboBox cbxCoordenadoria){
        
        int resposta = ctrlPrincipal.getCtrlCoordenadoria().cadastrar(nome.getText(), eixo);
        
        if(resposta == 0){
            nome.setText("");
            preencherComboCoordenadorias(eixo.getId(), cbxCoordenadoria);  
        }    
    }
    
    public void removerEixo(JComboBox cbxEixo){
        int confirmacao = CtrlMensagem.exibirMensagemConfirmacao(cadastraCurso, "Confirmar Exclusão ?");
            if (confirmacao == 0) {
                Eixo eixo = (Eixo) cbxEixo.getSelectedItem();
                int resposta = ctrlPrincipal.getCtrlEixo().excluir(eixo);
                if(resposta == 0){
                    cadastraCurso.preencherComboEixos();    
                }
            }
    }
    
    public void removerCoordenadoria(JComboBox cbxEixo, JComboBox cbxCoordenadoria){
        int confirmacao = CtrlMensagem.exibirMensagemConfirmacao(cadastraCurso, "Confirmar Exclusão ?");
        if (confirmacao == 0) {
            Coordenadoria coordenadoria = (Coordenadoria) cbxCoordenadoria.getSelectedItem();
            int resposta = ctrlPrincipal.getCtrlCoordenadoria().excluir(coordenadoria);
            if (resposta == 0) {
                Eixo eixo = (Eixo) cbxEixo.getSelectedItem();
                preencherComboCoordenadorias(eixo.getId(), cbxCoordenadoria);
            }
        }
    }
    
    public boolean validarCampos(String nome){
        
        if((nome.equals("")))
            return true;
        return false;
    }
}

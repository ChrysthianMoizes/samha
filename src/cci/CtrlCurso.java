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
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;

public class CtrlCurso extends CtrlGenerica{
    
    private CtrlPrincipal ctrlPrincipal;
    private JDBuscarCurso buscaCurso;
    private JDCadastrarCurso cadastraCurso;

    public CtrlCurso(CtrlPrincipal ctrl) {
        this.ctrlPrincipal = ctrl;
    }
    
    public Image setarIconeJanela() {
        ImageIcon icone = new ImageIcon("build/classes/cih/img/curso.png");
        return icone.getImage();
    }
    
    public void transitarTelas(JTable tabela, Frame pai){
        
        try {
            Curso curso = (Curso) JTableUtil.getDadosLinhaSelecionada(tabela);
            instanciarTelaCadastroCurso(curso, pai);
            
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

        String resposta = ctrlPrincipal.getGtPrincipal().getGtCurso().cadastrar(nome, nivel, periodos, coordenadoria);

        if (resposta.equals(Constantes.CADASTRADO)) {
            CtrlMensagem.exibirMensagemSucesso(cadastraCurso, "Cadastrado com sucesso!");
            cadastraCurso.desabilitarCampos();
            cadastraCurso.desabilitarCombos();
            buscaCurso.atualizarTabela();
        } else {
            CtrlMensagem.exibirMensagemErro(cadastraCurso, resposta);
        }
    }
    
    public void alterar(Curso curso, String nome, String nivel, int periodos, Coordenadoria coordenadoria) {

        String resposta = ctrlPrincipal.getGtPrincipal().getGtCurso().alterar(curso, nome, nivel, periodos, coordenadoria);
        
        if (resposta.equals(Constantes.ALTERADO)) {
            CtrlMensagem.exibirMensagemSucesso(cadastraCurso, "Alterado Com sucesso!");
            cadastraCurso.desabilitarCampos();
            cadastraCurso.desabilitarCombos();
            buscaCurso.atualizarTabela();
        } else {
            CtrlMensagem.exibirMensagemErro(cadastraCurso, resposta);
        }
    }
    
    public void excluir(JTable tabela) {

        try {
            Curso curso = (Curso) JTableUtil.getDadosLinhaSelecionada(tabela);
            int confirmacao = CtrlMensagem.exibirMensagemConfirmacao(buscaCurso, "Confirmar Exclusão ?");
            if (confirmacao == 0) {
                String resposta = ctrlPrincipal.getGtPrincipal().getGtCurso().excluir(curso);
                if (resposta.equals(Constantes.EXCLUIDO)) {
                    CtrlMensagem.exibirMensagemSucesso(buscaCurso, "Excluído com sucesso!");
                    buscaCurso.atualizarTabela();
                } else {
                    CtrlMensagem.exibirMensagemErro(buscaCurso, resposta);
                }
            }
        } catch (Exception ex) {
            CtrlMensagem.exibirMensagemErro(buscaCurso, "Selecione um curso");
        }   
    }
    
    public List<Curso> buscar(String coluna, String texto) {
        return ctrlPrincipal.getGtPrincipal().getGtCurso().buscar(coluna, texto);
    }
    
    public void listarCursos(String coluna, String texto, JTable tabela){
        
        List listaCursos = ctrlPrincipal.getGtPrincipal().getGtCurso().buscar(coluna, texto);
        listarEmTabela(listaCursos, tabela, buscaCurso, "toArray");
        
        if(listaCursos.size() == 0)
            buscaCurso.setarMensagem("Nenhum curso encontrado.");
    }
    
    public List<Curso> listar() {
       return ctrlPrincipal.getGtPrincipal().getGtCurso().listar();
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
            cadastraCurso.setCurso(curso);
            cadastraCurso.setarCamposComInstancia(curso);
            cadastraCurso.setarEixo(curso);
            cadastraCurso.setarCoordenadoria();
            cadastraCurso.setarNivel();
            cadastraCurso.desabilitarCamposIniciais();
        }
    }
    
    public void setarEixo(Curso curso, JComboBox cbxEixo, JComboBox cbxCoordenadoria){
        
        List listaEixos = cadastraCurso.getListaEixos();
        Eixo eixo;
        
        for (int i = 0; i < listaEixos.size(); i++) {

            eixo = (Eixo) listaEixos.get(i);
           // if (eixo.getId() == curso.getCoordenadoria().getEixo().getId()) {
                cbxEixo.setSelectedIndex(i);
                preencherComboCoordenadorias(eixo.getId(), cbxCoordenadoria);
                break;
            //}
        }
    }
    
    public void setarCoordenadoria(JComboBox cbxCoordenadoria){
        
        List listaCoordenadorias = cadastraCurso.getListaCoordenadorias();
        Curso curso = cadastraCurso.getCurso();
        Coordenadoria coordenadoria;
        
        for (int i = 0; i < listaCoordenadorias.size(); i++) {

            coordenadoria = (Coordenadoria) listaCoordenadorias.get(i);
            //if (coordenadoria.getId() == curso.getCoordenadoria().getId()) {
                cbxCoordenadoria.setSelectedIndex(i);
                break;
            //}
        }
    }
    
    public void setarNivel(JComboBox cbxNivel){
        
        Curso curso = cadastraCurso.getCurso();
        
        if(curso.getNivel().equals("ENSINO MÉDIO INTEGRADO"))
            cbxNivel.setSelectedIndex(0);
        else if(curso.getNivel().equals("GRADUAÇÃO"))
            cbxNivel.setSelectedIndex(1);
        else if(curso.getNivel().equals("PÓS-GRADUAÇÃO"))
            cbxNivel.setSelectedIndex(2);
        else if(curso.getNivel().equals("MESTRADO"))
            cbxNivel.setSelectedIndex(3);
        else
            cbxNivel.setSelectedIndex(4);
    }
    
    public void preencherComboEixos(JComboBox cbxEixo, JComboBox cbxCoordenadoria){ 
        
        List listaEixos = ctrlPrincipal.getCtrlEixo().consultar();
        cadastraCurso.setListaEixos(listaEixos);
        preencherCombo(cbxEixo, listaEixos);
        
        if(listaEixos.size() > 0){
            Eixo eixo = (Eixo) cbxEixo.getSelectedItem();
            preencherComboCoordenadorias(eixo.getId(), cbxCoordenadoria);
        }
    }

    public void preencherComboCoordenadorias(int id, JComboBox cbxCoordenadoria) {
        
        List listaCoordenadorias = ctrlPrincipal.getCtrlCoordenadoria().filtrarCoordenadoriasEixo(id);
        cadastraCurso.setListaCoordenadorias(listaCoordenadorias);
        preencherCombo(cbxCoordenadoria, listaCoordenadorias);   
    }
    
    public void adicionarEixo(JTextField nome){
        
        int resposta = ctrlPrincipal.getCtrlEixo().cadastrar(nome.getText());
        if(resposta == 0){     
            nome.setText("");
            cadastraCurso.preencherComboEixos();
        } 
    }
    
    public void adicionarCoordenadoria(JTextField txtNome, Eixo eixo, JComboBox cbxCoordenadoria){
        
        int resposta = ctrlPrincipal.getCtrlCoordenadoria().cadastrar(txtNome.getText(), eixo);
        
        if(resposta == 0){
            txtNome.setText("");
            preencherComboCoordenadorias(eixo.getId(), cbxCoordenadoria);  
        }    
    }
    
    public void removerEixo(JComboBox cbxEixo){
        
        try{
            Eixo eixo = (Eixo) cbxEixo.getSelectedItem();
            if(eixo != null){
                int confirmacao = CtrlMensagem.exibirMensagemConfirmacao(cadastraCurso, "Confirmar Exclusão ?");
                    if (confirmacao == 0) {

                        int resposta = ctrlPrincipal.getCtrlEixo().excluir(eixo);
                        if(resposta == 0){
                            cadastraCurso.preencherComboEixos();    
                        }
                    }
            }else
                CtrlMensagem.exibirMensagemAviso(cadastraCurso, "Lista de eixos vazia");
        }catch(Exception e){
            CtrlMensagem.exibirMensagemAviso(cadastraCurso, "Lista de eixos vazia");
        }    
    }
    
    public void removerCoordenadoria(JComboBox cbxEixo, JComboBox cbxCoordenadoria){
        
        try{
            Coordenadoria coordenadoria = (Coordenadoria) cbxCoordenadoria.getSelectedItem();
            if(coordenadoria != null){
                int confirmacao = CtrlMensagem.exibirMensagemConfirmacao(cadastraCurso, "Confirmar Exclusão ?");
                if (confirmacao == 0) {

                    int resposta = ctrlPrincipal.getCtrlCoordenadoria().excluir(coordenadoria);
                    if (resposta == 0) {
                        Eixo eixo = (Eixo) cbxEixo.getSelectedItem();
                        preencherComboCoordenadorias(eixo.getId(), cbxCoordenadoria);
                    }
                }
            }else
                CtrlMensagem.exibirMensagemAviso(cadastraCurso, "Lista de coordenadorias vazia");
        }catch(Exception e){
            CtrlMensagem.exibirMensagemAviso(cadastraCurso, "Lista de coordenadorias vazia");
        }
    }
    
    public boolean validarCampos(String nome){
        
        if((nome.equals("")))
            return false;
        return true;
    }
}

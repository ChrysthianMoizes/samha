package cci;

import cdp.Alocacao;
import cdp.Aula;
import cdp.Coordenadoria;
import cdp.Curso;
import cdp.Disciplina;
import cdp.Eixo;
import cdp.Oferta;
import cdp.Professor;
import cdp.Turma;
import cgt.Constantes;
import cih.relatorio.JDTipoRelatorio;
import cih.relatorio.JDRelatorioProfessor;
import cih.relatorio.JDRelatorioTurma;
import java.awt.Frame;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTable;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRRuntimeException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class CtrlRelatorio extends CtrlGenerica{
    
    private CtrlPrincipal ctrlPrincipal;
    private JDTipoRelatorio jdTipoRelatorio;
    private JDRelatorioTurma jdRelatorioTurma;
    private JDRelatorioProfessor jdRelatorioProfessor;
    
    public CtrlRelatorio(CtrlPrincipal ctrl){
        this.ctrlPrincipal = ctrl;
    }
    
    public void instanciarTelaRelatorioTurma(Frame pai){
        jdRelatorioTurma = new JDRelatorioTurma(pai, true, ctrlPrincipal);
        jdRelatorioTurma.setIconImage(setarIconeJanela());
        jdRelatorioTurma.preencherComboEixo();
        jdRelatorioTurma.preencherComboCurso();
        jdRelatorioTurma.preencherComboTurma();
        jdRelatorioTurma.setarTurno();
        jdRelatorioTurma.identificarOferta();
        jdRelatorioTurma.ativarFiltroNenhum();
        jdRelatorioTurma.setVisible(true);
    }
    
    public void instanciarTelaRelatorioProfessor(Frame pai){
        jdRelatorioProfessor = new JDRelatorioProfessor(pai, true, ctrlPrincipal);
        jdRelatorioProfessor.setIconImage(setarIconeJanela());
        jdRelatorioProfessor.preencherComboEixo();
        jdRelatorioProfessor.preencherComboCoordenadoria();
        jdRelatorioProfessor.preencherComboProfessor();
        jdRelatorioProfessor.preencherTabelaProfessor();
        jdRelatorioProfessor.ativarFiltroNenhum();
        jdRelatorioProfessor.setVisible(true);
    }
    
    public void instanciarTelaTipoRelatorio(Frame pai){
        jdTipoRelatorio = new JDTipoRelatorio(pai, true, ctrlPrincipal);
        jdTipoRelatorio.setIconImage(setarIconeJanela());
        jdTipoRelatorio.setVisible(true);
    }
    
    public Image setarIconeJanela() {
        ImageIcon icone = new ImageIcon("build/classes/cih/img/relatorio.png");
        return icone.getImage();
    }
    
    public void identificarTipoRelatorio(Frame pai, char tipo){  
        switch(tipo){
            
            case 'P': 
                instanciarTelaRelatorioProfessor(pai);
                break;
            case 'T': 
                instanciarTelaRelatorioTurma(pai);
                break;
            default: break;
        }          
    }
    
    public void preencherComboEixos(JComboBox cbxEixo){ 
        
        List listaEixos = ctrlPrincipal.getCtrlEixo().consultar();
        preencherCombo(cbxEixo, listaEixos);
       
    }
    
    public void preencherComboCoordenadoria(JComboBox cbxEixo, JComboBox cbxCoordenadoria){
        
        Eixo eixo = (Eixo) cbxEixo.getSelectedItem();
        
        if(eixo != null){
            
            List listaCoordenadorias = ctrlPrincipal.getCtrlCoordenadoria().filtrarCoordenadoriasEixo(eixo.getId());
            preencherCombo(cbxCoordenadoria, listaCoordenadorias);
        }
        
    }
    
    public void preencherComboCurso(JComboBox cbxEixo, JComboBox cbxCurso, JComboBox cbxTurma){ 
       
        Eixo eixo = (Eixo) cbxEixo.getSelectedItem();
        
        if(eixo != null){
            
            List listaCursos = ctrlPrincipal.getCtrlCurso().filtrarPorEixo(eixo.getId());
            preencherCombo(cbxCurso, listaCursos);
        }
    }
    
    public void preencherComboTurma(JComboBox cbxCurso, JComboBox cbxTurma) {
        
        Curso curso = (Curso) cbxCurso.getSelectedItem();
        
        if(curso != null){
            List listaTurmas = ctrlPrincipal.getCtrlTurma().filtrarPorCurso(curso.getId());
            preencherCombo(cbxTurma, listaTurmas);           
        }  
    }
    
    public void preencherComboProfessor(JComboBox cbxCoordenadoria, JComboBox cbxProfessor){
        
        Coordenadoria coord = (Coordenadoria) cbxCoordenadoria.getSelectedItem();
    
        if(coord != null){
            
            List listaProfessores = ctrlPrincipal.getCtrlProfessor().filtrarPorCoordenadoria(coord.getId());
            preencherCombo(cbxProfessor, listaProfessores);   
        }
    
    }
    
    public void setarTurno(JComboBox cbxTurma, JComboBox cbxTurno){
        
        Turma turma = (Turma) cbxTurma.getSelectedItem();
        
        if(turma != null){ 
            ctrlPrincipal.getCtrlOferta().setarTurno(turma.getTurno(), cbxTurno);
        }
    }
    
    public void identificarOferta(int ano, int semestre, JComboBox cbxTurma){

        Turma turma = (Turma) cbxTurma.getSelectedItem();
        Oferta oferta = null;
        
        if(turma != null){
            jdRelatorioTurma.setarTurma(turma.getNome());
            oferta = ctrlPrincipal.getGtPrincipal().getGdPrincipal().getGdOferta().filtrarOferta(ano, semestre, turma.getId());
            
            if(oferta != null){
                ctrlPrincipal.getGtPrincipal().getGtAula().preencherMatrizOferta(oferta);
            }
        }else
            jdRelatorioTurma.setarTurma("Turma");
        
        jdRelatorioTurma.preencherTabelaTurma(oferta);
    }
    
    public void preencherTabelaTurma(JTable tblTurma, JComboBox cbxTurno, Oferta oferta){
        
        JTableUtil.limparCelulasTabela(tblTurma);

        if(oferta != null){
            
            String turno = (String) cbxTurno.getSelectedItem();        
            int t = ctrlPrincipal.getGtPrincipal().getGtAula().obterNumeroTurno(turno);
            
            Aula aula;

            for(int linha = 0; linha < Constantes.LINHA; linha++){

                for(int coluna = t; coluna < (Constantes.AULAS + t); coluna++){
                    aula = ctrlPrincipal.getGtPrincipal().getGtAula().getAulaMatriz(linha, coluna);
                    if(aula != null)
                        tblTurma.setValueAt(aula, linha, aula.getNumero() - t);
                }  
            }
        }
    }
    
    public void preencherTabelaProfessor(int ano, int semestre, JComboBox cbxProfessor, JTable tblProfessor){
        
        Professor professor = (Professor) cbxProfessor.getSelectedItem();
        
        if(professor != null){
            jdRelatorioProfessor.setarProfessor(professor.getNome());
            List listaAulas = ctrlPrincipal.getGtPrincipal().getGtAula().filtrarAulasProfessorAnoSemestre(ano, semestre, professor.getId());
            preencherTabelaProfessor(tblProfessor, listaAulas);
            
        }else{
            jdRelatorioProfessor.setarProfessor("Professor");
            JTableUtil.limparCelulasTabela(tblProfessor);
        }    
    }
    
    public void preencherTabelaProfessor(JTable tblProfessor, List listaAulas){
 
        JTableUtil.limparCelulasTabela(tblProfessor);
        
        Aula aula;        
        for(int i = 0; i < listaAulas.size(); i++){
            aula = (Aula) listaAulas.get(i);
            tblProfessor.setValueAt(aula.getOferta().getTurma().getNome(), aula.getDia(), aula.getNumero());
        }
    }
    
    public List preencherListaAulasVazias(List[] aulas){
    
        Aula aula;
        Aula[] vetorAulas;
        
        List lista = new ArrayList<>();
        
        for(int dia = 0; dia < Constantes.LINHA; dia++){
            
            vetorAulas = preencherVetorAulas(aulas[dia]);
            
            for(int numero = 0; numero < 16; numero++){
                
                aula = vetorAulas[numero];
                
                if(aula == null){
                    aula = gerarAulaVazia(dia, numero);
                }
                lista.add(aula);
            }
        }
        return lista;
    }
    
    public Aula[] preencherVetorAulas(List<Aula> lista){
    
        Aula[] vetorAulas = new Aula[16];
        
        for(Aula aula : lista){
            vetorAulas[aula.getNumero()] = aula;
        }
        return vetorAulas;
    }    
    
    public Aula gerarAulaVazia(int dia, int numero){
        
        Aula aula = new Aula();
        
        aula.setDia(dia);
        aula.setNumero(numero);
        aula.setAlocacao(gerarAlocacaoVazia());
        aula.setOferta(gerarOfertaVazia());
        return aula;
    }
    
    public Oferta gerarOfertaVazia(){
        
        Oferta oferta = new Oferta();
        oferta.setTurma(gerarTurmaVazia());
        return oferta;
    }
    
    public Turma gerarTurmaVazia(){
        
        Turma turma = new Turma();
        turma.setNome("");
        
        return turma;
    }
    
    public Alocacao gerarAlocacaoVazia(){
        
        Alocacao alocacao = new Alocacao();
        alocacao.setProfessor1(gerarProfessorVazio());
        alocacao.setProfessor2(null);
        alocacao.setDisciplina(gerarDisciplinaVazia());
        
        return alocacao;
    }
    
    public Disciplina gerarDisciplinaVazia(){
        
        Disciplina disciplina = new Disciplina();
        disciplina.setNome("");
        disciplina.setSigla("");
        
        return disciplina;
    }
    
    public Professor gerarProfessorVazio(){
        Professor professor = new Professor();
        professor.setNome("");
        return professor;
    }
    
    public void gerarRelatorio(List lista, Map parametros, String nomeRelatorio, String nomeExport) throws JRException, FileNotFoundException, JRRuntimeException{
           
        InputStream arquivo = Aula.class.getResourceAsStream("/cih/relatorio/" + nomeRelatorio + ".jrxml");

        JasperReport report = JasperCompileManager.compileReport(arquivo);
        JRBeanCollectionDataSource dados = new JRBeanCollectionDataSource(lista);

        JasperPrint print = JasperFillManager.fillReport(report, parametros, dados);
        JasperExportManager.exportReportToPdfFile(print, nomeExport);

    }
    
    public String criarDiretorioArquivamento(String tipo, int ano, int semestre){
        
        String caminho = System.getProperty("user.dir") + "/Relatorios/" + tipo + "/" + ano + "-" + semestre;
        File diretorio = new File(caminho);
            
        if (!diretorio.exists())
            diretorio.mkdirs();
        
        return caminho + "/";
    }
}

/* EXIBIR RELATÓRIO ANTES DE GERAR

    JasperViewer.viewReport(print, true);

    JDialog janela = new JDialog(new javax.swing.JFrame(), "Relatório", true);
    janela.setSize(1200, 1000);
    janela.setIconImage(ctrlPrincipal.getCtrlRelatorio().setarIconeJanela());
    janela.setLocationRelativeTo(null);

    JasperViewer jasperView = new JasperViewer(print, true);
    janela.getContentPane().add(jasperView.getContentPane());
    janela.setVisible(true);

*/

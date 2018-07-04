package cci;

import cdp.Alocacao;
import cdp.Aula;
import cdp.Coordenadoria;
import cdp.Curso;
import cdp.Eixo;
import cdp.Oferta;
import cdp.Professor;
import cdp.Turma;
import cih.relatorio.JDTipoRelatorio;
import cih.relatorio.JDRelatorioProfessor;
import cih.relatorio.JDRelatorioTurma;
import java.awt.Frame;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
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
        jdRelatorioTurma.preencherComboTurma(false);
        jdRelatorioTurma.setarTurno();
        jdRelatorioTurma.identificarUltimaOfertaTurma();
        jdRelatorioTurma.atualizarAulasTurma();
        jdRelatorioTurma.ativarFiltroNenhum();
        jdRelatorioTurma.setVisible(true);
    }
    
    public void instanciarTelaRelatorioProfessor(Frame pai){
        jdRelatorioProfessor = new JDRelatorioProfessor(pai, true, ctrlPrincipal);
        jdRelatorioProfessor.setIconImage(setarIconeJanela());
        jdRelatorioProfessor.preencherComboEixo();
        jdRelatorioProfessor.preencherComboCoordenadoria();
        jdRelatorioProfessor.preencherComboProfessor();
        jdRelatorioProfessor.identificarUltimaAlocacao();
        jdRelatorioProfessor.atualizarAulasProfessor();
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
    
    public void preencherComboTurma(JComboBox cbxCurso, JComboBox cbxTurma, int ano, int semestre, boolean alterandoAnoSemestre) {
        
        Curso curso = (Curso) cbxCurso.getSelectedItem();
        Turma turmaSelecionada = (Turma) cbxTurma.getSelectedItem();
        
        if(curso != null){
            List listaTurmas = ctrlPrincipal.getCtrlTurma().filtrarPorCurso(curso.getId());
            listaTurmas = ctrlPrincipal.getGtPrincipal().getGtTurma().filtrarTurmasAtivas(listaTurmas, ano, semestre);
            preencherCombo(cbxTurma, listaTurmas);
            ctrlPrincipal.getCtrlTurma().setarTurmaSelecionada(turmaSelecionada, listaTurmas, cbxTurma, alterandoAnoSemestre);
        }  
    }
    
    public void preencherComboProfessor(JComboBox cbxCoordenadoria, JComboBox cbxProfessor){
        
        Coordenadoria coord = (Coordenadoria) cbxCoordenadoria.getSelectedItem();
    
        if(coord != null){
            
            List listaProfessores = ctrlPrincipal.getCtrlProfessor().filtrarAtivosPorCoordenadoria(coord.getId());
            preencherCombo(cbxProfessor, listaProfessores);   
        }
    
    }
    
    public void setarTurno(JComboBox cbxTurma, JComboBox cbxTurno){
        
        Turma turma = (Turma) cbxTurma.getSelectedItem();
        
        if(turma != null){ 
            ctrlPrincipal.getCtrlOferta().setarTurno(turma.getTurno(), cbxTurno);
        }
    }
    
    public void identificarOferta(int ano, int semestre, JComboBox cbxTurma, JComboBox cbxTurno, JTable tblTurma){
        
        Turma turma = (Turma) cbxTurma.getSelectedItem();
        
        String t = (String) cbxTurno.getSelectedItem();        
        int turno = ctrlPrincipal.getGtPrincipal().getGtAula().obterNumeroTurno(t);
        
        if(turma != null){
            jdRelatorioTurma.setarTurma(turma.getNome());
            List listaAulas = ctrlPrincipal.getGtPrincipal().getGtRelatorio().listarAulasTurma(ano, semestre, turma.getId(), turno);
            preencherTabelaTurma(tblTurma, listaAulas);
        }else{
            jdRelatorioTurma.setarTurma("Turma");
            JTableUtil.limparCelulasTabela(tblTurma);
        }
    }
    
    public void identificarUltimaOfertaTurma(JComboBox cbxTurma){
        Turma turma = (Turma) cbxTurma.getSelectedItem();
        if(turma != null){
            Oferta oferta = ctrlPrincipal.getGtPrincipal().getGtOferta().filtrarUltimaOfertaValidaTurma(turma.getId());
            atualizarAnoSemestreTurma(oferta);
        }    
    }
    
    public void atualizarAnoSemestreTurma(Oferta oferta){
        if(oferta != null){
            jdRelatorioTurma.getSpnAno().setEnabled(false);
            jdRelatorioTurma.getSpnAno().setValue(oferta.getAno());
            jdRelatorioTurma.getSpnAno().setEnabled(true);

            jdRelatorioTurma.getSpnSemestre().setEnabled(false);
            jdRelatorioTurma.getSpnSemestre().setValue(oferta.getSemestre());
            jdRelatorioTurma.getSpnSemestre().setEnabled(true);    
        }
    }
    
    public void identificarUltimaAlocacaoProfessor(JComboBox cbxProfessor){
        Professor professor = (Professor) cbxProfessor.getSelectedItem();
        if(professor != null){
            Alocacao alocacao = ctrlPrincipal.getGtPrincipal().getGtAlocacao().identificarUltimaAlocacao();
            atualizarAnoSemestreProfessor(alocacao);
        } 
    }
    
    public void atualizarAnoSemestreProfessor(Alocacao alocacao){
        if(alocacao != null){
            jdRelatorioProfessor.getSpnAno().setEnabled(false);
            jdRelatorioProfessor.getSpnAno().setValue(alocacao.getAno());
            jdRelatorioProfessor.getSpnAno().setEnabled(true);

            jdRelatorioProfessor.getSpnSemestre().setEnabled(false);
            jdRelatorioProfessor.getSpnSemestre().setValue(alocacao.getSemestre());
            jdRelatorioProfessor.getSpnSemestre().setEnabled(true);    
        }
    }
    
    public void preencherTabelaTurma(JTable tblTurma, List listaAulas){
        
        JTableUtil.limparCelulasTabela(tblTurma);
        
        Aula aula;        
        for(int i = 0; i < listaAulas.size(); i++){
            aula = (Aula) listaAulas.get(i);
            tblTurma.setValueAt(aula, aula.getDia(), aula.getNumero() - aula.getTurno());
        }
    }
    
    public void identificarProfessor(int ano, int semestre, JComboBox cbxProfessor, JTable tblProfessor){
        
        Professor professor = (Professor) cbxProfessor.getSelectedItem();
        
        if(professor != null){
            jdRelatorioProfessor.setarProfessor(professor.getNome());
            List listaAulas = ctrlPrincipal.getGtPrincipal().getGtRelatorio().listarAulasProfessor(ano, semestre, professor.getId());
            preencherTabelaProfessor(tblProfessor, listaAulas);
            
        }else{
            jdRelatorioProfessor.setarProfessor("Professor");
            JTableUtil.limparCelulasTabela(tblProfessor);
        }    
    }
    
    public void atualizarListaAulasAnoSemestre(int ano, int semestre){
        ctrlPrincipal.getGtPrincipal().getGtRelatorio().atualizarAulasAnoSemestre(ano, semestre);
    }
    
    public void preencherTabelaProfessor(JTable tblProfessor, List listaAulas){
 
        JTableUtil.limparCelulasTabela(tblProfessor);
        
        Aula aula;        
        for(int i = 0; i < listaAulas.size(); i++){
            aula = (Aula) listaAulas.get(i);
            tblProfessor.setValueAt(aula.getOferta().getTurma().getNome(), aula.getDia(), aula.getNumero());
        }
    }
    
    public void gerarRelatorio(List lista, Map parametros, String nomeRelatorio, String nomeExport) throws JRException, FileNotFoundException, JRRuntimeException{
           
        String logo = obterDiretorioLogoRelatorio();
        parametros.put("logo", logo);
        
        InputStream arquivo = Aula.class.getResourceAsStream("/cih/relatorio/" + nomeRelatorio + ".jrxml");

        JasperReport report = JasperCompileManager.compileReport(arquivo);
        JRBeanCollectionDataSource dados = new JRBeanCollectionDataSource(lista);

        JasperPrint print = JasperFillManager.fillReport(report, parametros, dados);
        JasperExportManager.exportReportToPdfFile(print, nomeExport);

    }
    
    public String obterDiretorioArquivamento(String tipo, int ano, int semestre){
        
        String caminho = obterDiretorioRelatorio() + tipo + "/" + ano + "-" + semestre;
        File diretorio = new File(caminho);
            
        if (!diretorio.exists())
            diretorio.mkdirs();
        
        return caminho + "/";
    }
    
    public String obterDiretorioRelatorio(){
        
        String caminho = "C:/SysAcad/Relatórios/";
        return caminho;
    }
    
    public String obterDiretorioLogoRelatorio(){
        
        String logo = obterDiretorioInicializacao() + "src/cih/img/logo_ifes.JPG";
        return logo.replace("/", "\\");
    }
    
    public String obterDiretorioInicializacao(){
        
        String caminho = System.getProperty("user.dir");
        File diretorio = new File(caminho + "/src");        
        
        if (!diretorio.exists()){
            return caminho + "/../";
        }else 
            return caminho + "/";  
    }
}

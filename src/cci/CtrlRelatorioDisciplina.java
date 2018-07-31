package cci;

import cdp.Aula;
import cdp.Disciplina;
import cdp.Turma;
import cih.relatorio.JDTipoRelatorio;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRRuntimeException;

public class CtrlRelatorioDisciplina extends CtrlGenerica{
    
    private CtrlPrincipal ctrlPrincipal;
    private String pastaRaiz = "Disciplinas";
    
    public CtrlRelatorioDisciplina(CtrlPrincipal ctrl){
        this.ctrlPrincipal = ctrl;
    }
    
    public void exibirTelaAnoSemestre(JDTipoRelatorio janela){

        JSpinner spnAno = new JSpinner();
        spnAno.setFont(new java.awt.Font("DialogInput", 0, 16));
        spnAno.setModel(new javax.swing.SpinnerNumberModel(2018, 2000, null, 1));
        spnAno.setEditor(new JSpinner.NumberEditor(spnAno, "####"));

        JSpinner spnSemestre = new JSpinner();
        spnSemestre.setFont(new java.awt.Font("DialogInput", 0, 16));
        spnSemestre.setModel(new javax.swing.SpinnerNumberModel(1, 1, 2, 1));

        JLabel rotulo = new JLabel("Ano/Semestre:\n");
        rotulo.setFont(new Font("DialogInput", 0, 14));

        JPanel entUsuario = new JPanel();
        entUsuario.add(rotulo);
        entUsuario.add(spnAno);
        entUsuario.add(spnSemestre);

        String titulo = "Deseja gerar os relatórios de disciplinas?";
        int resposta = CtrlMensagem.exibirMensagemInputDados(janela, entUsuario, titulo);
        int ano = (int) spnAno.getValue();
        int semestre = (int) spnSemestre.getValue();
        
        identificarResposta(resposta, ano, semestre);
    }
    
    public void identificarResposta(int resposta, int ano, int semestre){
        
        if(resposta == 0){
            String mensagem = "Este processo pode demorar um pouco, pressione o botão 'OK' e aguarde.\nA pasta com seus relatórios será aberta em seguida.";
            CtrlMensagem.exibirMensagemRetornoDados(null, mensagem, "Atenção");
            ctrlPrincipal.getGtPrincipal().getGtRelatorio().atualizarAulasAnoSemestre(ano, semestre);
            List turmas = ctrlPrincipal.getCtrlTurma().listar();
            List turmasAtivas = ctrlPrincipal.getGtPrincipal().getGtTurma().filtrarTurmasAtivas(turmas, ano, semestre);
            montarMensagemRelatorioDisciplinas(ano, semestre, turmasAtivas);
            abrirPastaDisciplinas(ano, semestre);
        }
    }
    
    public void montarMensagemRelatorioDisciplinas(int ano, int semestre, List<Turma> turmasAtivas){
        
        String mensagem = "";
        
        for(Turma turma : turmasAtivas){

            mensagem = "\n\t\t\t\t\t\t" + turma.getNome() + " - " + ano + "/" + semestre + "\n\n\n";
            
            List aulas = ctrlPrincipal.getGtPrincipal().getGtAula().filtrarAulasTurmaLista(turma.getId());
            mensagem = mensagem + obterSiglaDisciplina(aulas) + "\n";
            gerarRelatorioDisciplinas(mensagem, ano, semestre, turma);
        }
    }
    
    public void gerarRelatorioDisciplinas(String mensagem, int ano, int semestre, Turma turma){
        
        String diretorio = ctrlPrincipal.getCtrlRelatorio().obterDiretorioArquivamento(pastaRaiz, ano, semestre);
        String nomeExport = diretorio + turma.getNome() + "-Relatório de Disciplinas-" + ano + "-" + semestre + ".pdf";
        
        List relatorio = new ArrayList();
        relatorio.add(new Aula());

        String nomeRelatorio = "relatorioDisciplinas";
        Map parametros =  new HashMap();
        parametros.put("mensagem", mensagem);
        
        try {
            ctrlPrincipal.getCtrlRelatorio().gerarRelatorio(relatorio, parametros, nomeRelatorio, nomeExport);
        } catch (JRException | FileNotFoundException | JRRuntimeException ex) {
            CtrlMensagem.exibirMensagemErro(null, ex.getMessage());
        }
    }
    
    public String obterSiglaDisciplina(List<Aula> aulas){
        
        String mensagem = "";
        List<Disciplina> disciplinas = new ArrayList<>();
        
        for(Aula aula : aulas){
            if(!disciplinas.contains(aula.getAlocacao().getDisciplina())){
                mensagem = mensagem + "\t" + aula.getAlocacao().getDisciplina().getSigla() + " - " + aula.getAlocacao().getDisciplina().getNome() + ".\n";
                disciplinas.add(aula.getAlocacao().getDisciplina());
            }
        }
        
        return mensagem;
    }
    
    public void abrirPastaDisciplinas(int ano, int semestre){
        
        String diretorio = ctrlPrincipal.getCtrlRelatorio().obterDiretorioArquivamento(pastaRaiz, ano, semestre);
        try {  
            Runtime.getRuntime().exec("explorer.exe " + diretorio.replace("/", "\\"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            CtrlMensagem.exibirMensagemErro(null, "Não foi possível encontrar a pasta especificada.");
        }
    }
        
}

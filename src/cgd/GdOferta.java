package cgd;

import cdp.Aula;
import cdp.Oferta;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;

public class GdOferta extends GdGenerico{
    
    private GdPrincipal gdPrincipal;
    
    public GdOferta(GdPrincipal gdPrincipal){
        this.gdPrincipal = gdPrincipal;
    }
    
    public Oferta filtrarOferta(int ano, int semestre, int idTurma) {
        Criteria crit = criarSessao().createCriteria(Oferta.class);
        sessao.beginTransaction();
        crit.add( Restrictions.eq("ano", ano));
        crit.add( Restrictions.eq("semestre", semestre));
        crit.add( Restrictions.eq("turma.id", idTurma));
        crit.setMaxResults(1);
        Oferta oferta = (Oferta) crit.uniqueResult();
        sessao.getTransaction().commit();
        sessao.close();
        return oferta;
    }
    
    public void cadastrarOferta(Oferta oferta, ArrayList<ArrayList> matriz){
        
        try {
            sessao = criarSessao();
            sessao.beginTransaction();
            
            sessao.save(oferta);
            
            int linhas = matriz.size();
            int colunas = matriz.get(0).size();
            Aula aula;
            
            for(int linha = 0; linha < linhas; linha++){
                for(int coluna = 0; coluna < colunas; coluna++){
                    aula = (Aula) matriz.get(linha).get(coluna);
                    aula.setOferta(oferta);
                    if(aula != null)
                        sessao.save(aula);  
                } 
            }

            sessao.getTransaction().commit();
            sessao.close();

        } catch (HibernateException e) {
            sessao.getTransaction().rollback();
            sessao.close();
            throw e;
        } 
        
    }
    
    public void cadastrarAulas(ArrayList<ArrayList> matriz){
        
        try {
            sessao = criarSessao();
            sessao.beginTransaction();
            
            int linhas = matriz.size();
            int colunas = matriz.get(0).size();
            Aula aula;
            
            for(int linha = 0; linha < linhas; linha++){
                for(int coluna = 0; coluna < colunas; coluna++){
                    aula = (Aula) matriz.get(linha).get(coluna);
                    if(aula != null)
                        sessao.saveOrUpdate(aula);  
                } 
            }
            
            sessao.getTransaction().commit();
            sessao.close();

        } catch (HibernateException e) {
            sessao.getTransaction().rollback();
            sessao.close();
            throw e;
        } 
        
    }
}

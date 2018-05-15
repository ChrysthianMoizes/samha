package cgd;

import cdp.Aula;
import cdp.Oferta;
import java.util.List;
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
    
    public void cadastrarAulasOferta(Oferta oferta, Aula[][] matriz){
        
        try {
            sessao = criarSessao();
            sessao.beginTransaction();
            
            sessao.save(oferta);
            
            int linhas = matriz.length;
            int colunas = matriz[0].length;
            
            Aula aula = null;
            
            for(int linha = 0; linha < linhas; linha++){
                for(int coluna = 0; coluna < colunas; coluna++){
                    aula = matriz[linha][coluna];
                    
                    if(aula != null){
                        aula.setOferta(oferta);
                        sessao.save(aula);  
                    }      
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
    
    public void atualizarAulasOferta(Aula[][] matriz, List listaAulas){
        
        try {
            sessao = criarSessao();
            sessao.beginTransaction();
            
            Aula aulaRemovida;
            for(int i = 0; i < listaAulas.size(); i++){
                aulaRemovida = (Aula) listaAulas.get(i);
                sessao.delete(aulaRemovida);
            }
            
            int linhas = matriz.length;
            int colunas = matriz[0].length;
            Aula aula;
                     
            for(int linha = 0; linha < linhas; linha++){
                for(int coluna = 0; coluna < colunas; coluna++){
                    aula = (Aula) matriz[linha][coluna];
                    if(aula != null){
                        aula.setId(0);
                        sessao.save(aula);   
                    }
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

package cgd;

import cdp.Disciplina;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class GdDisciplina extends GdGenerico{
    
    private GdPrincipal gdPrincipal;
    
    public GdDisciplina(GdPrincipal gdPrincipal){
        this.gdPrincipal = gdPrincipal;
    }
    
    public List filtrarPorTipo(String tipo, int id) {
        Criteria crit = criarSessao().createCriteria(Disciplina.class);
        sessao.beginTransaction();
        crit.add( Restrictions.eq("matriz.id", id));
        crit.add( Restrictions.eq("tipo", tipo));
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List lista = crit.list();
        sessao.getTransaction().commit();
        sessao.close();
        return lista;
    }
    
    public List filtrarPorMatriz(String coluna, int texto) {
        Criteria crit = criarSessao().createCriteria(Disciplina.class);
        sessao.beginTransaction();
        crit.add( Restrictions.eq(coluna, texto) );
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List lista = crit.list();
        sessao.getTransaction().commit();
        sessao.close();
        return lista;
    }
    
    public List filtrarPorMatrizPeriodo(int matriz, int periodo){
        Criteria crit = criarSessao().createCriteria(Disciplina.class);
        sessao.beginTransaction();
        crit.add( Restrictions.eq("matriz.id", matriz));
        crit.add( Restrictions.eq("periodo", periodo));
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List lista = crit.list();
        sessao.getTransaction().commit();
        sessao.close();
        return lista;
    }
    
}

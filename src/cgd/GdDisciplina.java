package cgd;

import cdp.Disciplina;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

public class GdDisciplina extends GdGenerico{
    
    public List buscar(String coluna, String texto) {
        Criteria crit = criarSessao().createCriteria(Disciplina.class);
        sessao.beginTransaction();
        crit.add( Restrictions.like(coluna, texto, MatchMode.ANYWHERE) );
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List lista = crit.list();
        sessao.getTransaction().commit();
        sessao.close();
        return lista;
    }
    
    public List filtrar(String coluna, int texto) {
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

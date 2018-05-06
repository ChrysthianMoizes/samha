package cgd;

import cdp.Turma;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

public class GdTurma extends GdGenerico{
    
    private GdPrincipal gdPrincipal;
    
    public GdTurma(GdPrincipal gdPrincipal){
        this.gdPrincipal = gdPrincipal;
    }
    
    public List filtrarPorCurso(int id) {
        Criteria crit = criarSessao().createCriteria(Turma.class);
        sessao.beginTransaction();
        crit.createAlias("matriz", "m");
        crit.createAlias("m.curso", "c");
        crit.add( Restrictions.eq("c.id", id) );
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List lista = crit.list();
        sessao.getTransaction().commit();
        sessao.close();
        return lista;
    }
    
    public List buscar(String coluna, String texto) {
        Criteria crit = criarSessao().createCriteria(Turma.class);
        sessao.beginTransaction();
        crit.add( Restrictions.like(coluna, texto, MatchMode.ANYWHERE) );
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List lista = crit.list();
        sessao.getTransaction().commit();
        sessao.close();
        return lista;
    }
}

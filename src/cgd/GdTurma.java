package cgd;

import cdp.MatrizCurricular;
import cdp.Turma;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

public class GdTurma extends GdGenerico{
    
    public List filtrarPorMatriz(String coluna, int id) {
        Criteria crit = criarSessao().createCriteria(Turma.class);
        crit.add( Restrictions.eq(coluna, id) );
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List lista = crit.list();
        sessao.close();
        return lista;
    }
    
    public List filtrarPorCurso(int id) {
        Criteria crit = criarSessao().createCriteria(Turma.class);
            crit.createAlias("matriz", "m");
            crit.createCriteria("matriz_curricular", JoinType.INNER_JOIN);
            crit.createAlias("curso", "c");
        crit.add( Restrictions.eq("matriz_curricular_id", "m.id") );
        crit.add( Restrictions.eq("m.curso_id", id) );
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List lista = crit.list();
        sessao.close();
        return lista;
    }
    
    public List buscar(String coluna, String texto) {
        Criteria crit = criarSessao().createCriteria(Turma.class);
        crit.add( Restrictions.like(coluna, texto, MatchMode.ANYWHERE) );
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List lista = crit.list();
        sessao.close();
        return lista;
    }
}

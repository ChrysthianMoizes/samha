package cgd;

import cdp.Turma;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class GdTurma extends GdGenerico{
    
    public List filtrarPorMatriz(String coluna, int texto) {
        Criteria crit = criarSessao().createCriteria(Turma.class);
        crit.add( Restrictions.eq(coluna, texto) );
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List lista = crit.list();
        sessao.close();
        return lista;
    }
    
    public List buscar(String coluna, String texto) {
        Criteria crit = criarSessao().createCriteria(Turma.class);
        crit.add( Restrictions.like(coluna, "%"+texto+"%") );
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List lista = crit.list();
        sessao.close();
        return lista;
    }
}

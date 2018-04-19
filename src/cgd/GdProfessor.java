package cgd;

import cdp.Professor;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class GdProfessor extends GdGenerico{
    
    public List buscar(String coluna, String texto) {
        Criteria crit = criarSessao().createCriteria(Professor.class);
        crit.add( Restrictions.like(coluna, "%"+texto+"%") );
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List lista = crit.list();
        sessao.close();
        return lista;
    }
    
    public List filtrarPorCoordenadoria(String coluna, int id) {
        Criteria crit = criarSessao().createCriteria(Professor.class);
        crit.add( Restrictions.eq(coluna, id) );
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List lista = crit.list();
        sessao.close();
        return lista;
    }
}

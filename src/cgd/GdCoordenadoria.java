package cgd;

import cdp.Coordenadoria;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class GdCoordenadoria extends GdGenerico{
    
    public List filtrarCoordenadoresNulos(String coluna, String texto) {
        Criteria crit = criarSessao().createCriteria(Coordenadoria.class);
        coluna = coluna.toLowerCase();
        crit.add( Restrictions.like(coluna, "%"+texto+"%") );
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List lista = crit.list();
        sessao.close();
        return lista;
    }
    
    public List buscar(String coluna, String texto) {
        Criteria crit = criarSessao().createCriteria(Coordenadoria.class);
        crit.add( Restrictions.like(coluna, "%"+texto+"%") );
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List lista = crit.list();
        sessao.close();
        return lista;
    }
}

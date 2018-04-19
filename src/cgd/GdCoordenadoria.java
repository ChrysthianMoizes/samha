package cgd;

import cdp.Coordenadoria;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

public class GdCoordenadoria extends GdGenerico{
    
    public List filtrarCoordenadoriasEixo(String coluna, int id) {
        Criteria crit = criarSessao().createCriteria(Coordenadoria.class);
        coluna = coluna.toLowerCase();
        crit.add( Restrictions.eq(coluna, id) );
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List lista = crit.list();
        sessao.close();
        return lista;
    }
    
    public List buscar(String coluna, String texto) {
        Criteria crit = criarSessao().createCriteria(Coordenadoria.class);
        crit.add( Restrictions.like(coluna, texto, MatchMode.ANYWHERE) );
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List lista = crit.list();
        sessao.close();
        return lista;
    }
    
    public Coordenadoria filtrarCoordenadoriaUnica(String colunaFiltro, int id) {
        Criteria crit = criarSessao().createCriteria(Coordenadoria.class);
        colunaFiltro = colunaFiltro.toLowerCase();
        crit.add( Restrictions.eq(colunaFiltro, id));
        crit.setMaxResults(1);
        Coordenadoria coordenadoria = (Coordenadoria) crit.uniqueResult();
        sessao.close();
        return coordenadoria;
    }
}

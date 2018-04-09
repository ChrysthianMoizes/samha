package cgd;

import cdp.Disciplina;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class GdDisciplina extends GdGenerico{
    
    public List buscar(String coluna, String texto) {
        Criteria crit = criarSessao().createCriteria(Disciplina.class);
        crit.add( Restrictions.like(coluna, "%"+texto+"%") );
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List lista = crit.list();
        sessao.close();
        return lista;
    }
    
    public List filtrarPorCurso(String coluna, String texto) {
        Criteria crit = criarSessao().createCriteria(Disciplina.class);
        crit.add( Restrictions.eq(coluna, texto) );
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List lista = crit.list();
        sessao.close();
        return lista;
    }
    
}

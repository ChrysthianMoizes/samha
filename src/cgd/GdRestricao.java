package cgd;

import cdp.RestricaoProfessor;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class GdRestricao extends GdGenerico{
    
    public List filtrarPorProfessor(String coluna, int texto) {
        Criteria crit = criarSessao().createCriteria(RestricaoProfessor.class);
        crit.add( Restrictions.eq(coluna, texto) );
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List lista = crit.list();
        sessao.close();
        return lista;
    }
}

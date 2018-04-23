package cgd;

import cdp.MatrizCurricular;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class GdMatriz extends GdGenerico{
    
    public List filtrarMatrizCurso(String coluna, int id) {
        Criteria crit = criarSessao().createCriteria(MatrizCurricular.class);
        sessao.beginTransaction();
        coluna = coluna.toLowerCase();
        crit.add( Restrictions.eq(coluna, id) );
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List lista = crit.list();
        sessao.getTransaction().commit();
        sessao.close();
        return lista;
    }
    
}

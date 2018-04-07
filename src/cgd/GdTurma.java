package cgd;

import cdp.Turma;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class GdTurma extends GdGenerico{
    
    public List filtrarPorCurso(String coluna, int texto) {
        Criteria crit = criarSessao().createCriteria(Turma.class);
        crit.add( Restrictions.eq(coluna, texto) );
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List lista = crit.list();
        sessao.close();
        return lista;
    }
    
}
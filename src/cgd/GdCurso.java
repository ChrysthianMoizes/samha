package cgd;

import cdp.Curso;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class GdCurso extends GdGenerico{
    
    public List buscar(String coluna, String texto) {
        Criteria crit = criarSessao().createCriteria(Curso.class);
        crit.add( Restrictions.like(coluna, "%"+texto+"%") );
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List lista = crit.list();
        sessao.close();
        return lista;
    }
    
    public Curso filtrarCursoUnico(String colunaFiltro, int id) {
        Criteria crit = criarSessao().createCriteria(Curso.class);
        colunaFiltro = colunaFiltro.toLowerCase();
        crit.add( Restrictions.eq(colunaFiltro, id));
        crit.setMaxResults(1);
        Curso curso = (Curso) crit.uniqueResult();
        sessao.close();
        return curso;
    }
}

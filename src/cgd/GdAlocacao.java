package cgd;

import cdp.Alocacao;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class GdAlocacao extends GdGenerico{
    
    public List filtrarPorAnoSemestre(int ano, int semestre){
        Criteria crit = criarSessao().createCriteria(Alocacao.class);
        sessao.beginTransaction();
        crit.add( Restrictions.eq("ano", ano));
        crit.add( Restrictions.eq("semestre", semestre));
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List lista = crit.list();
        sessao.getTransaction().commit();
        sessao.close();
        return lista;
    }
    
    public Alocacao filtrarUltimaAlocacao() {
        Criteria crit = criarSessao().createCriteria(Alocacao.class)
                .setProjection(Projections.max("ano"))
                .setProjection(Projections.max("semestre"));
        crit.setMaxResults(1);
        Alocacao alocacao = (Alocacao) crit.uniqueResult();
        sessao.close();
        return alocacao;
    }
    
}

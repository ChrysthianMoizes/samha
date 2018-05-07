package cgd;

import cdp.RestricaoProfessor;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;

public class GdRestricao extends GdGenerico{
    
    private GdPrincipal gdPrincipal;
    
    public GdRestricao(GdPrincipal gdPrincipal){
        this.gdPrincipal = gdPrincipal;
    }
    
    public List filtrarPorProfessor(int id) {
        Criteria crit = criarSessao().createCriteria(RestricaoProfessor.class);
        sessao.beginTransaction();
        crit.add( Restrictions.eq("professor.id", id) );
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List lista = crit.list();
        sessao.getTransaction().commit();
        sessao.close();
        return lista;
    }
    
    public List identificarConflitoRestricao(int idProfessor, String dia, String turno) {
        Criteria crit = criarSessao().createCriteria(RestricaoProfessor.class);
        sessao.beginTransaction();
        crit.add( Restrictions.eq("professor.id", idProfessor) );
        crit.add( Restrictions.eq("dia", dia) );
        crit.add( Restrictions.eq("turno", turno) );
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List lista = crit.list();
        sessao.getTransaction().commit();
        sessao.close();
        return lista;
    }
}

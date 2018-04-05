package cgd;

import cdp.RestricaoProfessor;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;

public class GdRestricao extends GdGenerico{
    
    public List filtrarPorProfessor(String coluna, int texto) {
        Criteria crit = criarSessao().createCriteria(RestricaoProfessor.class);
        crit.add( Restrictions.eq(coluna, texto) );
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List lista = crit.list();
        sessao.close();
        return lista;
    }
    
    public void excluirRestricoes(String coluna, int id){
        
        List lista = filtrarPorProfessor(coluna, id);

        try {
            sessao = criarSessao();
            sessao.beginTransaction();
            RestricaoProfessor restricao;
            for (int i = 0; i < lista.size(); i++) {
                restricao = (RestricaoProfessor) lista.get(i);
                sessao.delete(restricao);
            }
            sessao.getTransaction().commit();
            sessao.close();

        } catch (ConstraintViolationException ce) {
            sessao.getTransaction().rollback();
            sessao.close();

        } catch (HibernateException he) {
            sessao.getTransaction().rollback();
            sessao.close();
            throw he;
        }
    }
}

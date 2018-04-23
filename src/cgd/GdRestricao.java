package cgd;

import cdp.RestricaoProfessor;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class GdRestricao extends GdGenerico{
    
    public List filtrarPorProfessor(String coluna, int texto) {
        Criteria crit = criarSessao().createCriteria(RestricaoProfessor.class);
        sessao.beginTransaction();
        crit.add( Restrictions.eq(coluna, texto) );
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        sessao.beginTransaction();
        List lista = crit.list();
        sessao.getTransaction().commit();
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
            sessao.flush();
            sessao.getTransaction().commit();
            sessao.close();

        } catch (Exception e) {
            sessao.getTransaction().rollback();
            sessao.close();
            throw e;
        } 
    }
}

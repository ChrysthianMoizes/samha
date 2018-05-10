package cgd;

import cdp.Aula;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class GdAula extends GdGenerico{
    
    private GdPrincipal gdPrincipal;

    public GdAula(GdPrincipal gdPrincipal) {
        this.gdPrincipal = gdPrincipal;
    }
    
    public List identificarConflitoAula(int ano, int semestre, int idProfessor, int numero, String dia, String turno) {
        Criteria crit = criarSessao().createCriteria(Aula.class);
        crit.createAlias("alocacao", "a");
        crit.createAlias("a.professor1", "p");
        crit.add( Restrictions.eq("a.ano", ano) );
        crit.add( Restrictions.eq("a.semestre", semestre) );
        crit.add( Restrictions.eq("p.id", idProfessor) );
        crit.add( Restrictions.eq("numero", numero) );
        crit.add( Restrictions.eq("dia", dia) );
        crit.add( Restrictions.eq("turno", turno) );
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List lista = crit.list();
        sessao.close();
        return lista;
    }
    
    public List filtrarAulasTurno(String turno, int idOferta) {
        Criteria crit = criarSessao().createCriteria(Aula.class);
        sessao.beginTransaction();
        crit.createAlias("oferta", "o");
        crit.add( Restrictions.eq("turno", turno));
        crit.add( Restrictions.eq("o.id", idOferta));
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List lista = crit.list();
        sessao.getTransaction().commit();
        sessao.close();
        return lista;
    }  
}
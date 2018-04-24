package cgd;

import cdp.CoordenadorAcademico;
import cdp.CoordenadorCurso;
import cdp.CoordenadorPedagogico;
import cdp.Coordenadoria;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

public class GdCoordenador extends GdGenerico{
    
    private GdCoordenadoria gdCoordenadoria;

    public GdCoordenador() {
        gdCoordenadoria = new GdCoordenadoria();
    }
        
    public List buscarCoordenadoresCurso(String coluna, String texto) {
        Criteria crit = criarSessao().createCriteria(CoordenadorCurso.class);
        sessao.beginTransaction();
        crit.createAlias("professor", "p");
        crit.add( Restrictions.like("p." + coluna, texto, MatchMode.ANYWHERE));
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List lista = crit.list();
        sessao.getTransaction().commit();
        sessao.close();
        return lista;
    }
    
    public List buscarCoordenadoresAcademicos(String coluna, String texto) {
        Criteria crit = criarSessao().createCriteria(CoordenadorAcademico.class);
        sessao.beginTransaction();
        crit.createAlias("servidor", "s");
        crit.add( Restrictions.like("s." + coluna, texto, MatchMode.ANYWHERE));
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List lista = crit.list();
        sessao.getTransaction().commit();
        sessao.close();
        return lista;
    }
    
    public List buscarCoordenadoresPedagogicos(String coluna, String texto) {
        Criteria crit = criarSessao().createCriteria(CoordenadorPedagogico.class);
        sessao.beginTransaction();
        crit.createAlias("servidor", "s");
        crit.add( Restrictions.like("s." + coluna, texto, MatchMode.ANYWHERE));
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List lista = crit.list();
        sessao.getTransaction().commit();
        sessao.close();
        return lista;
    }
    
    public void excluirCoordenadorCurso(CoordenadorCurso coordenador){
       
        try {
            sessao = criarSessao();
            sessao.beginTransaction();
            
            Coordenadoria coordenadoria = coordenador.getProfessor().getCoordenadoria();
            
            coordenadoria.setCoordenador(null);
            sessao.update(coordenadoria);
            sessao.delete(coordenador);
            
            sessao.getTransaction().commit();        
            sessao.close();

        } catch (Exception e) {
            sessao.getTransaction().rollback();
            sessao.close();
            throw e;
        }
    }
}

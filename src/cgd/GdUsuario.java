package cgd;

import cdp.CoordenadorAcademico;
import cdp.CoordenadorCurso;
import cdp.Coordenadoria;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

public class GdUsuario extends GdGenerico{
    
    private GdCoordenadoria gdCoordenadoria;

    public GdUsuario() {
        gdCoordenadoria = new GdCoordenadoria();
    }
    
    public List buscarCoordenadoresCurso(String coluna, String texto) {
        Criteria crit = criarSessao().createCriteria(CoordenadorCurso.class);
        crit.createAlias("professor", "p");
        crit.add( Restrictions.like("p." + coluna, texto, MatchMode.ANYWHERE));
        //crit.add( Restrictions.like("nome", texto, MatchMode.ANYWHERE) );
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List lista = crit.list();
        sessao.close();
        return lista;
    }
    
    public List buscarCoordenadoresAcademico(String coluna, String texto) {
        Criteria crit = criarSessao().createCriteria(CoordenadorAcademico.class);
        crit.createAlias("servidor", "s");
        crit.add( Restrictions.like("s." + coluna, texto, MatchMode.ANYWHERE));
        //crit.add( Restrictions.like("nome", texto, MatchMode.ANYWHERE) );
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List lista = crit.list();
        sessao.close();
        return lista;
    }
    
    public List filtrarPorTipo(String coluna, String texto) {
        Criteria crit = criarSessao().createCriteria(CoordenadorCurso.class);
        crit.add( Restrictions.eq(coluna, texto) );
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List lista = crit.list();
        sessao.close();
        return lista;
    }
    
    public void excluirCoordenadorCurso(CoordenadorCurso coordenador){
       
        try {
            sessao = criarSessao();
            sessao.beginTransaction();
            
            Coordenadoria coordenadoria = gdCoordenadoria.filtrarCoordenadoriaUnica("coordenador.id", coordenador.getId());
            
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

package cgd;

import cdp.Coordenador;
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
    
    public List buscar(String coluna, String texto) {
        Criteria crit = criarSessao().createCriteria(Coordenador.class);
        crit.add( Restrictions.like(coluna, texto, MatchMode.ANYWHERE) );
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List lista = crit.list();
        sessao.close();
        return lista;
    }
    
    public List filtrarPorTipo(String coluna, String texto) {
        Criteria crit = criarSessao().createCriteria(Coordenador.class);
        crit.add( Restrictions.eq(coluna, texto) );
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List lista = crit.list();
        sessao.close();
        return lista;
    }
    
    public void excluirCoordenador(Coordenador coordenador){
       
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

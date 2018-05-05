package cgd;

import cdp.CoordenadorAcademico;
import cdp.CoordenadorCurso;
import cdp.CoordenadorPedagogico;
import cdp.Curso;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

public class GdCoordenador extends GdGenerico{
    
    private GdCurso gdCurso;

    public GdCoordenador() {
        gdCurso = new GdCurso();
    }
    
    public CoordenadorCurso identificarCoordenadorCurso(int id){
        Criteria crit = criarSessao().createCriteria(CoordenadorCurso.class);
        crit.createAlias("professor", "p");
        crit.add(Restrictions.eq("p.id", id));
        crit.setMaxResults(1);
        CoordenadorCurso coordenador = (CoordenadorCurso) crit.uniqueResult();
        sessao.close();
        return coordenador;
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
    
    public void cadastrarCoordenadorCurso(Curso curso, CoordenadorCurso coordenador){
        
        try {
            sessao = criarSessao();
            sessao.beginTransaction();

            sessao.save(coordenador);
            curso.setCoordenador(coordenador);
            sessao.update(curso);
            
            sessao.getTransaction().commit();        
            sessao.close();

        } catch (Exception e) {
            sessao.getTransaction().rollback();
            sessao.close();
            throw e;
        }
        
    }
    
    public void alterarCoordenadorCurso(Curso curso, CoordenadorCurso coordenador){
        
        try {
            sessao = criarSessao();
            sessao.beginTransaction();
            
            sessao.update(coordenador);
            curso.setCoordenador(coordenador);
            sessao.update(curso);

            sessao.getTransaction().commit();        
            sessao.close();

        } catch (Exception e) {
            sessao.getTransaction().rollback();
            sessao.close();
            throw e;
        }
        
    }
    
    public void excluirCoordenadorCurso(CoordenadorCurso coordenador){
       
        try {
            sessao = criarSessao();
            sessao.beginTransaction();
            
            Curso curso = gdCurso.filtrarCursoUnico("coordenador.id", coordenador.getId());
            
            curso.setCoordenador(null);
            sessao.update(curso);
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

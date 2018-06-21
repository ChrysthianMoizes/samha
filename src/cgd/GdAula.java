package cgd;

import cdp.Aula;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;

public class GdAula extends GdGenerico{
    
    private GdPrincipal gdPrincipal;

    public GdAula(GdPrincipal gdPrincipal) {
        this.gdPrincipal = gdPrincipal;
    }
    
    public void salvarAulasOferta(Aula[][] matriz, List listaAulasRemovidas){
        
        try {
            sessao = criarSessao();
            sessao.beginTransaction();
            
            Aula aulaRemovida;
            for(int i = 0; i < listaAulasRemovidas.size(); i++){
                aulaRemovida = (Aula) listaAulasRemovidas.get(i);
                sessao.delete(aulaRemovida);
            }
            
            listaAulasRemovidas.clear();
            
            int linhas = matriz.length;
            int colunas = matriz[0].length;
            
            for(int linha = 0; linha < linhas; linha++){
                for(int coluna = 0; coluna < colunas; coluna++){
                    if(matriz[linha][coluna] != null)
                        sessao.merge(matriz[linha][coluna]);  
                } 
            }
            
            sessao.getTransaction().commit();
            sessao.close();

        } catch (HibernateException e) {
            sessao.getTransaction().rollback();
            sessao.close();
            throw e;
        }     
    }
    
    public List filtrarAulasProfessorNumeroDiaAnoSemestre(int ano, int semestre, int idProfessor, int numero, int dia) {
        Criteria crit = criarSessao().createCriteria(Aula.class);
        crit.createAlias("alocacao", "a");
        crit.createAlias("a.professor1", "p");
        crit.add( Restrictions.eq("a.ano", ano) );
        crit.add( Restrictions.eq("a.semestre", semestre) );
        crit.add( Restrictions.eq("p.id", idProfessor) );
        crit.add( Restrictions.eq("numero", numero) );
        crit.add( Restrictions.eq("dia", dia) );
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List lista = crit.list();
        sessao.close();
        return lista;
    }
    
    public List filtrarAulasOferta(int idOferta) {
        Criteria crit = criarSessao().createCriteria(Aula.class);
        sessao.beginTransaction();
        crit.createAlias("oferta", "o");
        crit.add( Restrictions.eq("o.id", idOferta));
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List lista = crit.list();
        sessao.getTransaction().commit();
        sessao.close();
        return lista;
    }
    
    public List filtrarAulasProfessor1DiaAnoSemestre(int dia, int idProfessor, int ano, int semestre) {
        Criteria crit = criarSessao().createCriteria(Aula.class);
        sessao.beginTransaction();
        crit.createAlias("alocacao", "a");
        crit.createAlias("a.professor1", "p1");
        crit.add( Restrictions.eq("p1.id", idProfessor));
        crit.add( Restrictions.eq("a.ano", ano));
        crit.add( Restrictions.eq("a.semestre", semestre));
        crit.add( Restrictions.eq("dia", dia));
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List lista = crit.list();
        sessao.getTransaction().commit();
        sessao.close();
        return lista;
    }
    
    public List filtrarAulasProfessor2DiaAnoSemestre(int dia, int idProfessor, int ano      , int semestre) {
        Criteria crit = criarSessao().createCriteria(Aula.class);
        sessao.beginTransaction();
        crit.createAlias("alocacao", "a");
        crit.createAlias("a.professor2", "p2");
        crit.add( Restrictions.eq("p2.id", idProfessor));
        crit.add( Restrictions.eq("a.ano", ano));
        crit.add( Restrictions.eq("a.semestre", semestre));
        crit.add( Restrictions.eq("dia", dia));
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List lista = crit.list();
        sessao.getTransaction().commit();
        sessao.close();
        return lista;
    }
    
    public List filtrarAulasProfessor1AnoSemestre(int idProfessor, int ano, int semestre) {
        Criteria crit = criarSessao().createCriteria(Aula.class);
        sessao.beginTransaction();
        crit.createAlias("alocacao", "a");
        crit.createAlias("a.professor1", "p1");
        crit.add( Restrictions.eq("p1.id", idProfessor));
        crit.add( Restrictions.eq("a.ano", ano));
        crit.add( Restrictions.eq("a.semestre", semestre));
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List lista = crit.list();
        sessao.getTransaction().commit();
        sessao.close();
        return lista;
    }
    
    public List filtrarAulasTurmaAnoSemestre(int idTurma, int ano, int semestre) {
        Criteria crit = criarSessao().createCriteria(Aula.class);
        sessao.beginTransaction();
        crit.createAlias("oferta", "o");
        crit.createAlias("o.turma", "t");
        crit.createAlias("alocacao", "a");
        crit.add( Restrictions.eq("a.ano", ano));
        crit.add( Restrictions.eq("a.semestre", semestre));
        crit.add( Restrictions.eq("t.id", idTurma));
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List lista = crit.list();
        sessao.getTransaction().commit();
        sessao.close();
        return lista;
    }
    
    public List filtrarAulasTurmaDiaAnoSemestre(int idTurma, int ano, int semestre, int dia) {
        Criteria crit = criarSessao().createCriteria(Aula.class);
        sessao.beginTransaction();
        crit.createAlias("oferta", "o");
        crit.createAlias("o.turma", "t");
        crit.createAlias("alocacao", "a");
        crit.add( Restrictions.eq("a.ano", ano));
        crit.add( Restrictions.eq("a.semestre", semestre));
        crit.add( Restrictions.eq("t.id", idTurma));
        crit.add( Restrictions.eq("dia", dia));
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List lista = crit.list();
        sessao.getTransaction().commit();
        sessao.close();
        return lista;
    }
    
    public List filtrarAulasProfessor2AnoSemestre(int idProfessor, int ano, int semestre) {
        Criteria crit = criarSessao().createCriteria(Aula.class);
        sessao.beginTransaction();
        crit.createAlias("alocacao", "a");
        crit.createAlias("a.professor2", "p2");
        crit.add( Restrictions.eq("p2.id", idProfessor));
        crit.add( Restrictions.eq("a.ano", ano));
        crit.add( Restrictions.eq("a.semestre", semestre));
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List lista = crit.list();
        sessao.getTransaction().commit();
        sessao.close();
        return lista;
    }
}
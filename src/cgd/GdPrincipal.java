package cgd;

import cdp.Usuario;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class GdPrincipal extends GdGenerico{

    public GdPrincipal() {
    }
    
    public Usuario validarAcesso(String login, String senha){
        Criteria crit = criarSessao().createCriteria(Usuario.class);
        sessao.beginTransaction();
        crit.add(Restrictions.eq("login", login));
        crit.add(Restrictions.eq("senha", senha));
        crit.setMaxResults(1);
        Usuario usuario = (Usuario) crit.uniqueResult();
        sessao.getTransaction().commit();
        sessao.close();
        return usuario;   
    }
}

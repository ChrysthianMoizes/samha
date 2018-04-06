package cgd;

import cdp.Coordenador;
import cdp.Usuario;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class GdPrincipal extends GdGenerico{

    public GdPrincipal() {
    }
    
    public Usuario validarAcesso(String login, String senha){
        Criteria crit = criarSessao().createCriteria(Usuario.class);
        crit.add(Restrictions.eq("login", login));
        crit.add(Restrictions.eq("senha", senha));
        crit.setMaxResults(1);
        Usuario usuario = (Usuario) crit.uniqueResult();
        sessao.close();
        return usuario;   
    }
    
    public Coordenador identificarCoordenador(int id){
        Criteria crit = criarSessao().createCriteria(Coordenador.class);
        crit.add(Restrictions.eq("usuario.id", id));
        crit.setMaxResults(1);
        Coordenador coordenador = (Coordenador) crit.uniqueResult();
        sessao.close();
        return coordenador;   
    }
}

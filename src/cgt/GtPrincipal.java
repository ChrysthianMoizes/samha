package cgt;

import cdp.Coordenador;
import cdp.Usuario;
import cgd.GdPrincipal;

public class GtPrincipal {
    
    private GdPrincipal gdPrincipal;
    private Coordenador coordAtual;

    public GtPrincipal() {
        gdPrincipal = new GdPrincipal();
    }
    
    public int validarAcesso(String login, String senha) {

        Usuario usuario = gdPrincipal.validarAcesso(login, senha);
        
        if (usuario == null) {
            return Permissao.PERMISSAO_NEGADA;

        } else {
            if (usuario.getLogin().toLowerCase().equals("admin")) {
                return Permissao.PERMISSAO_ADMIN;
            } else {
                
                Coordenador coordenador = gdPrincipal.identificarCoordenador(usuario.getId());
                if (coordenador == null) {
                    return Permissao.PERMISSAO_NEGADA;
                } else {
                    setCoordAtual(coordenador);
                    
                    if (coordenador.getTipo().toLowerCase().equals("coordenador acadêmico")) {
                        return Permissao.PERMISSAO_ADMIN;
                    } else if (coordenador.getTipo().toLowerCase().equals("coordenador de curso")) {
                        return Permissao.PERMISSAO_COORD;
                    } else {
                        return Permissao.PERMISSAO_VIEW;
                    }
                }
            }
        }
    }

    public Coordenador getCoordAtual() {
        return coordAtual;
    }

    public void setCoordAtual(Coordenador coordAtual) {
        this.coordAtual = coordAtual;
    } 
}

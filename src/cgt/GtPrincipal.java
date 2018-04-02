package cgt;

import cdp.Coordenador;
import cdp.Usuario;
import cgd.GdPrincipal;

public class GtPrincipal {

    private GdPrincipal gdPrincipal;
    private Coordenador coordAtual;
    private int permissao;

    public GtPrincipal() {
        gdPrincipal = new GdPrincipal();
        coordAtual = null;
        permissao = Permissao.PERMISSAO_NEGADA;
    }

    public int validarAcesso(String login, String senha) throws Exception {
        
        validarCampos(login, senha);
        Usuario usuario = gdPrincipal.validarAcesso(login, senha);

        if (usuario == null) {
            throw  new SAMHAException(0);

        } else {

            Coordenador coordenador = gdPrincipal.identificarCoordenador(usuario.getId());
            
            if (coordenador == null) {
                throw  new SAMHAException(0);
            } else {
                setCoordAtual(coordenador);

                if (coordenador.getTipo().toLowerCase().equals("coordenador acadêmico")) {
                    setPermissao(Permissao.PERMISSAO_ADMIN);
                    return Permissao.PERMISSAO_ADMIN;
                } else if (coordenador.getTipo().toLowerCase().equals("coordenador de curso")) {
                    setPermissao(Permissao.PERMISSAO_COORD);
                    return Permissao.PERMISSAO_COORD;
                } else {
                    setPermissao(Permissao.PERMISSAO_VIEW);
                    return Permissao.PERMISSAO_VIEW;
                }
            }
        }
    }

    public void encerrarSessao() {
        setCoordAtual(null);
        setPermissao(Permissao.PERMISSAO_NEGADA);
    }
    
    public void validarCampos(String login, String senha) throws Exception {
            if(login.equals(""))
                throw new SAMHAException(3);
            if(senha.equals(""))
                throw new SAMHAException(4);
        }

    public Coordenador getCoordAtual() {
        return coordAtual;
    }

    public void setCoordAtual(Coordenador coordAtual) {
        this.coordAtual = coordAtual;
    }

    public int getPermissao() {
        return permissao;
    }

    public void setPermissao(int permissao) {
        this.permissao = permissao;
    }
}

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
        permissao = Constantes.PERMISSAO_NEGADA;
    }

    public int validarAcesso(String login, String senha) {

        try {
            validarCampos(login, senha);
            Usuario usuario = gdPrincipal.validarAcesso(login, senha);

            if (usuario == null) {
                return Constantes.PERMISSAO_NEGADA;
            } else {

                Coordenador coordenador = gdPrincipal.identificarCoordenador(usuario.getId());

                if (coordenador == null) {
                    return Constantes.PERMISSAO_NEGADA;
                } else {
                    setCoordAtual(coordenador);

                    if (coordenador.getTipo().toLowerCase().equals(Constantes.COORD_ACAD)) {
                        setPermissao(Constantes.PERMISSAO_ADMIN);
                        return Constantes.PERMISSAO_ADMIN;
                    } else if (coordenador.getTipo().toLowerCase().equals(Constantes.COORD_CURSO)) {
                        setPermissao(Constantes.PERMISSAO_COORD);
                        return Constantes.PERMISSAO_COORD;
                    } else {
                        setPermissao(Constantes.PERMISSAO_VIEW);
                        return Constantes.PERMISSAO_VIEW;
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return Constantes.PERMISSAO_NEGADA;
        }
    }

    public void encerrarSessao() {
        setCoordAtual(null);
        setPermissao(Constantes.PERMISSAO_NEGADA);
    }

    public void validarCampos(String login, String senha) throws Exception {
        if (login.equals("")) {
            throw new SAMHAException(3);
        }
        if (senha.equals("")) {
            throw new SAMHAException(4);
        }
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

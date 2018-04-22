package cgt;

import cdp.CoordenadorAcademico;
import cdp.CoordenadorCurso;
import cdp.Usuario;
import cgd.GdPrincipal;

public class GtPrincipal {

    private GdPrincipal gdPrincipal;
    private CoordenadorCurso coordAtual;
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

                if(usuario instanceof CoordenadorCurso){
                    setPermissao(Constantes.PERMISSAO_COORD);
                    return Constantes.PERMISSAO_COORD;
                }else if(usuario instanceof CoordenadorAcademico){
                    setPermissao(Constantes.PERMISSAO_ADMIN);
                    return Constantes.PERMISSAO_ADMIN;
                }else{
                    setPermissao(Constantes.PERMISSAO_VIEW);
                    return Constantes.PERMISSAO_VIEW;
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

    public CoordenadorCurso getCoordAtual() {
        return coordAtual;
    }

    public void setCoordAtual(CoordenadorCurso coordAtual) {
        this.coordAtual = coordAtual;
    }

    public int getPermissao() {
        return permissao;
    }

    public void setPermissao(int permissao) {
        this.permissao = permissao;
    }
}

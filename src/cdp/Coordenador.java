package cdp;

public class Coordenador extends Servidor{
    
    private String tipo;
    private Usuario usuario;
            

    public Coordenador() {
    }

    public Coordenador(String tipo, Usuario usuario, int id, String nome, String matricula) {
        super(id, nome, matricula);
        this.tipo = tipo;
        this.usuario = usuario;
    }

    public Coordenador(String tipo, Usuario usuario, String nome, String matricula) {
        super(nome, matricula);
        this.tipo = tipo;
        this.usuario = usuario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}

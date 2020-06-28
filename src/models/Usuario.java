package models;

public class Usuario extends Pessoa{
    
    private int idUsuario;
    private String usuario;
    private String senha;
    private int idPrincipal;
    private int userType;

    public Usuario(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    public Usuario() {
    }
    
    public void iniciarSessao(){
        
    }
    
    public void finalizarSessao(){
        
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getIdPrincipal() {
        return idPrincipal;
    }

    public void setIdPrincipal(int idPrincipal) {
        this.idPrincipal = idPrincipal;
    }

    public void setUserType(int usertype){
        this.userType = usertype;
    }
    
    public int getUserType() {
        return userType;
    }
}


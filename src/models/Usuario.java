package models;

public class Usuario extends Pessoa{
    
    private int idUsuario;
    private String usuario;
    private String senha;
    private byte userType;

    public Usuario(String usuario, String senha, byte userType, String nome){
        this.usuario = usuario;
        this.senha = senha;
        this.userType = userType;
        super.setNome(nome);
    }

    public Usuario(byte userType, String nome) {
        super.setNome(nome);
        this.userType = userType;
    }

    public Usuario() {}
    
        
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

    public byte getUserType() {
        return userType;
    }
}


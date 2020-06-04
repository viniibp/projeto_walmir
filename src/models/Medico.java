package models;

import dao.models.MedicoDAO;

public class Medico extends Usuario {

    private int crm;
    private String especialidade;
    
    public Medico(String user, String senha, byte userType, String nome, String espec){
        super(user, senha, userType, nome);
        this.especialidade = espec;
    }
    public Medico(byte userType, String nome, String espec){
        super(userType, nome);
        this.especialidade = espec;
    }

    public Medico() {
    }
    
    
    
    public Medico Logar(String usuario, String senha){
     return new MedicoDAO().getMedico(usuario, senha);
    }
    
    private void imprimirAtendimento(){
        
    }
    
    private void finalizarAtendimento(){
        
    }
    
    public int getCrm() {
        return crm;
    }

    public void setCrm(int crm) {
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}

package models;

public class Medico extends Usuario{

    private int crm;
    private String especialidade;
    
    public Medico() {}
    
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

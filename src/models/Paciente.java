package models;

import dao.models.PacienteDAO;
import java.util.ArrayList;
import java.util.List;

public class Paciente extends Pessoa{
    
    private int idPaciente;
    private String rg;
    private String logradouro;
    private int numCasa;
    private String numSUS;
    private String cidade;
    private String telefone;
    private String email;
    private String cep;

    public Paciente(String nome) {
        super.setNome(nome);
    }
    
    public Paciente(){}
    
    public List<Atendimento> historico(int idAtendimento){
        List<Atendimento> atendimentos = new PacienteDAO().historico(this.idPaciente, idAtendimento);
        if(atendimentos == null)return new ArrayList();
        return atendimentos; 
    }
    
    public int getIdPaciente(){
        return this.idPaciente;
    }
 
    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumCasa() {
        return numCasa;
    }

    public void setNumCasa(int numCasa) {
        this.numCasa = numCasa;
    }

    public String getNumSUS() {
        return numSUS;
    }

    public void setNumSUS(String numSUS) {
        this.numSUS = numSUS;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
   
}

package models;

import dao.models.RecepcionistaDAO;

public class Recepcionista extends Usuario{

    private int registro;
    
    public boolean cadastrarPaciente(Paciente pac){
        RecepcionistaDAO recdao = new RecepcionistaDAO();
        if(recdao.podeCadastrar(pac)){
            recdao.cadastrarPaciente(pac);
            return true;
        }
        else return false;
    }
    
    public Paciente buscarPaciente(String cpf){
        String primeiro, segundo, terceiro, fim;
        primeiro = cpf.substring(0, 3);
        segundo = cpf.substring(3,6);
        terceiro = cpf.substring(6,9);
        fim = cpf.substring(9,cpf.length());
        
        cpf = primeiro+"."+segundo+"."+terceiro+"-"+fim;
        Paciente pac = new RecepcionistaDAO().buscarPacienteCPF(cpf);
        return pac;
    }
    
    public void iniciarTriagem(Atendimento atend){
        new RecepcionistaDAO().iniciarTriagem(atend);
    }
    
    public int getRegistro() {
        return registro;
    }

    public void setRegistro(int registro) {
        this.registro = registro;
    }
}

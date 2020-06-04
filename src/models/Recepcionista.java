package models;

public class Recepcionista extends Usuario{

    private int registro;
    
    public Recepcionista(String user, String senha, byte userType, String nome, int reg){
        super(user, senha, userType, nome);
        this.registro = reg;
    }
    
    public void cadastrarPaciente(Paciente pac){
        //TODO cadastrar o paciente no banco
    }
    
    public int getRegistro() {
        return registro;
    }

    public void setRegistro(int registro) {
        this.registro = registro;
    }
}

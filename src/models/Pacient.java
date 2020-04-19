package models;

public class Pacient {
    
    private String nome;
    
    public Pacient(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

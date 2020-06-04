package models;

public class Medicamento {
    private String nome;
    private String dose;

    public Medicamento(String nome, String dose) {
        this.nome = nome;
        this.dose = dose;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }
}

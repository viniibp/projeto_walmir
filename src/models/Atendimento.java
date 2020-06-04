package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Atendimento {
    private int idAtendimento;
    private int idPaciente;
    private int idMedico;
    private int idReceptionista;
    private int idEnfermeira;
    private String descricaoEnfermeira;
    private byte risco;
    private Date data;
    private String descricaoMedico;
    private String diagnostico;
    
    //Somente para o registro do atendimento, quando for ler, usar a funcao 
    //carregarMedicamentos()
    private List<Medicamento> medicamentos;
    
    public void addMedicamento(Medicamento med){
        if(medicamentos == null) medicamentos = new ArrayList();
        medicamentos.add(med);
    }
    
//    public List<Medicamento> carregarMedicamentos(){
//        List<Medicamento> medicamentosCarregados;
//        
//        return medicamentosCarregados;
//    } 

    public int getIdAtendimento() {
        return idAtendimento;
    }

    public void setIdAtendimento(int idAtendimento) {
        this.idAtendimento = idAtendimento;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public int getIdReceptionista() {
        return idReceptionista;
    }

    public void setIdReceptionista(int idReceptionista) {
        this.idReceptionista = idReceptionista;
    }

    public int getIdEnfermeira() {
        return idEnfermeira;
    }

    public void setIdEnfermeira(int idEnfermeira) {
        this.idEnfermeira = idEnfermeira;
    }

    public String getDescricaoEnfermeira() {
        return descricaoEnfermeira;
    }

    public void setDescricaoEnfermeira(String descricaoEnfermeira) {
        this.descricaoEnfermeira = descricaoEnfermeira;
    }

    public byte getRisco() {
        return risco;
    }

    public void setRisco(byte risco) {
        this.risco = risco;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescricaoMedico() {
        return descricaoMedico;
    }

    public void setDescricaoMedico(String descricaoMedico) {
        this.descricaoMedico = descricaoMedico;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
}

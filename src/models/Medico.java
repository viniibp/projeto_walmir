package models;

import dao.models.MedicoDAO;
import java.util.List;

public class Medico extends Usuario{

    private int crm;
    private String especialidade;
        
    public List<Atendimento> buscarAtendimentos(){
        return new MedicoDAO().buscarAtendimentos();
    }
    
    public void finalizarAtendimento(Atendimento atm){
        MedicoDAO dao = new MedicoDAO();
        dao.finalizarAtendimento(atm);
        dao.armazenarMedicamentos(atm.carregarMedicamentos(), atm.getIdAtendimento());
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

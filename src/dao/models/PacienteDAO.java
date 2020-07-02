package dao.models;

import dao.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Atendimento;
import models.Paciente;

public class PacienteDAO extends ConnectionFactory{
    
    public Paciente buscarPacienteId(int id){
        try{
            Open();
            PreparedStatement stmt;
            ResultSet rs;
            
            String command = "SELECT idPaciente,nome,rg,numSUS,cpf FROM pacientes "
                    + "WHERE idPaciente = ?;";
            
            stmt = conn.prepareStatement(command);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
            if (rs.next()){
                Paciente pac = new Paciente();
                pac.setIdPaciente(rs.getInt("idPaciente"));
                pac.setNome(rs.getString("nome"));
                pac.setRg(rs.getString("rg"));
                pac.setNumSUS(rs.getString("numSUS"));
                pac.setCpf(rs.getString("cpf"));
                Close();
                return pac;
            }
            Close();
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(RecepcionistaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<Atendimento> historico(int idPaciente, int idAtendimento){
        try {
            Open();
            List<Atendimento> listaAtendimentos = new ArrayList();
            PreparedStatement stmt;
            ResultSet rs;
            String command;
            command = "SELECT dataHora, diagnostico FROM atendimentos "
                    + "WHERE idPaciente = ? AND NOT idAtendimento = ?;";
            stmt = conn.prepareStatement(command);
            
            stmt.setInt(1, idPaciente);
            stmt.setInt(2, idAtendimento);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Atendimento atm = new Atendimento();
                
                atm.setIdPaciente(idPaciente);
                
                atm.setData(rs.getDate("dataHora"));
                atm.setDiagnostico(rs.getString("diagnostico"));

                listaAtendimentos.add(atm);
                if(listaAtendimentos.size() == 3) break;
            }
            Close();
            rs.close();
            stmt.close();
            return listaAtendimentos;
        } catch (SQLException ex) {
            Logger.getLogger(MedicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}

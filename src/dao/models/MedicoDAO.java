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
import models.Medicamento;

public class MedicoDAO extends ConnectionFactory{
    
    public List<Atendimento> buscarAtendimentos(){
        try {
            Open();
            List<Atendimento> listaAtendimentos = new ArrayList();
            PreparedStatement stmt;
            ResultSet rs;
            String command;
            command = "SELECT * FROM Atendimentos WHERE diagnostico = 'null';";
            stmt = conn.prepareStatement(command);
            rs = stmt.executeQuery();
            while(rs.next()){
                Atendimento atm = new Atendimento();
                atm.setIdAtendimento(rs.getInt("idAtendimento"));
                
                atm.setIdPaciente(rs.getInt("idPaciente"));
                
                atm.setIdReceptionista(rs.getInt("idRecepcionista"));
                
                atm.setIdEnfermeira(rs.getInt("idEnfermeira"));
                atm.setDescricaoEnfermeira(rs.getString("descricaoEnfermeira"));
                atm.setRisco(rs.getInt("risco"));

                listaAtendimentos.add(atm);
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
    
    public void finalizarAtendimento(Atendimento atm){
        try{
            Open();
            PreparedStatement stmt;
            String command;
            command = "UPDATE Atendimentos "
                    + "SET descricaoMedico = ?, "
                    + "diagnostico = ?, "
                    + "dataHora = ?, "
                    + "idMedico = ? "
                    + "WHERE idAtendimento = ?;";
            
            stmt = conn.prepareStatement(command);
            
            stmt.setString(1, atm.getDescricaoMedico());
            stmt.setString(2, atm.getDiagnostico());
            stmt.setDate(3,  java.sql.Date.valueOf(java.time.LocalDate.now()));
            stmt.setInt(4, atm.getIdMedico());
            stmt.setInt(5, atm.getIdAtendimento());

            stmt.execute();
            stmt.close();
            Close();
        } catch (SQLException ex) {
            Logger.getLogger(MedicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public void armazenarMedicamentos(List<Medicamento> medicamentos, int idAtendimento) {
        try {
            Open();
            medicamentos.forEach((Medicamento medicamento) -> {
                PreparedStatement stmt;
                String command = "INSERT INTO Medicamentos VALUES"
                    + "(0, ?, ?, ?)";
                try{
                    stmt = conn.prepareStatement(command);
                    stmt.setInt(1, idAtendimento);
                    stmt.setString(2, medicamento.getNome());
                    stmt.setString(3, medicamento.getDose());

                    stmt.execute();
                    stmt.close();
                }catch (SQLException ex) {
                    Logger.getLogger(MedicoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            });

            Close();
        } catch (SQLException ex) {
            Logger.getLogger(MedicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

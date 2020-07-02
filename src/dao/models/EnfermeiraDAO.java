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
import models.Enfermeira;

public class EnfermeiraDAO extends ConnectionFactory{
    
    public List<Atendimento> buscarAtendimentos(){
        try {
            Open();
            List<Atendimento> listaAtendimentos = new ArrayList();
            PreparedStatement stmt;
            ResultSet rs;
            String command;
            command = "SELECT * FROM Atendimentos WHERE descricaoEnfermeira = 'null';";

            stmt = conn.prepareStatement(command);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Atendimento atm = new Atendimento();
                atm.setIdAtendimento(rs.getInt("idAtendimento"));
                atm.setIdPaciente(rs.getInt("idPaciente"));
                atm.setIdReceptionista(rs.getInt("idRecepcionista"));
                
                atm.setDescricaoEnfermeira(rs.getString("descricaoEnfermeira"));
                atm.setRisco(rs.getInt("risco"));

                listaAtendimentos.add(atm);
            }
            rs.close();
            stmt.close();
            Close();
            return listaAtendimentos;
        } catch (SQLException ex) {
            Logger.getLogger(MedicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Enfermeira getEnfermeira(int id){
        try {
            Open();
            PreparedStatement stmt;
            ResultSet rs;
            String command = "SELECT * FROM Enfermeira "
                + "WHERE idEnfermeira = ?;";
            
            stmt = conn.prepareStatement(command);
            stmt.setInt(1, id);
            
            rs = stmt.executeQuery();
            
            if(rs.next()){
                Enfermeira enfer = new Enfermeira();
                enfer.setNome(rs.getString("nome"));
                enfer.setIdPrincipal(id);
                enfer.setUserType(2);
                return enfer;
            }
            stmt.close();
            rs.close();
            Close();
        } catch (SQLException ex) {
            Logger.getLogger(MedicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void finalizarTriagem(Atendimento atm){
        try{
            Open();
            PreparedStatement stmt;
            String command;
            command = "UPDATE Atendimentos "
                    + "SET descricaoEnfermeira = ?, "
                    + "risco = ?, "
                    + "idEnfermeira = ?, "
                    + "diagnostico = 'null' "
                    + "WHERE idAtendimento = ?;";
            
            stmt = conn.prepareStatement(command);
            
            stmt.setString(1, atm.getDescricaoEnfermeira());
            stmt.setInt(2, atm.getRisco());
            stmt.setInt(3, atm.getIdEnfermeira());
            stmt.setInt(4, atm.getIdAtendimento());

            stmt.execute();
            stmt.close();
            Close();
        } catch (SQLException ex) {
            Logger.getLogger(MedicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

package dao.models;

import dao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Medico;

public class MedicoDAO {
    private final Connection conn;
    
    public MedicoDAO(){
        conn = new ConnectionFactory().getConnection();
    }
    
    public Medico getMedico(String usuario, String senha){
        try {
            PreparedStatement stmt;
            ResultSet rs;
            String command = "SELECT * FROM Medicos "
                + "WHERE usuario = ? AND senha = ?";
            
            stmt = conn.prepareStatement(command);
            stmt.setString(1, usuario);
            stmt.setString(2, senha);
            
            rs = stmt.executeQuery();
            if(rs.next()){
                Medico medico = new Medico(
                        Byte.parseByte(Integer.toString(rs.getInt("tipoUsuario"))),
                        rs.getString("nome"),
                        rs.getString("especialidade")
                );
                return medico;
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(MedicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

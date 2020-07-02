package dao.models;

import dao.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Enfermeira;
import models.Medico;
import models.Recepcionista;
import models.Usuario;

public class UsuarioDAO extends ConnectionFactory{
    
    public Medico logarMedico(Usuario user){
        try {
            Open();
            PreparedStatement stmt;
            ResultSet rs;
            String command = "SELECT * FROM Medicos "
                + "WHERE idMedico = ?;";
            
            stmt = conn.prepareStatement(command);
            stmt.setInt(1, user.getIdPrincipal());
            
            rs = stmt.executeQuery();
            if(rs.next()){
                Medico medico = new Medico();
                medico.setNome(rs.getString("nome"));
                medico.setCrm(rs.getInt("crm"));
                medico.setEspecialidade(rs.getString("especialidade"));
                medico.setIdPrincipal(user.getIdPrincipal());
                medico.setUserType(0);
                return medico;
            }
            stmt.close();
            rs.close();
            Close();
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(MedicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Recepcionista logarRecepcionista(Usuario user){
        try {
            Open();
            PreparedStatement stmt;
            ResultSet rs;
            String command = "SELECT * FROM Recepcionista "
                + "WHERE idRecepcionista = ?;";
            
            stmt = conn.prepareStatement(command);
            stmt.setInt(1, user.getIdPrincipal());
            
            rs = stmt.executeQuery();
            
            if(rs.next()){
                Recepcionista rec = new Recepcionista();
                rec.setNome(rs.getString("nome"));
                rec.setRegistro(rs.getInt("registro"));
                rec.setIdPrincipal(user.getIdPrincipal());
                rec.setUserType(1);
                return rec;
            }
            
            stmt.close();
            rs.close();
            Close();
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(MedicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Enfermeira logarEnfermeira(Usuario user){
        try {
            Open();
            PreparedStatement stmt;
            ResultSet rs;
            String command = "SELECT * FROM Enfermeira "
                + "WHERE idEnfermeira = ?;";
            
            stmt = conn.prepareStatement(command);
            stmt.setInt(1, user.getIdPrincipal());
            
            rs = stmt.executeQuery();
            if(rs.next()){
                Enfermeira enfer = new Enfermeira();
                enfer.setNome(rs.getString("nome"));
                enfer.setIdPrincipal(user.getIdPrincipal());
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
    
    public Usuario Login(Usuario user){
        try {
            Open();
            PreparedStatement stmt;
            ResultSet rs;
            
            String command = "SELECT * FROM Usuarios "
                + "WHERE nomeUsuario = ? AND senha = ?;";
            
            stmt = conn.prepareStatement(command);
            
            stmt.setString(1, user.getUsuario());
            stmt.setString(2, user.getSenha());
            
            rs = stmt.executeQuery();
            
            if(rs.next()){
                Usuario u = new Usuario();
                u.setIdPrincipal(rs.getInt("idPrincipal"));
                u.setUserType(rs.getInt("tipoUsuario"));
                return u;
            }
            
            stmt.close();
            rs.close();
            Close();
            
        } catch (SQLException ex) {
            Logger.getLogger(MedicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}

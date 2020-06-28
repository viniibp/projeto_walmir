package dao.models;

import dao.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Atendimento;
import models.Paciente;

public class RecepcionistaDAO extends ConnectionFactory{
    public void cadastrarPaciente(Paciente pac){
        try {
            Open();
            PreparedStatement stmt;
            String command = "INSERT INTO Pacientes VALUES"
                + "(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            stmt = conn.prepareStatement(command);
            stmt.setInt(1, 0);
            stmt.setString(2, pac.getNome());
            stmt.setString(3, pac.getCpf());
            stmt.setString(4, pac.getSexo());
            stmt.setString(5, pac.getRg());
            stmt.setString(6, pac.getLogradouro());
            stmt.setInt(7, pac.getNumCasa());
            stmt.setString(8, pac.getNumSUS());
            stmt.setString(9, pac.getEmail());
            stmt.setString(10, pac.getCidade());
            stmt.setString(11, pac.getEstado());
            stmt.setString(12, pac.getTelefone());
            stmt.setString(13, pac.getCep());
            
            stmt.execute();
            stmt.close();

            Close();
        } catch (SQLException ex) {
            Logger.getLogger(MedicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean podeCadastrar(Paciente pac){
        try{
            Open();
            PreparedStatement stmt;
            ResultSet rs;
            String command = "SELECT * FROM Pacientes "
                    + "WHERE rg = ? AND cpf = ? AND numSUS = ?;";
            
            stmt = conn.prepareStatement(command);
            stmt.setString(1, pac.getRg());
            stmt.setString(2, pac.getCpf());
            stmt.setString(3, pac.getNumSUS());
            
            rs = stmt.executeQuery();
            boolean existe = !rs.next();
            stmt.close();
            rs.close();
            Close();
            return existe;

        } catch (SQLException ex) {
            Logger.getLogger(MedicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public Paciente buscarPacienteCPF(String cpf){
        try{
            Open();
            PreparedStatement stmt;
            ResultSet rs;
            
            String command = "SELECT idPaciente,nome,rg,numSUS,cpf FROM pacientes "
                    + "WHERE cpf = ?;";
            
            stmt = conn.prepareStatement(command);
            stmt.setString(1, cpf);
            rs = stmt.executeQuery();
            
            if (rs.next()){
                System.out.println("acho");
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
    
    public void iniciarTriagem(Atendimento atend){
         try {
            Open();
            PreparedStatement stmt;
            String command = "INSERT INTO Atendimentos(idAtendimento, idPaciente, idRecepcionista) VALUES"
                + "(?,?,?);";
            
            stmt = conn.prepareStatement(command);
            stmt.setInt(1, 0);
            stmt.setInt(2, atend.getIdPaciente());
            stmt.setInt(3, atend.getIdReceptionista());
            stmt.execute();
            stmt.close();

            Close();
        } catch (SQLException ex) {
            Logger.getLogger(MedicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
    protected Connection conn;
    
    public Connection getConnection(){
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost/Hospital";
        String user = "root";
        String senha = "";
        
        try{
            Class.forName(driver);
            Connection conexao = DriverManager.getConnection(url, user, senha);
            return conexao;
            
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na conexão", ex);
        }
    }
    
    protected void Open(){
        conn = getConnection();
    }
    
    protected void Close() throws SQLException{
        if(!conn.isClosed()) conn.close();
    }
    
    
    
}

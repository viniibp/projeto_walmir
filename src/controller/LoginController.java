package controller;

import dao.models.UsuarioDAO;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import models.UserType;
import models.Usuario;
import sessao.Sessao;
import views.main;

public class LoginController implements Initializable {

    @FXML
    private TextField txt_user;
    
    @FXML
    private PasswordField txt_pass;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
    
    @FXML
    private void logar() throws IOException{
        UsuarioDAO dao = new UsuarioDAO();
        Usuario user = new Usuario(txt_user.getText(), txt_pass.getText());
        user = dao.Login(user);
        if(user != null) 
        {
            Usuario logado;
            
            switch(user.getUserType()){
                case UserType.medico:
                    logado = dao.logarMedico(user);
                    break;
                case UserType.enfermeira:
                    logado = dao.logarEnfermeira(user);
                    break;
                case UserType.recepcao:
                    logado = dao.logarRecepcionista(user);
                    break;
                default:
                    logado = null;
            }
            Entrar(logado, user.getUserType());
        }
        else{
            widget.widgets.Notification("Aviso", "Usuario não encontrado.");
            System.gc();
        }
    }
    
    private void Entrar(Usuario u, int uType) throws IOException{
        if(u != null){
            String[] caminhos = new String[3];
            caminhos[0] = "medico/list_of_pacients.fxml";
            caminhos[1] = "medico/list_of_pacients.fxml";
            caminhos[2] = "recepcao/home.fxml";
            
            Sessao.StartSession(u);
            main.TrocarTelas(caminhos[uType]);
            widget.widgets.Notification(
                    "Sessão iniciada", 
                    "Bem vindo "+ u.getNome() +"!"
            );
            clear();
        }
    }
    
    private void clear(){
        txt_user.clear();
        txt_pass.clear();
    }
    
}

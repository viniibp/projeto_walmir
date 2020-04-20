package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import models.User;
import models.UserType;
import views.main;

public class LoginController implements Initializable {

    @FXML
    private TextField txt_user, txt_pass;
    
    private User rec, med;
    
    private List<User> usuarios;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rec = new User("rec", "123", UserType.recepcao);
        med = new User("med", "123", UserType.medico);
        
        usuarios = new ArrayList<>();
        usuarios.add(rec);
        usuarios.add(med);

    }
    
    @FXML
    private void logar() throws IOException{
        String[] caminhos = new String[2];
        caminhos[0] = "medico/list_of_pacients.fxml";
        caminhos[1] = "recepcao/home.fxml";
        
        for(User user : usuarios)
        if(txt_user.getText().equals(user.getUsername()) && txt_pass.getText().equals(user.getPassword()))
        {
            main.TrocarTelas(caminhos[user.getUserType()]);
            clear();
        }
        
    }
    
    private void clear(){
        txt_user.clear();
        txt_pass.clear();
    }
    
}

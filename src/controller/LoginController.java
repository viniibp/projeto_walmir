package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import views.main;

public class LoginController implements Initializable {

    @FXML
    private TextField txt_user, txt_pass;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
    @FXML
    private void logar() throws IOException{
        if(txt_user.getText().equals("rec") && txt_pass.getText().equals("123")){
            main.TrocarTelas("recepcao/home.fxml");
        }
        clear();
    }
    
    private void clear(){
        txt_user.clear();
        txt_pass.clear();
    }
    
}

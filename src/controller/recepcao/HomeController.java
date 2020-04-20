package controller.recepcao;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import views.main;

public class HomeController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Object ob = rb.getObject("obj");
    }    
    
    @FXML
    private void encaminharTriagem() throws IOException{
        main.TrocarTelas("recepcao/screening.fxml");
    }
    
    @FXML
    private void cadastrarPaciente() throws IOException{
        main.TrocarTelas("recepcao/patient_register.fxml");
    }
    
    @FXML
    private void sair() throws IOException{
        main.TrocarTelas("login.fxml");

    }

}

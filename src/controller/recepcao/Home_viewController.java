package controller.recepcao;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import views.main;

public class Home_viewController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //esse foi so um teste
        Object ob = rb.getObject("obj");
    }    
    
    @FXML
    private void encaminharTriagem(){
        
    }
    
    @FXML
    private void cadastrarPaciente() throws IOException{
        main.TrocarTelas("recepcao/patient_register_view.fxml");
    }
    
    @FXML
    private void sair() throws IOException{
        main.TrocarTelas("login_view.fxml");

    }

}

package controller.recepcao;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class Screening_viewController implements Initializable {

    @FXML
    private TextField txt_pesquisarPaciente, txt_nome, txt_RG, txt_CPF, txt_numeroSUS;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    private void encaminharPaciente(){
        
    }
    
}

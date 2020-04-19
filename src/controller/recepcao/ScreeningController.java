package controller.recepcao;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class ScreeningController implements Initializable {

    @FXML
    private TextField txt_pesquisarPaciente, txt_nome, txt_RG, txt_CPF, txt_numeroSUS;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    @FXML
    private void encaminharPaciente(){
        
    }
    
}

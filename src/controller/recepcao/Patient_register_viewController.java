package controller.recepcao;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class Patient_register_viewController implements Initializable {

    @FXML
    private TextField txt_nome;
    @FXML
    private TextField txt_RG;
    @FXML
    private TextField txt_CPF;
    @FXML
    private TextField txt_numeroSUS;
    @FXML
    private TextField txt_CEP;
    @FXML
    private TextField txt_logradouro;
    @FXML
    private TextField txt_numeroCasa;
    @FXML
    private TextField txt_cidade;
    @FXML
    private ComboBox<?> cb_estado;
    @FXML
    private ComboBox<?> cb_sexo;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void cadastrarPaciente(ActionEvent event) {
    }
    
}

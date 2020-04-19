package controller.recepcao;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class Patient_registerController implements Initializable {

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
    private ComboBox<String> cb_estado;
    @FXML
    private ComboBox<String> cb_sexo;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregarCB();
    }    

    @FXML
    private void cadastrarPaciente(ActionEvent event) {
    }
    
    private void carregarCB(){
        cb_sexo.getItems().addAll("Masculino", "Feminino");
        cb_estado.getItems().addAll("AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RO", "RS", "RR", "SC", "SE", "SP", "TO" );
    }
    
}

package controller.recepcao;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import models.Paciente;
import models.Recepcionista;
import static sessao.Sessao.Logado;
import views.main;

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
    private TextField txt_email;
    @FXML
    private TextField txt_telefone;
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
        Recepcionista rec = (Recepcionista)Logado();
        if(rec.cadastrarPaciente(paciente())){
            widget.widgets.Notification("Sucesso!", "O paciente " + paciente().getNome() + " foi cadastrado.");
        }
        else widget.widgets.Notification("Falha", "O paciente " + paciente().getNome() + " ja existe.");
    }
    
    private Paciente paciente(){
        Paciente paciente = new Paciente();
        
        paciente.setNome(txt_nome.getText());
        paciente.setLogradouro(txt_logradouro.getText());
        paciente.setRg(txt_RG.getText());
        paciente.setCpf(txt_CPF.getText());
        paciente.setNumSUS(txt_numeroSUS.getText());
        paciente.setTelefone(txt_telefone.getText());
        paciente.setEmail(txt_email.getText() != null ? txt_email.getText() : "Sem email");
        paciente.setNumCasa(Integer.parseInt(txt_numeroCasa.getText()));
        paciente.setCep(txt_CEP.getText());
        paciente.setCidade(txt_cidade.getText());
        
        paciente.setEstado(cb_estado.getSelectionModel().getSelectedItem());
        paciente.setSexo(cb_sexo.getSelectionModel().getSelectedItem());
        return paciente;
    }
    
    @FXML
    private void voltarHome() throws IOException{
        main.TrocarTelas("recepcao/home.fxml");
    }
    
    private void carregarCB(){
        cb_sexo.getItems().addAll("Masculino", "Feminino");
        cb_estado.getItems().addAll
        (
                "AC", "AL", "AM", "AP", "BA", "CE", "DF",
                "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", 
                "PI", "RJ", "RN", "RO", "RS", "RR", "SC", "SE", "SP", "TO" 
        );
    }
    
}

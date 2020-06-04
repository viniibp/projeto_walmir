package controller.medico;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import models.Medico;
import models.Paciente;
import sessao.Sessao;
import views.main;
import static widget.widgets.hbox;
import static widget.widgets.txtBorder;
import static widget.widgets.button;


public class List_of_pacientsController implements Initializable {

    @FXML
    private FlowPane base;
    
    @FXML
    private Text nomeMedico;
    
    @FXML
    private ScrollPane scroll;
    
    @FXML
    private TextField txt_pesquisarPaciente;
    
    private List<Paciente> pacientes;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Medico medico = (Medico)Sessao.Logado();
        nomeMedico.setText(medico.getNome());
        scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER); 
        
        //TODO remover testes posteriormente
        pacientes = new ArrayList<>();
        pacientes.add(new Paciente("Marcos"));
        pacientes.add(new Paciente("Pedro"));
        pacientes.add(new Paciente("Rafael"));
        pacientes.add(new Paciente("Paula"));        
        pacientes.add(new Paciente("Teste"));
   
        load(pacientes);
    }
    
    private void load(List<Paciente> pacientes){
        pacientes.forEach((paciente) -> {
            HBox pacient_base = hbox("495", "85");
            TextField pacient = txtBorder("480", "55");
            pacient.setText(paciente.getNome());
            pacient_base.getChildren().add(pacient);

            HBox button_base = hbox("257", "88");
            Button button = button("170", "55", "Atender");
            
            //TODO passar dados do paciente para outra tela
            button.setOnMouseClicked((__) -> {
                try {
                    main.TrocarTelas("medico/diagnostics.fxml", paciente);
                } catch (IOException ex) {
                    Logger.getLogger(List_of_pacientsController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            
            button_base.getChildren().add(button);

            base.getChildren().add(pacient_base);
            base.getChildren().add(button_base);
        });
    }
    
    @FXML
    private void filtrarPacientes(){
        base.getChildren().clear();
        List<Paciente> listaFiltrada = new ArrayList<>();
//        for (Paciente paciente : pacientes) {
//            if(paciente.getNome().toUpperCase().startsWith(txt_pesquisarPaciente.getText().toUpperCase())) listaFiltrada.add(paciente);
//        }
        pacientes.stream().filter((paciente) -> (
                paciente.getNome().toUpperCase().startsWith(txt_pesquisarPaciente.getText().toUpperCase())) //começa com
                //|| paciente.getNome().toUpperCase().contains(txt_pesquisarPaciente.getText().toUpperCase()) //possui
        ).forEachOrdered((paciente) -> {
            listaFiltrada.add(paciente);
        });
        load(listaFiltrada);
    }
    
    @FXML
    private void sair() throws IOException{
        Sessao.EndSession();
        main.TrocarTelas("login.fxml");
    }
    
}

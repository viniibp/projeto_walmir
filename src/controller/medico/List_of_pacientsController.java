package controller.medico;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import models.Pacient;
import views.main;
import static widget.widgets.hbox;
import static widget.widgets.txtBorder;
import static widget.widgets.button;


public class List_of_pacientsController implements Initializable {

    @FXML
    private FlowPane base;
    
    @FXML
    private ScrollPane scroll;
    
    private List<Pacient> pacientes;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER); 
        /*TODO
            remover testes posteriormente
        */
        
        pacientes = new ArrayList<>();
        pacientes.add(new Pacient("Marcos"));
        pacientes.add(new Pacient("Pedro"));
        pacientes.add(new Pacient("Rafael"));
        pacientes.add(new Pacient("Paula"));        
   
        load();
    }
    
    private void load(){
        for (Pacient paciente : pacientes) {
            HBox pacient_base = hbox("495", "85");
            TextField pacient = txtBorder("480", "55");
            pacient.setText(paciente.getNome());
            pacient_base.getChildren().add(pacient);

            HBox button_base = hbox("257", "88");
            Button button = button("170", "55", "Atender");

            button_base.getChildren().add(button);

            base.getChildren().add(pacient_base);
            base.getChildren().add(button_base);
        }
        
    }
    
    @FXML
    private void sair() throws IOException{
        main.TrocarTelas("login_view.fxml");
    }
    
}

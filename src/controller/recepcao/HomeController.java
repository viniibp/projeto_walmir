package controller.recepcao;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import models.Recepcionista;
import views.main;
import sessao.Sessao;

public class HomeController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Recepcionista recep = (Recepcionista)Sessao.Logado();
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
        Sessao.EndSession();
        main.TrocarTelas("login.fxml");

    }

}

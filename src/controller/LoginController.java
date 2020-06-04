package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import models.Medico;
import models.Recepcionista;
import models.Usuario;
import models.UserType;
import sessao.Sessao;
import views.main;

public class LoginController implements Initializable {

    @FXML
    private TextField txt_user, txt_pass;
    
    private Usuario rec, med;
    
    private List<Usuario> usuarios;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        med = new Medico("med", "123", UserType.medico, "Medico", "Cirurgião");
        rec = new Recepcionista("rec", "123", UserType.recepcao, "Recepcao", 1234);
        
        usuarios = new ArrayList<>();
        
        usuarios.add(med);
        usuarios.add(rec);

    }
    
    @FXML
    private void logar() throws IOException{
        String[] caminhos = new String[3];
        caminhos[0] = "medico/list_of_pacients.fxml";
        caminhos[1] = "";
        caminhos[2] = "recepcao/home.fxml";
        
        Medico medico = new Medico().Logar(txt_user.getText(), txt_pass.getText());
        if(medico == null) System.out.println("N ACHOU KKKKKKKKKKKKKKKKKK");
        else{
            Sessao.StartSession(medico);
            main.TrocarTelas(caminhos[medico.getUserType()]);
            clear();
        }
//        for (Usuario user : usuarios) {
//            if(txt_user.getText().equals(user.getUsuario()) && txt_pass.getText().equals(user.getSenha()))
//            {
//                Sessao.StartSession(user);
//                main.TrocarTelas(caminhos[user.getUserType()]);
//                clear();
//            }
//        }
        
    }
    
    private void clear(){
        txt_user.clear();
        txt_pass.clear();
    }
    
}

package controller.recepcao;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import models.Atendimento;
import models.Paciente;
import models.Recepcionista;
import views.main;

public class ScreeningController implements Initializable {

    @FXML
    private TextField txt_pesquisarPaciente, txt_nome, txt_RG, txt_CPF, txt_numeroSUS;
    
    @FXML
    private Label lb_Id;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    @FXML
    private void encaminharPaciente(){
        if(txt_pesquisarPaciente.getText().length() > 10){
            Recepcionista logado = (Recepcionista) sessao.Sessao.Logado();

            Atendimento atendimento = new Atendimento();

            atendimento.setIdPaciente(Integer.parseInt(lb_Id.getText()));
            atendimento.setIdReceptionista(logado.getIdPrincipal());
            logado.iniciarTriagem(atendimento);
            widget.widgets.Notification(
                    "Triagem",
                    txt_nome.getText()+" encaminhado com sucesso!" 
            );
        }
        else widget.widgets.Notification("Erro", "Busque um cpf válido.");
        
    }
    
    @FXML
    private void buscarPaciente(){
        Recepcionista logado = (Recepcionista)sessao.Sessao.Logado();
        Paciente busca = logado.buscarPaciente(txt_pesquisarPaciente.getText());
        if(busca != null) setarCampos(busca);
        else widget.widgets.Notification("Aviso", "Paciente não encontrado.");
    }
    
    private void setarCampos(Paciente pac){
        lb_Id.setText(Integer.toString(pac.getIdPaciente()));
        txt_nome.setText(pac.getNome());
        txt_RG.setText(pac.getRg());
        txt_CPF.setText(pac.getCpf());
        txt_numeroSUS.setText(pac.getNumSUS());
    }
    
    @FXML
    private void voltarHome() throws IOException{
        main.TrocarTelas("recepcao/home.fxml");
    }
    
}

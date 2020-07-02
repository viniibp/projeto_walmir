package controller.medico;

import dao.models.EnfermeiraDAO;
import dao.models.MedicoDAO;
import dao.models.PacienteDAO;
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
import models.Atendimento;
import models.Paciente;
import models.UserType;
import models.Usuario;
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
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Usuario usuario = Sessao.Logado();
        nomeMedico.setText(usuario.getNome());
        scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        load(atendimentos(usuario));
    }
    
    private void load(List<Atendimento> atendimentos){
        atendimentos.forEach((atendimento) -> {
            Paciente paciente = new PacienteDAO().buscarPacienteId(atendimento.getIdPaciente());
            HBox pacient_base = hbox("495", "85");
            TextField pacient = txtBorder("480", "55");
            pacient.setText(paciente.getNome());
            pacient_base.getChildren().add(pacient);

            HBox button_base = hbox("257", "88");
            Button button = button("170", "55", "Atender");
            
            button.setOnMouseClicked((__) -> {
                try {
                    String url;
                    if(Sessao.Logado().getUserType() == UserType.medico) url = "medico/diagnostics.fxml";
                    else url = "enfermeira/screening_diagnostics.fxml";
                    main.TrocarTelas(url, atendimento);
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
        Usuario usuario = Sessao.Logado();
        PacienteDAO dao = new PacienteDAO();
        List<Atendimento> listaFiltrada = new ArrayList<>();
        
        base.getChildren().clear();
        
        atendimentos(usuario).stream().filter((atendimento) -> (
                dao.buscarPacienteId(atendimento.getIdPaciente())
                        .getNome().toUpperCase().startsWith(txt_pesquisarPaciente.getText()
                                .toUpperCase())) //começa com
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
    
    private List<Atendimento> atendimentos(Usuario usuario){
        if(usuario.getUserType() == UserType.medico) return new MedicoDAO().buscarAtendimentos();
        else return new EnfermeiraDAO().buscarAtendimentos();
        
    }
    
}

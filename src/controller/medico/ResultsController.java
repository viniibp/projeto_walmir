package controller.medico;

import dao.models.EnfermeiraDAO;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import models.Atendimento;
import models.Enfermeira;
import models.Medico;
import sessao.Sessao;
import views.main;
import static widget.widgets.hboxBorder;
import static widget.widgets.txt;

public class ResultsController implements Initializable {
    
    @FXML
    private FlowPane base;
    
    @FXML
    private TextArea txt_descricaoMedico, txt_descricaoEnfermeira;
    
    @FXML
    private Label lb_nomeMedico, lb_nomeEnfermeira;
    
    @FXML
    private ScrollPane scroll;
    
    private Atendimento atendimento;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        atendimento = (Atendimento)rb.getObject("obj");
        loadMedicamenos();
        loadInfos();
        
    }    
    
    private void loadInfos(){
        txt_descricaoEnfermeira.setText(atendimento.getDescricaoEnfermeira());
        txt_descricaoMedico.setText(atendimento.getDescricaoMedico());
        Medico m = (Medico)Sessao.Logado();
        lb_nomeMedico.setText(m.getNome());
        atendimento.setIdMedico(m.getIdPrincipal());
        Enfermeira e = new EnfermeiraDAO().getEnfermeira(atendimento.getIdEnfermeira());
        lb_nomeEnfermeira.setText(e.getNome());
    }
    
    @FXML
    private void finalizarAtendimento() throws IOException{
        Medico m = (Medico)Sessao.Logado();
        m.finalizarAtendimento(atendimento);
        widget.widgets.Notification("Consulta finalizada", "Essa consulta foi armazenada no banco de dados!");
        main.TrocarTelas("medico/list_of_pacients.fxml");
    }
    
    @FXML
    private void corrigirDiagnostico() throws IOException{
        main.TrocarTelas("medico/diagnostics.fxml", atendimento);
    }
    
    private void loadMedicamenos(){
        atendimento.carregarMedicamentos().forEach((diagnostico) -> {
            HBox remedio_base = hboxBorder("290", "50");
            TextField remedio = txt("270", "40");
            remedio.setText(diagnostico.getNome());
            remedio.setEditable(false);
            
            HBox dose_base = hboxBorder("105", "50");
            TextField dose = txt("100", "40");
            dose.setText(diagnostico.getDose());
            dose.setEditable(false);
            
            remedio_base.getChildren().add(remedio);
            dose_base.getChildren().add(dose);

            base.getChildren().add(remedio_base);
            base.getChildren().add(dose_base);
        });
        
    }
    
}

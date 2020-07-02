package controller.medico;

import dao.models.PacienteDAO;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import models.Atendimento;
import models.Medicamento;
import models.Medico;
import models.Paciente;
import sessao.Sessao;
import views.main;
import static widget.widgets.txt;
import static widget.widgets.hboxBorder;

public class DiagnosticsController implements Initializable {

    @FXML
    private FlowPane base;
    
    @FXML
    private Pane pn_risco;
    
    @FXML
    private ScrollPane scroll;
    
    @FXML
    private TextArea txt_descricaoMedico;
    
    @FXML
    private TextField txt_diagnostico;
    
    @FXML
    private Label lb_nome, lb_sus, lb_cpf;
    
    @FXML
    private Label lb_nomeMedico, lb_date;
    
    private List[] medicamentos;
    
    private Atendimento atendimento;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        atendimento = (Atendimento)rb.getObject("obj");
        medicamentos = new List[]{new LinkedList(), new LinkedList()};
  
        carregarInfoPaciente();
        carregarInfoMedico();
        
    }    
    
    private void carregarInfoMedico(){
        Medico m = (Medico)Sessao.Logado();
        lb_nomeMedico.setText(m.getNome());
        lb_date.setText(getDate());

    }
    
    private String getDate(){
        String dia,mes,ano;
        dia = java.time.LocalDate.now().toString().substring(8, 10);
        mes = java.time.LocalDate.now().toString().substring(5, 7);
        ano = java.time.LocalDate.now().toString().substring(0, 4);
        return dia+"-"+mes+"-"+ano;
    }
    
    private void carregarInfoPaciente(){
        Paciente p = new PacienteDAO().buscarPacienteId(atendimento.getIdPaciente());
        lb_nome.setText(p.getNome());
        lb_sus.setText(p.getNumSUS());
        lb_cpf.setText(p.getCpf());
        pn_risco.setStyle(Risco(atendimento.getRisco()));

    }
    
    @FXML
    private void voltarListaPacientes() throws IOException{
        main.TrocarTelas("medico/list_of_pacients.fxml");
    }
    
    @FXML
    private void add(){        
        load();
        resize();
        scroll.setVvalue(1); 
    }
    
    @FXML
    private void enviar() throws IOException{
        for(int i = 0; i < medicamentos[0].size(); i++){
            TextField medicamento = (TextField)medicamentos[0].get(i);
            TextField dose = (TextField)medicamentos[1].get(i);
            atendimento.addMedicamento(new Medicamento(medicamento.getText(),dose.getText()));
        }
        atendimento.setDescricaoMedico(txt_descricaoMedico.getText());
        atendimento.setDiagnostico(txt_diagnostico.getText());
        main.TrocarTelas("medico/results.fxml", atendimento);
    }
    
    private String Risco(int risco){
        String color = "blue";
        if(risco == 1) color = "yellow";
        if(risco == 2) color = "red";
        return "-fx-background-color: "+color+"; -fx-background-radius: 10;"
                + "-fx-pref-width: 200;-fx-pref-height: 10;";
    }
    
    private void resize(){
        if(base.getChildren().size() >= 7)scroll.resize(350, 240);
        else scroll.resize(344, 240);
    }
    
    private void load(){
        byte indexRemedio = 0;
        byte indexDose = 1;
        
        HBox remedio_base = hboxBorder("290", "50");
        TextField remedio = txt("270", "40");
        
        remedio_base.getChildren().add(remedio);
        
        HBox dose_base = hboxBorder("105", "50");
        TextField dose = txt("100", "40");
        
        dose_base.getChildren().add(dose);
        
        base.getChildren().add(remedio_base);
        base.getChildren().add(dose_base);
        
        medicamentos[indexRemedio].add(remedio);
        medicamentos[indexDose].add(dose);
    }
    
    
}

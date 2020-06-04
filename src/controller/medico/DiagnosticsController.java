package controller.medico;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import models.Paciente;
import models.Atendimento;
import views.main;
import static widget.widgets.txt;
import static widget.widgets.hboxBorder;

public class DiagnosticsController implements Initializable {

    @FXML
    private FlowPane base;
    
    @FXML
    private ScrollPane scroll;
    
    @FXML
    private Label lb_nome;
    
    private List[] medicamentos;
    
    //teste
    private Paciente paciente;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        paciente = (Paciente)rb.getObject("obj");
        
        medicamentos = new List[]{new LinkedList(), new LinkedList()};
  
        carregarInfo();
        
    }    
    
    private void carregarInfo(){
        lb_nome.setText(paciente.getNome());
    }
    
    @FXML
    private void voltarListaPacientes() throws IOException{
        main.TrocarTelas("medico/list_of_pacients.fxml");
    }
    /*TODO
        Fazer botão de remover medicamento/dose
        arrumar scroll, não muito importante...
    */
    
    @FXML
    private void add(){        
        load();
        resize();
        //desce o scroll até o final...
        scroll.setVvalue(1); //bugado, se colocar em outro botao, funciona
    }
    
    @FXML
    private void enviar() throws IOException{
        for(int i = 0; i < medicamentos[0].size(); i++){
            TextField medicamento = (TextField)medicamentos[0].get(i);
            TextField dose = (TextField)medicamentos[1].get(i);
        }
        
        System.out.println(paciente);
        //main.TrocarTelas("", paciente);
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

package controller.medico;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import static widget.widgets.txt;
import static widget.widgets.hboxBorder;

public class DiagnosticsController implements Initializable {

    @FXML
    private FlowPane base;
    
    @FXML
    private ScrollPane scroll;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);       
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
    private void enviar(){
        //scroll.setVvalue(1); aqui funciona
    }
    
    
    private void resize(){
        if(base.getChildren().size() >= 7)scroll.resize(350, 240);
        else scroll.resize(344, 240);
    }
    
    private void load(){
        HBox remedio_base = hboxBorder("290", "50");
        TextField remedio = txt("270", "40");
        
        remedio_base.getChildren().add(remedio);
        
        HBox dose_base = hboxBorder("105", "50");
        TextField dose = txt("100", "40");
        
        dose_base.getChildren().add(dose);
        
        base.getChildren().add(remedio_base);
        base.getChildren().add(dose_base);
    }
    
    
}
package controller.medico;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import models.Diagnostico;
import static widget.widgets.hboxBorder;
import static widget.widgets.txt;

public class ResultsController implements Initializable {
    
    @FXML
    private FlowPane base;
    
    @FXML
    private ScrollPane scroll;
    
    private List<Diagnostico> diagnosticos;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        diagnosticos = new ArrayList<>();
        diagnosticos.add(new Diagnostico("0", "0"));
        diagnosticos.add(new Diagnostico("1", "1"));
        diagnosticos.add(new Diagnostico("2", "2"));
        diagnosticos.add(new Diagnostico("3", "3"));
        diagnosticos.add(new Diagnostico("4", "4"));

        load();
    }    
    
    @FXML
    private void imprimir(){
        
    }
    
    private void load(){
        for (Diagnostico diagnostico : diagnosticos) {
            HBox remedio_base = hboxBorder("290", "50");
            TextField remedio = txt("270", "40");
            remedio.setText(diagnostico.getDoenca());
            

            HBox dose_base = hboxBorder("105", "50");
            TextField dose = txt("100", "40");
            dose.setText(diagnostico.getData());
            
            remedio_base.getChildren().add(remedio);
            dose_base.getChildren().add(dose);

            base.getChildren().add(remedio_base);
            base.getChildren().add(dose_base);
        }
        
    }
    
}

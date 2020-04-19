package controller.recepcao;

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
import javafx.scene.text.Text;
import models.Diagnostico;
import static widget.widgets.txt;
import static widget.widgets.hboxBorder;

public class Screening_diagnosticsController implements Initializable {

    @FXML
    private FlowPane base;
    
    @FXML
    private ScrollPane scroll;
    
    @FXML
    private Text data0, data1, data2;
    
    @FXML
    private Text doenca0, doenca1, doenca2;
    
    private int index;
    
    private List<Diagnostico> hist;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);      
        hist = new ArrayList<>();
        hist.add(new Diagnostico("00/00/0000","doenca0"));
        hist.add(new Diagnostico("11/11/1111","doenca1"));
        hist.add(new Diagnostico("22/22/2222","doenca2"));
        hist.add(new Diagnostico("33/33/3333","doenca3"));
        hist.add(new Diagnostico("44/44/4444","doenca4"));

        loadHistorico();

    }
    
    private void resize(){
        if(base.getChildren().size() > 6)scroll.resize(350, 240);
        else scroll.resize(344, 240);
    }
    
    private void load(){
        HBox pacient_base = hboxBorder("495", "85");
        TextField pacient = txt("480", "55");
        
        pacient_base.getChildren().add(pacient);
        
        HBox button_base = hboxBorder("257", "85");
        
        button_base.getChildren().add(null);
        
        base.getChildren().add(pacient_base);
        base.getChildren().add(button_base);
    }
    
    @FXML
    private void back(){
        if(index > 0){
            index -= 3;
            loadHistorico();
        }
    }
    
    @FXML
    private void forward(){
        if(index <= hist.size()){
            index += 3;
            loadHistorico();
        }
    }
    
    private void loadHistorico(){
        setText(data0, doenca0, 0);
        setText(data1, doenca1, 1);
        setText(data2, doenca2, 2);

    }
    
    private void setText(Text data, Text doenca, int pos){
        int novoIndex = index + pos;
        if((novoIndex) < hist.size()){
            Diagnostico historico = hist.get(novoIndex);
            data.setText(historico.getData());
            doenca.setText(historico.getDoenca());
        }
        else{
            data.setText("Sem dados!");
            doenca.setText("Sem dados!");
        }
    }
    
    @FXML
    private void enviar(){
        
    }
}

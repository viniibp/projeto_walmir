package controller.enfermeira;

import dao.models.EnfermeiraDAO;
import dao.models.PacienteDAO;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import models.Atendimento;
import models.Enfermeira;
import models.Paciente;
import sessao.Sessao;
import views.main;
import static widget.widgets.txt;
import static widget.widgets.hboxBorder;

public class Screening_diagnosticsController implements Initializable {

    @FXML
    private FlowPane base;
    
    @FXML
    private ScrollPane scroll;
    
    @FXML
    private Label lb_nomePaciente, lb_sus, lb_cpf, lb_nomeEnfermeira;
    
    @FXML
    private TextArea txt_descricaoEnfermeira;
    
    @FXML
    private Text data0, data1, data2, doenca0, doenca1, doenca2;
    
    @FXML
    private RadioButton rb_baixo, rb_moderado, rb_grave;
    
    private Atendimento atendimento;
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        
        Enfermeira enfermeira = (Enfermeira) Sessao.Logado();
        lb_nomeEnfermeira.setText(enfermeira.getNome());
        
        atendimento = (Atendimento)rb.getObject("obj");
        loadDadosPaciente(atendimento.getIdPaciente());
        atendimento.setIdEnfermeira(enfermeira.getIdPrincipal());
        

    }
    
    @FXML
    private void voltarListaPacientes() throws IOException{
        main.TrocarTelas("medico/list_of_pacients.fxml");
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
    
    private void setText(Text data, Text doenca, String[] text){
        if(text != null){
            data.setText(text[0]);
            doenca.setText(text[1]);
        }
        else{
            data.setText("Sem dados!");
            doenca.setText("Sem dados!");
        }
    }
    
    @FXML
    private void enviar() throws IOException{
        atendimento.setDescricaoEnfermeira(txt_descricaoEnfermeira.getText());
        atendimento.setRisco(risco());
        new EnfermeiraDAO().finalizarTriagem(atendimento);
        widget.widgets.Notification("Triagem finalizada", "O paciente foi movido para a lista do medico");
        main.TrocarTelas("medico/list_of_pacients.fxml");
        
    }

    private int risco(){
        if(rb_baixo.isSelected()) return 0;
        if(rb_moderado.isSelected()) return 1;
        if(rb_grave.isSelected()) return 2;
        return 0;
    }
    
    private void loadDadosPaciente(int idPaciente) {
        Paciente paciente = new PacienteDAO().buscarPacienteId(idPaciente);
        lb_nomePaciente.setText(paciente.getNome());
        lb_sus.setText(paciente.getNumSUS());
        lb_cpf.setText(paciente.getCpf());
        loadHistorico(paciente);
    }
    
    private void loadHistorico(Paciente p){
        List<Atendimento> historico = p.historico(atendimento.getIdAtendimento());
        System.out.println(historico.size());
        String campoHist[][] = {{"Sem dados","Sem dados"}, {"Sem dados","Sem dados"}, {"Sem dados","Sem dados"}};
        if(historico.size() > 0){
            for(int i = 0; i <= historico.size()-1; i++){
                campoHist[i][0] = getDate(historico.get(i).getData().toString());
                campoHist[i][1] = historico.get(i).getDiagnostico();
            }
        }

        setText(data0, doenca0, campoHist[0]);
        setText(data1, doenca1, campoHist[1]);
        setText(data2, doenca2, campoHist[2]);
    }
    
    private String getDate(String data){
        String dia,mes,ano;
        dia = data.substring(8, 10);
        mes = data.substring(5, 7);
        ano = data.substring(0, 4);
        return dia+"-"+mes+"-"+ano;
    }
}

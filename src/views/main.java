package views;

import java.io.IOException;
import java.util.Enumeration;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class main extends Application {
    
    private static Stage stage;
    
    @Override
    public void start(Stage stageStart) throws IOException {
        stage = stageStart;
        
        //Busca a view da tela inicial
        Parent root = FXMLLoader.load(getClass().getResource("login_view.fxml"));
        
        //cria uma area pra colocar a janela inicial
        Scene scene = new Scene(root, 700, 430);
        
        stage.setTitle("Sistema do Hospital");
        stage.setScene(scene);
        stage.show();
    }

    public static void TrocarTelas(String tela, Object rb) throws IOException{
        new Telas().show(tela, rb);
    }
    
    public static void TrocarTelas(String tela) throws IOException{
        new Telas().show(tela);
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
    private static class Telas{
        protected void show(String tela, Object obj) throws IOException{
            ResourceBundle rb = new ResourceBundle(){
                @Override
                protected Object handleGetObject(String key) {
                    if (key.contains("obj")) {
                        return obj;
                    }else{
                        return null;
                    }
                }

                @Override
                public Enumeration<String> getKeys() {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            };
            
            Parent root = FXMLLoader.load(getClass().getResource(tela), rb);
            
            Scene scene = new Scene(root, 700, 430);

            stage.setScene(scene);
        }
        
        protected void show(String tela) throws IOException{
            Parent root = FXMLLoader.load(getClass().getResource(tela));
            
            Scene scene = new Scene(root, 700, 430);

            stage.setScene(scene);
        }
        
    }
    
}

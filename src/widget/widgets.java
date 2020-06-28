package widget;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

public class widgets {
    
    public static HBox hboxBorder(String width, String height){
        HBox hbox = new HBox();
        hbox.setStyle(
            "-fx-pref-width: "+width+";"
          + "-fx-pref-height: "+height+";"
          + "-fx-border-color: grey;"
          + "-fx-border-radius: 5;"
        );
        hbox.setAlignment(Pos.CENTER);
        return hbox;
    }
    
    public static HBox hbox(String width, String height){
        HBox hbox = new HBox();
        hbox.setStyle(
            "-fx-pref-width: "+width+";"
          + "-fx-pref-height: "+height+";"
        );
        hbox.setAlignment(Pos.CENTER);
        return hbox;
    }
    
    public static TextField txt(String width, String height){
        TextField txt = new TextField();
        txt.setAlignment(Pos.CENTER);
        txt.setStyle(
            "-fx-border-color: white;"    
          + "-fx-pref-width: "+width+";"
          + "-fx-pref-height: "+height+";");
        return txt;
    }
    
    public static TextField txtBorder(String width, String height){
        TextField txt = new TextField();
        txt.setEditable(false);
        txt.setStyle(
            "-fx-pref-width: "+width+";"
          + "-fx-pref-height: "+height+";");
        return txt;
    }
    
    public static Text text(String texto){
        Text txt = new Text(texto);
//        txt.setStyle(
//            "-fx-pref-width: "+width+";"
//          + "-fx-pref-height: "+height+";");
        return txt;
    }
    
    public static Button button(String width, String height, String texto){
        Button button = new Button(texto);
        button.setStyle(
            "-fx-background-color: #0088AA;"
          + "-fx-border-radius: 10;"
          + "-fx-text-fill: white;"
          + "-fx-font-size: 15;"
          + "-fx-font-weight: bold;"
          + "-fx-pref-width: "+width+";"
          + "-fx-pref-height: "+height+";"
        );
        return button;
    }
    
    public static void Notification(String title, String text){
        Notifications not = Notifications.create()
                .title(title)
                .text(text)
                .graphic(null)
                .hideAfter(Duration.seconds(3))
                .position(Pos.BOTTOM_RIGHT);
        not.showInformation();

    }
}

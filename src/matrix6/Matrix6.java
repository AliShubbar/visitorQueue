
package matrix6;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class Matrix6 extends Application {
    
    
    @Override
    public  void start(Stage primaryStage) throws IOException {
           
        
    try {
   Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
   Scene scene = new Scene(root,1200,700);
   scene.getStylesheets().add(getClass().getResource("Application.css").toExternalForm());
   primaryStage.setScene(scene);
   primaryStage.setTitle("Login page");
   primaryStage.show();
  } catch(Exception e) {
   e.printStackTrace();
  }
    }

   public static void infoForAddNewVisitor(String message){
       
       Alert alert = new Alert(AlertType.INFORMATION);
       alert.setTitle("info for adding new");
       alert.setHeaderText(null);
       alert.setContentText(message);
       alert.showAndWait();
       
   }
    public static void main(String[] args) {
        launch(args);
    }
    
}

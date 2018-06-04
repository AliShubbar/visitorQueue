package matrix6;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class LoginController implements Initializable {
    
    
    public LoginMoudel loginModel = new LoginMoudel();
    
     @FXML
   private Label isConnected;
     @FXML
   private TextField txtName;
     @FXML
   private TextField TxtPass;
     @FXML
   private AnchorPane aliAnchor;
     

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        if (loginModel.isDbConnected()){
             isConnected.setText("Connected");
            
  } else {

   isConnected.setText("Not Connected");
    
  }
 }

    
    @FXML
        void handAboutAction(ActionEvent event ){
        try {
            
            FXMLLoader fxmlloder  = new FXMLLoader(getClass().getResource("about.fxml"));
            Parent root1 =(Parent ) fxmlloder.load();
            Stage stage = new Stage();
            stage.setTitle("About ME");
            stage.setScene(new Scene(root1));
            stage.show();
            
            stage.setResizable(false);

   
            
            
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }
        
    @FXML
    public void loudLogine(ActionEvent event) throws IOException{
        
        try {
            if (loginModel.isLogin(txtName.getText(), TxtPass.getText())){
                isConnected.setText("الاسم والرقم السري صحيح");
                
            AnchorPane pane = FXMLLoader.load(getClass().getResource("visitor.fxml"));
            aliAnchor.getChildren().setAll(pane);
     
            }else{
                isConnected.setText("رجاءا تاكد من الاسم والرقم السري");
                
            }
            
            txtName.clear();
            TxtPass.clear();
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
            

            
        }
        
        
    }

        


        
    

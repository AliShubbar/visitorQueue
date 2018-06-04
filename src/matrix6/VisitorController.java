package matrix6;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class VisitorController implements Initializable {
    
   
    
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtStat;
    @FXML
    private TableView<visitorData>tablePres;
    @FXML
    private TableColumn<visitorData , String>idcolum;
    @FXML
    private TableColumn<visitorData , String>nameculom;
    @FXML
    private TableColumn<visitorData , String>statculom;
    @FXML
    private TextField search;
    
    @FXML
   private AnchorPane aliAnchorPP;
    
     ObservableList<visitorData> dataV = FXCollections.observableArrayList();
     Connection con =  sqliteConnection.Connector();
     PreparedStatement preper =null;
     ResultSet rs =null;
    //private sqliteConnection sqConn;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadDataVisitor();
    }
    
    public void clear(){
            txtName.clear();
            txtStat.clear();
        
    }
    
        public void loadDataVisitor(){
        
        try {
            
             rs = con.createStatement().executeQuery("select * from visitors");
             
            txtName.clear();
            txtStat.clear();
            dataV.clear();
            
            while(rs.next()){
                
                dataV.add(new visitorData(rs.getString("id"),rs.getString("name"),rs.getString("status")));
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(VisitorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        idcolum.setCellValueFactory(new PropertyValueFactory<visitorData, String>("id"));
        nameculom.setCellValueFactory(new PropertyValueFactory<visitorData, String>("name"));
        statculom.setCellValueFactory(new PropertyValueFactory<visitorData, String>("statas"));

        tablePres.setItems(dataV);
        
        
    }
        
    
    @FXML
    public void addNewUser() throws SQLException{
        
            String name = txtName.getText();
            String stat = txtStat.getText();
            
            String query = "INSERT INTO visitors(name , status) VALUES(?,?)";
            
            preper = null;
            
            try{
                
                preper = con.prepareStatement(query);
                
                preper.setString(1, name);
                preper.setString(2, stat);
                
                
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            finally {
                
                preper.execute();
                preper.close();
            }
                
            
            loadDataVisitor(); 
            
            Matrix6.infoForAddNewVisitor("تمت اضافة    "+name +"    بنجاح");
                
                
            }
    
    static String tempVisitorName;
    @FXML
    public void showOnClick(){
        
        try{
            visitorData visitor = (visitorData)tablePres.getSelectionModel().getSelectedItem();
            String query = "select * from visitors";
            preper = con.prepareStatement(query);
            
            tempVisitorName = visitor.getName();
            txtName.setText(visitor.getName());
            txtStat.setText(visitor.getStatas());
             preper.close();
             rs.close();
        }catch(SQLException ex){
            System.out.println(ex); 
                    
    
        }
    }
    
    
public void deleteVisitor(){
    
    String name = null;
    try{
            visitorData visitor = (visitorData)tablePres.getSelectionModel().getSelectedItem();
            String query = "delete from visitors where name=?";
            preper = con.prepareStatement(query);
            preper.setString(1, visitor.getName());
            name = visitor.getName();
            preper.executeUpdate();
            
             preper.close();
             rs.close();
        }catch(SQLException ex){
            System.out.println(ex); 
                    
    
        }
            loadDataVisitor(); 
            Matrix6.infoForAddNewVisitor("تم حذف الزائر :     "+name +"    بنجاح");
                
    
    
}

@FXML
public void UpdateVisitorList(){
     String query = "update visitors set name=? , status=? where name = '"+tempVisitorName+"'";

        try {
            preper = con.prepareStatement(query);
            preper.setString(1, txtName.getText());
            preper.setString(2, txtStat.getText());
            
            preper.execute();
            preper.close();
             
            Matrix6.infoForAddNewVisitor("تم تحديث الاسم الى   :     "+txtName.getText() +"    بنجاح");
            loadDataVisitor();
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
       
            


        
        
    }

@FXML
public void about() throws IOException{
    
            FXMLLoader fxmlloder  = new FXMLLoader(getClass().getResource("about.fxml"));
            Parent root1 =(Parent ) fxmlloder.load();
            Stage stage = new Stage();
            stage.setTitle("About ME");
            stage.setScene(new Scene(root1));
            stage.show();
            
            
            stage.setResizable(false);
}

@FXML

void singout() throws IOException{
    
    AnchorPane pane = FXMLLoader.load(getClass().getResource("Login.fxml"));
    aliAnchorPP.getChildren().setAll(pane);
    
   
}

@FXML
public void deleteAllVisitor(){
    
    String name = null;
    try{
            visitorData visitor = (visitorData)tablePres.getSelectionModel().getSelectedItem();
            String query = "delete  from visitors";
            preper = con.prepareStatement(query);
           // preper.setString(1, visitor.getName());
            //name = visitor.getName();
            preper.executeUpdate();
            
             preper.close();
             rs.close();
        }catch(SQLException ex){
            System.out.println(ex); 
                    
    
        }
            loadDataVisitor(); 
            Matrix6.infoForAddNewVisitor(" تم حذف جميع الاسماء الموجودة بنجاح ");
                
    
    
}

@FXML
public void searchRecord(KeyEvent ke){
    
    FilteredList<visitorData> filterData = new FilteredList<>(dataV,p->true);
    search.textProperty().addListener((observable,oldvalue,newvalue) -> {
        filterData.setPredicate(pers ->{
            if(newvalue == null || newvalue.isEmpty()){
                return true;
            }
            
            String typeText = newvalue.toLowerCase();
            
            if(pers.getName().toLowerCase().indexOf(typeText) !=-1 ){
              
                return true;
                
            }
            if(pers.getId().toLowerCase().indexOf(typeText) !=-1 ){
              
                return true;
                
            }
            if(pers.getStatas().toLowerCase().indexOf(typeText) !=-1 ){
              
                return true;
                
            }

            
            return false;
        });
        
        SortedList<visitorData> sortedList = new SortedList<>(filterData);
        sortedList.comparatorProperty().bind(tablePres.comparatorProperty());
        tablePres.setItems(sortedList);
    });
    
}


}


    


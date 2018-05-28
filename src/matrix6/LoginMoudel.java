package matrix6;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginMoudel {
    Connection conn;
    public LoginMoudel(){
        this.conn =  sqliteConnection.Connector();
        
        if (conn == null) {
            System.out.println("connection is not succcesfully");
            System.exit(1);
        }
    }
    
    public boolean isDbConnected(){
       
        
        try {
           return !conn.isClosed();
        } catch (SQLException ex) {
            Logger.getLogger(LoginMoudel.class.getName()).log(Level.SEVERE, null, ex);
            return  false;
        }
       
    }
    
    public boolean isLogin(String user , String password) throws SQLException{
                                

            PreparedStatement prs = null;
            ResultSet resultSet = null;
            String query = "SELECT * FROM employ WHERE user=? and pass=?";
            
            try {
                
            prs = conn.prepareStatement(query);
            
            
            
            prs.setString(1, user);       
            prs.setString(2, password);
            
            resultSet = prs.executeQuery();
            
            if (resultSet.next()){
                return true;
            }else{
                return false;
            }

        } catch (SQLException ex) {
            return false;
            
        } finally{
                
            // preparedStatement.close();
             resultSet.close();
             
                
            }
        
    }
}
package matrix6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class sqliteConnection {
    
     public static Connection Connector() {
 try {
  Class.forName("org.sqlite.JDBC");
  Connection conn =DriverManager.getConnection("jdbc:sqlite:queueVisitor.sqlite");
  return conn;
 } catch (ClassNotFoundException | SQLException e) {
  System.out.println(e);
  return null;
  // TODO: handle exception
 }
}
    
    
}

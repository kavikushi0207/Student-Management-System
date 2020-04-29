import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class myConnection {
  public static Connection getConnection()
  {
      Connection con=null;
      try{
          Class.forName("com.mysql.jdbc.Driver");
          con =DriverManager.getConnection("jdbc:mysql://localhost/student_managemnt_system","root","");
      }catch(ClassNotFoundException | SQLException ex){
          System.out.println(ex.getMessage());
      
      } 
      return con;
      
  }
}

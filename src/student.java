
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class student {
    public void insertUpdateDeleteStudent(char operation, Integer id, String fname,String lname,String sex, String dob,String phone,String address)
    {
        Connection con =myConnection.getConnection();
        PreparedStatement ps;
        //i for insert
        if(operation =='i')
        {
            try {
                ps=con.prepareStatement("INSERT INTO student( first_name, last_name, sex, DoB, phone, address) VALUES (?,?,?,?,?,?)");
                ps.setString(1, fname);
                ps.setString(2, lname);
                ps.setString(3, sex);
                ps.setString(4, dob);
                ps.setString(5, phone);
                ps.setString(6, address);
                if(ps.executeUpdate()>0)
                {
                    JOptionPane.showMessageDialog(null,"new student is added");
                }
                
                
                
            } catch (SQLException ex) {
                Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

   
}

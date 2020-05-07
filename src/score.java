
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class score {
    
     public void insertUpdateDeleteStudent(char operation, Integer Sid, Integer Cid,double score,String description)
    {
        Connection con =myConnection.getConnection();
        PreparedStatement ps;
        //i for insert
        if(operation =='i')
        {
            try {
                ps=con.prepareStatement("INSERT INTO `score`(`student_id`, `course_id`, `student_score`, `description`) VALUES (?,?,?,?)");
                ps.setInt(1, Sid);
                 ps.setInt(2, Cid);
                 ps.setDouble(3, score);
                ps.setString(4, description);
               
                
                if(ps.executeUpdate()>0)
                {
                    JOptionPane.showMessageDialog(null,"Score is added");
                }
                
                
                
            } catch (SQLException ex) {
                Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
//        //u for update
//        if(operation =='u')
//        {
//            try {
//                ps=con.prepareStatement("UPDATE `course` SET `Lable`=?,`hours number`=? WHERE `ID`=?");
//                ps.setString(1, courseTitle);
//                ps.setInt(2, hours);
//                
//                ps.setInt(3,id);
//                if(ps.executeUpdate()>0)
//                {
//                    JOptionPane.showMessageDialog(null,"course info is updated.");
//                }
//           
//                
//                
//                
//            } catch (SQLException ex) {
//                Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        
//        //d for remove
//        if(operation =='d')
//        {
//            try {
//                ps=con.prepareStatement("DELETE FROM `course` WHERE `id`=?");
//                
//                ps.setInt(1,id);
//                if(ps.executeUpdate()>0)
//                {
//                    JOptionPane.showMessageDialog(null,"A data row is deleted successfully!");
//                }
//                
//                
//                
//            } catch (SQLException ex) {
//                Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
//            }
//      }
    }
    
}

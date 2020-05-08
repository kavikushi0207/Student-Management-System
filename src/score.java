
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class score {
    
     public void insertUpdateDeleteStudent(char operation, Integer Sid, Integer Cid,Double score,String description)
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
        //u for update
        if(operation =='u')
        {
            try {
                ps=con.prepareStatement("UPDATE `score` SET `student_score`=?,`description`=? WHERE `student_id`=? AND `course_id`=?");
                ps.setDouble(1, score);
                ps.setString(2, description);
                ps.setInt(3, Sid);
                ps.setInt(4, Cid);
    
                if(ps.executeUpdate()>0)
                {
                    JOptionPane.showMessageDialog(null,"score value is updated.");
                }
           
                
                
                
            } catch (SQLException ex) {
                Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
//        
        //d for remove
        if(operation =='d')
        {
            try {
                ps=con.prepareStatement("DELETE FROM `score` WHERE `student_id`=? and`course_id`=?");
                ps.setInt(1, Sid);
                ps.setInt(2, Cid);
                if(ps.executeUpdate()>0)
                {
                    JOptionPane.showMessageDialog(null,"score is deleted successfully!");
                }
                
                
                
            } catch (SQLException ex) {
                Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
            }
      }
    }
     public static void fillScoreJtable(JTable table) {
        Connection con = myConnection.getConnection();
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("SELECT * FROM `score` ");
           
            
            ResultSet rs =ps.executeQuery();
            DefaultTableModel model =(DefaultTableModel)table.getModel();
            Object[] row;
            
            while(rs.next())
            {
                row= new Object[4];
                row[0]=rs.getInt(1);
                row[1]=rs.getInt(2);
                row[2]=rs.getDouble(3);
                row[3]=rs.getString(4);
                model.addRow(row); 
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    
    
}
